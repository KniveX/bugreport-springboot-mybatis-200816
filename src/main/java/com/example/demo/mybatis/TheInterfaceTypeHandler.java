package com.example.demo.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import com.example.demo.obj.TheInterface;
import com.example.demo.obj.TheRequiredBean;

@Component
public class TheInterfaceTypeHandler extends BaseTypeHandler<TheInterface> {
	private final TheRequiredBean theRequiredBean;
	
	public TheInterfaceTypeHandler(TheRequiredBean theRequiredBean) {
		this.theRequiredBean = theRequiredBean;
	}
	
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, TheInterface parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.name());
	}

	@Override
	public TheInterface getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return theRequiredBean.findByName( rs.getString(columnName) );
	}

	@Override
	public TheInterface getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return theRequiredBean.findByName( rs.getString(columnIndex) );
	}

	@Override
	public TheInterface getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return theRequiredBean.findByName( cs.getString(columnIndex) );
	}
}
