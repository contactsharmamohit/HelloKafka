# HelloKafka
This repository provides brief introduction to basic Kafka concepts followed by a simple Hello World using both CLI and Java Client.

## What is Kafka?
Apache Kakfa is a streaming platform. It uses PubSub (Publisher Subscriber) model for streaming. In Kafka, Publisher is called as Producer and Subscriber is called as Consumer.

## Prerequisites
Kafka requires Java. Make sure you have it in place by executing following command.
```CMD
java -version
```
You should get output similar to following:
```CMD
java version "1.8.0_121"
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)
```
If Java is not installed or configured properly, please follow steps mentioned [here](https://www.java.com/en/download/help/download_options.xml) or [here](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html).

## Downloading Kafka
Head over to Apache Kafka's [download](https://kafka.apache.org/downloads) page and download Kafka.
For reference, [Kafka_2.12-v2.1.0](http://mirrors.wuchna.com/apachemirror/kafka/2.1.0/kafka_2.12-2.1.0.tgz) was used here for windows 7 environment.

Decompress(Extract or Un-Tar) the package and we're good to go.

## Setting up Kafka

### Starting Zookeeper

Open command prompt in `<Extracted-Kafka-Path>\kafka_2.12-2.1.0\` and execute command:
```CMD
bin\windows\zookeeper-server-start.bat config/zookeeper.properties
```
This will start Zookeeper with default configurations specified in "config/zookeeper.properties" properties file.

### Starting Kafka
Open command prompt in `<Extracted-Kafka-Path>\kafka_2.12-2.1.0\` and execute command:
```CMD
bin\windows\kafka-server-start.bat config/server.properties
```
This will start Kafka with default configurations specified in "config/server.properties" properties file.

#### Is it Running?
In order to check whether Kafka is up and running, open command prompt in `<Extracted-Kafka-Path>\kafka_2.12-2.1.0\` and execute command:
```CMD
bin\windows\kafka-topics.bat --list --zookeeper localhost:2181
```
This will list down all topics present in Kafka server.
![ListingKafkaTopics](https://raw.githubusercontent.com/contactsharmamohit/HelloKafka/master/Illustrations/ListingKafkaTopics.JPG)

### Creating a Topic
Open command prompt in `<Extracted-Kafka-Path>\kafka_2.12-2.1.0\` and execute command:
Please note that `HelloKafka` is name of the topic in below command. 
You can give name of your choice for topic and note it down. 
For reference, Topic Name `HelloKafka` will be used in all below commands.
```CMD
bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic HelloKafka
```
![CreatingKafkaTopic](https://raw.githubusercontent.com/contactsharmamohit/HelloKafka/master/Illustrations/CreatingKafkaTopic.JPG)
## Hello World using CLI
### Starting Producer
Open command prompt in `<Extracted-Kafka-Path>\kafka_2.12-2.1.0\` and execute command:
Below command will create a producer for topic specified in below command.
```CMD
bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic HelloKafka
```
This will get you producer console for sending messages to topic.
![StartingProducerCLI](https://raw.githubusercontent.com/contactsharmamohit/HelloKafka/master/Illustrations/StartingProducerCLI.JPG)
Enter any message and hit enter. Get ready to get the entered message in Consumer console.
![SendingMessageProducerCLI](https://raw.githubusercontent.com/contactsharmamohit/HelloKafka/master/Illustrations/SendingMessageProducerCLI.JPG)

### Starting Consumer
Open command prompt in `<Extracted-Kafka-Path>\kafka_2.12-2.1.0\` and execute command:
Below command will create a consumer for topic specified in below command.
```CMD
bin\windows\kafka-console-consumer.bat --zookeeper localhost:2181 --topic HelloKafka --from-beginning
```
This will get you consumer console and show all messages related to topic.
![StartingConsumerCLI](https://raw.githubusercontent.com/contactsharmamohit/HelloKafka/master/Illustrations/StartingConsumerCLI.JPG)

Hello World using CLI is completed.

## Hello World using Java Client
### Producer
Create a project named [HelloKafka](https://github.com/contactsharmamohit/HelloKafka/tree/master/HelloKafka) in Eclipse and import files.
[MyProducer.java](https://github.com/contactsharmamohit/HelloKafka/blob/master/HelloKafka/src/hello/kafka/MyProducer.java) is the Source for Kafka Producer client implementation in Java.
Run the code and enter Topic name created in above steps and add a message. The message will be available in both CLI and Java Consumer.
Refer below illustration for reference.

![StartingConsumerCLI](https://raw.githubusercontent.com/contactsharmamohit/HelloKafka/master/Illustrations/ProducerConsoleJava.JPG)

### Consumer
[MyConsumer.java](https://github.com/contactsharmamohit/HelloKafka/blob/master/HelloKafka/src/hello/kafka/MyConsumer.java) is the Source for Kafka Consumer client implementation in Java.
Run the code and enter Topic name. The Consumer will now show all the messages related to the Topic from Kafka.
Refer below illustration for reference.

![ConsumerConsoleJava](https://raw.githubusercontent.com/contactsharmamohit/HelloKafka/master/Illustrations/ConsumerConsoleJava.JPG)

Hello World using Java is completed.

## Stopping Kafka and Zookeeper
In order to stop Kafka and Zookeeper,

Execute below commands in `<Extracted-Kafka-Path>\kafka_2.12-2.1.0\`
```CMD
bin\windows\kafka-server-stop.bat config/server.properties
bin\windows\zookeeper-server-stop.bat config/zookeeper.properties
```
Please note that we are first stopping Kafka and then Zookeeper as Kafka is managed by Zookeeper hence it should be stopped before Zookeeper.

![StoppingZookeperAndKafka](https://raw.githubusercontent.com/contactsharmamohit/HelloKafka/master/Illustrations/StoppingZookeperAndKafka.JPG)
