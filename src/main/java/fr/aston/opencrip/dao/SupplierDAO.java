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

    @Override
    public Set<ISupplierEntity> selectCriteria(
        String aSearchInput, Integer aLimit, String pOrderBy)
            throws ExceptionDao {
        Set<ISupplierEntity> result = new HashSet<>();

        try {
            // Recherche dans la table fournisseur
            StringBuffer request = new StringBuffer();
            request.append("select ");
            request.append(this.getPkName() + ",");
            request.append(String.join(",", this.getAllColumnNames()));
            request.append(" from ");
            request.append(this.getTableName());
            request.append(" where nom_enseigne LIKE ?");

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
                (ResultSetExtractor<Set<ISupplierEntity>>) this.getMapper());
        } catch (Throwable e) {
            throw new ExceptionDao(e);
        }

        return result;
    }
}