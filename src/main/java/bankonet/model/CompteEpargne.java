package bankonet.model;


public final class CompteEpargne extends Compte{
    private float tauxInteret;
    private float plafond;
    
    // Constructor
    	public CompteEpargne(String libelle, float solde, float tauxInteret, float plafond) {
        super();
		super.setLibelle(libelle);
		if (solde < 0) {
	        	super.setSolde(0);
	     } else {
	        	 super.setSolde(solde);
	     }   
        this.tauxInteret = tauxInteret;
        this.plafond = plafond;
    }

    // Get & Set
	    public float getTauxInteret() {
	        return tauxInteret;
	    }
	    public void setTauxInteret(float newTauxInteret) {
	        tauxInteret = newTauxInteret;
	    }
		public float getPlafond() {
			return plafond;
		}

		public void setPlafond(float plafond) {
			this.plafond = plafond;
		}

	// Method		
	    public boolean debitAutorise(Float montant) /*throws DebitException*/{
	        if((super.getSolde()-montant)<0){
	        	//throw new DebitException("Débit refusé : Votre solde ne peut pasêtre négatif !");
	        	return true;
	        } else {
	        	return true;
	        }
	    }
	    public boolean creditAutorise(Float montant) /*throws CreditException*/{
	        if((super.getSolde()+montant)>this.getPlafond()){
	        	//throw new CreditException("Vous ne pouvez pas dépasser votre plafond de " + this.getPlafond() + " €.");
	        	return true;
	        } else {
	        	return true;
	        }
	    }
		public String toString(){
		        return ("Le compte " + super.getLibelle() + 
		        		" a un solde de " + super.getSolde() + 
		        		"€, un taux d'intéret de " +
		        		this.tauxInteret +
		        		" et un plafond de " + this.getPlafond() + " €.");

		 }





}