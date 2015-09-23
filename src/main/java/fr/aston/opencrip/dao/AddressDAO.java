package fr.aston.opencrip.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

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
    public String[] getAllColumnNames() {
        return new String[] { "numero", "adresse_1", "adresse_2", "code_postal",
            "ville", "pays", "longitude", "latitude" };
    }

    @Override
    public String[] getInsertParams() {
        return new String[] { "?", "?", "?", "?", "?", "?", "?", "?" };
    }

    @Override
    public List<Object> getUpdateParams(IAddressEntity pEntity) {
        List<Object> list = new ArrayList<Object>(9);
        list.add(pEntity.getNumber());
        list.add(pEntity.getAddress1());
        list.add(pEntity.getAddress2());
        list.add(pEntity.getZipCode());
        list.add(pEntity.getCity());
        list.add(pEntity.getCountry());
        list.add(pEntity.getLongitude().doubleValue());
        list.add(pEntity.getLatitude().doubleValue());
        list.add(pEntity.getId().intValue());
        return list;
    }

    @Override
    public int[] getUpdateTypes() {
        return new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
            Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DECIMAL,
            Types.DECIMAL, Types.SMALLINT };
    }

    @Override
    protected AbstractJdbcMapper<IAddressEntity> getMapper() {
        return new AddressJdbcMapper();
    }
}