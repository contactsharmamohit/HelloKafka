package hello.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class MyConsumer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Topic Name : ");
		String topic = sc.next();
		sc.close();
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
		properties.put("auto.offset.reset", "earliest");
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		consumer.subscribe(Arrays.asList(topic));
		System.out.println("Subscribed to topic " + topic);
		ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
		for (ConsumerRecord<String, String> record : records)
			System.out.printf("%s\n", record.value());
		consumer.close();
	}
}
