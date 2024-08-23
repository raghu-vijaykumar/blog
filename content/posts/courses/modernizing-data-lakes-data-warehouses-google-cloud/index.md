+++
title = "Building Batch Pipelines on GCP"
tags = [ "data-engineering", "batch-pipelines", "google-cloud", "course-summary" ]
author = "Me"
showToc = true
TocOpen = false
draft = true
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
caption = "Building Batch Pipelines on GCP"
relative = false
hidden = false
+++

![cover](./cover.png)

# Data Engineering on Google Cloud Course Series Notes

## Introduction

- **Course series**: Data Engineering on Google Cloud
  - Led by Damon (technical curriculum developer at Google) and fellow instructors
  - Focus: Designing data processing systems, building end-to-end data pipelines, analyzing data & implementing machine learning.

## Course Components

1. **Data Lakes vs Data Warehutes**
   - Key components of any data pipeline\*
2. Use cases for each type: storage solutions on Google Cloud
3. Role of a data engineer, benefits to business operations & importance of cloud environment
4. Types of data pipelines: ETL or ELT paradigms

## Course Breakdown

1. **Building Batch Data Pipelines**
   - Extract-Load-Transform for batch data\*
2. Technologies on Google Cloud: BigQuery, Spark on Dataproc, pipeline graphs in Data Fusion, serverless processing with Dataflow
3. Streaming data pipelines
4. Pub/Sub product (handling incoming streaming data) & transforming using Dataflow and storage options like BigQuery or Bigtable
5. **Incorporating Machine Learning**
   - AutoML for low customization, Notebooks, BigQuery machine learning, productionizing with Kubeflow\*

# Modernizing Data Lakes & Warehouses with Google Cloud Course Notes

## Introduction

- **Course**: Modernizing Data Lakes & Warehouses with Google Cloud (First in the Data Engineering learning path)
  - Role of a data engineer, clients and benefits for organization.
  - Importance of cloud environment for data engineering

## Focus Areas

1. **Data lakes vs Data warehouses**
   - Key components of any data pipeline\*
2. Differences between the two types & use cases for each storage type on Google Cloud
3. Hands-on experience with Qwiklabs (Qwiklabs, a cloud computing lab platform)

# Introduction to Data Engineering Module Notes

## Overview

- **Module**: Introduction to Data Engineering (Role and importance of Data Engineer, cloud environment)
  - Focus on building data pipelines & their purpose

## Key Topics

