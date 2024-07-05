+++
title = "Building Batch Pipelines on GCP"
date = "2024-07-03T10:06:10+01:00"
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

# Smart Analytics, Machine Learning & AI on Google Cloud Course Introduction

**Presenter: Damon** (Technical Curriculum Developer at Google)

---

## Key Points:

- **Course Series Overview**: Part of the Data Engineering on Google Cloud course series; fourth and final stage.
- **Focus**: Integrating analytics & machine learning into data pipelines, emphasizing value addition through ML to existing data resources.
- **Machine Learning Value Validation**: Course commencement includes a discussion confirming the assertion that Machine Learning enhances the value of your dataset.

## Key Features of Google Cloud ML Solutions:

| Aspect                        | Description                                                        |
| ----------------------------- | ------------------------------------------------------------------ |
| **Organizational Challenges** | Offers solutions for a broad range, catering to different needs.   |
| **Team Expertise Levels**     | Suitable for organizations with large ML teams and beginners alike |

## Key Course Contents:

1. Evaluating the value of Machine Learning in enhancing data worth.
2. Overview of Google Cloud's Machine Learning (ML) solutions, addressing various organizational needs.
3. Detailed exploration of ML options available on Google Cloud for practical application.
4. Comprehensive guide to productionizing ML solutions using the tools and resources provided by Google Cloud.

---

Note: The course focuses heavily on practical applications while enscribing how machine learning can add significant value to existing data sets, thereby improving decision-making processes within an organization.

# Introduction to Analytics & AI Module

**Presenter: Unnamed Instructor**

---

## Key Points:

- **Module Focus**: Understanding Artificial Intelligence (AI) and its role in enhancing data analytics.
- **Topic Progression**: The module begins with defining AI, progressing to the transition from ad-hoc analysis to data-driven decision making, and concluding with leveraging Machine Learning on Google Cloud.

## Key Module Contents:

1. **Definition of AI**: Exploring what constitutes Artificnial Intelligence.
2. **AI in Data Analytics**: Discussing the role and impact of AI within the realm of data analytics, enhancing decision-making processes based on data insights.
3. **Transition to Data-Driven Decision Making**: Detailing how organizations can move from ad-hoc analysis towards a more structured, data-driven approach in their decision making.
4. **Machine Learning on Google Cloud**: Introduction of various Machine Learning solutions available on Google Cloud platform that help enhance analytics and drive insights.

---

Note: The module provides an overview of AI and its application to data analytics, with a focus on transitioning towards more structured decision-making processes based on data insights. It also introduces the potential of leveraging Google Cloud's machine learning solutions for these purposes.

# AI, Machine Learning (ML), Deep Learning: Key Concepts & Applications

**Presenter: Unnamed Instructor**

---

## Definitions and Differentiation:

1. **Artificial Intelligence (AI)**: A discipline like physics; It refers to machines capable of autonomous thinking, problem-solving, and acting like humans.
2. **Machine Learning (ML)**: The process of deriving predictive insights from data using general algorithms applicable across various datasets. ML aids in making scalable predictions and decisions without custom code.
3. **Deep Learning**: A subset of Machine Learning, it deals with unstructured data like images or speeches and excels at complex problem-solving.

## Key Applications & Examples:

1. Business Intelligence (BI) and Data Analytics: ML is used to make predictive insights from historical data on a large scale, facilitating dynamic decision-making processes that were previously not feasible manually.
2. Image Classification in Real Estate: Keller Williams uses AutoML Vision for automatically recognizing specific features (e.g., built-in bookcases) in house listings to speed up the process of getting houses listed and finding suitable homes for buyers.
3. Quality Control in Food Production: Japanese manufacturer, Kewpie utilizes machine learning algorithms leveraging image recognition capabilities to detect low-quality potato cubes, thus focusing employees on higher value tasks instead of manual inspection.
4. Natural Language Processing (NLP): Google's Natural Language API can be tested in a web browser and is used for analyzing human language data.

## Tools & Platforms:

