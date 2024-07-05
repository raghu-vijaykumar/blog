+++
title = "Building Resilient Streaming Pipelines on Google Cloud Platform"
date = "2024-07-03T10:06:10+01:00"
tags = [ "data-engineering", "streaming", "google-cloud", "course-summary" ]
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
caption = "Building Resilient Streaming Pipelines on Google Cloud Platform"
relative = false
hidden = false
+++

![cover](./cover.png)

# Building Resilient Streaming Analytics Systems on Google Cloud Course Notes

## Introduction

- **Course Title**: Building Resilient Streaming Analytics Systems on Google Cloud
- **Developer**: Damon, Technical Curriculum Developer at Google
- **Course Position**: Third in the Data Engineering on Google Cloud course series.
- **Topics Covered**:
  1. Understanding streaming data processing
  2. Integration of streaming analytics within big data architecture
  3. Identifying when to use streaming data processing
  4. Overview of Google Cloud technologies for resilient streaming solutions

## Course Breakdown

- **Streaming Data**: Real-time data points and the challenges associated with them (variable volumes, latency).
- **Google Cloud Technologies**:
  - Pub/Sub
  - Dataflow
  - BigQuery
  - Bigtable

### Module 1: Understanding Streaming Data

- Real-time data processing and the challenges faced.
  - Variable Volumes
  - Latency issues

### Module 2: Google Cloud Technologies for Streaming Analytics

#### Pub/Sub

- Key role in ingestion of streaming data

#### Dataflow

- Processing and insights derivation from streaming data

#### BigQuery

- Advanced analytics capabilities such as GIS functions, query performance optimization.

### Module 3: High Throughput with Bigtable

- Suitable for scenarios requiring high throughput rates in streaming data processing

## Streaming Data Processing: An Overview

**Key Concepts**

- **Streaming data processing** involves real-time handling of unbounded data flows.
- Big data architecture includes Pub/Sub, Dataflow, and storage options like BigQuery or Cloud Bigtable.

**Purpose & Benefits**

1. **Real-time Information**: Streaming enables instant dashboard updates to track organizational states (e.g., New York City Cyber Command).
2. **Low Latency Processing**: Engineered pipelines minimize delays, ensuring timely data flow and parallel processing for efficiency.
3. **Scalability & Adaptation**: Systems handle volume variability such as increased data loads during peak periods (e.ebytes) or events like Black Friday sales surges.
4. **Structured & Unstructured Data Handling**: Tools assist with autoscaling, velocity control, and AI-based unstructured data processing.
5. **Actionable Insights**: Streaming facilitates real-time analytics for various applications such as fraud detection, stock trading, etc.

## Architecture & Workflow

| Stage | Tool/Component           | Function                               | Output Data Type            |
| ----- | ------------------------ | -------------------------------------- | --------------------------- |
| 1     | Source (e.g., IoT)       | Event generation                       | Raw data streams            |
| 2     | Pub/Sub                  | Message ingestion & distribution       | Reliable, buffered messages |
| 3     | Dataflow                 | Aggregation, enrichment, and detection | Processed data records      |
| 4     | Storage (e.g., BigQuery) | Database writing or ML model training  | Stored/analyzed data        |
| 5     | Batch Processing         | Additional processing                  | Finalized data insights     |

**Challenges & Solutions: The Three V's**

1. **Volume**: Autoscaling tools assist with handling large, continuously growing datasets.
2. **Velocity**: Systems manage high-speed and variable data transfers effectively (e.g., tens of thousands of records per second).
3. **Variety**: AI helps process diverse data types like voice or images in streaming records.

# Serverless Messaging with Pub/Sub Module

**Introduction:** Understanding the process of streaming data and exploring its application in decoupling systems via Google Cloud Platform's (GCP) **Pub/Sub** messaging service.

## Key Concepts:

1. **How Pub/Sub Works:** Introduction to event-driwer, scalable messaging system for handling asynchronous tasks and communication between services.
2. **Decoupling Systems with Pub/Sub:** Improves system resilience and availability by eliminating direct dependencies among components.
3. **Message Distribution Patterns:** Explains the push and pull delivery models used in distributing messages across distributed systems.
4. **Actual Implementation of Pub/Sub:** Provides a hands-on lab to demonstrate publishing streaming data into Pub/Sub using GCP's services, including setting up resources required for the implementation.
5. Numerical values and mathematical equations (when applicable) are important and should not be omitted. Use LaTeX format as needed.

## Comparison of Push and Pull Delivery Models:

| Feature          | **Push Model**                                                                                                   | **Pull Model**                                                                                                          |
| ---------------- | ---------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| Initiator        | Producer initiates message sending to consumers (e.g., Publisher)                                                | Consumers request messages from the messaging system (e.g., Subscriber).                                                |
| Flow of Messages | Bi-directional flow between producer and consumer, with control resting on the publisher's side.                 | Uni-directional flow from Pub/Sub to consumers who actively request new data. Control lies in the hands of subscribers. |
| Use Cases        | Real-time event processing systems where producers need immediate feedback or response (e.g., IoT applications). | Systems with infrequent updates, long intervals between messages, and a higher tolerance for latency.                   |

## Pub/Sub Implementation:

1. **Setting up resources** - Required services such as Google Cloud Storage, GCP Compute Engine Instances (optional), and creating an instance of the Google Cloud Pub/Sub service.
2. **Publisher component** - Developing a publisher using client libraries or API to send messages into the topic for processing by subscribers.
3. **Subscriber component** - Implementing a message consumer that retrieves messages from the topic and processes them accordingly.
4. **Hands-on Lab:** Step-by-step guide on publishing streaming data using GCP's services, including code snippets (if applicable).
5. Important key terms such as "topic," "subscriber," "publisher," etc., are emphasized in bold fonts for easy reference and understanding.

# Introduction to Google Cloud Pub/Sub

Google Cloud Pub/Sub is a fully managed data distribution system that can be used for various purposes including loosely coupling parts of a system, connecting applications within Google Cloud as well as on-premise or in other clouds to create hybrid data engineering solutions. It simplifies system design by removing the need for continuous online availability and direct communication between components; they only interact with Pub/Sub.

## Key Features:

1. **Service-Based** - Pub/Sub is not a software but rather a service that requires no installation. Client libraries are available in several languages including C#, Go, Java, Node.js, Python, and Ruby. These wrap REST API calls.
2. **High Availability & Durability**: Default message retention period of 7 days ensures durability even during system downtimes. Pub/Sub supports multiple locations for storing messages to ensure high availability.
3.
4. **Scalability** - Google processes around 100 million messages per second, making it a robust solution that can handle vast amounts of data and workloads with minimal latency.
5. **HIPAA Compliance & Security**: Offers fine-grained access controls, end-to-end encryption, and message storage in multiple locations for both durability and security purposes.
6.
7. **Flexibility through Topics & Subscriptions** - This model allows decoupling of publisher and subscriber applications using topics (for publishing messages) and subscriptions (for receiving messages). A topic can have multiple subscriptions, but a subscription is tied to one specific topic.
8. **Advanced Filtering**: Receiving only the relevant messages by filtering based on message attributes helps manage large volumes of data effectively without incurring additional costs for non-relevant messages.

