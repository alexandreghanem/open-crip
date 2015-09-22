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
import fr.aston.opencrip.dao.util.PaymentJdbcMapper;
import fr.aston.opencrip.entity.IPaymentEntity;

/**
 * Gestion des paiments. <br>
 */
@Repository
public class PaymentDAO extends AbstractDAO<IPaymentEntity>implements
    IPaymentDAO {

    private static final long serialVersionUID = 1L;

    public PaymentDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Paiement";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String getAllColumnNames() {
        return "id, date_paiement, mode_paiement";
    }

    @Override
    protected AbstractJdbcMapper<IPaymentEntity> getMapper() {
        return new PaymentJdbcMapper();
    }

    @Override
    public IPaymentEntity insert(final IPaymentEntity pEntity)
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
                        "insert into " + PaymentDAO.this.getTableName()
                            + " (date_paiement, mode_paiement) "
                            + " values (?,?);",
                        Statement.RETURN_GENERATED_KEYS);
                    ps.setDate(1, pEntity.getPaymentDate());
                    ps.setString(2, pEntity.getPaymentMode());
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
    public IPaymentEntity update(IPaymentEntity pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName()
                + " set date_paiement=?,mode_paiement=? where " + this
                    .getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, pEntity.getPaymentDate(), pEntity
                .getPaymentMode(), pEntity.getId().intValue());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }
}