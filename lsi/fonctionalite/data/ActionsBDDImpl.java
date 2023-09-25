package lsi.fonctionalite.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lsi.fonctionalite.utils.Constantes;
import lsi.fonctionalite.utils.Programmeur;

public class ActionsBDDImpl implements ActionsBDD {

    @Override
    public void dataBaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR, Constantes.MOT_DE_PASSE);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dataBaseConnectionEnd() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR, Constantes.MOT_DE_PASSE);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProgrammeur(int idProgrammeur) {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour supprimer un programmeur en utilisant l'ID
            String deleteSQL = "DELETE FROM PROGRAMMEUR WHERE id = ?";
            
            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR, Constantes.MOT_DE_PASSE);
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

    @Override
    public void addProgrammeur(Programmeur programmeur) {
        try{
        dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour ajouter un programmeur
            String insertSQL = "INSERT INTO PROGRAMMEUR (ID ,NOM, PRENOM, ADRESSE, RESPONSABLE, HOBBY, NAISSANCE, SALAIRE, PRIME, PSEUDO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR, Constantes.MOT_DE_PASSE);
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

    @Override
    public void modifySalaire(int idProgrammeur, float newSalaire) {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour modifier le salaire d'un programmeur en utilisant l'ID
            String updateSQL = "UPDATE PROGRAMMEUR SET SALAIRE = ? WHERE id = ?";
            
            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR, Constantes.MOT_DE_PASSE);
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

    @Override
    public void printAllProgrammeur() {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour récupérer les informations de tous les programmeurs
            String selectSQL = "SELECT * FROM PROGRAMMEUR";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR, Constantes.MOT_DE_PASSE);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSQL);

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
                System.out.println(
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printProgrammeur(int id) {
        try {
            dataBaseConnection(); // Établir une connexion à la base de données

            // Créer une requête SQL pour récupérer les informations d'un programmeur en utilisant l'ID
            String selectSQL = "SELECT * FROM PROGRAMMEUR WHERE id = ?";

            Connection connection = DriverManager.getConnection(Constantes.URL, Constantes.UTILISATEUR, Constantes.MOT_DE_PASSE);
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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
                System.out.println(
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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printBestSalaryProgrammeur() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printBestSalaryProgrammeur'");
    }

    @Override
    public void printSameResponsableProgrammeur() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printSameResponsableProgrammeur'");
    }

    @Override
    public void printCommonObjectProgrammeur() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printCommonObjectProgrammeur'");
    }

    @Override
    public void diagramAgeOfProgrammeur() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'diagramAgeOfProgrammeur'");
    }
    
    

}

