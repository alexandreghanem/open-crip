package fr.aston.opencrip.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.util.AbstractJdbcMapper;
import fr.aston.opencrip.dao.util.OrderProductJdbcMapper;
import fr.aston.opencrip.entity.IOrderProductEntity;

/**
 * Gestion des commandes produits. <br>
 */
@Repository
public class OrderProductDAO extends AbstractDAO<IOrderProductEntity>implements
    IOrderProductDAO {

    private static final long serialVersionUID = 1L;

    public OrderProductDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "CommandeProduit";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String[] getAllColumnNames() {
        return new String[] { "prix_unitaire", "quantite", "id_commande",
            "id_produit" };
    }

    @Override
    public String[] getInsertParams() {
        return new String[] { "?", "?", "?", "?" };
    }

    @Override
    public List<Object> getUpdateParams(IOrderProductEntity pEntity) {
        List<Object> list = new ArrayList<Object>(5);
        list.add(pEntity.getPrice().doubleValue());
        list.add(pEntity.getQuantity().intValue());
        list.add(pEntity.getOrderId().intValue());
        list.add(pEntity.getProductId().intValue());
        list.add(pEntity.getId().intValue());
        return list;
    }

    @Override
    public int[] getUpdateTypes() {
        return new int[] { Types.DECIMAL, Types.SMALLINT, Types.SMALLINT,
            Types.SMALLINT, Types.SMALLINT };
    }

    @Override
    protected AbstractJdbcMapper<IOrderProductEntity> getMapper() {
        return new OrderProductJdbcMapper();
    }
}