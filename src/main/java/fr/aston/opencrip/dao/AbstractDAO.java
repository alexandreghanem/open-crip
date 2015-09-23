package fr.aston.opencrip.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.aston.opencrip.dao.ex.ExceptionDao;
import fr.aston.opencrip.dao.util.AbstractJdbcMapper;
import fr.aston.opencrip.entity.IEntity;

/**
 * DAO standard.
 *
 * @param <T>
 *            la cible du DAO
 */
@Repository
public abstract class AbstractDAO<T extends IEntity> implements Serializable,
    IDAO<T> {

    private static final long serialVersionUID = 1L;

    private JdbcTemplate jdbcTemplate;

    protected Log LOG = LogFactory.getLog(this.getClass());

    public AbstractDAO() {
        super();
    }

    /**
     * Getter for attribute jdbcTemplate
     *
     * @return the jdbcTemplate
     */
    protected JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    /**
     * Setter for attribute jdbcTemplate
     *
     * @param jdbcTemplate
     *            the jdbcTemplate to set
     */
    @Autowired
    protected void setJdbcTemplate(
        @Qualifier("jdbcTemplate") JdbcTemplate aJdbcTemplate) {
        this.jdbcTemplate = aJdbcTemplate;
    }

    protected abstract AbstractJdbcMapper<T> getMapper();

    @Override
    public abstract String getTableName();

    @Override
    public abstract String getPkName();

    @Override
    public abstract String[] getAllColumnNames();

    @Override
    public abstract String[] getInsertParams();

    @Override
    public abstract List<Object> getUpdateParams(T pEntity);

    @Override
    public abstract int[] getUpdateTypes();

    @Override
    public T insert(final T pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }

        try {
            PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(
                    Connection connexion) throws SQLException {
                    String sql = "insert into " + AbstractDAO.this
                        .getTableName() + " (" + String.join(",",
                            AbstractDAO.this.getAllColumnNames()) + ") values("
                        + String.join(",", AbstractDAO.this.getInsertParams())
                        + ")" + ";";
                    if (AbstractDAO.this.LOG.isDebugEnabled()) {
                        AbstractDAO.this.LOG.debug("Requete: " + sql);
                    }
                    PreparedStatement ps = connexion.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                    AbstractDAO.this.getMapper().revertMapRow(ps, pEntity);
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
    public T update(T pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return null;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "update " + this.getTableName() + " set " + String
                .join("=?,", this.getAllColumnNames()) + "=?" + " where " + this
                    .getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            this.getJdbcTemplate().update(sql, this.getUpdateParams(pEntity)
                .toArray(), this.getUpdateTypes());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return pEntity;
    }

    @Override
    public boolean delete(T pEntity) throws ExceptionDao {
        if (pEntity == null) {
            return false;
        }
        if (pEntity.getId() == null) {
            throw new ExceptionDao("L'entite n'a pas d'ID");
        }

        try {
            String sql = "delete from " + this.getTableName() + " where " + this
                .getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            return this.getJdbcTemplate().update(sql, pEntity.getId()) > 0;
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }
    }

    @Override
    public T select(Object pKey) throws ExceptionDao {
        if (pKey == null) {
            return null;
        }

        T result = null;

        try {
            String sql = "select " + this.getAllColumnNames() + " from " + this
                .getTableName() + " where " + this.getPkName() + "=?;";

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql);
            }

            if (pKey instanceof Number) {
                result = this.getJdbcTemplate().queryForObject(sql,
                    (RowMapper<T>) this.getMapper(), ((Number) pKey)
                        .intValue());

            } else {
                result = this.getJdbcTemplate().queryForObject(sql,
                    (RowMapper<T>) this.getMapper(), Integer.valueOf(pKey
                        .toString()).intValue());
            }
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return result;
    }

    @Override
    public Set<T> selectAll(String pAWhere, String pAnOrderBy)
        throws ExceptionDao {

        Set<T> result = new HashSet<>();

        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select ");
            sql.append(this.getAllColumnNames());
            sql.append(" from ");
            sql.append(this.getTableName());
            if (pAWhere != null) {
                sql.append(" where ");
                sql.append(pAWhere);
            }
            if (pAnOrderBy != null) {
                sql.append(" order by ");
                sql.append(pAnOrderBy);
            }
            sql.append(';');

            if (this.LOG.isDebugEnabled()) {
                this.LOG.debug("Requete: " + sql.toString());
            }

            result = this.getJdbcTemplate().query(sql.toString(),
                (ResultSetExtractor<Set<T>>) this.getMapper());
        } catch (DataAccessException e) {
            throw new ExceptionDao(e);
        }

        return result;
    }
}
