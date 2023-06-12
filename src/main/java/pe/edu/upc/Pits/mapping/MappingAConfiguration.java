package pe.edu.upc.Pits.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfigurationA")
public class MappingAConfiguration {
	
	@Bean
	public AppointmentMapper appointmentMapper(){ return new AppointmentMapper();}
}
