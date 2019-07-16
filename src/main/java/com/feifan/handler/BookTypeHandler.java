package com.feifan.handler;

import com.feifan.entity.Book;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 自定义的Book类型的处理器
 * 把一些特殊字段进行处理
 */
public class BookTypeHandler extends BaseTypeHandler<List<String>> {

    @Override//设置参数
    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,Book.authorsToString(parameter));
    }

    @Override//设置返回值的
    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return Book.authorsToList(rs.getString(columnName));
    }

    @Override//设置返回值的
    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return Book.authorsToList(rs.getString(columnIndex));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Book.authorsToList(cs.getString(columnIndex));
    }

}
