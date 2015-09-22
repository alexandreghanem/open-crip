package fr.aston.opencrip.entity;

public interface IProductEntity extends IEntity {

    /**
     * Recupere la propriete <i>reference</i>.
     *
     * @return the reference la valeur de la propriete.
     */
    public abstract String getReference();

    /**
     * Fixe la propriete <i>reference</i>.
     *
     * @param pReference
     *            la nouvelle valeur pour la propriete reference.
     */
    public abstract void setReference(String pReference);

    /**
     * Recupere la propriete <i>price</i>.
     *
     * @return the price la valeur de la propriete.
     */
    public abstract Double getPrice();

    /**
     * Fixe la propriete <i>price</i>.
     *
     * @param pPrice
     *            la nouvelle valeur pour la propriete price.
     */
    public abstract void setPrice(Double pPrice);

    /**
     * Recupere la propriete <i>supplierId</i>.
     *
     * @return the supplierId la valeur de la propriete.
     */
    public abstract Integer getSupplierId();

    /**
     * Fixe la propriete <i>supplierId</i>.
     *
     * @param pSupplierId
     *            la nouvelle valeur pour la propriete supplierId.
     */
    public abstract void setSupplierId(Integer pSupplierId);
}
