package lsi.fonctionalite.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import lsi.fonctionalite.data.ActionsBDDImpl;
import lsi.fonctionalite.utils.Programmeur;

public class testActionsBDDImpl {
    private ActionsBDDImpl actionsBDD;

    @Before
    public void setUp() {
        actionsBDD = new ActionsBDDImpl();
    }

    @Test
    public void testDeleteProgrammeur() {
        // Insérer un programmeur de test dans la base de données
        Programmeur testProgrammeur = new Programmeur("Test", "Unitaire", 1990, "Adresse", "Pseudo", "Responsable",
                "Hobby", 5000, 1000);
        actionsBDD.addProgrammeur(testProgrammeur);

        // Récupérer l'ID du programmeur de test
        int idTestProgrammeur = testProgrammeur.getId();

        // Supprimer le programmeur de test
        actionsBDD.deleteProgrammeur(idTestProgrammeur);

        // Vérifier que le programmeur a été supprimé en essayant de le récupérer
        String result = actionsBDD.printProgrammeur(idTestProgrammeur);
        assertTrue(result.contains("Il n'existe pas(ou plus) de programmeur avec l'id: " + idTestProgrammeur));
    }

    @Test
    public void testAddProgrammeur() {
        // Créer un programmeur de test
        Programmeur testProgrammeur = new Programmeur("Test", "Ajout", 1990, "Adresse", "Pseudo", "Responsable",
                "Hobby", 5000, 1000);

        // Ajouter le programmeur de test dans la base de données
        actionsBDD.addProgrammeur(testProgrammeur);

        // Récupérer l'ID du programmeur de test
        int idTestProgrammeur = testProgrammeur.getId();

        // Vérifier que le programmeur a été ajouté en essayant de le récupérer
        String result = actionsBDD.printProgrammeur(idTestProgrammeur);
        assertTrue(result.contains("id: " + idTestProgrammeur));
    }

    @Test
    public void testPrintAllProgrammeur() {
        // Vérifier que la méthode renvoie une chaîne non vide
        String result = actionsBDD.printAllProgrammeur();
        assertTrue(result != null && !result.isEmpty());
    }

    @Test
    public void testModifySalaire() {
        // Créer un programmeur de test et l'ajouter dans la base de données
        Programmeur testProgrammeur = new Programmeur("Test", "Salaire", 1990, "Adresse", "Pseudo", "Responsable",
                "Hobby", 5000, 1000);
        actionsBDD.addProgrammeur(testProgrammeur);

        // Récupérer l'ID du programmeur de test
        int idTestProgrammeur = testProgrammeur.getId();

        // Modifier le salaire du programmeur de test
        float newSalaire = 6000;
        actionsBDD.modifySalaire(idTestProgrammeur, newSalaire);

        // Récupérer les informations modifiées du programmeur de test
        String result = actionsBDD.printProgrammeur(idTestProgrammeur);

        // Créer la chaîne attendue en fonction des informations modifiées
        String expected = " id: " + idTestProgrammeur + "\n" +
                " Nom: Test\n" +
                " Prénom: Salaire\n" +
                " Adresse: Adresse\n" +
                " Pseudo: Pseudo\n" +
                " Responsable: Responsable\n" +
                " Hobby: Hobby\n" +
                " Naissance: 1990\n" +
                " Salaire: " + newSalaire + "\n" +
                " Prime: 1000\n";

        // Assurez-vous que le résultat contient la chaîne attendue
        assertTrue(result.contains(expected));

        // Supprimer le programmeur de test
        actionsBDD.deleteProgrammeur(idTestProgrammeur);
    }

    @Test
    public void testPrintProgrammeur() {
        // Créer un programmeur de test et l'ajouter dans la base de données
        Programmeur testProgrammeur = new Programmeur("Test", "Affichage", 1990, "Adresse", "Pseudo", "Responsable",
                "Hobby", 5000, 1000);
        actionsBDD.addProgrammeur(testProgrammeur);

        // Récupérer l'ID du programmeur de test
        int idTestProgrammeur = testProgrammeur.getId();

        // Vérifier que la méthode renvoie les informations du programmeur de test
        String result = actionsBDD.printProgrammeur(idTestProgrammeur);
        assertTrue(result.contains("id: " + idTestProgrammeur));

        // Supprimer le programmeur de test
        actionsBDD.deleteProgrammeur(idTestProgrammeur);
    }

    @Test
    public void testPrintAllProgrammeurWithSameHobby() {
        // Ajouter plusieurs programmeurs avec le même hobby dans la base de données
        Programmeur programmer1 = new Programmeur("Hobby1", "Test1", 1990, "Adresse", "Pseudo1", "Responsable1",
                "Hobby1", 5000, 1000);
        Programmeur programmer2 = new Programmeur("Hobby2", "Test2", 1990, "Adresse", "Pseudo2", "Responsable2",
                "Hobby1", 5000, 1000);
        actionsBDD.addProgrammeur(programmer1);
        actionsBDD.addProgrammeur(programmer2);

        // Vérifier que la méthode renvoie les programmeurs avec le même hobby
        String result = actionsBDD.printPorgrammerWithSameHobby();

        // Assurez-vous que le résultat contient les noms des programmeurs
        assertTrue(result.contains("Test1"));
        assertTrue(result.contains("Test2"));

        // Supprimer les programmeurs de test
        int idProgrammer1 = programmer1.getId();
        int idProgrammer2 = programmer2.getId();
        actionsBDD.deleteProgrammeur(idProgrammer1);
        actionsBDD.deleteProgrammeur(idProgrammer2);
    }

}
