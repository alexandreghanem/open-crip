package fr.aston.opencrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.aston.opencrip.dao.IUserDAO;
import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.service.ex.AuthentificationException;
import fr.aston.opencrip.service.ex.TechnicalErrorException;
import fr.aston.opencrip.service.ex.BadPasswordException;
import fr.aston.opencrip.service.ex.UserNotFoundException;

/**
 * Gestion de l'authentification.
 */
@Service("authentificationService")
public class AuthentificationService extends AbstractService implements
    IAuthentificationService {

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
    public IUserDAO getUtilisateurDAO() {
        return this.userDAO;
    }

    /**
     * Fixe la propriete <i>userDAO</i>.
     *
     * @param pUtilisateurDAO
     *            la nouvelle valeur pour la propriete userDAO.
     */
    @Autowired
    public void setUtilisateurDAO(
        @Qualifier("userDAO") IUserDAO pUtilisateurDAO) {
        this.userDAO = pUtilisateurDAO;
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
            resultat = this.getUtilisateurDAO().selectLogin(pLogin);
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
