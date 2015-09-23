package fr.aston.opencrip.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.util.AbstractJdbcMapper;
import fr.aston.opencrip.dao.util.ProductJdbcMapper;
import fr.aston.opencrip.entity.IProductEntity;

/**
 * Gestion des produits. <br>
 */
@Repository
public class ProductDAO extends AbstractDAO<IProductEntity>implements
    IProductDAO {

    private static final long serialVersionUID = 1L;

    public ProductDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Produit";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String[] getAllColumnNames() {
        return new String[] { "reference_produit", "prix_unitaire",
            "id_fournisseur" };
    }

    @Override
    public String[] getInsertParams() {
        return new String[] { "?", "?", "?" };
    }

    @Override
    public List<Object> getUpdateParams(IProductEntity pEntity) {
        List<Object> list = new ArrayList<Object>(4);
        list.add(pEntity.getReference());
        list.add(pEntity.getPrice().doubleValue());
        list.add(pEntity.getSupplierId().intValue());
        list.add(pEntity.getId().intValue());
        return list;
    }

    @Override
    public int[] getUpdateTypes() {
        return new int[] { Types.VARCHAR, Types.DECIMAL, Types.SMALLINT,
            Types.SMALLINT };
    }

    @Override
    protected AbstractJdbcMapper<IProductEntity> getMapper() {
        return new ProductJdbcMapper();
    }
}