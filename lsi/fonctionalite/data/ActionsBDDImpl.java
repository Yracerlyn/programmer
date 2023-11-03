package lsi.fonctionalite.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lsi.fonctionalite.utils.Constantes;
import lsi.fonctionalite.utils.Programmeur;

public class ActionsBDDImpl implements ActionsBDD {

    /**
     * Connection à la base de donnée
     */
    @Override
    public void dataBaseConnection() {
        try {
            // charge le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Établit la connexion à la base de données en utilisant les constantes pour
            // l'URL, le nom d'utilisateur et le mot de passe.
            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
        } catch (SQLException e) {
            // En cas d'erreur SQL (par exemple, échec de connexion), cette exception sera
            // capturée.
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // En cas d'erreur de chargement du JDBC
            e.printStackTrace();
        }
    }

    /**
     * Déconnexion à la base de donnée
     */
    @Override
    public void dataBaseConnectionEnd() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            connection.close();// fermer la connexion
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param idProgrammeur
     *                      Supprime un programmeur dans la base de donnée
     *                      Le programmeur avec l'id idPorgrammeur sera supprimer
     */
    @Override
    public void deleteProgrammeur(int idProgrammeur) {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour supprimer un programmeur en utilisant l'ID
            String deleteSQL = "DELETE FROM PROGRAMMEUR WHERE id = ?";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, idProgrammeur);

            // Exécuter la requête
            preparedStatement.executeUpdate();

            // Fermer la connexion
            preparedStatement.close();
            dataBaseConnectionEnd();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param programmeur
     *                    Ajoute un programmeur dans la base de donnée
     */
    @Override
    public void addProgrammeur(Programmeur programmeur) {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour ajouter un programmeur
            String insertSQL = "INSERT INTO PROGRAMMEUR (ID ,NOM, PRENOM, ADRESSE, RESPONSABLE, HOBBY, NAISSANCE, SALAIRE, PRIME, PSEUDO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, programmeur.getNom());
            preparedStatement.setString(3, programmeur.getPrenom());
            preparedStatement.setString(4, programmeur.getAdresse());
            preparedStatement.setString(5, programmeur.getResponsable());
            preparedStatement.setString(6, programmeur.getHobby());
            preparedStatement.setInt(7, programmeur.getAnNaissance());
            preparedStatement.setFloat(8, programmeur.getSalaire());
            preparedStatement.setFloat(9, programmeur.getPrime());
            preparedStatement.setString(10, programmeur.getPseudo());

            // Exécuter la requête
            preparedStatement.executeUpdate();

            // Fermer la connexion
            preparedStatement.close();
            dataBaseConnectionEnd();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param idProgrammeur
     * @param newSalaire
     */
    @Override
    public void modifySalaire(int idProgrammeur, float newSalaire) {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour modifier le salaire d'un programmeur en utilisant
            // l'ID
            String updateSQL = "UPDATE PROGRAMMEUR SET SALAIRE = ? WHERE id = ?";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setFloat(1, newSalaire);
            preparedStatement.setInt(2, idProgrammeur);

            // Exécuter la requête
            preparedStatement.executeUpdate();

            // Fermer la connexion
            preparedStatement.close();
            dataBaseConnectionEnd();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return String
     *         Affiche tous les programmeurs dans la base de données
     *
     */
    @Override
    public String printAllProgrammeur() {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour récupérer les informations de tous les
            // programmeurs
            String selectSQL = "SELECT * FROM PROGRAMMEUR";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            StringBuilder result = new StringBuilder();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("NOM");
                String prenom = resultSet.getString("PRENOM");
                String adresse = resultSet.getString("ADRESSE");
                String responsable = resultSet.getString("RESPONSABLE");
                String hobby = resultSet.getString("HOBBY");
                int naissance = resultSet.getInt("NAISSANCE");
                float salaire = resultSet.getFloat("SALAIRE");
                float prime = resultSet.getFloat("PRIME");
                String pseudo = resultSet.getString("PSEUDO");

                result.append(
                        " id: " + id + "\n" +
                                " Nom: " + nom + "\n" +
                                " Prénom: " + prenom + "\n" +
                                " Adresse: " + adresse + "\n" +
                                " Pseudo: " + pseudo + "\n" +
                                " Responsable: " + responsable + "\n" +
                                " Hobby: " + hobby + "\n" +
                                " Naissance: " + naissance + "\n" +
                                " Salaire: " + salaire + "\n" +
                                " Prime: " + prime + "\n" +
                                "\n");
            }

            // Fermer la connexion
            resultSet.close();
            statement.close();
            dataBaseConnectionEnd();

            return result.toString(); // Renvoie les résultats sous forme de chaîne de caractères
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la récupération des données.";
        }
    }

