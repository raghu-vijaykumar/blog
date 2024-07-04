# Serverless Data Processing with Dataflow: Course Introduction - Dataflow Foundations

### **Key Points**

- Presented by Mehran Nazir (Product Manager, Google Cloud Dataflow)
- Series based on data engineering specialization concepts
- Focuses on serverless data processing using Apache Beam and Google Cloud Dataflow
- Includes three additional courses: Foundations, Developing Pipelines, Operations

### **Course Content Outline**

1. **Refreshing the Apache Beam Programming Model in Google's Dataflow Managed Service**
   - Understanding fundamental concepts of Apache Beam and how they integrate with Dataflow managed service
2. **Beam Portability Framework**
   - Writing pipelines in preferred languages, execution on desired engines
3. **Dataflow's Premium Back Ends: Separating Compute & Storage for Maximum Performance**
   - Benefits and utilization of compute-storage separation
4. **IAM, Quotas, and Permissions Integration with Dataflow Pipelines**
   - Mechanisms controlling access to resources within the pipeline workflows
5. **Main Security Features & Implementation in Google Cloud Dataflow**
   - Overview of security measures available for data pipelines
6. **Summary: Main Concepts from Foundations Course**
   - Recapitulating key takeaways and fundamental principles

### **Learning Objectives**

- Gain a comprehensive understanding of the Apache Beam programming model, its core concepts, and integration with Dataflow managed service.
- Learn how to leverage the Beam Portability Framework for writing pipelines in preferred languages on various execution engines
- Understand the benefits of using premium back ends that separate compute and storage resources within Google Cloud's Dataflow infrastructure
- Acquire knowledge about IAM, quotas, and permissions management for securing data processing workflows with Apache Beam
- Recognize main security features available in Google Cloud Dataflow environment and how to implement them effectively.

# Beam & Dataflow Refresher: Concepts and Customer Value

### **Presenter**

- Federico Patota, Cloud Consultant at Google

### **Key Points**

- Apache Beam: Open Source Unified Programming Model for Batch & Streaming Pipelines
- Beam SDK Usage with Different Runners and Backend Services
- Dataflow as a Runner in Apache Beam Framework

### **Content Outline**

1. **Apache Beam Overview**
   - Open source unified model for defining both batch & streaming pipelines
2. **Building Pipelines with Beam SDK**
   - Language-agnostic approach, using classes and transforms to define data processing
3. **Runner Selection: Local vs Remote Execution**
   - Choices of engine powering your pipeline based on specified runner
4. **Dataflow as a Runner in Apache Beam**
   - Fully managed service with automated resource provisioning, management & optimization
5. **Google Cloud Integration and Separation of Compute & Storage**
   - Dataflow's role within the Google Cloud ecosystem; dynamic worker balancing for optimal performance
6. **Customer Value: Key Benefits of Using Apache Beam with Dataflow**
   - Efficiency, scalability, resource optimization in data processing workflows
7. **Future Modules & Deep Dive Topics**
   - Compute and storage separation; detailed exploration on how to maximize pipeline execution within Google Cloud's infrastructure

### **Learning Objectives**

- Acquire a comprehensive understanding of Apache Beam, its unified programming model for data pipelines, and the various runners available.
- Gain knowledge about building pipelines using Beam SDK across different languages while leveraging shared classes and transforms.
- Understand the importance of runner selection to optimize pipeline execution based on workload requirements.
- Recognize Dataflow as a powerful fully managed runner within Apache Beam, offering automated resource management and dynamic optimization capabilities.
- Explore how Google Cloud's infrastructure seamlessly integrates with Dataflow for enhanced data processing workflows through compute and storage separation.

# Beam Portability: Framework & Key Benefits

### **Presenter**

- Unnamed Presenter (assuming from context)

### **Key Points**

- Beam portability vision: Write once, run anywhere across various languages and execution engines.
- Language agnostic representation of Beam pipelines through Portability API & Docker containerization for customizable environments.
- Seamless transition from on-premise to Google Cloud Dataflow or other cloud providers without vendor lock-in.

### **Content Outline**

1. **Beam Portability Framework Overview**
   - Aim: Comprehensive portability for data processing pipelines across languages & engines
2. **Pipeline Definition in Diverse Languages**
   - Supported languages: Java, Python, Go, SQL; flexibility to move pipelines between on-premise environments and Google Cloud Dataflow or other clouds
3. **Introduction of Portability API**
   - Language agnostic data structures & protocols for interoperable SDKs & runners
4. **Docker Containerization in Beam**
   - Customizable, isolated worker nodes environment on back-end services
5. **Key Benefits: Enhanced Flexibility & Efficiency**
   - Cross-runner compatibility across all supported languages; multi-language pipelines & cross-language transforms enabled by Portability API and containerization; faster delivery of new features across SDKs (due to uniform updates)

### **Learning Objectives**

- Understand the vision behind Beam portability: Write once, run anywhere.
- Learn about Portability API's role in enabling language agnostic representation and interoperable execution of pipelines across various engines & languages.
- Recognize Docker containerization as a means to customizable worker nodes environments on back-end services.
- Comprehend the multiple benefits provided by Beam portability: Cross-runner compatibility, flexibility in defining multi-language pipelines and cross-language transforms, accelerated delivery of new features across supported languages' SDKs due to uniform updates.

### **Key Takeaways**

| Aspect | Detail |
|------------------------|--------------------------------warted by the following points: |
| Portability Vision | Write once, run anywhere; write pipeline in chosen language and execute with minimal effort on desired engine. |
| Languages Support | Java, Python, Go, SQL among others. Flexibility to move pipelines from on-premise environments to Google Cloud Dataflow or other clouds without vendor lock-in. |
| Portability API | Language agnostic data structures and protocols that ensure interoperable execution of Beam pipelines across all supported languages & engines. |
| Docker Containerization| Provides a customizable, isolated worker nodes environment on back-end services for each operation's processing. |
| Benefits | Cross-runner compatibility; flexibility in defining multi-language pipelines and cross-language transforms; accelerated delivery of new features across supported languages' SDKs due to uniform updates.

# Dataflow Runner v2: Key Features & Integration

### **Presenter**

- Unnamed Presenter (assumed from context)

### **Key Points**

- New version of the Dataflow Runner implementing portability features; uses Apache Beam Portability framework.
- Enhanced worker architecture for custom containers, multi-language pipelines & cross-language transforms support.
- Packaged with Dataflow shuffle service and streaming engine (discussed in subsequent modules).
- Official documentation provided by Google Cloud as reference for enabling Runner vn2 features.

### **Content Outline**

1. **Dataflow Runner V2 Overview**
   - Implementation of portability features; utilizes Apache Beam Portability framework
   - Enhanced worker architecture supporting custom containers, multi-language pipelines & cross-language transforms.
2. **Integration with Dataflow Shuffle Service and Streaming Engine**
   - Packaged together with these components for seamless operation (discussed in upcoming modules)
3. **Enabling Runner vn2 Features**
   - Official Google Cloud documentation as the primary reference source

### **Learning Objectives**

- Understand Dataflow Runner V2's implementation of portability features using Apache Beam Portability framework.
- Recognize enhanced worker architecture for custom containers, multi-language pipelines and cross-language transforms support in the context of data processing with Google Cloud services.
- Comprehend how to enable Runner vn2's features by referring to official Google Cloud documentation.

### **Key Takeaways**

| Aspect | Detail |
|------------------------|--------------------------------warted by the following points: |
| Dataflow Runner V2 | Implements portability features; uses Apache Beam Portability framework for more efficient worker architecture. |
| Enhanced Features | Supports custom containers, multi-language pipelines and cross-language transforms in data processing operations with Google Cloud services. |
| Integration | Packaged together with Dataflow Shuffle Service and Streaming Engine for seamless operation (further discussed in subsequent modules). |
| Official Documentation | Required reference source to enable Runner vn2's features through official Google Cloud documentation.

# **Container Environments: Apache Beam SDK & Custom Containers**

### Presenter (Unnamed)

## Key Points:

- Containerization of the Beam SDK Runtime Environment with Docker for isolation from other runtime systems
- Each user operation associated with a custom environment. Default environments provided by supported SDKs, allowing further customizations.
- Benefits include ahead-of-time installation, inclusion of arbitrary dependencies, and additional customization possibilities through containerization.

## Content Overview:

1. **Introduction to Container Environments**
   - Beam SDK Runtime Environment can be containerized with Docker for isolation purposes
2. **User Operations & Default Environments**
   - Each user operation associated with an environment, which is customizable using the provided defaults by supported SDKs
3. **Benefits of Containerization**
   - Ahead-of-time installation, inclusion of arbitrary dependencies, and additional possibilities for further customizations through containerization
4. **Running a Pipeline with Custom Containers**
   - Requirements: Apache Beam SDK version 2.cuinty (at least) & Docker installed if running locally
   - Process: Create a `Dockerfile` specifying the Apaché Beam image as parent, add customizations, build and push to Container Registry (e.g., gcr.io), launch Dataflow job referencing regular parameters + container image location

## Learning Objectives:

- Understand how Apache Beam SDK Runtime Environment can be isolated with Docker for better efficiency.
- Comprehend the concept of user operation environments, their customizability using provided defaults by supported SDKs.
- Recognize benefits that arise from containerization such as ahead-of-time installation and inclusion of arbitrary dependencies among others.
- Learn process to run a pipeline with custom containers: requirements & Dockerfile creation, building image and pushing it to Container Registry (e.g., gcr.io), and launching Dataflow job referencing regular parameters + container image location.

## Key Takeaways Table:

| Aspect                                  | Detail                                                                                                                                                                                                                                                             |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Beam SDK Runtime Environment            | Can be containerized with Docker for isolation purposes                                                                                                                                                                                                            |
| User Operation Environments             | Each associated with a custom environment, which is customizable using provided defaults by supported SDKs.                                                                                                                                                        |
| Benefits of Containerization            | Ahead-of-time installation, inclusion of arbitrary dependencies among others.                                                                                                                                                                                      |
| Running Pipeline with Custom Containers | Requires Apache Beam SDK version 2.cuinty (at least), Docker if running locally; involves creating a `Dockerfile`, building and pushing image to Container Registry like gcr.io, launching Dataflow job referencing regular parameters + container image location. |

# **Cross-Language Transforms: Apache Beam**

### Presenter (Unnamed)

## Key Pointnits:

- Cross‑language transforms allow multi‑language pipelines with portability, leveraging benefits of dual SDKs.
- Example: Python pipeline using I/O connectors available only in Java; TensorFlow extended code block for machine learning model in Java pipeline.
- Apache Beam enables language agnostic representation of pipelines and the ability to specify environment per operation.

## Content Overview:

1. **Introduction to Cross‑Language Transforms**
   - Multi-language pipelines, portability, benefits of dual SDKs
2. **Example Use Cases**
   - Python pipeline using Java I/O connectors; TensorFlow extended code for machine learning model in a Java pipeline
3. **How It Works: Apache Beam Cross‑Language Transforms**
   - Language agnostic representation, specifying environment per operation
4. **Under the Hood: Implementation of Python and Java Pipeline Fragments**
   - Local Java service on your computer for creating and injecting Java pipeline fragments into Python pipelines; downloading/staging necessary Java dependencies at runtime. Dataflow workers execute both Python & Java code simultaneously to run pipeline.

## Learning Objectives:

- Understand the concept of cross‑language transforms enabling multi‑language pipelines with portability, leveraging benefits of dual SDKs.
- Recognize examples showcasing use of I/O connectors available only in one language (e.g., Java) within another language pipeline (e.g., Python); using TensorFlow extended code for machine learning model in a different language pipeline.
- Comprehend how Apache Beam enables language agnostic representation, environment specification per operation; and the process of creating/injecting Java pipeline fragments into Python pipelines with simultaneous execution by Dataflow workers.

## Comparisons:

| Feature                                                    | Python Pipeline (With Cross‑Language Transforms)                                             | Java Pipeline (Without Cross-Language Transforms)                                                                                   |
| ---------------------------------------------------------- | -------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| Use of I/O Connectors                                      | Can use Java I/O connectors within Python pipeline.                                          | Cannot use cross-language transforms to utilize other language's I/O connectors.                                                    |
| TensorFlow Extended Code Blocks for Machine Learning Model | Can include TensorFlow extended code block from a different language (Java) in the pipeline. | Cannot integrate TensorFlow extended code blocks from another language within the pipeline without using cross-language transforms. |

# **Separating Compute and Storage in Google Cloud: Dataflow**

### Presenter (Unnamed)

## Key Points:

- Dataflow allows executing Beam pipelines on Google Cloud with fully managed, auto-configured service.
- Optimization of graph execution through efficient fusion of operations & non-waiting for previous steps unless dependencies exist.
- Autoscaling in the middle of a pipeline job to meet resource requirements without manual scaling or unnecessary payment for unused VM resources.
- Strong streaming semantics with correct aggregations like sums and counts, even if input sources send duplicate records.

## Content Overview:

1. **Dataflow Overview**
   - Fully managed, auto-configured Beam pipelines execution on Google Cloud.
2. **Optimization Features in Dataflow**
   - Efficient fusion of operations; non-waiting for previous steps unless dependencies exist.
3. **Autoscaling and Resource Management**
   - Step-by-step autoscaling based on job needs without manual scaling or payment for unused VM resources.
4. **Strong Streaming Semantics with Dataflow**
   - Correct aggregations like sums & counts, even if input sources send duplicate records. Intelligent watermarking when writing records later.
5. **Separating Compute and Storage with Dataflow Services**
   - Use of Shuffle Service, Streaming Engine, and flexible resource scheduling to save money and time.

## Learning Objectives:

- Understand the concept of fully managed, auto-configured Beam pipelines execution on Google Cloud via Dataflow.
- Identify optimization features in Dataflow such as efficient fusion of operations & non-waiting for previous steps unless dependencies exist.
- Comprehend autoscaling and resource management mechanisms to meet job needs without manual scaling or payment for unused VM resources within Dataflow.
- Recognize the strong streaming semantics with correct aggregations even when input sources send duplicate records, along with intelligent watermarking.
- Utilize Dataflow services like Shuffle Service, Streamer Engine, and flexible resource scheduling to separate compute and storage while saving money and time.

# **Dataflow Shuffle Service: Understanding Its Functionality and Benefits**

### Presenter (Unnamed)

## Key Points:

- Dataflow shuffle is a scalable, efficient, fault-tolerant operation behind transforms such as group by key, compute by key, and combine.
- Shuffle operations move out of the worker VMs into the Dataflow Service back end for batch pipelines only.
- Benefits include faster execution time, reduced resource consumption (CPU, memory, persistent storage), better autoscaling capabilities, improved fault tolerance, prevention of job failure due to unhealthy VM holding Shuffle data.

## Content Overview:

1. **Dataflow Shuffle and Its Role**
   - Scalable, efficient & fault-tolerant operation for transforms like group by key, compute by key & combine.
2. **Shuffle Operation Transition in Dataflow**
   - Moves out of worker VMs to the back end of the Dataflow Service for batch pipelines only.
3. **Benefits of Utilizing Dataflow Shuffle Service**
   - Faster execution time, reduced resource consumption (CPU, memory & persistent storage), enhanced autoscaling capabilities, improved fault tolerance.
4. **Prevention from Job Failure with Dataflow Shuffle Service**
   - Unhealthy VM holding shuffle data won't cause the entire job to fail; prevents this scenario by moving operations into back-end service.
5. **Learning Resource Reduction and Autoscaling Enhancements through Dataflow Shuffle Service**
   - Worker nodes have less CPU, memory & persistent storage usage due to shuffling data being moved out of VMs; this improves autoscaling as nodes can be scaled down earlier.
6. **Understanding Fault Tolerance Improvements with Dataflow Shuffle Service**
   - An unhealthy VM holding shuffle data won't cause the entire job to fail, which provides better fault tolerance.
7. **Enabling Dataflow Shuffle Service for Batch Pipelines**
   - Refer to official Dataflow documentation on how to enable this service for batch pipelines.

## Learning Objectives:

