package pe.edu.upc.Pits.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.Pits.domain.model.entity.Car;
import pe.edu.upc.Pits.resource.CarResource;
import pe.edu.upc.Pits.resource.CreateCarResource;
import pe.edu.upc.Pits.resource.UpdateCarResource;
import pe.edu.upc.Pits.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class CarMapper implements Serializable {
	
	@Autowired
	EnhancedModelMapper mapper;
	
	public Car toModel(CreateCarResource resource) { return this.mapper.map(resource, Car.class);
	}
	public Car toModel(UpdateCarResource resource) {
		return this.mapper.map(resource, Car.class);
	}
	public CarResource toResource(Car car) {
		return this.mapper.map(car, CarResource.class);
	}
	
}