    /**
     * @param id
     * @return String
     *         Affiche le programmeur avec l'id renseigner
     */
    @Override
    public String printProgrammeur(int id) {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour récupérer les informations d'un programmeur en
            // utilisant l'ID
            String selectSQL = "SELECT * FROM PROGRAMMEUR WHERE id = ?";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder result = new StringBuilder();
            if (resultSet.next()) {
                do {
                    id = resultSet.getInt("id");
                    String nom = resultSet.getString("NOM");
                    String prenom = resultSet.getString("PRENOM");
                    String adresse = resultSet.getString("ADRESSE");
                    String responsable = resultSet.getString("RESPONSABLE");
                    String hobby = resultSet.getString("HOBBY");
                    int naissance = resultSet.getInt("NAISSANCE");
                    float salaire = resultSet.getFloat("SALAIRE");
                    float prime = resultSet.getFloat("PRIME");
                    String pseudo = resultSet.getString("PSEUDO");
                    result.append(
                            " id: " + id + "\n" +
                                    " Nom: " + nom + "\n" +
                                    " Prénom: " + prenom + "\n" +
                                    " Adresse: " + adresse + "\n" +
                                    " Pseudo: " + pseudo + "\n" +
                                    " Responsable: " + responsable + "\n" +
                                    " Hobby: " + hobby + "\n" +
                                    " Naissance: " + naissance + "\n" +
                                    " Salaire: " + salaire + "\n" +
                                    " Prime: " + prime + "\n");
                } while (resultSet.next());
            } else {
                return "Il n'existe pas(ou plus) de programmeur avec l'id: " + id + ".";
            }

            return result.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la récupération des données.";
        }
    }

    /**
     * Affiche le programmeur qui a le meilleur salaire
     * 
     * @return String
     */
    @Override
    public String printBestSalaryProgrammeur() {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            String selectSQL = "SELECT * FROM PROGRAMMEUR ORDER BY SALAIRE DESC LIMIT 1";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            StringBuilder result = new StringBuilder();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("NOM");
                String prenom = resultSet.getString("PRENOM");
                String adresse = resultSet.getString("ADRESSE");
                String responsable = resultSet.getString("RESPONSABLE");
                String hobby = resultSet.getString("HOBBY");
                int naissance = resultSet.getInt("NAISSANCE");
                float salaire = resultSet.getFloat("SALAIRE");
                float prime = resultSet.getFloat("PRIME");
                String pseudo = resultSet.getString("PSEUDO");

                result.append(
                        " id: " + id + "\n" +
                                " Nom: " + nom + "\n" +
                                " Prénom: " + prenom + "\n" +
                                " Adresse: " + adresse + "\n" +
                                " Pseudo: " + pseudo + "\n" +
                                " Responsable: " + responsable + "\n" +
                                " Hobby: " + hobby + "\n" +
                                " Naissance: " + naissance + "\n" +
                                " Salaire: " + salaire + "\n" +
                                " Prime: " + prime + "\n");
            } else {
                return "Aucun programmeur trouvé.";
            }

            resultSet.close();
            statement.close();
            dataBaseConnectionEnd();
            return result.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la récupération des données.";
        }
    }

    /**
     * @param responsable
     * @return String
     *         Affiche les programmeurs qui ont le même responsable
     */
    @Override
    public String printSameResponsableProgrammeur(String responsable) {
        try {
            dataBaseConnection();

            String selectSQL = "SELECT * FROM PROGRAMMEUR WHERE RESPONSABLE = ?";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, responsable);
            ResultSet resultSet = preparedStatement.executeQuery();
            StringBuilder result = new StringBuilder();
            if (resultSet.next()) {
                result.append("Programmeurs ayant le même responsable " + responsable + ":\n");
                do {
                    int id = resultSet.getInt("id");
                    String nom = resultSet.getString("NOM");
                    String prenom = resultSet.getString("PRENOM");
                    result.append(
                            " id: " + id + "\n" +
                                    " Nom: " + nom + "\n" +
                                    " Prénom: " + prenom + "\n" +
                                    "_____________________________\n");
                } while (resultSet.next());
            } else {
                result.append("Aucun programmeur avec le responsable " + responsable + " trouvé.");
            }

            resultSet.close();
            preparedStatement.close();
            dataBaseConnectionEnd();
            return result.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la récupération des données.";
        }
    }

    /**
     * @return String
     *         Affiche les programmeur avec les mêmes hobby
     */
    @Override
    public String printPorgrammerWithSameHobby() {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            int anneeActuelle = Constantes.ANNEE_ACTUELLE;

            // Calculer l'âge des programmeurs en utilisant la différence entre l'année
            // actuelle et l'année de naissance
            String selectSQL = "SELECT NOM, PRENOM, HOBBY FROM PROGRAMMEUR";
            StringBuilder result = new StringBuilder();
            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            Map<String, List<String>> hobbiesByType = new HashMap<>();

            while (resultSet.next()) {
                String nom = resultSet.getString("NOM");
                String prenom = resultSet.getString("PRENOM");
                String hobby = resultSet.getString("HOBBY");

                // Ajouter le hobby à la liste correspondante dans la Map
                hobbiesByType.computeIfAbsent(hobby, k -> new ArrayList<>()).add(nom + " " + prenom);
            }

            if (!hobbiesByType.isEmpty()) {
                result.append("Hobbies des programmeurs par type : \n");
                for (Map.Entry<String, List<String>> entry : hobbiesByType.entrySet()) {
                    String hobbyType = entry.getKey();
                    List<String> programmers = entry.getValue();

                    result.append(hobbyType + ": " + String.join(", ", programmers) + "\n");
                }
            } else {
                return "Aucun résultat trouvé. \n";
            }
            resultSet.close();
            preparedStatement.close();
            dataBaseConnectionEnd();
            return result.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la récupération des données.";
        }
    }

    /**
     * Affiche le diagramme selon des âges des programmeurs
     */
    @Override
    public void diagramAgeOfProgrammeur() {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Récupérer l'année actuelle depuis la classe constante
            int anneeActuelle = Constantes.ANNEE_ACTUELLE;
            // Créer une requête SQL pour sélectionner l'âge de tous les programmeurs
            String selectSQL = "SELECT NAISSANCE FROM PROGRAMMEUR";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            int countJunior = 0;
            int countExpert = 0;
            int countSenior = 0;

            while (resultSet.next()) {
                int anneeNaissance = resultSet.getInt("NAISSANCE");
                int age = anneeActuelle - anneeNaissance;

                // Classer les programmeurs en fonction de leur âge
                if (age >= 20 && age < 30) {
                    countJunior++;
                } else if (age >= 30 && age < 40) {
                    countExpert++;
                } else if (age >= 40 && age <= 50) {
                    countSenior++;
                }
            }

            // Afficher le diagramme
            System.out.println("Diagramme d'âge des programmeurs :");
            System.out.println("Junior (20-29 ans): " + getStars(countJunior));
            System.out.println("Expert (30-39 ans): " + getStars(countExpert));
            System.out.println("Senior (40-50 ans): " + getStars(countSenior));

            // Fermer la connexion
            resultSet.close();
            statement.close();
            dataBaseConnectionEnd();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param count
     * @return String
     */
    private String getStars(int count) {
        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stars.append("*");
        }
        return stars.toString();
    }

    /**
     * @return int
     */
    @Override
    public int nombreTotalProgrammeur() {
        int count = 0;
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            String selectSQL = "SELECT COUNT(*) FROM PROGRAMMEUR";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1); // Récupérer la valeur du compte depuis la première colonne du résultat
            }
            resultSet.close();
            preparedStatement.close();
            dataBaseConnectionEnd();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * @return float
     *         Calcul le salaire total dépensé par l'entreprise pour les
     *         programmeurs
     */
    @Override
    public float totalSalaire() {
        float salaireTotal = 0;
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            String selectSQL = "SELECT SALAIRE FROM PROGRAMMEUR";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                float salaire = resultSet.getFloat("SALAIRE");
                salaireTotal += salaire; // Ajouter le salaire au total
            }
            resultSet.close();
            preparedStatement.close();
            dataBaseConnectionEnd();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salaireTotal;
    }

    /**
     * @return int la moyenne d'âge des programmeur
     *         Calcul l'âge moyenne des programmeurs dans la base de donnée
     */
    @Override
    public int ageMoyenneProgrammeur() {
        int moyenneAge = 0;
        int totalAge = 0;
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            String selectSQL = "SELECT NAISSANCE FROM PROGRAMMEUR";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int age = Constantes.ANNEE_ACTUELLE - resultSet.getInt("NAISSANCE");
                totalAge += age;
                moyenneAge = totalAge / nombreTotalProgrammeur();
            }
            resultSet.close();
            preparedStatement.close();
            dataBaseConnectionEnd();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moyenneAge;
    }

    /**
     * @return String
     */
    @Override
    public String printAllResponsable() {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour récupérer les informations de tous les
            // programmeurs
            String selectSQL = "SELECT DISTINCT RESPONSABLE FROM PROGRAMMEUR";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            StringBuilder result = new StringBuilder();

            while (resultSet.next()) {
                if (!(resultSet.getString("RESPONSABLE").equals("N/A"))) {
                    String responsable = resultSet.getString("RESPONSABLE");
                    result.append(
                            " Responsable: " + responsable + "\n");
                }
            }

            // Fermer la connexion
            resultSet.close();
            statement.close();
            dataBaseConnectionEnd();

            return result.toString(); // Renvoie les résultats sous forme de chaîne de caractères
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la récupération des données.";
        }
    }

    @Override
    public int[] diagramInterface() {
        int[] countTable = new int[3];
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Récupérer l'année actuelle depuis la classe constante
            int anneeActuelle = Constantes.ANNEE_ACTUELLE;
            // Créer une requête SQL pour sélectionner l'âge de tous les programmeurs
            String selectSQL = "SELECT NAISSANCE FROM PROGRAMMEUR";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR,
                    Constantes.MOT_DE_PASSE);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

            int countJunior = 0;
            int countExpert = 0;
            int countSenior = 0;

            while (resultSet.next()) {
                int anneeNaissance = resultSet.getInt("NAISSANCE");
                int age = anneeActuelle - anneeNaissance;

                // Classer les programmeurs en fonction de leur âge
                if (age >= 20 && age < 30) {
                    countJunior++;
                } else if (age >= 30 && age < 40) {
                    countExpert++;
                } else if (age >= 40 && age <= 50) {
                    countSenior++;
                }
            }
            countTable[0] = countJunior;
            countTable[1] = countExpert;
            countTable[2] = countSenior;
            // Fermer la connexion
            resultSet.close();
            statement.close();
            dataBaseConnectionEnd();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return countTable;
    }
}
