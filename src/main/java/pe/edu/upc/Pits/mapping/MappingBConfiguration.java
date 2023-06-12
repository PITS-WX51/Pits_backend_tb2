package pe.edu.upc.Pits.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfigurationB")
public class MappingBConfiguration {
	
	@Bean
	public BrandMapper BrandMapper(){ return new BrandMapper();}
}
