+++
title = "Building Batch Pipelines on Google Cloud Platform"
date = "2024-07-03T10:06:10+01:00"
tags = [ "data-engineering", "batch-pipelines", "google-cloud", "course-summary" ]
author = "Me"
showToc = true
TocOpen = false
draft = false
hidemeta = false
comments = false
disableShare = false
disableHLJS = false
hideSummary = false
searchHidden = true
ShowReadingTime = true
ShowBreadCrumbs = true
ShowShareButtons = true
ShowPostNavLinks = true
ShowWordCount = true
ShowRssButtonInSectionTermList = true
UseHugoToc = true

[cover]
image = "./cover.png"
alt = "Image"
caption = "Building Batch Pipelines on Google Cloud Platform"
relative = false
hidden = false
+++

![cover](./cover.png)

## Introduction to Building Batch Data Pipelines

### Batch Pipelines Overview

- **Definition:** Pipelines that process a fixed amount of data and terminate.

  - Example: Daily processing of financial transactions to balance books and store reconciled data.

- **ETL vs ELT:**

  - **ELT (Extract, Load, Transform):**

    - Load raw data into a target system and perform transformations on the fly as needed.
    - Suitable when transformations depend on user needs or view requirements (e.g., raw data accessible through views).

  - **ETL (Extract, Transform, Load):**
    - Extract data, transform it in an intermediate system, then load into a target system (e.g., Dataflow to BigQuery).
    - Preferred for complex transformations or data quality improvements before loading.

- **Use Cases:**

  - **EL (Extract and Load):**

    - Use when data is clean and ready for direct loading (e.g., log files from cloud storage).
    - Suitable for batch loading and scheduled data loads.

  - **ELT (Extract, Load, Transform):**
    - Start with loading as EL, then transform data on-demand or based on evolving requirements.
    - Useful when transformations are uncertain initially, like processing API JSON responses in BigQuery.

### Quality Considerations in Data Pipelines

- **Data Quality Dimensions:**

  - **Validity:** Data conforms to business rules (e.g., transaction amount validation).
  - **Accuracy:** Data reflects objective truth (e.g., precise financial calculations).
  - **Completeness:** All required data is processed (e.g., no missing records).
  - **Consistency:** Data consistency across different sources (e.g., uniform formats).
  - **Uniformity:** Data values within the same column are consistent.

- **Methods to Address Quality Issues:**

  - **BigQuery Capabilities:**
    - Use views to filter out invalid data rows (e.g., negative quantities).
    - Aggregate and filter using `HAVING` clause for data completeness checks.
    - Handle nulls and blanks using `COUNTIF` and `IF` statements for accurate computations.

- **Ensuring Data Integrity:**

  - **Verification and Backfilling:**
    - Verify file integrity with checksums (e.g., MD5).
    - Address consistency issues such as duplicates with `COUNT` and `COUNT DISTINCT`.
    - Clean data using string functions to remove extra characters or format inconsistencies.

- **Documentation and Best Practices:**
  - Document SQL queries, transformations, and data units clearly to maintain uniformity.
  - Use SQL functions like `CAST` and `FORMAT` to manage data type changes and indicate units clearly.

### Shortcomings of ELT and Use Cases for ETL

- **Complex Transformations Beyond SQL:**

  - Examples include:
    - Translating text (e.g., Spanish to English using external APIs).
    - Analyzing complex customer action streams over time windows.
  - SQL may not handle these transformations efficiently or feasibly.

- **Continuous Data Quality Control and Transformation:**

  - Use ETL when:
    - Raw data requires extensive quality control or enrichment before loading into BigQuery.
    - Transformations are too complex or cannot be expressed in SQL.
    - Continuous streaming data needs processing and integration (e.g., using Dataflow for real-time updates).

- **Integration with CI/CD Systems:**
  - ETL is suitable for integrating with continuous integration and continuous delivery (CI/CD) systems.
    - Allows for unit testing of pipeline components and scheduled launches of Dataflow pipelines.

## Google Cloud ETL Tools

