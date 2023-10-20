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

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        JPanel panel1 = new JPanel();


        /*JTextArea resultTextArea = new JTextArea();
        resultTextArea.setEditable(false); // Empêche l'édition du texte
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);*/

        resultTextArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        panel1.add(scrollPane); // Ajoutez la zone de texte à votre interface utilisateur


        JButton btnAfficherTous = new JButton("Afficher tous les programmes");
        JButton btnAfficherUn = new JButton("Afficher un programmeur");
        JButton btnSupprimer = new JButton("Supprimer un programmeur");
        JButton btnAjouter = new JButton("Ajouter un programmeur");
        JButton btnModifierSalaire = new JButton("Modifier le salaire");
        JButton btnAutres = new JButton("Autres");
        JButton btnQuitter = new JButton("Quitter le programme");

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(7, 1));
        btnPanel.add(btnAfficherTous);
        btnPanel.add(btnAfficherUn);
        btnPanel.add(btnSupprimer);
        btnPanel.add(btnAjouter);
        btnPanel.add(btnModifierSalaire);
        btnPanel.add(btnAutres);
        btnPanel.add(btnQuitter);
        panel.add(btnPanel, BorderLayout.WEST);

        add(panel);
    

        /*JTextArea resultTextArea = new JTextArea();
        resultTextArea.setEditable(false); // Empêche l'édition du texte
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);*/

        /*btnAfficherTous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ActionsBDDImpl actionsBDD = new ActionsBDDImpl();
                String resultat = actionsBDD.printAllProgrammeur();
                afficherResultat(resultat);
            }
        });*/


        ActionsBDD actionsBDD = new ActionsBDDImpl(); // Instanciez la classe ActionsBDDImpl

        btnAfficherTous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String resultat = actionsBDD.printAllProgrammeur(); // Appelez la méthode correspondante
                afficherResultat(resultat);
            }
        });


        /*btnAfficherTous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String result = actionsBDD.printAllProgrammeur(); // Appel de la méthode modifiée pour obtenir les résultats
                resultTextArea.setText(result); // Met à jour le JTextArea avec les résultats
            }
        });*/



        btnAfficherUn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Gui.this, "Afficher un programmeur");
            }
        });

        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Gui.this, "Supprimer un programmeur");
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
    public void afficherResultat(String resultat) {
        Label resultTextArea = new Label();
        resultTextArea.setText(resultat);
    }

}
