package pe.edu.upc.Pits.domain.service;

import pe.edu.upc.Pits.domain.model.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService /*extends CrudService*/{
	List<Car> fetchAll();
	Optional<Car> fetchById(Integer id);
	Car save(Car car);
	Car update(Car car);
	boolean deleteById(Integer id);
}
