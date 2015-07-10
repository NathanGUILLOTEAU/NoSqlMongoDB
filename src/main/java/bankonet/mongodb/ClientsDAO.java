package bankonet.mongodb;

import java.util.Map;

import org.bson.Document;

import bankonet.model.Client;
import bankonet.model.Compte;
import bankonet.model.CompteCourant;
import bankonet.model.CompteEpargne;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ClientsDAO {
	
	// Recuperer la connection à une base (ou la créer)
		public MongoDatabase connectBase(String base){
			MongoClient myCliDB = new MongoClient();
			MongoDatabase myBase = myCliDB.getDatabase(base);
			return myBase;
		}
		
	// Inseret un client
		public Document getDocClient(Client client){
			Document doc = new Document();
			doc.append("nom", client.getNom() );
			doc.append("prenom", client.getPrenom());
			doc.append("login", client.getLogin());
			doc.append("password", client.getPwd());
			String str = "[";
			Boolean premierPassage = true;
			for (Map.Entry<Integer, Compte> maMap : client.getCompteMap().entrySet()) {
				if (premierPassage){
					str = str + getFieldCompte(maMap.getValue()); 
				} else {
					str = str + "," + getFieldCompte(maMap.getValue()); 
				}
				premierPassage = false;
			}
			str= str + "]";
			doc.append("comptesCourants", str);
			
			return doc;
		}
		
	// Transforme un object Compte en chaine de caractère 
		public String getFieldCompte(Compte myCpt){
			String str ="";
			if (myCpt instanceof CompteCourant){
				str="{libelle:"+ myCpt.getLibelle() + ", solde:" + myCpt.getSolde() + ", decouvertAutorise:" + ((CompteCourant) myCpt).getDecouvertAutorise() + "";
			} else if (myCpt instanceof CompteEpargne){
				str="{libelle:"+ myCpt.getLibelle() + ", solde:" + myCpt.getSolde() + ", tauxInteret:" + ((CompteEpargne) myCpt).getTauxInteret() + ", plafond:" + ((CompteEpargne) myCpt).getPlafond() + "";
			} else {
				str="{libelle:"+ myCpt.getLibelle() + ", solde:" + myCpt.getSolde() + "";
			}
			
			return str;
		}
		
		
}
