package fr.aston.opencrip.service.ex;

/**
 * Erreur tehcnique.
 */
public class TechnicalErrorException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructeur de l'objet.
     */
    public TechnicalErrorException() {
        super();
    }

    /**
     * Constructeur de l'objet.
     * 
     * @param pMessage
     */
    public TechnicalErrorException(String pMessage) {
        super(pMessage);
    }

    /**
     * Constructeur de l'objet.
     * 
     * @param pCause
     */
    public TechnicalErrorException(Throwable pCause) {
        super(pCause);
    }

    /**
     * Constructeur de l'objet.
     * 
     * @param pMessage
     * @param pCause
     */
    public TechnicalErrorException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }

}