- Comprehend the role and functionality of a shuffle in Dataflow, including its scalability, efficiency, and fault tolerance.
- Understand that the Shuffle Service feature moves operations out of worker VMs into the back end of the Dataflow Service for batch pipelines only.
- Acknowledge benefits like faster execution time, reduced resource consumption (CPU, memory, persistent storage), enhanced autoscaling capabilities, and improved fault tolerance when using Dataflow Shuffle Service.
- Grasp how unhealthy VMs holding shuffle data won't cause entire job failure with the service in place.
- Learn to enable the Dataflow Shuffle Service for batch pipelines by referring to official Dataflow documentation.

# **Dataflow Streamebling Engine: Features & Advantages**

### Presenter (Unnamed)

## Key Points:

- Offloads state storage from persistent disks attached to worker VMs and implements an efficient shuffle for streaming cases.
- No code changes required; worker nodes run user code, implement data transforms, and communicate transparently with the Streaming Engine.
- Reduction in resource consumption (CPU, memory, persistent disk storage) on worker VMs; works best with smaller worker machine types like N1 standard ^2.
- Lower resource and quota consumption due to reduced need for larger worker disks beyond a smaller boot disk.
- Improved responsiveness of pipelines to variations in incoming data volume.
- Enhanced supportability as no redeployment is needed when applying service updates.

## Content Overview:

1. **Functionality & Operation of Dataflow Streaming Engine**
   - Offloads state storage from persistent disks attached to worker VMs and implements an efficient shuffle for streaming cases.
2. **Seamless User Experience with No Code Changes**
   - Worker nodes run user code, implement data transforms, and communicate transparently with the Streaming Engine; no modifications necessary in existing codebase.
3. **Reduction in Resource Consumption on Worker VMs**
   - Diminished utilization of CPU, memory, and persistent disk storage resources within worker VMs due to streamlined state management. Optimized for smaller machine types like N1 standard ^2.
4. **Lower Resource & Quota Consumption**
   - Minimal resource needs and quota consumption with the use of a reduced boot disk size; no larger persistent disks required, leading to cost-effective solutions.
5. **Improved Responsiveness in Pipelines**
   - Enhanced adaptability to fluctuations in incoming data volumes due to streamlined state storage and efficient shuffle mechanisms within the Streaming Engine.
6. **Enhanced Supportability Through Service Updates**
   - No need for redeployment of pipelines during service updates, ensuring seamless maintenance and support with minimal disruptions in operations.
7. **Activation & Guidance**
   - For activation instructions and additional guidance on using the Dataflow Streaming Engine, refer to official documentation provided by Dataflow.

# **Flexible Resource Scheduling (FlexRS) Overview**

### Presenter (Unnamed)

## Key Pointn:

- Cost reduction in batch processing pipelines via advanced scheduling techniques using the Dataflow Shuffle Service and a combination of preemptable and normal virtual machines.
- Submission process involves placing jobs into queues, with execution within <6 hours> from job creation. Suitable for workloads that are not time critical (daily/weekly) which can be completed within specific time windows.

## Content Overview:

1. **Introduction to Flexible Resource Scheduling (FlexRS)**
   - Cost-saving technique for batch processing pipelines using advanced scheduling, Dataflow Shuffle Service integration, and a mix of preemptable and normal VMs.
2. **Submission & Execution Process in FlexRS**
   - Job submission involves queuing the job with eventual execution within <6 hours> from creation date. Ideal for non-time critical workloads like daily or weekly jobs that can be completed within a designated time window.
3. **Early Validation Run and Error Reporting in FlexRS**
   - Immediate validation run upon job submission to verify execution parameters, configurations, quota, and permissions; ensuring prompt error reporting for failures without waiting for delayed executions.
4. **Enabling & Guidance on Flexible Resource Scheduling (FlexRS)**
   - For activation instructions and additional guidance on using the Flexible Resource Scheduling feature within Dataflow, consult official documentation provided by Dataflow.

## Comparison Table:

| Aspect           | Traditional Batch Processing    | **Flexible Resource Scheduling (FlexRS)**            |
| ---------------- | ------------------------------- | ---------------------------------------------------- |
| Cost Efficiency  | Standard VMs used               | Uses advanced scheduling, preemptable and normal VMs |
| Execution Window | Fixed or unpredictable          | Submitted job executed within <6 hours> window       |
| Suitability      | Broad range of workloads        | Non-time critical (daily/weekly) workloads           |
| Error Reporting  | Delayed reporting in some cases | Immediate error reporting after validation run       |

# Summary: IAM Roles and Permissions in Google Cloud's Dataflow

## Introduction

- **Topic**: Understanding IAM roles, quotas, and permissions for running Dataflow on Apache Beam
- **Presenter**: Omar Ismail (Solutions Developer at Google Cloud)

## Key Points

1. **IAM Roles in Dataflow**: Determines access to Dataflow resources based on user submission of Beam code.
2. **User Account Representation**: Each account is represented by an email address, e.g., Omar@mysuccessfulcompany.com.
3. **Dataflow Viewer Role**: Allows users to view only the Dataflow jobs without submitting or updating them.
4. **Dataflow Developer Role**: Enables submission of jobs and management of running pipelines; requires additional roles for specific tasks like staging files in Cloud Storage buckets.
5. **Dataflow Admin Role**: Provides minimum permissions needed to create and manage Dataflow jobs, including file-staging and Compute Engine quota viewing.
6. **Service Accounts**: Essential for interaction between project and Dataflow; includes Dataflow Service Agent account (default) and Controller Service Account account (customizable).

## IAM Roles Summary Table

| Role      | Permissions                                                              | Usage                                                                   | Additional Notes                               |
| --------- | ------------------------------------------------------------------------ | ----------------------------------------------------------------------- | ---------------------------------------------- |
| Viewer    | View jobs only                                                           | Limited access; no submission or update allowed                         | Cannot view Compute Engine quota               |
| Developer | Submit and manage running pipelines, view available Compute Engine quota | Ideal for pipeline management; customizable with additional permissions | Requires extra roles to stage files in buckets |
| Admin     | Create/manage Dataflow jobs, view Compute Engine quota                   | Minimum necessary permissions for creating and managing jobs            | Customizable with extra permissions as needed  |

## Service Accounts Summary Table

| Type                       | Usage                                                                           | Additional Notes                                                                                                   |
| -------------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------ |
| Dataflow Service Agent     | Interact between project and Dataflow (e.g., checking quotas, creating workers) | Automatically created when enabling the API; assigned default roles                                                |
| Controller Service Account | Assigned to Compute Engine VMs for running pipelines                            | Default account is `project-number-compute@developer.gservices.com`; customizable with extra permissions as needed |

## Conclusion

In summary, IAM plays a crucial role in determining access and permissions when running Dataflow jobs on Apache Beam within Google Cloud Platform (GCP). By understanding the different roles and service accounts available, users can effectively manage their resources while adhering to best security practices.

# Dataflow Quotas Summary

## CPU Quota

- **CPU quota**: Total number of virtual CPUs across all VM instances in a region/zone.
- Consumed by products like DataProc, GKE, AI notebooks.
- Accessible on the IAM quota page under UI.
- Example consumption: 21cups (cpu) in northamerica‑northeast1 region.

### CPU Quota Usage Example for a Job:

```markdown
| VM Size | Number of Workers | Total CPUs Required                                              | Available Limit | Outcome               |
| ------- | ----------------- | ---------------------------------------------------------------- | --------------- | --------------------- |
| N1 std1 | 100               | \(100 \text{ workers} \times 1 \text{ core/worker}\) = 100 CPUs  | 600             | Job runs              |
| N1 std8 | 100               | \(100 \text{ workers} \times 8 \text{ cores/worker}\) = 800 CPUs | 600 (Limit)     | Error: Quota exceeded |
```

_(Code Snippet)_

## In-Use IP Address Quota

- **In-use IP address quota**: Limits the number of VMs with an external IP per region.
- Shared across all Google Cloud products that create VMs with an external IP.

| Default Setting   | Requirement                       | Cost Implication                                      | Note                                        |
| ----------------- | --------------------------------- | ----------------------------------------------------- | ------------------------------------------- |
| External IP       | API/service access outside GC     | Higher cost, consumes quota                           | Can be changed to internal only for savings |
| Internal IPs Only | No need for external API/services | Saves money and conserves the in-use IP address quota |                                             |

_(Code Snippet)_

```bash
# Example command to launch a Dataflow job with internal IPs:
gcloud dataproc jobs submit ... --internal-ip
```

## Persistent Disk Quotas

- **Hard Disk Drive (HDD)** and **Solid State Drives (SSD)** quotas per region.
- Flags to set the disk type are `workerDiskType` with prefixes 'pd-std' for HDDs and 'pd-ssd' for SSDs.

| Disk Type | Default Size | Usage Example                          |
| --------- | ------------ | -------------------------------------- |
| PD-SSD    | 25 GB        | Batch job with shuffle service         |
| PD-STD    | 250 GB       | Streaming jobs running on VMs          |
| Override  | Custom size  | `disk_tile_size` flag for custom sizes |

_(Code Snippet)_

```bash
# Set persistent disk size to a custom value (e.g., 100 GB):
--disk-tile-size=102400MB
```

## Streaming Jobs Quotas and Flags:

- **Maximum Number of Workers**: Equals the number of disks allocated in a streaming job.
- Default is 100 for jobs not using streaming engine, can be set up to 1,000 with `max_num_workers`.

_(Code Snippet)_

```bash
# Set maximum number of workers:
--max_num_workers=25
```

## Dataflow Security: Data Locality

- **Module Overview**: Omar Ismail (solutions developer at Google Cloud) discusses enhancing security when running on Dataflow with a focus on four features; this summary concentrates on **Data Locality**.

### Understanding Data Locality

1. **Definition and Purpose**: Ensures that data, metadata stay within one region to meet compliance/security needs & minimize network latency/transport costs.
2. **Regional Endpoint Role**: Managed project communicates between user's project and regional endpoint via Dataflow service account.
3. **Data Transfer between Project and Regional Endpoint**: Regular health checks, work requests, autoscaling events & unexpected incidents like unhandled exceptions or job launch failures due to permissions.
   4.anguage>
4. **Visibility on Dataflow UI**: Transferred items visible, including pipeline parameters, job details (name, ID, start time).

### Reasons for Specifying a Regional Endpoint

1. **Security and Compliance**: For bank projects in certain countries with regulations against data leaving the country of operation.
2. **Network Latency & Cost Minimization**: If source/sink/staging locations are within the same region, no network egress charges apply.

### Specifying a Regional Endpoint for Dataflow Jobs

- **Supported Regional Endpoint (No Zone Preference)**: Use regional flag only; automatic selection of best zone based on capacity in Apache Beam 2.15+ is mandatory.
- **Specific Zone within Region with Regional Endpoint**: Set both region and worker_zone flags to specify the exact zone.
- **Region without a Regional Endpoint**: Use both regional and worker_region flags; this could result in increased latency as data needs to travel between regions.

### Key Notes on Data Locality & Metadata Transfer

- Only metadata is transferred if the chosen region for the regional endpoint differs from where application data resides, ensnaring no actual application data movement across regions.

## Shared VPC: Enhancing Security with Delegated Administration

- **Module Overview**: Omar Ismail (solutions developer at Google Cloud) discusses Shared VPC, enabling delegated admin responsibilities while maintaining centralized network control.

### Understanding Shared VPC in Dataflow Jobs

1. **Defining Shared VPC**: A networking setup that allows organization admins to delegate tasks like instance creation and management within a host project, whilst controlling resources (subnets, routes, firewalls).
2. **Dataflow Network Options**: Either the default network set by Google Cloud upon creating a project or custom networks defined with specified regions and subnets.
3. **Worker Count & IP Availability**: Ensure adequate IP addresses for worker count based on subnet (/29, e.ebit) allocation (e.g., 4 workers per /29 subnet).
4. **Compute Network Role Requirement**: Dataflow service account needs the Compute Network user role at project or subnet level within host project.
5. **Network Flags in Shared VPC**: Difference between network (project-level) and subnetwork flags demonstrated via Python and Java examples.

### Comparisons of Default vs Custom Networks & Subnet Level Roles

| Aspect                   | Default Network                                              | Custom Network                                                                 |
| ------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------------------------ |
| Configuration            | Automatically set by Google Cloud upon project creation      | Manually configured with specific regions and subnets                          |
| Worker Deployment        | Based on available IP addresses within the default network   | Based on defined subnet availability; e.g., /29 limits to 4 workers per subnet |
| Role Assignment (Python) | Compute Network role set at project level                    | Not applicable for Python example, demonstrating project-level assignment      |
| Role Assignment (Java)   | Dataflow service account permissions defined at subnet level | Demonstrates how to assign roles at the more granular subnetwork level         |

## Private IP Addresses: Enhancing Security & Resource Efficiency

- **Module Overview**: Discussing a security feature of Dataflow - disabling external IP usage for worker instances, and its implications on infrastructure security and resource management.

### Understanding the Use of Private IPs in Dataflow Jobs

1. **Disabling External IP Usage**: A method to block workers from internet access, enhancing data processing security within Dataflow's environment.
2. **Resource Management Impact**: Reduces public IP address consumption against your in-use IP quota by default assigning both private and public IP addresses to worker instances.
3. **Network Access with Private IPs Only**: Limits resource accessibility only to the following networks when external internet use is disabled:
   - Another instance within the same VPC network
   - Shared VPC network
   - Network with VPC network peering enabled
4. **Private Google Access & Communication**: When using custom networks, private Google access must be enabled for subnets where worker instances will run to facilitate communication with other Google services and APIs. Disabling this may restrict VM instance's internet accessibility unless alternative options like Cloud NAT are used.
5. **Flags Configuration**: To exclusively use internal IP addresses, two flags need to be added:
   - Network or subnetwork specification for worker deployment (either `--network` or `--subnet`)
   - Flag `-n` (`no use public IPs`) to enable Dataflow workers with private IP address only.

| Aspect                 | Private IP Usage              | Public IP Usage                  |
| ---------------------- | ----------------------------- | -------------------------------- |
| Internet Accessibility | Blocked (Enhanced security)   | Allowed (Default configuration)  |
| Resource Quota Impact  | Reduces public IP consumption | Consumes from in-use IP quota    |
| Network Access         | Limited to specific networks  | Unrestricted access              |
| Private Google Access  | Required for custom networks  | Not applicable (Default setting) |

## Customer-Managed Encryption Keys (CMEK): Enhancing Data Security

1. **Key Concept**: CMEK - A security feature enabling customers to manage encryption keys for data at rest in various storage locations within a Dataflow job's lifecycle.
2. **Storage Locations Requiring Encryption**: Binary files containing pipeline code, Cloud Storage buckets (for temporary storage/export/import), persistent disks attached to workers, and back-end storages for batch or streaming jobs need encryption.
3. **Default Security Measures**: Google managed keys are used by default to encrypt data at rest in any of these locations.
4. **CMEK Advantages & Implementation**:
   - CMEK allows using customer-managed symmetric keys, stored within the Google Cloud key management system. This enhances security and flexibility for encryption at different storage locations.
   - Data keys used in operations (windowing, grouping, joining) will be decrypted with custom CMEKs during pipeline execution.
   - For added security, hash or transform the encryption key.
5. **Job Metadata Encryption**: Job metadata is encrypted using Google's default encryption; this includes user-supplied data (job names, job parameters) and system-generated data (job IDs, worker IP addresses).
6. **Roles & Permissions for CMEK**: Dataflow service account and controller agent service account must have Cloud KMS CryptoKey Encrypter/Decrypter roles to use CMEKs.
7. **Flags Required for Launching Job with CMEK**: Two flags need to be specified, including a temp location flag specifying the Cloud Storage path for temporary file staging and a dataflowKmsKey flag indicating the key's location in Google KMS.
8. **Regional Limitations & Restrictions**: The Dataflow job region, CMEK key region, and storage bucket region must all be identical; global or multiregional keys will not work. Overriding worker regions/zones to a different region than the key's region makes regional keys unusable.

### Comparison of Encryption Methodologies:

| Feature                        | Google Managed Keys                 | CMEK (Customer-Managed)                                      |
| ------------------------------ | ----------------------------------- | ------------------------------------------------------------ |
| Control & Flexibility          | Limited by default options          | Higher, with custom keys                                     |
| Usage Across Storage Locations | Default for all mentioned locations | Allowed across same storage locations as Google managed keys |
| Security Level                 | Standard encryption                 | Customizable; can hash or transform the key                  |
| Role Requirements              | None specified                      | CryptoKey Encrypter/Decrypter roles required for accounts    |