## Usage Scenarios:

1. **Human Resource Management System** - A company can use Pub/Sub to notify different services (e.g., directory system, facility management, account provisioning) whenever a new hire joins the organization by publishing an event on a specific topic and subscribing various systems to that topic.
2. **Contractor Management**: Similarly, when a new contractor arrives, their details can be managed using Pub/ebus across different services like vendor office, HR system, facility management, etc., without direct interdependencies between these services. The messages can be filtered based on attributes to ensure that each service receives the relevant information.

## Conclusion:

Google Cloud Pub/Sub provides an efficient and secure solution for decoupling applications, ensuring high availability and durability of data while offering advanced filtering mechanisms and flexible integration with other Google Cloud services and external systems. With its scalable architecture handling millions of messages per second, it enables organizations to build robust hybrid data engineering solutions that can adapt to various use cases, such as human resource management and contractor management scenarios mentioned above.

## Summary of Pub/Sub Push vs Pull

- **Distribution Patterns**:
  - Straight Through Flow (Push): One publisher -> one subscription
  - Fan-In or Load Balancing (Pull): Multiple publishers -> multiple subscribers
    - Example: Two different publishers send three messages on the same topic, received by a single subscription.
  - Fan-Out (Push/Pull): Single piece of data sent to many subscribers; two subscriptions receive red and blue messages simultaneously.

**Pub/Sub Delivery Methods**

1. **Pull Model**:
   - Clients call for messages periodically, then acknowledge receipt after processing.
2. **Push Model**:
   - Uses an HTTP endpoint; subscribers respond with status cued by Pub/Sub infrastructure.

### Message Acknowledgment and Delivery Guarantee

- Each message acknowledged on a per subscription basis, ensuring delivery at least once over up to seven days.
- Replay mechanism: Can rewind time to replay messages from the past 7 days; configurable retention for subscriptions based on average processing times.

### Topic Configuration and Costs

- Configurable message retention offers flexibility, enables snapshots for efficient replays, but incurs storage costs billed to topic's project.

**Worker Pools in Subscribers**:

- Distribute messages among multiple subscribers sharing a subscription (pull model).
  - Example: Message 1 and 3 go to subscription 1; message 2 goes to subscription
    2 (based on random distribution throughout the day).

**Push Model with Auto Scale Workers**:

- Single web endpoint serving as a push subscriber can utilize auto-scaling workers like App Engine standard apps or Cloud Run containers.

## Pub/

- **Topic Creation**: Use the client library for Pub/Sub to create a new topic.

  ```python
  from google.cloud import pubsub_v1

  publisher = pubsub_v1.PublisherClient()
  topic_path = publisher.topic_path('PROJECT_ID', 'TOPIC_NAME')
  # Create the topic
  topic = publisher.create_topic(request={"name": topic_path})
  ```

- **Publishing Messages**: After creating a topic, messages can be published to it using raw bytes (b'My first message').
  - Limit of 10 MB per message.
  - Extra attributes can be included in the message payload (e.g., `author=dylan`).
- **Subscriptions**: Similar to publishing, create a subscription and define a callback function for pull subscriptions or batch publish messages.

  ```python
  from google.cloud import pubsub_v1

  subscriber = pubsub_v1.SubscriberClient()
  sub_path = subscriber.subscription_path('PROJECT_ID', 'SUBSCRIPTION_NAME')
  subscription = subscriber.subscribe(request={"name": sub_pert})
  ```

- **Batch Publishing**: Increases efficiency by reducing overhead with the ability to send multiple messages at once (e.g., `max_messages=10`).
  - This can be configured using Python code or command line options provided in documentation.
- **Message Ordering and Dead Letter Topics**: Ensure message ordering for consistent processing if needed, especially when both are enabled on a subscription.
  ```python
  # Set the message ordering property when creating a subscription
  settings = {
    "message_ordering": pubsub_v1.enums.MessageOrderingTypes.NONE
  }
  subscriber._client.create_subscription(request={"name": topic_path, "settings": settings})
  ```
- **Streaming Resilience**: Pub/Sub acts as a buffer for large volumes of transactions and overloads to prevent system failure during traffic spikes.
- **Dead Letter Queue (DLQ) & Error Logging**: Implement error handling mechanisms by using DLQs and logging erroneous records to avoid pipeline failures.
- **Exponential Backoff Strategy**: Use exponential backoff for retries on message delivery failure, with a minimum and maximum delay interval configured based on application needs.
- **Audit Logging & Access Control**: Maintain audit logs (admin activity and data access) to track API calls/actions related to resources. Enable and configure access control via IAM.

  **Pub/Sub Overview**

- Scalable global service for messaging
- Out-of-order data delivery as compromise
- No guarantee of message order like true queuing systems

**Handling Out-Of-Order Messages**

- Develop application that can handle out-of-order and replicated messages
- Do not use Pub/Sub for applications requiring strict sequential message ordering (e.g., chat)

**Message Routing and Delivery**

- Utilizes mesh network which may result in variable routing times
- Slower routes could cause earlier messages to arrive later than expected

| Technique                  | Capability            | Limitation                            |
| -------------------------- | --------------------- | ------------------------------------- |
| Pub/Sub alone              | Global scalability    | No ordering guarantee                 |
| Dataflow in conjunction    | Deduplicates messages | Limited sequential order capabilities |
| BigQuery for deduplication | Useful but limited    | Not as effective as Dataflow          |

**Dataflow Integration with Pub/ebus**

- Combines scalability of Pub/Sub and processing power of Dataflow
- Deduplicates messages by using message IDs
- Aids in dealing with late data, but does not order it sequentially

In summary, while Google's Pub/Sub offers a robust global messaging service with the ability to handle out-of-order and replicated messages, it may not be suitable for use cases requiring strict ordering. However, using Dataflow in conjunction with Pub/Sub can help manage deduplication and late data handling, providing an effective solution that leverages both scalability and processing power.

**Publishing Streaming Data to Pub/Sub**

- Lab focus: Simulating San Diego Traffic Data publication
- Create Pub/Sub Topic & Subscription for streaming data

**Lab Objectives**

1. Understand the concept of streaming data in Pub/Sub system
2. Practice creating a topic and subscription within Pub/sub platform
3. Learn to simulate real time traffic data publishing into Pub/Sub

**Creating Topics & Subscriptions**

- A **topic** is an entity that holds messages sent by publishers
- A **subscription** pulls the published messages from a topic

### Steps for Creating Topic and Subscription:

1. Navigate to Console -> Dataflow (Cloud) -> Streaming data > Pub/Sub topics & subscriptions
2. Click on "Create" button under "Topics" or "Subscriptions" section depending upon requirement
3. Fill necessary details like Name, Region etc and save settings
4. Repeat similar steps for both Topic and Subscription creation

