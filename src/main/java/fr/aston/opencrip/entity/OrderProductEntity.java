package fr.aston.opencrip.entity;

/**
 * Le bean qui represente une CommandeProduit. <br>
 */
public class OrderProductEntity extends AbstractEntity implements
    IOrderProductEntity {

    private static final long serialVersionUID = 1L;

    private Double price;
    private Integer quantity;
    private Integer orderId;
    private Integer productId;

    /**
     * Constructeur de l'objet. <br>
     */
    public OrderProductEntity() {
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
    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(Integer pQuantity) {
        this.quantity = pQuantity;
    }

    @Override
    public Integer getOrderId() {
        return this.orderId;
    }

    @Override
    public void setOrderId(Integer pOrderId) {
        this.orderId = pOrderId;
    }

    @Override
    public Integer getProductId() {
        return this.productId;
    }

    @Override
    public void setProductId(Integer pProductId) {
        this.productId = pProductId;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String parent = super.toString();
        parent = parent.substring(0, parent.length() - 1);
        sb.append(parent);
        sb.append(",prix=");
        sb.append(this.getPrice());
        sb.append(",quantite=");
        sb.append(this.getQuantity());
        sb.append("}");
        return sb.toString();
    }
}