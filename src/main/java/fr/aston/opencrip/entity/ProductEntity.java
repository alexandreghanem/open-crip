package fr.aston.opencrip.entity;

/**
 * Le bean qui represente un fournisseur. <br>
 */
public class ProductEntity extends AbstractEntity implements IProductEntity {

    private static final long serialVersionUID = 1L;

    private String reference;
    private Double price;
    private Integer supplierId;

    /**
     * Constructeur de l'objet. <br>
     */
    public ProductEntity() {
        super();
    }

    @Override
    public String getReference() {
        return this.reference;
    }

    @Override
    public void setReference(String pReference) {
        this.reference = pReference;
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
    public Integer getSupplierId() {
        return this.supplierId;
    }

    @Override
    public void setSupplierId(Integer pSupplierId) {
        this.supplierId = pSupplierId;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String parent = super.toString();
        parent = parent.substring(0, parent.length() - 1);
        sb.append(parent);
        sb.append(",reference=");
        sb.append(this.getReference());
        sb.append(",prix=");
        sb.append(this.getPrice());
        sb.append("}");
        return sb.toString();
    }
}