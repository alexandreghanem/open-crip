package fr.aston.opencrip.service;

import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.service.ex.AuthentificationException;
import fr.aston.opencrip.service.ex.TechnicalErrorException;
import fr.aston.opencrip.web.bean.AuthentificationBean;

/**
 * Gestion de l'authentification.
 */
public interface IAuthentificationService extends IService {

    /**
     * Authentifie un utilisateur.
     *
     * @param pLogin
     *            le login
     * @param pPassword
     *            le password
     * @return l'utilisateur authentifie, leve une exception sinon
     * @throws AuthentificationException
     *             si un probleme survient
     * @throws TechnicalErrorException
     *             si un probleme survient
     * @throws NullPointerException
     *             avec comme message le nom du parametre null
     */
    public abstract IUserEntity authentifier(
        AuthentificationBean authentificationBean)
            throws TechnicalErrorException, AuthentificationException;

}