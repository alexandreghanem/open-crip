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
import fr.aston.opencrip.dao.util.ProductJdbcMapper;
import fr.aston.opencrip.entity.IProductEntity;

/**
 * Gestion des produits. <br>
 */
@Repository
public class ProductDAO extends AbstractDAO<IProductEntity>implements
    IProductDAO {

    private static final long serialVersionUID = 1L;

    public ProductDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Produit";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String getAllColumnNames() {
        return "id, reference_produit, prix_unitaire, id_fournisseur";
    }

    @Override
    protected AbstractJdbcMapper<IProductEntity> getMapper() {
        return new ProductJdbcMapper();
    }

    @Override
    public IProductEntity insert(final IProductEntity pEntity)
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
                        "insert into " + ProductDAO.this.getTableName()
                            + " (reference_produit, prix_unitaire, id_fournisseur) "
                            + " values (?,?,?);",
                        Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, pEntity.getReference());
                    ps.setDouble(2, pEntity.getPrice().doubleValue());
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
    public IProductEntity update(IProductEntity pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName()
                + " set reference_produit=?,prix_unitaire=?,id_fournisseur=? where "
                + this.getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, pEntity.getReference(), pEntity
                .getPrice().doubleValue(), pEntity.getSupplierId().intValue(),
                pEntity.getId().intValue());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }
}