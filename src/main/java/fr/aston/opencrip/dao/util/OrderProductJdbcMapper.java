package fr.aston.opencrip.dao.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.IOrderProductEntity;
import fr.aston.opencrip.entity.OrderProductEntity;

/**
 * Le mapper qui represente une commandeProduit. <br>
 */
public class OrderProductJdbcMapper extends
    AbstractJdbcMapper<IOrderProductEntity> {

    /**
     * Constructeur de l'objet. <br>
     */
    public OrderProductJdbcMapper() {
        super();
    }

    @Override
    public IOrderProductEntity mapRow(ResultSet rs, int id)
        throws SQLException {
        IOrderProductEntity result = new OrderProductEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setPrice(Double.valueOf(rs.getDouble("prix_unitaire")));
        result.setQuantity(Integer.valueOf(rs.getInt("quantite")));
        result.setOrderId(Integer.valueOf(rs.getInt("id_client")));
        result.setProductId(Integer.valueOf(rs.getInt("id_fournisseur")));
        return result;
    }

    @Override
    public void revertMapRow(PreparedStatement ps, IOrderProductEntity pEntity)
        throws SQLException {
        ps.setDouble(1, pEntity.getPrice().doubleValue());
        ps.setInt(2, pEntity.getQuantity().intValue());
        ps.setInt(3, pEntity.getOrderId().intValue());
        ps.setInt(4, pEntity.getProductId().intValue());
    }
}