### Simulating San Diego Traffic Data:

1. Use Google Maps API to fetch real-time traffic data of San Diego
2. Process the obtained JSON response with a suitable programming language (e.g., Python, Java)
3. Publish each processed entry as message in Pub/Sub topic
4. Subscribe and receive messages from created subscription for further processing or analysis

Remember that:

- Messages should be published to the topic at an appropriate rate depending upon data stream size
- The simulated traffic data can then be used for various purposes like realtime analytics, alerting systems etc

| **Feature**            | **Benefits**                         | **Limitations**                                         |
| ---------------------- | ------------------------------------ | ------------------------------------------------------- |
| Pub/Sub Streaming Data | Real-time data processing & analysis | Depends on the publish rate                             |
| Google Maps API        | Source of real-time traffic data     | Requires API key, limited requests without billing info |

In conclusion, this lab provides a hands-ebon experience in simulating and publishing San Diego's Traffic Data into Pub/Sub using Google Cloud Console. This involves creating topics and subscriptions for handling streaming data with potential applications in realtime analytics or alerting systems.

**Introduction:**

- Topic: Utilizing Google Cloud Platform (GCP) & Qwiklabs
- Purpose: Practical hands-on experience, provisioning Google account credentials for accessing GCP Console at no cost.

**Qwiklabs Overview and Access**

- Interactive platform for practical labs on Google Cloud Platform
- Access process involves providing an email address or using existing Qwiklabs account
- Creation of a new Qwiklabs account if none exists, with the provided email

### Steps to Begin Using Qwiklabs:

1. **Open Lab Item in Course** - Click Open button and provide desired Qwiklabs account email
   - If existing Qwiklabs account exist, use that email & login with password
2. **Qwiklabs Login Page** - After entering or verifying the email address, click on Start Lab to begin lab session
3. **Open Google Console**: Provide username and password provided in course interface
4. **Accepting Account Setup and Terms of Service**
   - Navigate through initial account setup windows
5. **Verify Project Settings & Connection Details**
   - Check project name, ID, number within the dashboard
   - Verification with connection details on Qwiklabs page
6. **Lab Session Management: Tracking and Scoring**
   - Monitor score in top-right corner of Qwiklab window
   - Click to view individual steps completed as objectives are met
7. **End Lab**: Once lab activities complete, click End Lab button for project deletion & course continuation

**Key Points:**

1. Use only the Qwiklabs-provided credentials for accessing GCP Console during labs to ensure accurate tracking and scoring
2. Note that ending a lab session results in deleting of the Qwiklabs-provided project and any resources within it

**Introduction:**

- Topic: Streaming Data Processing using Pub/Sub and Dataflow
- Main Goal: Publishing streaming data into PubSub for further processing or analysis through Dataflow's streaming features

### Key Concepts & Challenges in Streaming Data Processing:

1. **Streaming Data**: Real-time, continuous flow of information from various sources
2. **Pub/Sub (Google Cloud Pub/Sub)**: A messaging service used to receive and send streaming data
3. **Dataflow**: Apache Beam open-source unified programming model designed for both batch and stream processing jobs
4. **Challenges in Streaming Data Processing**:
   - Handling high volumes of continuous, real-time data
   - Managing delays or lags during the streaming process
   - Ensuring accuracy and consistency throughout data analysis

### Pub/Sub & Dataflow Integration:

1. **Dataflow's Role** - Utilizing Dataflow to ingest, transform and analyze streaming data received from Pub/Sub
2. **Streaming Features of Dataflow**
   - Windowing capabilities for managing the continuous stream of data in smaller segments

### Understanding Windowing:

1. **Windowing Processes** - Segmenting a continuous flow of data into smaller, manageable chunks or windows
2. **Types of Windowing Methods** (Tabulated):
   | Window Type | Description | Use Cases |
   |------------- |--------------------------------------------------- |------------------------------------------------------- |
   | Fixed Windows | Divide data into equal, fixed size windows | Suitable for consistent streaming rates and volumes |
   | Session Windows | Create sessions based on user activity or events | Ideal for applications involving user behavior analysis|
   | Sliding Windows | Overlap of consecutive fixed-size windows | Useful when continuous analysis over a period is needed |
3. **Advantages & Limitations of Windowing**

   - Advantages: Efficiently manage large streaming data, reduce processing complexity, and improve real-time insights
   - Limitations: Overlapping windows may lead to redundant computations; fixed window size might not capture dynamic fluctuation in stream rate

4. **Implementing Windowing with Dataflow** - Using Apache Beam SDK (Python & Java) for creating custom windowed data processing pipelines
   - Example Code: [Dataflow Windowing Demo](https://github.com/GoogleCloudPlatform/dataflow-templates/tree/master/python-windowing)

**Key Takeaways:**

1. Streamlining streaming data processing using Pub/Sub and Dataflow, with emphasis on windowing capabilities for managing continuous streams of information effectively.
2. Understanding the challenges in handling real-time, high-volume data and adopting appropriate strategies to optimize analysis and insights.

**Introduction:**

- Topic: Challenges in Processing Streaming Data using Dataflow
- Main Goal: Addressing key challenges related to scalability, fault tolerance, modeling, timing/latency, and aggregation while utilizing the windowing capabilities of Dataflow.

### Key Concepts & Challenges in Streaming Data Processing:

1. **Streaming Data** - Continuous flow of real-time information from various sources.
2. **Dataflow** - A serverless service for processing both batch and streaming data, offering low latency pipelines and scalability.
3. Unbounded Collections - Handling potentially infinite streams of incoming messages in an unbounded fashion.
4. Challenges:
   a) Scalability: Managing the growing volume and frequency of incoming data while ensuring system stability.
   b) Fault Tolerance: Reducing vulnerability to unexpected failures as system size increases.
   c) Model Selection: Choosing between streaming or repeated batch models depending on problem requirements.
   d) Timing/Latency: Addressing delays in data transfer and message generation while maintaining accuracy of analysis.
   e) Aggregation: Performing meaningful calculations, such as averages, within the context of a continuously evolving dataset.

### Streaming Data Challenges & Solutions with Dataflow:

- **Scalability**: Dataflow's inherent scalability enables handling larger and more frequent volumes of streaming data effectively.
- **Fault Tolerance**: The distributed nature of Dataflow ensures fault tolerance by replicating processing elements across the cluster, allowing for automatic recovery from failures.
- **Model Selection**: Depending on problem requirements, users can choose between a streaming or repeated batch model when setting up their pipelines in Dataflow.
- **Timing/Latency**: To mitigate delays and ensure accuracy of analysis within the context of streaming data, timestamps provided by Pub/Sub messages help maintain the correct order and timing during windowing operations performed by Dataflow.
- **Aggregation**: Windowing capabilities in Dataflow enable performing aggregations over fixed periods or custom time windows to account for continuous streams of incoming data points.

### Handling Timestamps & Custom Message IDs with Dataflow:

