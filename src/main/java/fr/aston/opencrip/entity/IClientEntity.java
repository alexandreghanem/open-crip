package fr.aston.opencrip.entity;

public interface IClientEntity extends IUserEntity {

    /**
     * Recupere la propriete <i>lastname</i>.
     *
     * @return the nom la valeur de la propriete.
     */
    public abstract String getLastname();

    /**
     * Fixe la propriete <i>lastname</i>.
     *
     * @param pLastname
     *            la nouvelle valeur pour la propriete nom.
     */
    public abstract void setLastname(String pLastname);

    /**
     * Recupere la propriete <i>firstname</i>.
     *
     * @return the prenom la valeur de la propriete.
     */
    public abstract String getFirstname();

    /**
     * Fixe la propriete <i>firstname</i>.
     *
     * @param pFirstname
     *            la nouvelle valeur pour la propriete prenom.
     */
    public abstract void setFirstname(String pFirstname);
}
