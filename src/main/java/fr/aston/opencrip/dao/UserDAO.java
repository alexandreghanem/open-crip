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
 * Gestion des operations.
 */
@Repository("utilisateurDAO")
public class UserDAO extends AbstractDAO<IUserEntity>implements
    IUserDAO {

    private static final long serialVersionUID = 1L;

    public UserDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "utilisateur";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String getAllColumnNames() {
        return "id,nom,prenom,login,password,sex,derniereConnection";
    }

    @Override
    protected AbstractJdbcMapper<IUserEntity> getMapper() {
        return new UserJdbcMapper();
    }

    @Override
    public IUserEntity insert(final IUserEntity pUneEntite)
        throws ExceptionDao {
        if (pUneEntite == null) {
            return null;
        }

        try {
            PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(
                    Connection connexion) throws SQLException {
                    PreparedStatement ps = connexion.prepareStatement(
                        "insert into " + UserDAO.this.getTableName()
                            + " (nom,prenom,login,password,sex,derniereConnection) values (?,?,?,?,?,?);",
                        Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, pUneEntite.getNom());
                    ps.setString(2, pUneEntite.getPrenom());
                    ps.setString(3, pUneEntite.getLogin());
                    ps.setString(4, pUneEntite.getPassword());
                    ps.setByte(5, pUneEntite.getSex().byteValue());
                    ps.setTimestamp(6, pUneEntite.getDerniereConnection());
                    return ps;
                }
            };
            KeyHolder kh = new GeneratedKeyHolder();
            this.getJdbcTemplate().update(psc, kh);
            pUneEntite.setId(Integer.valueOf(kh.getKey().intValue()));
        } catch (Throwable e) {
            throw new ExceptionDao(e);
        }

        return pUneEntite;
    }

    @Override
    public IUserEntity update(IUserEntity pUneEntite)
        throws ExceptionDao {
        if (pUneEntite == null) {
            return null;
        }
        if (pUneEntite.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName()
                + " set nom=?,prenom=?,login=?,password=?,sex=?,derniereConnection=? where "
                + this.getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, pUneEntite.getNom(), pUneEntite
                .getPrenom(), pUneEntite.getLogin(), pUneEntite.getPassword(),
                pUneEntite.getSex().byteValue(), pUneEntite
                    .getDerniereConnection(), pUneEntite.getId().intValue());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pUneEntite;
    }

    @Override
    public IUserEntity selectLogin(String pLogin) throws ExceptionDao {
        Set<IUserEntity> allLogin = this.selectAll("login='" + pLogin
            + "'", null);
        if ((allLogin == null) || allLogin.isEmpty()) {
            return null;
        }
        // On retourne le premier
        return allLogin.iterator().next();
    }

}