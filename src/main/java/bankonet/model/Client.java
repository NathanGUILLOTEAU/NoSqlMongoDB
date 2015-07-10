package bankonet.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client implements ClientInterface {
	// Attributs
	    private String nom;
	    private String prenom;
	    private String login;
	    private String pwd;
	    private Map<Integer,Compte> compteMap = new HashMap<Integer, Compte>();

	 // Constructor
		 public Client(String nom, String prenom, String login,
					Map<Integer, Compte> compteMap) {
				super();
				this.nom = nom;
				this.prenom = prenom;
				this.login = login;
				this.pwd = "secret";
				this.compteMap = compteMap;
			}
		 
		public Client() {
			super();
		}

	// Get & Set
	    public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public Map<Integer, Compte> getCompteMap() {
			return compteMap;
		}
		
		
//		// Method
//		public Float calculerAvoirGlobal(){
//			Float avGlobal = (float) 0;
//			for (Map.Entry<Integer, Compte> maMap : compteMap.entrySet()) {
//				avGlobal += maMap.getValue().getSolde();
//			}
//			return avGlobal;
//		}
		public String toString(){
			return ("L'avoir du client " + this.nom + " " + this.prenom + " sur son ou ses compte est de  + this.calculerAvoirGlobal() +  €.");
		}
//		
//		
//	// Gestion des comptes HashMap
//		public void creerCompte(Compte compte) {
//	    	this.getCompteMap().put(compte.getIdentifiant(), compte);
//	    }   
//	    public void supprimerComte(Compte compteArg) throws Exception{
//	    	boolean test = false;
//	    	for (Map.Entry<Integer, Compte> maMap : compteMap.entrySet()) {
//				if (compteArg.getIdentifiant() == maMap.getKey()){
//					test= true;
//					this.compteMap.remove(maMap.getKey());
//				}		
//			}
//		
//	    	if (test=false){
//				throw new Exception("Ce compte n'existe pas !");
//	    	}	    	
//	    }
//	    public void supprimerCompte(int id) throws Exception{
//	    	boolean test = false;
//	    	for (Map.Entry<Integer, Compte> maMap : compteMap.entrySet()) {
//				if (id == maMap.getKey()){
//					test= true;
//					compteMap.remove(id);
//				}		
//			}
//	    	if (test=false){
//				throw new Exception("Ce compte n'existe pas !");
//	    	}
//	    }
//	    public Compte retournerCompte(int id) throws Exception{
//	    	Compte myCompte = new Compte();
//	    	boolean test= false;
//	    	for (Map.Entry<Integer, Compte> maMap : compteMap.entrySet()) {
//				if (id == maMap.getKey()){
//					test= true;
//					myCompte = maMap.getValue();
//				}		
//			}
//	    	if (test=false){
//				throw new Exception("Ce compte n'existe pas !");
//	    	}
//	    	return myCompte;
//	    }    
//

		
	
	    
	


}
