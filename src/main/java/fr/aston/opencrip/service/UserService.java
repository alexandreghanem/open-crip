package fr.aston.opencrip.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.aston.opencrip.dao.IUserDAO;
import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.service.ex.TechnicalErrorException;

/**
 * Gestion de l'utilisateur.
 */
@Service("userService")
public class UserService extends AbstractService implements IUserService {

    private IUserDAO userDAO;

    /**
     * Constructeur de l'objet.
     */
    public UserService() {
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
    @Autowired
    public void setUserDAO(@Qualifier("userDAO") IUserDAO pUserDao) {
        this.userDAO = pUserDao;
    }

    @Override
    public Set<IUserEntity> getUsers() throws TechnicalErrorException {
        Set<IUserEntity> users;
        try {
            users = this.getUserDAO().selectAll(null, "id ASC");
        } catch (ExceptionDao e) {
            throw new TechnicalErrorException(e);
        }
        return users;
    }
}