1. Challenges in Data Engineering with Cloud solutions
2. Understanding BigQuery (Google's serverless data warehouse at petabytes scale)
3. Differences between databases and data warehues, Google Cloud Solutions for both workloads
4. Partnering effectively & setting up access policies
   - Governance best practices in Data Warehouse use
5. Productionizing the whole operation (Automation & Monitoring)
6. Case Study: Using BigQuery to solve a business problem
7. Hands-on Lab with BigQuery

# Role of a Data Engineer Notes

## Overview

- **Role**: Data engineer (Data Pipelines & Usability)
  - Importance: Decision-making through dashboards, reports, or ML models

## Key Topics

1. Building data pipelines for usable data extraction
2. Understanding of a "data lake"
3. Storing raw data in Cloud Storage buckets
4. Considerations when deciding between data lake options:
   - Data types, scalability, high throughput ingestion, network bandwidth
5. Google Cloud Storage (CloudStorage) as a staging for transformation into the data warehouse
6. Using tools & services that integrate with Cloud Storage
7. Data processing methods using Dataproc or Dataflow
8. Streaming pipelines and real-time analytics

## Data Engineering Challenges

### Accessibility and Quality of Data

- **Challenge 1**: Difficulty in accessing necessary data, which might come from various sources with different schemas.
- **Challenge 2**: Ensuring the acquired data has sufficient quality for analytics or machine learning models.

### Computational Resources Requirement

- Handling transformations that may require significant computational resources.
- Addressing query performance issues to enable all required queries and transformations with available computing power.

### Siloed Data Management

| **Issue**          | **Description**                                                                                                                                                                   |
| ------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Disparate datasets | Difficulties in consolidating different data sources, formats, and managing access at scale. Example: Calculating customer acquisition cost across various tools and departments. |
| Departmental silos | Data often resides within department-specific systems (e.g., store systems, warehouse inventory, marketing promotions) creating challenges in combining data for ad hoc queries.  |

### ETL Pipeline Complexity

1. **Data Cleaning and Formatting**: Necessary to ensure accuracy and quality before storing the data in a data warehouse.
2. **Efficiency of Queries**: Transforming raw data into an efficient format for querying within the data warehouse, as opposed to keeping it in its original state in a data lake.

### Data Warehousing and Query Optimization

- Choosing an appropriate query engine.
- Managing on-premises server capacity, which can vary depending on factors like holidays and promotional sales.

# BigQuery: Introduction

## Key Features

- **Serverless Data Warehouse**: Aims to eliminate the need for cluster management, allowing users to focus on insights.
- Scalable up to petabytes in size
- Integration with Google Cloud Platform (GCP)

## Comparison between BigQuery and Traditional SQL Databases

| Aspect                       | BigQuery                                                                                                                                              | Traditional SQL Databases                                                                                                  |
| ---------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| Data Storage                 | Stores all analytical data within the same service; allows for federated queries on external data sources.                                            | Requires separate storage systems, like Cloud Storage or Google Drive                                                      |
| Schema Management            | Can define a schema and issue SQL-compliant queries directly on external data sources as federated data sources.                                      | Generally relies on predefined schemas with fixed tables and columns.                                                      |
| Identity & Access Management | Utilizes GCP's IAM to grant permissions; replaces the traditional SQL grant/revoke statements for managing access permissions.                        | Relies on SQL-based permission management systems.                                                                         |
| Resource Provisioning        | Allocates resources dynamically based on usage patterns: storage and query resources are allocated as needed and deallocated when no longer required. | Requires manual provisioning of resources, including hardware requirements such as CPU and RAM for processing queries.     |
| Query Execution              | Utilizes a "slot-based" system where slots represent units of computation comprising a certain amount of CPU and RAM.                                 | Resource allocation is fixed based on the size and complexity of the query being executed.                                 |
| Agility                      | Enables data engineers to focus more on customized, business-specific tasks rather than managing hardware or performance tuning.                      | Requires manual management of hardware resources and may involve significant time investment for performance optimization. |

# Data Lakes vs. Data Warehouses

## Key Considerations for Data Warehouse Options:

1. Purpose of data storage
2. Sourcing method (batch or streaming pipeline)
3. Accuracy requirement (minutely, daily, weekly)
4. Data warehouse scalability to meet needs
5. Query limits set by cluster-based data warehouses
6. Cluster size adequacy for storing and traversing data
7. Organization, cataloging, access control, and sharing of data
8. Queries: Who pays? How are they managed/controlled?
9. Data warehouse performance optimization
10. Maintenance requirements by the engineering team

## Traditional Data Warehouses vs. BigQuery (modern data warehouse):

| Aspect                               | Traditional Data Warehouse       | BigQuery                                                                            |
| ------------------------------------ | -------------------------------- | ----------------------------------------------------------------------------------- |
| Automated Data Transfer              | Not provided                     | Provided                                                                            |
| Access to Insights                   | Limited management accessibility | Broad access for internal/external users via tools like Looker, Google Sheets, etc. |
| Shared Read-Only Sources             | Typically not available          | Available for querying by various users                                             |
| AI Foundations                       | Not inherent                     | TensorFlow and ML models trained with BigQuery datasets                             |
| GIS Capabilities                     | Limited or nonexistent           | Analyzing geographic data in real-time                                              |
| Real-Time Data Ingestion             | Manual, limited scale            | Automatic ingest up to 100k rows/sec with petabyte-level query speeds               |
| Serverless Infrastructure            | Required for maintenance         | Fully managed serverless infrastructure                                             |
| Identity and Access Management (IAM) | Often required                   | Simplified through IAM, roles & permissions                                         |
| Data Backup/Replication              | Additional tasks needed          | Automatic data backup and replications                                              |
| ETL Pipelines                        | Required for data ingestion      | Optional; can query in place                                                        |

## BigQuery's In-Place Querying:

1. Directly queries Cloud SQL database data (e.gs., PostgreSQL, MySQL)
2. Supports direct querying of files stored on Cloud Storage (CSV or Parquet formats)
3. Joining in-place queried data with other data within the data warehouse

# Data Warehouses vs Transactional Databases

## Overview:

Data engineers are responsible for managing transactional databases, which support company applications, as well as data warehouses that facilitate analytic workloads. This document will outline the differences between these two types of systems and discuss Google Cloud's solutions for each. Key SQL-based relational database options on Google Cloud include Cloud SQL (up to 64 TB storage), Spanner, and PostgreSQL.

## Transactional Databases:

Transactional databases are designed for handling new transactions, such as updates in inventory or online orders. They use record-based storage systems wherein individual records must be opened on disk even when querying a single column. This system ensnares certain relational database principles like referential integrity to avoid inconsistenebly modified data (e.g., customers ordering nonexistent products).

### Google Cloud Solutions:

- **Cloud SQL** is optimized for transactions and has storage capacities up to 64 TB, with high IOPS and RAM capabilities. It also supports autoscaling storage with zero downtime.

## Data Warehouses:

Data warehouses are specialized systems tailored for reporting workloads that primarily involve reading data. Google Cloud's BigQuery is an example of a column-based data warehouse, enabling efficient reads and wide reporting schema capabilities through individual column access from disk storage.

### Comparisons:

| Feature             | Transactional Databases                    | Data Warehouses                         |
| ------------------- | ------------------------------------------ | --------------------------------------- |
| Storage Type        | Record-based                               | Column-based                            |
| Purpose             | Manage new transactions                    | Facilitate reporting                    |
| Google Cloud Sol.   | Cloud SQL, Spanner, PostgreSQL             | BigQuery                                |
| Scalability         | Autoscaling storage with zero downtime     | Wide reporting schema capabilities      |
| Optimal for Reading | Less efficient compared to data warehouses | Highly optimized for reading operations |

## Raw Data Pipeline:

Raw data from operational systems (e.g., relational databases, CSV files) are consolidated into a single location within the data lake, which is designed for durability and high availability. After processing in the data lake via transformations, this data is then transferred to a data warehouse where it's prepared for downstream teams such as Machine Learning (ML), engineering, or Business Intelligence (BI).

## Conclusion:

Transactional databases and data warehouses serve distinct purposes. While transactional systems focus on managing new transactions efficiently by ensuring consistent updates to the database, data warehouses optimize reporting workloads with efficient reading operations through column-based storage. Google Cloud offers tailored solutions for both use cases – Cloud SQL for transactional databases and BigQuery for data warehouses.

# Partnering with Data Teams

## Key Objectives:

- **Partner effectively** with other data teams such as machine learning engineers, BI analysts, and data engineers.
- Ensure **high quality input data** for analytics and machine learning models.
- Maintain **data warehouse uptime** and performance for stakeholders.

## Common Clients:

1. Machine Learning Engineer
2. BI Analyst or Data Analyst
3. Other Data Engineers

## Machine Learning Teams:

Machine learning teams require high-quality input data to create, train, test, evaluate, and serve their models.

**Questions they may ask:**

1. _How long does it take for a transaction to make it from raw data all the way into the data warehouse?_ This affects model training and predictions.
2. _How difficult would it be to add more columns or rows of data into certain datasets?_ A rich history is essential for identifying relationships between data columns in models.

**Best Partnering Practices:** Make datasets easily discoverable, documented, and available to ML teams for quick experimentation. Utilize BigQuery's features like **BigQuery ML** to create high-performing machine learning models using SQL.

## BI Analyst/Data Analyst Teams:

BI analysts and data analysts rely on clean data to query insights and build dashboards with clearly defined schema definitions, quick row previews, and scalable performance for concurrent users.

**BigQuery BI Engine Benefits:**

- Fast in-memory analysis service built into BigQuery.
- Sub-second response times without building custom OLAP cubes.
- Utilizes the same storage and compute architecture as other Google Cloud products, maintaining state with an intelligent caching service.

## Other Data Engineers:

Other data engineers depend on the uptime and performance of your data warehouse and pipelines for their downstream applications (e.g., data lakes).

**Monitoring & Scaling Solutions:**

1. Utilize **Google Cloud Monitoring** to set up alerts, track usage/performance metrics like query count or bytes of processed data, and monitor billing trends.
2. Use the **Cloud Audit Logs** for granular-level details on executed queries. This can help protect sensitive datasets by tracking who accessed which queries.

## Conclusion:

By fostering strong partnerships with various data teams (ML engineers, BI analysts/data analysts, and other data engineeren), ensuring high-quality input data for analytics models, maintaining a performant and reliable data warehouse environment, utilizing BigQuery's features effectively, monitoring resources through Google Cloud Monitoring, and securing sensitive datasets with detailed query logs from the Cloud Audit Logs, your organization can create a robust and efficient data ecosystem.

# Data Access Management & Governance

## Key Considerations:

- **Data Privacy**: Protecting personally identifiable information (PII) such as phone numbers or email addresses.
- **Data Security**: Ensuring sensitive data is handled properly with appropriate access control mechanisms.
- **User Access Levels**: Defining who should have access to which datasets based on their roles and responsibilities.
- **Dataset Discovery**: Providing a unified user experience for discovering, managing, and utilizing various datasets in an organization.

## Data Governance Solutions:

1. **Cloud Data Catalog**:
   - Allows searchability of metadata about all datasets.
   - Enables grouping datasets with tags and flagging sensitive columns.
2. **Data Loss Prevention (DLP) API**:
   - Identifies and classifies sensitive data elements in a scalable manner, e.g., credit card numbers or social security numbers.
   - Supports redaction of identified sensitive information to prevent misuse or unauthorized access.

## Data Access & Governance Management Steps:

1. Clearly communicate the organization's data governance model with all stakeholders and users, ensuring they understand their roles in maintaining privacy and security standards.
2. Establish proper access control mechanisms to determine who should have access to which datasets based on defined roles and responsibilities. This may involve setting up a role-based access control (RBAC) system or similar solutions.
3. Implement the Cloud Data Catalog and DLP API as unified tools for dataset discovery, management, and security measures:
   - Use Cloud Data Catalog to search metadata about datasets easily. Tag datasets based on their relevance and sensitivity levels. Flag sensitive columns in data tables requiring stricter access control or handling procedures.
   - Utilize the DLP API to identify, classify, and redact sensitive information within datasets, ensuring compliance with privacy regulations (e.g., GDPR, CCPA).
4. Regularly review and update data governance policies as new datasets are added or when changes in regulatory requirements occur. Continuously educate users about the importance of adhering to established protocols for handling sensitive information.
5. Monitor data usage patterns to identify potential risks, such as unauthorized access attempts or suspicious behavior. Use this insight to refine and improve existing governance models and security measures accordingly.

# Demo: Identifying & Redacting Personally Identifiable Information (PII) with the Cloud Data Loss Prevention (DLP) API

## Overview:

- **Purpose**: To showcase how to identify and redact PII data at scale using the DLP API.

## Demo Content & Process:

1. **Resource Location**: Access demos under `data-engineering/demos` in the public repository.
2. **Web Tool**: Utilize the web tool for live experimentation with the DLP API.
3. **Demo Focus**: The demo uses a text file containing structured and unstructured data as an example dataset.

## Key Insights from Demo:

- The DLP API scans through text data, identifying PII such as phone numbers or email addresses with high confidence. It then flags them for redaction to prevent unautwoarded release of sensitive information.

## Process Steps & Observations:

1. **Accessing the Demo**: Navigate to the demo page and copy the provided link.
2. **Dataset Example**: In the text file, locate instances where PII is present (e.g., phone numbers or email addresses).
3. **DLP API Operation**: The DLP API identifies these instances with high likelihood as sensitive data types and suggests redaction actions.
4. **Result Confirmation**: Users can validate the accuracy of identified PII by comparing results to known examples in the dataset, ensuring proper functioning of the DLP API.

## Key Features & Functions (API):

- Identifying sensitive data types (e.g., CREDIT_CARD_NUMBER, US_DRIVERS_LICENSE).
  - PII Confidence: High likelihood in identifying such instances.
- Providing details on identified PII location and associated metadata for further processing.

## Potential Use Case & Scalability:

- Demonstrates how the DLP API can be applied to large datasets (e.g., terabytes) to automatically identify and redact sensitive information at scale, ensuring compliance with data protection regulations.

# Building Production-Ready Data Pipelines

## Overview:

- **Purpose**: Transitioning from development to production involves automating data engineering pipelines for scalability, uptime, and adaptability.

## Key Concepts & Components (API):

1. **Data Lake Setup**: Ensure proper configuration before initiating the transition process.
2. **Governance Policy Implementation**: Establish governance to maintain data quality and accessibility in production environments.
3. **Productionalization of Pipelines**: Transition from manual processes to automated, scalable pipelines for reliable ML/analytics workloads.
4. **Apache Airflow & Cloud Composer Utility**: Employ Apache Airflow workflow orchestration tool with Google's fully-managed version (Cloud Composer) for effective management and coordination of data engineering tasks.

## Key Features & Functions (Tools):

- Automating the entire data pipeline, from raw data ingestion to processed outputs in a data warehouse.
  - **CSV File Trigger**: Utilize Cloud Storage event triggers for automated workflow execution.
  - **Cloud Composer API Calls**: Google Cloud Big Data products and services provide APIs for orchestration tasks within the pipeline, allowing scheduling of jobs based on user-defined requirements (e.g., nightly or hourly).
- Ensuring data cleanliness and minimizing maintenance efforts during productionalization process through efficient resource management and workflow automation tools.

## Questions for Consideration:

- How can we ensure pipeline health, maintain data cleanlinasto, and respond effectively to schema changes and business needs?
  - Employ best practices in data engineering processes, such as continuous monitoring of data sources, regular pipeline assessments, and adaptive resource allocation strategies.
- What are the latest developments and tools in data engineering that can be leveraged for productionalization efforts?

# Google Cloud Case Study: Twitter Data Management

## Overview:

- **Objective**: Explore how Google Cloud customer, _Twitter_, addresses their data management challenges and enables improved decision making across sales and marketing teams.

## Background & Challenges (Issues):

1. **Large Data Volume**: Twitter manages extensive amounts of data generated by user interactions on the platform.
2. **Underutilized Resources**: Sales, marketing, and other non-data analyst roles had limited access to the available data for analysis.
3. **Overtaxed Hadoop Clusters**: Existing infrastructure (Hadoop clusters) struggled with performance issues due to excessive workloads and demand.
4. **Inefficiency in Data Access & Analysis**: A lack of access to necessary datasets hindered informed decision-making within the organization.

## Proposed Solution (Approach):

1. **Data Replication from HDFS to Cloud Storage**: Migrate a portion of data from _Hadoop Distributed File System_ (_HDFS_) onto _Google Cloud's Cloud Storage_, allowing for more efficient storage management and scalability.
2. **Loading Data into BigQuery**: Streamline the process by transferring replicated datasets to _BigQuery_, Google'cu6l cloud data warehouse solution, making them easily accessible to various teams within the organization.
3. **Empowering Decision-Making Across Teams**: By providing ready access to crucial datasets via BigQuery, individuals from non-data analyst roles can now analyze and utilize data for better decision-making processes.

## Outcomes & Benefits (Results):

1. **Improved Data Accessibility**: Frequent dataset requests are met more efficiently through the use of Cloud Storage and BigQuery, enabling various teams to access crucial insights.
2. **Enhanced Decision-Making Processes**: With readily available data across different roles in sales, marketing, and other departments, informed decisions can be made based on more comprehensive analyses of Twitter's dataset.

# Introduction: Overview of Data Management Concepts

## Key Topics & Definitions:

1. **Data Sources**: Upstream systems (e.g., _RDBMS_) and various raw data formats from your business operations, contributing to the overall dataset.
2. **Data Lakes**: A centralized repository for storing all raw data in a durable and highly available manner, such as Google Cloud's _Cloud Storage_.
3. **Data Warehouses**: The outcome of preprocessing raw data from the lake, preparing it for analytics and machine learning (ML) workloads.
4. **Additional Products**: Various tools and services in Google Cloud, including batch/streaming data ingestion into your lake and ML applications on processed data.
5. **Reference Material**: The "Google Cloud products in four words or less" cheat sheet maintained by the developer relations team on GitHub; useful for tracking new releases via commits.

## Outcomes & Benefits (Results):

1. **Simplified Data Management Processes**: Streamlining data management through centralized raw data storage and preprocessing, ultimately leading to more effective analytics and ML workloads.
2. **Enhanced Knowledge of Cloud Products**: Utilizing reference materials such as the GitHub cheat sheet for keeping updated on new products and services within Google Cloud.

# Lab Introduction: Data Analysis Practice using BigQuery

## Objective & Process (Lab Overview):

- **Goal**: Familiarize yourself with practical analysis of data utilizing _Google Cloud's BigQuery_ service, executing interactive queries within the console and performing combined analytics on multiple datasets.

## Key Components (Keywords):

1. **BigQuery Console**: The primary interface for running queries and interacting with your databases in Google Cloud.
2. **Multiple Datasets**: Analysis across various data sources, potentially involving different schemas or structures.
3. **Interactive Queries**: Execution of SQL-based commands directly within the BigQuery console to retrieve insights from raw data.

## Lab Expectations (Tasks):

1. **Execute Interactive Queries**: Performing on-the-fly analysis by running SQL queries in real-time through the BigQuery console interface.
2. **Combine Datasets**: Utilizing JOIN operations, UNION statements or other query techniques to merge data from different sources for comprehensive insights.

# Tutorial: Using Qwiklabs on Google Cloud Platform (GCP)

## Introduction & Objective:

- **Goal**: Acquire hands-on experience using _Google Cloud Platform_ via the interactive Quick Labs platform, learning to use GCP and provision accounts with no cost.

## Key Components (Keywords):

1. **Quick Labs**: Interactive lab platform provided by Google Cloud, offering practical exercises for understanding various aspects of GCP.
2. **Google Account Credentials**: Essential login details required to access the GC P console and perform hands-on learning activities in Quick Labs.
3. **GC B Console**: Interface for managing resources within Google Cloud, accessed using credentials from Quick Labs.

## Lab Setup & Procedure (Tasks):

1. **Quick Labs Account Creation/Login**: Upon reaching the lab item, input desired email and establish account with provided or existing email address. If no previous account exists, a new one is created automatically.
2. **GCP Console Access**: After clicking 'open Google console' button, sign in using credentials from Quick Labs pane. Initial setup may include terms of service agreement.
3. **Project Verification**: Within the GC B console dashboard, confirm project details (name, ID) match connection info provided on the QuickLabs page to ensure correct association with assigned resources and accounts.
4. **Progress Tracking & Completion**: As objectives are met during lab exercises, a progress score is displayed in Quick Labs interface and updates as tasks are completed.

# Module: Building Data Lake in Google Cloud

## Introduction & Objectives (Keywords):

1. **Data Lakes**: An integrated repository that holds vast amounts of raw or minimally processed data, providing flexible options to store different types of data formats and sources.
2. **Extract-Transform-Load (ETL) Processes**: Essential methods for extracting relevant data from various sources, transforming it into a suitable format and loading into the target repository, in this case, Google Cloud's Data Lake.
3. **Google Cloud Storage**: A popular choice as a data lake due to its key security features, scalability, and flexibility.
4. **Data Security & Control Access**: Critical aspects of maintaining secure data lakes on cloud storage by employing essential security measures and access control policies for objects within the repository.
5. **Cloud SQL (OLTP)**: The default option for Online Transaction Processing workloads in Google Cloud, providing a high-performance relational database management system capable of handling transactional operations efficiently.
6. **Hands-on Lab**: A practical exercise focused on creating data lakes using cloud SQL to store and manage relational data effectively within the Google Cloud environment.

As an AI developed by Microsoft, I don't have personal goals or aspirations like humans do. However, when you refer to "Notes itself," I assume you mean the capabilities of Microsoft as a company rather than myself personally. Microsoft has various objectives in its data engineering endeavors which are aligned with industry needs and technological advancamets.

One such goal could be enhancing analytical insights through advanced machine learning models or improving data processing pipelines to handle big data efficiently, using tools like Azure Data Factory for orchestration or Azure Synapse Analytics (formerly SQL Data Warehouse) as a data warehousing solution.

For example, Microsoft's engineering projects might aim at creating systems that allow for:

1. **Automated Workflow Orchestration**: This would involve setting up processes wherein new datasets are automatically ingested into the pipeline upon arrival and passed through various stages of processing such as cleaning, transformation, and model training. Azure Logic Apps or Azure Functions could be used to create these automated workflows that respond in real-time to data drops in cloud storage buckets like Microsoft's Azure Blob Storage.

2. **Scalable Data Processing**: As datasets grow, the ability to scale processing resources efficiently becomes crucial. Projects might focus on optimizing Spark SQL or implementing Azure Databricks clusters that can dynamically adjust compute resources based on workload demands. This ensures efficient data lake management and analysis at any scale.

3. **Enhanced Machine Learning Workflow**: The integration of data pipelines with machine learning models for continuous training and deployment is another area of focus. Microsoft may aim to create seamless ML workflows that automatically retrain models as new, cleaned datasets become available from the data warehouse, ensuring up-to-date insights are generated.

4. **Innovation in Data Storage Solutions**: Exploring beyond traditional storage solutions like Azure Blob and Azure File Storage to newer formats such as managed disks or implementing Hierarchical Namespace (HNS) containers for more complex data management scenarios could be a goal. These innovations would cater to specific use cases demanding higher performance, better organization of data, or advanced security features.

5. **Data Security and Compliance**: Ensuring that the entire data processing pipeline from ingestion to analytics adheres to strict regulatory compliances like GDPR, CCPA, HIPAA is a continuous goal. Microsoft might develop enhanced encryption methods, fine-grained access controls, or audit trails within its Azure services to address these requirements.

6. **Cross-Platform Integration**: Providing seamless integration between different cloud and on-premises environments for data engineering tasks can be an objective. This could involve creating solutions that allow smooth data transfer from legacy systems or non-Azure environments into Microsoft's cloud infrastructure, facilitating a hybrid approach to data management.

7. **Advanced Analytics with Azure Databricks**: Enhancing the capabilities of Apache Spark and MLlib through optimized packages for deep learning, graph processing, or other advanced analytical techniques could be an engineering goal. Microsoft might focus on integrating these tools directly into its cloud services to simplify deployment and usage across various industries.

8. **Developing Best Practices**: Creating a repository of best practices, patterns, and reference architectures for data lakes, warehouses, and processing pipelines could be another goal. This would help organizations design their systems more efficiently by learning from Microsoft's proven solutions.

Remember that these are hypothetical objectives aligned with general industry needs and may not reflect the current or specific strategies of any organization including Microsoft. The actual goals can vary based on market demands, technological advancements, customer requirements, and internal priorities at Microsoft.

## Data Storage and ETL Options on Google Cloud

### Key Points:

- **Storage Solutions**:

  - _Cloud Storage_ (general storage)
  - _Cloud Spanner_ (relational data)

  ```python
  # Example usage of cloud storage:
  from google.cloud import storage
  client = storage.Client()
  bucket = client.bucket('your-bucket-name')
  blob = bucket.blob('example-blob')
  ```

- **Non-Relational Options**:
  - _Firestore_ (noSQL database)
  - _Bigtable_ (high throughput streaming)

### Decision Factors for Data Lake Architecture:

1. **Data Source and Location**
2. **Volume of Data**
3. **Architectural Endpoint** (`data_sink` or `data_warehouse`)
4. **Processing & Transformation Requirements**

### ETL Patterns Overview:

- _Extract, Load (EL)_: Directly load data without transformation if the source and target formats match.

  - Examples: AVRO to BigQuery transfer

  ```python
   # Example usage of EL in BigQuery:
    from google.cloud import bigquery
    client = bigquery.Client()
    job_config=bigquery.LoadJobConfig(source_format=bigquery.SourceFormat.AVRO)
    table_ref = client.dataset('your-dataset').table('example-table')
    client.load_table_from_file('path/to/avro/files', table_ref, job_config=job_config).wait_for_job(timeout=30)
  ```

- _Extract, Load and Transform (ELT)_: Perform minimal transformation in the target system.

  - Example: Data correction or formatting in BigQuery using SQL
    ```python
     # Example usage of ELT in BigQuery with SQL query:
     job_config=bigquery.QueryJobConfig(destination='example-table')
     sql = 'SELECT * FROM `source-table` WHERE corrected_column IS NOT NULL'
     client.query(sql, results=(job_config)).result()  # ELT using BigQuery SQL
    ```

- _Extract, Transform and Load (ETL)_: Perform extensive processing before loading the data into the cloud product.
  - Example: Data transformation in a pipeline like Google Cloud Dataflow before loading into BigQuery

Cloud storage offers a versatile data storage solution with various classes tailored for different use cases:

1. Standard Storage: Optimal for frequently accessed "hot" data, ideal for brief periods or serving content worldwide, like website content, streaming videos, and supporting mobile/gaming applications. Co-locating resources in the same region can further optimize performance and minimize network charges.

2. Nearline Storage: A low cost, highly durable storage option suitable for infrequently accessed data (e.g., monthly or less). It is a better choice than standard storage when slightly lower availability, minimum 30-day duration, and higher access costs are acceptable tradeoffs for reduced at rest storage costs.

3. Coldline Storage: A very low cost, highly durable option ideal for data accessed even less frequently (e.g., quarterly). It offers an efficient solution when slightly lower availability, 90-day minimum duration, and higher access costs are acceptable tradeoffs compared to nearline storage.

4. Archive Storage: The lowest cost, most durable option designed specifically for long-term archival needs such as legal or regulatory requirements (accessed less than once a year). Although it has higher data access costs and requires longer minimum storage duration, its affordability makes it an excellent choice for cloud backup and disaster recovery purposes.

Cloud storage possesses unique features like single millisecond API data access latency, 11 nines durability across all classes, object lifecycle management policies to automatically move data between classes based on usage frequency, and simulated file system structure using bucket and object names. While it offers many advantages over traditional file systems, there are differences in how objects can be managed when migrating them within a "directory" structure (using forward slashes in object names).

It is recommended to use best practices such as avoiding sensitive information in bucket names due to their global nature and ensuring data privacy through proper access controls. Cloud storage provides flexibility with multiple methods of accessing the stored data, including direct copy commands from local files or web-based interfaces that maintain secure transport protocols like HTTPS for protecting credentials and in-transit data.

**Cloud Storage Security Features:**

- **IAM Policy & Access Control Lists (ACL):**
  - IAM policy is set at bucket level with uniform access rules for all objects within the bucket.
  - ACL can be applied at bucket or individual object levels, allowing finer grained control over access.
  - Supported roles include: project roles and bucket roles (e.g., reader, writer, owner).
- **Security Management:**
  - Ability to create/change ACLs requires `IAM bucketEditor` role at the bucket level; setting or changing IAM policy needs a project level role with permissions like viewer, editor, and owner.
  - Custom roles can be created for special internal groups granting access based on their memberships in these roles.

**Encryption:**

- **Data Encryption at Rest & In Transit:**
  - All data is encrypted by default using two levels of encryption keys (data encryption key and key encryption key).
  - Google uses managed encryption keys (Google-managed KMS or GKEM) automatically rotating the key. Users have an option for customer-managed encryption keys (CMEK) or CEK, allowing control over creation/existence of key encryption keys; users can also opt for client-side encryption with their own mechanism (CEK).

**Logging & Data Protection:**

- **Data Access Logs:**
  - Cloud storage supports audit logs and access logs, which are immutable.
- **Data Locking Mechanisms:**
  - Object holds suspend all operations that could change/delete the object until released; lock on a bucket prevents any changes or deletions.
- **Retention Policies & Special Use Cases:**
  - Retention policies can prevent data from being deleted, even with other locks in place.
  - Decompressive coding allows uploads of compressed files like Gzip archives; requester pays feature ensures only the person accessing the data pays for network egress charges; signed URLs allow anonymous sharing and expiration control of objects.

# Data Storage and Processing Options on Google Cloud

## General Overview

- **Cloud storage**: not ideal for transactional workloads due to higher latency compared with other options like Cloud SQL or Firestore.
- **Analytics Workloads**: Avoid using cloud storage, prefer Bigtable or BigQuery based on the required latency and compute requirements for processing structured data.

## Transactional vs Analytical Workloads

1. _Transactional workloads_: Fast inserts/updates, maintaining a current state of the system with simple queries affecting few records (e.g., bank depositing salary). Suitable tools include Cloud SQL or Firestore.
2. _Analytical workloads_: Reading entire dataset and complex aggregations for planning or decision support (e.g., generating reports on customer transactions). Preferred tools are BigQuery or Bigtable, depending on latency requirements.

## Data Transfer between Operational & Analytical Systems

- Periodic population from operational systems to analytical systems using data pipelines built by engineers, such as exporting database files and loading them into Bigquery.

## Relational Database Options

1. _Cloud SQL_: Default choice for transactional workloads unless global distribution or large database size is needed. Cost-effective option for analytics workloads.
2. _Firestore_: Consider using Firestore when working with non-relational data models, such as documents and collections (e.g., NoSQL databases).
3. _Cloud Spanner_: Optimal choice if global distribution or a database larger than 10 GB is required for transactional workloads due to its true time capability and scalability features.
4. _Bigtable & BigQuery_: Preferred options for analytical workloads with high throughput insert requirements (millions of rows per second) or low latency needs (on the order of milliseconds), respectively.

## Summary in Markdown Table Format

| Workload Type | Suitable Tools | Notes |
| ------------- | -------------- |letech-focused workloads, high throughput and low latency requirements)|}

