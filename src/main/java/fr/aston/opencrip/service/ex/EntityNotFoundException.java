package fr.aston.opencrip.service.ex;

/**
 * Erreur d'authentification.
 */
public class EntityNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructeur de l'objet.
     */
    public EntityNotFoundException() {
        super();
    }

    /**
     * Constructeur de l'objet.
     * 
     * @param pMessage
     */
    public EntityNotFoundException(String pMessage) {
        super(pMessage);
    }

    /**
     * Constructeur de l'objet.
     * 
     * @param pCause
     */
    public EntityNotFoundException(Throwable pCause) {
        super(pCause);
    }

    /**
     * Constructeur de l'objet.
     * 
     * @param pMessage
     * @param pCause
     */
    public EntityNotFoundException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}