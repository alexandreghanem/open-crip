package fr.aston.opencrip.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.IOrderEntity;
import fr.aston.opencrip.entity.OrderEntity;

/**
 * Le mapper qui represente une commande. <br>
 */
public class OrderJdbcMapper extends AbstractJdbcMapper<IOrderEntity> {

    /**
     * Constructeur de l'objet. <br>
     */
    public OrderJdbcMapper() {
        super();
    }

    @Override
    public IOrderEntity mapRow(ResultSet rs, int id) throws SQLException {
        IOrderEntity result = new OrderEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setPrice(Double.valueOf(rs.getDouble("prix_total")));
        result.setOrderDate(rs.getDate("date_commande"));
        result.setValidationDate(rs.getDate("date_validation"));
        result.setClientId(Integer.valueOf(rs.getInt("id_client")));
        result.setPaymentId(Integer.valueOf(rs.getInt("id_paiement")));
        return result;
    }
}