# Cloud SQL as a Relational Data Lake

## Overview

- **Cloud SQL**: Managed relational database service by Google for various RDBMS (MySQL, Postgres, SQL, and Microsoft SQL Server).
- Supports **OLTP workloads** on the Google Cloud platform.
- Fully managed aspect includes patching, backups, minor version updates, etc., allowing focus on application development.

## Key Features & Benefits

| Aspect                                 | Description                                                                                                                                                                                                                                                                              |
| -------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Database Management                    | Offers a compute engine instance with pre-installed MySQL (additional RDBMS support coming over time). Google manages all the maintenance aspects like updates, backups, and security patches.                                                                                           |
| Availability & SLAs                    | Provides 99.95% availability for replicas managed by Google Cloud SQL.                                                                                                                                                                                                                   |
| Accessibility                          | Instances can be accessed from various Google Cloud services and external applications using standard drivers (e.cuiercer). Supports popular tools like MySQL Workbench, Toad, etc.                                                                                                      |
| Security & Encryption                  | Customer data is encrypted in transit on internal networks and at rest within database tables, temporary files, and backups. Network firewall controls access to instances.                                                                                                              |
| Scalability                            | Vertical scaling up to 64 processor cores and >100 GB RAM; horizontal scaling through read replicas (three scenarios supported).                                                                                                                                                         |
| Data Durability & Failover Replication | Instances can be configured with failover replicas across zones within a region, ensuring data durability. Automatic failover occurs during primary zone outages.                                                                                                                        |
| Serverless Aspects                     | Though providing direct SQL access like an on-premises installation, Google Cloud manages aspects such as backups and automatic failover handling. However, serverless products are managed entirely by the provider without any infrastructure involvement from users (e.g., BigQuery). |
| Cost Considerations                    | Failover replicas count towards costs when primary instances require manual failover initiation; connections closed during failover events may impact application behavior.                                                                                                              |

