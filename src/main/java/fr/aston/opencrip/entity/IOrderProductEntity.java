package fr.aston.opencrip.entity;

public interface IOrderProductEntity extends IEntity {

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
     * Recupere la propriete <i>quantity</i>.
     *
     * @return the quantity la valeur de la propriete.
     */
    public abstract Integer getQuantity();

    /**
     * Fixe la propriete <i>quantity</i>.
     *
     * @param pQuantity
     *            la nouvelle valeur pour la propriete quantity.
     */
    public abstract void setQuantity(Integer pQuantity);

    /**
     * Recupere la propriete <i>orderId</i>.
     *
     * @return the orderId la valeur de la propriete.
     */
    public abstract Integer getOrderId();

    /**
     * Fixe la propriete <i>orderId</i>.
     *
     * @param pOrderId
     *            la nouvelle valeur pour la propriete orderId.
     */
    public abstract void setOrderId(Integer pOrderId);

    /**
     * Recupere la propriete <i>productId</i>.
     *
     * @return the productId la valeur de la propriete.
     */
    public abstract Integer getProductId();

    /**
     * Fixe la propriete <i>productId</i>.
     *
     * @param pProductId
     *            la nouvelle valeur pour la propriete productId.
     */
    public abstract void setProductId(Integer pProductId);
}
