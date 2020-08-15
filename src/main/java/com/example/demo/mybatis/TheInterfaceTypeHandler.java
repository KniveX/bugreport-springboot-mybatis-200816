package com.example.demo.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import com.example.demo.obj.TheEnum;
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
		theRequiredBean.doSomething();
		ps.setString(i, TheEnum.TEST.name());
	}

	@Override
	public TheInterface getNullableResult(ResultSet rs, String columnName) throws SQLException {
		theRequiredBean.doSomething();
		return TheEnum.TEST;
	}

	@Override
	public TheInterface getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		theRequiredBean.doSomething();
		return TheEnum.TEST;
	}

	@Override
	public TheInterface getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		theRequiredBean.doSomething();
		return TheEnum.TEST;
	}
}
