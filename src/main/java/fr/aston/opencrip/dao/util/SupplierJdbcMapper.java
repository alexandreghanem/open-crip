package fr.aston.opencrip.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.ISupplierEntity;
import fr.aston.opencrip.entity.SupplierEntity;

/**
 * Le mapper qui represente un fournisseur. <br>
 */
public class SupplierJdbcMapper extends AbstractJdbcMapper<ISupplierEntity> {

    /**
     * Constructeur de l'objet. <br>
     */
    public SupplierJdbcMapper() {
        super();
    }

    @Override
    public ISupplierEntity mapRow(ResultSet rs, int id) throws SQLException {
        ISupplierEntity result = new SupplierEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setCompanyName(rs.getString("nom_enseigne"));
        result.setTurnover(rs.getString("chiffre_affaire"));
        return result;
    }
}
