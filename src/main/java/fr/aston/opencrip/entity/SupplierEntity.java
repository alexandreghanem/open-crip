package fr.aston.opencrip.entity;

/**
 * Le bean qui represente un fournisseur. <br>
 */
public class SupplierEntity extends UserEntity implements ISupplierEntity {

    private static final long serialVersionUID = 1L;

    private String companyName;
    private String turnover;

    /**
     * Constructeur de l'objet. <br>
     */
    public SupplierEntity() {
        super();
    }

    @Override
    public String getCompanyName() {
        return this.companyName;
    }

    @Override
    public void setCompanyName(String pCompanyName) {
        this.companyName = pCompanyName;
    }

    @Override
    public String getTurnover() {
        return this.turnover;
    }

    @Override
    public void setTurnover(String pTurnover) {
        this.turnover = pTurnover;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String parent = super.toString();
        parent = parent.substring(0, parent.length() - 1);
        sb.append(parent);
        sb.append(",enseigne=");
        sb.append(this.getCompanyName());
        sb.append(",chiffreAffaire=");
        sb.append(this.getTurnover());
        sb.append("}");
        return sb.toString();
    }
}