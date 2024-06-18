package com.mongodb.java.learn;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoClientUpdateOne {
	public static void main(String[] args) {
		String uri = "mongodb+srv://admin:admin@cluster0.4cnso1q.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

		// Create a MongoClient
		try (MongoClient mongoClient = MongoClients.create(uri)) {
			// Get a specific database
			MongoDatabase database = mongoClient.getDatabase("MongoDB");

			// Get a specific collection
			MongoCollection<Document> collection = database.getCollection("test");

			Document document = (Document) collection.find(new Document("name", "Gowtham")).first();
			
			if(document!=null) {
				System.out.println("User Found : "+document.toString());
				Bson updateValue = new Document("age", 24);
				Bson updateOperation = new Document("$set", updateValue);
				collection.updateOne(document, updateOperation);
				System.out.println("Document Updated Successfully");
			}
			document = (Document) collection.find(new Document("name", "Gowtham")).first();
			System.out.println("Document After Update :  "+document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
