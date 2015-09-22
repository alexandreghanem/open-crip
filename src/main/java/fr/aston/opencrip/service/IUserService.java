package fr.aston.opencrip.service;

import java.util.Set;

import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.service.ex.TechnicalErrorException;

/**
 * Gestion de l'utilisateur.
 */
public interface IUserService extends IService {

    /**
     * Récupère tous les utilisateur.
     *
     * @return liste d'utilisateurs, leve une exception sinon
     * @throws TechnicalErrorException
     *             si un probleme survient
     */
    public abstract Set<IUserEntity> getUsers() throws TechnicalErrorException;

}