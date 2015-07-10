package bankonet.banquier;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import bankonet.model.Client;
import bankonet.model.Compte;
import bankonet.model.CompteCourant;
import bankonet.mongodb.ClientsDAO;

public class BanquierMain {

	public static void main(String[] args) {
		Logger.getLogger("").setLevel(Level.SEVERE);
		System.out.println("*****	APPLICATION	CONSEILLER	BANCAIRE ******");
		System.out.println("0. Arrêter le programme");
		System.out.println("1. Ouvrir un compte");
		System.out.println("Veuillez choisir une action.");

		Boolean bonChoix= false;
		
		do {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			
			switch (Integer.parseInt(str)) {
			//FERMETURE
            case 0:  	bonChoix=true;
						System.out.println("Fermeture de l'application");
            			break;
            
           // ETAPE 1
            case 1:  	bonChoix=true;
						// Nom
							String strName = "";
							do {
								System.out.println("Nom du client :");
								Scanner scName = new Scanner(System.in);
								strName = scName.nextLine();
							} while (strName.equalsIgnoreCase(""));
						// Prenom
							String strFirstName = "";
							do {
								System.out.println("Prénom du client :");
								Scanner scFirstName = new Scanner(System.in);
								strFirstName = scFirstName.nextLine();
							} while (strFirstName.equalsIgnoreCase(""));
						// Login
							String strLogin = "";
							do {
								System.out.println("Login du client :");
								Scanner scLogin = new Scanner(System.in);
								strLogin = scLogin.nextLine();
							} while (strLogin.equalsIgnoreCase(""));
						// Création de mon object Client
							Map<Integer,Compte> compteMap = new HashMap<Integer, Compte>();
							CompteCourant myCC = new CompteCourant("" + strName + "_" + strFirstName + "_COURANT_1", new Float("0"), new Float("200"));
							compteMap.put(1, myCC);
							Client myCli = new Client(strName, strFirstName, strLogin, compteMap);
							System.out.println("Le client " + myCli.getNom() + " " + myCli.getPrenom() + " [" + myCli.getLogin() + "] a bien été créé avec le compte suivant :");
							System.out.println(myCC.toString());
						// Ajout dans ma BD
							// Connexion & chargement
								ClientsDAO myConnect = new ClientsDAO();
								MongoCollection<Document> myClients= myConnect.connectBase("bankonetDB").getCollection("clients");
							// Insert
								myClients.insertOne(myConnect.getDocClient(myCli));	
						break;
						
			// Si invalid
            default : 	System.out.println("Choix incorect !");
						System.out.println("0. Arrêter le programme");
						System.out.println("1. Ouvrir un compte");
						System.out.println("Veuillez choisir une action.");
						break;
			}
		} while (!bonChoix);
            
	}

}
