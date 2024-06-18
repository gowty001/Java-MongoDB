package com.mongodb.java.learn;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoClientConnectionTest {
    public static void main(String[] args) {
        String uri = "mongodb+srv://admin:admin@cluster0.4cnso1q.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        // Create a MongoClient
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // Get a specific database
            MongoDatabase database = mongoClient.getDatabase("MongoDB");

            // Check if we can connect to the database
            database.listCollectionNames().first();

            System.out.println("Successfully connected to the database");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database");
        }
    }
}
