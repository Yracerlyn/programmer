package lsi.fonctionalite.exception;

public class InvalidChoiceException extends Exception {
    public InvalidChoiceException(String message) {
        // Le constructeur accepte un argument de type chaîne de caractères (message).
        // L'appel à "super(message)" appelle le constructeur de la classe mère Exception
        super(message);
    }
}
