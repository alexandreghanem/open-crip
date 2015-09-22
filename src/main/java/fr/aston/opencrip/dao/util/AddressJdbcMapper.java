package fr.aston.opencrip.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.AddressEntity;
import fr.aston.opencrip.entity.IAddressEntity;

/**
 * Le mapper qui represente une adresse. <br>
 */
public class AddressJdbcMapper extends AbstractJdbcMapper<IAddressEntity> {

    /**
     * Constructeur de l'objet. <br>
     */
    public AddressJdbcMapper() {
        super();
    }

    @Override
    public IAddressEntity mapRow(ResultSet rs, int id) throws SQLException {
        IAddressEntity result = new AddressEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setNumber(rs.getString("number"));
        result.setAddress1(rs.getString("adresse_1"));
        result.setAddress2(rs.getString("adresse_2"));
        result.setZipCode(rs.getString("code_postal"));
        result.setCity(rs.getString("ville"));
        result.setCountry(rs.getString("pays"));
        result.setLatitude(Double.valueOf(rs.getDouble("latitude")));
        result.setLongitude(Double.valueOf(rs.getDouble("longitude")));
        return result;
    }
}
