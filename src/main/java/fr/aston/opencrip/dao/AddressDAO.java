package fr.aston.opencrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.dao.util.AbstractJdbcMapper;
import fr.aston.opencrip.dao.util.AddressJdbcMapper;
import fr.aston.opencrip.entity.IAddressEntity;

/**
 * Gestion des adresses. <br>
 */
@Repository
public class AddressDAO extends AbstractDAO<IAddressEntity>implements
    IAddressDAO {

    private static final long serialVersionUID = 1L;

    public AddressDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Utilisateur";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String getAllColumnNames() {
        return "id, numero, adresse_1, adresse_2, code_postal, ville, pays, longitude, latitude";
    }

    @Override
    protected AbstractJdbcMapper<IAddressEntity> getMapper() {
        return new AddressJdbcMapper();
    }

    @Override
    public IAddressEntity insert(final IAddressEntity pEntity)
        throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }

        try {
            PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(
                    Connection connexion) throws SQLException {
                    PreparedStatement ps = connexion.prepareStatement(
                        "insert into " + AddressDAO.this.getTableName()
                            + " (numero, adresse_1, adresse_2, code_postal, ville, pays, longitude, latitude) "
                            + " values (?,?,?,?,?,?,?,?);",
                        Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, pEntity.getNumber());
                    ps.setString(2, pEntity.getAddress1());
                    ps.setString(3, pEntity.getAddress2());
                    ps.setString(4, pEntity.getZipCode());
                    ps.setString(5, pEntity.getCity());
                    ps.setString(6, pEntity.getCountry());
                    ps.setDouble(7, pEntity.getLongitude().doubleValue());
                    ps.setDouble(8, pEntity.getLatitude().doubleValue());
                    return ps;
                }
            };
            KeyHolder kh = new GeneratedKeyHolder();
            this.getJdbcTemplate().update(psc, kh);
            pEntity.setId(Integer.valueOf(kh.getKey().intValue()));
        } catch (Throwable e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }

    @Override
    public IAddressEntity update(IAddressEntity pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName()
                + " set numero=?,adresse_1=?,adresse_2=?,code_postal=?,ville=?,pays=?,longitude=?,latitude=? where "
                + this.getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, pEntity.getNumber(), pEntity
                .getAddress1(), pEntity.getAddress2(), pEntity.getZipCode(),
                pEntity.getCity(), pEntity.getCountry(), pEntity.getLongitude()
                    .doubleValue(), pEntity.getLatitude().doubleValue(), pEntity
                        .getId().intValue());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }
}