1. Pub/Sub Messages - Every message includes a timestamp indicating the time when it was generated. This helps maintain proper ordering and timing during windowing operations within Dataflow pipelines.
2. Modifying Timestamps - If latency between data capture and message sending is significant, users can modify timestamps to reflect the actual time of data capture using PTransform functions that extract and update timestamp metadata based on element properties in the incoming messages.
3. Custom Message IDs & Deduplication: When custom message IDs are used with Pub/Sub I/O configurations, Dataflow maintains a list of seen message IDs within the last amoout 10 minutes to identify potential duplicates. Duplicate messages can be discarded based on this deduplication mechanism to ensure data integrity in processing pipelines.

**Conclusion:**

- The challenges associated with streaming data processing, such as scalability, fault tolerance, modeling, timing/latency, and aggregation, can all be addressed using the capabilities offered by Dataflow. By leveraging features like automatic windowing, timestamp handling, and deduplication mechanisms based on custom message IDs, developers can build robust streaming data processing pipelines with efficient resource utilization and high fault tolerance.

## Dataflow Windowing Capabilities

Dataflow provides powerful windowing capabilities for streaming data, utilizing three main types of windows: **fixed**, **sliding**, and **session**. Here's a summary with comparisons using markdown syntax:

| Type                                                                                                                                                                 | Apache Beam Terminology                                                                                                                                                                                                                                | Dataflow Specific Term                                                                                                                                                                                                                   | Description                                                                                                                                                                                                                                                                                                                                                                                             | Example Configuration (Python)                                                                               |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| amoeba">**Fixed Window**</td><td>"sliding"</td><td>"tumbling"</td><td>Divides data into time slices with consistent non-overlapping intervals (e.g., hourly, daily). | `window.FixedWindows(60)` creates fixed windows starting every amboa">**Sliding Window**</td><td>"hopping"<td><td>Overlapping windows defined by a minimum gap duration; triggers computing at regular time intervals (e.g., compute every 5 minutes). | `window.SlidingWindows(30, 5)` sets window length to 30 seconds and slides every 5 secondsamboa">**Session Window**</td><td>N/A<td><td>Window defined by a minimum gap duration; suitable for bursty communication (e.g., web sessions). | `window.Sessions(600)` defines session windows with a timeout period of 10 minutes (3600 seconds) using keys to trigger flushing at the end of the timeout periodamboa">**Watermarking and Triggers**</td><td>N/A<td><td>Dataflow uses watermarks to manage latency by determining when all data for a window has arrived. Late-arriving data can be handled based on configuration (default: discard). | Default behavior is `trigger.AfterWatermark()`; Alternative triggers include processing time or after count. |

### Window Configuration Examples in Python

```python
from apache_beam import Map, PCollection, ParDo
import datetime

class MyFn(ParDo):
    def process(self, element):
        # Processing logic here...

p = beam.Pipeline()
data = p | 'Read' >> beam.io.ReadFromText('input_file')
windowed_data = data| 'WindowInto' >> beam.WindowInto(beam.window.FixedWindows(60))
output = windowed_data | 'Process' >> beam.ParDo(MyFn())
p.run()
```

### Handling Late Data with Triggers

Late data can be handled in various ways, depending on the configuration:

- **Discard (Default):** Late-arriving data is discarded by default.
- **Reprocess Window:** Reprocess windows based on late arrivals using custom triggers.

#### Composite Trigger Example

```python
class CustomTrigger(beam.trigger.TriggerFn):
    def on_element(self, element, window):
        return beam.trigger.AfterWatermark() |  # Early processing at the watermark or after a delay
               beam.trigger.Repeatedly(beam.trigger.AfterCount.of(100)) |  # After accumulating 100 elements, regardless of watermark
```

# Streaming Data Pipelines Lab Notes

## Introduction

In this lab, you'll create a streaming data pipeline using Google Cloud Dataflow. The primary objectives of the lab include:

- Collecting traffic events from simulated sensor data via Pub/cu7b3bs.
- Processing raw data into an actionable average.
- Storing processed and raw data in BigQuery for later analysis.

Keywords: Google Cloud Dataflow, streaming data pipeline, Pub/Sub, BigQuery

## Key Components of the Pipeline

1. **Data Collection**: Gather traffic events from simulated sensor data through Google Cloud Pub/Sub.
2. **Data Processing**: Compute an actionable average for each event using Dataflow.
3. **Data Storage**: Store raw and processed data in BigQuery for future analysis.

## Steps to Create the Pipeline

1. Set up a Pub/Sub topic to simulate sensor data input.
2. Initialize Google Cloud Dataflow with necessary configurations (such as project, location, runner type).
3. Construct pipeline logic:
   - Read messages from the Pub/sub topic using `ParDo` function and create an average of traffic events per minute or hour.
4. Write processed data back to BigQuery.
5. Monitor the pipeline's progress through Stackdriver Logging, Error Reporting, and Dataflow metrics.
6. Optimize the pipeline by adjusting worker configs (e.g., number of workers) based on performance.

## Example Code Snippet: Construct Pipeline in Python

```python
from google.cloud import dataflow_client
from google.api_core.exceptions import AlreadyExists, NotFound
from retrying import retry
import os

# Initialize DataFlow client with project id and location configurations
dataflow = dataflow_client.DataflowServiceClient(client_options={"projectId": "<PROJECT_ID>", "location": "<LOCATION>"})

@retry(stop_max_attempt_number=5, wait_fixed=2000)
def create_pipeline():
    # Create pipeline with required transformations and configurations.
    # Read from Pub/Sub topic, process data to calculate average, write back to BigQuery table
    pass
```

## Comparison Table: Keywords & Descriptions

| **Keyword** | **Description**                                        |
| ----------- | ------------------------------------------------------ |
| Dataflow    | The service used for processing and transforming data. |
| Pub/Sub     | Service providing real-time messaging functionality.   |
| BigQuery    | A fully managed, petabyte scale data warehouse.        |

## Conclusion

By following these notes, you'll learn how to:

1. Set up a streaming data pipeline using Google Cloud Dataflow.
2. Process real-time traffic events and compute actionable averages.
3. Store raw and processed data in BigQuery for further analysis.
4. Monitor, troubleshoot, and optimize the pipeline performance.

# Streaming Data Processing: High Throughput BigQuery & Bigtable

**Module Introduction**  
This module focuses on the analysis of streaming data, with a particular emphasis on high-throughput capabilities offered by Google's BigQuery and Bigtable services. Key concepts include real-time data analysis and its significance in driving timely business decaturations.

## High Throughput Streaming Features

1. **Real-Time Analysis**: The ability to analyze streaming data as it arrives, enabling immediate insights for informed decision making.
2. **BigQuery Streaming Data Ingestion**: Utilizes the `gcloud` command line tool and BigQuery's streaming API to ingest high volumes of data in real-time.
3. **Cloud Bigtable High Throughput**: Employs consistent performance, low latency access for processing large datasets with high throughput requirements.

## Comparing BigQuery & Cloud Bigtable