- **Dataflow:**

  - Fully managed, serverless data processing service based on Apache Beam.
  - Supports both batch and streaming data processing pipelines.
  - Ideal for transforming and enriching data before loading into BigQuery.

- **Dataproc:**

  - Managed service for running Apache Hadoop and Apache Spark jobs.
  - Cost-effective for complex batch processing, querying, and machine learning tasks.
  - Offers features like autoscaling and integrates seamlessly with BigQuery.

- **Data Fusion:**
  - Cloud-native enterprise data integration service for building and managing data pipelines.
  - Provides a visual interface for non-programmers to create pipelines.
  - Supports transformation, cleanup, and ensuring data consistency across various sources.

### Considerations for Choosing ETL

- **Specific Needs that ETL Addresses:**

  - **Low Latency and High Throughput:**

    - BigQuery offers low latency (100 ms with BI Engine) and high throughput (up to 1 million rows per second).
    - For even stricter latency and throughput requirements, consider Cloud Bigtable.

  - **Reusing Existing Spark Pipelines:**

    - If your organization already uses Hadoop and Spark extensively, leveraging Dataproc may be more productive.

  - **Visual Pipeline Building:**
    - Data Fusion provides a drag-and-drop interface for visual pipeline creation, suitable for non-technical users.

### Metadata Management and Data Governance

- **Importance of Data Lineage and Metadata:**
  - Data Catalog provides:
    - Metadata management for cataloging data assets across multiple systems.
    - Access controls and integration with Cloud Data Loss Prevention API for data classification.
    - Unified data discovery and tagging capabilities for organizing and governing data assets effectively.

## Executing Spark on Dataproc

**Dataproc**: Google Cloud's managed Hadoop service, focusing on Apache Spark.

### The Hadoop Ecosystem

- **Historical Context**:
  - Pre-2006: Big data relied on large databases; storage was cheap, processing was expensive.
  - 2006 Onward: Distributed processing of big data became practical with Hadoop.
- **Hadoop Components**:
  - **HDFS (Hadoop Distributed File System)**: Stores data on cluster machines.
  - **MapReduce**: Distributed data processing framework.
  - **Related Tools**: Hive, Pig, Spark, Presto.
- **Apache Hadoop**:
  - **Open-source** software for distributed processing across clusters.
  - **Main File System**: HDFS.
- **Apache Spark**:
  - **High-performance** analytics engine.
  - **In-memory processing**: Up to 100 times faster than Hadoop jobs.
  - **Data Abstractions**: Resilient Distributed Datasets (RDDs), DataFrames.
- **Cloud vs. On-premises**:
  - **On-premises Hadoop**: Limited by physical resources.
  - **Cloud Dataproc**: Overcomes tuning and utilization issues of OSS Hadoop.
- **Dataproc Benefits**:
  - **Managed hardware/configuration**: No need for physical hardware management.
  - **Version management**: Simplifies updating open-source tools.
  - **Flexible job configuration**: Create multiple clusters for specific tasks.

### Running Hadoop on Dataproc

- **Advantages of Dataproc**:
  - **Low Cost**: Priced at one cent per virtual CPU per cluster per hour.
  - **Speed**: Clusters start, scale, and shut down in 90 seconds or less.
  - **Resizable Clusters**: Quick scaling with various VM types and disk sizes.
  - **Open-source Ecosystem**: Frequent updates to Spark, Hadoop, Pig, and Hive.
  - **Integration**: Works seamlessly with Cloud Storage, BigQuery, Cloud Bigtable.
  - **Management**: Easy interaction through cloud console, SDK, REST API.
  - **Versioning**: Switch between different versions of Spark, Hadoop, and other tools.
  - **High Availability**: Multiple primary nodes, job restart on failure.
  - **Developer Tools**: Cloud console, SDK, RESTful APIs, SSH access.
  - **Customization**: Pre-configured optional components, initialization actions.

### Dataproc Cluster Architecture

- **Cluster Components**:
  - **Primary Nodes**: Run HDFS name node, node and job drivers.
  - **Worker Nodes**: Can be part of a managed instance group.
  - **Preemptible Secondary Workers**: Lower cost but can be preempted anytime.