## Comparison: Cloud SQL vs Serverless Products

Choosing between fully managed services like Google Cloud SQL and serverless products such as BigQuery or Dataflow depends on the specific project requirements, desired levels of management involvement, and cost considerations. For new projects with no prior RDBMS experience, using a serverless product is generally recommended due to its ease-of-use and reduced infrastructure overhead.

## Lab Notes: Loading Taxi Data into Google Cloud SQL

### Objective

- Create a data lake by importing relational data from an external source to a **Google Cloud SQL** hosted environment.

### Steps

1. **Create a Google Cloud SQL instance**

   - This can hold multiple databases for better organization and management of data.

2. **Set up the new cloud SQL database**
   - Name, region, and other settings should be configured as per requirements.

3.amo import taxi dataset into the newly created database in Google Cloud SQL 4. **Import text data**: Follow the necessary procedure to transfer your relational data (taxi dataset) from its current location to the cloud SQL instance.

- Ensure proper formatting and compatibility with the destination structure.

5. **Verify data integrity**: After importing, perform checks on the taxi dataset to ensure that all records are intact and accurate. This step is crucial for maintaining the quality of your data lake.

### Summary Table Comparison (for illustrative purposes)

| Aspect        | Google Cloud SQL                         | Traditional Relational Database Systems |
| ------------- | ---------------------------------------- | --------------------------------------- |
| Location      | Hosted in cloud environment              | On-premises or on local servers         |
| Accessibility | Easily accessible via internet           | Requires physical access to server      |
| Scalability   | Highly scalable with pay-per-use pricing | Limited by hardware and infrastructure  |
| Maintenance   | Google manages maintenance automatically | Requires manual intervention            |

