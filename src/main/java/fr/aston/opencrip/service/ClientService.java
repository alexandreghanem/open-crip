package fr.aston.opencrip.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.opencrip.dao.IClientDAO;
import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.IClientEntity;
import fr.aston.opencrip.service.ex.TechnicalErrorException;

/**
 * Gestion du client.
 */
@Service
public class ClientService extends AbstractService implements IClientService {
	@Autowired
	private IClientDAO clientDAO;

	/**
	 * Constructeur de l'objet.
	 */
	public ClientService() {
		super();
	}

	/**
	 * Recupere la propriete <i>clientDAO</i>.
	 *
	 * @return the clientDAO la valeur de la propriete.
	 */
	public IClientDAO getClientDAO() {
		return this.clientDAO;
	}

	/**
	 * Fixe la propriete <i>clientDAO</i>.
	 *
	 * @param pClientDAO
	 *            la nouvelle valeur pour la propriete clientDAO.
	 */
	public void setClientDAO(IClientDAO pClientDao) {
		this.clientDAO = pClientDao;
	}

	@Override
	public Set<IClientEntity> getClients() throws TechnicalErrorException {
		Set<IClientEntity> clients;
		try {
			clients = this.getClientDAO().selectAll(null, "id ASC");
		} catch (ExceptionDao e) {
			throw new TechnicalErrorException(e);
		}
		return clients;
	}

	@Override
	public Set<IClientEntity> register(String pNom, String pPrenom, String pLogin, String pPassword, String pEmail,
			String pTelephone) throws TechnicalErrorException {
		Set<IClientEntity> client = null;

		return client;
	}
}