- **Storage Options**:
  - **Persistent Disks**: Standard storage method.
  - **Cloud Storage**: Recommended over native HDFS for durability.
  - **Cloud Bigtable/BigQuery**: Alternatives for HBase and analytical workloads.
- **Cluster Lifecycle**:
  - **Setup**: Create clusters via cloud console, command line, YAML files, Terraform, or REST API.
  - **Configuration**: Specify region, zone, primary node, worker nodes.
  - **Initialization**: Customize with initialization scripts and metadata.
  - **Optimization**: Use preemptible VMs and custom machine types to balance cost and performance.
  - **Utilization**: Submit jobs through console, command line, REST API, or orchestration services.
  - **Monitoring**: Cloud Monitoring for job and cluster metrics, alert policies for incidents.

### Key Features of Dataproc

- **Low Cost**: Pay-per-use with second-by-second billing.
- **Fast Cluster Operations**: 90 seconds or less to start, scale, or shut down.
- **Flexible and Resizable**: Variety of VM types, disk sizes, and networking options.
- **Integration with Google Cloud**: Seamless interaction with other Google Cloud services.
- **Ease of Use**: Minimal learning curve, supports existing Hadoop tools.
- **High Availability and Reliability**: Multiple primary nodes, restart able jobs.
- **Developer-Friendly**: Multiple ways to manage clusters, customizable via scripts and metadata.

### Using Google Cloud Storage Instead of HDFS

#### Network Evolution and Data Proximity

- **Original Network Speeds**: Slow, necessitating data to be close to the processor.
- **Modern Network Speeds**: Petabit networking enables independent storage and compute.
- **On-Premise Hadoop Clusters**: Require local storage on disks as the same server handles compute and storage.

#### Cloud Migration and HDFS

- **Lift-and-Shift**: Moving Hadoop workloads to Dataproc with HDFS requires no code changes but is a short-term solution.
- **Long-Term Issues with HDFS in Cloud**:
  - **Block Size**: Performance is tied to server hardware, not elastic.
  - **Data Locality**: Storing data on persistent disks limits flexibility.
  - **Replication**: HDFS requires three copies for high availability, leading to inefficiency.

#### Advantages of Cloud Storage over HDFS

- **Network Efficiency**: Google’s Jupyter network fabric offers over one petabit per second bandwidth.
- **Elastic Storage**: Cloud Storage scales independently of compute resources.
- **Cost Efficiency**: Pay only for what you use, unlike HDFS which requires overprovisioning.
- **Integration**: Cloud Storage integrates seamlessly with various Google Cloud services.

#### Considerations for Using Cloud Storage

- **Latency**: High throughput but significant latency; suitable for large, bulk operations.
- **Object Storage Nature**:
  - Renaming objects is expensive due to immutability.
  - Cannot append to objects.
- **Output Committers**: New object store-oriented committers help mitigate directory rename issues.

#### Data Transfer and Management

- **DistCp Tool**: Essential for moving data; push-based model preferred for known necessary data.
- **Data Management Continuum**:
  - Pre-2006: Big databases for big data.
  - 2006: Distributed processing with Hadoop.
  - 2010: BigQuery launch.
  - 2015: Google’s Dataproc for managed Hadoop and Spark clusters.

### Ephemeral Clusters

- **Ephemeral Model**: Utilize clusters as temporary resources, reducing costs by not paying for idle compute capacity.
- **Workflow Example**: Use Cloud Storage for initial and final data, with intermediate processing in local HDFS if needed.

#### Cluster Optimization

- **Data Locality**: Ensure Cloud Storage bucket and Dataproc region are physically close.
- **Network Configuration**: Avoid bottlenecks by ensuring traffic isn’t funneled through limited gateways.
- **Input File Management**:
  - Reduce the number of input files (<10,000) and partitions (<50,000) if possible.
  - Adjust `fs.gs.block.size` for larger datasets.

#### Persistent Disks and Virtual Machines