# Course Summary: Serverless Data Processing with Dataflow

**Topic**: Setup IAM & Networking for your Dataflow Jobs

## Key Learnings

1. **Apache Beam and its relationship with Dataflow**:

   - Apache Beam is an open-source programming model that provides a unified approach to both batch and streaming pipelines, eliminating the need for managing multiple data processing architectures (lambda architecture).

2. **Dataflow as a Google Cloud Product**:

   - Dataflow serves as a fully managed distributed data processing engine designed specifically for Apache Beam pipelines within the GCP ecosystem.
   - It automates worker machine provisioning and orchestration, utilizing techniques like horizontal autoscaling and dynamic work rebalancing to minimize total cost of ownership.

3. **Apache Beam Portability Framework**:

   - The framework promotes interoperability between different execution backends through the portability API, allowing for custom containers and multi-language pipelines without modifying code when enabled via a pipeline option in Runner v2 implementation.

4. **Separation of Compute & Storage**:

   - Dataflow allows separation of compute resources from storage, resulting in cost savings by offloading the shuffle operation onto the service backend (batch pipelines) and window state storage for streaming pipelines. This leads to reduced resource footprints and improved autoscaling with data latency benefits.

5. **Flexible Resource Scheduling - FlexRS**:

   - Helps save costs in batch pipelines by combining the use of preemptable VMs and shuffle backends, enabling features without code modifications during pipeline deployment through parameter passing.

6. **IAM & Networking Interactions with Dataflow Pipelines**:
   - Predefined roles for Dataflow users are available alongside different service accounts utilized to run pipelines. Quota considerations involve vCPUs, IPs, and persistent disks during capacity planning exercises related to Dataflow workloads.
   - Implementing the right security model includes: complying with data locality requirements by specifying region/zone parameters; VPC configurations; preventing data exfiltration via public IP disabling on workers; default encryption of at-rest data using Google-managed keys, and integration with CKMS for custom key management.

**Conclusion**: The course provided an in-depth understanding of Apache Beam's relationship to Dataflow, the benefits of the Portability framework, cost savings through compute/storage separation, Flexible Resource Scheduling (FlexRS), and best practices concerning IAM & Networking interactions.

# Serverless Data Processing with Dataflow - Developing Pipelines

## Course Overview

- **Product Manager:** Mehran Nazir, Google Cloud Dataflow

## Key Concepts & Techniques Covered in this Course Series

1. Understanding of various Google Cloud services for data processing needs
2. Familiarity with Dataflow's IAM, quotas, security model and its key features:
   - Beam portability framework
   - Compute/Storage separation (Shuffle & Streaming Engine)
3. Launching methods of a Dataflow pipeline:
   - Create Job Wizard in Cloud Console (non-coding approach).
   - Apache Beam SDK in development environment (.java, .py for Jupyter Notebooks).
   - SQL statements in the Dataflow SQL UI (with streaming extensions).
4. Detailed focus on developing pipelines using the Beam SDK and a module dedicated to Dataflow SQL.
5. Review of previous courses' concepts including:
   - Building blocks of the Apache Beam model
   - Windows, watermarks, triggers, sources & sinks, schemas
   - State & timers (for in-flight data control)
6. Best practices for maximizing performance and exploring domain-specific languages (SQL, DataFrames).
7. Introduction to Beam Notebooks for Python developers.
8. Summary of all concepts covered.

# Apache Beam Concepts Review

## Introduction

- **Presenter:** Israel Herraiz, Strategic Cloud Engineer at Google.

## Key Concepts of Apache Beam & their Application in Data Processing Pipelines

1. Unification of traditional batch and stream processing concepts by Apache Beam is a major innovation.
2. **Four primary concepts:**

   - _PTransforms_
     - Instructions containing actions on data.
       - Handle input transformation and output creation.
   - _PCollections_
     - Distributed, immutable abstraction holding the data to be processed.
     - Any change results in a new PCollection as output; original is unaltered.
   - _Pipelines_
     - Identifies the data (from PCollections) and actions (via PTransforms).
       - Data flows through pipeline from one PTransform to another via graph-like structure.
   - _Pipeline Runners_
     - Analogous to container hosts like Kubernetes engine, enable scalable execution.

3. **Immutable data**: A key differentiator between batch and stream processing.
   - Enables simplified distributed processing as there's no need for coordination or access control of original ingested data.

# Utility Transforms in Apache Beam

## Overview

- **Purpose:** Provide building blocks for creating complex processing logic at scale using Dataflow.

## Key Utility Transforms & their Applications

1. ParDo (Parallel do)
   - Function application to each element of a PCollection.
2. GroupByKey
   - Assembles elements sharing the same key within one worker node, useful for commutative and associative operations on large or skewed data sets.
3. Combine
   - Hierarchical transformation over groups with better performance than GroupByebyKey when handling large groups & performing commutative/associative operations.
4. CoGroupByKey
   - Allows joining of two PCollections based on a common key; supports various join types like left outer, right outer and inner joins.
5. Flatten
   - Merges multiple input PCollections into one PCollection provided they contain the same value type. Not to be confused with joins or CoGroupByKey operations where different value types share a common key.
6. Partition
   - Divides an input PCollection into several output PCollections based on group IDs assigned by a function, opposite of Flatten operation.

# Apache Beam's DoFn Lifecycle

## Key Concepts & Functionalities

- **DoFns**: Versatile and powerful functions for processing PCollections beyond basic map/filter operations.
- **ParDo**: The main transform behind DoFn, providing flexible functionality for various data processing tasks.

## Higher Level Utility Transforms (HTs)

1. Filtering
   - Removes elements based on specific conditions from a PCollection.
2. Mapping
   - Applies a function to each element in the input PCollection, generating new output values.
3. FlatMapping
   - A combination of mapping and filtering operations with added keying capabilities for complex data transformations.
4. Key/Value Addition (KVA)
   - Enables adding or modifying keys or associated values within a PCollection.

## DoFn Lifecycle Methods

1. **Setup()**: Called once per worker, ideal for initializing resources like database connections, network connections, etc.
2. **StartBundle()**: Initiated at the beginning of each data bundle processing stage; suitable for tracking and monitoring purposes using instance variables or metrics.
3. **Process()**: The core transform method that applies operations on individual elements within a data bundle, allowing access to input arguments, state objects, timers, etc.
4. **FinishBundle()**: Invoked after processing all elements in the current bundle; useful for performing batch updates or external system interactions (e.g., updating database records).
5. **TearDown()**: Executed once a worker has finished its task and is no longer needed, responsible for cleaning up resources initialized during Setup().

## Best Practices & Key Notes

- Avoid mutating state objects directly within the process method; instead, utilize state variables to maintain consistency across bundles.
- Ensure that external states are not modified from the process method, as multiple workers may be processing identical data in parallel for redundancy purposes.
- Store state information in maps based on relevant keys due to potential key presence within a single bundle (especially with FlatMapping).

# Serverless Data Processing with Apache Beam & Cloud Dataflow

## Summary:

The lab focuses on utilizing Apache Beam and Google Cloud Dataflow for serverless data processing through Extract-Transform-Load (ETL) pipelines in Java and Python languages. Key concepts include windowing, watermarks, and triggers that enable handling continuous streams of non-stationary data, ensuring orderly processing despite out-of-order delivery.

## Main Topics:

1. **Windowing**: Dividing data into time-based chunks (fix windows) or complex event-time window types to accommodate unbounded stream processing. Apache Beam offers three default window types - fixed, sliding, and session-based windows with the possibility for custom window creation.

2. **Watermarks**: The mechanism used by Dataflow to understand when a window is ready for producing results based on incoming data timestamps. Watermarks allow handling out-of-order delivery of events without compromising orderly processing.

3. **Triggers**: Control the emission frequency and timing of outputs within windows, depending on factors like watermark progress or window expiry. Triggers ensure consistent output while managing the tradeoff between latency (realtime response) and throughput (processing efficiency).

## Comparison Table for Window Types:

| Type                  | Characteristics                                     | Example Use Cases          | Frequency                   | Overlap | Notes                               |
| --------------------- | --------------------------------------------------- | -------------------------- | --------------------------- | ------- | ----------------------------------- |
| Fixed Windows         | Consistent non-overlapping intervals                | Hourly, Daily aggregations | Consistent                  | No      | Useful for regular time slices      |
| Sliding Windows       | Represents overlapping or non-overlapping intervals | Moving averages            | Variable (e.g., 30 seconds) | Yes/No  | Determines when a new window starts |
| Session-Based Windows | Data-dependent, determined by user activity gaps    | User session analysis      | Dependent on data           | N/A     | Identifies bursts of user activity  |

## Key Concepts:

1. **Batch vs Streaming Pipelines**: Batch pipelines process data at regular intervals and chunk large amounts, while streaming pipelines handle continuous non-stationary data as a string with real-time updates.
2. **Data Order & Out-of-Order Delivery**: Apache Beam's windowing mechanism handles out-of-order events by assigning them to the appropriate windows based on their event timestamps, ensuring orderly processing and accurate calculations in streaming pipelines.

### Advanced Bullet-Point Notes Summary

#### Watermark Concept in Dataflow:

- A watermark defines when a windowed data processing operation can be considered complete based on event and processing timestamps.
- It determines whether messages are early, on-time, or late for the given window duration.
- Default behavior is to drop late data unless configured otherwise using triggers.

#### Important Key Terms:

1. **Watermark**: A marker indicating how far behind a stream of events has progressed in time relative to a reference point (usually, current time).
2. **Event Timestamp**: The timestamp associated with each incoming event or message.
3. **Processing Time Stamp**: The system's clock at the moment when an event is processed.
4. **Window Duration**: A specified period during which events are grouped for processing.
5. **Trigger**: Specifies how and when to emit results from a windowed computation, including handling late data.
6. **Data Freshness Metric**: Measures the time difference between real-time and the timestamp of the oldest unprocessed message in Dataflow's input queue.
7. **System Latency Metric**: The time taken for a message to be fully processed, including any waiting time at the data source.
8. **Auto-Scaling**: Dynamic adjustment of resources based on demand and performance metrics within Google Cloud Dataflow.
9. **Backlog**: A queue of messages waiting to be processed by the pipeline.

#### Watermark Mechanism in Action:

1. _Event Arrival_: Events arrive with their timestamps at different rates.
2. _Watermark Establishment_: Dataflow's system establishes a watermark, marking how far back it will consider for windowed computations based on the event arrival rate and processing delays.
3. _Window Evaluation_: When an event arrives, its timestamp is compared against the current watermark to determine if it falls within any active window. If so, this event triggers further computation or result emission as defined by the triggering logic (e.g., accumulation-based, early firing).
4. _Handling Late Data_: Depending on the configuration and trigger used, late data may be handled differently—dropped, reprocessed, or processed with a new window if applicable.
5. _Data Freshness & System Latency Indicators_: These metrics help monitor input rates (data freshness) and processing delays (system latency), informing the need for auto-scaling to maintain optimal performance.

#### Dataflow's Auto-Scaling Based on Metrics:

1. _Data Freshness & System Latency_: Monitors whether these metrics are stable, increasing due to input rate spikes or processing delays.
2. _Response Strategies_:
   - **Stable Metrics**: Auto-scaling may be unnecessary if the system is balanced.
   - **Increased Data Freshness & Stable Latency**: Indicates increased input rate; auto-scaling up to accommodate more messages.
   - **Increased System Latency (Stable/Reduced Input Rate)**: Suggests processing bottlenecks, potentially requiring additional resources for smoother operation.

# Notes: Apache Beam Windowing & Trigger Mechanisms

## Key Concepts:

- **Watermark**: Indicates completeness of data within a window for event time or processing time; used to determine if results can be emitted.
- **Metrics**: Provide insights on watermark progression and latency in result production (default trigger).
- **Triggers**: Determine when to produce results based on conditions like time, data volume, or a combination.
- **Accumulation Modes**: `accumulate` retains all messages for each new calculation; `discard` only uses the latest batch of messages for each trigger event.

## Types of Triggers:

1. **Event Time Trigger**: Results are emitted based on message timestamps (e.cuation in time). Examples include:
   - After a fixed period (`trigger.after(Duration.ofSeconds(secs))`).
   - When the watermark crosses a threshold relative to event time (`trigger.after_all_elements()`).
2. **Processing Time Trigger**: Results are emitted based on processing time, typically used for micro-batching. Examples include:
   - After a fixed period from window opening (`trigger.after(Duration.ofSeconds(secs))`).

## Important Parameters:

- `TriggerType`: Selects the trigger mechanism (e.g., `AfterWatermark`, `AfterProcessingTime`).
- Allowed lateness determines how late data is handled; it's supported in Python SDK for Dataflow and other runners.
- Window size defines the duration or number of elements within a window, e.g., event time sliding windows with 5 minutes (`Window.byKey(FixedWindows.of(Duration.standardMinutes(5))))`.

## Examples:

Python SDK (Dataflow and other runners):

```python
# Event Time Windowing & Trigger Example
from apache_beam import Create, Map, GroupByKey, ApplyPairCombineFunction, CombinePerKey, AfterWatermark, DoFn, PTransform, ParDo, Restriction, TransformDerived, TypeDelegator
import datetime

def emit(element: dict) -> None:
    yield element['id'], {'value': element['value']}

trigger = trigger.after_all_elements()  # Trigger after all elements in window are processed
windowed_values = (pipeline
                   | "Create" >> Create([{'id': 'a', 'value': 1}, {'id': 'b', 'value': -3}])
                   | "WindowInto" >> Window.into(FixedWindows(7))
                   | "GroupByKeyAfterWatermark" >> GroupByKeyAfterWatermark() # or AfterWatermark() in Dataflow & other runners)
```

Java SDK:

```java
// Event Time Windowing & Trigger Example
public class Main {
    public static void main(String[] args) throws Exception {
        PipelineOptions options = PipelineOptionsFactory.create();
        pardoContext = new PardoContext(options);

        JavaCollection<Record> input = pardoContext.apply("/path/to/input").read().withBoundedStreaming(true).build().all();

        Trigger trigger = WindowTrigger.afterFixedIngestionTime(Duration.standardHours(1)); // 1 hour fixed window size
    }
}
```

# Serverless Data Processeing with Dataflow

## Lab Topics:

- Batch Analytics Pipelines with Cloud Dataflow (Java)
- Batch Analytics Pipelines with Cloud Dataflow (Python)
- Using Dataflow for Streaming Analytics (Java)
- Using Dataflow for Streaming Analytics (Python)

## Module Focus:

Sources and Sinks in Google Cloud Dataflow. Learn about Text IO, File IO, BigQuery IO, Pub/Sub IO, Kafka IO, Bigtable IO, Avro IO, and Splittable DFns with associated useful features for each IO.

## Key Points:

1. **Data Pipeline Components**:
   - _Sources_: Read input data into a Beam pipeline; generally appears at the beginning of a pipeline but not always.
   - _Sinks_: Write output data from your Beam pipeline; performs write to specified destination (e.g., Bigtable IO, File IO).
2. **PTransformations**:

   - Operations that take an input and provide an output in the form of PDone for signaling completion or other outputs like bounded/unbounded data sources.

3. **Bounded vs Unbounded Sources**:

| Bounded Source             | Unbounded Source                                                                 |
| -------------------------- | -------------------------------------------------------------------------------- |
| Finite input               | Reads from an unbounded amount of input                                          |
| Split work                 | Dynamically rebalance for better performance                                     |
| Known start and end points | Data bookmarking with checkpoints; point-in-time data estimates using watermarks |

4. **Pub/Sub IO**:
   - Ability to pass a Record ID allowing message deduplication, tracking IDs for ebted messages automatically discard record if duplicated after 10 minutes.

## Additional Resources:

- Apache Beam Documentation (for updated list of various IO connectors and more information)

# NotesGPT Summary on Text IO & File IO

**Text IO:**

- **Purpose:** Working with text sources and sinks
- Keywords: Reading methods, Java example for simple read using Text IO

Java Example (Simple Read):

```java
import com.google.dataflow.javalang.textio.TextIO;

public void main(String[] args) {
    // Provide file name as the first step
    String fileName = "example.txt";

    // Use TextIO to read from the provided file name
    TextIO textIO = TextIO.read();
    Iterable<String> lines = textIO.from(fileName);
}
```

Python Examples:

- **Example 1**: File name as input, passed into a method that reads content from a file
- **Example 2**: Directly reading from a file using the filename and accessing contents & metadata via an object (variable X)

File IO in Java:

```java
import com.google.dataflow.javalang.fileio.BeamFileIO;

public void main(String[] args) {
    // Monitoring location for a particular pattern every 30 seconds, for one hour
    String pattern = "<your_pattern>";
    int intervalSeconds = 30;

    BeamFileIO.matchPattern(filePattern, new File("/path/to/monitor"), intervalSeconds, 60);
}
```

**Contextual IO:**

- **Purpose:** Enhanced behavior of text reading, handling more complicated Text IO reads and writing to different file systems or object stores.
- Keywords: Return ordinal position, read multiline CSV records, Java sink example using Text IO, Dynamic destinations

Java Sink Example (Writing Output):

```java
import com.google.dataflow.javalang.textio.TextIO;

public void main(String[] args) {
    // Write output to a file or object store using TextIO
    String fileName = "output_file.txt";

    TextIO textIO = TextIo.write();
    textIO.to(fileName);
}
```

Python Dynamic Destinations Example:

- Determining the sink destination at runtime based on transaction type or record characteristics, allowing flexibility without altering codebase

# BigQuery IO

BigQuery IO is a useful connector for **Google BigQuery**, a scalable and serverless data warehouse.

## Reading from BigQuery

- Use standard SQL statement to retrieve results from BigQuery
  - Dataflow submits the query to BigQuery, retrieves metadata first
    ```markdown
    EXAMPLE: SELECT \* FROM table_name WHERE condition;
    ```
- BigQuery exports the results to a temporary staging location in Google Cloud Storage
- Dataflow reads the contents from there, prioritizing throughput

## Mapping and Processing Results

- Map read data from Google Cloud Storage for use in the data pipeline

## High Throughput with BigQuery Storage API

- Built to facilitate consumption from distributed processing frameworks (e.g., Beam)
  - Achieve high throughput when reading from BigQuery
- Use DIRECT_read method to invoke Storage API read method
  ```markdown
      EXAMPLE: bqRead[DIRECT_READ]
  ```

## Column Projection and Filtering

- Reduce the number of columns accessed by using column projection feature with selected fields
- Apply a simple predicate filter for row restriction via .withRowRestriction clause

# Writing to BigQuery

BigQuery IO supports writing to BigQuery with various options, including:

1. **Dynamic Destinations**
   - Utilize dynamic destinations to route writes to multiple tables in BigQuery (varying schemas)
2. **Schemas Specification**
   - Use built-in schema functionality for efficient specification
3. **Streams and Batches**
   - Write streams or batches with file loads method, windowing data if needed
     ```python
         # Python Example: BigQuery Dynamic Destination Write
         def get_destination(record):
             destination = "table1" if condition else "table2"
             return {
                 "data": record["field"],
                 "dynamicDestination": dynamicDestination,
             }
     ```
4. **Streaming Jobs**
   - Default to streaming write method by default

# Pub/Sub IO

Google's highly scalable and robust messaging service: **Pub/Sub**

## Connecting Google Cloud Dataflow with Pub/Sub

- Use \*\*Pub/

sub IO\*\* for seamless integration between the two services

## Reading from a Pub/Sub Topic (Java Example)

1. **Automatic Subscription Creation & Destruction**
   - When deployed: A subscription is automatically created by Pub/Sub IO
   - Upon termination: The subscription is destroyed
2. **Persistent Subscriptions**
   - Create a permanent subscription using the `fromSubscription` method for persistence upon job termination
3. **Message Acknowledgment & Durable Persistence**
   - Pub/Sub IO automatically acknowledges messages when data is durably persisted in Dataflow
4. **Windowing Features & Timestamps**
   - Default to using Pub/Sub's message timestamp for windowing features
   - Optionally, reassign timestampt values for additional calculations (e.g., reported vs published timestamps)
5. **Capturing Failures: Dead Letter Queues**
   - Divert messages meeting specific criteria to a dead letter queue for further examination or action
6. **Reading from Kafka & Publishing to Pub/Sub**
   ```markdown
   EXAMPLE:
   Scenario 1: Regular flow of messages
   Messages go through processing and are published successfully to Pub/Sub
   Scenario 2: Failed messages diversion
   Messages that fail or require a second look are sent to a dead letter queue (second topic)
   ```

# **Kafka IO**

Google'cu's Kafka IO provides an unbounded source for streaming data, with checkpoints to allow resumption of reads and topic selection based on subscribed topics or specific single-topic requests. It supports cross-language transforms through Beam's conceptual framework.

## Key Features & Functionality:

1. **Unbounded Source**
   - Kafka IO functions as an unbounded source, making it ideal for streaming data applications (e.g., real-time analytics)
2. **Checkpoints**
   - Enables the resumption of read operations using bookmarks to save progress and prevent data loss or duplication upon restarting the process
3. **Topic Selection & Subscriptions:**
   - Kafka topics store streams of records, with flexibility in topic selection through submitting parameters for specific lists or a single-topic request (using "with-topic" parameter)
4. **Cross-Language Transforms:**
   - Leverages Beam's cross-language transform concept to allow the use of Kafka IO across multiple software development kits, including Python using its native `kafka` module and Java directly
5. **Python Integration via Cross-Language Transforms:**
   ```markdown
   EXAMPLE: - A call in a Python script utilizing Kafka IO through the cross-language transform enables access to the functionality originally built for Java, by invoking external calls from libraries implemented within the Python environment.
   ```

# **BigTable IO**

Google's scalable noSQL database service, BigTable, offers high throughput and scalability. The module connecting it to Dataflow is BigtableIO which facilitamoes communication between both services. Key features include:

1. **Row Filtering:**
   - Enables selection of rows based on specific criteria using the `RowFilter` clause in BigtableIO for efficient data processing and retrieval
2. **Index Utilization & Prefix Scan with WithKeyRange():**
   ```markdown
   - Allows quick access to desired prefixes by performing a scan across an index, optimizing query performance and resource utilization
   ```
3. **Continuous Pipeline Flow Post-Sink Write:**
   - By triggering the `Wait.on` function in Beam during BigtableIO sink writes, users can continue with additional transformations after a write has completed, ensuring continuous data processing without interruption or delay
4. **Scalability & High Throughput Design:**
   ```markdown
   Both BigTable and Dataflow are designed for high throughput and scalability to efficiently handle large-scale data operations in real time
   ```

# **Avro IO**

A popular file format for big data, AvroIO allows reading and writing self-describing files (files that contain both schema and data). Key features include:

1. **Self-Describing Files:**
   - Provide schema information along with the data in the file, enhancing flexibility during processing or analysis without prior knowledge of the file structure
2. **Read/Write Operations:**
   - AvroIO facilitates reading from and writing to Avro files, which support various data types and complex structures (e.n., records, arrays) with efficient serialization techniques for performance optimization
3. **Schema Retrieval within Beam Pipeline:**
   ```markdown
   By leveraging built-in functions in AvroIO, users can seamlessly integrate the schema into their Beam pipeline without manual intervention or separate steps to parse file formats
   ```
4. **Multiple File Processing with Wildcards:**
   - Enables processing of multiple files using wildcard patterns within Python code snippets (e.g., `*.avro`), allowing batch operations on related datasets for streamlined analysis and improved efficiency

# **Splittable DoFn**

Enhanced version of standard _Do Functions_ (DoFns) that improve upon sources' capabilities, especially with regards to streaming and batch processing integration. Splittable DFns play a crucial role in advancing Beam's unified programming model by enabling:

1. **Source Enhancebilities & Streaming/Batch Programming Integration:**
   - Allow sources to use the flexibility, modularity, and ease of coding from the DoFn syntax while incorporating splittability for better progress tracking
2. **Progress Metrics Tracking:**
   ```markdown
   Enable monitoring of a bundle's advancement within its assigned workload through metrics like progress reporting
   ```
3. **Work Distribution Across Multiple Bundles:**
   - Facilitate splitting the entire workload into smaller, more manageable bundles that can be processed independently or in parallel
4. **Custom Source Creation & Restriction Setting:**
   - Enable users to define custom data sources by setting restrictions on file reading sequences and leveraging DoFn parameters such as restriction tracker for complete units of work (e.g., initial_restriction function)
5. **Open-Source Code Referencing:**
   ```markdown
   Accelerate development processes by utilizing existing open-source code examples in both Python and Java, available through provided links
   ```

# **Beam Schemas**

Introduced by David Sabater (Outbound Product Manager for Data Analytics at Google Cloud), Beam schemas enhance distributed processing capabilities in Apache Beam's PCollections:

1. **PCollection Uniformity:**
   - Ensures elements within a collection are of the same type, such as JSON objects or byte strings (plaintext)
2. **Blob Management for Distributed Workers:**
   ```markdown
       Enables encoding individual PCollection elements as byte strings to be efficiently transferred between transforms and distributed workers.
   ```
3. **Types in Common Beam Sources:**
   - JSON, Avro, Protobuf, or database raw objects with well-defined structures can serve as intermediate types (e.cuative POJOs/structures) across SDK pipelines.
4. **Structural Awareness for API Efficiency:**
   ```markdown
   By understanding record structure within a pipeline and applying schemas, APIs become more concise and efficient in data processing tasks.
   ```
5. **Database Schema Paradigms (1970s):**
   - Leveraging long-established schema concepts from the database world to optimize distributed data processing architectures within Apache Beam's framework.
6. **Schema Characteristics:**
   - Primitive and nested types, field names/indexes (strings or numerical), optional markings ('nullable', 'required'), and array/map type fields are common schema features across most structure records in data processing pipelines.

# **Code Examples for Data Processing Using Beam Schemas**

Presented by David Sabater (Outbound Product Manager for Data Analytics at Google Cloud), here are concise API examples in Apache Beam's Java SDK, demonstrating the benefits of using schemas:

1. **Filtering Purchases Based on Geolocation:**
   - Utilizes longitude and latitude coordinates to filter purchases.
2. **Support for Multiple Languages:**
   ```markdown
   The examples provided cover Java, with Python, SQL, and DataFrames versions introduced later in the course; public documentation available on Apache Beam's website covers schema usage across these languages.
   ```
3. **Conciseness of Code Implementation:**
   - Features showcased how filtering streams using lambdas (Java SDK 8) can simplify code complexity, both with and without schemas.
4. **Joins in Data Processing:**
   - Joining transactions and purchases from an online system to calculate total purchases per transaction, grouped by user ID. This example highlights the benefits of using schemas for readability and ease of management compared to non-schema Java codebases that require type casting steps.

# Serverless Data Processeing with Dataflow: Branching Pipelines

**Topic Covered**: Utilizing State API and Timers for Stateful Transformations in Apache Beam's DoFn

## Key Concepts & Features

1. **State API**: Enables state variables to accumulate data across multiple elements, facilitating aggregations without using GroupByKey or Combine.
2. **ParDo (parallel do) Transformation**: A stateless transform that can be extended into a stateful one via the State API for performing calculations requiring state from different messages.
3. **State Variables**: Local to each transformation, used to store and mutate data during element processing. They are not shared between workers in the same key.
4. **Timers**: Provide an effective solution when a buffer does not reach MAX_BUFFER_SIZE. Timers help clear state variables after specific time intervals or conditions have been met.
5. **Batch Processing for External Services**: State variables allow batch processing and reducing the number of calls to external services during large data processing, preventing overwhelming these services with too many requests simultaneously.

## Python & Java Implementation Example

The implementation example below demonstrates how state variables can be utilized within Apache Beam's DoFn in both Python and Java languages.

```python
class MyDoFn(beam.DoFn):
    def __init__(self, max_buffer_size=10):
        self.BUFFER = []
        self.MAX_BUFFER_SIZE = max_buffer_size

    @sf.timerutil.RepeatedTimer('3s')  # Timer to clear the buffer every 3 seconds or after MAX_BUFFER_SIZE elements are added
    def process(self, element, *args, **kwargs):
        self.BUFFER.append(element)

        if len(self cuisine > self.MAX_BUFFER_SIZE:
            # Call external service here with batched data from buffer (omitted for simplicity)
            self.BUFFER = []
```

```java
@ProcessElement
public void processElements() {
    List<String> buffer = getState(BufferStateKey.class, new BufferSpec());

    // Add elements to the buffer state
    buffer.add(inputValue);

    if (buffer.size() > MAX_BUFFER_SIZE) {
        callExternalServiceWithBatchDataFromBuffer(); // Call external service with batched data from buffer (omitted for simplicity)
        resetState(BufferStateKey.class, new BufferSpec());
    }
}
```

## Comparison of Python and Java Implementation:

- Both implementations utilize the State API to enable stateful transformations in ParDo function.
- The timerutil.RepeatedTimer is used in Python for clearing the buffer after a specified time or number of elements have been added. In Java, resetState() method clears the state after calling external services with batched data from the buffer.
- Both implementations demonstrate how to handle the last messages that may not reach MAX_BUFFER_SIZE without leaving them indefinitely.

# Timer API: Combining State Variables & Timers

Combine state variables with **timers** for rich, complex stateful transformations. Use event time & processing time timers based on watermark values and worker clocks respectively.

## Event Time Timers

- Depend on watermark value.
- Influenced by input data rate; can fire when data is stale.

```python
def expiry_callback(context, timer_spec, event_time):
    # Handle the state clearing process here
    pass

@sf.with_inputs('messages')
class MyDoFn(beam.DoFn):
    def __init__(self):
        self.timer = None

    ...

    @sf.types.beam.typehints.WithTimestampAndWatermarkAnnotations()
    def process(self, element):
        ...

    def expiry_callback(self, context, timer_spec, event_time):
        # Clear state and perform any necessary operations
        pass

    @sf.types.beam.typehints.OnTimer()
    def on_timer(self, timer_info):
        self.expiry_amoke()
```

## Processing Time Timers

- Depend on worker's clock.
- Expires at regular intervals regardless of data progress.

```java
@Override
public void startBundle(Context c) {
    Timer timer = TimerFactory.system().currentTimer(); // Start the processing time timer
}

@Override
public void onTimer(@Nullable long window, @Nullable Trigger firingTrigger) {
    System.out.println("On Timer: " + window);
    // Clear state and perform any necessary operations
}
```

## Combining State & Timers

- Use timers to ensure that the state is not held indefinitely.
- Allow DoFn functions to finish even when new messages aren't incoming.

| Event Time Timer | Processing Time Timer |
| :--------------: | :-------------------: |
| Watermark based  |   Regular intervals   |
|    Stale data    |     Worker clock      |
|    Dependent     |      Independent      |

## Decision Factors

- Use event time timers when dealing with stale data.
- Processing time timers work best for regular interval callbacks, regardless of input data progress rate.

# Summary: Using State and Timers in Apache Beam

Apache Beam provides two types of timers - **Processing Time Timers** and **Event Time Timers**. They are essential for implementing various data processing tasks within your pipelines, such as timeouts or output based on data completeness. Here is an overview:

## Types of Timers in Apache Beam

1. Processing Time Timers
   - Relative to the previous messages
   - Good for predictable latencies and incomplete results
2. Event-Time Timers
   - Based on message timestamps
   - Ideal for complete outputs with potential high latency

### Key Considerations:

- Always clear event timer state after output emission
- Clearing prevents DoFns from continuously waiting, reducing resource consumption

## State Variables in Apache Beam

Apache Beam provides several state variables to accumulate and process data effectively. The choice of variable depends on the specific needs and characteristics of your pipeline:

1. ValueState (Genetic)
   - Can hold any value type
2. BagState
   - Efficient for adding elements, no guaranteed order
3. Combining State
   - Aggregates associative and commutative data types efficiently
4. MapState
   - Key-value pairs with random access; efficient retrieval of specific keys
5. SetState (Not supported in Dataflow)
   - Similar to BagState for holding unique elements

## Applications of State and Timers

Apache Beam's state and timers offer a vast range of possibilities, allowing you to implement domain-specific triggers based on various criteria beyond time:

1. Slowly changing dimensions (dimension table referencing)
2. Complex joins in streaming or graph data processing
3. Fine control over element aggregation logic within DoFns

## Conclusion

State and timers are powerful features of Apache Beam, enabling complex workflows that go beyond simple mapping and filtering operations. The only limitation lies in your imagination when applying these tools to implement intricate data processing tasks.

# Module Resources: Best Practices for Schemas in Dataflow

## Introduction to Beam Schemas

- **Schemas** describe data types via named fields with specific values.
- They enable efficient processing of structured data within Dataflow pipelines.
- Provides readability and maintenance benefits, as well as backend optimizations by the Dataflow service during serialization and deserialization stages.

### Schema Structure:

1. **Nested Fields**: Support nested schema structures with repeated or complex fields for versatile data representation.
2. **Type Awareness**: Enhances code comprehensibility while allowing Dataflow to optimize encoders and decoders based on the structured data types involved.

## Example of Beam Schemas in Java and Python SDKs

```java
// Sample schema for a class representing an item with associated details
public class Item {
    /** Unique identifier for user */
    @Schema(name = "user_id", required = true)
    private String userId;

    /** Unique identifier for the purchased item */
    @Schema(name = "item_id")
    private String itemId;

    // Additional fields: shipping_address, cost_cents, transactions
}
```

```python
# Sample schema for a class representing an item with associated details in Python SDK
class Item:
    """An object encapsulating information about a purchased item."""

    user_id = Field(str)  # Unique identifier for the user
    item_score = Field(int, required=True)  # Unique identifier for the purchased item

    # Additional fields: shipping_address, cost_cents, transactions
```

# Handling Unprocessable Data: Best Practices

## Introduction and Importance of Error Handling in Pipelines

- **Real-world data handling**: Erroneous records are common; pipelines must be designed to manage them.
- Avoiding pipeline failures due to unexpected or undesirable record formats is crucial for robust system behavior.

### Strategy Overview: Dead Letter Sink Pattern Implementation

1. **Persistent Storage**: Diverting erronenous records to a separate storage medium (e.g., BigQuery, Cloud Storage).
2. **Double Tags Utilization**: Facilitates multiple outputs from the resulting PCollection for efficient data management.
3. **ProcessElement Function with Error Handling**: Enhances error isolation and control within user code execution.
4. **Selective Logging of Exceptions**: Prevents overwhelming the pipeline by avoiding exhaustive exception logging.

```python
def process_element(element, state=None):
    try:
        # Attempt data processing here
         ...
    except (ErrorType1, ErrorType2) as err:
        # Send erroneous records to a dead letter sink using the 'dead-letter' tag.
        yield pcollection.sideOutput('dead-letter', element)
```

#### Key Code Insights:

- Line 11 represents sending erroneous elements to a side output with `dead_letter` tag, segregating them from the main process flow.
- At line n (not shown in snippet), data is routed to an alternative sink for further examination or rectification actions.

# Error Handling in Dataflow Pipelines: Best Practices

## Introduction and Importance of Robust Exception Management

- **Error Presence**: Acknowledging that errors are inherent parts of any data processing pipeline is the first step towards building fault-tolerant systems.
- **Performance & Reliability**: Appropriate error handling ensures high performance and reliability in a Dataflow pipeline.

### Best Practices for Error Handling

1. **Exception Isolation with DoFn Functions**: Incorporating try/catch blocks within user code written in the DoFn functions allows better control over exception management.
2. **Severity-based Exception Handling**: Different exceptions should be handled based on their severity to maintain system stability and data integrity.
3. **Persistent Storage of Raw Data for Error Analysis**: Rather than logging errors, raw unprocessed erroneous records should be sent out as side output into a storage medium (e.g., BigQuery, Cloud Bigtable) with the help of stream column(s). This facilitutes detailed error analysis and recovery actions.
4. **Multiple Output Sinks Utilization**: Double tags are useful in writing data to multiple sinks for efficient management and processing flow control.
5. **Dead-letter Queue Usage for Erroneous Records Management**: A dead-letter queue is essential for handling erroneous records separately, ensuring their non-disruptive impact on the main pipeline operations.

```python
def process_element(element, state=None):
    try:
        # Attempt data processing here
         ...
    except (ErrorType1, ErrorType2) as err:
        yield pcollection.sideOutput('dead-letter', element)
```

#### Key Code Insights:

- The provided snippet demonstrates handling exceptions in user code by sending erroneous records to the 'dead-letter' tag for separate processing or rectification.

# Utility Classes for POJO Generation: Exploring Apache Beam's AutoValue

## Introduction and Key Concepts

- **POJOs (Plain Old Java Objects)**: Essential when dealing with key/value objects or handling object state in Java pipelines.
- **Apache Beam Schemas**: A superior choice for representing structured data due to their intuitive nature, but sometimes POJOs are still necessary.
- **AutoValue Class Builder**: A tool provided by the Apache Beam SDK for generating POJOs efficiently and accurfly.

### Importance of AutoValue in Java Pipelines

1. **Efficiency & Accuracy**: Hand building POJOs is time-consuming, error-prone, and can lead to inconsistent applications. The AutoValue class builder ensures accurate generation of necessary overrides for equals and hash code methods while avoiding potential errors introduced by hand coding.
2. **Integration with Apache Beam Schemas**: The use of AutoValue is highly compatible within the Apache Beam codebase, allowing users to develop robust pipelines in Java using Dataflow. Furthermore, it can be used alongside Apache Beam schemas when an @DefaultSchema annotation is added.
3. **Referenced Documentation**: Comprehensive information on utilizing AutoValue effectively can be found within the respective section of the reference material provided by Apache Beam.

```java
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MyPojo {
    protected MyPojo(int myField) {}
     ...
}
```

#### Key Code Insights:

- The provided snippet demonstrates an example of using AutoValue to create a simple POJO. The annotation `@AutoValue` generates all necessary boilerplate code, including equals and hashCode methods, avoiding manual coding mistakes or oversight.

# Best Practices in Handling JSON Data within Apache Beam

## Core Concepts and Tools

- **JSON Strings**: Often need conversion into rows or Plain Old Java Objects (POJOs) during pipeline processing, particularly when handling click stream information from web applications.
- **Apache Beam's JsonToRow**: A built-in transform for converting JSON strings to rows.
- **AutoValue and POJO Conversion**: Use @DefaultSchema annotation to register schema for the type and use Convert utility class to convert a JSON string into a POJO, with code resembling this example:

```java
@AutoValue
public abstract class MyPojo {
    protected MyPo^o(int myField) {}
     ...
}
```

- **Dead-letter Pattern**: A method for managing unprocessable messages resulting from unexpected structures or schemas.

#### Key Code Insights and Practical Implementation

- The provided code snippet is an example of using AutoValue to create a POJO, ensuring accurate generation of necessary overrides in the equals() and hashCode() methods while avoiding potential errors introduced by manual coding.

```java
import com.google.auto.value.AutoValue;
import org.apache.beam.sdk.transforms.JSON.JsonToRow;
...
PCollection<MyPojo> pojos = input.apply(new JsonToRow<>());
```

- When dealing with unpredictable changes in the structure of JSON data, use a dead-letter pattern to handle any messages that are unable to be processed due to these unexpected structures or schemas. For more information on this practice and its implementation, refer to the section titled "Queuing Unprocessable Data for Further Analysis."

# Utilizing DoFn Lifecycle for Micro-Batching in Apache Beam

## Understanding the Role of DoFns

- **DoFns**: These are key components in Dataflow pipelines, providing functionalities to transform each input element. They play a critical role when dealing with big data use cases and external APIs integration.

```java
public class MyDoFn extends DoFn<KV<String, String>, String> { ... }
```

## Leveraging the Lifecycle of DoFns for Micro-Batching

- **Lifecycle Functions**: The lifecycle methods `StartBundle` and `FinishBundle` can be overridden to implement micro-batching. This approach optimizes calls to external APIs, preventing service endpoint overloads.

```java
@Override
public void startBundle(IncrementalAggregator<K> aggregator) {
    ... // Initialize or reset batch here
}

@Override
public void finishBundle() {
   ... // Commit the micro-batch in this function
}
```

## Important Considerations and Pseudo Code Snippets for Micro-Batching

- Depending on the runner implementation, `StartBundle` and `FinishBundle` may be called multiple times to process more than one bundle.
- To ensure correct micro-batch behavior, reset variables appropriately while using lifecycle functions or do fun.

## Pseudo Code for Implementing Micro-Batching

```java
public class MyDoFn extends DoFn<KV<String, String>, String> {
   private List<String> batch = new ArrayList<>();  // Batch holder list

   @Override
   public void startBundle(IncrementalAggregator<K> aggregator) {
       batch.clear();  // Reset the batch at the beginning of each bundle
   }

   @Override
   public void processElement(...) {
       ...
       batch.add(...);  // Add processed elements to batch here
   }

   @Override
   public void finishBundle() {
       for (String element : batch) {
           ... // Process each micro-batched element
       }
   }
}
```

# Pipeline Optimization Best Practices in Apache Beam

## General Guidelcuences for Designing Dataflow Pipelines

- **Filter Early**: Implement data filtering as early as possible within the pipeline, and move any operations reducing data volume upwards. This improves overall efficiency by minimizing data flow through the pipeline.

```java
pCollection<String> filtered = pCollection1.apply(Filters.custom((in) -> { ... }))
```

- **Window Transformations**: Consider window operations while designing pipelines, as they help in tagging elements for aggregation steps within your Directed Acyclic Graph (DAG).

```java
pCollection<String> windowed = pCollection.apply(Window.<String>into(FixedWindows.of(Duration.standardMinutes(5))));
```

- **Data Cleaning**: If data collected from external systems require cleaning, plan for appropriate DAGs to address multiple issues within an element. Ensure elements flow through all necessary transforms.

## Serial Applications of Data Transformations

Apply data transformations serially when possible, allowing the Apache Beam service to optimize your DAG. This arrangement enables processing in single worker nodes, reducing costly I/O and network operations.

```java
pCollection<String> transformed = pCollection1.apply(SerialTransformers.custom((in) -> { ... }));
```

## Handling External Systems Interaction

- **Back Pressure**: Be aware of potential back pressure when interacting with external systems, like key-value stores or Extract, Transform, Load (ETL) sinks in your pipeline. Ensure that the capacity of these systems is adequate to avoid any performance issues.

## Autoscaling and Dataflow Pipelines

- Enable autoscaling for your Apache Beam pipelines as a good practice. If an external system becomes backlogged, scaling down will prevent pipeline resources from being underutilized.

```java
PipelineOptions pOpt = new PipelineOptions();
pOpt.set("autoscaler.maxWorkerCount", "50");
Pipeline p = PipelineBuilder.create(pOpt);
...
```

To summarize, you've provided an overview of Beam SQL and Dataflow SQL:

1. **Beam SQL** is part of Apache Beam library, enabling users to query bounded or unbounded PCollections (data streams) using SQL statements in batch and stream modes. It integrates with schema PCollections, supports windowing for aggregating data, and allows mixing SqlTransforms with other PTransforms within a pipeline.

2. **Beam SQL** includes two dialects: Apache Calcite SQL (default) and Google ZetaSQL. The former is widely adopted in big data processing ecosebackward-compatible with Flink SQL, while the latter aligns more closely with BigQuery standard SQL.

3. Beam SQL also supports **UDFs** or user-defined functions for custom functionality within queries.

4. On to **Dataflow SQL**: this variant integrates with Apache Beam SQL and uses a ZetaSQL query syntax, which is compatible with BigQuery's standard SQL dialect. It can be utilized as part of the Cloud Dataflow pipeline using flex templates or through UI tools like the BigQuery web interface.

5. **Dataflow SQL** enables data analysts to use their existing SQL skills in a user-friendly environment, without needing SDK knowledge or programming experience in Java or Python. This ease of access extends to joining streams from various sources such as Pub/Sub and writing query results back into BigQuery tables for analysis and dashboarding purposes.

6. **Dataflow SQL** also supports integration with a variety of cloud services like Kafka, Bigtable, HBase, etc., providing flexibility in handling different data streaming scenarios.

7. The Dataflow UI can be used to monitor the underlying jobs running queries on Cloud Dataflow pipelines for real-time insights and debugging. Additionally, gcloud command line tools offer an alternative method of launching Dataflow SQL jobs.

8. For a more programmatic approach in existing pipelines, data engineers can encapsulate the logic implemented by the analysts using PCollection as a table name or by accessing tuples by their names within templates. This allows for scalable and efficient execution of queries across different stages of the pipeline process.

## Windowing in SQL

**Keywords:** Streaming Concepts, Aggregations, Data Streaming, Tumbling/Fixed Window, Hopping/Sliding Windows, Session Windows

### Types of Windows for Aggregations

1. **Tumbling/Fixed Window**

   - Incorporates tumble term in SQL query.
   - Fixed interval window size

2. **Hopping/Sliding Windows**
   - Use hop term to apply windowing concept.
   - Defines two intervals:
     - Length of the window (slide)
     - Start time for a new window (hop)
3. **Session Windows**
   - Implements session windows using SQL query.
   - Determines when to create a new window based on an interval of time

## Beam DataFrames

**Keywords:** Apache Beam, Python SDK, pandas-like DataFrame API, Parallel Processing, GroupBy Operation, Schema, DSL (Domain Specific Language), CombinePerKeys, TupleCombineFn, SqlTransform, Control Flow, Interactive Visualizations.

### Features and Usage of Beam DataFrames

1. **Python SDK:** Apache Beam Python SDK offers a DataFrame API for interacting with pandas-like DataFrame objects.

   - Converts PCollection to DataFrame using standard methods from the pandas DataFrame API.

2. **Data Manipulation and Processing:** Operations on subsets of datasets in parallel, leveraging pandas implementation.

3. **Parallel Processing Model Support:** Deferring operations supports Apache Beam's parallel processing model.

   - Different from Pandas DataFrames due to deferred operation execution.

4. **Domain-Specific Language (DSL):** Integrated into the Python SDK, it enables creating pipelines without referencing standard constructs like ParDo and CombinePerKeys.

5. **Pipeline Efficiency:** Deferring operations allows data processing using efficient vectorized pandas implementation, which can enhance pipeline performance.

6. **GroupBy Operation:** Primitive for grouping large amounts of data; involves splitting the object, applying a function, and combining results.

   - Supports arbitrary expression computations on grouped data (e.g., summing up total prices by recipe).

7. **DataFrameTransform Functionality:** Similar to SqlTransform from Beam SQL DSL but applies functions that take and return DataFrames instead of PCollections.

   - Useful when using standalone functions compatible with both Python's pandas library and Apache Beam pipelines.

8. **Conversion between PCollection, DataFrame, and Schema:** Converts data seamlessly among these three representations to perform computations on the fly (e.g., converting source data to schema for aggregation by word count).

   - Ability to save results with methods like `to_csv`.

9. **Limitations of Beam DataFrames:** Some limitations exist due to deferred operations, such as unavailability for control flow or interactive visualizations and lack of support for order-sensitive pandas operations (e.g., shift, cummax, etc.).

# Serverless Data Processing with Dataflow - Using Dataflow SQL for Batch Analytics

## Topics Covered:

- Apache Beam Notebooks
- Interactive Runner Features
- Pipeline Development and Optimization
- Real-time Data Access during Development
- Transformation Examples (Word Count)
- Debugging with Intermediate Results Visualization
- Code to Production Transition

## Key Concepts:

- **Apache Beam**: A unified model for developing both batch and streaming data processing pipelines.
- **Dataflow SQL**: Allows writing SQL queries directly on Apache Beam PCollections.
- **Interactive Runner**: Provides access to intermediate results during development, enabling exploration and debugging.
- **Batch vs. Streaming Analytics**: Differences in handling batch (bounded) data versus streaming (unbounded) data sources.

## Apache Beam Notebooks Overview:

Beam notebooks offer an interactive environment to develop and debug Apache Beam pipelines using SQL or Python syntax. They provide a suite of libraries, including `apache_beam`, `pandas`, and `matplotlib` for seamless data manipulation and visualization.

## Interactive Runner Features:

- **Intermediate Results**: Access to transformed elements during pipeline execution.
- **Recording Controls**: Options like `recording_duration` and `recording_amoomize_limit` for managing the data captured by the interactive runner.
- **Replay Data**: Option to replay recorded events or use fresh streaming data for consistent experimentation.

## Pipeline Development with Debugging Capabilities:

- Use SQL queries like `SELECT * FROM ReadFromPubSub(topic_name)` to read from Pub/Sub topics.
- Apply windowing (`FixedWindows`) and aggregations (e.g., count) to transform the data stream.
- Utilize visualization tools (`ib.show`) for a graphical representation of intermediate results, including metadata like event time and window information.

## Transition from Development to Production:

1. Develop your Beam pipeline using Apache Beam Notebooks with SQL or Python.
2. Ensure the code is fully functional within the notebook environment.
3. Import `apache_beam.runners.dataflow` and set up necessary options (e.g., project, staging directory) as part of your pipeline options.
4. Run the pipeline on Google Cloud Dataflow using `runner.run()`.

## Example: Word Count Pipeline with Interactive Debugging

```python
# Read data from a Pub/Sub topic into a PCollection named 'words'.
words = (p | beam.io.ReadFromPubSub(topic=pubsub_project + ":" + pubsub_topic))

# Apply fixed windowing and aggregation to count words within each 10-second window.
word_counts = (words
               | 'Window into 10 second intervals' >> beam.WindowInto(window.FixedWindows(duration=timedelta(seconds=10)))
               | 'Group by word and calculate counts per fixed window' >> beam.combiners.Count().PerKey())
```

## Visualizing Intermediate Results:

- Use `ib.show()` to display the PCollection as a table, including additional information such as event time and window data if `include_window_info=True` is set.

By using Apache Beam Notebooks for development, you can take advantage of real-time debugging features while seamlessly transitioning your code to production on Google Cloud Dataflow.

# Module Resources Summary: Developing Pipelines with Dataflow Course

## Key Concepts Covered

- Apache Beam core concepts, including
  - **pipelines**
  - **PCollections**
  - **PTransforms**
  - **runners**
- Utility transforms: ParDo, GroupByKey, flatten
- DoFn lifecycle breakdown

## Building Basic Beam Pipelines

- Combining concepts to build basic pipelines.

## Streaming Data Handling

- Windows, watermarks & triggers in streaming data processing.

## Flexibility of the Beam Model

- Emitting results and managing late arriving data according to business logic needs.

## Sources and Sinks

- Variety of IOs available through the Beam SDK:
  - Text IO, File IO
  - Google Cloud IOs: BigQuery, Pub/Sub, Bigtable
  - Open source connectors: Kafka IO, Avro

## Performance Enhancement with Custom Connectors and Splittable DoFns

- Maximizing throughput using distributed processing.

## Schemas for Data Structure Expression

- Making code more manageable & efficient.

## State Management in Pipelines

- Leveraging state and timers for fine-grained control over aggregations, beyond the limits of ParDo and GroupByKeys.

## Beam SDK for Developing Dataflow Pipelines

- Implementing best practices: dead‑letter queue, error handling strategy, JSON data processing with built‑in utilities, batch calls optimization to external APIs, pipeline optimization techniques.

# Alternative Launching Methods for Dataflow Pipelines

## Using SQL Integrated with BigQuery UI

- Executing pipelines via SQL statements and windowing logic in the UI.

## Command-line Interface (CLI) Invocation of Dataflow Jobs

- Programmatically invoking jobs using CLI.

# Beam Notebooks: A Different Approach to Pipeline Authorship

- Merging Beam Python SDK with Jupyter lab for interactive pipeline development and validation.

# NotesGPT: Dataflow Operations Course Summary

**Introduction to Dataflow Operations**

- Hosted by Mehab Nazir, Product Manager at Google Cloud Dataflow
- Final installment of the Dataflow course series
- Focus on building a stable and resilient modern data platform using Dataflow

## Course Outline:

1. **Dataflow Monitoring**

   - Console experience walkthrough

2. **Logging & Error Reporting Integrations**

   - Critical component of the Dataflow operations stack

3. **Troubleshooting and Debugging Pipelines**

   - Recommended approach for diagnosing pipeline errors
   - Common causes for failures in pipelines

4. **Performance Optimization Techniques**

   - Maximizing efficiency of Dataflow jobs

5. **CI/CD with Dataflow (Continuous Integration and Continuous Deployment)**

   - Ensuring safe testing, deployment of pipeline changes

6. **Reliability in Pipeline Systems**

   - Strategies for resilience against data corruption and center outages

7. **Flex Templates**

   - Standardization and reuse of Dataflow pipeline code to solve operational challenges

8. **Recap & Key Lessons**
   - Overview of the course's main takeaways

## Previous Courses:

- Foundations Course (Dataflow Basics): Shuffle, streaming engine, resource scheduling, beam portability
- Advanced Features: State and timers, best practices, SQL/data frames/notebooks

# NotesGPT: Dataflow Monitoring Page Summary

**Introduction by Omar Ismail, Solutions Developer at Google Cloud**

- Apache Beam pipeline monitoring via Dataflow & Cloud Monitoring integration

## Resources for Pipeline Usage Viewing:

1. **Dataflow Job List Page**

   - Primary interface upon visiting the Dataflow platform
   - Displays jobs from past 30 days with options to filter and sort

2. **Running Filter Feature**

   - Enables view of only currently active jobs
   - Toggle option available for showing all jobs

3. **Sortable Columns & Filters**

   - Start Time, Pipeline Status, and other columns are sortable
   - Supports multiple filters with logical relationship options (AND/OR)

4. **Customizable Filtering Based on Job Name**

   - Example: filtering for jobs containing "Wikipedia" in the name

5. **Bookmarking Selected Views**
   - Allows quick access to specific filtered views by saving URL links as bookmarks

# NotesGPT: Dataflow Job Graph Page Summary

**Job Monitoring via Job Graph Page**

- Interactive interface displaying job metadata & runtime parameters

## Key Features of Job Info Panel on Job Graph Page:

1. **Basic Metadata Displayed**
   - Regional Endpoint Used
     - Essential for regional resource allocation and latency consideraturings
   - Worker Location
     - Impacts performance based on geographic proximity to data sources
   - Encryption Type Implemented
     - Crucial for ensuring data security & compliance standards
2. **Resource Usage Indicators**
   - Quantified count of resources currently in use by the job
     - Reflects computational demand, affecting cost and performance metrics
3. **Runtime Parameters Overview**
   - Details parameters that were utilized to execute the pipeline
     - Insight into configuration choices influencing job behavior

# NotesGPT: Job Graph Page Advanced Summary

## Visual Representation & Execution Flow:

- **Visual Depiction**: Centralized graphical representation of Beam code pipeline steps, including data read/write operations and reshuffling actions.

  - **Pipeline Steps Breakdown**
    - Input: `BigQuery` table reading
    - Transformation: Data shuffling
    - Output: Writing to a `Cloud Storage Bucket` in TensorFlow record format
  - Splitting into training, validation, and test sets

- **Step Execution & Optimization**
  - Sequential execution of batch job steps (non-concurrent)
  - Dataflow optimization techniques:
    - Fusing multiple pipeline steps
    - Stage sharing between different steps (e.g., `RecordToExample` and `ReshuffleResults`)
      - **Shared Stage**
        - Simultaneous execution visualization upon step pressing
- **Metrics & Performance Tracking**:
  - Throughput info for each step across time, along with total elements added/estimated size.
  - Wall time metric indicating the time taken by workers to execute steps.
    - Useful for identifying bottlamens in worker activity
- **Completion Status & Failure Indication**:
  - Green checkmark on completed job stages, red with error symbol upon failure
- **Custom Metrics Implementation** (via `Beam.Metrics`):
  - Counter method for variable/event increment and decrement
  - Distribution tracking for COUNT, MIN, MAX, MEAN
  - Gauge method to monitor current value of specified metrics

# Dataflow Job Metrics Summary

## JOB METRICS TAB Overview:

- Displays time series data for a given job.
- Varies between batch and streaming jobs.

## Batch Pipeline Example (BigQuery to TensorFlow records):

**Workers' Graphs:**

| Metric     | Description                          | Graph Representation |
| ---------- | ------------------------------------ | -------------------- |
| Green Line | Number of required workers over time | Workers needed graph |
| Blue Line  | Current number of active workers     | Active workers graph |

_Note: A small time gap exists between the two lines due to worker spin-up and work distribution._

**Throughput Graphs for Substeps (vs. Time):**

Each substep' cuisine is plotted separately, showing their individual throughput over time. The graph reflects that batch pipelines do not run all steps concurrently.

**CPU Utilization Percentage:**

| Status               | Description                                                                                                    | Graph Representation                                                        |
| -------------------- | -------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| 100% CPU utilization | Indicates potential blocking operations or high processing load in specific steps with high system watermarks. | Worker logs should be checked for errors or indications of slow processing. |

**Pub/Sub Input Metrics (Requests per Second):**

- Measures API request rate to read data from Pub/Sub over time.
- A drop in rate might indicate pipeline blockage, performance issues, or lack of data to read.

**Response Errors Per Second by Type:**

- Tracks the rate of failed API requests to read/write data from Pub/Sub.
- Frequent errors should be cross-referenced with Pub/Sub error codes for troubleshooting.

## Time Selector Tool Usage:

The time selector tool allows users to focus on specific intervals within the pipeline's runtime, providing a more granular view of metrics and logs. It is activated by pressing the button displaying the current time range selected in the top right corner of the dashboard.

# Metrics Explorer in Cloud Monitoring

## Overview

- **Cloud Monitoring Metrics Explorer** is a tool used for monitoring metrics related to Google's Dataflow service.
- It serves as the endpoint where all data flow metrics are exported and can be visualized using custom dashboards.
- The available metrics range from job status plots to user-defined custom metrics.

## Features

1. **Data Visualization**: Create custom dashboards with a variety of charts to monitor Dataflow jobs' performance, such as the data watermark and other relevant metrics.
2. **Custom Metrics Creation**: Define your own metrics for more granular monitoring purposes.
3. **Alerting Policies**: Establish thresholds for specific metrics and receive notifications when these thresholds are crossed. Alerts can be sent via email, SMS, or other notification mechanisms.
4. flaws in the system latency increases over a predefined value
5. **Incident Management**: Each time an alert is triggered, an incident is created and tracked for resolution.

## Metrics Monitoring Examples

1. Job Failure Detection:
   - Set `is_failed > 0` to monitor job failures; filter by the desired job name.
2. Dependency Issues Tracking:
   - Utilize a counter for tracking the number of times dependencies are called, and plot results using the user_counter metric.
3. Data Watermark Monitoring:
   - Create a custom dashboard to monitor data watermarks across all pipelines with specific names or conditions.
4. Indefinite Retries Alerting:
   - Set an alert threshold for system latency and receive notifications when this value is exceeded, indicating potential indefinite retries.
5. Custom Alert Policies:
   - Build customized alerting policies to group more than one pipeline using Cloud Monitoring tools.

## Using Metrics Explorer with Dataflow

- **Dataflow UI**: Navigate through the job details user interface and interpret metric graphs for pipeline diagnosis.
- **Dashboards**: Utilize the built-in functionality of Metrics Explorer to create custom dashboards tailored to specific monitoring requirements.
- **Alerting Mechanisms**: Set up alerting policies with desired notification mechanisms (e.g., email, SMS) and define thresholds for metrics that require close monitoring.

By leveraging the capabilities of Cloud Monitoring Metrics Explorer in conjunction with Dataflow UI, users can effectively monitor their data processing pipelines while staying alert to potential issues or performance degradations.

# NotationsGPT: Google Cloud Logging and Error Reporting

## Key Concepts:

- **Logs Panel**: Located at the bottom of the job graph and metrics pages; allows users to view logs from both Dataflow service (JOB LOGS) and VM running worker processes (WORKER LOGS).
- **Filter Options**: Users can filter logs by minimum log level, e.cuating errors or warnings, and specific messages using text input boxes in the Logs panel.
- **Steps/Substeps Filtering**: By clicking on steps or substeps in the job graph page, users can view logs related to a particular step of the pipeline execution.
- **Diagnostics Tab**: Provides information about errors across time within an entire project, including frequency and timestamps; also highlights important log entries from worker VM operations during pipeline life cycles.
- **BigQuery Jobs Tab**: Available for Beam 2.24+ users with the BigQuery admin role, displays BigQuery jobs related to their pipelines that read or load data into BigQuery tables.

## Logging and Error Reporting Procedures:

1. Expand the **Logs panel** at the bottom of the page for detailed logging information.
2. Select the desired log category (JOB LOGS, WORKER LOGS) using tabs in the Logs panel.
3. Filter logs by minimum log level or specific messages to narrow down relevant entries.
4. To focus on a particular step/substep within the pipeline execution, click it on the job graph page and return to the Worker Loads tab.
5. Use **Diagnostics Tab** for error frequency analysis across time and insights into worker VM operations during the pipeline life cycle. Clicking an error in this tab directs users to the Error Reporting Page for more details.
6. For pipelines utilizing BigQuery, use the **BigQuery Jobs Tab** (only available with Beam 2.24+ and admin role) to view related jobs that read or load data into BigQueue tables. Choose the appropriate location before retrieving job listings; detailed information can be accessed by pressing command-line buttons associated with specific jobs.

## Example:

A batch job failed due to memory pressure, causing JVM crash on worker VMs. By examining the Diagnostics tab in the Logs panel, users could quickly identify the cause of failure without sifting through all logs manually. Additionally, for pipelines that interact with BigQuery tables, relevant jobs can be monitored and analyzed using the dedicated **BigQuery Jobs Tab**, offering valuable insights into data exportation/importation processes via extract/load or streaming insert methods.

# Error Reporting

## Overview

- **DIAGNOSTICS** tab in **Logs Pane**: Displays frequently occurrcuing errors for your job.

- **Error Reporting Page**: Aggregates and displays error details across cloud services, focusing on Dataflow pipelines within a project.

## Features of Error Reporting Page

1. View most frequent or new errors in the selected timeframe using top right buttons for different periods.
2. Identify jobs where the error occurred.
3. Access full **stack trace** information.
4. Link to company's issue tracker by pasting URL on the page.

## Error Status Management

- Change status of resolved errors: options include "Open", "Acknowledged", "Resolved" or "Muted".

| Functionality           | Description                                 | Example                                             |
| ----------------------- | ------------------------------------------- | --------------------------------------------------- |
| Timeframes              | Select specific time periods to view errors | 1 day, 7 days, 30 days                              |
| Job Identification      | Find jobs with a particular error           | Click on the job name/details                       |
| Stack Trace             | View detailed error information             | Scroll down to see full stack trace                 |
| Issue Tracker Linkage   | Connect errors to company's issue tracker   | Paste URL in provided space                         |
| Error Status Management | Update status after resolution of the error | Change from "Open" to "Resolved/Acknowledged/Muted" |

# Troubleshooting & Debugging Workflow

**Omar Ismail, Google Cloud Solutions Developer**

## General Steps for Dataflow Pipelines Troubleshooting

1. **Checking Job Status:** Start by assessing the job status on the Dataflow Jobs page.
2. **Analyzze Error Notifications & Log Details:** For failed jobs, view error notifications and logs in Cloud Logging for root cause identification.
3. **Evaluate Job Metrics:** Use metrics such as data freshness, system latency, CPU utilization to identify performance issues or anomalamoies.

## Detailed Steps & Indicators

1. **Job Status Analysis:**
   - Job in a failed state requires deeper log analysis.
   - Running jobs might also be problematic but not yet identified as failed.
2. **Error Notifications & Log Details:**
   - Error notifications above the job graph highlight errors.
   - Detailed logs can be accessed via Cloud Logging, filtering/searching for relevant information.
3. **Job Metrics Evaluation:**
   - **Data Freshness:** High data freshness might indicate worker capacity issues.
   - **System Latency:** Increasing system latency could suggest lengthy processing times of certain work items.
   - **CPU Utilization Graph:** Limited parallelism or a CPU-bound job can be identified by high CPU utilization in one or few workers, with others near 0%.

# Types of Troubles in Dataflow Pipelines

## 1. Graph Construction Errors during Job Building

- **Cause**: Issues while building the job graph, Beam aspects validation, input/output specifications.
- **Reproducible with**: Direct runner and unit tests.
- **Effect on Dataflow Service**: Prevents job creation if an error is found.

## 2. Errors during Job Validation by Dataflow Service

- **Cause**: Access issues to Cloud Storage buckets, permissions in Google Cloud project, input/output source accessibility.psychologist.
- **Reproducible with**: Requires Dataflow runner and potentially the Dataflow service.
- **Validation process checks**: Storage bucket access, required permissions, data sources access.

##

# Types of Troubles in Dataflow Pipelines

## 1. Graph Construction Errors during Job Building

- **Cause**: Issues while building the job graph, Beam aspects validation, input/output specifications.
- **Reproducible with**: Direct runner and unit tests.
- **Effect on Dataflow Service**: Prevents job creation if an error is found.

## 2. Errors during Job Validation by Dataflow Service

- **Cause**: Access issues to Cloud Storage buckets, permissions in Google Cloud project, input/output source accessibility.
- **Reproducible with**: Requires Dataflow runner and potentially the Dataflow service.
- **Validation process checks**: Storage bucket access, required permissions, data sources access.

## 3. Exceptions during Pipeline Execution (Worker Code Errors)

- **Cause**: Unhandled exceptions in pipeline functions (`do` functions).
- **Manifestation**: Failed tasks within Dataflow job.
- **Troubleshooting**: Detailed stack traces from Cloud Logging, exception handling strategies, logging/inspecting failing elements using additional outputs or logs.
  - Batch Pipelines: Retry failed tasks up to four times.
  - Streaming Pipelines: May stall indefinitely; troubleshooting requires other signals like data freshness, job logs, Cloud Monitoring, metrics for pipeline progress, and error counts.

## # Slow Running Pipelines or Lack of Output Affecting Performance

- **Cause**: Design flaws, data shape issues, interactions with sources/sinks/external systems.
- **Indicators of Expensive Steps** (for Troubleshooting):
  - Wall time and input elements count via the user interface's Step info section.
  - Output element count and estimated size to measure output efficiency.

## Lab: Serverless Data Processing with Dataflow - Monitoring, Logging and Error Reporting

**Strategic Cloud Engineer (Ajay):** Performance considerations in developing batch and streaming pipelines using Google's **Dataflow**.

### Key Points:

1. **Pipeline Design Considerations:** Critical to performance are simple yet crucial design decisions, such as filtering data early and placing volume-reducing transformations at the top of a Directed Acyclic Graph (DAG).
2. **Data Shape Effects on Performance:** The shape of your dataset impacts Dataflow pipeline efficiency; reducing volumes early in processing helps optimize performance.
3. **Impact of External Systems:** External systems can affect Dataflow pipelines, requiring careful design and optimization to maintain high performance levels.
4. **Dataflow-Specific Optimization Options:** Several techniques for enhancing performance within the scope of Dataflow include:
   - Coder Selection: Use efficient coders like ProtoCoder or schemas instead of serializable coder in Java SDK to reduce overhead from encoding and decoding.
     ```
     // Example using Protobuf's field mass type
     PCollection<K, V> result = data.apply(WindowInto.<String>FixedSizeWindows(windowDurationSeconds * parallelism, windowDurationSeconds))
         .apply("ProcessWindow", new DoFn<K, V>() { /*...*/ });
     ```
   - Window Optimization: Create a combined-then-sliding window to reduce the volume of elements processed.
     ```
     PCollection<K, W> result = data.apply(WindowInto.<String>SlidingWindows(windowSizeSeconds * parallelism, slideDurationSeconds))
         .apply("ProcessWindow", new DoFn<K, W>() { /*...*/ });
     ```
   - Fanout Transformation and Logging: Avoid fusion across fan-out transformations with a high output count. Be cautious of excessive logging causing performance issues; consider alternatives like the dead letter pattern for error reporting.
     ```
     PCollection<K, V> result = data.apply("FanOut", ParDo.<String, String>ParDo() { /*...*/ });
     ```
   - Preventing Graph Optimization Fusion: Insert a reshuffle or pass the intermediate PCollection as a side input to another ParDo operation; this prevents fusion across aggregations.
     ```
     PCollection<K, V> result = data.apply("PreventFusion", ParDo.<String, String>ParDo() { /*...*/ });
     ```

# Data Shape and Pipeline Performance

## Key Concepts:

- **Data Skew**: Unbalanced data processing due to unique characteristics of input data.
- **GroupByKey/Combine Operation**: Merges multiple `PCollections` into one by shuffling keys across workers.
- **Hot Keys**: Occur when columns used as keys are nullable, leading to unbalanced load distribution.
- **Dataflow Shuffle**: Offloads the shuffle operation from worker machine constraints and helps detect hot keys.

## Strategies for Mitabulating Hot Key Issue:

1. **Helper API with Fanout**: Allows defining intermediate workers before the final combined step.
2. **Combined Per-Key with Hot Key Fanout**: Enables a function to determine intermediate steps, improving load distribution and resource allocation.
3. **Dataflow Shuffle (Batch/Streaming Services)**: Offloads shuffle operation, eases hot key detection, and enhances performance by setting `hotKeyLoggingEnabled` flag to true for identifying bottlenecked keys.

## Key Space Impact on Performance:

- Too Few Keys: Difficulties in workload sharing, per-key ordering, and reduced parallelism due to limited key space.
  - **Pro Tip**: Utilize windows as part of the key for distinct window processing to improve worker machine parallelization.
- Too Many Keys: Increases overhead, consider using internal hashes for separating keys if datetime information is present; reuse past active keys to minimize costs.

## General Guidelines:

1. Avoid both too few and too many keys in your pipeline design. Striking a balance ensures optimal load distribution and efficient resource utilization, ultimately improving the overall performance of Dataflow pipelines.

# External Systems Impact on Dataflow Pipeline

## Key Concepts:

- **Sources and Sinks**: Abstract users from read stage parallelism but can hide underlying performance issues.
- **TextIO with Gzip Files**: Limited to single thread per file, resulting in negative effects like a bottleband on the host network during shuffle stages.

## Strategies for Improving External System Performance:

1. Switch from gzip files using TextIO to uncompressed or compressed error format (e.g., snappy).
2. Leverage Beam runners' ability to handle parallel work efficiently, distributing threads across multiple machines.
3. Utilize batch mechanisms in external system calls (group into batches, transforms, start bundle and finish bundle) for mitigating potential issues during backlog processing or with peak Dataflow volumes.
4. Ensure adequate provisioning of external services to accommodate peak Dataflow pipeline volumes.
5. Optimize colocation by selecting services and resources within the same region as your application, leading to reduced latency in inter-service communication.

## Performance Considerations:

1. Choice of file format (e.g., gzip vs uncompressed or compressed error) has a direct impact on parallel processing capabilities during read stages.
2. External system interactions can be swamped by the rapid parallel work processing abilities of Beam runners, affecting both batch and streaming pipelines.
3. Colocation within the same region as external services (e.g., BigQuery or Bigtable) may result in significant performance gains due to lower latency during inter-service communication.

# Dataflow Performance Optimization: Shuffle & Streaming Engine

## Key Concepts:

- **Shuffle Operation**: Partitions and groups data by key in a scalable, efficient, and fault-tolerant manner within Cloud Dataflow pipelines.
  - Traditional implementation runs on worker VMs using CPU, memory, and persistent disk storage resources.
  - Service-based implementation moves the shuffle operation out of the worker into the Cloud Dataflow service back end for batch pipelines only.

## Benefits of Service-Based Shuffle:

1. **Faster Execution Time**: Increased performance across a majority of job types in batch pipelines compared to traditional implementations.
2. cuffolding CPU, memory, and persistent disk storage resources on worker VMs, enabling better autoscaling capabilities.
3. Improved Fault Tolerance: Shuffle data is no longer held by unhealthy VMs; hence the entire job does not fail as it would with traditional implementations.

## Streaming Engine Feature:

1. Offloads window state storage operation from workers to a back-end service for both batch and streaming pipelines, specifically optimized for streaming cases.
2. No code changes required to benefit from these features; worker nodes run user code that communicates transparently with the Shuffle or Streaming Engine services.
3. Resolves scalability and autoscaling issues by enabling both shuffle and streaming engine functionalities in batch and streaming pipelines, respectively.

## Conclusion:

- Understanding performance considerations for Dataflow pipelines is crucial; implementing the Shuffle and Streaming Engine features can significantly enhance pipeline efficiency.

# Dataflow Pipeline Testing and CI/CD Overview

## Introduction

- **Vince Gonzalez**: Google Cloud's Data Engineer
  - Presents frameworks for streamlining CI/CD workflow in data pipelines using Beam

## Objective

- Introduce testing strategies, integration tests, artifact building, and deployment considerations for Beam & Dataflow pipelines.

## Key Points: Pipeline Lifecycle Management

- Similar to application lifecycle management
  - Testing strategy (unit, integration, end-to-end)
    - Validate changes in pipeline logic with rollback plans if necessary
  - Development structure is vital for minimizing potential disruptions during deployment.

## Stateful Data Pipelines

- Aggregation of data makes them stateful: Accumulation over time
  - Requires accounting for existing states and logical changes in updates
    - Potential need for alternate migration strategies & reprocessing
  - Importance of ensuring safe releases, as non-idempotent side effects can impact external systems.

## Testing Approaches

- Unit tests: Focus on PTransforms (DoFns) and other DoFn subclasses validation through handcrafted input datasets
- Integration testing: Incorve small amount of test data with actual IOs to ensure expected results interaction
- End-to-End tests: Utilize full testing dataset for realistic production scenario representation.

## CI/CD Workflow

1. Development phase (local unit and integration tests using direct runner)
2. Continuous Integration (CI): Automated compilation & testing of code commits
3. Pre-production environment deployment (end-to-end tests)
4. Production environment deployment

## Testing Tools

- Direct Runner: For local development, unit and small integration tests
- Dataflow Runners: Cloud services for larger integration tests, performance testing, and pipeline rollback simulations

# Unit Testing with Apache Beam

## Overview and Key Concepts

- **Unit tests**: Small, testable pieces asserting behavior in production pipelines, often DoFns or PTransforms
- **TestPipeline**: Class for testing transforms (part of the Beam SDK)
- **PAssert**: Verification on contents of a `PCollection` regardless of pipeline runner type
- **Beam Runner Types**: Direct and Dataflow runners for both local and production environments

## Prerequisites and Dependencies

```markdown
# JUnit amo Beam dependency

<dependency>
    <groupId>org.apache.beam</groupId>
    <artifactId>beam-testing</artifactId>
    <version>[insert version]</version>
</dependency>
```

## Unit Testing Procedure with Apache Beam

1. **Set Up TestPipeline**: Replace the pipeline object with `TestPipeline` for testing transforms
2. **Create PCollection Instances**: Use known input to test DoFns and composite transforms
3. **Apply Assertions with PAssert**: Compare output of transforms against expected results, regardless of runner type
4. **Implement TestStream for Streaming Interactions**: Simulate unbounded `PCollection` streams using timestamp manipulation
5. **Adhere to Best Practices in Design and Coding**: Utilize named subclasses instead of anonymous ones for code maintainability
6. **Test Window Transform Behavior**: Apply fixed windows, manipulate timestamps, and assert on windowed calculations

## Example Code Snippets

```java
// TestPipeline initialization in unit test class
public final class MyDoFnTest extends TestPipeline {
    private static final String INPUT_COLLECTION = "myInputData";
}

// Applying fixed windows and assertions
PCollection<WindowedValue<String, TimeWindow>> windowedOutput = pipeline.apply(
    FixedWindows.of(Duration.standardMinutes(1))
).apply(ParDo.of((WindowedMutableVoidInput input) -> {
    Assert.assertEquals("expected output", input.output()); // Replace with actual expected value
}));
```

## Comparisons and Best Practices

| Aspect               | Named Subclasses                                             | Anonymous Subclasses                           |
| -------------------- | ------------------------------------------------------------ | ---------------------------------------------- |
| Reusability          | High (due to named reference)                                | Low (difficult to reuse without duplication)   |
| Maintainability      | Easier maintenance as code separation is clear               | Code intermingled, hard to maintain and update |
| Testing Independence | Can validate behavior independently from the entire pipeline | Validation requires running full pipeline      |

# Integration Testing in Data Pipelines

## Overview:

Integration testing is an essential part of developing robust data pipelines, enscribing various components to work seamlessly together. It involves creating a smaller amount of data and asserting that outputs align with expected results while working on a near-production scale. Integration tests can include copying production datasets or cloning the entire production environment for extensive testing before any major updates are implemented.

## Key Points:

1. **Smaller Amount of Data**: During integration testing, only a smaller amount of data is used to ensure pipeline components work together as expected and produce anticipated outputs.

   - _Keyword_: **Assertion**

2. **Near-Production Scale Testing**: Integration tests are carried out on near-production scale to mimic real-world scenarios, providing more accurate test results. This can be achieved by cloning data from a production project or creating an identical non-production environment for testing purposes.

   - _Keyword_: **Cloning**

3. **Storage Transfer Service and BigQuery Dataset Cloning**: Data transfer services like the Storage Transfer Service are used to copy Cloud Storage data, including datasets in BigQuery for large integration tests. Production datasets can also be accessed as read-only during testing.
   - _Keyword_: **BigQuery**
4. **Streaming Data Sources (Cloud Pub/Sub) and Attaching Extra Subscriptions**: For streaming pipelines, extra subscriptions to topics like Cloud Pub/Sub allow for easy cloning of production environments during testing. This process incurs additional costs but is essential for major updates.
   - _Keyword_: **Pub/Sub**
5. **Regular Cadence Testing and AB Testing**: Regularly scheduled integration tests (e.g., after a specific number of minor pipeline updates) can help ensure smooth production operations, particularly when implementing A/B testing scenarios where streaming data is split based on entry to the topic.
   - _Keyword_: **AB Testing**
6. **Pipeline-Specific Integration Tests**: Some integration tests may focus only on individual pipeline components such as sources, transforms, or sinks without involving all aspects of the pipeline. An example is testing a PTransform subclass like WeatherStatsPipeline which summarizes weather data integers. Here'지, a TestPipeline instance and PCollection of integers are created to test the expected results against actual outputs.

   - _Keyword_: **Testing**

7. **Handling Production Data for Streaming Sources**: If streaming sources like Cloud Pub/Sub allow splitting data during entry to the topic, it is possible to carry out AB testing and ensure that sinks can handle different versions of transforms as part of integration tests.

# Artifact Building: Packaging Apache Beam Pipelines

## Overview:

Artifact building in pipeline development involves packaging and versioning essential components such as Apache Beam, ensebling them with other necessary elements like Dataflow runners or GCP IOs to ensure compatibility and functionality. The process is based on semantic versioning principles (Major.minor.incremental), where incrementation signifies either incompatible API changes (major), backward-compatible new functionalities (minor), or forward-compatible bug fixes (incremental).

## Key Points:

1. **Semantic Versioning of Apache Beam**: The versioning system for Apache Beam adheres to the semantic versioning principles, with incrementation reflecting incompatible API changes (**Major**), new backward-compatible functionalities (**Minor**), and forward-compatible bug fixes (**Incremental**).

   - _Keywords_: **Semantic Versioning**, **Apache Beam**

2. **Build Artifacts in Maven Central**: The necessary build artifacts for Apache Beam are hosted on [Maven Central](https://search.maven.org/), and developers often require more than just the core package. Additional dependencies may include Dataflow runners or GCP IO packages, among others.

   - _Keywords_: **Build Artifacts**, **Maven Central**

3. **Versioning Tools**: The Apache Beam build system primarily utilizes either Maven or Gradle for version management and dependency handling. In the context of Maven POM, developers often need to import more than just core dependencies (e.g., Dataflow runners, GCP IO packages).

   - _Keywords_: **Maven**, **Gradle**

4. **Dependency Management with Google Cloud Libraries BOMbomb**: Versions of Apache Beam from 2.26 and higher employ the use of [Google Cloud Libraries BOMbomb](https://github.cuold/google-cloud-libraries) to manage dependencies involving Google-related libraries, helping reduce potential dependency conflicts.

   - _Keywords_: **Dependency Management**, **BOMbomb**

5. **Recommended Apache Beam Versioning**: It is suggested that developers use Apache Beam version 2.26 and above to benefit from the Google Cloud Libraries BOMbomb feature for enhanced dependency management.
   - _Keywords_: **Apache Beam Recommendation**, **Versioning**

Deploying a streaming pipeline using Apache Beam on Google Cloud Platform involves several steps. Here's an overview of the process:

1. Define your streaming pipeline code in Python, Java, or Go with Apache Beam libraries. Your job will consist of one or more stages that read from and write to various data sources like Pub/Sub, BigQuery, etc.

2. Create a Cloud Dataproc cluster by selecting the appropriate configuration (cluster type, machine types) based on your requirements. Ensure you have sufficient permissions and resources allocated for running Apache Beam jobs.

3. Deploy your pipeline to Google Cloud Platform:

   - Navigate to the Dataflow UI in the GCP console.
   - Click "New job" -> "Apache Beam (Dataflow)" -> "Python 2", or select the appropriate language and version for your codebase.
   - Configure the pipeline with the cluster's details, including location and other necessary settings.
     [Continue]

   3. Upload the source code file to Google Cloud Storage (GCS). Alternatively, you can directly paste the Python code in the Dataflow UI editor if your codebase is small enough for this approach.

4. Configure additional pipeline options as needed:
   - Set up a trigger based on event time or processing time.
   - Define windowing parameters to segment data into windows for aggregation, depending on the nature of your stream (e.g., tumbling, session).
   - Specify any side inputs/outputs that might be required by your pipeline logic.
   - Configure error handling mechanisms like retries and timeouts to ensure fault tolerance in case of processing failures or errors.
5. Deploy the pipeline:

   - Click "Submit" -> "Deploy now". This will execute the job using the Dataflow service on your configured cluster, reading from the specified sources and writing results to designated sinks (e.g., BigQuery, Pub/Sub).
   - Monitor job progress in the provided logs or through Cloud Logging. You can also use Stackdriver for real-time monitoring of performance metrics like CPU utilization, memory usage, etc.

6. Take a snapshot and update your pipeline:
   - If you want to modify your streaming pipeline codebase without redeploying from scratch, take a snapshot before making changes using the UI or GCloud SDK/CLI.
   - Update your pipeline logic by deploying the new version of the job on Dataflow with an updated source code file in step 3 above.
   - Provide update compatibility mapping for any renamed transformations to avoid losing state and ensure smooth transitions between versions.
7. Drain or cancel the pipeline:
   - If you need to stop your streaming pipeline, choose either 'Drain' (to finish processing all buffered data without dropping records) or 'Cancel' (immediately shutting down resources and stopping data pull/processing).
   - Be aware of possible incomplete aggregations when using the 'Drain' option. You may need to handle such cases in your downstream business logic accordingly.

Follow these steps, keeping best practices like modularity, reusability, error handling, and monitoring in mind while deploying streaming pipelines with Apache Beam on Google Cloud Platform.

# Serverless Data Processing with Dataflow - Testing using Apache Beam

- **Topics Covered:** Java and Python implementations, CI/CD integration, additional resources for reliability, introduction to reliability techniques.

# Reliability in Dataflow Pipelines

1. Implementations of different approaches based on pipeline type (batch vs streaming)
   - Batch jobs: Easy re-runs without data loss; sinks can be rewritten if partially written.
   - Streaming jobs: Continuous processing, high complexity and importance for reliability.
2. **Best Practices** mainly focus on streaming pipelines.
3. Second half of the module covers:
   - Disaster recovery
   - High availability configurations
4. Monitoring and geolocation sections apply to both batch workloads and streaming jobs.

# Classifying Pipeline Failures

1. Two broad categories for failures:
   - User code-related (software bugs, transient errors)
   - Data shapes
2. **Outages** affecting the pipeline's reliability:
   - Service outages
   - Zonal outages
   - Regional outages
3. Mitigation strategies for these incidents will be discussed in upcoming modules to enhance Dataflow workloads' reliability.

# Monitoring Strategies in Dataflow Workloads

**1. Retry and Error Handling:**

- Batch jobs retry failing items up to four times before failure.
- Streaming work items are retried **indefinitely**.
- Implement a **dead letter queue** & **error logging** for erroneous records.
- Sample Java code snippet with try-catch block:
  ```java
  process(input -> {
    try {
      // user code here
    } catch (Exception e) {
      return createDeadLetterItem(e, input);
    }
  });
  ```

**2. Monitoring and Alerting:**

- Essential for **catching issues before production systems fail**.
- Use metrics to observe important Service Level Indicators (SLIs).
- Compare SLIs against an acceptable threshold.
- Dataflow's web interface provides job monitoring, and integration with Cloud Monitoring offers customized health condition metrics.

**3. Batch Workload Metrics:**

- Track overall runtime for jobs on recurring schedules.
- Use **Cloud Monitoring** to create an alert if elapsed time exceeds the SLO threshold.
- Example monitoring metric table using Markdown syntax:
  ```markdown
  | Metric  | Threshold    | Action             |
  | ------- | ------------ | ------------------ |
  | Runtime | X hours/days | Alert Notification |
  ```

**4. Streaming Pipeline Metrics:**

- Standard metrics for data freshness and system latency track pipeline performance.
- Create alerts with a specified threshold using the Dataflow monitoring UI to improve reliability posture.

## Geolocation Impact on Dataflow Pipeline Reliability

**Dataflow Service:**

- Regional service with job routing based on resource availability within specified zones when no zone is explicitly selected by the user.

### Job Submission and Zone Selection

1. **Without explicit zone selection:**
   - Dataflow selects the best zone for a job's execution based on available capacity.
2. **Explicit zone specification:**
   - User cannot benefit from automatic resource availability-based zoning, potentially leading to reduced reliability in case of issues.

### Job Failure and Retrying Techniques

1. **Zone issue failures:**
   - Reducing explicit zone selection during retry can resolve such issues due to auto-zone selection based on capacity.
2. **Job location modification constraints:**
   - Cannot change job's location once started. For streaming jobs, drain/cancel before relaunching in the same or different region without specified zones.

### Resource Location Elements for Dataflow Jobs

1. **Sources:**
   - Preferably located within the same region as processing and sinks to minimize cross-region dependencies.
2. **Processing:**
   - Restricted to a single, specific region; however, multiregional sources/sinks can help mitigate regional outages' impact on performance penalties.
3. **Sinks:**
   - Located in the same or multiple regions as processing for enhanced reliability and data accessibility.

### Multiregional Sources & Sinks

- Utilize geo-redundant options offered by Google Cloud Storage, BigQuery, and Pub/Sub to ensure seamless multi-region data accessibility.

### Cross-Region Dependency Avoidance

- Limit configurations with critical dependencies across regions; e.g., avoid pipelines reading from one region's storage bucket while writing to another region's BigQuery table, as regional failures can affect pipeline operation.

## Disaster Recovery Methods with Dataflow

Dataflow offers two key features for disaster recovery strategies: **Pub/Sub snapshots** and **seek functionality**. These methods are essential in handling streaming pipelines and ensuring the continuity of data processing during unexpected system failures.

### Pub/Sub Snapshots & Seek Functionality

- Capture message acknowledgment state with _Pub/Sub snapshots_
- Alter acknowledgment state of messages en masse using _seek_
- Rework the disaster recovery strategy to accommodate reprocessing and data duplication after a failure.

### Using Pub/Sub Snapshots for Disaster Recovery: Steps

1. **Take snapshots**: Use CLI or Cloud Console to create Pub/Sub subscription snapshots.
2. **Stop & drain pipeline**: Halt processing using the command-line interface (CLI) or Dataflow UI's job details page.
3. **Use seek functionality**: Revert acknowledgment state of messages with the CLI tool.
4. **Resubmit pipeline**: Restart your pipeline either from a development environment, deployment tools, or by using CLI and template commands.
   - Example command for launching templated jobs via CLI: `dataflow --parameters=...`
5. **Considerations**:
   - Pub/Sub messages have a maximum data retention of seven days; weekly snapshps are recommended to prevent data loss in case of pipeline failure.
   - Using both _Pub/Sub snapshot_ and _seek_ may lead to duplicate records, requiring reconciliation within the data sink.

### Dataflow Snapshots for Disaster Recovery: Steps

1. **Create snapshots**: Use UI (CREATE SNAPSHOT button) or CLI to save streaming pipeline state with/without source Pub/Sub snapshot.
2. **Stop & drain pipeline**: Similar to the above process, halt and restart processing as necessary.
3. **Create new job from snapshots**: Deploy jobs using a parameter containing the snapshot ID.
4. **Schedule coordinated Dataflow and Pub/Sub snapshots**: Conduct weekly snapshots for minimal data loss scenarios; use Cloud Composer or Scheduler to automate this process.
   - Snapshots are region-specific, requiring launching jobs in the same region as original job unless handling zonal outages. Regional migration isn't possible with Dataflow snapshots alone.

Both strategies have their use cases and considerations for disaster recovery within streaming pipelines. Implement these methods to maintain data integrity and ensure minimal downtumeven during unexpected system failures or zone/regional outages.

# High Availability Configurations for Dataflow Pipelines

**Key Concepts:**

- Streaming pipelines require high availability configurations.
- Factors include **downtime tolerance (RTO), data loss limitation (RPO)**, and cost considerations.

## High Availability Strategies

1. **Redundant Sources Across Multiple Regions:**
   - Utilize two independent subscriptions in separate regions for the same topic.
   - In case of regional outage, replace with pipeline in second region from backup subscription.
2. **Parallel Pipelines Consuming Duplicate Data:**
   - Run duplicate pipelines simultaneously across different regions/zones.
   - Process data using workers distributed geographically and write to multiregional sinks for fault tolerance.

## Comparison Table: High Availability Configurations

| Configuration Type                           | Resource Duplication       | Downtime Impact                                                 | Data Loss Risk                                                         | Cost Efficiency                                   |
| -------------------------------------------- | -------------------------- | --------------------------------------------------------------- | ---------------------------------------------------------------------- | ------------------------------------------------- |
| Redundant Sources Across Regions             | Limited (source data only) | Minimized with backup subscription replaying                    | Potential for minor losses, depending on snapshot coordination         | More cost-efficient than full duplication         |
| Parallel Pipelines in Multiple Zones/Regions | Full stack duplication     | Zero downtime achieved by multiple instances running parallelly | Very low risk due to geographically distributed processing and storage | Less cost-effective, most expensive configuration |

# Dataflow Flex Templates Module

**Key Concepts:**

- **Flex Templates**: Separate development activities from execution, eliminating reliance on runtime dependencies.
- **Classic Templates** (formerly known as templates): The initial version of flex templates that enable automation and reusability without requiring runtimes.

## Dataflow Template Review & Creation Process

1. **Reviewing Classic Templates:**
   - Originally introduced to aid non-technical users by removing the need for runtime dependencies.
2. **Creating a Flex Template:**
   - Stage pipeline as a template file on Google Cloud Storage, allowing launch without runtime dependencies.

## Comparison Table: Classic Templates vs. Flex Templates

| Feature                  | Classic Templates                  | Flex Templates (Introduced)             |
| ------------------------ | ---------------------------------- | --------------------------------------- |
| Dependencies             | Required for execution             | Eliminated with template use            |
| Automation & Reusability | Enabled by the absence of runtimes | Further improved opportunities and ease |

**Note:** The transition from Classic Templates to Flex Templates enhances automation, reusability, and accessibility across different teams.

# Dataflow Flex Templates Module

**Key Concepts:**

- **Challenges of Classic Templates**:
  - Lack of `ValueProvider` support for Beam I/O transforms.
  - No support for Dynamic DAG (Directed Acyclic Graph).

2. **Introduction to Flex Templates**: Next generation templates addressing the limitations faced by Classic Templates.

### Defining Pipeline Options in Classic Templates and Transition to Flex Templates

- In classic templates, options were converted to runtime parameters using `ValueProvider` interface. However, not all open-source I/O transforms supported this feature.
- Dynamic selection of sync nodes at template launch time was impossible with classic templates, requiring separate variations for each user choice (e.g., writing events to BigQuery or Google Cloud Storage).

## Comparison Table: Classic Templates vs. Flex Templates

| Feature                 | Classic Templates                                  | Flex Templates                                                 |
| ----------------------- | -------------------------------------------------- | -------------------------------------------------------------- |
| `ValueProvider` Support | Limited, not all I/O transforms supported          | Enhanced support for diverse Beam I/Os                         |
| Dynamic DAG             | Not possible at template launch time               | Generated when the end user launches the templates             |
| Template Launching      | Requires separate variations for different options | User-supplied values influence pipeline generation dynamically |

**Note:** Flex Templates provide greater flexibility by allowing dynamic graph generation and broader I/O transform support.

# Flex Templates Module

**Key Concepts:**

- **Creation and Execution of Flex Templates:** Steps for building a flex template, including creating metadata file with parameters details and running the `flex‑template build` command.

## Creating Flex Template

1. **Metadata File Creation**
   - Create a `metadata.json` file detailing pipeline name, description, parameter information, and regex validation for user-supplied values.
2. **Build Command Execution**
   - Run the `gcloud dataflow flex-template build` command with:
     - Path to store Docker image
     - Template specification file
     - Artifact details (jar files or other dependencies) and entry point for execution.
3. **Packaging, Pushing & Storing**
   - Packages pipeline artifacts into a Docker image
   - Image pushed to Google Container Registry
   - Template spec file created on GCS containing the image URL and parameter details.

## Executing Flex Templates

1. **Launching from Console, gcloud or REST API**
2. **Scheduling with Cloud Scheduler (Example: Every 30 Minutes)**

# Google-provided Templates Module

**Key Concepts:**

- **Templates Overview**
  - A wide range of predefined templates for transferring data between different systems or performing simple transformations using JavaScript user-defined functions.

## Template Usage and Execution

1. **Accessing Google-provided Templates:**

   - Accessible without writing code, with all template codes available open-source on GitHub as a learning resource for Dataflow developers.

2. **Template Types:**
   - Classified into three categories: streaming, batch and utility templates; each serving specific purposes (e.gs., Pub/Sub to BigQuery in streaming, BigQuery exporting to Parquet in batch).
3. **Executing Templates:**

   - Executed through console, gcloud, REST API or Scheduler by selecting the chosen template and providing necessary pipeline options.

4. **Template Graphs:**
   - Displayed for classic templates upon selection; flex templates do not render a graph as it may change based on user input.
5. **Community Contribution & Best Practices:**
   - Encouraging contributions to new or existing templates and learning best practices from the GitHub repository.

# NotesGPT: Operations Course Summary - Serverless Data Processing with Dataflow

## Main Concepts Covered in Modules:

1. **Dataflow Monitoring Experience**:
   - Use jobs list page for job monitoring and investigation.
   - Job graph, job info, job metrics tabs for comprehensive job summary.
   - Integration with Metrics Explorer for alerting policies on Dataflow metrics.
2. **Operational Toolkit (Logging & Error Reporting)**:
   - Log sifting through jobs and workers; diagnostics tab surfacing errors.
   - Recommended troubleshooting workflow incorporating error reporting, job info, and metrics tabs.
3. **Common Modes of Failure**:
   - In-depth analysis on failure to build pipeline, start it on Dataflow, execution during pipeline performance issues.
4. **Pipeline Design & Performance Impact**:
   - Consideration for topology, coders, windows, logging and data skewness affecting worker imbalances and underutilization.
5. **Interactions with Sources, Sinks, and External Systems**:
   - Optimizing pipelines by considering limitations and constraints of these components.
6. **Performance Benefits with Shuffle & Streaming Engine**:
   - Offloading data storage from worker attached disks to a scalable backend improving performance.
7. **Dataflow Architecture Testing Best Practices**:
   - Implement testing at various abstraction layers (do functions, PTransforms, pipelines and entire systems).
8. **Update, Drain, Snapshots, Cancel Features of Dataflow**:
   - Modifying deployment of streaming pipelines as per requirements using these features.
9. **Reliability Best Practices for Dataflow Pipelines**:
   - Monitoring dashboards and alerts, utilizing dead letter queues, error logging to avoid pipeline failures.
10. **Zonal/Regional Outage & High Availability**:
    - Implement strategies to protect against regional outages and ensure high availability by running redundant pipelines in different zones or regions.

## Flex Templates in Dataflow:

- Simplified sharing and standardizing of data processing pipelines across an organization using API calls without needing to install runtime dependencies.
- Google offers a variety of templates directly on the Cloud console, allowing for launching Dataflow jobs effortlessly.
- Flex templates are recommended over classic Dataflow templates due to their advantages.
