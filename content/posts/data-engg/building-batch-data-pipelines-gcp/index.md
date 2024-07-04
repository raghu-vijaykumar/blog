# Building Batch Data Pipelines on Google Cloud

# Introduction to Batch Data Pipelines

**Concept:** Process a bounded amount of data and then exit; e.g., reconciling transactions daily.

## EL vs. ELT vs. ETL in Data Balancing Pipeline

- **EL (Extract Load):** Extraction & loading without transformations, potentially suitable for simple pipelines, such as logs from Cloud Storage to BigQuery.
- **ELT (Extract Load Transform):** Loads raw data and applies transformations on the fly during querying or analysis; advantageous when using a powerful engine like BigQuery.
- **ETL (Extract Transform Load):** Extraction, transformation prior to loading into the warehouse. Ideal for complex transformations and stringent data quality requirements.

### Choosing Between EL, ELT, & ETL: Key Considerations

1. **Complexity of Data Transformation Required:**
   - _EL_ is less preferred due to lack of transformation stage.
   - _ELT_ and _ETL_ provide transformation capabilities with the latter offering more control.
2. **Data Quality Concerns:**
   - Strong data quality controls are best served by an ETL approach, allowing pre-loading transformations that ensure consistency across datasets.

# Data Quality Considerations: Transformations & Solutions

- **Key Concepts**: Validity, Accuracy, Completeness, Consistency, Uniformity
  - These are independent qualities that contribute to overall **data quality**.
- **Challenges in Data Analysis**:
  - Impact of poor data quality on business outcuits and decisions.
- **Data Quality Problems & Solutions Using BigQuery**:

1. **Validity Issues**
   - E.g., Movie ticket sales with incorrect pricing (should be $10, but is $7).  
     \- _Solution_: Validate against business rules within BigQuery.
2. **Accuracy Problems**
   - Data does not align with objective truth; requires cross-verification.
3. **Completeness Issues**
   - E.g., Incomplete data processing leads to skewed analysis.  
     \- _Solution_: Ensure full dataset capture in BigQuery, apply DISTINCT as needed.
4. **Consistency Challenges**
   - Discrepancies between similar operations; lack of reliable insights due to conflicting results.
5. **Uniformity Concerns**
   - Data values within the same column signify different things across rows, complicating analysis.

# Operations in BigQuery for Addressing Data Quality Issues

- **Quality Challenges & Solutions**:

  - **Invalid Quantities**: Use `WHERE clause` to remove quantities less than 0.\
     `sql\nSELECT * FROM dataset.table WHERE quantity >= 0;`

  - **Low Group Totals (POST-GROUP BY)**: Employ the `HAVING clause` with a minimum record count per group.\
    `sql\nSELECT column1, COUNT(*) as total\nFROM dataset.table GROUP BY column1 HAVING total >= 10;`

  - **Nulls & Blanks Handling**: Use `COUNTIF` for non-null values and the `IF` statement to exclude specific value types in computations.\
     `sql\nSELECT COUNTIF(column1) as non_null, IF(column2 = 'specific_value', NULL, column2) AS cleaned_data FROM dataset.table;`

  - **Duplication & Consistency**:\
    Compare `COUNT` and `COUNT(DISTINCT)` values to identify duplicates.\
     `sql\nSELECT COUNT(*) as total, COUNT(DISTINCT column1) as unique_count FROM dataset.table;`

  - **Character Extra Handling (e.g., Timestamps or Strings)**: Utilize string functions for data cleaning before further processing.\
     `sql\nSELECT REGEXP_REPLACE(column1, '[extra]', '') AS cleaned_timestamp FROM dataset.table;`

  - **Accuracy Testing & Value Verification**: Use SQL's `IN` operator to confirm values against a canonical list.\
     `sql\nSELECT * FROM dataset.table WHERE item IN ('value1', 'value2');`

  - **Completene Missing Values Handling**:\
    Employ functions like `NULLIF`, `COUNTIF`, and `COALESCE` to handle nulls, or perform data backfilling.\
     `sql\nSELECT COALESCE(column1, 'default_value') AS filled_data FROM dataset.table;`

  - **Data Integrity Verification**:\
    Check file integrity using checksum values during the loading process and maintain uniform units with `CAST` & `FORMAT`.\
     `sql\nSELECT CAST(column1 AS DECIMAL) as standardized_value, FORMAT(column2, 'unit') as labeled_data FROM dataset.table;`

# ETL vs ELT: Selecting Appropriate Tools for Data Processing

Understanding when to choose **ETL (Extract, Transform, Load)** over **ELT (Extract, Load, Transform)** is critical in data processing and analysis workflows. This note highlights key considerational factors determiding the appropriate tool selection based on specific requirements or constraints:

## Situations where ETL may be preferable to Evolutionary Learning Techniques (ELT):

1. **Complex Transformations**: When dealing with intricate data transformations that cannot be efficiently expressed in SQL, opting for an ETL approach can simplify the process.
2. **Data Quality Control & Enrichment**: If raw data requires extensive quality control and enrichment before loading into a destination like Google Cloud's BigQuery, employing ETL tools such as Dataflow is advisable.
3. **Continuous Loading Requirements**: For use cases necessitating continuous or streaming data ingestion (e.g., Pub/Sub), ETL pipelines facilitated by Dataflow are suitable options. This approach also supports unit testing and integration with CI/CD systems.
4. **Deployment of Complex Pipelines**: When complex ETL workflows need to be constructed, utilizing Google Cloud's Dataproc or Data Fusion services can provide robust solutions while enabling easy scalability and deployment on Dataproc clusters.
5. **Programmatic Logic Utilization**: Instances where programmable logic is essential for processing data streams (e.g., customer actions over a time window) should prefer ETL tools, as SQL may not suffice to accommodate such complexities efficiently.

## Comparing Key Tools in Google Cloud's Data Processing Suite:

1. **Dataflow**: A fully managed serverless data processing service based on Apache Beam supporting batch and streaming pipelines, offering quickstart templates for rapid deployment of common ETL tasks.
2. **Dataproc**: Based on Apache Hadoop, Dataproc caters to more complex ETL workflows but requires substantial expertise in leveraging its full capabilities. It is suitable for handling large datasets and performing extensive data processing.
3. **Data Fusion**: Provides a user-friendly graphical interface for building and deploying scalable ETL pipelines, making it accessible to users with varying levels of technical proficiency.

### Tabulating Comparison:

| Feature         | Dataflow                       | Dataproc                          | Data Fusion                             |
| --------------- | ------------------------------ | --------------------------------- | --------------------------------------- |
| Core Technology | Apache Beam, Batch & Streaming | Hadoop                            | Graphical Interface for Pipelines       |
| Managed Service | Fully Managed Serverless       | Managed Cluster (based on Hadoop) | -                                       |
| Scalability     | Automatic Resource Management  | High scalability with clusters    | Easy to scale through visual interface  |
| Deployment      | Quickstart Templates           | Requires significant expertise    | Simple and intuitive deployment process |

In conclusion, the choice between ETL and ELT methodologies depends on various factors such as transformation complexity, data quality requirements, continuous loading needs, and preferred tools within Google Cloud's suite. Considering these aspects enables efficient selection for optimal performance in data processing pipelines.

# ETL Tools and Strategies

**ETL (Extract, Transform, Load) tools are cruplular options such as Dataflow, BigQuery, Dataproc, and Cloud Data Fusion to solve data quality issues:**

- **Dataflow & BigQuery:** Recommended unless specific needs arise. _Advantages_ include integration with Google Cloud services like BigQuery (now supports 1M rows/second sync) and BI Engine (latency as low as 10^2 ms). _Considerations_ before choosing Dataflow & BigQuery are:
  - **Low latency and high throughput** needs.
    - If higher than what these tools offer, other options may be better suited.
- **Cloud Bigtable:** Might be a more suitable sync for data processing pipelines with stricter latency & throughput considerations. _Recommended if_ the user requires lower latencies or higher throughputs than Dataflow and BigQuery can provide.
  - Check documentation to confirm current values as they may change over time.
- **Dataproc:** A cost-effective, managed service for Hadoop workloads with features like autoscaling & out-of-the-box integration with Google Cloud products (e.g., BigQuery). _Recommended if_ the user has significant investments in Hadoop/Spark and requires batch processing, querying, streaming, or machine learning capabilities at a reduced cost compared to self-managed solutions on bare metal infrastructure.
- **Cloud Data Fusion:** A fully managed, cloud-native enterprise data integration service that simplifies the building & managing of data pipelines for non-programming users via visual interfaces (drag-and-drop). _Recommended if_ users need a tool with which they can build data pipelines without relying on programming skills or extensive IT resources.
  - Also offers a flexible API to automate execution, catering well to the needs of technical staff who prefer scripting and automation.