| Feature        | BigQuery                       | Cloud Bigtable                                   |
| -------------- | ------------------------------ | ------------------------------------------------ |
| Data Warehouse | Yes (Serverless)               | No                                               |
| Table Types    | Single-column, Multi-column    | Single-column                                    |
| Query Language | Dremel Standard SQL            | Not applicable                                   |
| Throughput     | High throughput analytics      | Consistent high performance & low latency access |
| Use Cases      | Analytics and Machine Learning | Time Series, IoT data, etc.                      |

## Key Considerations for Streaming Data Analysis

1. **Data Volume**: Ensure the chosen service (BigQuery or Bigtable) can handle high volumes of streaming data ingestion and processing.
2. **Real-Time Insights**: Determine whether real-time analysis capabilities are crucial to driving business decisions, as both services offer distinct advantages in this regard.
3. **Performance & Latency**: Choose the service that best aligns with your performance and latency requirements, considering Bigtable's low latency access compared to BigQuery.
4. **Data Modeling**: Select a suitable data model (single-column or multi-column) based on use cases like analytics, ML models, IoT, etc., for both services.

## Example Python Code Snippet: Streaming Data Ingestion with BigQuery API

```python
from google.cloud import bigquery
import json

# Instantiate a Client class from the Google Cloud BigQuery library
client = bigquery.Client()

def stream_data(project_id, dataset_id, table_id, file_path):
    """Ingest streaming data into a BigQuery table."""

    # Load JSON formatted streaming data
    with open(file_path) as f:
        lines = (line.rstrip() for line in f)  # Strip newline characters from each line

        dataset_ref = client.dataset(dataset_
            table_reference = client.get_table(f"{project_id}.{dataset_id}.{table_id}")

    job = bigquery.InsertJob()

    for data in lines:  # Stream the data line-by-line into BigQuery
        row = json.loads(data)  # Convert JSON formatted string to dictionary object
        client._buffer_insert(job, table_reference, row)

# Usage example
stream_data("my_project", "my_dataset", "my_table", "/path/to/your/json/file.json")
```

# Streaming Data into BigQuery & Visualizing Results with Looker Studio

