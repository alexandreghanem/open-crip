package fr.aston.opencrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.dao.util.AbstractJdbcMapper;
import fr.aston.opencrip.dao.util.ClientJdbcMapper;
import fr.aston.opencrip.entity.IClientEntity;

/**
 * Gestion des clients. <br>
 */
@Repository
public class ClientDAO extends AbstractDAO<IClientEntity>implements IClientDAO {

    private static final long serialVersionUID = 1L;

    public ClientDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Client";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String getAllColumnNames() {
        return "id, nom, prenom";
    }

    @Override
    protected AbstractJdbcMapper<IClientEntity> getMapper() {
        return new ClientJdbcMapper();
    }

    @Override
    public IClientEntity insert(final IClientEntity pEntity)
        throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }

        try {
            PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(
                    Connection connexion) throws SQLException {
                    PreparedStatement ps = connexion.prepareStatement(
                        "insert into " + ClientDAO.this.getTableName()
                            + " (nom, prenom) " + " values (?,?);",
                        Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, pEntity.getLastname());
                    ps.setString(2, pEntity.getFirstname());
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
    public IClientEntity update(IClientEntity pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName()
                + " set nom=?,prenom=? where " + this.getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, pEntity.getLastname(), pEntity
                .getFirstname(), pEntity.getId().intValue());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }
}