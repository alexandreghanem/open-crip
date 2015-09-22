package fr.aston.opencrip.entity;

import java.io.Serializable;

/**
 * Le bean qui represente une entit้. <br>
 */
public abstract class AbstractEntity implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;

    protected Integer id;

    /**
     * Constructeur de l'objet. <br>
     */
    public AbstractEntity() {
        super();
    }

    /**
     * Constructeur de l'objet. <br>
     *
     * @param pId
     *            l'id d'un compte
     */
    public AbstractEntity(Integer pId) {
        super();
        this.setId(pId);
    }

    @Override
    public final Integer getId() {
        return this.id;
    }

    @Override
    public final void setId(Integer pId) {
        this.id = pId;
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return (this.getClass().getName() + "-" + this.getId()).hashCode();
        }
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractEntity) {
            return (((IEntity) obj).getId() == this.getId()) || ((IEntity) obj)
                .getId().equals(this.getId());
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{class=");
        sb.append(this.getClass().getName());
        sb.append(",id=");
        sb.append(this.getId());
        sb.append('}');
        return sb.toString();
    }
}