- **Disk Size**: Choose appropriate persistent disk size to avoid performance limitations.
- **VM Allocation**: Prototype and benchmark with real data to determine optimal VM size.
- **Job-Scoped Clusters**: Customize clusters for specific tasks to optimize resource use.

#### Local HDFS vs. Cloud Storage

- **Local HDFS**: Better for jobs requiring frequent metadata operations, small file sizes, or heavy I/O workloads with low latency needs.
- **Cloud Storage**: Ideal for the initial and final data source in pipelines, reducing disk requirements and saving costs.

### Autoscaling and Templates

- **Workflow Templates**: Automate cluster creation, job submission, and cluster deletion.
- **Autoscaling**: Scale clusters based on YARN metrics, providing flexible capacity and improving resource utilization.
- **Initial Workers**: Set the number of initial workers to ensure basic capacity from the start.

### Monitoring and Logging

- **Cloud Logging**: Consolidates logs for easy error diagnosis and monitoring.
- **Custom Dashboards**: Use Cloud Monitoring to visualize CPU, disk, and network usage, and YARN resources.
- **Application Logs**: Retrieve Spark job logs from the driver output, Cloud Console, or Cloud Storage bucket.

## Serverless Data Processing with Dataflow

- **Dataflow Overview:**

  - **Serverless:** Dataflow is serverless, eliminating the need to manage clusters.
  - **Scaling:** Scales step by step, fine-grained scaling unlike Data Proc.
  - **Unified Processing:** Supports both batch and stream processing with the same code.

- **Choosing Between Dataflow and DataProc:**

  - **Recommendation:** Use Dataflow for new pipelines due to serverless benefits.
  - **Existing Hadoop Pipelines:** Consider Data Proc for migration and modernization.
  - **Decision Factors:** Depends on existing technology stack and operational preferences.

- **Unified Programming with Apache Beam:**

  - **Historical Context:** Batch processing (1940s) vs. stream processing (1970s).
  - **Apache Beam:** Unifies batch and stream processing concepts.
  - **Core Concepts:** P transforms, P collections, pipelines, and pipeline runners.

- **Immutable Data and Distributed Processing:**
  - **P collections:** Immutable distributed data abstractions in Dataflow.
  - **Serialization:** All data types are serialized as byte strings for efficient network transfer.
  - **Processing Model:** Each transform creates a new P collection, enabling distributed processing.

### Why Customers Value Dataflow

- **Efficient Execution and Optimization:**

  - **Pipeline Execution:** Dataflow manages job execution from data source to sink.
  - **Optimization:** Optimizes job graph, fuses transforms, and dynamically rebalances work units.
  - **Resource Management:** On-demand deployment of compute and storage resources per job.

- **Reliability and Fault Tolerance:**

  - **Continuous Optimization:** Ongoing optimization and rebalancing of resources.
  - **Fault Tolerance:** Handles late data arrivals, with automatic restarts and monitoring.
  - **Auto-Scaling:** Scales resources dynamically during job execution, improving job efficiency.

- **Operational Efficiency and Integration:**
  - **Managed Service:** Fully managed and auto-configured service, reducing operational overhead.
  - **Integration:** Acts as a central component connecting various Google Cloud services.
  - **Use Cases:** Supports diverse use cases from BigQuery to Cloud SQL seamlessly.

### Building Dataflow Pipelines in Code

### Constructing a Dataflow Pipeline

- **Pipeline Construction:**

  - **Python Syntax:** Use pipe symbols (`|`) to chain P transforms from an input P collection.
  - **Java Syntax:** Use `.apply()` method instead of pipe symbols.

- **Branching in Pipelines:**

  - **Multiple Transform Paths:** Apply the same input P collection to different transforms.
  - **Named Outputs:** Store results in separate P collection variables (`Pcollection_out1`, `Pcollection_out2`).

- **Pipeline Initialization and Termination:**
  - **Pipeline Start:** Begin with a source to fetch the initial P collection (e.g., `readFromText`).
  - **Pipeline End:** Terminate with a sink operation (e.g., writing to a text file in cloud storage).
  - **Context Management:** Use Python `with` clause to manage pipeline execution context.

### Key Considerations in Pipeline Design

