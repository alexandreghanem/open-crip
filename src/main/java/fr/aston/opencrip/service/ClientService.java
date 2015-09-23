package fr.aston.opencrip.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.opencrip.dao.IClientDAO;
import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.ClientEntity;
import fr.aston.opencrip.entity.IClientEntity;
import fr.aston.opencrip.service.ex.TechnicalErrorException;
import fr.aston.opencrip.web.bean.RegisterBean;

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
	public IClientEntity register(RegisterBean registerBean) throws TechnicalErrorException {

		IClientEntity client = new ClientEntity();

		try {
			client.setLastname(registerBean.getLastname());
			client.setFirstname(registerBean.getFirstname());
			// client.setLogin(pLogin);
			// client.setPassword(pPassword);
			// client.setEmail(pEmail);
			// client.setTelephone(pTelephone);

			this.getClientDAO().insert(client);
		} catch (ExceptionDao e) {
			throw new TechnicalErrorException(e);
		}
		return client;
	}
}
