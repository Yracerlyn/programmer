package lsi.fonctionalite.exec;

import javax.swing.SwingUtilities;

public class Start {
    private Start() {
        // Le constructeur privé empêche l'instanciation de cette classe.
    }
    /**
     * @param args
     */
    // public static void main(String[] args) {
    //     Menu menu = new Menu();
    //     menu.selectMenu();
        
    // }

    public static void main(String[] args) {
        //Menu menu = new Menu();
        //menu.selectMenu();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui gui = new Gui();
                gui.setVisible(true);
            }
        });
    }


}

