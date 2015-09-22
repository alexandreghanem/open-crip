package fr.aston.opencrip.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.entity.UserEntity;

/**
 * Le mapper qui represente un utilisateur. <br>
 */
public class UserJdbcMapper extends AbstractJdbcMapper<IUserEntity> {

    /**
     * Constructeur de l'objet. <br>
     */
    public UserJdbcMapper() {
        super();
    }

    @Override
    public IUserEntity mapRow(ResultSet rs, int id) throws SQLException {
        IUserEntity result = new UserEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setLogin(rs.getString("identifiant"));
        result.setPassword(rs.getString("mot_de_passe"));
        result.setEmail(rs.getString("email"));
        result.setTelephone(rs.getString("telephone"));
        result.setLastConnection(rs.getTimestamp("date_derniere_connection"));
        result.setRegistrationDate(rs.getDate("date_inscription"));
        result.setAddressId(Integer.valueOf(rs.getInt("id_adresse")));
        result.setClientId(Integer.valueOf(rs.getInt("id_client")));
        result.setSupplierId(Integer.valueOf(rs.getInt("id_fournisseur")));
        return result;
    }
}
