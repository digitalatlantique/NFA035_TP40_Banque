package model;

import java.util.ArrayList;

import main.DemoApli;
import view.VuePrincipale;

/**
 * This is a custumer of the bank
 */
public class Client extends Personne {

    /**
     * Default constructor
     */
    public Client() {
    }
    
    /**
     * Constructor with first name, genre, age, administrator
     */
    public Client(String prenom,int age, Genre genre, Gestionnaire gest) {
    	super(prenom);
    	this.age = age;
    	this.genre = genre;
    	this.gestionnaire = gest;
    	this.tresorerie = 0.0;
    	this.idClient = DemoApli.genererIdClient(prenom);
    	super.setProfil("Client");
    	mesComptes = new ArrayList<Compte>(); 
    }

    /**
     * This is an identification of the customer 
     */
    private String idClient;

    /**
     * This is the age of the customer
     */
    private Integer age;

    /**
     * this is the gender of the customer
     */
    private Genre genre;

    /**
     * this is the administrator of the customer
     */
    private Gestionnaire gestionnaire;

    /**
     * this is the balance of the customer
     */
    private Double tresorerie;

    /**
     * To store all the accounts of the customers
     */
    private ArrayList<Compte> mesComptes;
    
    /**
     * To create an account
     * @param type is the kind of account
     */    
    public Compte creerCompte(TypeCompte type, Double solde) {
    	
    	Compte cpt = new Compte(this, type, solde);
    	mesComptes.add(cpt);
    	return cpt;
    }
    
    /**
     * Return the list of all the accounts
     */
    public ArrayList<Compte> listerCompte() {    	
        return this.mesComptes;
    }
    
    /**
     * Return a list of account
     * @param TypeCompte
     */
    public ArrayList<Compte> listerCompte(TypeCompte type) {
    	
    	ArrayList<Compte> listeType = new ArrayList<Compte>();
    	for(int i=0; i<mesComptes.size(); i++) {
    		if(mesComptes.get(i).getType() == type) {
    			listeType.add(mesComptes.get(i));
    		}
    	}
        return listeType;
    }
    	
    
    /**
     * To credit this account
     */
    public void crediter(String numéroCompte, double montant) {
        for(Compte compte : mesComptes) {
        	if(compte.getNumCpte().equals(numéroCompte)) {
        		
    			double nouveauSolde = compte.getSolde() + montant;
    			compte.setSolde(nouveauSolde);        		     	
        	}
        	else {
        		System.out.println("Compte inconnu");
        	}
        }
    }

    /**
     * To dedit the account
     */
    public void debiter(String numéroCompte, double montant) {
    	
        for(Compte compte : mesComptes) {
        	
        	// check the identification of the account
        	if(compte.getNumCpte().equals(numéroCompte)) {
        		
        		// check the balance of the account
        		if(compte.getSolde() - montant <= -1000) {
        			double nouveauSolde = compte.getSolde() + montant;
        			compte.setSolde(nouveauSolde);
        		}
        		else {
        			VuePrincipale.afficherErreur("Solde insuffisant !");
        		}       	
        	}
        	else {
        		VuePrincipale.afficherErreur("Compte inexistant !");
        	}
        }
    }

    /**
     * 
     */
    public void transferer() {
        // TODO implement here
    }
    
    /**
     * To check the cash 
     * @return the cash
     */
    public Double consulterTresorerie() {
    	
    	Double resultat = 0.0;
    	
    	for(int i=0; i<mesComptes.size(); i++) {
    		resultat += mesComptes.get(i).getSolde();
    	}
    	this.tresorerie = (Math.floor(resultat*100))/100;;
    	return resultat;        
    }
    
    /**
     * This object (which is already a string!) is itself returned
     * @return the string itself.
     */
	public String toString() {
		this.consulterTresorerie();
		String str = 	"------------------------------------------------\n"
						+ super.toString() + "\n"
						+ "Identifiant : " + this.idClient +"\n"						
						+ "Age : " + this.age + " ans\n"
						+ "Genre : " + this.genre +"\n"
						+ "Gestionnaire : " + gestionnaire.getPrenom() +"\n"
						+ "Trésorerie : " + this.tresorerie + "Euro(s)\n"
						+"------------------------------------------------\n";
		return str;						 
	}    
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}
	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public Double getTresorerie() {
		this.consulterTresorerie();
		return tresorerie;
	}
	public void setTresorerie(Double tresorerie) {
		this.tresorerie = tresorerie;
	}
}