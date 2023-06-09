package pe.edu.upc.Pits.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfigurationM")
public class MappingMConfiguration {

    @Bean
    public MechanicMapper mechanicMapper(){ return new MechanicMapper();}
}
