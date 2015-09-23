package fr.aston.opencrip.dao.util;

import java.sql.PreparedStatement;
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

    @Override
    public void revertMapRow(PreparedStatement ps, IAddressEntity pEntity)
        throws SQLException {
        ps.setString(1, pEntity.getNumber());
        ps.setString(2, pEntity.getAddress1());
        ps.setString(3, pEntity.getAddress2());
        ps.setString(4, pEntity.getZipCode());
        ps.setString(5, pEntity.getCity());
        ps.setString(6, pEntity.getCountry());
        ps.setDouble(7, pEntity.getLongitude().doubleValue());
        ps.setDouble(8, pEntity.getLatitude().doubleValue());
    }
}
