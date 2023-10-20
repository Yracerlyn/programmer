package lsi.fonctionalite.exec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JPanel {

    public DashBoard() {
        setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2, 1)); // Vous pouvez ajuster le nombre de boutons dans le menu

        JButton btnAfficherTous = new JButton("Dashboard");
        JButton btnAfficherUn = new JButton("Menu");

        menuPanel.add(btnAfficherTous);
        menuPanel.add(btnAfficherUn);

        // Ajoutez un ActionListener au bouton "Menu" pour afficher la classe Gui
        btnAfficherUn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame guiFrame = new Gui();
                guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                guiFrame.setSize(800, 600);
                guiFrame.setVisible(true);
            }
        });

        add(menuPanel, BorderLayout.WEST);
        // Ajoutez d'autres composants au contenu de votre dashboard (à droite du menu)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DashBoard());
            frame.setPreferredSize(new Dimension(800, 600));
            frame.pack();
            frame.setVisible(true);
        });
    }
}
