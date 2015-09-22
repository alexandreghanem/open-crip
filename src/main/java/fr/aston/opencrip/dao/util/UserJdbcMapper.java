package fr.aston.opencrip.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.aston.opencrip.entity.IUserEntity;
import fr.aston.opencrip.entity.UserEntity;

public class UserJdbcMapper extends
    AbstractJdbcMapper<IUserEntity> {

    public UserJdbcMapper() {
        super();
    }

    @Override
    public IUserEntity mapRow(ResultSet rs, int id) throws SQLException {
        IUserEntity result = new UserEntity();
        result.setId(Integer.valueOf(rs.getInt("id")));
        result.setNom(rs.getString("nom"));
        result.setPrenom(rs.getString("prenom"));
        result.setLogin(rs.getString("login"));
        result.setPassword(rs.getString("password"));
        result.setSex(Byte.valueOf(rs.getByte("sex")));
        result.setDerniereConnection(rs.getTimestamp("derniereConnection"));
        return result;
    }

}
