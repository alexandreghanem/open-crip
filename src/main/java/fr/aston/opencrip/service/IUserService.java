package fr.aston.opencrip.service;

import java.util.Set;

import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.service.ex.AuthentificationException;
import fr.aston.opencrip.service.ex.TechnicalErrorException;

/**
 * Gestion de l'authentification.
 */
public interface IUserService extends IService {

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
    public abstract Set<IUserEntity> getUsers() throws TechnicalErrorException;

}