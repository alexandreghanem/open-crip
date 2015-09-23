package fr.aston.opencrip.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.dao.util.AbstractJdbcMapper;
import fr.aston.opencrip.dao.util.UserJdbcMapper;
import fr.aston.opencrip.entity.IUserEntity;

/**
 * Gestion des clients. <br>
 */
@Repository
public class UserDAO extends AbstractDAO<IUserEntity>implements IUserDAO {

    private static final long serialVersionUID = 1L;

    public UserDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Utilisateur";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String[] getAllColumnNames() {
        return new String[] { "identifiant", "mot_de_passe", "email",
            "telephone", "date_derniere_connexion", "date_inscription",
            "id_adresse", "id_client", "id_fournisseur" };
    }

    @Override
    public String[] getInsertParams() {
        return new String[] { "?", "?", "?", "?", "?", "?", "?", "?", "?" };
    }

    @Override
    public List<Object> getUpdateParams(IUserEntity pEntity) {
        List<Object> list = new ArrayList<Object>(10);
        list.add(pEntity.getLogin());
        list.add(pEntity.getPassword());
        list.add(pEntity.getEmail());
        list.add(pEntity.getTelephone());
        list.add(pEntity.getLastConnection());
        list.add(pEntity.getRegistrationDate());
        list.add(pEntity.getAddressId().intValue());
        list.add(pEntity.getClientId().intValue());
        list.add(pEntity.getSupplierId().intValue());
        list.add(pEntity.getId().intValue());
        return list;
    }

    @Override
    public int[] getUpdateTypes() {
        return new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
            Types.VARCHAR, Types.TIMESTAMP, Types.DATE, Types.SMALLINT,
            Types.SMALLINT, Types.SMALLINT, Types.SMALLINT };
    }

    @Override
    protected AbstractJdbcMapper<IUserEntity> getMapper() {
        return new UserJdbcMapper();
    }

    @Override
    public IUserEntity selectLogin(String pLogin) throws ExceptionDao {
        Set<IUserEntity> allLogin = this.selectAll("identifiant='" + pLogin
            + "'", null);
        if ((allLogin == null) || allLogin.isEmpty()) {
            return null;
        }
        // On retourne le premier
        return allLogin.iterator().next();
    }
}