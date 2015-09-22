package fr.aston.opencrip.entity;

public interface ISupplierEntity extends IUserEntity {

    /**
     * Recupere la propriete <i>companyName</i>.
     *
     * @return the CompanyName la valeur de la propriete.
     */
    public abstract String getCompanyName();

    /**
     * Fixe la propriete <i>companyName</i>.
     *
     * @param pCompanyName
     *            la nouvelle valeur pour la propriete companyName.
     */
    public abstract void setCompanyName(String pCompanyName);

    /**
     * Recupere la propriete <i>turnover</i>.
     *
     * @return the turnover la valeur de la propriete.
     */
    public abstract String getTurnover();

    /**
     * Fixe la propriete <i>turnover</i>.
     *
     * @param pTurnover
     *            la nouvelle valeur pour la propriete turnover.
     */
    public abstract void setTurnover(String pTurnover);
}