## Lab Notes: Building a Data Warehouse Module - Modernizing Data Lakes & Warehouses

### Introduction

- The third module focuses on **modern data warehouses**, contrasting them with traditional data lakes.

### Key Concepts

1. **Modern Data Warehouse Characteristics:**

   - Emphasize advanced capabilities like scalability and performance optimization in the cloud environment.

2. **Distinguishing Factors between a Data Lake & Enterprise Data Warehouse:**

   - Highlighting differences based on structure, data quality, processing models, etc.

3. **Introduction to BigQuery as a Data Warehousing Solution:**

   - Discuss Google Cloud's powerful and scalable data warehouse service for analytical use cases.

4. **Organizing & Loading Data in BigQuery:**

   - Steps on how to manage, organize, and load new data into the system.

5. **Hands-On Lab Opportunity:**

   - Practical experience with loading data into BigQuery for better understanding of the process.

6. **Data Warehouse Schema Overview & Efficiency:**

   - Focus on efficient design patterns and Google Cloud's support for nested/repeated fields, catering to enterprise needs.

7. **Working with JSON & Array Data in BigQuery:**

   - Hands-on lab exploring handling of complex data types like arrays within the database environment.

8. **Optimizing Tables through Partitioning and Clustering:**
   - Techniques to enhance query performance and manage large datasets effectively using partitioning and clustering in BigQuery.

### Comparison Table (for illustrative purposes)

| Aspect            | Modern Data Warehouse                                   | Traditional Enterprise Data Warehouse         |
| ----------------- | ------------------------------------------------------- | --------------------------------------------- |
| Cloud Integration | Fully integrated with cloud services                    | May not be designed for the cloud environment |
| Scalability       | High scalability and elasticity                         | Limited by on-premises infrastructure         |
| Data Management   | Supports complex data types like nested/repeated fields | Typically handles structured relational data  |
| Performance       | Optimized for fast querying with BigQuery               | Varies based on hardware and database design  |
| Maintenance       | Automated management by cloud provider                  | Requires manual intervention                  |

# Modern Data Warehouse Notes

## Key Features of a Modern Data Warehouse:

- **Data Consolidation**
  - Unlike a **data lake**, an enterprise data warehouse consolidates multiple sources' data by imposing a schema for easier querying and processing.
- **Schema Knowledge**
  - Analysts require knowledge of the warehouse's schema to access and utilize the stored data without writing code.

## Purpose & Differentiation:

1. **Data Storage vs Query Availability**: A data warehouse focuses on making consolidated, query-ready data available for analysis rather than storing raw data like a data lake.
2. **Cleanliness and Consistency**: The purpose of a data warehouse is to ensure that the stored data is clean, accurate, and consistent across different sources.
3. **Scalability & Performance**: A modern data warehouse should be able to handle large datasets (gigabytes-petabytes) with efficient queries without delays or need for separate storage systems.
4. **Serverless Operations**: Modern data warehouses must support serverless operations and require no manual maintenance, enabling analysts to perform ad hoc queries efficiently.
5. **Visualization & Reporting Support**: A modern data warehouse should integrate with familiar visualization and reporting tools for seamless analysis and decision-making processes.
6. **Data Pipeline Integration**: The data warehouse must accommodate an ecosystem of processing tools to build effective ETL pipelines, refreshing the stored data regularly without relying on batch updates only.
7. **Predictive Analytics Support**: Modern data warehouses should enable machine learning operations directly within their environment, preventing the need for moving data out.
8. **Enterprise-Grade Security & Collaboration Features**: A modern data warehouse must offer advanced security features (e.g., data exfiltration constraints) and facilitate collaboration with shared data access and queries among team members.

## BigQuery Overview

**Key Features:**

