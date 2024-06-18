package com.mongodb.java.learn;

import java.util.stream.StreamSupport;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoClientGetCollectionNames {
	public static void main(String[] args) {
		String uri = "mongodb+srv://admin:admin@cluster0.4cnso1q.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

		// Create a MongoClient
		try (MongoClient mongoClient = MongoClients.create(uri)) {
			// Get a specific database
			MongoDatabase database = mongoClient.getDatabase("MongoDB");

			// Check if we can connect to the database by listing collections
			MongoIterable<String> collectionsList = database.listCollectionNames();

			StreamSupport.stream(collectionsList.spliterator(), false).forEach(System.out::println);
//            .collect(Collectors.toList());
			
			// Print the collection names to verify connection
//			for (String name : collectionsList) {
//				System.out.println(name);
//			}

			System.out.println("Successfully connected to the database");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to connect to the database");
		}
	}
}
