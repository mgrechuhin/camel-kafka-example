# camel-kafka-example

### How to Run

1. Start kafka with two topics: words and sentences
2. Start the Processor
    1. Install camel-kafka-kafka-connector (download from [camel website](https://camel.apache.org/camel-kafka-connector/latest/connectors.html), unzip, edit connect-standalone.properties)
    2. Define the delimiter and run the connector
        ```sh
        $ export KAFKA_OPTS=-Dline.separator=.
        $ bin/connect-standalone.sh config/connect-standalone.properties $PROCESSOR_HOME/MySentenceConnector.properties
        ```
3. Start cassandra and create myapp keyspace with the sentences table:
    ```sql
    create table sentences(id uuid primary key, sentence text);
    ```
4. Start the Rest Client
    ```sh
    $ cd rest-client
    $ mvn spring-boot:run
    ```
5. Put in your words
    ```sh
    curl -X PUT -d 'Hello' http://localhost:8090/word
    ```
