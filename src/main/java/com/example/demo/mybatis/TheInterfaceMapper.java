package com.example.demo.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.obj.TheInterface;
import com.example.demo.obj.TheModel;

@Mapper
public interface TheInterfaceMapper {
	@Insert("INSERT INTO the_table(the_interface) VALUES (#{theInterface})")
	void annotationDirect(TheInterface theInterface);
	void        xmlDirect(TheInterface theInterface);
	
	@Insert("INSERT INTO the_table(the_interface) VALUES (#{theInterface, typeHandler=com.example.demo.mybatis.TheInterfaceTypeHandler})")
	void annotationDirectUsingTypeHandler(TheInterface theInterface);
	void        xmlDirectUsingTypeHandler(TheInterface theInterface);
	
	@Insert("INSERT INTO the_table(the_interface) VALUES (#{theInterface})")
	void annotationWithModel(TheModel theModel);
	void        xmlWithModel(TheModel theModel);
	
	@Insert("INSERT INTO the_table(the_interface) VALUES (#{theInterface, typeHandler=com.example.demo.mybatis.TheInterfaceTypeHandler})")
	void annotationWithModelUsingTypeHandler(TheModel theModel);
	void        xmlWithModelUsingTypeHandler(TheModel theModel);
	
}
