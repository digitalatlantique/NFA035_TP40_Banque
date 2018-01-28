package model;

/**
 * This is an account of the customer. The account is made of an identification, a first name, a type and the balance 
 * @author Win7
 *
 */
public class Compte {
	
	private String numCpte;
	private String prenom;
	private TypeCompte type;
	private Double solde;
	
	/**
	 * Default constructor
	 */
	public Compte() {
		
	}
	
	/**
	 * Constructor
	 * Initialize with the first name, the kind of account, the initial balance
	 * @param prenom
	 * @param type
	 * @param solde
	 */
	public Compte(Client client, TypeCompte type, Double solde) {
		this.prenom = client.getPrenom();
		this.type = type;
		this.solde = solde;
		this.numCpte = client.getIdClient();
;		
	}

	public String getNumCpte() {
		return numCpte;
	}	
	public String getPrenom() {
		return prenom;
	}
	public TypeCompte getType() {
		return type;
	}
	public void setType(TypeCompte type) {
		this.type = type;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public String toString() {
		String str = "------------------------------------------------\n"
						+"Compte n : " + this.numCpte + "\n"
						+"Pr�nom : " + this.prenom + "\n"
						+"Type : " + this.type + "\n"
						+"Solde : " + this.solde + " Euro(s)\n"
						+"------------------------------------------------";
		return str;
	}
	

}
