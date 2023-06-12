package pe.edu.upc.Pits.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfigurationC")
public class MappingCConfiguration {
	
	@Bean
	public CarMapper carMapper(){ return new CarMapper();}
}
