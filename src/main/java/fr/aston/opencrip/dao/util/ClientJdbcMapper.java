package fr.aston.opencrip.dao.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.ClientEntity;
import fr.aston.opencrip.entity.IClientEntity;

/**
 * Le mapper qui represente une client. <br>
 */
public class ClientJdbcMapper extends AbstractJdbcMapper<IClientEntity> {

    /**
     * Constructeur de l'objet. <br>
     */
    public ClientJdbcMapper() {
        super();
    }

    @Override
    public IClientEntity mapRow(ResultSet rs, int id) throws SQLException {
        IClientEntity result = new ClientEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setLastname(rs.getString("nom"));
        result.setFirstname(rs.getString("prenom"));
        return result;
    }

    @Override
    public void revertMapRow(PreparedStatement ps, IClientEntity pEntity)
        throws SQLException {
        ps.setString(1, pEntity.getLastname());
        ps.setString(2, pEntity.getFirstname());
    }
}