- **Data Sources and Sinks:**

  - **Reading Data:** Utilize `beam.io` to read from various sources like text files, Pub/Sub, or BigQuery.
  - **Writing Data:** Specify sinks such as BigQuery tables using `beam.io.WriteToBigQuery`.

- **Transforming Data with PTransforms:**

  - **Mapping Data:** Use `Map` to apply a function to each element in the P collection.
  - **Flat Mapping:** Apply `FlatMap` to handle one-to-many relationships, flattening results.
  - **ParDo Transformation:** Custom processing on each element, with serialization and thread safety ensured.
  - **DoFn Class:** Define distributed processing functions, ensuring they are serializable and idempotent.

- **Handling Multiple Outputs:**
  - **Branching and Outputs:** Output different types or formats from a single P collection using `ParDo`.

### Aggregate with GroupByKey and Combine

- **Dataflow Model**: Utilizes a shuffle phase after the map phase to group together like keys.

  - Operates on a PCollection of key-value pairs (tuples).
  - Groups by common key, returning a key-value pair where the value is a group of values.

- **Example**: Finding zip codes associated with a city.

  - **Key-Value Pair Creation**: Create pairs and group by key.
  - **Data Skew Issue**:
    - **Small Scale**: Manageable with 1 million items.
    - **Large Scale**: 1 billion items can cause performance issues.
    - **High Cardinality**: Performance concerns in queries with billions of records.

- **Performance Concern**:

  - Grouping by key causes unbalanced workload among workers.
  - **Example**:
    - 1 million X values on one worker.
    - 1,000 Y values on another worker.
  - **Inefficiency**: Idle worker waiting for the other to complete.

- **Dataflow Optimization**:

  - Design applications to divide work into aggregation steps.
  - Push grouping towards the end of the processing pipeline.

- **CoGroupByKey**: Similar to GroupByKey but groups results across multiple PCollections by key.

- **Combine**: Used to aggregate values in PCollections.

  - **Combine Variants**:
    - **Combine.globally()**: Reduces a PCollection to a single value.
    - **Combine.perKey()**: Similar to GroupByKey but combines values using a specified function.
  - **Prebuilt Combine Functions**: For common operations like sum, min, and max.
  - **Custom Combine Function**: Create a subclass of CombineFn for complex operations.
    - **Four Operations**:
      1. **Create Accumulator**: New local accumulator.
      2. **Add Input**: Add input to the accumulator.
      3. **Merge Accumulators**: Merge multiple accumulators.
      4. **Extract Output**: Produce final result from the accumulator.
  - **Efficiency**: Combine is faster than GroupByKey due to parallelization.
  - **Custom Combine Class**: For operations with commutative and associative properties.

- **Flatten**: Merges multiple PCollection objects into a single PCollection, similar to SQL UNION.

- **Partition**: Splits a single PCollection into smaller collections.
  - **Use Case**: Different processing for different quartiles.

### Side Inputs and Windows of Data

- **Side Inputs**: Additional inputs to a ParDo transform.
  - **Use Case**: Inject additional data at runtime.
  - **Example**:
    - Compute average word length.
    - Use as side input to determine if a word is longer or shorter than average.
- **Dataflow Windows**:
  - **Global Window**: Default, not useful for unbounded PCollections (streaming data).
  - **Time-based Windows**:
    - Useful for processing streaming data.
    - **Example**: Sliding Windows - `beam.WindowInto(beam.window.SlidingWindows(60, 30))`.
      - Capture 60 seconds of data, start new window every 30 seconds.
    - **Fixed Windows**: Example - group sales by day.

### Creating and Re-using Pipeline Templates

- **Dataflow Templates**: Enable non-developers to execute dataflow jobs.
  - **Workflow**:
    - Developer creates pipeline with Dataflow SDK (Java/Python).
    - Separate development from execution activities.
  - **Benefits**:
    - Simplifies scheduling batch jobs.
    - Allows deployment from environments like App Engine, Cloud Functions.