# Important Considerations

1. **Data Lineage:** Maintain data lineage for understanding what processes data has gone through, its current condition & suitability for use cases. _Importance_ lies in troubleshooting odd results by identifying causes that can be corrected and meeting trust and regulatory compliance requirements.
2. **Metadata Management with Data Catalog:** Use Google Cloud's fully-managed Data Catalog as a metadata management service to provide unified data discovery across multiple projects & systems, while supporting enriched business metadata tags (e.n., enum, bool, date/time). _Benefits_ include easy search capabilities using the same technology behind Gmail and Drive, integration with Cloud Data Loss Prevention API for sensitive data classification, and facilitating collaborative annotation of business metadata.
3. **Billing & Access Control:** Leverage labels to manage complex resources effectively by filtering them based on their assigned labels, enabling granular billing analysis in conjunction with Google's Cloud Billing system. Data Catalog offers enterprise-grade access control and integrates seamlessly across multiple projects and systems within the Google Cloud environment.
4. **Unified User Experience:** Utilize tools like Data Catalog to provide a unified user experience when discovering datasets, eliminating the need to search databases for table names or work with inaccessible data due to varying access levels. This approach streamlines data discovery and allows users to find relevant information quickly.

# Module: Executing Spark on Dataproc

**Introduction to Dataproc and Apache Spark**

- Google Cloud's managed **Hadoop service** called Dataproc
- Covers the Hadoop ecosamoeba, running Hadoop on Dataproc, benefits of Cloud Storage vs. HDFS, optimizing Dataproc with a hands-on lab using Apache Spark on Dataproc

### Key Topics Covered:

1. **Hadoop Ecosystem**
   - Components and their roles within the ecosystem
2. Running Hadoop on Dataproc
3. Benefits of Cloud Storage over HDFS
4. Optimizing Dataproc Performance
5. Hands-on Lab: Apache Spark with Dataproc

## Key Points to Note:

1. **Dataproc** is a managed service for running Apache Spark and other big data processing tools on Google Cloud Platform (GCP).
2. It enables easy setup, management, and scaling of big data workloads within the GCP environment.
3. The hands-on lab will provide practical experience in configuring and executing Apache Spark jobs using Dataproc.
4. Utilizing **Cloud Storage** instead of HDFS can offer additional benefits such as improved performance and scalability.
5. Optimization techniques for improving Dataproc's overall efficiency include resource allocation, data placement strategies, and configuring network settings.

# The Hadoop Ecosystem: An Overview

**Introduction to the Hadoop Ecosystem and its Core Components**

- **Apache Hadoop** (200e) established as an open-source software framework for distributed data processing on clusters of computers using simple programming models.

## Key Points & Technologies:

1. **HDFS (Hadoop Distributed File System):** Main file system that distributes work to nodes within the Hadoop cluster, facilitating large dataset storage and management across multiple machines.
2. **MapReduce:** The primary processing model for handling big data in a distributed manner, with jobs being split into smaller sub-tasks (map) and then aggregated (reduce).
3. **Apache Spark:** A high-performance analytics engine specializing in both batch and streaming data processes; it provides speed improvements of up to 100x compared to MapReduce due to its use of in-memory processing, RDDs (Resilient Distributed Datasets), and DataFrames.
4. **Apache Hive:** Provides a SQL-like interface for querying data stored in the Hadoop ecosystem.
5. **Apache Pig:** A high-level platform designed to analyze large datasets that allow users to write complex applications without knowing Java or MapReduce.
6. **Presto, Spark, and other OSS Hadoop Applications:** Enable a rich set of data processing capabilities across on-premises and cloud environments for organizations requiring advanced analytics solutions.
7. **Managed Cloud Services (Dataproc):** Google's managed Hadoop environment offering simplified hardware configuration management, resource scaling options, streamlined versioning, and flexible job configurations to optimize workload performance.
8. **Comparison of On-Premises vs. Cloud Deployment:** The transition from on-premises Hadoop clusters (limited scalability and capacity) to managed cloud environments like Google's Dataproc provides numerous benefits such as reduced hardware management, simplified version control, flexible job configurations, and cost savings in time, money, and effort.
9. **Apache Spark Features:** Declarative programming model enabling the mix of different applications with resource usage adjustments based on availability; full SQL implementation, common DataFrame model across multiple languages (Scala, Java, Python, R), and a distributed machine learning library called Spark MLlib.
10. **Importance of Ongoing Learning:** The Hadoop ecosystem continues to evolve with new technologies, libraries, and enhancements; staying up-to-date on the latest developments is essential for maximizing the benefits of these advanced data processing systems.

To create a Dataproc cluster using the Cloud SDK and specify an initialization script (e.g., a shell script) to run at startup, you can use the `gcloud` command-line tool as follows:

