package hello.kafka;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MyProducer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Topic Name : ");
		String topic = sc.next();
		System.out.println("Enter Message : ");
		sc.nextLine();
		String message = sc.nextLine();
        sc.close();
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092");
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		producer.send(new ProducerRecord<String, String>(topic, message));
        System.out.println("Message Sent");
        producer.close();
	}
}
