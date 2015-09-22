package fr.aston.opencrip.service.ex;

/**
 * Erreur d'authentification.
 */
public class BadPasswordException extends AuthentificationException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur de l'objet.
     */
    public BadPasswordException() {
        super();
    }

    /**
     * Constructeur de l'objet.
     * 
     * @param pMessage
     */
    public BadPasswordException(String pMessage) {
        super(pMessage);
    }

    /**
     * Constructeur de l'objet.
     * 
     * @param pCause
     */
    public BadPasswordException(Throwable pCause) {
        super(pCause);
    }

    /**
     * Constructeur de l'objet.
     * 
     * @param pMessage
     * @param pCause
     */
    public BadPasswordException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}