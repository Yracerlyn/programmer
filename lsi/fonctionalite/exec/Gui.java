package lsi.fonctionalite.exec;

import lsi.fonctionalite.data.ActionsBDD;
import lsi.fonctionalite.data.ActionsBDDImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    private JTextArea resultTextArea;
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
                JOptionPane.showMessageDialog(Gui.this, "Ajouter un programmeur");
            }
        });

        btnModifierSalaire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Gui.this, "Modifier le salaire");
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
    private void afficherResultat(String resultat) {
        resultTextArea.setText(resultat);
    }

}
