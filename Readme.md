# TTL based Topic replication Manager

TTL based Topic replication Manager is a Spring Boot application designed to manage the replication of topics from Kafka to MongoDB using the MongoDB Sink Connector. It allows users to dynamically control the list of topics being replicated by configuring a TTL (Time-To-Live) for each topic replication.

## Features

- Add and remove topics from the replication list dynamically.
- Set a TTL for each topic to control the duration of replication.
- View active topics along with their remaining TTL.
- REST API for managing topics programmatically.
- Web interface for managing topics interactively.

## REST API Endpoints

- `POST /api/topics` - Add a new topic for replication.
    - Request Body: `{"topicName": "topic1", "ttlHours": 2}`

- `GET /api/topics` - Get a list of active topics.

- `DELETE /api/topics/{topicName}` - Remove a topic from the replication list.

## Web Interface

- Accessible at `http://localhost:9000`.
- Provides forms for adding and removing topics.
- Displays a list of active topics along with their remaining TTL.

## Setup

1. Clone the repository: `git clone https://github.com/your-username/kafka-mongodb-sink-manager.git`
2. Navigate to the project directory: `cd kafka-mongodb-sink-manager`
3. Build the project: `./gradlew build`
4. Run the application: `./gradlew bootRun`
5. Open a web browser and navigate to `http://localhost:9000` to access the web interface.

## Dependencies

- Spring Boot 3.1.5
- H2 Database
- Thymeleaf




