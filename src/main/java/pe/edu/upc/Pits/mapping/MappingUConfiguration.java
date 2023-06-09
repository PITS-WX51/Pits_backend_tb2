package pe.edu.upc.Pits.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")
public class MappingUConfiguration {
	@Bean
	public UserMapper userMapper() {return new UserMapper();}
}
