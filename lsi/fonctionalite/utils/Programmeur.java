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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnNaissance() {
        return this.naissance;
    }

    public void setAnNaissance(int anNaissance) {
        this.naissance = anNaissance;
    }
    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getResponsable() {
        return this.responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getHobby() {
        return this.hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public float getSalaire() {
        return this.salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public float getPrime() {
        return this.prime;
    }

    public void setPrime(float prime) {
        this.prime = prime;
    }
}