- **Custom Templates**:
  - **Value Providers**: Parse command-line or optional arguments.
  - **Runtime Parameters**: Convert compile-time parameters for user customization.
  - **Metadata File**: Describes template parameters and functions for downstream users.

## Manage Data Pipelines with Cloud Data Fusion and Cloud Composer

- **Cloud Data Fusion** provides a **graphical user interface** and **APIs** to build, deploy, and manage data integration pipelines efficiently.
- **Users**: Developers, Data Scientists, Business Analysts
  - **Developers**: Cleanse, match, remove duplicates, blend, transform, partition, transfer, standardize, automate, and monitor data.
  - **Data Scientists**: Visually build integration pipelines, test, debug, and deploy applications.
  - **Business Analysts**: Run at scale, operationalize pipelines, inspect rich integration metadata.
- **Benefits**:
  - **Integration**: Connects with a variety of systems (legacy, modern, relational databases, file systems, cloud services, NoSQL, etc.).
  - **Productivity**: Centralizes data from various sources (e.g., BigQuery, Cloud Spanner).
  - **Reduced Complexity**: Visual interface for building pipelines, code-free transformations, reusable templates.
  - **Flexibility**: Supports on-prem and cloud environments, interoperable with open-source software (CDAP).
  - **Extensibility**: Template pipelines, create conditional triggers, manage and create plugins, custom compute profiles.

### Components of Cloud Data Fusion

- **User Interface Components**:
  - **Wrangler UI**: Explore datasets visually, build pipelines with no code.
  - **Data Pipeline UI**: Draw pipelines on a canvas.
  - **Control Center**: Manage applications, artifacts, and datasets.
  - **Pipeline Section**: Developer studio, preview, export, schedule jobs, connector, function palette, navigation.
  - **Integration Metadata**: Search, add tags and properties, see data lineage.
  - **Hub**: Available plugins, sample use cases, prebuilt pipelines.
  - **Administration**: Management (services, metrics) and configuration (namespace, compute profiles, preferences, system artifacts, REST client).

### Building a Pipeline

- **Pipeline Representation**: Visual series of stages in a **Directed Acyclic Graph (DAG)**.
  - **Nodes**: Different types (e.g., data from cloud storage, parse CSV, join data, sync data).
  - **Canvas**: Area for creating and chaining nodes.
  - **Mini Map**: Navigate large pipelines.
  - **Pipeline Actions Tool Bar**: Save, run, and manage pipelines.
  - **Templates and Plugins**: Use pre-existing resources to avoid starting from scratch.
  - **Preview Mode**: Test and debug pipelines before deployment.
  - **Monitoring**: Track health, data throughput, processing time, and anomalies.
  - **Tags Feature**: Organize pipelines for quick access.
  - **Concurrency**: Set maximum number of concurrent runs to optimize processing.

### Exploring Data Using Wrangler

- **Wrangler UI**: For exploring and analyzing new datasets visually.
  - **Connections**: Add and manage connections to data sources (e.g., Google Cloud Storage, BigQuery).
  - **Data Exploration**: Inspect rows and columns, view sample insights.
  - **Data Transformation**: Create calculated fields, drop columns, filter rows using directives to form a transformation recipe.
  - **Pipeline Creation**: Convert transformations into pipelines for regular execution.

### Example Pipeline

- **Twitter Data Ingestion**:
  - Ingest data from Twitter and Google Cloud.
  - Parse tweets.
  - Load into various data sinks.
- **Health Monitoring**:
  - View start time, duration, and summary of pipeline runs.
  - Data throughput at each node.
  - Inputs, outputs, and errors per node.
- **Streaming Data Pipelines**: Future modules will cover streaming data pipelines.

### Key Metrics and Features

- **Metrics**: Records out per second, average processing time, max processing time.
- **Automation**: Set pipelines to run automatically at intervals.
- **Field Lineage Tracking**: Track transformations applied to data fields.

#### Example: Campaign Field Lineage

- Track every transformation before and after the field.
- View the lineage of operations between datasets.
- Identify time of last change and involved input fields.

### Summary

