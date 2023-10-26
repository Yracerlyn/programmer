package lsi.fonctionalite.exec;

import lsi.fonctionalite.data.ActionsBDDImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*public class DashBoard extends JFrame {

    private JPanel menuPanel;
    private JPanel contentPanel;
    private static Gui Gui;


    public DashBoard(Gui Gui) {
        this.Gui = Gui;
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        setLayout(new BorderLayout());

        menuPanel = createMenuPanel();
        contentPanel = createContentPanel("Contenu du Dashboard");

        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(23, 24, 38));
        panel.setPreferredSize(new Dimension(200, getHeight()));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton btnDashboard = createGradientButton("Dashboard", new Color(96, 95, 228), new Color(153, 118, 229));
        JButton btnMenu = createGradientButton("Menu", new Color(96, 95, 228), new Color(153, 118, 229));
        JButton btnQuitter = createGradientButton("Quitter", new Color(96, 95, 228), new Color(153, 118, 229));

        gbc.gridy++;
        panel.add(btnDashboard, gbc);
        gbc.gridy++;
        panel.add(btnMenu, gbc);
        gbc.gridy++;
        panel.add(btnQuitter, gbc);

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPanel.removeAll();
                contentPanel.add(createMenuContentPanel());
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });

        return panel;
    }

    private JPanel createMenuContentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Alignement au centre avec un espacement de 10px
        panel.setBackground(new Color(35, 36, 56));

        JButton btnAfficherTous = createSmallButton("Afficher tous les programmes");
        JButton btnAfficherUn = createSmallButton("Afficher un programmeur");
        JButton btnSupprimer = createSmallButton("Supprimer un programmeur");
        JButton btnAjouter = createSmallButton("Ajouter un programmeur");

        panel.add(btnAfficherTous);
        panel.add(btnAfficherUn);
        panel.add(btnSupprimer);
        panel.add(btnAjouter);

        // Ajoutez une action pour le bouton "Afficher tous les programmes" ici
        btnAfficherTous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionsBDDImpl actionsBDD = new ActionsBDDImpl();
                String resultat = actionsBDD.printAllProgrammeur();
                Gui.afficherResultat(resultat); // Utilisez la référence de GUI pour appeler la méthode
            }
        });


        return panel;
    }



    private JButton createSmallButton(String text) {
        JButton button = createGradientButton(text, new Color(96, 95, 228), new Color(153, 118, 229));
        button.setPreferredSize(new Dimension(250, 50)); // Taille plus petite
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        return button;
    }


    private JPanel createContentPanel(String contentText) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(35, 36, 56));

        JLabel label = new JLabel(contentText);
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label, BorderLayout.CENTER);

        return panel;
    }

    private JButton createGradientButton(String text, Color startColor, Color endColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint paint = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor, true);
                g2.setPaint(paint);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                super.paintComponent(g);
            }
        };
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(150, 50));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashBoard dashboard = new DashBoard(Gui);
            dashboard.setVisible(true);
        });
    }
}*/