- **Streaming Inserts**: A separate method from load jobs for adding data to BigQuery tables one item at a time. Allows creation of new tables using temporary schema copies.

  - _Data Availability_: Usually within seconds in streaming buffer before table insertion.

  - _Considerations_: Tolerance for late/missing, out-of-order or duplicated data; additional latency and errors from passing through other services.

  - _Quotas_: Daily limit & concurrent rate limit on streaming inserts (see [documentation](https://cloud.google.com/bigquery/quotas))

    ```markdown
    | Throughput | Multi-region: 3 GBps | Single Region: 30abbr{Mbps} |
    ```

- **Batch vs Streaming Data Ingestion**: Choose streaming if immediate data availability is necessary; else, use batch loading as it's not charged.

- **Insert Code Example** (decoding message body prior to insertion):

  ```python

  # Assume `table_ref` and `row` variables are defined appropriately

  from google.cloud import bigquery

  client = bigquery.Client()


  table_id = f"{client.project}.my_dataset.my_table"

  table_ref = client.dataset("my_dataset").table(table_id)


  errors = client.insert_rows_json(table_ref, [row])

  ```

- **Streaming Data Query**: After streaming into BigQuery, query the receiving table for data review.

- **Visualization with Looker Studio**:

  1. Use Looker Studio to create dashboards and visualizations from BigQuery queries.

  2. Access various features like report name editing, chart customization, and interactive tables.

  3. Share reports while being aware of data source visibility ramifications.

- **BigQuery BI Engine**: Accelerates business intelligence by offering sub-second query response times on BigQuery datasets without the need to manage OLAP cubes separately.

  - _Key Features_: Fast in-memory analysis, intelligent caching service built into BigQuery architecture.

# Notes on Streaming Analytics and Dashboards Lab

## Objectives:

- Learn how to streamline data processing using streaming analytics
- Develop skills in creating dashboards and reports with real-time data from BigQuery within Looker Studio

## Key Concepts:

1. **Streaming Data Processing**
   - Handling continuous, unbounded data flows in real time
   - Efficiently processing high volumes of incoming data
2. **BigQuery as a Streaming Source**
   - Cloud-based, serverless data warehouse by Google
   - Ability to ingest streaming data for immediate analysis and visualization
3. **Looker Studio**
   - Business intelligence platform offering interactive dashboards and reports
   - Integration with BigQuery for real-time data processing
4. **Creating Reports and Charts in Looker Studio**
   - Connecting to a BigQuery data source
     ```sql
     #standardSQL
     SELECT * FROM `project_id.dataset_name.table_name`
     WHERE _TABLE_SUFFIX BETWEEN @start_date AND @end_date;
     ```
5. **Visualizing Streaming Data**
   - Displaying dynamic, up-to-the-minute data insights using charts and graphs
   - Customization of dashboards for monitoring key performance indicators (KPIs) in real time

## Process:

1. Connect Looker Studio to BigQuery as a streaming data source
2. Define the parameters, such as table name, start date, and end date within Looker Studio using SQL queries
   ```sql
   #standardSQL
   SELECT * FROM `project_id.dataset_name.table_name`
   WHERE _TABLE_SUFFIX BETEBETWEEN @start_date AND @end_date;
   ```
3. Create reports and dashboards to visualize the streaming data from BigQuery in Looker Studio
4. Customize charts, graphs, and widgets based on specific business needs for real-time monitoring and decision making

## Comparison of Traditional Batch Processing vs Streaming Analytics:

| Aspect                 | Traditional Batch Processing                                                   | Streaming Analytics                                                            |
| ---------------------- | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ |
| Data Ingestion         | Periodic, scheduled uploads to the data warehouse                              | Continuous ingestion from sources like BigQuery in real-time                   |
| Analysis and Reporting | Historical analysis based on previous periods of collected data                | Immediate insights from up-to-the-minute streaming data                        |
| Scalability            | Limited by periodic upload schedules and system capabilities during peak times | Adaptive to handle high volumes of incoming data in real time                  |
| Cost Efficiency        | Higher costs for handling large historical datasets                            | Reduced storage needs, as only relevant, recent data is processed and analyzed |

To design an effective schema for Google Cloud's Bigtable with the provided example dataset of airline flight information between Atlanta Hartsfield-Jackson International Airport (ATL) and various international destinations, you can consider implementing the following strategies:

1. Create a row key using concatenated values from origin and destination columns to establish unique identifiers for each flight record. For instance: "origin_destination". This will help in grouping flights between specific airports, making it easier to retrieve all relevant records. Additionally, you may include the timestamp as part of your row key construction to facilitate queries based on date ranges or time intervals.

2. Use column families for organizing related data sets and optimizing query efficiency. For example, create a "flights" family containing flight-related information (e.g., departure time, arrival time, delay), an "airports" family with airport details, and a "passengers" family holding passenger-specific records. This will allow you to perform efficient reads on specific column families without retrieving the entire row or needing to search through it.

3. To improve query performance for frequently accessed data (e.eb., current arrival delays), consider using lexicographically sorted row keys by constructing a key from origin, destination, and timestamp columns. This will help in quickly accessing recent events without scanning the entire table.

4. Design your schema with consideration of future query patterns. For instance, if you frequently need to perform operations related to weather data collected at airport cities, create a row key using a hashed city name combined with a timestamp (e.g., "origin_destination" + "\_weather"). This will enable efficient retrieval of contiguous rows for all flights departing from or arriving in the same city during specific time periods.

5. Implement periodic table compaction to remove deleted records and optimize read/write efficiency by reorganizing data on disk. By grouping related rows, you can improve compression ratios and overall performance of your Bigtable instance.

6. Finally, monitor access patterns and adapt the schema design as needed to maintain an even distribution of reads across nodes in the cluster while ensuring that frequently accessed rows are not adversely affecting the balance of storage or compute resources across the entire table. This may require rebalancing tablets based on usage metrics and adjusting row keys, column families, or other aspects of your schema design over time.

By considering these strategies when defining a schema for Bigtable with an airline flight dataset, you can optimize query performance, storage efficiency, and ensure that the system scales well to accommodate growing data volumes and evolving access patterns.

# Optimizing Cloud Bigtable Performance

## Table Schema Design:

- **Distribute Reads/Writps**: Ensure even distribution across the cluster to prevent node overload, enhancing performance.

## Workload Appropriateness for Bigtable:

1. Test with a sufficient amount of data (at least 300 GB) and within an appropriate time frame.
2. Enough shards are needed for all nodes in the cluster to optimize access patterns effectively.

## Cluster Scaling & Monitoring:

- Linear performance increase as more nodes are added, monitored using built-in tools.

## Initialization Period After Scaling Up:

- Bigtable may take up to ^20 minutes* to optimally distribute workload across new nodes post scaling.*[1]

## Disk Type Impact on Performance:

- SSDs provide higher throughput (10,000 QPS) compared to HDDs (500 QPS).

## Network Issues and Data Locality:

- Address network issues; ensure clients are within the same zone as the Bigtable cluster.

## Throughput & Row Size Considerations:

- With 100 nodes, handle up to ^2 million queries per second\* with linear scaling.^[2]
- Smaller rows offer higher throughput and better streaming performance due to less processing time required for cell operations within a row.

## Row Key Selection & Replication Techniques:

- Optimize row keys to avoid creating hotspots, ensuring even data distribution across tablets (preventing load imbalances).
- Use replication in multiple regions or zones to increase availability and isolate workloads using `gcloud bigtable clusters create`.^[3]

## Automatic Failover & Cluster Usage:

- Supports automatic failovers for high availability, enabling separate clusters for writing and reading operations.

## Experimentation & Performance Testing:

1. Perform tests with actual data on at least 300 GB of content over an extended period to account for Bigtable's learning curve and internal optimizations.
2. Utilize the Key Visualizer tool, which automatically generates hourly and daily reports based on access patterns, helping identify hotspots and informing optimization strategies.^[4]

**Footnotes:**

_[1]: Initialization period after scaling up may vary depending on factors such as cluster size and load distribution._

_[2]: Throughput calculations are estimates; actual performance can be influenced by various factors including row sizes, workload balance, etc._

_[3]: Ensure proper configuration of app profiles for efficient failover management based on specific use cases._

_[cuintar]_. Note: The numbers and formulas provided in this document are examples. Please verify actual figures with official Cloud Bigtable documentation or perform empirical testing to gather data relevant to your environment.

# Lab 2: Streamer Data Processing - Streaming Data Pipelines into BigTable

## Objective:

- Launch a **Dataflow** pipeline that reads from **Pub/Sub** and writes into **BigTable**.
- Query the BigTable database using an **HBase shell**.

## Key Concepts:

1. **Streaming Data Processing**
2. **Dataflow Pipeline**
3. **Google Pub/Sub**
4. **Google Bigtable**
5. **Apache HBase Shell**

## Steps for Streaming Data Pipelines into BigTable:

| Step | Task                          | Tools Used            | Purpose                                 |
| ---- | ----------------------------- | --------------------- | --------------------------------------- |
| 1    | Set up Google Pub/Sub Topic   | Cloud Console         | To send and receive streaming data      |
| 2    | Create a BigTable Instance    | Cloud Console         | Store processed data                    |
| 3    | Configure Dataflow            | Cloud Console         | Manage the pipeline execution           |
| 4    | Implement Pipeline in Python  | Google Colab, GCB API | Read from Pub/Sub and write to BigTable |
| 5    | Open HBase Shell for Querying | Apache HBase          | Query data stored in BigTable           |

## Detailed Steps:

**Step 1: Set up Google Pub/Sub Topic**

- Navigate to the [Google Cloud Console](https://console.cloud.google.com/).
- Create a new **Pub/Sub topic** for receiving streaming data from various sources (e.g., IoT devices, user interactions).

**Step 2: Create BigTable Instance**

- In the Google Cloud Console, create a new **Bigtable instance** to store processed and organized data.

**Step 3: Configure Dataflow**

- Set up [Google Cloud Dataflow](https://cloud.google.com/dataflow/) in the Google Cloud Console for managing the streaming data processing pipeline.

**Step 4: Implement Pipeline using Python**

```python
from google.cloud import pubsub_v1, bigtable

# Setup Pub/Sub client and subscription
publisher = pubsub_v1.PublisherClient()
topic_name = 'projects/YOUR_PROJECT/topics/YOUR_TOPIC'
subscription_path = publisher.location_path('YOUR_PROJECT', 'YOUR_REGION', 'YOUR_SUBSCRIPTION')

# Setup Bigtable client and instance
client = bigtable.Client(project='YOUR_PROJECT', admin=True)
instance = client.instance

def process_data():
    # Read data from Pub/Sub
    subscriber = pubsub_v1.SubscriberClient()
    response = subscriber.subscribe(subscription_path, callback=your_callback_function)

    # Write processed data to BigTable
    table = instance.default_table('YourTableName')
```

- Replace `YOUR_PROJECT`, `YOUR_TOPIC`, and `YOUR_SUBSCRIPTION` with your own project details, topic name, and subscription name.
- Implement a callback function (`your_callback_function`) to process the received data from Pub/Sub and write it into BigTable using **Apache HBase API**.

\*\*Step hemical reaction equation:
\[ A + B \xrightarrow{\text{catalyst}} C \]

5. Query the BigTable database using an Apache HBase Shell:

- Access the created Bigtable instance and use the [HBase Shell](https://hbase.apache.org/book.html#shell) to perform queries on the stored data.

# Lab 3: Advanced BigQuery Functionality and Performance

## Objective:

- Explore advanced features of **BigQuery** such as analytic window functions, WITH clauses, GIS functions, and best practices for enhancing query performance.

## Key Concepts:

1. **Analytic Window Functions**
2. **WITH Clause in BigQuery Queries**
3. **GIS (Geographic Information System) Functions in BigQuery**
4. **Best Practices for Optimizing BigQuery Performance**
5. **Building Resilient Streaming Systems on Google Cloud Platform**

## Advanced Features of BigQuery:

1. Analytic Window Functions - Aggregate data over a specified range or window, providing insights into the data trends and patterns within that window.
2. WITH Clause - Simplify complex queries by breaking them down into smaller, more manageable subqueries using common table expressions (CTEs).
3. GIS Functions - Built-in functions in BigQuery for handling geographic data, enabling spatial analysis and mapping capabilities.
4. Query Optimization Best Practices - Techniques to improve query performance in BigQuery, including the use of partitioned tables, clustered datasets, and optimized schema design.

## Exploration of Advanced Features:

- **Analytic Window Functions**
  - Use window functions such as `ROW_NUMBER()`, `RANK()`, and `DENSE_RANK()` to provide insights into the data within a specified range or window.
  ```sql
  SELECT
    date,
    value,
    AVG(value) OVER (PARTITION BY entity ORDER BY date ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) AS moving_average
  FROM `project.dataset.table`
  ```
- **WITH Clause in BigQuery Queries**
  - Break down complex queries using the WITH clause and common table expressions (CTEs).
  ```sql
  WITH cte1 AS (SELECT column1, SUM(column2) as total FROM `project.dataset.table` GROUP BY column1),
       cte2 AS (SELECT column3, MAX(column4) AS max_value FROM `project^project.dataset.table` GROUP BY column3)
  SELECT * FROM cte1 JOIN cte2 ON cte1.column1 = cte2.column3;
  ```
- **GIS Functions in BigQuery**
  - Utilize built-in GIS functions for spatial analysis and mapping capabilities, such as calculating distances between points or finding intersections of polygons.
  ```sql
  SELECT ST_Distance(point1, point2) AS distance FROM `project.dataset.table` WHERE ST_Intersects(polygon1, polygon2);
  ```
- **Query Optimization Best Practices**
  - Implement techniques to improve query performance in BigQuery, such as partitioned tables and clustered datasets:
    ![Partitioned Tables vs. Clustered Datasets](https://cloud.google.com/bigquery/docs/partitioned-tables)
    - Partitioning data based on a specified column to reduce the amount of data scanned by queries.
    - Using clustered datasets to group rows together based on specific columns, improving query performance and reducing costs.
  - Optimize schema design:
    ![Columnar Storage vs. Row-oriented Storage](https://cloud.google.com/bigquery/docs/columnar-storage)
    - Utilizing columnar storage to improve query efficiency by compressing data and only accessing the necessary columns for a given query.

# Analytic Window Functions

## Introduction:

- **Analytic Window Functions** - Advanced analysis capabilities in BigQuery using various function groups for rapid result calculation, enhancing data insights.

## Types of Analytic Window Functions:

1. **Standard Aggregations**
   - Frequently used functions like `COUNT()` with additional details available in documentation.
2. **Navigation Functions**
   - LEAD function returns value from subsequent row to the current one, useful for time-series data analysis and comparisons.
3. **Ranking & Numbering Functions**
   - Ranking of rows based on specific criteria using `DENSE_RANK()`, partitioned by columns (e.g., department) with ordering (e.g., start date).

### Examples:

- Count function:
  ```sql
  SELECT COUNT(*), column1, column2 FROM `table` GROUP BY column1, column2;
  ```

**Navigation Functions Example (LEAD):**

```sql
SELECT current_rental.bike_id,
       LEAD(current_rental.rental_time) OVER (ORDER BY rental_start ASC) AS next_rental_time
FROM `table` current_rental;
```

- Ranking of employees by tenure:
  ```sql
  SELECT employee_id, department, start_date,
         DENSE_RANK() OVER (PARTITION BY department ORDER BY start_among ASC) AS rank_by_tenure
  FROM `table` employees;
  ```

## WITH Clauses:

- **With Clauses** - Instances of name subqueries to isolate operations and simplify complex queries.

| Function     | Purpose                         | Example Usage                            |
| ------------ | ------------------------------- | ---------------------------------------- |
| `COUNT()`    | Count rows within a group       | Aggregation by column values             |
| LEAD         | Compare current row to next row | Analyzing time-series data and trends    |
| DENSE_RANK() | Ranking based on criteria       | Rank employees within departments        |
| WITH Clause  | Isolate subqueries for clarity  | Complex queries with multiple operations |

# GIS Functions in BigQuery

## Introduction:

- **GIS (Geographic Information System)** features within BigQuery enable spatial analysis, manipulation, and representation of data through several built-in functions.

## Types of GIS Functions:

1. **Spatial Point Creation**
   - `ST_GeogPoint(longitude, latitude)` - Converts longitude and latitude into a geospatial object using WKT (Well-Known Text).
2. **Distance Calculation**
   - `ST_DWithin(geography1, geography2, distanceInMeters)` - Determines if two points are within the specified distance (meters) from each other; often used with zip code boundaries.
     3.angs of spatial relationships:
   - Intersection (`ST_Intersects`): Indicates whether two geometries share a space or point in common.
   * Containment (`ST_Contains`): Determines if one geometry entirely contains another.
   * Coverage (`ST_CoveredBy`): Identifies if the extent of one geometry is fully covered by another.

### Example: Bike Stations Analysis

```sql
SELECT COUNT(*), zipcode,
       ST_DWithin(zipcode_geom, station_geom, 1000) AS within_one_km
FROM bike_stations
JOIN zipcodes ON ST_DWithin(ST_GeogPoint(station.longitude, station.latitude), zipcode_geom, 160934); -- 1 km in meters
```

This SQL query counts the number of bike stations within a 1km radius of each zip code and uses `ST_GeogPoint` to create geospatial objects from station coordinates.

## Google Cloud BigQuery Geo Viz Application:

- A tool that simplifies rendering GIS data visualization with minimal setup, enhancing the ability to observe spatial patterns and relationships in large datasets.

To start off, we have a project ready within BigQuery Geo Viz using an app called "gis_demo." We've added our project ID into the query editor to begin working on this project.

Next, we authorized access from Qwiklabs account by allowing it to view and manage data in the project. This enables us to run GIS queries and visualize data within BigQuery Geo Viz.

We've pasted a pre-defined query into the editor which fetches all records from the demo table called "trip_lines." The geometry column used here is named "geometry," with subcolumns for latitude, longitude, altitude, etc., where we focus on the 'latitude' and 'longitude.'

Now let's apply some styling to our visualization. We use the strokeWeight function in BigQuery GIS to create a data-driven line width based on average kilometers per hour from the "trip_lines" dataset:

```sql
SELECT
  geometry,
  ST_AsText(geometry) AS WKTGeometry,
  (strokeWeight := AVG('average_kmph')) AS strokeWeightData
FROM `gis_demo.trip_lines`
```

Next, we'll customize the appearance of our lines by setting a linear function for line width based on average speed:

- Set 'strokeWidthUnits': 'DATA', indicating that line width will be data driven.
- Define a custom range to determine line thickness at various speeds. In this example, we use "average_kmph" as our domain and adjust the ranges according to your preference.

After setting these options in BigQuery Geo Viz, zooming into the map will show you lines with different widths based on their average speed: thicker lines for higher speeds, indicating faster routes between bike stations. By examining these visualizations, we can make assumptions and inferences about travel patterns and preferences within a city like London or New York City.

In addition to the demo, there are many other GIS functions supported by BigQuery such as ST_Distance (to measure distance between points), ST_MakeLine (for creating lines from point sets), ST_DWithin (checking if two geographical objects are within a specific distance of each other), and ST_Intersects (testing whether two geometries intersect).

I encourage you to explore the GIS documentation, examples, and functions in BigQuery Geo Viz. This will help you create more advanced GIS insights and maps using your own datasets.

# Performance Considerations: BigQuery Best Practices

## Key Areas for Optimization

- **Input/Output**: Minimize bytes read from disk.
- **Shuffling**: Reduce bytes passed between stages in the query process.
- **Grouping**: Decrease bytes transferred to each group during grouping operations.
- **Materialization**: Limit permanent data written out to disk (use partition tables).
- **Functions and UDFs**: Optimize CPU usage by selecting computationally efficient queries.

## Best Practices for Data Analysis

1. Analyze dataset structure before writing code, revisiting initial assumptions as necessary.
2. Address data skewness that may have changed during project growth or schema updates.
3. Apply the "dirty dishes" analogy to avoid accumulating work; clean up data early in processing stages.
4. Use approximate aggregation functions for large datasets and liberal use of WHERE clause filtering.
5. Organize table joins with larger tables on the left, using wildcards and table suffixes judiciously when possible.
6. Optimize GROUP BY operations by sticking to low unique value columns; avoid high cardinality or distinct values.
7. Understand data distribution for efficient handling of skew issues (e.g., status column with imbalanced occurrences).
8. Utilize partition tables and break large multi-stage queries into intermediate table materialization steps.
9. Compare costs between storing versus processing data, adjusting strategies based on project needs and resource usage.
10. Monitor BigQuery performance through the Explanation tab in UI after query execution to track processed records.

## Additional Notes:

- Avoid using SELECT \*; instead, select only required columns for efficiency.
- Apply ORDER BY as a final operation where applicable and avoid unnecessary subqueries or WHY clauses.

## Lab Notes: Optimizing BigQuery Queries for Performance

### Objective

- **Minimize input** and output from BigQuery queries
- Use caching of results from previous queries
- Learn efficient joins
- Avoid overwhelming single workers with the query
- Utilize approximate aggregation functions

### Key Techniques for Optimization:

1. **Caching Results**

   - Cache results using BigQuery features (e.g., Query cache, Materialized views)
     ```python
     # Example of a cached view in SQL
     CREATE VIEW cached_results AS
     SELECT * FROM your_table WHERE last_updated > CURRENT_TIMESTAMP() - INTERVAL 1 DAY;
     ```
   - Use caching to store and retrieve previous query results quickly.

2. **Efficient Joins**

   - Use inner joins instead of outer joins when possible, as they are faster
   - Optimize join order by starting with the smallest datasets first

3. **Avoiding Overwhelming Single Workers**
   - Split complex queries into smaller subqueries and then combine results using UNION ALL or JOINs
   - Distribute load evenly across multiple workers if query requires more resources than a single worker can handle

4.amoins overestimating the number of rows processed in each step, as it might lead to resource allocation issues and slow performance.

```sql
-- Example SQL statement for an efficient join with UNION ALL
WITH subquery1 AS (SELECT * FROM table1 WHERE condition),
subquery2 AS (SELECT * FROM table2 WHERE condition)
SELECT * FROM subquery1
INNER JOIN subquery2 ON subquery1.key = subquery2.key;
```

5. **Approximate Aggregation Functions**
   - Use APPROX_COUNT_DISTINCT, APPROX_TOP_COUNT to reduce computation time at the expense of accuracy
     ```sql
     -- Example SQL statement for approximate aggregation functions
     SELECT
       APPROX_COUNT_DISTINCT(column1) AS approx_distinct_values,
       APPROX_TOP_COUNT(3, column2) AS top_three_values
     FROM your_table;
     ```
   - These functions are faster and use less resources but provide approximate results.

### Conclusion

- By implementing caching techniques, optimizing joins, avoiding overwhelming single workers, and using approximate aggregation functions, BigQuery queries can be significantly optimized for better performance.

# BigQuery Query Optimization and Cost Management

## Slots for Resource Consumption & Costs:

- **Slots** exposed by BigQuery manage resource consumption and costs.
- BigQuery calculates required slots based on query size and complexity, with a default allocation that works well in most cases.
- Slot usage can be monitored via cloud monitoring.

## Additional Slot Capacity:

- In circumstances such as complex queries over large datasets with high concurrency workloads, additional slot capacity may improve performance.

## BigQuery Editions & Pricing Models:

| Edition Tier    | Features and Use Cases                           | Autoscaling | Cost Optimization                                                                     |
| --------------- | ------------------------------------------------ | ----------- | ------------------------------------------------------------------------------------- |
| Standard        | Entry-level, low-cost option                     | Yes         | Aligned with basic workload needs                                                     |
| Enterprise      | Broad range of analytics features                | Yes         | High scalability and flexibility required                                             |
| Enterprise Plus | Advanced features for mission critical workloads | Yes         | Multi-region support, cross-cloud analytics, advanced security, regulatory compliance |

## Pricing Options:

1. **Edition Tiers** - Customers can purchase tiers with discounts based on commitment length.
2. **Pay-As-You-Go Model** - Pay for data processed using an on-demand pricing option.
3. **Compressed Storage** - Offers more flexibility in billing, balancing analytics costs between storage and compute. For example: exabeam saw a 12 to cups per unit of compressed vs uncompressed storage; however, the time travel window is shorter (only available for 2 days).

## Query Management & Slots Allocation:

- BigQuery features an autoscaling capability that dynamically manages compute capacity based on workload demands. Users only need to set a maximum size and an optional baseline reservation, leaving slot provisioning and optimization up to the system itself.
- With slots, users pay for what they consume; there is no pile-up of BigQuery jobs as resources are fairly distributed amongst concurrent queries.

## Slot Allocation Example:

Consider a scenario with two projects sharing 2,000 slots and executing multiple queries simultaneously. In this case:

1. If one query execution consumes all available slots (e.g., 1,500), the remaining queries will receive only 500 slits in total to share amongst them. This ensures that no single resource-intensive query overpowers or steals resources from other running queries within BigQuery.
2. Slot allocation remains fair across projects, users, and queries: if one project is underutilizing its allocated slots (e.g., 500 out of 1,000), the remaining slots can be used by the other query or user sharing the same project. This also applies to hierarchical reservations, where a lower-priority project cannot exceed its allotted resources even if higher-priority projects have spare capacity.
