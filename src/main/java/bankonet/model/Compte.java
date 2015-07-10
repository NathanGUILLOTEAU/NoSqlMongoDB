package bankonet.model;

public class Compte {
	private String libelle;
	private float solde;
	
	// Constructor
		public Compte(String libelle, float solde) {
			super();
			this.libelle = libelle;
			if (solde < 0) {
		        	this.solde=(float) 0;
		     } else {
		        	 this.solde = solde;
		     }   
		}
		public Compte(){
			
		}
	
	// Get & Set
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		public float getSolde() {
			return solde;
		}
		public void setSolde(float solde) {
			this.solde = solde;
		}
	
	// Methods
	    public void crediter(float montant) throws Exception{
	    	if (this.creditAutorise(montant)){
	    		this.solde += montant;
		    	System.out.println("Compte " + this.getLibelle() + " crédité de " + montant + " €.");
	    	}
	    }
	    public void debiter(float montant) throws Exception{
	    	if (this.debitAutorise(montant)){
	    		this.setSolde(this.getSolde()-montant);
	    		System.out.println ("Compte " + this.getLibelle() + " débité de " + montant + " €.");
	    	}

	    }
		public String toString(){
			return ("Le compte " + this.libelle + " a un solde de : " + this.solde + " €.");
		}
		
		public boolean debitAutorise(Float montant) throws Exception{
			throw new Exception("Le compte n'est pas définit");
	    }
		
		public boolean creditAutorise(Float montant) throws Exception{
			return true;
	    }
		
		public void effectuerVirement(Compte compte, float montant) throws Exception{
			this.debiter(montant);
			compte.crediter(montant);
			System.out.println("Transfert de " + montant + " € du compte " + this.getLibelle() + " au compte " + compte.getLibelle() + ".");
			
		}
}
