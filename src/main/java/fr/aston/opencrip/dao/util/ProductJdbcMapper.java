package fr.aston.opencrip.dao.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.IProductEntity;
import fr.aston.opencrip.entity.ProductEntity;

/**
 * Le mapper qui represente un produit. <br>
 */
public class ProductJdbcMapper extends AbstractJdbcMapper<IProductEntity> {

    /**
     * Constructeur de l'objet. <br>
     */
    public ProductJdbcMapper() {
        super();
    }

    @Override
    public IProductEntity mapRow(ResultSet rs, int id) throws SQLException {
        IProductEntity result = new ProductEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setReference(rs.getString("reference_produit"));
        result.setPrice(Double.valueOf(rs.getDouble("prix_unitaire")));
        result.setSupplierId(Integer.valueOf(rs.getInt("id_fournisseur")));
        return result;
    }

    @Override
    public void revertMapRow(PreparedStatement ps, IProductEntity pEntity)
        throws SQLException {
        ps.setString(1, pEntity.getReference());
        ps.setDouble(2, pEntity.getPrice().doubleValue());
        ps.setInt(9, pEntity.getSupplierId().intValue());
    }
}
