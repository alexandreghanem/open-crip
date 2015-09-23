package fr.aston.opencrip.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.util.AbstractJdbcMapper;
import fr.aston.opencrip.dao.util.OrderJdbcMapper;
import fr.aston.opencrip.entity.IOrderEntity;

/**
 * Gestion des commandes. <br>
 */
@Repository
public class OrderDAO extends AbstractDAO<IOrderEntity>implements IOrderDAO {

    private static final long serialVersionUID = 1L;

    public OrderDAO() {
        super();
    }

    @Override
    public String getTableName() {
        return "Commande";
    }

    @Override
    public String getPkName() {
        return "id";
    }

    @Override
    public String[] getAllColumnNames() {
        return new String[] { "prix_total", "date_commande", "date_validation",
            "id_client", "id_paiement" };
    }

    @Override
    public String[] getInsertParams() {
        return new String[] { "?", "?", "?", "?", "?" };
    }

    @Override
    public List<Object> getUpdateParams(IOrderEntity pEntity) {
        List<Object> list = new ArrayList<Object>(6);
        list.add(pEntity.getPrice().doubleValue());
        list.add(pEntity.getOrderDate());
        list.add(pEntity.getValidationDate());
        list.add(pEntity.getClientId().intValue());
        list.add(pEntity.getPaymentId().intValue());
        list.add(pEntity.getId().intValue());
        return list;
    }

    @Override
    public int[] getUpdateTypes() {
        return new int[] { Types.DECIMAL, Types.DATE, Types.DATE,
            Types.SMALLINT, Types.SMALLINT, Types.SMALLINT };
    }

    @Override
    protected AbstractJdbcMapper<IOrderEntity> getMapper() {
        return new OrderJdbcMapper();
    }
}