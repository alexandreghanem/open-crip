package fr.aston.opencrip.entity;

/**
 * Le bean qui represente une adresse. <br>
 */
public class AddressEntity extends AbstractEntity implements IAddressEntity {

    private static final long serialVersionUID = 1L;

    private String number;
    private String address1;
    private String address2;
    private String zipCode;
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;

    /**
     * Constructeur de l'objet. <br>
     */
    public AddressEntity() {
        super();
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public void setNumber(String pNumber) {
        this.number = pNumber;
    }

    @Override
    public String getAddress1() {
        return this.address1;
    }

    @Override
    public void setAddress1(String pAddress1) {
        this.address1 = pAddress1;
    }

    @Override
    public String getAddress2() {
        return this.address2;
    }

    @Override
    public void setAddress2(String pAddress2) {
        this.address2 = pAddress2;
    }

    @Override
    public String getZipCode() {
        return this.zipCode;
    }

    @Override
    public void setZipCode(String pZipCode) {
        this.zipCode = pZipCode;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public void setCity(String pCity) {
        this.city = pCity;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public void setCountry(String pCountry) {
        this.country = pCountry;
    }

    @Override
    public Double getLatitude() {
        return this.latitude;
    }

    @Override
    public void setLatitude(Double pLatitude) {
        this.latitude = pLatitude;
    }

    @Override
    public Double getLongitude() {
        return this.longitude;
    }

    @Override
    public void setLongitude(Double pLongitude) {
        this.longitude = pLongitude;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String parent = super.toString();
        parent = parent.substring(0, parent.length() - 1);
        sb.append(parent);
        sb.append(",numero=");
        sb.append(this.getNumber());
        sb.append(",adresse1=");
        sb.append(this.getAddress1());
        sb.append(",adresse2=");
        sb.append(this.getAddress2());
        sb.append(",codePostal=");
        sb.append(this.getZipCode());
        sb.append(",ville=");
        sb.append(this.getCity());
        sb.append(",pays=");
        sb.append(this.getCountry());
        sb.append(",latitude=");
        sb.append(this.getLatitude());
        sb.append(",longitude=");
        sb.append(this.getLongitude());
        sb.append("}");
        return sb.toString();
    }
}