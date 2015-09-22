package fr.aston.opencrip.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Le bean qui represente un utilisateur. <br>
 */
public class UserEntity extends AbstractEntity implements IUserEntity {

    private static final long serialVersionUID = 1L;

    private String login;
    private String password;
    private String email;
    private String telephone;
    private Timestamp lastConnection;
    private Date registrationDate;
    private Integer addressId;
    private Integer clientId;
    private Integer supplierId;

    /**
     * Constructeur de l'objet. <br>
     */
    public UserEntity() {
        super();
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public void setLogin(String pLogin) {
        this.login = pLogin;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String pPassword) {
        this.password = pPassword;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String pEmail) {
        this.email = pEmail;
    }

    @Override
    public String getTelephone() {
        return this.telephone;
    }

    @Override
    public void setTelephone(String pTelephone) {
        this.telephone = pTelephone;
    }

    @Override
    public Timestamp getLastConnection() {
        return this.lastConnection;
    }

    @Override
    public void setLastConnection(Timestamp pLastConnection) {
        this.lastConnection = pLastConnection;
    }

    @Override
    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    @Override
    public void setRegistrationDate(Date pRegistrationDate) {
        this.registrationDate = pRegistrationDate;
    }

    @Override
    public Integer getAddressId() {
        return this.addressId;
    }

    @Override
    public void setAddressId(Integer pAddressId) {
        this.addressId = pAddressId;
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
        sb.append(",login=");
        sb.append(this.getLogin());
        sb.append("}");
        return sb.toString();
    }
}