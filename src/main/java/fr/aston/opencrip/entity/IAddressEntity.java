package fr.aston.opencrip.entity;

public interface IAddressEntity extends IEntity {

    /**
     * Recupere la propriete <i>number</i>.
     *
     * @return the number la valeur de la propriete.
     */
    public abstract String getNumber();

    /**
     * Fixe la propriete <i>lastname</i>.
     *
     * @param pNumber
     *            la nouvelle valeur pour la propriete number.
     */
    public abstract void setNumber(String pNumber);

    /**
     * Recupere la propriete <i>address1</i>.
     *
     * @return the address1 la valeur de la propriete.
     */
    public abstract String getAddress1();

    /**
     * Fixe la propriete <i>address1</i>.
     *
     * @param pAddress1
     *            la nouvelle valeur pour la propriete address1.
     */
    public abstract void setAddress1(String pAddress1);

    /**
     * Recupere la propriete <i>address2</i>.
     *
     * @return the address2 la valeur de la propriete.
     */
    public abstract String getAddress2();

    /**
     * Fixe la propriete <i>address2</i>.
     *
     * @param pAddress2
     *            la nouvelle valeur pour la propriete address2.
     */
    public abstract void setAddress2(String pAddress2);

    /**
     * Recupere la propriete <i>zipCode</i>.
     *
     * @return the zipCode la valeur de la propriete.
     */
    public abstract String getZipCode();

    /**
     * Fixe la propriete <i>zipCode</i>.
     *
     * @param pZipCode
     *            la nouvelle valeur pour la propriete zipCode.
     */
    public abstract void setZipCode(String pZipCode);

    /**
     * Recupere la propriete <i>city</i>.
     *
     * @return the city la valeur de la propriete.
     */
    public abstract String getCity();

    /**
     * Fixe la propriete <i>city</i>.
     *
     * @param pCity
     *            la nouvelle valeur pour la propriete city.
     */
    public abstract void setCity(String pCity);

    /**
     * Recupere la propriete <i>country</i>.
     *
     * @return the country la valeur de la propriete.
     */
    public abstract String getCountry();

    /**
     * Fixe la propriete <i>country</i>.
     *
     * @param pCountry
     *            la nouvelle valeur pour la propriete country.
     */
    public abstract void setCountry(String pCountry);

    /**
     * Recupere la propriete <i>latitude</i>.
     *
     * @return the latitude la valeur de la propriete.
     */
    public abstract Double getLatitude();

    /**
     * Fixe la propriete <i>latitude</i>.
     *
     * @param pLatitude
     *            la nouvelle valeur pour la propriete latitude.
     */
    public abstract void setLatitude(Double pLatitude);

    /**
     * Recupere la propriete <i>longitude</i>.
     *
     * @return the longitude la valeur de la propriete.
     */
    public abstract Double getLongitude();

    /**
     * Fixe la propriete <i>longitude</i>.
     *
     * @param pLongitude
     *            la nouvelle valeur pour la propriete longitude.
     */
    public abstract void setLongitude(Double pLongitude);
}