1. Install and initialize the Google Cloud SDK by following the instructions in this [link](https://cloud.google.com/docs/authentication/install-debian-apt). Make sure your account is added to the project that will host the cluster.

2. Create a new shell script (e.g., `init_script.sh`) and include any necessary commands or configurations you want to run during startup.

3. Upload the initialization script to a bucket in Google Cloud Storage:

   ```bash
   gsutil cp init_script.sh gs://<BUCKET-NAME>/init_scripts/init_script.sh
   ```

4. Create the Dataproc cluster using the `gcloud dataproc clusters create` command and specify the initialization script with `--properties`. Here's an example:

   ```bash
   gcloud dataproc clusters create my-cluster \
       --region <REGION> \
       --zone <ZONE> \
       --master-instance-count 1 \
       --worker-instance-count 2 \
       --properties='clusterProperties={"initializationActions": ["gs://<BUCKET-NAME>/init_scripts/init_script.sh"]}'
   ```

5. Wait for the cluster to be created and initialized by checking the status with:

   ```bashamo
   gcloud dataproc clusters describe my-cluster --region <REGION> --zone <ZONE> | grep "state" | cut -d'=' -f2
   ```

6. Once your initialization script has been executed, you can start submitting Hadoop jobs or Spark applications to the cluster using `gcloud dataproc jobs submit` command and specifying other required parameters like `--cluster`, `--jars`, etc. Here's an example:

   ```bash
   gcloud dataproc jobs submit hadoop \
       --cluster my-cluster \
       --jar path/to/your_hadoop_job.jar \
       --stagingdir /tmp
   ```

7. To monitor the job, you can use Cloud Monitoring or create custom dashboards and alerts using Google's Stackdriver service: [https://cloud.google.com/monitoring](https://cloud.google.com/monitoring)

## Cloud Storage vs HDFS

**Cloud Storage instead of Hadoop Distributed File System (HDFS):**

- **Networking:**
  - Network speeds are now fast enough for storage and compute independence, facilitamoe by petabit networking.

**Transition to Cloud:**

- Lifting & Shifting workloads is possible with Dataproc without requiring code changes.

### Advantages of Cloud Storage over HDFS

1. **Storage Management Separation**
   - Elastic and scalable, unlike HDFS where persistent disks must be sized for current and potential future data needs.
2. **Networking Infrastructure**
   - Jupyter networking fabric provides > 1 petabit/s bandwidth within Google data centers, enabling fast communication between servers (bisectional bandwidth).
3. **Data Processing Workloads Management**
   - Dataproc allows scaling VMs as needed and using Cloud Storage for persistent storage with ultra-fast network speeds.
4. **Storage Service Characteristics**
   - High throughput optimized for bulk parallel operations, though latency may be higher compared to HDFS.
5. **Avoidance of Bottlenecks & Single Points of Failure**
   - The distributed service architecture in Cloud Storage reduces risks associated with single points of failure and bottlenecks.
6. **Cost-Efficiency**
   - Pay for the used storage only, without needing to overprovision like with HDFS persistent disks.

### Disadvantages of using Cloud Storage instead of HDFS:

1. **Object Store Limitations**
   - Directory renaming differs from HDFS and may require object store-oriented output committers for better management.
2. **Inability to Append Data**
   - Unlike HDFS, objects in Cloud Storage cannot be appended, which can limit some functionalities during data processing jobs.

## Optimizing Dataproc: Key Points

- **Data Locality**: Ensure that the data and Dataproc cluster are in close physical proximity within the region to optimize performance. Utilize the automatic zone selection feature but verify the Cloud Storage bucket is in the same regional location as your Dataproc region.

- **Network Configuration**: Avoid network bottlenecks by ensuring proper routing of Cloud Storage traffic through adequate VPN gateways and not congesting bandwidth.

- **Input Files & Hadoop Partitions**: Limit the number of input files to approximately 10,000; combine or union data if necessary. If working with more than around 50,000 Hadoop partitions, adjust `fs.gs.block.e`size` accordingly for improved performance.

- **Persistent Disk Size**: Choose an adequately sized persistent disk to avoid limiting throughput and ensure it scales linearly with the volume size.

- **Virtual Machine Allocation**: Accurately determine the number of virtual machines needed by understanding workloads, running prototypes, and benchmarking real data and jobs. Adjust cluster sizes as necessary in a cloud environment.

### Tabulated Comparison

| Factor                          | Recommendation                                                                                                               |
| ------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| Data Locality                   | Ensure proximity between Dataproc region and Cloud Storage bucket within the same regional location.                         |
| Network Configuration           | Avoid network bottlenecks by routing traffic properly through VPN gateways.                                                  |
| Input Files & Hadoop Partitions | Limit input files to 10,000; adjust `fs.gs.block.size` if working with more than ~50,000 partitions.                         |
| Persistent Disk Size            | Choose an adequately sized persistent disk for scalability and throughput optimization.                                      |
| Virtual Machine Allocation      | Determine VMs based on workload understanding, prototypes, benchmarking; resize clusters as needed in the cloud environment. |

## Optimizing Dataproc Storage Options: Local HDFS vs. Cloud Storage

### When to use local HDFS for Data Processing:

- **Metadata Operations**: If your jobs require extensive metadata operations such as handling numerous partitions and directories with small file sizes, renaming directories often, or frequent modifications of HDFS data.

- **Append Operation on HDFS Files**: This is suitable when there's heavy I/O involved especially for partitioned rights.

- **Latency Requirements**: Local HDF지름 may be preferred if ultra-low latency is required, as it operates within your local network.

### When to use Cloud Storage for Data Processing:

- **Cost Efficiency**: Storing data in Cloud Storage is more cost-effective than maintaining a persistent HDFS cluster.

- **Flexibility with Google Cloud Products**: It allows using your data across multiple Google Cloud services, enhancing efficiency and economics for specific use cases.

- **Ephemeral Clusters Model**: Using ephemeral clusters that are spun up only when needed reduces resource wastage as you pay for what you actually use.

### Recommended Approach with Ephemeral Dataproc Clusters and Cloud Storage Data Persistence:

1. Store your data in **Cloud Storage** to support multiple temporary processing clusters. This model is often referred to as the ephemeral model, wherein resources are active only when needed.
2. When a job needs to be run, create an appropriately configured cluster using Dataproc.
3. Run your job and send the output to **Cloud Storage** or another persistent location.
4. Delete the cluster after the job completion. This ensnares resources used for actual processing while preventing wastage on idle clusters.
5. Use the job outputs as needed and view logs in Cloud Logging or Cloud Storage.
6. If necessary, create a persistent cluster but aim to keep it minimal by scoping workload and scaling nodes dynamically to meet demand.
7. Decouple storage from compute; Decompose further with job-scoped clusters and isolate dev, staging, and production environments by running them on separate clusters.
8. Apply appropriate ACLs to service accounts to protect data.

# Dataproc Templates and Autoscaling

**Dataproc Workflow Template:**

- **YAML File**: Processed through Directed Acyclic Graph (DAG)
- **Functionality**:
  - Create new cluster or select existing one
  - Submit jobs
  - Hold jobs until dependencies complete
  - Delete cluster after job completion
- **Accessibility**: gcloud command, REST API; not through cloud console

## Workflow Template Processing Steps

1. Collect installation requirements via startup scripts and `pip install` commands (e.g., Matplotlib)
2. Create new cluster with desired parameters (architecture, machine types, image versions) using `gcloud` command
3. Add Spark job written in Python to the created cluster from Cloud Storage bucket
4. Submit workflow template as a new Dataproc workflow template

# Autoscaling Features and Optimizations

**Key features include:**

- **I fire and forget jobs**: No manual intervention required for over/under capacity clusters
- **Standard & Preemptible Workers**: Resource, quota, cost savings; fine-grained control based on YARN memory difference (scale up or down)
- **Improvements**:
  - More granular controls and policy updates at any time
  - Reduced minimum scaling interval from 10 minutes to pressing_up(2minutes)
  - Shared autoscaling policies across multiple clusters
  - Enhanced cluster dashboard, decision history in Cloud Logging, and job stability without losing progress
- **Best Practices**: Autoscaling suited for clusters processing many jobs or large jobs; not ideal for idle/idle clusters

## Workflow Template Configuration

- Set initial worker nodes based on the minimum required (`nodes_minimum`) to ensure quick cluster capacity increase compared to autoscaling's multiple periods needed.
- **Maximum Number of Nodes**: Caps the number of worker nodes, preventing excessive scaling during heavy loads.
  - `scale_up_factor`: Determines additional nodes launched (commonly set as one node but can scale faster if anticipated)
  - `cooldown_period`: Reduces chances of simultaneous cluster start-stop cycles; allows settling before next autoscaling evaluation.
  - **Graceful Decomission**: Provides running jobs time to complete before service termination (`graceful_decommission_timeout`).
  - `scale_down_factor`: Reduces capacity leisurely, with an additional cooldown period for return to minimum workers.

## Optimizing Dataproc Monitoring in Google Cloud

### Tools Used:

- **Cloud Logging** and **Cloud Monitoring**
  - _Purpose_: To view, customize logs, monitor jobs, and resources.

### Error Detection in Spark Jobs:

1. Review driver output and executor logs for errors.
2. Retrieve driver program output via cloud console or `gcloud` command.
3. Stored logs are located within the Dataproc cluster's Cloud Storage bucket.

### Accessing Logs:

- **Driver Output**: Not available when connecting to primary node using SSH; access through cloud console, gcloud commands, or Cloud Storage.
- **Executor Logs**: Viewable in Spark app web UI and history server executor tab post-job completion.
  - _Note_: Requires browsing each container's logs individually.

### Application Code Logging:

1. Use `stdout` or `stderr` redirection for logging within code.
2. YARN collects all stdout/stderr logs by default, accessible via Cloud Logging.
3. **Benefits**: Provides a concise view of all logs without browsing container logs to find errors.
   - _Command_: `gcloud dataproc jobs submit hadoop --driver-log-levels DEBUG` (example)

### Customizing Log Retrieval and Monitoring:

1. **Labels**: Create custom labels for clusters or Dataproc jobs to filter logs efficiently (`env=exploration`).
2. **Cluster Metrics**: Monitor CPU, disk, network usage, and YARN resources with Cloud Monitoring dashboards.
3. **Compute Engine VM Instance Selection**: Choose the instance for visualizing additional metrics (CPU usage, Disk I/O, networking).
4. **Spark Applications Metrics**: Access Spark query metrics through the application's web UI.

```markdown
| Feature                    | Description                                                                               | Command or Location                                            |
| -------------------------- | ----------------------------------------------------------------------------------------- | -------------------------------------------------------------- |
| Log Retrieval              | Driver output and executor logs via cloud console, gcloud commands, Cloud Storage buckets | -                                                              |
| Log Customization          | Create custom labels for efficient log filtering                                          | `gcloud dataproc jobs submit hadoop --driver-log-levels DEBUG` |
| Cluster Metrics Monitoring | CPU, disk usage, network monitoring with dashboards                                       | Select Compute Engine VM instance in Cloud Monitoring          |
```

## Lab: Running Apache Spark Jobs on Dataproc

### Objectives:

- **Migrate Existing Spark Job Code**: Transition current codebase to execute on Google Cloud's Dataproc platform.
- **Modify Spark Jobs Backend Usage**: Implement Cloud Storage as the back end, replacing HDFS in Spark jobs.
- **Optimize Spark Job Performance**: Enhance job efficiency through specialized cluster configurations tailored to specific tasks.

### Key Steps and Techniques:

1. **Code Migration**: Adapt existing Apache Spark codebase for compatibility with Dataproc environment.
2. **Back End Transition (Cloud Storage vs HDFS)**:
   - _Old Back End_: Hadoop Distributed File System (HDFS).
   - _New Back End_: Google Cloud'aturated and uncomfortable, potentially leading to disengagement or distraction. Therefore, the correct match is 'A'.

## Lab: Running Apache Spark Jobs on Cloud Dataproc

#### Summary Recap:

- **Hadoop Ecosystem**: Demonstrated execution within cloud environments using data processing units (DataProc).
- **Compute & Storage Separation**: Highlighted cost efficiency and performance improvements through distinct compute and storage services.
  - _Old Method_: Integrated HDFS as both compute and storage.
  - _New Approach_: Utilizes **Cloud Storage** for data persistence, isolating it from compute tasks.
- **Cluster Optimization & Smart Features**: Emphasized the importance of scaling clusters to meet dynamic requirements, alongside smart features such as automated downsizing post non-usage intervals.

## Serverless Data Processing: The Dataflow Module

#### Introduction Overview:

- **Serverless Tools**: Introduces the essential serverless tool, _Dataflow_, for data engineering practices on Google Cloud.
- **Batch Pipelines Focus**: Entire module dedicated to constructing and understanding batch _Dataflow_ pipelines.
  - _Parallel Lesson_: Streaming pipeline coverage will follow in subsequent discussions.
- **Code Reusability**: Emphasizes the ability of _Dataflow_ codebase to handle both batch and streaming data processes with minimal modifications.

## Introduction: Dataflow Essentials

#### Serverless Processing: The Core Advantage

- **Dataflow** stands out as Google Cloud's preferred choice due to its serverless architecture, eliminating cluster management responsibcuils.
  - _Scalability_: Offers granular auto-scaling capabilities for fine control and efficiency.
- _Code Flexibility_: Enables the same codebase for both batch processing (with dataflow) and streaming.

#### Selective Implementation Strategy

- **Data Engineering Recommendation**: Mastery of DataFlow/DataProc is crucial, with selection based on project needs.
  - _Use Case Analysis_:
    - For moving existing workloads or without a need for streaming: **DataProc** may be adequate.
    - To build new pipelines and leverage stream processing: **DataFlow** is the recommended approach, highlighting its low latency and ability to process batches and streams with unified code.
- _Programming Paradigm Innovation_: Beam abstracts traditional batch programming concepts (dating back to 1940s) from modern stream processing paradigms of the 1970s, fostering a unique blend beneficial in data engineering.

# Dataflow: Why Engineers Value It Over Other Alternatives

## Key Characteristics & Benefits of Dataflow

- **Efficient Execution**: Provides an optimized execution mechanism for batch processing, using the Apache Beam pipeline.
- **Dynamic Optimization**: Constantly optimizes graph by fusing transforms together and scheduling tasks across available resources.
- **Fault Tolerance & Rebalancing**: Supports dynamic rebalancing of workloads in case of resource failure or changes, ensuring processing continuity.
- **Auto Scaling**: Auto scales compute and storage on a per-job basis; resources are deployed as needed and torn down upon job completion or scaling reduction.
- **Managed Service**: Fully managed and auto-configured service from Google Cloud Platform (GCP).
- **Strong Streaming Semantics**: Handles late arrivals, duplicate records, restarts, monitoring, and logging while maintain.maintaining correct aggregations like sums or counts.
- **Integration with GCP Services**: Acts as a glue service to connect various services on the platform such as BigQuery, BigTable, Pub/Sub, and Cloud SQL.

## Comparison with Other Data Processing Alternatives

| Characteristics | Dataflow                               | Traditional Approaches                    |
| --------------- | -------------------------------------- | ----------------------------------------- |
| Execution       | Efficient & dynamic optimization       | Static execution plans                    |
| Fault Tolerance | Dynamic work rebalancing               | Manual intervention required              |
| Auto Scaling    | On-demand, per job basis               | Requires manual scaling                   |
| Integration     | Seamless integration with GCP services | May require additional connectors or code |

## Summary of Dataflow's Advantages

Data engineers value Google Cloud Platform's (GCP) Dataflow over other alternatives due to its efficiency, dynamic optimization capabilities, fault tolerance mechanisms, auto scaling features, and integration with GCP services. These benefits result in a fully managed and optimized data processing solution that reduces the need for manual intervention and ensures correct aggregations even under complex scenarios such as late arrivals or duplicate records.

# Dataflow Pipelines: Summary

## Overview

Dataflow pipelines enable efficient processing of data by passing an input **P collection** through multiple transformations (or **P transforms**) and generating a final output **P collection**. These pipelines consist of three main components: sources, transformers, and sinks.

## Pipeline Construction in Python

A simple pipeline can be constructed using the pipe operator (`|`) to connect an input `P collection` with multiple `P transforms`. The syntax is shown below:

```python
input_collection | Transform1 | Transform2 | ... | OutputCollection
```

In this example, each transformation receives a **P collection** as the input and produces another **Pn collection** as its output. Branching can also be achieved by sending a single **P collection** through two different `P transforms`.

## Java Implementation

The Python implementation is similar in Java; however, instead of using the pipe operator (`|`), we use the `apply()` method:

```java
inputCollection.apply(transform1).apply(transform2)
...
outputCollection = resultFromTransformN
```

Here, each transform function applies to the input **P collection** and produces an output **Pn collection**. The final output can be assigned a variable name for later use in the program.

## Pipeline Components

1. **Source:** Obtains the initial **P collection** from data sources like text files or cloud storage, typically using methods such as `readFromTextLine()`.
2. **Transformers (P Transforms):** Perform operations on the input **P collection** to produce a new **Pn collection** through various functions like flatMap().
3. **Sink:** Writes out the final **P collection** to an output sink, such as a text file or cloud storage. This can be achieved using methods like `writeToText()`.

## Example Pipeline in Python

The following code snippet demonstrates constructing and running a simple dataflow pipeline in Python:amo

# Designing Dataflow Pipelines

## Input and Outputs of Pipeline:

1. **Beam Pipeline Setup**

   - Utilize `beam.Pipeline()` with options passed through the dot notation, e.g., `pipeline = beam.Pipeline(options=...)`

2. **Data Sources for Input**

### Text files from Cloud Storage:

- Use `beam.io.ReadFromText` and specify cloud storage bucket/file name with asterisk wildcard to handle multiple files.

### Pub Sub Topics:

- Implement `beam.io.ReadFromPubSub` for reading strings, input topic name required.

### BigQuery Data Inputs:

- Prepare SQL query and use `beam.io.Read(bigquery.Read)` with source as a read function to flow data into pipeline.

3. **Data Sources from Other Services** (e.g., Google Sheets, Cloud Datastore)

   - Similar usage pattern of Beam IO Read functions tailored for specific services.

4. **Outputs/Data Writing Options:**

## BigQuery Data Outputs

- Use `beam.io.WriteToBigQuery` to write data into a BQ table with the following configuration:
  - Project ID, dataset name and table name specified as part of the reference.
    **Note on Rate Disposition and Table Handling**:
  ```python
  bigquery_options=beam.options.Read / WriteToBigQueryOptions(
      rate_limiting=True, write_disposition=beam.bigqueryio.WriteDisposition.WRITE_TRUNCATE)
  ```

5. **Additional Pipeline Steps**:

- In case of smaller datasets like lookup tables or hardcoded lists, create a `PCollection` in memory using functions such as `beam.Create()` and apply pipeline steps directly to it.

Remember that these are key considerebations when designing pipelines for dataflow. The actual implementation depends on the specific requirements and resources available.

# Data Transformation with PTransforms

## Understanding Map Phase:

- **Map phase** processes each element from a `PCollection`. It applies parallel transformations to map input to output.

  - For example, calculating word length or finding instances of terms in text data.

  ```python
  def my_mapper(line):
      # This function could be used to find the number of occurrences of a specific term
      for match in re.finditer(term, line):
          yield {'match': str(match), 'position': match.start()}
  ```

### Using Generators (`yield`) in PTransforms:

- `yield` statement allows function to remember its state and continue from where it left off upon subsequent calls.
  - Useful for parsing lines with multiple occurrences of a term.
  - Implemented as generator functions within PTransform mapper methods.

## FlatMap Transformation:

- **FlatMap** handles one-to-many relationships, iterating over each output from the mapping function to create new elements in `PCollection`.
  - Can be used to filter and transform data into different formats for further processing or storage (e.g., BigQuery tables).

## ParDo Transformation:

- **ParDo** is a versatile transformation allowing complex operations on each element of a `PCollection`.
  - Enables extraction, conversion, computation, and outputting in various formats.

### DoFn Functions for ParDo:

- A **do function (beam Sink)** defines distributed processing logic within a pipeline. It must be serializable and thread-safe.

  ```python
  class ComputeLength(beam.transforms.combining.BeamTransform):
      def expand(self, pcoll):
          return (pcoll | beam.Map(lambda x: len(x)))
  ```

### PTransform Output Varieties:

- Transformations can produce elements with different outputs based on processing needs, such as extracting fields from records or computing new variables.
  - Example output types include single values per input item and multiple variable results for complex operations.

# Lab: Building a Simple DataFlow Pipeline

## Introduction:

- This lab focuseback on constructing a basic **Dataflow pipeline** for serverless data processing and analysis in either **Python or Java**.

## Key Concepts & Components:

### Serverless Data Analysis:

- Utilizes cloud services like Google Cloud DataFlow to process large datasets without provisioned servers, optimizing costs.

### Dataflow Pipeline Construction Steps:

1. **Define a Source**:
   - Specify data source (e.g., Pub/Sub topics, BigQuery tables) for ingestion into the pipeline.
2. **Map and FlatMap Transformations**:
   - Apply transformation functions to each element in PCollection, such as filtering or projecting fields.
     ```python
     def map_function(element):
         # Process elements (e.g., filtering)
         return transformed_element
     ```
3. **GroupByKey & ParDo**:
   - Perform aggregations and complex operations on grouped data using user-defined functions within a PCollection.
4. **Output Sink Configuration**:

   - Configure sinks to store processed data, such as BigQuery or Cloud Storage buckets.
     ```python
     | beam.io.Read from PubSub(topic_name='example')
       | beam.Map(_parse)
       | beam.WindowInto(...))
       | beam.Write(beam.io.BigQuerySink(...))
     ```

5. **Pipeline Execution**:
   - Launch the pipeline with appropriate parameters and execute using cloud resources dynamically allocated as needed.

### Python vs Java Implementation:

- Both languages support Dataflow's API for building pipelines, although the syntax differs slightly due to language specifics (e.ebxpression vs Generics).

# Notes on Dataflow Pipeline: Python & Java

## Key Concepts

- **Dataflow Model**: Manages data flow in parallel computing environments such as serverless architectures.
- **GroupByKey Phase**: Groups key-value pairs by common keys, aggregating values associated with each key.
  - _Example_: Grouping zip codes under their respective city names.
- **Combine Transformations**: Apply functions to combine elements or values within P collections based on a key.
  - _Note_: Combined operations can be faster and more efficient than `GroupByKey`.

## Technical Details

### Dataflow Processing Phases: Map & Shuffle (Unnamed)

- **Map Phase**: Transforms each element in the input P collection.
- **Shuffle Phase (Unnamed)**: Groups elements by their common key, preparing for aggregation or combination steps.
  - _Important_: Be aware of data skew and potential network issues with large groups.

### Combine vs GroupBy()

#### GroupByKey Operation

- **Description**: Aggregates values per unique key in a P collection, resulting in single key-value pairs where the value is an aggregation (e.g., list or sum) of associated values.
  - _Challenge_: Data skew can lead to inefficient processing when large groups are processed by a single worker node.

#### Combine Transformations

- **Description**: Applies predefined or custom functions to combine elements within P collections, allowing for more complex aggregations beyond simple `GroupByKey`.
  - _Customization_: Define subclasses of the combined function with additional methods if necessary.
  - _Optimization_: Can be orders of magnitude faster than GroupByKey due to parallel processing capabilities.

### Mathematical Formulas and Operators

- **Combine** (e.g., `combine_by_key`): $\text{combine}(k, vs) = \text{reduce}(\text{accumulator}(v), vs)$ for a key $k$ with values $vs$.
  - _Variants_: Custom combined functions such as sums or means.

### Code Examples and Best Practices

- **Dataflow Syntax**: Utilize the specific language (Python or Java) syntax within Google's Dataflow environment for creating pipelines.

## Tabular Comparison

| Operation        | GroupByKey                     | Combined Transformations                      |
| ---------------- | ------------------------------ | --------------------------------------------- |
| Aggregation Type | List of values per key         | Customizable aggregation function             |
| Efficiency       | Less efficient with data skew  | More efficient, parallel processing           |
| Complexity       | Simple grouping by common keys | Handles complex operations like mean averages |

# MapReducuce in Beam Lab Overview

---

## Learning Objectives:

- Create and perform **map** and **reduce** operations on P collections within a pipeline.
- Choose between Python or Java for implementation.
- Identify the required map and reduce operations.
- Execute the pipeline successfully.
- Modify command line parameters as needed.

## Key Concepts:

1. **MapReduce** is a programming model that allows processing large data sets in a distributed manner, using _map_ functions to process input key/value pairs and generate intermediate results; followed by _reduce_ functions to merge all intermediate values associated with the same key.

2. In Apache Beam's context, P collections represent an abstraction for parallel processing of distributed datasets within a pipeline architecture.

## MapReduce Operations:

| Operation | Description                                                                                                                                        | Example (Python)                                                                                | Example (Java)                                     |
| --------- | -------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | -------------------------------------------------- |
| Map       | Apply the map function to every element of a P collection. The output is an intermediate dataset with key/value pairs.                             | ```python def process_element(element): return (element, "processed") pcoll = pipeline          | .apply("MyMap", beam.Map(process_element)) # ...   |
| Reduce    | Apply the reduce function to all intermediate values associated with the same key in a P collection. The output is a single result per unique key. | ```python def combine_values(value1, value2): return "".join([value1, value2]) pcoll = pipeline | .apply("MyReduce", beam.Map(combine_values)) # ... |

## Executing the Pipeline:

- Choose either **Python** or **Java** for implementation.
- Define your map and reduce functions as shown in examples above.
- Construct a pipeline by applying the map operation first, followed by the reduce operation.
- Run the pipeline with appropriate command line parameters to execute the processing of input data through the defined operations.

## Modifying Command Line Parameters:

- **--project**: Set your GCP project name for billing and access control purposes.
- **--location**: Specify a region within your chosen project, e.g., 'us-central1'.
- **--job_name**: Assign a unique job identifier; must be 3 to 26 characters long and cannot contain special symbols or whitespaces.
- **--temp_location**: Define the default location for temporary storage used during pipeline execution, e.g., 'us-central1-a'.
- **--setup_file** (optional): Run setup actions before job execution by providing a configuration file path.

# Lab: MapReduprise in Beam (Python) 2.5 & Serverless Data Analysis with Beam: MapReduce in Beam (Java)

## Side Inputs and Windows of Data

**Objective**: Understand the role of side inputs, windows, and their application within a pipeline's data processing using Apache Beam.

### 1. Introduction to Side Inputs

- **Definition**: Additional input accessible by each function (FN) while processing an element in the primary input P collection.
- **Usage**: Inject additional dynamic, runtime-determined values that depend on different branches of your pipeline.
- **Example (Python)**: Map functions to get length and a global combine function to compute total lengths across data sets.

### 2. How Side Inputs Work

1. Create view with side input using additional data from another P collection.
2. View is static, available for worker nodes' use later in the pipeline.
3. Example: Compute average word length and then feed branch into method as a side input.

### grobal Windows

- **Purpose**: Handle unbounded data sets by grouping elements based on timestamps or other criteria.
- **Types** of windows in Apache Beam:
  1. Global window
     - Processes all elements together after the last element is processed (unsuitable for streaming data).
     - Example: `beam.WindowInto(glob)alWindows()`
  2. Time based windows
     - Group and process data in time-based chunks, useful for processing streaming data with different timestamps.
       - **Subtypes** (Java): Fixed, Sliding, Session, Count, Split, Interval, Global, TimestampedValue
  3. Batch inputs can also use timestamp information for grouping and windowing purposes.
     - Extract timestamps from data records and apply windows accordingly; e.g., aggregating sales by day using a one-day fixed window duration.

### 3. Additional Notes on Capabilities: Accumulation Steps & More

- **Accumulation**: An arithmetic mean example with two parts – accumulation step (compute total and count) followed by the division after all elements are processed.
  - Unbounded data sets present challenges in determining when to perform final completion steps, like computing means or aggregations.

### 4. Future Topics & Courses

- Streaming pipelines: Discussions on unbound P collections and windows will continue in the streaming course.
  - Time based Windows can be useful for processing streaming data with different timestamps.
- Batch inputs: Group by time using timestamp information instead of standard output.
  - Example: Read an offline access log, extract date/time stamps, use them for windowing and group aggregations (e.g., sliding windows).

## Serverless Data Analysis with Dataflow: Side Inputs Lab Notes

**Objective:**  
To practice creating site inputs for a data flow pipeline using either Python orjava. Bringing data from BigQuery to the pipeline and executing jobs in DataFlow.

### Key Components:

- **Serverless Data Analysis**
  - Utilizing Google Cloud Platform's serverless computing model
- **Dataflow**
  - A fully managed service for stream and batch processing
- **Side Inputs**
  - Functionality to read data from BigQuery within a Python or Java DoFn function

### Steps:

1. Set up Google Cloud project, enable billing, and create necessary service accounts
2. Install required software/libraries for the chosen language (Python or Java)
3. Configure access permissions in GCP IAM to authenticate with Dataflow APIs using your service account
4. Create a BigQuery dataset and table for input data
5. Write Python or Java functions as DoFns, implementing side inputs functionality:
   - Import required modules/libraries (Google Cloud client libraries, Apache Beam)
   - Define the function to read from BigQuery using side inputs
6. Construct Dataflow pipeline with your customized DoFn and specified input data source from BigQuery
7. Execute DataFlow job on GCP
8. Monitor/Debug DataFlow job execution in GCP Console

### Comparison between Python and Java Implementations:

| Aspect                   | **Python**                            | **Java**                              |
| ------------------------ | ------------------------------------- | ------------------------------------- |
| Libraries/Modules        | Apache Beam, Google Cloud client libs | Apache Beam, Google Cloud client libs |
| Programming Paradigm     | Object-Oriented (Pythonic)            | Object-Oriented                       |
| Syntax                   | Dynamic typing                        | Static typing                         |
| Popularity and Community | Higher popularity; more tutorials     | Lower popularity; fewer tutorials     |

## Serverless Data Analysis: Reusing Dataflow Templates

**Objective:**  
Enable non-developers, such as database administrators, analysts, and data scientists to execute their own data flow jobs using pre-existing templates or creating new ones without requiring coding capabilities or knowledge of the development environment dependencies.

### Key Components:

- **Dataflow Templates**
  - Facilitate rapid deployment of standard data transformation jobs for non-developers
  - Can be created from scratch by users, using Google's pre-existing templates as a starting point
- **Value Providers**
  - Function to parse command line or optional arguments and convert them into runtime parameters
- **Metadata Files**
  aturally associated with each template upon creation to help downstream users understand the function of the template and its expected parameters

### Steps:

1. Understand dataflow templates, their purpose, and how they can be utilized for rapid deployment of standard transformations jobs by non-developers without coding capabilities or understanding development environment dependencies
2. Familiarize yourself with value providers and how they parse command line arguments to convert them into runtime parameters, making the template accessible and usable by a broader audience
3. Learn about metadata files and their role in providing information on the function of templates and expected parameters for downstream users upon creation
4. For creating new templates:
   - Determine desired dataflow transformation job requirements
   - Create the necessary value providers based on required command line arguments or optional inputs
   - Develop template code with appropriate metadata file(s) in Java/Python
5. Deploy, execute, and test your newly created dataflow templates using various environments (app engine, standard environment, cloud functions, etc.) to ensure compatibility and functionality across platforms
6. Utilize Google-provided templates for immediate deployment or use as a reference point when creating custom templates tailored to specific needs
7. Leverage the command line tool or REST API to execute template jobs once deployed, using specified runtime parameters provided by users through value providers
8. Continuously monitor and refine your dataflow templates based on user feedback, usage patterns, and evolving requirements of downstream consumers.

# Summary: Hadoop and Spark Job Migration & Pipeline Design on Dataflow

## Batch Processing using DataProc

- **Hadoop** & **Spark jobs** migration to the cloud is simplified by running them on **DataProc**, a serverless product that automates cluster resizing.

## Data Flow for New and Migrated Pipelines

- Develop new pipelines or migrate Hadoop jobs using Dataflow's Beam SDK (Apache Beam open source).

### Input Creation with Beam Syntax:

- Read **CS V files** from cloud storage, streaming messages, pub/sub cues, and structured data in BigQuery.

## Key Considerations When Designing Pipelines

1. Utilize `combine` instead of `group by key` for skewed datasets to avoid bottlenecks due to high cardinality data sets:
   ```bash
   PTransform(GroupByKey()) => PTransform(CombineFn())
   ```
2. Use parallel transforms (P and P collections) in pipelines as they are immutable, distributed across multiple workers for efficient processing.

## Practices with Side Inputs & Windows of Data

- Incornporate side inputs into labs to manage dependencies between different parts of the pipeline.
- Implement windows of data for batch datasets and create/save new templates using premade Google public GitHub repositories.

# Summary: Managing Data Pipelines using Cloud Data Fusion & Cloud Composer

## Introduction to the Module

- Understand the concepts of managing data pipelines with **Cloud Data Fusion** for visual pipeline building and **Cloud Composer** for orchestration between Google Cloud services.

### Using Cloud Data Fusion:

1. Visual interface to design, build, and monitor robust data pipelines across multiple cloud and on-premises sources.
   - Utilize connectors for various data storage systems like BigQuery, Cloud Storage, etc.
2. Apply transformations using built-in functions or user-defined code snippets within the pipeline creation process.

### Implementing with Cloud Composer:

1. Orchestration tool to coordinate work between Google Cloud services and on-premises data sources.
   - Design workflows with a YAML file, specifying tasks, dependencies, and configurations.
2. Scalable processing using GKE for running large numbers of concurrent jobs while maintaining cost efficiency.

# Summary: Introduction to Cloud Data Fusion

## Overview of Cloud Data Fusion

- **Cloud Data Fusion** provides an intuitive graphical user interface (GUI) along with an API for efficient time management in data integration tasks.
- Targeted towards **business users, developers, and data scientists** to build and manage data pipelines easily without coding knowledge.

### Cloud Data Fusion Functionality:

1. **Data Cleansing & Transformation:** Developers can cleanse, match, remove duplicates, blend, transform, partition, transfer, standardize, automate, and monitor their data efficiently.
2. **Pipeline Development for Data Scientists:** Allows the creation of integration pipelines using a visual interface, testing, debugging, deploying applications with ease.
3. **Scalable Operations for Business Analysts:** Facilitates large-scale operations on Google Cloud, operationalizing pipelines and enabling rich metadata inspection.

### Key Benefits of Using Cloud Data Fusion:

1. **Integration Capabilities:** Seamlessly integrates with various data sources such as legacy systems, relational databases, file systems, cloud services (e.g., object stores), NoSQL and more.
2. **Productivity & Efficiency Enhancement:** Centralizes diverse data sources in a unified view (like BigQuery or Cloud Spanner) for improved productivity and reduced complexity via a visual interface.
3. **Flexibility & Interoperability:** Supports on-premises, cloud environments; interoperates with open-source software like CDAP.
4. **Extensible Architecture:** Enables users to extend functionalities using templates, connectors (Google Cloud and other providers), a comprehensive transformation library, testing & debugging features, tagging for organizational purposes, unified search functionality, field lineage tracking, tent-plug integration, conditional triggers creation, custom compute profiles, etc.
5. **UX Improvements:** Offers UIs like widget and plugin plugins to enhance user experience while managing data pipelines on Google Cloud Platform (GCP).

# Summary: Components of Cloud Data Fusion

## Key User Interface Components:

1. **Wrangler UI** - Allows users to visually explore datasets and build pipelines without coding knowledge using templates for common data processing tasks (e.g., from cloud storage to BigQuery).
2. **Data Pipeline UI** - Enables drawing pipelines directly onto a canvas, providing flexibility in designing custom workflows.

### Additional Features of Cloud Data Fusion:

- **Integrated Rules Engine**:
  - Business users can create predefined checks and transformations stored as reusable "rules".
  - Data engineers use these rules within rule books or pipelines for efficient processing.
- **Data Lineage & Metadata Aggregation**:
  1.  Field metadata includes data lineage accessible through the integrated UI.
  2.  Rich metadata about pipelines and schemas can be analyzed using the metadata aggregator tool, including creating a shared data dictionary within the platform.
  - Example use case: Analyzing source field transformations to ensure proper mapping between datasets.
- **Microservice Framework**:
  - Allows building specialized logic for processing specific types of data or custom operations in pipelines.
- **Event Condition Action (ECA) Application**:
  1.  Parses events based on defined conditions and triggers actions accordingly, allowing dynamic control over pipeline execution.

### Comparisons:

| Feature              | Wranger UI                                                    |                                            Data Pipeline UI |
| :------------------- | ------------------------------------------------------------- | ----------------------------------------------------------: |
| **Main Focus**       | Visually exploring datasets & building pipelines with no code | Designing custom workflows by drawing pipelines on a canvas |
| **Template Usage**   | Yes (for common data processing tasks)                        |                                             Limited or none |
| **Lineage Analysis** | Integrated lineage for field metadata                         |       Included in the overall functionality of the platform |

# Summary: Cloud Data Fusion UI

## Key User Interface Elements:

1. **Control Center**:
   - Provides an overview of applications, artifacts, data sets, and pipelines using search capabilities for quick access (e.g., pipeline, data dictionary).
2. **Wrangler Section**:
   - Contains connections, transforms, data quality insights, functions, and integration metadata features such as tagging, property management, and field data lineage tracking.
3. **Hub**:
   - Enables users to explore plugins, sample use cases, prebuilt pipelines, and manage entities like creating new pipelines or uploading applications.
4. **Administration Components**:
   1. **Management**:
      - Includes services management.
      2. **Configuration**:
         - Handles metrics, namespaces, compute profiles, preferences, system artifacts, and the rest client setup.

### Comparisons:

| UI Component         |                 Main Functionality |            Sub-Functionalities            |
| :------------------- | ---------------------------------: | :---------------------------------------: |
| **Control Center**   |     Overview & Search Capabilities |   Apps, Artifacts, Datasets, Pipelines    |
| **Wrangler Section** |              Data Management Tools | Connections, Transforms, Lineage Tracking |
| **Hub**              |   Plugins and Pipeline Exploration |   Entity Creation & Application Upload    |
| **Administration**   | Service & Configuration Management |       Services, Metrics, Namespaces       |

# Data Pipeline Construction Guide

## Introduction

A **data pipeline** is depicted visually as stages in a Directed Acyclic Graph (DAG), where nodes represent stages and edges indicate data flow from one node to another without any cycles or feedback loops.

## Components of a DAG-based Pipeline

1. Nodes: Each stage within the pipeline corresponds to a node that can have varying types, such as cloud storage data retrieval or parsing operations using CS Verbs.
2. Edges: The connections between nodes define the flow of data throughout the pipeline.
3. Parallel Processing (Forking): A single parent node may fork multiple child nodes for parallel processing without being blocked by other processes in separate pipelines.
4. Data Combination and Sync: Nodes can join data from different sources before passing it to synchronization points, such as Cloud Data Fusion's sync capabilities.
5. User Interface (Studio): The studio provides a canvas for authoring, creating, and chaining nodes within the pipeline architecture.
6. Navigation Tools: Utilize mini-maps and zoom functions to manage clutter in large pipelines with many nodes.
7. Pipeline Actions Bar: Includes features like saving, running, previewing, deploying, and monitoring pipelines' health through metrics collection.
8. Template Usage: Leverage pre-existing templates or plugins for rapid pipeline development, such as the "data pipeline batch" template for moving data between cloud storage, processing with Wrangler, and outputting to BigQuery.
9. Preview Mode: Ensure proper functioning by testing each node using sample data before deployment in production environments.
10. Monitoring and Tagging: Post-deployment monitoring allows tracking of start times, duration, summary stats per execution, throughput rates, compute profiles, inputs/outputs, errors for each node, as well as organizing multiple pipelines with tags.

## Key Concepts in Data Pipelines

1. **DAG**: A Directed Acyclic Graph that defines the structure of a data pipeline without cycles or feedback loops.
2. **Node Types**: Various types of nodes, including cloud storage retrieval and CS Verb parsing.
   3.pressing parallel processes can be managed through forking from single parent nodes.
3. Data synchronization involves combining inputs from multiple sources before passing them to sync points like Cloud Data Fusion's sync capabilities.
4. The studio is the user interface where pipelines are authored, created, and chained together on a canvas. Navigational tools such as mini-maps help manage large pipelines with many nodes.
5. Pipeline actions bar features include saving, running, previewing, deploying, and monitoring pipeline health through metrics collection. Templates can be used for rapid development of data pipelines. Preview mode allows testing each node using sample data before deployment in production environments. Post-deployment monitoring enables tracking various aspects of pipeline execution while tags help organize multiple pipelines within an organization.
6. **Lineage Tracking**: Cloud Data Fusion provides the ability to track lineage, allowing users to trace a given field value's history and transformations between data sets for better understanding and debugging purposes.

## Data Exploration and Transformation Using Wrangler UI

### Overview:

- Core components, tools, processes of building **data pipelines** discussed.
- Introduction to using the **Wrangleteer U I (UI)** for exploring new data sets visually.

#### Key Components in Wrangler UI:

1. **Data Connections:**
   - Connects to various sources like Google Cloud Storage, BigQuery, etc.
2. **Dataset Browsing:**
   - Ability to browse through files or tables within the specified source (e.g., CS V files of customer complaints).
3. **Data Exploration and Insights:**
   - Visual exploration of rows, columns, and sample insights.

#### Data Transformation Steps:

1. **Calculated Fields Creation:** Add new calculated fields to the data set.
2. **Column Dropping:** Drop unwanted columns from the data set.
3. **Row Filtering:** Apply filters to select specific rows within the data set.
4. **Data Wrangling:** Combine all transformations into a directive for creating a pipeline recipe.

#### Pipeline Execution and Scheduling:

- Create, customize, and run pipelines at regular intervals using directives formed from previous steps in the Wrangler UI.

## Building and Executing Pipeline Graphs in Cloud Data Fusion

### Overview:

- Practical exercise on creating and executing pipeline graphs using **Cloud Data Fusion**.
- Connect multiple data sources, apply transformations, join datasets, and synchronize output data.

#### Lab Steps:

1. **Data Source Connection:**
   - Establish connections between Cloud Data Fusion and various data sources (e.g., databases, files).
2. **Basic Transformations:**
   - Perform elementary data manipulations such as filtering or aggregating datasets.
3. **Joining Datasets:**
   - Merge two distinct datasets to create a unified dataset based on specified keys and conditions.
4. **Data Synchronization (Output):**
   - Write the final, transformed data to an output location for synchronization and analysis purposes.

#### Key Concepts in Cloud Data Fusion:

- **Pipeline Graphs:** Visual representation of the sequence of transformations applied to datasets within a pipeline.
- **Transformations:** Operations that alter or enhance dataset attributes (e.g., filtering, aggregation).
- **Joining Datasets:** Combining multiple datasets based on common identifiers or criteria.

#### Pipeline Execution and Output Data:cuarto

## Orchestrating Work with Cloud Composer 2.5

### Overview:

- Managing complex data pipelines across multiple Google Cloud services using **Cloud Composer** (formerly Apache Airflow).
- Creating and executing workflows to coordinate tasks like pipeline execution, model training, and deployment.

#### Key Concepts in Orchestration:

- **DAGs (Directed Acyclic Graphs):** Workflow schemas that define task dependencies and order of operations.
- **Cloud Composer:** Serverless platform for running open source workflow tools, managing data pipelines across Google Cloud services.

#### Steps in Orchestrating with Cloud Composer 2.5:

1. **DAG Creation:** Construct a DAG specifying tasks (e.g., updating training datasets, model training, deployment) and their dependencies.
   - Example: Four sequential tasks orchestrated within a single DAG using Cloud Composer.
2. **Task Orchestration:** Utilize Cloud Composer to direct and execute tasks among various Google Cloud services (e.g., BigQuery, Cloud Storage).
   - Tasks may include data retrieval, preprocessing, model training/validation, deployment to production environments.
3. **Workflow Automation:** Leverage the open-source nature of Patchwork Airflow in Cloud Composer for flexible and customizable workflow automation across services.

## Apache Airflow Environment Overview

### Introduction:

- Preview of Cloud Composer's interface after launching an environment via command line or Google Cloud UI.
- Mention multiple environments, each with a separate Apache Airflow instance and DAGs (Directed Acyclic Graphs).

#### Key Features in Airflow Environment:

- **Multiple Environments:** Capability to create various isolated instances of Cloud Composer for different projects or workflows.
- **Apache Airflow Instances:** Each environment hosts its own Apache Airflow instance, managing the execution of DAGs within that environment.
- **DAGs and Environment Variables:** Execution plans (DAGs) written in Python are stored in a cloud storage bucket; environment variables for workflow customization can be set at the Apache Airflow level rather than Cloud Composer UI.

#### Steps to Work with Apache Airflow Instance:

1. **Launching Environment and Accessing Web Server:** Navigate through Cloud Composer UI, create a new instance and proceed to the airflow web server for workflow interaction.
   - Note that environment variables should be edited at the Apache Airflow level using the admin UI interface of each respective instance.
2. **DAG Management:evelopment:** The DAGs folder within an Apache Airflow instance contains Python code files defining workflow tasks and dependencies, stored in a cloud storage bucket created automatically for that environment.

## DAGs and Operators in Apache Airflow

### Introduction:

- Primary artifact: Directed Acyclic Graph (DAG) written in Python, representing workflow tasks within Apache Airflow environment.

### Components of a DAG:

1. _Python Files_ - One file for each DAG, containing user-defined tasks using predefined operators such as `data_flow` and `general_python`.
2. Upload Python File to the 'DAGS' Folder in Cloud Storage Bucket.
3. Visual Representation: Once uploaded, workflow is visually represented on Airflow Web UI, with nodes (tasks) and edges (dependencies).

### Example Workflow - "GCS to BigQuery":

- Name of DAG: GCS_to_Bigquery_Triggered
- Number of Tasks: Three
  - Process Delimited & Push: Invokes a data flow job for CSV processing and writes output to BigQuery.
  - Success Move To Completion: Moves processed file from input bucket to completed/archived cloud storage bucket after successful execution, else it moves with "Failure" tag.
- Common Operators Used: `data_vein` (Bigquery), `general_python`, and others as per requirement.

### Apache Airflow Operators:

Operators are predefined tasks in Apache Airflow that can be invoked to automate various services/actions such as BigQuery queries, data manipulation etc. They're atomic, usually one operator per task.

- Relevant operators for Data Engineers: `bigquery_get_data`, `bigquery_check_operator` and `bigquery_interval_check`. More operators available in Apache Airflow documentation.

### Retraining & Redeploying the Model:

Post BigQuery operations, further steps can include retraining models using other cloud or software services via vertex AI operator.

# Workflow Scheduling Notes

## Key Concepts:

- **Workflow scheduling** involves automating processes to run at specific intervals or based on certain events, without manual intervention.

## Types of Workflow Triggers:

1. **Periodic/Scheduled Runs**: Processes are executed automatically according to a predefined schedule (e.g., daily, weekly). Example: `Once a day at vegetable_daily_6a_m`.
2. **Event-Based Triggers**: Activated by specific occurrences or changes in the system, such as new file uploads or data updates from an external source (e.g., pub/sub topics). Example: `Whenever a CS V data files are loaded into cloud storage bucket`.

## Workflow Automation Tools and Environments:

- **Apache Airflow**: A platform for programming workflows to orchestrate complex ETL processes with scheduling and monitoring capabilities.
- **Cloud Composer (Google Cloud)**: Allows the creation of templates for Airflow DAGs, facilitating easy management of workflows in a cloud environment.

## Comparison of Workflow Triggers:

| Type                    | Description                                           | Example                                   | Use Cases                                |
| ----------------------- | ----------------------------------------------------- | ----------------------------------------- | ---------------------------------------- |
| Periodic/Scheduled Runs | Run based on predefined schedules (daily, weekly)     | `vegetable_daily_6a_m`                    | Regular data processing tasks            |
| Event-Based Triggers    | Activated by specific events or changes in the system | CS V files loaded to cloud storage bucket | Real-time updates and reactive workflows |

## Creating Workflow Triggers with Apache Airflow:

1. Define a DAG (Directed Acyclic Graph) for your ETL process, specifying tasks and dependencies between them.
2. Configure the schedule or trigger type in the DAG code. For example: `schedule_interval='@daily'`.
3. Deploy Airflow to monitor and execute the defined workflows according to their triggers.
4. (Optional) Use Cloud Functions for event-driven architecture, e.g., monitoring file uploads in a cloud storage bucket and triggering an ETL process accordingly:
   - Create a JavaScript function that makes a POST request to the Airflow server when specific events occur.
   - Package metadata about the function (code dependencies, version info) for deployment.
5. Deploy the Cloud Function as an event listener, e.g., monitoring new CS V files uploads in a cloud storage bucket: `trigger_csv_files`.
6. Monitor and log Airflow workflow executions using tools like GCP'e Stackdriver to track progress and troubleshoot any issues that arise during runtime.

## Best Practices for Workflow Automation:

- Use periodic/scheduled runs for regular, predictable tasks (e.g., daily data processing).
- Implement event-based triggers for real-time updates or reactive workflows when dealing with unpredictable events.
- Monitor and log Airflow workflow executions to ensure smooth operation and easy troubleshooting.

## Monitoring & Logging in Airflow Workflows

- **Auto-Retries**:

  - Set to automatically retry workflow execution if transient errors occur, reducing manual troubleshooting efforts.

- **Workflow State Tracking**:

  - Utilize the main DAG page for real-time monitoring of pipeline runs in various states (success, running, failed).

- **Successful Runs Insight**:

  - Example analysis shows five successful DAG runs over consecutive days.

- **Identifying Troubled Workflows**:

  - Red indicators on the main page suggest problems with recent DAG executions.

- **DAG Run Status Indicators**:
  - Three circles displayed for each DAG, showing active/failed run statuses.

### Investigation of Failed Runs (Case Study)

1. **Initial Observations**:
   - For a specific DAG with failed runs, no success is recorded out of 268 attempts.
2. **Task-Specific Issues**:

   - First task succeeds; second task fails due to improper file transfer between cloud storage buckets.

3. **Error Diagnosis Steps**:
   - Inspect logs for errors, focusing on keyword "error".
4. **Issue Identification & Solution**:

   - Output bucket naming error causes an infinite processing loop; fixing the output bucket name resolves the issue.

5. **Cloud Functions Considerations**:
   - Ensure cloud functions are triggered correctly and monitor logs for errors (case-sensitive).

## Lab: Introduction to Cloud Composer

### Objectives & Practical Application

- Create **Cloud Composer Environment** using the cloud console.
- Run a DAG (Directed Acyclic Graph) through Airflow's web interface.
- Analyze results of word count job stored in storage.

### Key Components:

- **Cloud Console**: Used for environment creation and configuration.
- **DAG**: Directed Acyclic Graph - a set of tasks to execute workflow.
- **Airflow Web Interface**: Platform to monitor, trigger, and analyze DAG runs.

### Practical Steps & Analysis

1. **Environment Setup**:
   - Use the cloud console to establish Cloud Composer environment with appropriate resources and permissions.
2. **DAG Creation**:

   - Develop a DAG that performs word count tasks, detailing each step's dependencies and order of execution.

3. **Airflow Interface Execution**:
   - Deploy the DAG on Airflow web interface; monitor its progress in real time.
4. **Results Analysis**:
   - Review stored results from the word count task, assessing accuracy and efficiency of execution.

## Lab Course Summary: Building Batch Data Ppipelines

### Key Takeaways & Practical Application

- **Data Loading Methods**: Understanding ELT (Extract, Load, Transform) vs. ETL (Extract, Transform, Load).
  - When to use each approach based on data transformation complexity and volume.

### Cloud Composer Overview

- **Cloud Data Fusion & Cloud Composer**: New tools introduced for data wrangling and orchestration.
  - Cloud Data Fusion enables visual pipeline building, while Cloud Composer manages workflows with DAGs (Directed Acyclic Graphs).

### Hadoop Module Highlights

- **Lifting & Shifting Workloads**: Seamless migration to cloud without code changes.
  - Additional optimizations: Utilizing Cloud Storage for cluster storage, enhancing efficiency and cost savings.

### Data Flow Techniques

- **Batch Pipelines with Dataflow Templates**: Creating scalable batch data pipelines using templates.
  - The "P collection" as a fundamental unit of logical data in the pipeline.

### Managing Data Pipelines

- **Cloud Composer & Cloud Data Fusion Management**: Tools for managing and orchestrating cloud services through DAGs and workflow visualization, respectively.
