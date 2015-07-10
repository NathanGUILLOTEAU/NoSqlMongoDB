package bankonet.model;



public class CompteCourant extends Compte{
    private Float decouvertAutorise;
    private static int nbComptesCourants = 0;
       
    // Constructor
	    public CompteCourant(String lib, Float solde, Float decouvertAutorise){
	        this(); 
			super.setLibelle(lib);
			if (solde < 0) {
		        	super.setSolde(0);
		     } else {
		        	 super.setSolde(solde);
		     }   
	        this.decouvertAutorise = decouvertAutorise;
	    }
	    public CompteCourant(){
	    	super();
	        nbComptesCourants++;
	    }
	    
	// Get & Set
	    public static int getNbComptesCourants() {
	        return nbComptesCourants;
	    }  
	    

    
	public Float getDecouvertAutorise() {
			return decouvertAutorise;
		}
		public void setDecouvertAutorise(Float decouvertAutorise) {
			this.decouvertAutorise = decouvertAutorise;
		}
		// Methods
	    public boolean debitAutorise(Float montant) /*throws DebitException*/{
	        if(montant < (super.getSolde() + this.decouvertAutorise)){
	        	return true;
	        } else {
	        	//throw new DebitException("Débit refusé : Découvert autorisé trop faible");
	        	return true;
	        }
	    }

	    public String toString(){
	        return "Le compte " + super.getLibelle() + 
	        		" a un solde de " + super.getSolde() + 
	        		"€ et un découvert autorisé de " +
	        		this.decouvertAutorise +"€.";
	    }
	    
	  }
	    
