package mongo.db;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoMain {

	public static void main(String[] args) {
		Logger.getLogger("").setLevel(Level.SEVERE);
		
		// Connexion & chargement
			MongoClient myCli = new MongoClient();
			MongoDatabase myBase = myCli.getDatabase("persondb");
			MongoCollection<Document> myPersons= myBase.getCollection("persons");
		
		// Insert
			Document doc = new Document();
			doc.append("nom", "GUILLOTEAU");
			doc.append("prenom", "Nathan");
			myPersons.insertOne(doc);	
		
		// Uttiliser mes collections
			FindIterable<Document> resultPersons = myPersons.find();
			Iterator<Document> myIt = resultPersons.iterator();
			while (myIt.hasNext()){
				Document myDoc = myIt.next();
				//System.out.println(myDoc.get("nom"));
				System.out.println(myDoc.toJson());
			}
	}

}
