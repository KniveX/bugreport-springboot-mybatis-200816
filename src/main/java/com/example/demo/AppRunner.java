package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.mybatis.TheInterfaceMapper;
import com.example.demo.obj.TheEnum;
import com.example.demo.obj.TheModel;

@Component
public class AppRunner implements ApplicationRunner {
	private final TheInterfaceMapper theInterfaceMapper;
	
	public AppRunner(TheInterfaceMapper theInterfaceMapper) {
		this.theInterfaceMapper = theInterfaceMapper;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		TheModel theModel = new TheModel();
		
//		theInterfaceMapper.annotationDirect(TheEnum.TEST);	// ERROR
//		theInterfaceMapper.       xmlDirect(TheEnum.TEST);	// ERROR
		
//		theInterfaceMapper.annotationDirectUsingTypeHandler(TheEnum.TEST);	// ERROR
//		theInterfaceMapper.       xmlDirectUsingTypeHandler(TheEnum.TEST);	// ERROR
		
		theInterfaceMapper.annotationWithModel(theModel);
//		theInterfaceMapper.       xmlWithModel(theModel);	// ERROR (not yet tested with 'parameterType' on mapper XML)
		
		theInterfaceMapper.annotationWithModelUsingTypeHandler(theModel);
		theInterfaceMapper.       xmlWithModelUsingTypeHandler(theModel);
	}
}
