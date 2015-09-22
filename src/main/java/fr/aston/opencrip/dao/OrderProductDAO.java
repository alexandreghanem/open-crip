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
import fr.aston.opencrip.dao.util.OrderProductJdbcMapper;
import fr.aston.opencrip.entity.IOrderProductEntity;

/**
 * Gestion des commandes produits. <br>
 */
@Repository
public class OrderProductDAO extends AbstractDAO<IOrderProductEntity>implements
    IOrderProductDAO {

    private static final long serialVersionUID = 1L;

    public OrderProductDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "CommandeProduit";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String getAllColumnNames() {
        return "id, prix_unitaire, quantite, id_commande, id_produit";
    }

    @Override
    protected AbstractJdbcMapper<IOrderProductEntity> getMapper() {
        return new OrderProductJdbcMapper();
    }

    @Override
    public IOrderProductEntity insert(final IOrderProductEntity pEntity)
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
                        "insert into " + OrderProductDAO.this.getTableName()
                            + " (prix_unitaire, quantite, id_commande, id_produit) "
                            + " values (?,?,?,?);",
                        Statement.RETURN_GENERATED_KEYS);
                    ps.setDouble(1, pEntity.getPrice().doubleValue());
                    ps.setInt(2, pEntity.getQuantity().intValue());
                    ps.setInt(3, pEntity.getOrderId().intValue());
                    ps.setInt(4, pEntity.getProductId().intValue());
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
    public IOrderProductEntity update(IOrderProductEntity pEntity)
        throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName()
                + " set prix_unitaire=?, quantite=?, id_commande=?, id_produit=? where "
                + this.getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, pEntity.getPrice().doubleValue(),
                pEntity.getQuantity().intValue(), pEntity.getOrderId()
                    .intValue(), pEntity.getProductId().intValue(), pEntity
                        .getId().intValue());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }
}