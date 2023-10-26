package lsi.fonctionalite.utils;

public class Programmeur {
    private int id;
    private String nom;
    private String prenom;
    private int naissance;
    private String adresse;
    private String pseudo;
    private String responsable;
    private String hobby;
    private float salaire;
    private float prime;    

    public Programmeur(String nomProgrammeur, String prenomProgrammeur, int anNaissanceProgrammeur, String adresseProgrammeur, String pseudoProgrammeur, String respProgrammeur, String hobbyProgrammeur, float salaireProgrammeur, float primeProgrammeur) {
        nom = nomProgrammeur;
        prenom = prenomProgrammeur;
        naissance = anNaissanceProgrammeur;
        adresse = adresseProgrammeur;
        pseudo = pseudoProgrammeur;
        responsable = respProgrammeur;
        hobby = hobbyProgrammeur;
        salaire = salaireProgrammeur;
        prime = primeProgrammeur;
    }

    
    /** 
     * @return int
     */
    public int getId() {
        return this.id;
    }

    
    /** 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /** 
     * @return String
     */
    public String getNom() {
        return this.nom;
    }

    
    /** 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    /** 
     * @return String
     */
    public String getPrenom() {
        return this.prenom;
    }

    
    /** 
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    
    /** 
     * @return int
     */
    public int getAnNaissance() {
        return this.naissance;
    }

    
    /** 
     * @param anNaissance
     */
    public void setAnNaissance(int anNaissance) {
        this.naissance = anNaissance;
    }
    
    /** 
     * @return String
     */
    public String getAdresse() {
        return this.adresse;
    }

    
    /** 
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
    /** 
     * @return String
     */
    public String getPseudo() {
        return this.pseudo;
    }

    
    /** 
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    
    /** 
     * @return String
     */
    public String getResponsable() {
        return this.responsable;
    }

    
    /** 
     * @param responsable
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    
    /** 
     * @return String
     */
    public String getHobby() {
        return this.hobby;
    }

    
    /** 
     * @param hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    
    /** 
     * @return float
     */
    public float getSalaire() {
        return this.salaire;
    }

    
    /** 
     * @param salaire
     */
    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    
    /** 
     * @return float
     */
    public float getPrime() {
        return this.prime;
    }

    
    /** 
     * @param prime
     */
    public void setPrime(float prime) {
        this.prime = prime;
    }
}
