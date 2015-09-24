package fr.aston.opencrip.entity;

import org.json.JSONObject;

public interface IEntity {

    /**
     * Recupere l'id du compte.
     *
     * @return l'id du compte.
     */
    public abstract Integer getId();

    /**
     * Fixe l'id du compte.
     *
     * @param pId
     *            l'id du compte.
     */
    public abstract void setId(Integer pId);

    public abstract JSONObject toJSONObject();
}