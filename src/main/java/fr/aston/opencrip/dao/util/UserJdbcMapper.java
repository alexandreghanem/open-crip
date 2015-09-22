package fr.aston.opencrip.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.entity.UserEntity;

public class UserJdbcMapper extends AbstractJdbcMapper<IUserEntity> {

    public UserJdbcMapper() {
        super();
    }

    @Override
    public IUserEntity mapRow(ResultSet rs, int id) throws SQLException {
        IUserEntity result = new UserEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setLogin(rs.getString("identifiant"));
        result.setPassword(rs.getString("mot_de_passe"));
        result.setLastConnection(rs.getTimestamp("date_derniere_connection"));
        return result;
    }

}
