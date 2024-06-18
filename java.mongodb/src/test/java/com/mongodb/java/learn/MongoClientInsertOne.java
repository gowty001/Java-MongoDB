package com.mongodb.java.learn;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoClientInsertOne {
    public static void main(String[] args) {
        String uri = "mongodb+srv://admin:admin@cluster0.4cnso1q.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        // Create a MongoClient
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // Get a specific database
            MongoDatabase database = mongoClient.getDatabase("MongoDB");

            // Get a specific collection
            MongoCollection<Document> collection = database.getCollection("test");

            // Create a document to insert
            Document document = new Document("name", "Hari")
                                    .append("gender", "male")
                                    .append("age", 28)
                                    .append("hobbies", Arrays.asList("Swimming","Volley Ball","Cricket"));
            	

            // Insert the document into the collection
            collection.insertOne(document);

            System.out.println("Document inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