- **Data Warehousing Capabilities:** Scales from gigabytes to petabytes seamlessly, cost-effective large data set storage and querying.
- **Operational Ease:** NoOps features such as automatic archiving of older data without performance hindrance or downtime during upgrades.
- **Built-In Advanced Technologies:** GIS, Machine Learning integration; Streaming Data Capabilities for real-time analysis.
- **Security and Collaboration:** Benefits from Google Cloud's security features while allowing data sharing across datasets and queries.
- **SQL Compatibility:** Supports standard SQL and NC SQL 2011 compatibility with auto table exploration feature upon creation or update.

**Management & Maintenance:**

- **Serverless Architecture:** Managed by the BigQuery team, requiring no user maintenance or downtime for upgrades.
- **Data Optimization:** Continuous storage and replication management; tables do not require indexing or vacuuming processes.

**Implementation Details:**

- **Infrastructure:** Consists of a Storage Engine (Colossus) using erasure coding for redundancy across multiple physical disks, and an Analytic Engine on Google's distributed network (Jupiter).
- **Resource Allocation:** Dynamic based on usage patterns with storage allocated as consumed; query resources are assigned according to type and complexity.

## BigQuery Performance & Architecture:

| Aspect                   | Description                                                                                                                                                                                             |
| ------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Data Organization        | Column-oriented tables optimized for analytics over OLTP row-oriented tables; immutable once created.                                                                                                   |
| Storage Engine           | Colossus (Google's distributed file system); erasure coding and multiple data center replication ensure durability.                                                                                     |
| Query Processing         | Microservice architecture with no need to configure VMs; uses slots as computational capacity units for sequential execution of queries. Each slot varies in specifications such as CPU, memory, or IO. |
| Scalability & Efficiency | Slots are dynamically calculated based on query complexity and size; resources like CPU, memory, networking are allocated accordingly.                                                                  |
| Query Types              | Sequential execution across multiple stages (e.g., data filtering, partial counting) with parallel worker node processing.                                                                              |

**Note:** BigQuery's column-oriented storage allows for efficient querying by only reading the required columns and leveraging most queries involving few columns. The use of JSON files or manual entry can define each table's schema.

The Wikipedia page was written in English and titled "Wikipedia."

The total number of views where somewhere in the title of any article features the name Google (case sensitive) is 10 billion. This information can be found on the execution details of your SQL query, showing how many records met this condition.

To summarize, when querying BigQuery in a Google Cloud project:

1. Costs are assigned to the active (logged-in) user's project. You need to be logged into your own Google Cloud project with appropriate permissions for billing and accessing data sets.
2. IAM roles grant access control at different levels, such as read permissions or the ability to submit jobs. Users can also have custom IAM roles assigned according to their responsibcuity in a given project.
3. Access control is managed through BigQuery's IA (identity and access management) system for data sets, tables, views, and columns. You need at least read permissions on the table or view that you want to query.
4. Sharing data with different groups can be controlled using row-level security rules and authorized views, which allow fine-grained control over what users see based on their group membership.
5. BigQuery supports materialized views for improved performance of repeated queries by caching the results of a query periodically to reduce resource consumption. These can also contribute to better cost management as you're not repeatedly fetching data from base tables.

To optimize your use of BigQuery, remember to:

1. Manage IAM roles and permissions effectively at all levels (datasets, tables, views, columns).
2. Utilize authorized views for secure sharing of query results with specific users or groups while maintaining access control over the underlying data.
3. Use row-level security policies to filter rows based on user membership in a group and improve overall data governance within your organization.
4. Consider materialized views when you have common, repeated queries across multiple projects for improved performance.

The BigQuery Data Transfer Service provides automated data transfer from various sources into Google BigQuery, handling tasks like scheduled and automatic transfers of data, ens. It also takes care of backfilling missing data to ensure complete datasets are maintained in your analytics processes.

Here is a breakdown of the key features you can use:

1. **Scheduled and Automatic Transfers**: The core functionality enables seamless transfer of big query data from different sources, such as databases or applications on-premises, into BigQuery without requiring extensive coding for coordination or interfacing.

2. **Data Staging**: When using the Data Transfer Service to move your data into BigQuery, you can stage it first by cleaning and transforming the ELT (Extract, Load, Transform) process, ensuring that it is in its final and stable form for analysis. This allows for better maintenance of data quality and structure.

3. **Data Backfill**: A feature provided by the Data Transfer Service to address late-arriving data issues. It automatically detects missing data points during scheduled transfers, requests any missing data from source systems, and backfills it in your BigQuery tables or datasets. This ensures that analytics processes continue to run smoothly without data gaps.

4. **Connectors & Transformation Templates**: The Data Transfer Service offers a range of connectors to establish secure communication with various source services (e.g., SaaS platforms, databases) and collect standard data exports or reports. These connectors work with transformation templates within BigQuery that can perform complex transformations on the collected data before transferring it into tables in BigQuery. The frequency of these transfers can be as frequent as once a day.

5. **Data Transfer Between Regions**: Efficiently move data between different regions using the Data Transfer Service, eliminating the need for cloud storage buckets and allowing you to run BigQuery jobs that transform reports from source services into BigQuery tables and views.

6. **Scheduled Queries in Standard SQL**: Automate execution of queries based on a schedule or event and cache their results using standard SQL syntax (including DDL and DML statements). Scheduled queries can be parameterized, allowing you to organize query results by date/time for complete seven-day history tracking.

7. **Point in Time Query**: BigQuery allows querying point-in-time snapshots of data without the need for backups or recovery processes. This feature enables selective queries that can be used to restore tables, join with other tables, and correct column values based on historical timestamps (up to 24 hours ago).

8. **User Defined Functions**: The BigQuery Data Transfer Service supports user-defined functions or DF As for extending built-in SQL expressions or using an external programming language like JavaScript in your data transformations. You can create and share public UDFs through the BigQuery GitHub repository, which is a helpful resource to access common custom functions.

In summary, Google's BigQuery Data Transfer Service offers numerous features that streamline automated data transfer from various sources into BigQuery, including scheduled transfers, staging and cleaning of datasets, backfilling missing data, connectors with transformation templates, region-specific transfers, parameterized standard SQL queries, point in time query capabilities, and support for user-defined functions.

# Lab Notes: Loading Data into BigQuery

## Objective

- **Primary goal**: Learn to load data into BigQuery using both CLI (Command Line Interface) and Cloud Console, work with multiple datasets, and use Data Description Language (DDL).

## Key Terms

- **BigQuery**: Google's fully managed, petabyte scale data warehouse.
- **CLI**: Command Line Interface for interacting with BigQuery through commands.
- **Cloud Console**: Web interface to manage and use BigQuery services.
- **DDL (Data Description Language)**: Syntax used to describe the structure of a database and its objects, such as tables.

## Important Points & Procedures

1. Setting up the environment
   - Install Google Cloud SDK for command line operations.
   - Set up necessary permissions in Cloud Console for data manipulation.
2. Loading Data via CLI
   - Use `bq load` command to import data into BigQuery from files (CSV, Avro, Parquet).
     ```bash
     bq load --source_format=FORMAT_NAME table_name file_path
     ```
3. Loading Data through Cloud Console
   - Navigate to the appropriate dataset in the console and use "Load data" option.
   - Select source data format (CSV, Avro, Parquet) and configure additional settings as needed.
4. Working with Multiple Datasets
   - Understand BigQuery concepts of datasets, tables, and schemas.
5. Using DDL to Describe Data Structure
   - Use `CREATE TABLE` syntax or import from existing schema to define table structure in BigQuery.
     ```sql
     CREATE TABLE project_name.dataset_name.table_name (field1 datatype(s), field2 datatype);
     ```

# Lab Notes: Exploring Schemas in BigQuery

## Objective

- **Primary goal**: Understand the concept of schemas in BigQuery, their importance for efficient data handling and exploration of public datasets related to weather readings, taxicabs, health logs etc., using SQL.

## Key Terms

- **Schema**: The organization or structure of a database which defines how data is stored, organized, and manipulated.
- **BigQuery Schema**: Defines the format in which datasets are structured in Google BigQuery.
- **SQL (Structured Query Language)**: A programming language used for managing relational databases and performing various operations on the data.

## Important Points & Procedures

1. Understanding Schemas
   - The schema represents a blueprint of how your dataset is organized in BigQuery, including tables, fields (columns), and their respective types.
2. Exploring Public Datasets
   - Numerous public datasets are available on BigQuery covering various topics like daily weather readings, taxicab data, health logs etc., which can be explored using SQL queries to understand the schema design.
3. Using SQL for Schema Exploration
   - Use `EXPLAIN` statement in SQL to examine how a query will run and what kind of processing it will involve:
     ```sql
     EXPLAIN SELECT * FROM dataset_name.table_name;
     ```
4. Analyzing Schema Efficiency
   - Understand the trade-off between schema complexity and data retrieval efficiency, as complex schemas may impact query performance but provide more structured insights into the data.
5. Practical Application of SQL for Data Manipulation
   - Learn to use various SQL commands like `SELECT`, `JOIN`, `WHERE` etc., in conjunction with schema exploration and understanding how these operations affect the overall dataset structure and efficiency.

In the given script, we are exploring various ways to query BigQuery metadata using SQL queries in Google Cloud Platform (GCP). These queries help us understand different aspects of a dataset's structure and attributes within BigQuery.

1. **Using `INFORMATION_SCHEMA`**: We start by selecting columns from the information schema for all datasets in a given project. This query helps determine which tables are present in each dataset, giving insights into their structures and relationships.

```sql
SELECT table_name FROM INFORMATION_SCHEMA.TABLES
WHERE table_schema = '<dataset>'
ORDER BY table_catalog, table_name;
```

2. **Counting Columns**: To find the number of columns in each dataset's tables, we can use this query with `INFORMATION_SCHEMA`:

```sql
SELECT COUNT(*) AS column_count FROM INFORMATION_SCHEMA.COLUMNS
WHERE table_schema = '<dataset>' GROUP BY table_name ORDER BY column_cuont DESC;
```

3. **Retrieving Column Types**: We can retrieve the data types of columns within a dataset using `INFORMATION_SCHEMA`:

```sql
SELECT DISTINCT COLUMN_NAME, TYPE_NAME FROM INFORMATION_SCHEMA.COLUMNS
WHERE table_schema = '<dataset>' ORDER BY column_name;
```

4. **Finding Table Descriptions**: The `INFORMATION_SCHEMA` can also provide descriptions for dataset tables:

```sql
SELECT TABLE_NAME, TYPE_NAME FROM INFORMATION_SCHEMA.TABLES
WHERE table_schema = '<dataset>' AND description IS NOT NULL;
```

5. **Querying Table Definitions**: To retrieve the full table definitions for a dataset's tables with descriptions, we can use this query:

```sql
SELECT * FROM INFORMATION_SCHEMA.TABLES
WHERE table_schema = '<dataset>' AND description IS NOT NULL;
```

6. **Retrieving Table Names and Schema Details**: This query fetches the names, descriptions, and column details of all tables within a dataset:

```sql
SELECT TABLE_NAME, DESCRIPTION FROM INFORMATION_SCHEMA.TABLES
WHERE table_schema = '<dataset>' AND description IS NOT NULL;
SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '<dataset>';
```

7. **Querying Table Statistics**: BigQuery provides statistics about the distribution of values across a dataset's columns:

```sql
SELECT column_name,
       percentile_approx(min_value) AS min_val,
       percentile_approx(max_value) AS max_val,
       avg_(quantiles(0.5)) OVER() AS median_val,
       count(*) AS num_values
FROM INFORMATION_SCHEMA.TABLES JOIN `project_id`.`dataset_name`.INFORMATION_SCHEMA.`COLUMNS`, (SELECT DISTINCT column_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '<dataset>') AS c
USING(table_catalog, table_schema, table_name) ON TRUE GROUP BY column_name;
```

8. **Querying Datasets**: To list all datasets within a project and retrieve their information such as description and last modification time, we can use the following query:

```sql
SELECT dataset_id AS dataset FROM INFORMATION_SCHEMA.TABLES
WHERE table_catalog = '<project>' ORDER BY create_time DESC;
```

9. **Querying Columns of All Tables**: We can gather detailed information about the columns within all tables in a given project using this query:
   cu

```sql
SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '<project>';
```

10. **Querying Columns of All Tables with Descriptions**: To filter out only the columns that have descriptions, we can modify our previous query like this:

```sql
SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '<project>' AND description IS NOT NULL;
```

11. **Querying Dataset Details**: We can retrieve detailed information about all the tables within a dataset, including their schemas and descriptions using this query:

```sql
SELECT * FROM INFORMATION_SCHEMA.TABLES
WHERE table_schema = '<dataset>' ORDER BY create_time DESC;
```

12. **Querying Dataset Columns**: To fetch detailed information about the columns in all tables within a dataset, we can use this query:

```sql
SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE table_schema = '<dataset>';
```

13. **Creating Schema from Dataset**: Finally, we can generate an SQL script that creates the full schema for a given dataset using this query:

```sql
SELECT CONCAT('CREATE TABLE `project_id`.',table_name,' (') AS stmt
FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '<dataset>';
```

By running these queries, you can extract valuable metadata about your datasets in BigQuery and gain insights into their structures and attributes for effective data management and analysis.

# Efficient Data Warehouse Schema Design

## Key Concepts:

- **Normalization**: Transforms data into a structured, relational format to enhance efficiency and orderlineby reducing redundancy and improving query processing clarity.
- **Theorizing**: A technique that allows duplication of field values in columns for performance optimization by utilizing non-relational, flattened structure. However, this may not be suitable for one-to-many relationship data as it requires shuffling during groupings.
- **BigQuery Support**: Enables nested and repeated fields to manage theorized data efficiently while maintaining relational characteristics and improving query performance.

## Comparison between Normalization and Theorizing in BigQuery [Markdown Table]:

| Aspect                   | Normalization                                        | Theorizing                                    |
| ------------------------ | ---------------------------------------------------- | --------------------------------------------- |
| Data Organization        | Relational, efficient storage, reduced redundancy    | Non-relational, flattened structure           |
| Query Processing         | Clear and direct, improved by nested/repeated fields | More parallel processing, columnar processing |
| Space Saving             | Yes                                                  | Less due to duplication                       |
| Performance Optimization | Suitable for most cases                              | Better in specific scenarios                  |
| Handling One-to-Many     | Works well with grouping operations                  | Inefficient, requires data shuffling          |
| Relationship             | Maintains relationships between related data         | Preserves relational patterns                 |

## Data Warehousing Strategies:

1. **Normalization**:
   - Efficiency: Enhanced by converting unstructured to structured, relational format.
   - Space Saving: Reduces redundancy and saves storage space.
2. **Theorizing** (with BigQuery):
   - Query Performance: Offers better parallel processing through columnar operation.
   - Handling Relationships: Utilizes nested/repeated fields to manage relational patterns effectively.
   - Consideration: Best for use cases that don't involve one-to-many relationships or require significant data shuffling during groupings.

## Advanced Bullet-Point Notes on Nested and Repeated Fields

### Key Concept: Schema Design

- **Popular schema designed for enterprises** in BigQuery using nested and repeated fields.
- Real business example: Gojek, Indonesian ride booking service processing 13 PB of data/month on BigQuery.

### Data Organization

- Orders table tracks customer actions (e.g., hail a ride).
- Decisions include querying large datasets efficiently for a massive user base.

### Relational vs. Denormalized Schemas

| Aspect               | Normalized (Relational)                     | Fully Denormalized                  |
| -------------------- | ------------------------------------------- | ----------------------------------- |
| Approach             | Storing each fact in a separate table       | All granularity levels in one table |
| Computation          | More complex queries, joins                 | Simple queries                      |
| Data Retrieval       | Slower due to multiple joins and lookups    | Faster retrieval                    |
| Granularity Handling | Separate tables for different granularities | All data in one place               |

### BigQuery Optimizations: Nested and Repeated Fields

- **Nested fields** (struct): Combine multiple related fields within a single record.
  - Example: `event` struct with subfields like status, time, etc.
- **Repeated fields** (arrays): Allow for multiple values of the same type in one field.
  - Example: Array of events attached to an order or user record.
- Advantages: Pre-joined data leads to faster queries; supports columnar storage model which optimizes certain operations.

### Implementing Nested and Repeated Fields

- **Struct fields** can be used for logical grouping within a table without creating multiple tables or complex joins.
  - Example: `event` struct containing multiple event details, avoiding separate tables for each event type.
- **Arrays of repeated values** enable deep granularity levels in specific fields.
  - Example: Array of statuses and times for detailed user actions.

### Integration with Existing Schemas

- BigQuery also handles traditional star schema, snowflake, or third normal form data effectively.
- **Best Practices** include using arrays and structs when naturally fitting your data format to improve performance immediately.
- For existing schemas: bring them directly into BigQuery for good results without major modifications required.

### Conclusion

Nested and repeated fields in BigQuery provide powerful tools for managing complex enterprise datasets, enabling efficient storage, querying, and analysis of large volumes of detailed data within a single optimized schema.

To achieve the desired result of unpacking array values and getting them on individual rows in Google BigQuery, we can use the UNNEST function with appropriate aliases for clarity. Here's how you can construct your SQL statement step by step:

1. Firstly, let's select from the blocks table (`T`) and cross join it with transactions to access all transaction data associated with each block. We will create an alias `transactions` as `T_trns`:

```sql
SELECT
    T.blockId AS blockId,
    UNNEST(T_TRNS) AS TRANS
FROM blocks AS T
CROSS JOIN UNNEST(T.transactions) AS T_TRNS;
```

2. Now that we have the transactions unpacked, let's select the columns of interest from each transaction and filter by a specific block ID:

```sql
SELECT
    TRANS.id,
    TRANS.value,
    TRANS.timestamp,
    TRANS.inputs,
    TRANS.outputs
FROM (
    SELECT
        T.blockId AS blockId,
        UNNEST(T.transactions) AS transaction
    FROM blocks AS T
) AS unpacked_blocks
CROSS JOIN UNNEST(unpacked_blocks.transaction) AS TRANS
WHERE unpacked_blocks.blockId = 'your_specific_block_id';
```

Replace `'your_specific_block_id'` with the actual block ID you want to filter by, such as `'92154837'`.

This query will return all individual transactions from a specific block in separate rows. Note that if there are multiple inputs and outputs for each transaction, they will still appear on different columns (inputs and outputs) but unpacked into separate rows.

## Optimal Schema Design for BigQuery

### Key Points:

- **Nested Repeated Fields**: More efficient in BigQuery compared to traditional joins.
- **Data Organization**: Use arrays (repeated fields) instead of separate tables when possible.
- **Normalized Tables**: Keep dimension tables normalized if they are smaller than 10 GB and have frequent update/delete operations.
- **Denormalization**: Consider denormalizing into one table for larger datasets to reduce join performance impact.

### Comparison Table: Normalized vs Denormalized Schema

| Criteria                 | Normalized Tables         | Denormalized Tables         |
| ------------------------ | ------------------------- | --------------------------- |
| Optimal Size             | < ^10 GB                  | >= ^10 GB                   |
| Update/Delete Operations | More frequent             | Rarely occurring            |
| Join Performance         | Better for smaller tables | Improved by reducing joins  |
| Data Organization        | Separate tables with FK   | Single table, nested arrays |

^10 GB represents the crossover point between normalized and denormalized schema design.

## Working with JSON and Array Data in BigQuery

### Key Points:

- **Semi-Structured JSON**: Load and work with JSON formatted data in BigQuery.
- **Arrays & Structs**: Learn to create, manipulate, and query arrays and structs within datasets.
- **Nested & Repeated Fields**: Understand the concept of nested and repeated fields for efficient querying.

### Lab Objectives:

1. Load semi-structured JSON data into BigQuery.
2. Create and manipulate arrays and structs in BigQuery.
3. Query nested and repeated fields within datasets.

## Optimizing JSON and Array Data Handling in BigQuery

### Advanced Techniques: Partitioning & Clustering

- **Partitioned Tables**: Segment data by time (e.g., date or timestamp), minimize metadata overhead, enhance cost-effective querying.
- **Clustered Columns**: Organize related data, improve performance on filter and aggregate queries, optimize costs with accurate estimates beforehand.

### Implementation Strategies:

1. Partition tables by date/time columns to reduce metadata overhead (e.g., partition by event_date).
2. Cluster tables using relevant columns for sorted data blocks (e.g., cluster by user_id), boost query performance on aggregates and filters.
3. Utilize autore-clustering feature in BigQuery, free of cost and automated.
4. Combine partitioning with clustering to enhance both accuracy in cost estimation and overall data retrieval speed.

## Introduction: Date-Partitioned Tables in BigQuery

### Key Concepts & Practices:

- **Date Partitioning**: Enhances query performance, optimizes costs (e.cu) by segmenting data based on time intervals (e.g., days).
  - **Advantages**:
    - Improved Queries: Faster execution, efficient data retrieval using partition filters.
    - Cost Efficiency: Reduced expenses due to processing only relevant partitions in queries.
- **Dataset Partitions Creation**: Strategy for organizing and managing segmented datasets within BigQuery environment.
  - Practical Exercise:
    1. Query existing partition data sets for hands-on experience.
    2. Create dataset partitions following best practices to ensure optimized performance.

## Review: Partitioned Tables in Google BigQuery

### Key Concepts & Practices:

- **Modern Data Warehouse**: Characterized by scalability, dynamic resource allocation (e.g., storage, query resources), no need for pre-provisioning.
  - _BigQuery_: A prime example of a modern data warehouse on Google Cloud Platform.
    - Advantages:
      - Dynamic Resource Allocation: Resources adjust based on usage patterns; ensures efficient performance without manual intervention.
      - Data Management: Organizes information into datasets, projects, and tables for improved structure and accessibility.
- **Datasets & Projects**:
  - Use multiple datasets to separate analytical domains (e.g., marketing, sales).
  - Employ project level scoping for data isolation according to business requirements; aligns with billing and facilitates access control via data sets.
- **Data Ingestion & Transfer**:
  - Offers both batch loading (e.g., CS V files, external databases) and streaming capabilities for real-time data querying upon arrival.
  - Supports third-party applications/services with BigQuery connectors to ingest data directly into the platform.
- **Table Schema & Normalization**:
  - Structure of each table is defined through a schema, which can be manually entered or imported via a JSON file.
    - Array Data Types (Repeated): Multiple values per field entry; improves performance by avoiding intensive joins.
    - Structured Data Types (Nested): Complex data organization within a single field; enhances query efficiency and denormalization benefits.
- **Table Partitioning & Clustering**:
  - Reduces the amount of scanned data, speeding up queries by organizing records based on specific columns or time intervals.

## Summary: Modern Data Lakes & Warehouses Course

### Key Concepts:

- **Data Pipelines**: Essential for enabling stakehold
  to make informed decisions; evolved with cloud computing. - _Cloud Advantages_: Separation of compute from storage, no need to manage infrastructure/software directly. - Focus Shifted: Allows more time on data insights extraction instead of management tasks.
- **Data Lakes vs. Data Warehouses**:
  - _Data Lake_: Stores unprocessed raw data; acts as a repository for all types of data in its native format.
    - Purpose: Serve initial stages of the data lifecycle, including collection and storage before transformation or analysis.
  - **Data Warehouse**: Houses transformed data ready for analytics, machine learning, dashboards, etc.
    - Distinguishing Feature: Focuses on structured and processed data optimized for querying and reporting.
- **Google Cloud Storage & BigQuery**:
  - _Cloud Storage_: Serves as a data lake solution; offers scalability, security, and accessibility for raw unprocessed data.
    - Designed to handle high volume ingestion and diverse data types efficiently.
  - _BigQuery_: Adopts the role of data warehouse on Google Cloud Platform (GCP), ideal for structured querying of transformed datasets.
    - Enhances analytical performance with techniques like partitioning and clustering to improve queries' speed and efficiency.
- **Data Integration Techniques**:
  - _ETL_ ("Extract, Transform, Load"): Pivotal for moving data between systems (data lakes and warehouses), ensuring accuracy, completeness, and consistency across platforms.
    - ETL Processes: Facilitate the transformation of raw data into a structured format suitable for analysis in data warehouses.
  - _ELT_ ("Extract, Load, Transform"): An alternative to ETL where raw data is loaded directly into the cloud (data lake) and then transformed as needed; becoming more prevalent due to advances in cloud computing capabilities.
- **Streaming & Batch Data Pipelines**:
  - _Reference Architectures_ on GCP for these pipelines provide a foundation or starting point, accommodating both real-time (streaming) and scheduled (batch) data processing requirements.
    - Use Cases: Streaming pipelines handle continuous, high-velocity data flows; batch pipelines manage large volumes of data in periodic chunks.
