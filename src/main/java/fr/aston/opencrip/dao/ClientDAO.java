package fr.aston.opencrip.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.util.AbstractJdbcMapper;
import fr.aston.opencrip.dao.util.ClientJdbcMapper;
import fr.aston.opencrip.entity.IClientEntity;

/**
 * Gestion des clients. <br>
 */
@Repository
public class ClientDAO extends AbstractDAO<IClientEntity>implements IClientDAO {

    private static final long serialVersionUID = 1L;

    public ClientDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Client";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String[] getAllColumnNames() {
        return new String[] { "nom", "prenom" };
    }

    @Override
    public String[] getInsertParams() {
        return new String[] { "?", "?" };
    }

    @Override
    public List<Object> getUpdateParams(IClientEntity pEntity) {
        List<Object> list = new ArrayList<Object>(3);
        list.add(pEntity.getLastname());
        list.add(pEntity.getFirstname());
        list.add(pEntity.getId().intValue());
        return list;
    }

    @Override
    public int[] getUpdateTypes() {
        return new int[] { Types.VARCHAR, Types.VARCHAR, Types.SMALLINT };
    }

    @Override
    protected AbstractJdbcMapper<IClientEntity> getMapper() {
        return new ClientJdbcMapper();
    }
}