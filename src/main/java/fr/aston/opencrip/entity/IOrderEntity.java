package fr.aston.opencrip.entity;

import java.sql.Date;

public interface IOrderEntity extends IEntity {

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
     * Recupere la propriete <i>orderDate</i>.
     *
     * @return the orderDate la valeur de la propriete.
     */
    public abstract Date getOrderDate();

    /**
     * Fixe la propriete <i>orderDate</i>.
     *
     * @param pOrderDate
     *            la nouvelle valeur pour la propriete orderDate.
     */
    public abstract void setOrderDate(Date pOrderDate);

    /**
     * Recupere la propriete <i>validationDate</i>.
     *
     * @return the validationDate la valeur de la propriete.
     */
    public abstract Date getValidationDate();

    /**
     * Fixe la propriete <i>validationDate</i>.
     *
     * @param pValidationDate
     *            la nouvelle valeur pour la propriete validationDate.
     */
    public abstract void setValidationDate(Date pValidationDate);

    /**
     * Recupere la propriete <i>clientId</i>.
     *
     * @return the clientId la valeur de la propriete.
     */
    public abstract Integer getClientId();

    /**
     * Fixe la propriete <i>clientId</i>.
     *
     * @param pClientId
     *            la nouvelle valeur pour la propriete clientId.
     */
    public abstract void setClientId(Integer pClientId);

    /**
     * Recupere la propriete <i>paymentId</i>.
     *
     * @return the paymentId la valeur de la propriete.
     */
    public abstract Integer getPaymentId();

    /**
     * Fixe la propriete <i>paymentId</i>.
     *
     * @param pPaymentId
     *            la nouvelle valeur pour la propriete paymentId.
     */
    public abstract void setPaymentId(Integer pPaymentId);
}
