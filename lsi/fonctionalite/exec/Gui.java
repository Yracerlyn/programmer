package lsi.fonctionalite.exec;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    public Gui(){

        /*JLabel label = new JLabel();
        label.setText("test");
        label.setVisible(true);


        JFrame frame = new JFrame(); //creates a frame
        frame.setTitle("User Managment"); //sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(false); //prevent frame from being resized
        frame.setSize(420,420); //sets the x-dimension, and y-dimension of frame
        frame.setVisible(true); //make frame visible
        frame.add(label);*/

        setTitle("Gestion des Utilisateurs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        JButton btnAfficherTous = new JButton("Afficher tous les programmes");
        JButton btnAfficherUn = new JButton("Afficher un programmeur");
        JButton btnSupprimer = new JButton("Supprimer un programmeur");
        JButton btnAjouter = new JButton("Ajouter un programmeur");
        JButton btnModifierSalaire = new JButton("Modifier le salaire");
        JButton btnAutres = new JButton("Autres");
        JButton btnQuitter = new JButton("Quitter le programme");

        panel.add(btnAfficherTous);
        panel.add(btnAfficherUn);
        panel.add(btnSupprimer);
        panel.add(btnAjouter);
        panel.add(btnModifierSalaire);
        panel.add(btnAutres);
        panel.add(btnQuitter);

        add(panel);
    }

     
}
