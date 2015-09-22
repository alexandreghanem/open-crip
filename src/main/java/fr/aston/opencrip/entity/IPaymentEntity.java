package fr.aston.opencrip.entity;

import java.sql.Date;

public interface IPaymentEntity extends IEntity {
    /**
     * Recupere la propriete <i>paymentDate</i>.
     *
     * @return the paymentDate la valeur de la propriete.
     */
    public abstract Date getPaymentDate();

    /**
     * Fixe la propriete <i>paymentDate</i>.
     *
     * @param pPaymentDate
     *            la nouvelle valeur pour la propriete paymentDate.
     */
    public abstract void setPaymentDate(Date pPaymentDate);

    /**
     * Recupere la propriete <i>paymentMode</i>.
     *
     * @return the paymentMode la valeur de la propriete.
     */
    public abstract String getPaymentMode();

    /**
     * Fixe la propriete <i>paymentMode</i>.
     *
     * @param pPaymentMode
     *            la nouvelle valeur pour la propriete paymentMode.
     */
    public abstract void setPaymentMode(String pPaymentMode);
}