- **Cloud Data Fusion**: Efficient, flexible, and extensible tool for building and managing data pipelines.
- **User Interfaces**: Wrangler UI for visual exploration, Data Pipeline UI for pipeline creation.
- **Building Pipelines**: Use DAGs, nodes, canvas, templates, and plugins for streamlined pipeline creation.
- **Wrangler for Exploration**: Visual data exploration and transformation using directives.
- **Monitoring and Automation**: Track metrics, automate runs, and manage concurrency for optimized processing.
- **Field Lineage Tracking**: Detailed tracking of data transformations for comprehensive data management.

## Orchestrating Work Between Google Cloud Services with Cloud Composer

### Overview

- **Orchestration**: Managing multiple Google Cloud services (e.g., data fusion pipelines, ML models) in a specified order.
- **Cloud Composer**: Serverless environment running **Apache Airflow** for workflow orchestration.

### Apache Airflow Environment

- **Launching Cloud Composer**: Can be done via command line or Google Cloud web UI.
- **Environment Variables**: Edited at Apache Airflow instance level, not Cloud Composer level.
- **Components**:
  - **Airflow Web Server**: Access via Cloud Composer to monitor and interact with workflows.
  - **DAGs Folder**: Cloud storage bucket for storing Python DAG files.

### DAGs and Operators

- **DAGs (Directed Acyclic Graphs)**:
  - Represent workflows in Airflow.
  - Consist of tasks invoking predefined operators.
- **Operators**:
  - **BigQuery Operators**: Used for data querying and related tasks.
  - **Vertex AI Operators**: Used for retraining and deploying ML models.
  - **Common Operators**: Atomic tasks, often one operator per task.

#### Sample DAG File

```python
from airflow import DAG
from airflow.operators.dummy import DummyOperator
from airflow.operators.python import PythonOperator
from datetime import datetime

def process_data():
    ## Your data processing code here
    pass

default_args = {
    'start_date': datetime(2023, 1, 1),
}

dag = DAG(
    'example_dag',
    default_args=default_args,
    schedule_interval='@daily',
)

start = DummyOperator(task_id='start', dag=dag)
process = PythonOperator(task_id='process', python_callable=process_data, dag=dag)
end = DummyOperator(task_id='end', dag=dag)

start >> process >> end
```

### Workflow Scheduling

#### Periodic Scheduling

- **Description**: Set schedule (e.g., daily at 6 a.m.).

#### Event-Driven Scheduling

- **Description**: Triggered by events (e.g., new CSV files in cloud storage).

#### Event-Driven Example

- **Cloud Function**: Watches for new files in a Cloud Storage bucket and triggers a DAG.

```javascript
const { google } = require("googleapis");
const dataflow = google.dataflow("v1b3");
const PROJECT_ID = "your-project-id";
const LOCATION = "your-location";
const TEMPLATE_PATH = "gs://your-template-path";
const BUCKET_NAME = "your-bucket-name";

exports.triggerDAG = async (event, context) => {
  const file = event.name;
  const metadata = {
    projectId: PROJECT_ID,
    location: LOCATION,
    templatePath: TEMPLATE_PATH,
    gcsPath: `gs://${BUCKET_NAME}/${file}`,
  };

  const request = {
    projectId: metadata.projectId,
    location: metadata.location,
    gcsPath: metadata.templatePath,
    requestBody: {
      parameters: {
        inputFile: metadata.gcsPath,
      },
    },
  };

  try {
    const response = await dataflow.projects.locations.templates.launch(
      request
    );
    console.log(`Job launched successfully: ${response.data.job.id}`);
  } catch (err) {
    console.error(`Error launching job: ${err}`);
  }
};
```

### Monitoring and Logging

#### Monitoring DAG Runs

- **Check status**: Monitor DAGs for success, running, or failure states and troubleshoot accordingly.
- **Logs**: Available for each task and overall workflow.

#### Google Cloud Logs

- **Usage**: Diagnose errors with Cloud Functions and other services.

#### Troubleshooting Example

- **Error Detection**: Use logs to identify and correct issues (e.g., missing output bucket).
- **Case Sensitivity**: Ensure correct naming in Cloud Functions.