- **Google Vision AI**: This platform allows users to perform image recognition tasks without the need for any custom code, thus making it an easy tool for implementing AI solutions. It can be accessed through [cloud.google.com/vision](https://console.cloud.google.com/apis/dashboard).
- **Google's Natural Language API**: This platform is used to analyze human language data and is accessible via a web browser at [cloud.google.com/natural language](https://console.cloud.google.com/apis/dashboard#/applications/nlp/apiKeys).

# NotesGPT Summary: From Ad-Hoc Data Analysis to Data-Driven Decisions

## Bicycle Rental Business Scenario in London

**Objective:** Ensure optimal number of bicycles available based on historical trends and usage patterns.

### Ad-hoc data analysis approach

1. Analyze historical data for average daily rental duration over time.
2. Explore variations by station and specific time ranges (e.g., day of the week, hour).
3. Manual sifting through data to find insights.

### Data-Driven Decision Making with AI/ML

1. Automate analysis process using Machine Learning (ML) models for faster and more accurate insights.
2. Use ML algorithms on large datasets to predict future needs based on past usage patterns.
3. Example: Apply a linear regression model against hourly sections of bike rental data.

## Comparison Table

| Approach               | Key Differences                          | Pros & Cons                                                                  |
| ---------------------- | ---------------------------------------- | ---------------------------------------------------------------------------- |
| Ad-hoc                 | Manual analysis, time-consuming          | Controlled exploration                                                       |
|                        | of historical data for insights.         | less scalable                                                                |
| Data-driven with AI/ML | Automated predictions based on ML models | faster and more accurate; large scale and complex data handling capabilities |
|                        | Derive insights from past usage          | may require initial setup time and expertise in ML algorithms                |

# NotesGPT Summary: Options for ML Models on Google Cloud

### Advanced User Tools & Custom Model Development

1. **Custom models** via ML libraries like TensorFlow supported on Vertex AI.
2. Suitable for data scientists with skills and requirements to create tailored custom models.
3. Involves building and training of machine learning models from scratch.
4. Allows flexibility, but may require significant expertise in ML algorithms and libraries.

### AutoML: Tailored Models without Line-by-Line Coding Expertise

1. Utilizes Google's Machine Learning capabilities to build custom models tailored to specific business needs.
2. No need for extensive knowledge of machine learning or running lines of code.
3. Integration with applications and websites is possible, enabling seamless usage without requiring data scientists on the team.
4. Ideal for users looking for ease-of-use and simplicity in creating custom ML models.

### Pretrained Models: Ready for Immediate Use & API Support

1. Prebuilt machine learning models provided by Google, eliminating the need to bring your own data.
2. Designed for immediate integration within applications using respective APIs.
3. Suitable for replacing user input with ML-based solutions quickly and efficiently.
4. Provides a cost-effective solution for users requiring readily available, pretrained models without extensive customization.

## Comparison Table

| Option                   | Key Differences                                         | Pros & Cons                                                                                                                            |
| ------------------------ | ------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| Custom Model Development | Creation and training of ML models                      | Flexibility, requires expertise in ML algorithms and libraries; suited for data scientists with specific needs.                        |
| AutoML                   | Builds customized models using Google's ML capabilities | Easy-to-use, tailored to business requirements without extensive coding or knowledge of ML; integration into applications is possible. |
| Pretrained Models        | Ready for immediate use and API support                 | Quickly replace user input with ML solutions; cost-effective solution for readily available models without customization needs.        |

# NotesGPT Summary: Prebuilt ML Model APIs for Unstructured Data

## Module Introduction and Objective

- Focuses on utilizing **ready-to-use** Machine Learning (ML) APIs for working with unstructured data.
- Definitions of **unstructured data** include audio, video, images, and freeform text.
- Aims to explain the challenges associated with handling unstructured data and discussing available Google Cloud products.

## Unstructured Data Challenges

1. Lack of a predefined schema makes it difficult to organize and analyze unstructuted data.
2. Extracting relevant information requires advanced techniques like natural language processing or computer vision.
3. Large volume of data often results in high computational requirements for processing.

## Google Cloud Products & Solutions for Unstructured Data

1. **AutoML Vision**: Utilizes pre-trained models to analyze and classify images, including object detection and image captioning functionalities.
2. **AutoML Video Intelligence**: Provides video analysis capabilities such as content moderation, labeling objects, and detecting shot changes in videos.
3. **Cloud Speech-to-Text**: Converts spoken language into written text using automatic speech recognition (ASR) technology for audio data processing.
4. **Natural Language API**: Supports natural language understanding by enabling sentiment analysis, entity recognition, and content classification in freeform text data.
5. **Cloud Translation API**: Offers translations between different languages to assist with internationalization of applications dealing with unstructured textual data.

# NotesGPT Summary: Challenges and Solutions in Handling Unstructured Data

## Understanding Unstructured Data

- **Unstructured Data**: Non-uniform data formats like audio, video, images, freeform text (e.g., newspaper pages, sports events).
  - Extracting metadata such as language, content, and context requires advanced ML techniques.

## Challenges with Unstructured Data

1. **Complexity**: Difficulty in identifying patterns due to varied data formats and absence of a predefined schema.
2. **Volume & Computation**: Processing large volumes necessitates significant computational resources, particularly for high-resolution medical images.

## Machine Learning (ML) Solutions with Google Cloud

1. **AutoML Vision**: Pre-trained models for image analysis; features like object detection and captioning.
2. **Dialogflow (Natural Language Understanding Platform)**: Design conversational interfaces, e.g., shopping chatbots by Uniqlo.
3. **Airbus ML Use Case**: Distinguishing clouds from snow cover in satellite imagery using Machine Learning models.
4. **Economic Forecasting via Satellite Imagery Analysis**: Track container ships to improve forecast accuracy with cargo volume data.
5. **Medical Image Diagnostics**: Early diagnosis of conditions like diabetic retinopathy, requiring high computational power due to image resolution.

## Google Cloud ML Products & APIs

- Use pre-trained models and avoid extensive model training on unstructured data (e.g., Vision API).
- Input your data via an API for predictions; the primary downside is if data differs from what was used to train the models, which may affect prediction accuracy.

# ML APIs: Enriching Unstructured Data with Google Cloud Natural Language API

## Introduction

- **Unstructured data**: Free from strict formatting, generated from various sources like email, audio, video, images, texts, social media likes/comments
- Importance of processing unstructured data for business insights (constitutes ~90% of a company's data)
- Utilizing AI technologies to process and enrich this data with labels

## Cloud Natural Language API Features

1. **Syntactic analysis**: Breaks text into tokens, identifies structure, role in the sentence, grammatical information (noun/verb, singular/plural, etc.)
2. Supports 10 languages at the time of writing (consult online documentation for current language support)
3. **Entity Analysis**: Recognizes entities such as people, locations, organizations, events, artwork, consumer products, phone numbers, addresses, dates, and numbers
4. **Sentiment analysis**: Identifies emotional opinion using numerical score and intensity magnitude; classifies content into generally positive, negative or neutral categories (620 categories)

## Applying Labels to Unstructured Data

- Example questions: What is the subject of this email? Does this comment have a positive or negative sentiment?

**Table 1. Comparison of Unstructured Data Types and Analysis Methods**
| Type | Syntactic Analysis | Entity Analysis | Sentiment Analysis |
|------------|--------------------|---------------------|-----------------------|
| Text | Token identification, grammatical information | People, locations, organizations, etc. recognition | Emotional opinion classification (positive/negative/neutral) |
| Image | - | Objects, faces, scenes, text recognition | - |
| Audio | Speech-to-text conversion, transcription analysis | Named entities in audio content, speaker identification | Tone of voice analysis, emotion detection |
| Video | Captioning, scene description extraction | Objects, faces, scenes, text recognition within video frames | Emotion detection from facial expressions and tone |

# Lab: Using the Natural Language API for Text Classification

## Overview

- **Goal**: Understand a set of news articles using Google Cloud's Natural Language API for content classification
- Importance of extracting value from unstructured data, which requires machine learning (difficult to train models)

## Preparation & Data Scope

1. Ensure the dataset is compatible with the intended use of APIs (e.g., news articles vs. non-news texts)
2. Confirm the availability and quality of unstructured data for analysis

**Table 1. Lab Objectives and Requirements**
| Objective | Requirement |
|-----------------------------|----------------------|
| Understand news articles | News article dataset |
| Perform content classification | Compatible dataset, Google Cloud API access |

## Natural Language API Features for Classification

1. **Content analysis**: Identify the primary themes and topics in texts
2. **Entity Analysis**: Recognize key entities such as people, locations, organizations, etc. within articles
3. **Sentiment analysis**: Determine sentiment (positive/negative/neutral) of texts based on emotional tone
4. Additional features can include language detection, syntax parsing, and more

# Getting Startebout with Google Cloud Platform (GCP) & Qwiklabs

## Overview:

- Objective: Navigate using Qwiklabs for practical, hands-on experience with GCP in an interactive lab setting.

**Table 2. Lab Navigation and Setup Steps**
| Step | Requirement/Action |
|------|--------------------|
| Account Creation | Provide email to create a Qwiklabs account or use existing one |
| Launch Lab | Click "Open" button, start lab with timer for completion |
| Access GCP Console | Use username & password provided in tutorial pane |
| Agree Terms of Service | Necessary step before accessing resources |
| Verify Project Details | Ensure project name, ID matches Qwiklabs details |
| Complete Lab Activities | Score increases with each objective met; End Lab to delete project and resources

## Key Takeaways:

1. **Qwiklabs Account**: Create a new account or use an existing one upon launching the lab.
2. **GCP Console Access**: Necessary for interacting within labs, requires username & password from Qwiklabs.
3. **Project Verification**: Confirm project name and ID match those provided in Qwiklabs environment to avoid errors.
4. **Lab Activities Tracking**: Completion of each objective updates a score visible at the top-right corner of the window, which is reset upon ending lab.

# Lab: Using Natural Language API & Big Data Analytics with Notebooks

## Introduction to Notebooks

- **Notebook**: A powerful tool for prototyping Machine Learning solutions, facilitating a mix of live code execution and markdown text.

## Benefits of using notebooks:

1. **Interactive Learning Environment**: Combines code execution with informative notes through Markdown cells to foster an engaging learning experience.
2. **Data Visualization**: Facilitutes the integration and visualization of complex datasets in a clear, comprehensible manner.
3. **Immediate Feedback**: Code can be executed instantly allowing for real-time debugging and problem solving.
4. **Collaboration**: Provides shared environment where multiple users can collaborate on projects simultaneously.
5. **Flexibility**: Allows the execution of any language, making it adaptable to various computational requirements.

## Integrating Notebooks with Google Cloud Services:

1. **Datastore**: Store and retrieve structured data in NoSQL Databases directly from a notebook environment.
2. **BigQuery**: Execute SQL queries against Big Data for large-scale, complex analyses right within the notebook.
3. **Natural Language API**: Classify unstructured text to extract insights and meaningful information with machine learning techniques.
4. **Pub/Sub & Cloud Functions**: Stream data in real time from Pub/Sub for processing using cloud functions, providing an efficient pipeline of operations within the notebook environment.

# Understanding Notebooks

- **What is a Notebook?**: A flexible tool integrating commentary, plots, code execution for data analysis & machine learning tasks. Differs significantly from traditional software development tools or desktop editors by organizing executable code pieces into cells and facilitating collaboration without the need to email documents back and forth.
- **Benefits of using notebooks:**
  - _Iterative Processing_: Optimizes handling data analysis tasks that involve frequent minor code changes, repeated plot examinations, and output printing through individually executable cells rather than whole script execution.
  - _Collaboration_: Enhances teamwork by sharing editable notebooks without the hassle of sending document versions back-and-forth. A seamless experience with real-time collaboration enabled by cloud hosting and version control systems like Git.

## Notebook Environment Characteristics & Features:

1. **Cloud Hosting**: Enables round-the-clock accessibility to your notebook, irrespective of the machine's state or location, facilitating easy collaboration between team members in different geographical locations.
2. **GPU Integration**: Supports GPUs (Graphics Processing Units) for accelerated performance on workloads such as machine learning and data processing. This feature can be added to existing VMs during/after creation or detached when not required.
3. **Integration with Git & BigQuery**: By default, the notebook environment is integrated with version control systems like Git, enabling efficient tracking of changes made by team members across different versions and instances. The seamless connectivity to BigQuery simplifies data retrieval into your notebooks for processing or analysis.
4. **Pre-installed Libraries**: A standard machine learning library is preinstalled in the provided Python environment, allowing users to jumpstart their projects with readily available tools without having to install them manually.
5. **Hardware Flexibility**: Users can start a notebook using any Compute Engine instance type and adjust underlying hardware including machine types as per application needs at different stages of the project.

## Key Points:

- **BigQuery magic functionality** in notebooks allows direct extraction of data from BigQuery.
- Similar to JupyterLabs' magic functions, these enable system commands execution within cells.
- Custom magic functions can be created for specific tasks.

## Benefits and Usage:

1. **Queries Execution**: Check query format, accuracy, and output directly in notebooks.
2. **Integration with Pandas DataFrame**: Save BigQuery query results to a Pandas DataFrame named `df`.
3. **Data Manipulation & Analysis**: Use metadata for data frame descriptions, object types, summary statistics on columns.
4. **Memory Consideration**: Opt for sampling techniques when dealing with large datasets (multi-terabyte or more).
5. **Example Usage**: Generate bar plots from the data within a Pandas DataFrame after executing BigQuery queries.

## Key Points:

- **Lab Focus**: Utilizing BigQuery in JupyterLab on Vertex AI platform.
- **Goals**: Instantiate a Jupyter Notebook, execute BigQuery queries, and use Pandas for processing outputs.

## Steps & Processes:

1. **Jupyter Lab Initialization**: Start by creating a new Jupyter Notebook on Vertex AI.
2. **BigQuery Query Execution**: Run your query directly in the notebook environment.
3. **Output Handling with Pandas**: Manage and manipulate the output data using Pandas library within the notebook cells.

## Key Points:

- **Module Focus**: BigQuery on JupyterLab in Vertex AI platform, ML Pipelines Module 2.tile(1) Introduction and Model Creation
- **Leveraging Pre-Trained Models**: Using Google's pretrained ML APIs for natural language processing.
- **Custom Model Necessity**: For specific use cases or customization, a tailored model trained on personal data is beneficial.

## Overview of Building Custom Models:

1. **Preliminary Options**: Exploration and utilization of Google's pretrained ML APIs for initial model testing.
2. **Custom Model Creation**: Discussion on methods to create a tailored machine learning model with personal data in Vertex AI environment.
3. **ML Pipelines**: Overview of deploying models using Vertex AI pipelines, emphasizing production environments and workflows.
4. **TensorFlow Hub Insights**: Utilization of TensorFlow Hub for accessing a range of ML resources, with considerations on accessibility (public vs restricted).

## Comparisons & Considerations:

- Pre-trained models are beneficial when generic solutions suffice; however, customized models offer more targeted insights and performance.
- Vertex AI pipelines provide a structured approach for ML model deployment, optimizing workflows in production settings.

## Key Points:

- **Google Cloud ML Approaches**: Utilizing pretrained models vs. building custom models; emphasis on Vertex AI.
- **Vertex AI Overview**: Fully managed service supporting entire lifecycle of custom ML model development, training, and deployment.
- **Scalability & Features**: Capabilities including input data transformations, hyperparameter tuning for optimum performance selection, auto-scaling in production environments.

## Custom Model Development Process on Vertex AI:

1. **Experimentation to Production Scale**: Ability to scale custom models from initial experiments to fully operational deployment within Google Cloud.
2. **TensorFlow Integration**: Incorcuating TensorFlow features for advanced model development, such as data transformation and hyperparameter tuning.
3. **Deployment & Auto-scaling**: Deploying models on Vertex AI with auto-scaling functionality to manage client demand efficiently.
4. **Learning Path Integration**: Recommend further exploration of TensorFlow within the Machine Learning on Google Cloud course, part of a larger learning path for data science professionals.

## Key Points:

- **Vertex AI Pipelines**: Integral tool within Google Cloud's ML ecosystem, designed to streamline data engineering workflow for machine learning pipelines.
- **Pipeline Definition & Usage**: Modeling of complex multistep ML workflows into interconnected steps with inputs and outputs; core component in production ML systems across development, testing, deployment stages.
- **ML Pipeline Example Workflow**: Loading datasets from CSV files, outlier removal, dataset partitioning for training/evaluation, model training, model evaluation.
- **Advantages of Vertex AI Pipelines**: Managed Kubernetes clusters and pods; flexible Python SDKs for rapid iteration; automatic metadata storage; robust pipeline management tools; security features; cost efficiency through per-step resource allocation.
- **Governance in ML Systems**: Addressing increasing importance as model usage expands within organizations, leading to the need for governance solutions like Kubeflow pipelines and Vertex AI's approach.

## Key Points:

- **TensorFlow Hub & Vertex AI Pipelines**: Facilitates packaging and sharing ML assets among users; repository for prebuilt components to avoid reinventing the wheel in model development.
- **ML Asset Types on TensorFlow Hub**: Variety of assets including pretrained models, text embeddings, image classification models, video/audio processing models, TF.js/TFLite models.
- **Community Contributions**: Open repository for contributions from the community; detailed asset information available (inputs/outputs and download options).

## Key Points:

- **Lab Introduction**: Practical understanding of Vertex AI Pipelines functionality through a lab exercise using Kubeflow pipeline SDK for ML pipelines execution.
- **Project Setup**: Initial step involves setting up the project environment to prepare for running the Vertex AI Pipeline.
- **Pipeline Configuration & Inspection**: Configuring and inspecting the code of the Kubeflow pipeline is crucial before execution.
- **Execution of AI Pipeline**: Finalizing the process by executing the ML pipeline on Vertex AA

## Key Points:

- **Google Cloud Options**: Offers multiple machine learning solutions; Vertex AI and AutoML are tailored to meet different needs based on time and resources available.
- **Vertex AI Pipelines**: Utilize Vertex AI Pipelines for deploying end-to-end ML pipelines, optimizing the process of model development and deployment.
- **TensorFlow Hub Advantage**: Encourages leveraging prebuilt components from TensorFlow Hub to save time and resources; avoids duplicating efforts by reusing optimized assets in ML pipeline creation.

## Key Points:

- **BigQuery ML Module**: Enables building machine learning models using SQL syntax; democratizes access to ML and AI for individuals with only SQL knowledge.
- **End-to-End Use Case Walkthrough**: Step-by-step guidance through a practical application, showcasing BigQuery ML's capabilities in real-world scenarios.
- **Supported Models**: Detailed discussion on the range of models supported by BigQuery ML for various machine learning tasks.
- **Labs and Hands-On Experience**: Practical labs provided to gain hands-on experience with building, training, and deploying models using BigQuery ML.

## Key Points:

- **BigQuery ML**: Enables custom model building using SQL syntax; offers a simplified approach compared to AutoML for leveraging Google Cloud AI and machine learning options.

- **Process Overview**:

  1. Write an ad‑hack query on data in BigQuery for training data extraction.
  2. Create a custom model, specifying type and hyperparameters.
  3. Evaluate the trained model against requirements.
  4. Make predictions using the trained model on new datasets from BigQuery.

- **Model Creation Syntax**:

  - Use `CREATE OR REPLACE MODEL` statement with specified name, options, and hyperparameters.
  - Define training set within query; example includes logistic regression model for article source classification (GitHub, New York Times, Techcrunch).

- **Model Evaluation**: Utilize `ML.EVALUATE`, examining metrics such as precision, recall, accuracy, and additional scores like f1_score, log_loss, roc_auc to assess model performance.

  - Precision measures the ratio of correctly guessed articles; high value indicates low false positive rate.
  - Recall evaluates correctly predicted positives versus all actual class observations.
  - Accuracy assesses true positives and negatives in relation to total observation count.

- **Prediction**: Models are automatically deployable within BigQuery for serving predictions, without needing separate deployment processes.

# Summary: BigQuery ML Model Types

BigQuery ML supports various types of models for different tasks including classification and regression problems as well as recommender systems and unsupervised learning with clustering. The key model types include logistic regression, deep neural networks (DNNs), gradient boosted trees/XGBoost, DNN regressors, matrix factorization, and K-means clustering.

## Classification Models:

1. **Logistic Regression** - Binary or multi-class classification using a logistic regression model with the model type specified in BigQuery ML.
2. **Deep Neural Networks (DNN)** - Nonlinear relationships modeled through DNN, requiring specification of 'DNN' as the model type and setting hyperparameters like hidden units size.
3. **Gradient Boosted Trees/XGBoost** - Uses gradient boosting approach for classification tasks, where you specify `boosted_tree_classifier` to use this algorithm with adjustable hyperparameters such as maximal tree depth.

## Regression Models:

1. **Linear Regression** - Predicts continuous numeric values using a linear regression model by specifying the dependent variable and relevant features in BigQuery ML query.
2. **Deep Neural Network Regressors (DNN regressor)** - More complex than linear regression, suitable for nonlinear relationships; requires 'dnn_regressor' as model type with hidden units size set.
3. **Gradient Boosted Trees/XGBoost** - Also available for regression tasks by specifying `boosted_tree_regressor` and tuning hyperparameters.
4. **Importing TensorFlow Models** - Pre-trained models from TensorFlow can be imported into BigQuery ML for batch prediction using the 'tensorflow' model type along with specifications of the model name, path in cloud storage, and features used for predictions.

## Recommender Systems:

1. **Matrix Factorization Model** - Collaborative filtering-based recommender system; requires setting the model type to `matrix_ebfractionation` and providing a user-item interactions table. Once trained, this model can be employed to suggest products based on predicted ratings using SQL queries within BigQuery ML.

## Unsupervised Learning:

1. **K-means Clustering** - For unsupervised learning tasks where patterns are identified in data rather than predicting labels; requires standardizing features and removing ID fields, followed by training the model with 'kmeans' as the model type and specifying the number of clusters (e.g., 4). Afterward, analysis on clustered data can be performed to understand unique characteristics using SQL queries or visualization tools like Looker Studio.

## Cheat Sheet:

- **Training a Model**: Use SELECT statement with required model type and features in BigQuery ML query.
- **Evaluating the Model**: Run an EVALUATE QUERY to obtain metrics such as accuracy, F1 score, or RMSE depending on the task (classification/regression).
- **Making Predictions**: Use PREDICT statement with SELECT in a BigQuery SQL query for predictions based on trained models.

# Lab Notes: Predicting Bike Trip Duration with Regression Model in BigQuery ML

**Objective**: To predict bike trip duration using a linear regression model in BigQuery ML.

## Step 1: Prepare the Data

- **Select dataset**: Choose an appropriate dataset containing relevant features for bike ride prediction, such as start time, end time, distance, and average speed. Ensure data is cleaned and preprocessed.

## Step amo: Create a BigQuery Table

- Create a new table in Google Cloud Storage (GCS) to store the selected dataset.

## Step 3: Build the Linear Regression Model

```sql
CREATE OR REPLACE MODEL my_project.my_dataset.bike_model
USING linear regression AS
SELECT tripDuration, startTime, endTime, distance, avgSpeed
FROM `my_project.my_dataset.bike_data`;
```

- **Training the model**: Execute a SQL query to create and train the model using BigQuery ML's CREATE OR REPLACE MODEL statement with the linear regression algorithm.

## Step 4: Evaluate Model Performance

- Use built-in functions in BigQuery ML to evaluate your model performance, such as RMSE (Root Mean Squared Error) and MAE (Mean Absolute Error).

```sql
SELECT train_dataset, test_dataset, rrmse(tripDuration), mae(tripDuration) AS evaluation_metrics FROM my_project.my_dataset.bike_model;
```

## Step 5: Extract Model Weights for Feature Importance Analysis

- **Extract model weights**: Query the trained model to extract feature importance coefficients using BigQuery ML's built-in function, `MODEL_WEIGHTS`.

```sql
SELECT weight.featureName AS feature, weight.coefficientValue AS coefficient
FROM my_project.my_dataset.bike_model.MODEL_WEIGHTS;
```

- **Analyze Feature Importance**: Interpret the extracted coefficients to understand how each input feature affects bike trip duration prediction. A higher absolute value indicates a stronger impact on the outcome variable.

## Conclusion

By following these steps, you can build and evaluate a linear regression model in BigQuery ML for predicting bike trip durations. The final output provides insights into the importance of each input feature affecting the outcome.

# Lab Notes: Generating Movie Recommendations with Matrix Factorization in BigQuery ML

**Objective**: To generate movie recommendations using a matrix factoraturation model in BigQuery ML.

## Step 1: Prepare the Data

- **Select dataset**: Choose an appropriate dataset containing user ratings, movies metadata (genres, actors), and timestamps. Clean and preprocess data for model training.

## Step 2: Create a BigQuery Table

- Create a new table in GCS to store the selected dataset.

## Step 3: Build the Recommendation Model with Matrix Factorization

```sql
CREATE OR REPLACE MODEL my_project.my_dataset.recommender AS
SELECT userId, movieId, rating
FROM `my_project.my_dataset.movie_data`;
```

- **Training the model**: Execute a SQL query to create and train the recommendation model using matrix factorization with BigQuery ML's CREATE OR REPLACE MODEL statement.

## Step 4: Make Single User Predictions

```sql
SELECT userId, movieId, prediction
FROM my_project.my_dataset.recommender
WHERE userId = 'some-user-id';
```

- This query returns movie recommendations for a specific user based on their historical ratings.

## Step 5: Make Batch User Predictions

```sql
SELECT batchUserId, movieId, prediction
FROM my_project.my_dataset.recommender
WHERE NOT (userId = 'some-user-id');
```

- This query returns recommendations for multiple users in a single result set based on their historical ratings and preferences.

## Step 6: Evaluate Model Performance

Use built-in functions such as RMSE, MAE to evaluate your model performance using the same evaluation metrics used in previous labs.

```sql
SELECT train_dataset, test_dataset, rrmse(rating) AS evaluation_metric
FROM my_project.my_dataset.recommender;
```

## Conclusion

By following these steps, you can build a movie recommendation model using matrix factorization in BigQuery ML and make predictions for individual users as well as batches of users based on their historical ratings and preferences.

# Lab Notes: Movie Recommendations in BigQuery ML - Key Takeawatur

**Key Takeaway**: The primary objective of the course was demonstrating how powerful machine learning models can be built directly within BigQuery, utilizing its capabilities for data storage and processing. This eliminates the need to transfer large datasets elsewhere for model training purposes.

# Lab Notes: Custom Model Building with AutoML Module

**Objective**: Understand how Google Cloud's AutoML service allows users to build machine learning models quickly without requiring extensive expertise in the field.

## Key Concepts

- **AutoML Services**: Explore and utilize various AutoML products like Vision, Natural Language, and Tables based on your data type (image, text, or tabular).

## Steps for Model Building with AutoML

1. Choose the appropriate AutoML product depending on the dataset's nature – **Vision** for images, **Natural Language** for text-based datasets, and **Tables** for tabular data.
2. Prepare your dataset: clean, preprocess, and ensure it is in a format suitable for the chosen AutoML service.
3. Train an initial model using the prepared dataset as input. This process can be automated within the AutoML environment to handle feature engineering, hyperparameter tuning, and evaluation of different models' performances.
4. Evaluate and optimize your model based on performance metrics provided by the AutoML service.
5. Use the optimized model for predictive analysis or further development in a production environment.

```python
# Example code to initiate an AutoML training job using Google Cloud Python client library
from google.cloud import automl_v1beta2 as automl
client = automl.AutoMlClient()
project_id = 'your-project-id'
model_display_name = 'your-model-display-name'
# Prepare your dataset input configuration and specify the AutoML service type (e.g., Vision, Natural Language, Tables)
inputs = {...} # Fill in with appropriate data format for chosen AutoML service
config = automl_v1beta2.AutoMlTrainingInputConfig(
    training_input=automl_v1beta2.TrainRequest(...),
    evaluation_input=...,
)
model = {...} # Fill in with appropriate model specification for chosen AutoML service
# Create the model resource and initiate a training job using the specified dataset input configuration, project, and model resources
response = client.create_model(parent='projects/' + project_amoletID', display_name=model_display_name, ...)
```

## Summary of AutoML Products

- **AutoML Vision**: For image data classification, object detection, optical character recognition (OCR), and other computer vision tasks.
- **AutoML Natural Language**: Suitable for text analysis tasks such as sentiment analysis, entity extraction, syntax parsing, and language translation.
- **AutoML Tables**: Designed to work with tabular data like financial statements or customer records, enabling users to perform predictive analytics on structured datasets.

To summarize this comprehensive guide for using AutoML in your project:

1. Prepare your dataset by storing CSV files and source data in a cloud storage bucket within your AutoML project.
2. Verify if the prepared dataset is ready for training; add rows or labels as needed to ensure adequate information and organization.
3. Train your custom model using supervised learning, which involves multiple epochs (full runs through trained group data) to minimize errors.
4. Evaluate the performance of your trained model on unseen test group data for bias removal and effectiveness in prediction/classification; use evaluation report indicators specific to your model type.
5. Access the custom model using project credentials, list models, delete any unneeded ones (note that custom models are temporary), and periodically train new models as needed based on usage patterns or quota limits.
6. Use AutoML's primary classification interface via web UI or cURL for JSON-structured requests; scores indicate confidence levels in the classifications made by your model.
7. Leverage specialized custom models to focus problem-solving, break down complex tasks into multiple steps, and combine these models with prebuilt AI services (e.cuhT) to optimize application performance.
8. If you need advanced features beyond AutoML's capabilities, explore other machine learning and artificial intelligence services for more sophisticated model development.

# AutoML Vision: Image Data Processing & Model Training

## Overview

- **AutoML Vision**: An auto ML product designed for handling image data. It focuses on training models for image classification tasks using various image file formats and sizes, along with a set of best practices to improve model accuracy and performance.

## Image Data Preparation & Training

1. **Image File Formats**: Supports JPEG, PNG, WebP, GIF, BMP, TIFF, ICO (up to 30 MB size). Service requests accept JPEG, PNG, or GIF files (up to ebytesize = 1.5 MB).
2. **Image Conversion**: Images should be converted into Base64 encoding and stored as TXT or compressed ZIP files.
3. **File Size Limit**: The maximum image size is limited to 1.5 MB for service requests, while training supports images up to 30 MB in size.

### Training Best Practices

- **Balanced Labels**: Aim for a ratio of no more than 10 times the most common label's occurrence compared to the least common one.
  - _Example_: For every 1 image with 'label2', there should be at least 1 image with 'label5'.
- **Label Frequency**: Remove low frequency labels to improve model performance.

## Image Labeling Processes

1. **Web UI**: Images can be labeled directly in the web interface provided by AutoML Vision.
2. **Human Labeling Service (HLS)**: For cases with more than 100 unlabeled images, HLS from Google is recommended to handle large-scale labeling tasks efficiently.

## Model Evaluation Metrics

- Use a confusion matrix to evaluate model performance for up to 10 labels or the top 10 misclassified labels in larger datasets (>10 labels).
  - Key metrics: Average precision, Precision, Recall scores
- Low confidence and low variety data may indicate that additional training data is required. Conversely, very high average precision scores could imply a lack of variability or too easy test scenarios. Consider increasing the dataset's diversity to enhance model robustness and performance beyond test data.

## Additional Recommendations

- **Image Properties**: Train models using images with properties similar to those you intend to classify (e.g., resolution, lighting, focus, level of detail) for better accuracy and generalization capabilities.

# AutoML Natural Language Processing

AutoML Natural Language specializes in training models for text data, such as classifying newspaper articles into categories like sports or politics. The process involves handling text within CSV files or documents (.txt or .zip). Here's a summary:

## Data Handling and Format

- **Text location**: Inline text in CSV cells or paths to cloud storage for documents (standard text, no unicode support)
- **Document size**: 1 sentence to 12amoKB maximum per document.
- **Labels**: From 2 up to 100 labels allowed.

## Model Evaluation and Metrics

- _Average Precision_: Value from .5 to 1.0, also referred to as the area under the precision recall curve; higher values indicate better classification accuracy.
- _Confidence Threshold Curves_: Characterizes false positive classifications against true positives for models with one label per document.
- For such models, an additional evaluation metric is provided:
  ```markdown
  - Confusion Matrix
  ```

## Model Lifecycle and Retraining

1. Unused Natural Language custom model after **60 days** will be deleted; used within **6 months** before deletion.
2. To preserve, models need to be periodically retrained due to frequent updates in training and serving methods inside AutoML.
3. Changes may not be backwardly compatible, potentially causing issues with custom model compatibility over time.

## Troubleshooting Low Quality Evaluations

- High confusion and low average precision scores suggest the need for further refinement of datasets or label usage consistency.
- Improvements can include:
  ```markdown
  1. Adding more documents associated with problematic labels
     - Increase training data quantity, variety in examples (length, writing style, word choice) and authors.
  2. Adjusting the number of labels to increase accuracy for remaining ones; removing unhelpful or low-quality labels.
  ```

## Reading Materials & Support

Additional information on evaluations, interpretation, and troubleshooting can be found in online documentation provided alongside AutoML services.

# Summary: Using Google's AutoML Tables for Tabular Data

**Introduction**

- **AutoML Tables** focus on structured data, as opposed to unstructured data handled by Vision and Natural Language models.
- Developed in collaboration between Google Cloud and the Google Brain team.

## Applications of AutoML Tables

- Demonstrated using Mercari's price suggestion challenge:
  - Japan's largest community marketplace with over 1.5 million data rows, rich and noisy dataset.
  - Competition lasting 3 months for a $100k prize, attracting more than 2000 participants (data scientists).

## Training Performance & Importance

- **Quick results**: After just 1 hour of training, models performed well on the leaderboard.
  - _Costs vs Benefits_: Approximately $19 for an hour's worth of AutoML Table training versus a prize pool of $100k.

## Data Requirements & Importing Methods

- **Data characteristics**: 100K to 100M rows, 2 to 1000 columns; size not exceeding 100 GB.
- Support for arrays and structs when importing via BigQuery.
  - Alternative methods include CSV files stored locally or on cloud storage.

## Model Development Steps & Feature Selection

1. **Data Validation**: Checks for null values, outliers, correlation with the target prediction variable.
2. **Feature Selection**: Identify relevant features and define the prediction column.
3. **Training Budget Setting**: Determine node hours to control costs during training process.
4. **Model Evaluation & Metrics Generation** (for both classification and regression models):
   - _Classification_: Precision-Recall AUC, Accuracy, F1 Score, Confusion Matrix, Feature Importances.
   - _Regression_: Root Mean Squared Error, Mean Absolute Percentage Error, Feature Importances.

## Model Testing & Threshold Adjustments (for Classification Models)

- Evaluate performance on test set to assess generalization capabilities.
- Modify score threshold if needed for increased confidence in positive label prediction.

**Deployment Options: Batch or Online Predictions**

- Utilize curl commands, Java, Node.js, or Python APIs for making predictions.

### Decision Making: When to Use AutoML Tables vs Custom Models

- Start with low effort solutions like BigQuery ML and AutoML tables before investing resources in custom model development.

## Overview

- **AutoML**: Enables building of powerful ML models without coding.

### Customization

- Models tailored to specific datasets using appropriate AutoML versions (Vision, Natural Language, Tables).

### Applications per Data Type

| Data Type               | Corresponding AutoML Tool   |
| ----------------------- | --------------------------- | ------------------------------------- |
| Image Data              | **AutoML Vision**           |
| Text Data               | **AutoML Natural Language** | aturated with a color of your choice. |
| Structured/Tabular Data | **AutoML Tables**           |

## Course Summary: "Analytics & AI"

- **AI Importance**: Core topic covered in the course.

### Topics Covered

1. Prebuilt APIs for unstructured data analysis.
2. Deployment and use of notebooks on Google Cloud.
3. Utilizing Kubeflow's extended production capabilities to deploy ML pipelines.
4. Rapid ML model creation using **BigQuery ML**.
5. Understanding features & options in AutoML.

### Course Series: Data Engineering on Google Cloud (Fourth and Final)
