package fr.aston.opencrip.service.ex;

/**
 * Erreur d'authentification.
 */
public class UserNotFoundException extends AuthentificationException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur de l'objet.
     */
    public UserNotFoundException() {
        super();
    }

    /**
     * Constructeur de l'objet.
     *
     * @param pMessage
     */
    public UserNotFoundException(String pMessage) {
        super(pMessage);
    }

    /**
     * Constructeur de l'objet.
     *
     * @param pCause
     */
    public UserNotFoundException(Throwable pCause) {
        super(pCause);
    }

    /**
     * Constructeur de l'objet.
     *
     * @param pMessage
     * @param pCause
     */
    public UserNotFoundException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}