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
import fr.aston.opencrip.dao.util.SupplierJdbcMapper;
import fr.aston.opencrip.entity.ISupplierEntity;

/**
 * Gestion des fournisseurs. <br>
 */
@Repository
public class SupplierDAO extends AbstractDAO<ISupplierEntity>implements
    ISupplierDAO {

    private static final long serialVersionUID = 1L;

    public SupplierDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Fournisseur";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String getAllColumnNames() {
        return "id, nom_enseigne, chiffre_affaire";
    }

    @Override
    protected AbstractJdbcMapper<ISupplierEntity> getMapper() {
        return new SupplierJdbcMapper();
    }

    @Override
    public ISupplierEntity insert(final ISupplierEntity pEntity)
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
                        "insert into " + SupplierDAO.this.getTableName()
                            + " (nom_enseigne, chiffre_affaire) "
                            + " values (?,?);",
                        Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, pEntity.getCompanyName());
                    ps.setString(2, pEntity.getTurnover());
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
    public ISupplierEntity update(ISupplierEntity pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName()
                + " set nom_enseigne=?,chiffre_affaire=? where " + this
                    .getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, pEntity.getCompanyName(), pEntity
                .getTurnover(), pEntity.getId().intValue());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }
}