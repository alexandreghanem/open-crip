package fr.aston.opencrip.dao;

import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.IUserEntity;

/**
 * Dao utilisateur. <br>
 */
public interface IUserDAO extends IDAO<IUserEntity> {

    /**
     * Selectionne le premier utilisateur ayec le login indique. <br>
     *
     * @param pLogin
     *            un login.
     * @return l'utilisateur
     * @throws ExceptionDao
     *             si une erreur survient
     */
    public abstract IUserEntity selectLogin(String pLogin) throws ExceptionDao;
}