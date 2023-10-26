package lsi.fonctionalite.exec;//package lsi.fonctionalite.exec;

import lsi.fonctionalite.data.ActionsBDDImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DashBoard extends JFrame {

    private JPanel menuPanel;
    private JPanel contentPanel;
    private JTextArea resultTextArea;


    public DashBoard() {
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

        JButton btnDashboard = createSimpleColorButton("Dashboard", new Color(95, 96, 228));
        JButton btnMenu = createSimpleColorButton("Menu", new Color(95, 96, 228));
        JButton btnQuitter = createSimpleColorButton("Quitter", new Color(95, 96, 228));

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

        JScrollPane scrollPane = new JScrollPane();
        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);
        scrollPane.setViewportView(resultTextArea);

        return panel;
    }

    public void afficherResultat(String resultat) {
        resultTextArea.setText(resultat);
    }



    private JButton createSmallButton(String text) {
        JButton button = createSimpleColorButton(text, new Color(95, 96, 228));
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

    public static JButton createSimpleColorButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        return button;
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashBoard dashboard = new DashBoard();
            dashboard.setVisible(true);
        });
    }
}