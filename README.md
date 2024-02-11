# Spring Boot + Kafka

## This application reads messages from Kafka and reads them.

### Getting Started

[//]: # (1. Download [this]&#40;https://github.com/Surftrader/spring-boot-kafka-generator&#41; project to generate messages.)

1. [Download](https://kafka.apache.org/downloads#:~:text=kafka_2.13%2D3.6.1.tgz) Kafka release and extract it:
    ```
    $ tar -xzf kafka_2.13-3.6.1.tgz
    $ cd kafka_2.13-3.6.1
    ```
2. Start the Kafka environment

   *Start the ZooKeeper service*
    ```
    $ bin/zookeeper-server-start.sh config/zookeeper.properties
    ```
   *Start the Kafka broker service*
    ```
    $ bin/kafka-server-start.sh config/server.properties
    ```
3. Read the events (just data-temperature topic)
    ```
    $ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic data-temperature --from-beginning
    ```
4. Run this application
5. Run [spring-boot-kafka-generator](https://github.com/Surftrader/spring-boot-kafka-generator) application to generate messages
6. Sending a message once via Curl
    ```
    $ curl -X POST http://localhost:8081/api/v1/data/send -H "Content-Type: application/json" -d '{"sensorId": 1,"timestamp": "2024-02-07T23:00:02","measurement": 28.5,"measurementType": "TEMPERATURE"}'
    ```
7. Automatic message sending via Curl
    ```
    $ curl -X POST http://localhost:8081/api/v1/data/test/send -H "Content-Type: application/json" -d '{"delayInSeconds": 3,"measurementTypes": ["POWER","VOLTAGE","TEMPERATURE"]}'
    ```
