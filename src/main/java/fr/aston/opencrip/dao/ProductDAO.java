package fr.aston.opencrip.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.ex.ExceptionDao;
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

    @Override
    public Set<IProductEntity> selectCriteria(
        String aSearchInput, Integer aLimit, String pOrderBy)
            throws ExceptionDao {
        Set<IProductEntity> result = new HashSet<>();

        try {
            // Recherche dans la table produit
            StringBuffer request = new StringBuffer();
            request.append("select ");
            request.append(this.getPkName() + ",");
            request.append(String.join(",", this.getAllColumnNames()));
            request.append(" from ");
            request.append(this.getTableName());
            request.append(" where reference_produit LIKE ?");

            List<Object> gaps = new ArrayList<>();
            gaps.add("%" + aSearchInput + "%");

            if (aLimit != null) {
                request.append(" limit 0,?");
                gaps.add(aLimit.intValue());
            }

            if (pOrderBy != null) {
                request.append(" order by ");
                request.append(pOrderBy);
            }

            request.append(';');

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + request.toString());
            }

            result = this.getJdbcTemplate().query(request.toString(), gaps
                .toArray(new Object[gaps.size()]),
                (ResultSetExtractor<Set<IProductEntity>>) this.getMapper());
        } catch (Throwable e) {
            throw new ExceptionDao(e);
        }

        return result;
    }
}