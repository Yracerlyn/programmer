package lsi.fonctionalite.exec;

import lsi.fonctionalite.data.ActionsBDD;
import lsi.fonctionalite.data.ActionsBDDImpl;
import lsi.fonctionalite.utils.Programmeur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lsi.fonctionalite.exec.Gui;


public class Gui extends JFrame {

    private JTextArea resultTextArea;

    DashBoard DashBoard = new DashBoard(this); // Passez la référence de la GUI

    public Gui(){

        setTitle("Gestion des Utilisateurs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton btnAfficherTous = new JButton("Afficher tous les programmes");
        JButton btnAfficherUn = new JButton("Afficher un programmeur");
        JButton btnSupprimer = new JButton("Supprimer un programmeur");
        JButton btnAjouter = new JButton("Ajouter un programmeur");
        JButton btnModifierSalaire = new JButton("Modifier le salaire");
        JButton btnAutres = new JButton("Autres");
        JButton btnQuitter = new JButton("Quitter le programme");

        buttonPanel.add(btnAfficherTous);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espace vertical
        buttonPanel.add(btnAfficherUn);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnSupprimer);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnAjouter);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnModifierSalaire);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnAutres);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonPanel.add(btnQuitter);

        JScrollPane scrollPane = new JScrollPane();
        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);
        scrollPane.setViewportView(resultTextArea);

        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Espace horizontal
        mainPanel.add(scrollPane);

        add(mainPanel);

        btnAfficherTous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActionsBDDImpl actionsBDD = new ActionsBDDImpl();
                String resultat = actionsBDD.printAllProgrammeur();
                afficherResultat(resultat);
            }
        });

        ActionsBDD actionsBDD = new ActionsBDDImpl(); // Instanciez la classe ActionsBDDImpl


        btnAfficherUn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Demandez à l'utilisateur de saisir l'ID du programmeur
                String idProgrammeurStr = JOptionPane.showInputDialog(Gui.this, "Veuillez entrer l'ID du programmeur :");

                // Vérifiez si l'utilisateur a annulé la saisie
                if (idProgrammeurStr != null && !idProgrammeurStr.isEmpty()) {
                    try {
                        // Convertissez l'ID en entier
                        int idProgrammeur = Integer.parseInt(idProgrammeurStr);

                        // Appelez la méthode pour afficher les détails du programmeur
                        ActionsBDDImpl actionsBDD = new ActionsBDDImpl();
                        String resultat = actionsBDD.printProgrammeur(idProgrammeur);

                        // Affichez les informations dans la zone de texte
                        //JOptionPane.showMessageDialog(Gui.this, resultat, "Détails du Programmeur", JOptionPane.INFORMATION_MESSAGE);

                        afficherResultat(resultat);
                        //resultTextArea.setText(resultat);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Gui.this, "L'ID doit être un nombre entier.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Demandez à l'utilisateur de saisir l'ID du programmeur à supprimer
                String idProgrammeurStr = JOptionPane.showInputDialog(Gui.this, "Veuillez entrer l'ID du programmeur à supprimer :");

                // Vérifiez si l'utilisateur a annulé la saisie
                if (idProgrammeurStr != null && !idProgrammeurStr.isEmpty()) {
                    try {
                        // Convertissez l'ID en entier
                        int idProgrammeur = Integer.parseInt(idProgrammeurStr);

                        // Appelez la méthode de suppression du programmeur
                        ActionsBDDImpl actionsBDD = new ActionsBDDImpl();
                        actionsBDD.deleteProgrammeur(idProgrammeur);

                        // Affichez un message pour informer l'utilisateur
                        JOptionPane.showMessageDialog(Gui.this, "Le programmeur avec l'ID " + idProgrammeur + " a été supprimé.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Gui.this, "L'ID doit être un nombre entier.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Créez une boîte de dialogue pour saisir les informations du programmeur
                JTextField nomField = new JTextField(10);
                JTextField prenomField = new JTextField(10);
                JTextField adresseField = new JTextField(10);
                JTextField responsableField = new JTextField(10);
                JTextField hobbyField = new JTextField(10);
                JTextField naissanceField = new JTextField(10);
                JTextField salaireField = new JTextField(10);
                JTextField primeField = new JTextField(10);
                JTextField pseudoField = new JTextField(10);

                JPanel myPanel = new JPanel();
                myPanel.setLayout(new GridLayout(9, 2));
                myPanel.add(new JLabel("Nom:"));
                myPanel.add(nomField);
                myPanel.add(new JLabel("Prénom:"));
                myPanel.add(prenomField);
                myPanel.add(new JLabel("Adresse:"));
                myPanel.add(adresseField);
                myPanel.add(new JLabel("Responsable:"));
                myPanel.add(responsableField);
                myPanel.add(new JLabel("Hobby:"));
                myPanel.add(hobbyField);
                myPanel.add(new JLabel("Année de naissance:"));
                myPanel.add(naissanceField);
                myPanel.add(new JLabel("Salaire:"));
                myPanel.add(salaireField);
                myPanel.add(new JLabel("Prime:"));
                myPanel.add(primeField);
                myPanel.add(new JLabel("Pseudo:"));
                myPanel.add(pseudoField);

                int result = JOptionPane.showConfirmDialog(Gui.this, myPanel, "Entrez les informations du programmeur", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    // Récupérez les valeurs saisies par l'utilisateur
                    String nom = nomField.getText();
                    String prenom = prenomField.getText();
                    int naissance = Integer.parseInt(naissanceField.getText());
                    String adresse = adresseField.getText();
                    String pseudo = pseudoField.getText();
                    String responsable = responsableField.getText();
                    String hobby = hobbyField.getText();
                    float salaire = Float.parseFloat(salaireField.getText());
                    float prime = Float.parseFloat(primeField.getText());

                    // Appelez la méthode d'ajout de programmeur
                    ActionsBDDImpl actionsBDD = new ActionsBDDImpl();
                    Programmeur nouveauProgrammeur = new Programmeur(nom, prenom, naissance, adresse, pseudo, responsable, hobby, salaire, prime);
                    actionsBDD.addProgrammeur(nouveauProgrammeur);

                    // Affichez un message pour informer l'utilisateur
                    JOptionPane.showMessageDialog(Gui.this, "Le programmeur a été ajouté avec succès.");
                }
            }
        });


        btnModifierSalaire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Demandez à l'utilisateur de saisir l'ID du programmeur et le nouveau salaire
                JTextField idProgrammeurField = new JTextField(10);
                JTextField nouveauSalaireField = new JTextField(10);

                JPanel myPanel = new JPanel();
                myPanel.setLayout(new GridLayout(2, 2));
                myPanel.add(new JLabel("ID du programmeur:"));
                myPanel.add(idProgrammeurField);
                myPanel.add(new JLabel("Nouveau salaire:"));
                myPanel.add(nouveauSalaireField);

                int result = JOptionPane.showConfirmDialog(Gui.this, myPanel, "Modifier le salaire du programmeur", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    // Récupérez l'ID du programmeur et le nouveau salaire saisis par l'utilisateur
                    int idProgrammeur = Integer.parseInt(idProgrammeurField.getText());
                    float nouveauSalaire = Float.parseFloat(nouveauSalaireField.getText());

                    // Appelez la méthode de modification de salaire
                    ActionsBDDImpl actionsBDD = new ActionsBDDImpl();
                    actionsBDD.modifySalaire(idProgrammeur, nouveauSalaire);

                    // Affichez un message pour informer l'utilisateur
                    JOptionPane.showMessageDialog(Gui.this, "Le salaire du programmeur a été modifié avec succès.");
                }
            }
        });


        btnAutres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Gui.this, "Autres actions");
            }
        });

        btnQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public static void showMenuContent() {
    }

    public static void showDashboardContent() {
    }

    void afficherResultat(String resultat) {
        resultTextArea.setText(resultat);
    }

    public void afficherTous() {
    }
}
