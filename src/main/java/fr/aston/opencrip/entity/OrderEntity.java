package fr.aston.opencrip.entity;

import java.sql.Date;

/**
 * Le bean qui represente une commande. <br>
 */
public class OrderEntity extends AbstractEntity implements IOrderEntity {

    private static final long serialVersionUID = 1L;

    private Double price;
    private Date orderDate;
    private Date validationDate;
    private Integer paymentId;
    private Integer clientId;

    /**
     * Constructeur de l'objet. <br>
     */
    public OrderEntity() {
        super();
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Double pPrice) {
        this.price = pPrice;
    }

    @Override
    public Date getOrderDate() {
        return this.orderDate;
    }

    @Override
    public void setOrderDate(Date pOrderDate) {
        this.orderDate = pOrderDate;
    }

    @Override
    public Date getValidationDate() {
        return this.validationDate;
    }

    @Override
    public void setValidationDate(Date pValidationDate) {
        this.validationDate = pValidationDate;
    }

    @Override
    public Integer getClientId() {
        return this.clientId;
    }

    @Override
    public void setClientId(Integer pClientId) {
        this.clientId = pClientId;
    }

    @Override
    public Integer getPaymentId() {
        return this.paymentId;
    }

    @Override
    public void setPaymentId(Integer pPaymentId) {
        this.paymentId = pPaymentId;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String parent = super.toString();
        parent = parent.substring(0, parent.length() - 1);
        sb.append(parent);
        sb.append(",prix=");
        sb.append(this.getPrice());
        sb.append(",dateCommande=");
        sb.append(this.getOrderDate());
        sb.append(",dateValidation=");
        sb.append(this.getValidationDate());
        sb.append("}");
        return sb.toString();
    }
}