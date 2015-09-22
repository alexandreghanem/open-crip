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
import fr.aston.opencrip.dao.util.OrderJdbcMapper;
import fr.aston.opencrip.entity.IOrderEntity;

/**
 * Gestion des commandes. <br>
 */
@Repository
public class OrderDAO extends AbstractDAO<IOrderEntity>implements IOrderDAO {

    private static final long serialVersionUID = 1L;

    public OrderDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Commande";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String getAllColumnNames() {
        return "id, prix_total, date_commande, date_validation, id_client, id_paiement";
    }

    @Override
    protected AbstractJdbcMapper<IOrderEntity> getMapper() {
        return new OrderJdbcMapper();
    }

    @Override
    public IOrderEntity insert(final IOrderEntity pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }

        try {
            PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(
                    Connection connexion) throws SQLException {
                    PreparedStatement ps = connexion.prepareStatement(
                        "insert into " + OrderDAO.this.getTableName()
                            + " (prix_total, date_commande, date_validation, id_client, id_paiement) "
                            + " values (?,?,?,?,?);",
                        Statement.RETURN_GENERATED_KEYS);
                    ps.setDouble(1, pEntity.getPrice().doubleValue());
                    ps.setDate(2, pEntity.getOrderDate());
                    ps.setDate(3, pEntity.getValidationDate());
                    ps.setInt(4, pEntity.getClientId().intValue());
                    ps.setInt(5, pEntity.getPaymentId().intValue());
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
    public IOrderEntity update(IOrderEntity pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName()
                + " set prix_total=?, date_commande=?, date_validation=?, id_client=?, id_paiement=? where "
                + this.getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, pEntity.getPrice().doubleValue(),
                pEntity.getOrderDate(), pEntity.getValidationDate(), pEntity
                    .getClientId().intValue(), pEntity.getPaymentId()
                        .intValue(), pEntity.getId().intValue());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }
}