package fr.aston.opencrip.entity;

import java.sql.Date;

/**
 * Le bean qui represente un paiement. <br>
 */
public class PaymentEntity extends AbstractEntity implements IPaymentEntity {

    private static final long serialVersionUID = 1L;

    private Date paymentDate;
    private String paymentMode;

    /**
     * Constructeur de l'objet. <br>
     */
    public PaymentEntity() {
        super();
    }

    @Override
    public Date getPaymentDate() {
        return this.paymentDate;
    }

    @Override
    public void setPaymentDate(Date pPaymentDate) {
        this.paymentDate = pPaymentDate;
    }

    @Override
    public String getPaymentMode() {
        return this.paymentMode;
    }

    @Override
    public void setPaymentMode(String pPaymentMode) {
        this.paymentMode = pPaymentMode;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String parent = super.toString();
        parent = parent.substring(0, parent.length() - 1);
        sb.append(parent);
        sb.append(",date=");
        sb.append(this.getPaymentDate());
        sb.append(",mode=");
        sb.append(this.getPaymentMode());
        sb.append("}");
        return sb.toString();
    }
}