package fr.aston.opencrip.service;

import java.util.Set;

import fr.aston.opencrip.entity.IClientEntity;
import fr.aston.opencrip.service.ex.TechnicalErrorException;

/**
 * Gestion de l'utilisateur.
 */
public interface IClientService extends IService {

	/**
	 * Récupère tous les clients.
	 *
	 * @return liste de clients, leve une exception sinon
	 * @throws TechnicalErrorException
	 *             si un probleme survient
	 */
	public abstract Set<IClientEntity> getClients() throws TechnicalErrorException;

	/**
	 * Enregistre un client dans la base.
	 *
	 * @param pNom
	 * @param pPrenom
	 * @param pLogin
	 * @param pPassword
	 * @param pEmail
	 * @param pTelephone
	 * @return le client cree, leve une exception sinon
	 * @throws TechnicalErrorException
	 *             si un probleme survient
	 */
	public abstract Set<IClientEntity> register(String pNom, String pPrenom, String pLogin, String pPassword,
			String pEmail, String pTelephone) throws TechnicalErrorException;

}