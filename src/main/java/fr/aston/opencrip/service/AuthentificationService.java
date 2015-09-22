package fr.aston.opencrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.opencrip.dao.IUserDAO;
import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.service.ex.AuthentificationException;
import fr.aston.opencrip.service.ex.BadPasswordException;
import fr.aston.opencrip.service.ex.TechnicalErrorException;
import fr.aston.opencrip.service.ex.UserNotFoundException;

/**
 * Gestion de l'authentification.
 */
@Service
public class AuthentificationService extends AbstractService implements
    IAuthentificationService {
    @Autowired
    private IUserDAO userDAO;

    /**
     * Constructeur de l'objet.
     */
    public AuthentificationService() {
        super();
    }

    /**
     * Recupere la propriete <i>userDAO</i>.
     *
     * @return the userDAO la valeur de la propriete.
     */
    public IUserDAO getUserDAO() {
        return this.userDAO;
    }

    /**
     * Fixe la propriete <i>userDAO</i>.
     *
     * @param pUtilisateurDAO
     *            la nouvelle valeur pour la propriete userDAO.
     */
    public void setUserDAO(IUserDAO pUserDAO) {
        this.userDAO = pUserDAO;
    }

    @Override
    public IUserEntity authentifier(String pLogin, String pPassword)
        throws AuthentificationException, TechnicalErrorException {
        if ((pLogin == null) || (pLogin.trim().length() == 0)) {
            throw new NullPointerException("login");
        }
        if ((pPassword == null) || (pPassword.trim().length() == 0)) {
            throw new NullPointerException("password");
        }
        IUserEntity resultat = null;
        try {
            resultat = this.getUserDAO().selectLogin(pLogin);
        } catch (ExceptionDao e) {
            throw new TechnicalErrorException(e);
        }
        if (resultat == null) {
            throw new UserNotFoundException();
        }
        if (!pPassword.equals(resultat.getPassword())) {
            throw new BadPasswordException();
        }

        return resultat;
    }
}
