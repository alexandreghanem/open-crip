package fr.aston.opencrip.entity;

import java.sql.Date;
import java.sql.Timestamp;

public interface IUserEntity extends IEntity {

    /**
     * Recupere la propriete <i>login</i>.
     *
     * @return the login la valeur de la propriete.
     */
    public abstract String getLogin();

    /**
     * Fixe la propriete <i>login</i>.
     *
     * @param pLogin
     *            la nouvelle valeur pour la propriete login.
     */
    public abstract void setLogin(String pLogin);

    /**
     * Recupere la propriete <i>password</i>.
     *
     * @return the password la valeur de la propriete.
     */
    public abstract String getPassword();

    /**
     * Fixe la propriete <i>password</i>.
     *
     * @param pPassword
     *            la nouvelle valeur pour la propriete password.
     */
    public abstract void setPassword(String pPassword);

    /**
     * Recupere la propriete <i>email</i>.
     *
     * @return the email la valeur de la propriete.
     */
    public abstract String getEmail();

    /**
     * Fixe la propriete <i>email</i>.
     *
     * @param pEmail
     *            la nouvelle valeur pour la propriete email.
     */
    public abstract void setEmail(String pEmail);

    /**
     * Recupere la propriete <i>telephone</i>.
     *
     * @return the telephone la valeur de la propriete.
     */
    public abstract String getTelephone();

    /**
     * Fixe la propriete <i>telephone</i>.
     *
     * @param pTelephone
     *            la nouvelle valeur pour la propriete telephone.
     */
    public abstract void setTelephone(String pTelephone);

    /**
     * Recupere la propriete <i>lastConnection</i>.
     *
     * @return the derniereConnection la valeur de la propriete.
     */
    public abstract Timestamp getLastConnection();

    /**
     * Fixe la propriete <i>lastConnection</i>.
     *
     * @param pLastConnection
     *            la nouvelle valeur pour la propriete derniereConnection.
     */
    public abstract void setLastConnection(Timestamp pLastConnection);

    /**
     * Recupere la propriete <i>registrationDate</i>.
     *
     * @return the nom la valeur de la propriete.
     */
    public abstract Date getRegistrationDate();

    /**
     * Fixe la propriete <i>registrationDate</i>.
     *
     * @param pRegistrationDate
     *            la nouvelle valeur pour la propriete registrationDate.
     */
    public abstract void setRegistrationDate(Date pRegistrationDate);

    /**
     * Recupere la propriete <i>addressId</i>.
     *
     * @return the addressId la valeur de la propriete.
     */
    public abstract Integer getAddressId();

    /**
     * Fixe la propriete <i>addressId</i>.
     *
     * @param pAddressId
     *            la nouvelle valeur pour la propriete addressId.
     */
    public abstract void setAddressId(Integer pAddressId);

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
     * Recupere la propriete <i>supplierId</i>.
     *
     * @return the supplierId la valeur de la propriete.
     */
    public abstract Integer getSupplierId();

    /**
     * Fixe la propriete <i>supplierId</i>.
     *
     * @param pSupplierId
     *            la nouvelle valeur pour la propriete supplierId.
     */
    public abstract void setSupplierId(Integer pSupplierId);
}