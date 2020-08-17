package com.example.demo.obj;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Component;

@Component
public class TheRequiredBean {
	private Map<String, TheInterface> nameToEnumMapping;

    @SuppressWarnings("unchecked")
	public TheRequiredBean(ApplicationContext appCtx) {
		nameToEnumMapping = new HashMap<>();
		
		// Find all enum classes with interface
		final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AssignableTypeFilter(TheInterface.class));
        
        for(BeanDefinition def : provider.findCandidateComponents("com.example.demo")) {
        	String cls = def.getBeanClassName();
            Class<?> detectedClass = null;
            
            try {
            	detectedClass = Class.forName(cls);
            } catch (ClassNotFoundException e) {
				// Skip processing this bean
            	continue;
			}
            
        	// Skip non-enum
            if(!detectedClass.isEnum())
            	continue;
            
            // Read all enum values in the detected class, and map them
            Class<? extends Enum<?>> enumClass = (Class<? extends Enum<?>>) detectedClass;
            for(Enum<?> e : enumClass.getEnumConstants())
                nameToEnumMapping.put(e.name(), (TheInterface) e);
        }
	}
	
    public TheInterface findByName(String enumName) {
    	return nameToEnumMapping.get(enumName);
    }
}
