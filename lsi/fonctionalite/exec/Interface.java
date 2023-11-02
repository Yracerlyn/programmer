package lsi.fonctionalite.exec;

import lsi.fonctionalite.data.ActionsBDD;
import lsi.fonctionalite.data.ActionsBDDImpl;
import lsi.fonctionalite.utils.Constantes;
import lsi.fonctionalite.utils.Programmeur;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    private static ActionsBDD actionsBDD;
    private static JFrame frame;
    private static JPanel dashboardPanel;
    private static JPanel infoPanel;
    private static JLabel totalProgrammeursLabel;
    private static JLabel ageMoyenLabel;
    private static JLabel totalSalaireLabel;
    private static JLabel anneEnCoursLabel;
    private static JPopupMenu autresMenu;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            actionsBDD = new ActionsBDDImpl(); // Remplacez par votre implémentation
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Accueil de l'entreprise de programmation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(Color.black);

        // Créer le tableau de bord sur le côté gauche
        createDashboardPanel();
        frame.add(dashboardPanel, BorderLayout.WEST);

        // Créer le panneau d'informations sur le côté droit
        createInfoPanel();
        frame.add(infoPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void createDashboardPanel() {
        dashboardPanel = new JPanel();
        dashboardPanel.setBackground(Color.decode("#FFFFFF"));
        dashboardPanel.setLayout(new BoxLayout(dashboardPanel, BoxLayout.Y_AXIS));
        dashboardPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        // Ajouter un titre
        JLabel titleLabel = new JLabel("Tableau de Bord");
        titleLabel.setForeground(Color.decode("#0FAC71"));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(40, 0, 40, 0));
        dashboardPanel.add(titleLabel);

        // Boutons du tableau de bord
        String[] buttonLabels = {
                "Tous les programmeurs",
                "Rechercher",
                "Supprimer",
                "Ajouter",
                "Modifier le salaire",
                "Quitter"
        };

        String[] icons = {
                "all.png",
                "programmeur.png",
                "delete.png",
                "ajouter.png",
                "salaire.png",
                "exit.png"
        };

        int i = 0;

        for (String label : buttonLabels) {
            ImageIcon icon = new ImageIcon(
                    new ImageIcon("img\\" + icons[i]).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton button = new JButton(label, icon);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            button.setForeground(Color.WHITE);
            button.setBackground(Color.decode("#24D26D"));
            button.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            button.setMaximumSize(new Dimension(200, 40));
            button.setBorder(new LineBorder(Color.WHITE, 1));
            button.setIcon(icon);

            dashboardPanel.add(button);
            dashboardPanel.add(Box.createRigidArea(new Dimension(0, 25)));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleDashboardButtonClick(label);
                }
            });
            i++;
        }

        // Menu autre
        autresMenu = new JPopupMenu();
        String[] autresOptions = {
                "Qui est le programmeur le mieux payé",
                "Listes des responsables",
                "Qui ont les programmeurs qui ont le même responsable",
                "Liste des activités des programmeurs",
                "Diagramme moyenne d'âge des programmeurs"
        };

        for (String option : autresOptions) {
            JMenuItem item = new JMenuItem(option);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAutresOptionClick(option);
                }
            });
            autresMenu.add(item);
        }

        ImageIcon autreIcon = new ImageIcon(
                new ImageIcon("img\\autre.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
        JButton autreButton = new JButton();
        autreButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        autreButton.setIcon(autreIcon);
        autreButton.setBackground(Color.decode("#ffffff"));
        autreButton.setMaximumSize(new Dimension(40, 40));
        autreButton.setBorder(new LineBorder(Color.WHITE, 1));
        autreButton.setToolTipText("Plus d'options");
        dashboardPanel.add(autreButton);

        autreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autresMenu.show(autreButton, 0, autreButton.getHeight());
            }
        });
        i++;
    }

    private static JTextArea resultTextArea;

    private static void createInfoPanel() {
        infoPanel = new JPanel();
        infoPanel.setBackground(Color.decode("#FFFFFF"));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        ImageIcon totalProgrammeursIcon = new ImageIcon(
                new ImageIcon("img\\nombrepro.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        ImageIcon ageMoyenIcon = new ImageIcon(
                new ImageIcon("img\\age.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        ImageIcon totalSalaireIcon = new ImageIcon(
                new ImageIcon("img\\salairetotal.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        ImageIcon anneEnCoursIcon = new ImageIcon(
                new ImageIcon("img\\anne.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        totalProgrammeursLabel = new JLabel(actionsBDD.nombreTotalProgrammeur() + "");
        totalProgrammeursLabel.setForeground(Color.decode("#1C5588"));
        totalProgrammeursLabel.setToolTipText("Nombre total de programmeur");
        totalProgrammeursLabel.setIcon(totalProgrammeursIcon);

        ageMoyenLabel = new JLabel(actionsBDD.ageMoyenneProgrammeur() + " ans");
        ageMoyenLabel.setForeground(Color.decode("#24D26D"));
        ageMoyenLabel.setToolTipText("Âge moyen des programmeurs");
        ageMoyenLabel.setIcon(ageMoyenIcon);

        totalSalaireLabel = new JLabel(actionsBDD.totalSalaire() + " €");
        totalSalaireLabel.setForeground(Color.decode("#FF584D"));
        totalSalaireLabel.setToolTipText("Total des salaires");
        totalSalaireLabel.setIcon(totalSalaireIcon);

        anneEnCoursLabel = new JLabel(Constantes.ANNEE_ACTUELLE + "\n");
        anneEnCoursLabel.setForeground(Color.BLACK);
        anneEnCoursLabel.setToolTipText("Année en cours");
        anneEnCoursLabel.setIcon(anneEnCoursIcon);

        resultTextArea = new JTextArea(10, 30); // Zone de texte pour les résultats
        resultTextArea.setWrapStyleWord(true);
        resultTextArea.setLineWrap(true);
        resultTextArea.setCaretPosition(resultTextArea.getDocument().getLength());
        resultTextArea.setEditable(false);
        resultTextArea.setBackground(Color.decode("#FFFAF1"));
        resultTextArea.setBorder(new LineBorder(Color.WHITE, 1));

        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(Box.createRigidArea(new Dimension(0, 100)));

        // Ajoutez les éléments à afficher horizontalement
        horizontalBox.add(totalProgrammeursLabel);
        horizontalBox.add(Box.createRigidArea(new Dimension(90, 0))); // Ajoutez un espacement
        horizontalBox.add(ageMoyenLabel);
        horizontalBox.add(Box.createRigidArea(new Dimension(90, 0))); // Ajoutez un espacement
        horizontalBox.add(totalSalaireLabel);
        horizontalBox.add(Box.createRigidArea(new Dimension(90, 0))); 
        horizontalBox.add(anneEnCoursLabel);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        infoPanel.add(horizontalBox);
        infoPanel.add(scrollPane);

    }

    private static void handleDashboardButtonClick(String label) {
        // Vous pouvez implémenter la logique pour chaque bouton ici
        if (label.equals("Tous les programmeurs")) {

            String result = actionsBDD.printAllProgrammeur();
            resultTextArea.setText(result);

        }
        if (label.equals("Rechercher")) {
            String idText = JOptionPane.showInputDialog(frame, "Entrez l'ID du programmeur :");
            if (idText != null && !idText.isEmpty()) {
                try {
                    int id = Integer.parseInt(idText);
                    String result = actionsBDD.printProgrammeur(id);
                    resultTextArea.setText(result);
                } catch (NumberFormatException ex) {
                    resultTextArea.setText("L'ID du programmeur doit être un nombre entier.");
                }
            } else {
                resultTextArea.setText("Vous n'avez pas entré d'ID de programmeur.");
            }
        } else if (label.equals("Supprimer")) {
            String idText = JOptionPane.showInputDialog(frame, "Entrez l'ID du programmeur à supprimer :");
            if (idText != null && !idText.isEmpty()) {
                try {
                    int id = Integer.parseInt(idText);
                    actionsBDD.deleteProgrammeur(id);
                    resultTextArea.setText("Programmeur avec l'ID " + id + " a été supprimé.");
                } catch (NumberFormatException ex) {
                    resultTextArea.setText("L'ID du programmeur doit être un nombre entier.");
                }
            } else {
                resultTextArea.setText("Vous n'avez pas entré d'ID de programmeur.");
            }
        } else if (label.equals("Ajouter")) {
            String nom = JOptionPane.showInputDialog(frame, "Entrez le nom du programmeur :");
            String prenom = JOptionPane.showInputDialog(frame, "Entrez le prénom du programmeur :");
            String anNaissanceText = JOptionPane.showInputDialog(frame, "Entrez l'année de naissance du programmeur :");
            String adresse = JOptionPane.showInputDialog(frame, "Entrez l'adresse du programmeur :");
            String pseudo = JOptionPane.showInputDialog(frame, "Entrez le pseudo du programmeur :");
            String resp = JOptionPane.showInputDialog(frame, "Entrez le responsable du programmeur :");
            String hobby = JOptionPane.showInputDialog(frame, "Entrez le hobby du programmeur :");
            String salaireText = JOptionPane.showInputDialog(frame, "Entrez le salaire du programmeur :");
            String primeText = JOptionPane.showInputDialog(frame, "Entrez la prime du programmeur :");

            if (nom != null && prenom != null && anNaissanceText != null && adresse != null && pseudo != null
                    && resp != null &&
                    hobby != null && salaireText != null && primeText != null &&
                    !nom.isEmpty() && !prenom.isEmpty() && !anNaissanceText.isEmpty() && !adresse.isEmpty()
                    && !pseudo.isEmpty() &&
                    !resp.isEmpty() && !hobby.isEmpty() && !salaireText.isEmpty() && !primeText.isEmpty()) {
                try {
                    int anNaissance = Integer.parseInt(anNaissanceText);
                    float salaire = Float.parseFloat(salaireText);
                    float prime = Float.parseFloat(primeText);
                    Programmeur nouveauProgrammeur = new Programmeur(nom, prenom, anNaissance, adresse, pseudo, resp,
                            hobby, salaire, prime);
                    actionsBDD.addProgrammeur(nouveauProgrammeur);
                    resultTextArea.setText("Programmeur ajouté avec succès.");
                } catch (NumberFormatException ex) {
                    resultTextArea.setText(
                            "L'année de naissance, le salaire et la prime du programmeur doivent être des nombres valides.");
                }
            } else {
                resultTextArea.setText("Veuillez remplir tous les champs pour ajouter un programmeur.");
            }
        } else if (label.equals("Modifier le salaire")) {
            String idText = JOptionPane.showInputDialog(frame, "Entrez l'ID du programmeur à modifier le salaire :");
            String nouveauSalaireText = JOptionPane.showInputDialog(frame, "Entrez le nouveau salaire :");

            if (idText != null && nouveauSalaireText != null && !idText.isEmpty() && !nouveauSalaireText.isEmpty()) {
                try {
                    int id = Integer.parseInt(idText);
                    float nouveauSalaire = Float.parseFloat(nouveauSalaireText);
                    actionsBDD.modifySalaire(id, nouveauSalaire);
                    resultTextArea.setText("Salaire du programmeur avec l'ID " + id + " modifié avec succès.");
                } catch (NumberFormatException ex) {
                    resultTextArea
                            .setText("L'ID du programmeur et le nouveau salaire doivent être des nombres valides.");
                }
            } else {
                resultTextArea.setText("Veuillez remplir tous les champs pour modifier le salaire du programmeur.");
            }
        } else if (label.equals("Quitter")) {
            int response = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter ?", "Quitter",
                    JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    private static void handleAutresOptionClick(String option) {
        // Gérer les actions associées à chaque option ici
        if (option.equals("Qui est le programmeur le mieux payé")) {
            String result = actionsBDD.printBestSalaryProgrammeur();
            resultTextArea.setText(result);
        } else if (option.equals("Qui ont les programmeurs qui ont le même responsable")) {
            JTextField responsableTextField = new JTextField();
            Object[] message = {
                    "Entrez le nom du responsable :",
                    responsableTextField
            };
            int optionResult = JOptionPane.showConfirmDialog(frame, message, "Entrez le nom du responsable",
                    JOptionPane.OK_CANCEL_OPTION);

            if (optionResult == JOptionPane.OK_OPTION) {
                String responsable = responsableTextField.getText();
                if (!responsable.isEmpty()) {
                    String result = actionsBDD.printSameResponsableProgrammeur(responsable);
                    resultTextArea.setText(result);
                } else {
                    resultTextArea.setText("Veuillez entrer un nom de responsable.");
                }
            }
        } else if (option.equals("Liste des activités des programmeurs")) {
            String result = actionsBDD.printPorgrammerWithSameHobby();
            resultTextArea.setText(result);
        } else if (option.equals("Diagramme moyenne d'âge des programmeurs")) {
            int[] countTable = actionsBDD.diagramInterface();
            int countJunior = countTable[0];
            int countExpert = countTable[1];
            int countSenior = countTable[2];

            JFrame frame = new JFrame("Diagramme d'âge des programmeurs");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel chartPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int barWidth = 100;
                    int barSpacing = 30;
                    int x = 50;

                    // Dessiner les barres pour chaque catégorie d'âge
                    g.setColor(Color.blue);
                    g.fillRect(x, 300 - countJunior, barWidth, countJunior);
                    g.setColor(Color.green);
                    g.fillRect(x + barWidth + barSpacing, 300 - countExpert, barWidth, countExpert);
                    g.setColor(Color.red);
                    g.fillRect(x + 2 * (barWidth + barSpacing), 300 - countSenior, barWidth, countSenior);

                    // Étiquettes pour les catégories d'âge
                    g.setColor(Color.black);
                    g.drawString("Junior (20-29 ans)", x, 320);
                    g.drawString("Expert (30-39 ans)", x + barWidth + barSpacing, 320);
                    g.drawString("Senior (40-50 ans)", x + 2 * (barWidth + barSpacing), 320);
                }
            };

            frame.add(chartPanel);
            frame.setVisible(true);

        } else if (option.equals("Listes des responsables")) {
            resultTextArea.setText(actionsBDD.printAllResponsable());
        }
    }
}