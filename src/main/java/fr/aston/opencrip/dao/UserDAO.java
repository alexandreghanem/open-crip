package fr.aston.opencrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    public String getAllColumnNames() {
        return "id, identifiant, mot_de_passe, date_derniere_connexion, email, telephone,"
            + " date_inscription, id_adresse, id_client, id_fournisseur";
    }

    @Override
    protected AbstractJdbcMapper<IUserEntity> getMapper() {
        return new UserJdbcMapper();
    }

    @Override
    public IUserEntity insert(final IUserEntity pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }

        try {
            PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(
                    Connection connexion) throws SQLException {
                    PreparedStatement ps = connexion.prepareStatement(
                        "insert into " + UserDAO.this.getTableName()
                            + " (identifiant, mot_de_passe, date_derniere_connexion, email, telephone,"
                            + " date_inscription, id_adresse, id_client, id_fournisseur) "
                            + " values (?,?,?,?,?,?,?,?,?);",
                        Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, pEntity.getLogin());
                    ps.setString(2, pEntity.getPassword());
                    ps.setTimestamp(3, pEntity.getLastConnection());
                    ps.setString(4, pEntity.getEmail());
                    ps.setString(5, pEntity.getTelephone());
                    ps.setDate(6, pEntity.getRegistrationDate());
                    ps.setInt(7, pEntity.getAddressId().intValue());
                    ps.setInt(8, pEntity.getClientId().intValue());
                    ps.setInt(9, pEntity.getSupplierId().intValue());
                    return ps;
                }
            };
            KeyHolder kh = new GeneratedKeyHolder();
            this.getJdbcTemplate().update(psc, kh);
            pEntity.setId(Integer.valueOf(kh.getKey().intValue()));
        } catch (Throwable e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }

    @Override
    public IUserEntity update(IUserEntity pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName()
                + " set identifiant=?,mot_de_passe=?,date_derniere_connection=?,email=?,telephone=?,"
                + "date_inscription=?, id_adresse=?, id_client=?, id_fournisseur=? where "
                + this.getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, pEntity.getLogin(), pEntity
                .getPassword(), pEntity.getLastConnection(), pEntity.getEmail(),
                pEntity.getTelephone(), pEntity.getRegistrationDate(), pEntity
                    .getAddressId().intValue(), pEntity.getClientId()
                        .intValue(), pEntity.getSupplierId().intValue(), pEntity
                            .getId().intValue());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
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