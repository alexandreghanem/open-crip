package fr.aston.opencrip.dao;

import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.IUserEntity;

/**
 * Dao utilisateur.
 */
public interface IUserDAO extends IDAO<IUserEntity> {

    /**
     * Selectionne le premier utilisateur ayant le login indique.
     *
     * @param pLogin
     *            un login.
     * @param connexion
     *            une connection (peut etre null)
     * @return l'utilisateur
     * @throws ExceptionDao
     *             si une erreur survient
     */
    public abstract IUserEntity selectLogin(String pLogin)
        throws ExceptionDao;

}