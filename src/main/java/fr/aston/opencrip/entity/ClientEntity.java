package fr.aston.opencrip.entity;

/**
 * Le bean qui represente un client. <br>
 */
public class ClientEntity extends UserEntity implements IClientEntity {

    private static final long serialVersionUID = 1L;

    private String lastname;
    private String firstname;

    /**
     * Constructeur de l'objet. <br>
     */
    public ClientEntity() {
        super();
    }

    @Override
    public String getLastname() {
        return this.lastname;
    }

    @Override
    public void setLastname(String pLastname) {
        this.lastname = pLastname;
    }

    @Override
    public String getFirstname() {
        return this.firstname;
    }

    @Override
    public void setFirstname(String pFirstname) {
        this.firstname = pFirstname;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String parent = super.toString();
        parent = parent.substring(0, parent.length() - 1);
        sb.append(parent);
        sb.append(",nom=");
        sb.append(this.getLastname());
        sb.append(",prenom=");
        sb.append(this.getFirstname());
        sb.append("}");
        return sb.toString();
    }
}