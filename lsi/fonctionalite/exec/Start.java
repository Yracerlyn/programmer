package lsi.fonctionalite.exec;

public class Start {
    private Start() {
        // Le constructeur privé empêche l'instanciation de cette classe.
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.selectMenu();
        
    }

}

