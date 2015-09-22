package fr.aston.opencrip.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.IPaymentEntity;
import fr.aston.opencrip.entity.PaymentEntity;

/**
 * Le mapper qui represente un paiement. <br>
 */
public class PaymentJdbcMapper extends AbstractJdbcMapper<IPaymentEntity> {

    /**
     * Constructeur de l'objet. <br>
     */
    public PaymentJdbcMapper() {
        super();
    }

    @Override
    public IPaymentEntity mapRow(ResultSet rs, int id) throws SQLException {
        IPaymentEntity result = new PaymentEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setPaymentDate(rs.getDate("date_paiement"));
        result.setPaymentMode(rs.getString("mode_paiement"));
        return result;
    }
}
