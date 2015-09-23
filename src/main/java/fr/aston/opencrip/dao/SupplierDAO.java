package fr.aston.opencrip.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.util.AbstractJdbcMapper;
import fr.aston.opencrip.dao.util.SupplierJdbcMapper;
import fr.aston.opencrip.entity.ISupplierEntity;

/**
 * Gestion des fournisseurs. <br>
 */
@Repository
public class SupplierDAO extends AbstractDAO<ISupplierEntity>implements
    ISupplierDAO {

    private static final long serialVersionUID = 1L;

    public SupplierDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Fournisseur";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String[] getAllColumnNames() {
        return new String[] { "nom_enseigne", "chiffre_affaire" };
    }

    @Override
    public String[] getInsertParams() {
        return new String[] { "?", "?" };
    }

    @Override
    public List<Object> getUpdateParams(ISupplierEntity pEntity) {
        List<Object> list = new ArrayList<Object>(3);
        list.add(pEntity.getCompanyName());
        list.add(pEntity.getTurnover());
        list.add(pEntity.getId().intValue());
        return list;
    }

    @Override
    public int[] getUpdateTypes() {
        return new int[] { Types.VARCHAR, Types.VARCHAR, Types.SMALLINT };
    }

    @Override
    protected AbstractJdbcMapper<ISupplierEntity> getMapper() {
        return new SupplierJdbcMapper();
    }
}