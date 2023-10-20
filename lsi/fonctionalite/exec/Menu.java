package lsi.fonctionalite.exec;

import java.util.Scanner;

import lsi.fonctionalite.data.ActionsBDD;
import lsi.fonctionalite.data.ActionsBDDImpl;
import lsi.fonctionalite.exception.InvalidChoiceException;
import lsi.fonctionalite.utils.Programmeur;

public class Menu {

    private ActionsBDD actionsBDD;

    public Menu() {
        actionsBDD = new ActionsBDDImpl();
    }

    public void printMenu() {
        System.out.println("\n");
        System.out.println("Menu:");
        System.out.println("\n");
        System.out.println("1. Afficher tous les programmmes");
        System.out.println("2. Afficher un programmeur");
        System.out.println("3. Supprimer un programmeur");
        System.out.println("4. Ajouter un programmeur");
        System.out.println("5. Modifier le salaire");
        System.out.println("6. Autres");
        System.out.println("7. Quitter le programme");
        System.out.println("Faites un choix !");
    }

    public void selectMenu() {
        boolean exitRequested = false;

        do {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();
            Scanner scanner2 = new Scanner(System.in);
            Scanner scanner3 = new Scanner(System.in);
            Scanner scanner4 = new Scanner(System.in);
            Scanner scanner5 = new Scanner(System.in);

            try {
                validateChoice(choix);

                switch (choix) {
                    case 1:
                        actionsBDD.printAllProgrammeur();
                        break;
                    case 2:
                        System.out.println("Donnez le numéro du programmeur que vous souhaitez afficher:\n");
                        int idPrintProgrammeur = scanner.nextInt();
                        actionsBDD.printProgrammeur(idPrintProgrammeur);
                        break;
                    case 3:
                        System.out.println("Quelle est l'indentifiant du programmeur que vous souhaitez supprimer");
                        int idDeleteProgrammeur = scanner.nextInt();
                        actionsBDD.deleteProgrammeur(idDeleteProgrammeur);
                        break;
                    case 4:
                        System.out.println("Donnez son nom: ");
                        String nomP = scanner2.nextLine();
                        System.out.println("Donnez son prenom: ");
                        String prenomP = scanner2.nextLine();
                        System.out.println("Donnez son année de naissance: ");
                        int naissanceP = scanner2.nextInt();
                        System.out.println("Donnez son adresse: ");
                        String adresseP = scanner3.nextLine();
                        System.out.println("Donnez son pseudo: ");
                        String pseudoP = scanner3.nextLine();
                        System.out.println("Donnez son responsable: ");
                        String responsableP = scanner3.nextLine();
                        System.out.println("Donnez son hobby: ");
                        String hobbyP = scanner4.nextLine();
                        System.out.println("Donnez son salaire: ");
                        float salaireP = scanner4.nextFloat();
                        System.out.println("Donnez sa prime: ");
                        float primeP = scanner4.nextFloat();
                        Programmeur programmeur = new Programmeur(nomP, prenomP, naissanceP, adresseP, pseudoP,
                                responsableP, hobbyP, salaireP, primeP);
                        actionsBDD.addProgrammeur(programmeur);
                        break;
                    case 5:
                        System.out
                                .println("Pour quelle programmeur souhaitez vous modifié le salaire (fournir l'id)\n");
                        int idProgrammeurSalary = scanner.nextInt();
                        System.out.println("Quelle est le nouveau montant du salaire ?\n");
                        float salaryModify = scanner.nextFloat();
                        actionsBDD.modifySalaire(idProgrammeurSalary, salaryModify);
                        break;
                    case 6:
                        boolean exitMenu6 = false;
                        do {
                            autreFonction();
                            int choix2 = scanner.nextInt();
                            try {
                                validateChoice(choix2);
                                switch (choix2) {
                                    case 1:
                                        actionsBDD.printBestSalaryProgrammeur();
                                        break;
                                    case 2:
                                        System.out.println("Dequel responsable s'agit-il ?");
                                        String responsableChoix = scanner5.nextLine();
                                        actionsBDD.printSameResponsableProgrammeur(responsableChoix);
                                        break;
                                    case 3:
                                        actionsBDD.printPorgrammerWithSameHobby();
                                        break;
                                    case 4:
                                        actionsBDD.diagramAgeOfProgrammeur();
                                        break;
                                    case 5:
                                        exitMenu6 = true;
                                        break;
                                }
                            } catch (InvalidChoiceException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (!exitMenu6);
                        break;
                    case 7:
                        exitRequested = true;
                        System.out.println("Vous avez quitté le programme.");
                        break;
                }
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        } while (!exitRequested);
    }

    private void autreFonction() {
        System.out.println("1. Qui est le programmeur le mieux payé");
        System.out.println("2. Qui sont les programmeur qui ont le même responsable");
        System.out.println("3. Liste des activitées des programmeurs");
        System.out.println("4. Diagramme moyenne d'âge des programmeurs");
        System.out.println("5. Retour");
    }

    public void validateChoice(int choix) throws InvalidChoiceException {
        if (choix < 1 || choix > 7) {
            throw new InvalidChoiceException("ERREUR! Veuillez entrer un nombre entre 1 et 6.");
        }
    }

}
