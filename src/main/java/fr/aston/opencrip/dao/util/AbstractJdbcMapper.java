package fr.aston.opencrip.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public abstract class AbstractJdbcMapper<T> implements RowMapper<T>,
    ResultSetExtractor<Set<T>> {

    public AbstractJdbcMapper() {
        super();
    }

    @Override
    public Set<T> extractData(ResultSet rs) throws SQLException,
        DataAccessException {
        Set<T> result = new HashSet<>();
        int id = 0;
        while (rs.next()) {
            T res = this.mapRow(rs, id);
            result.add(res);
            id++;
        }
        return result;
    }

    @Override
    public abstract T mapRow(ResultSet rs, int id) throws SQLException;
}
