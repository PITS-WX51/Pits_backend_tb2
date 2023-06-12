package pe.edu.upc.Pits.service.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.Pits.domain.model.entity.Car;
import pe.edu.upc.Pits.domain.persistence.CarRepository;
import pe.edu.upc.Pits.domain.service.CarService;
import pe.edu.upc.Pits.shared.Constant;
import pe.edu.upc.Pits.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Pits.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private Validator validator;
	
	@Transactional(readOnly = true)
	@Override
	public List<Car> fetchAll(){return carRepository.findAll();}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Car> fetchById(Integer id){
		if (carRepository.existsById(id)){
			return carRepository.findById(id);
		} else {
			throw new ResourceNotFoundException("Car",id);
		}
	}
	
	@Transactional
	@Override
	public Car save(Car car){
		Set<ConstraintViolation<Car>> violations = validator.validate(car);
		if (!violations.isEmpty()){
			throw new ResourceValidationException(Constant.CAR_ENTITY, violations);
		}
		return carRepository.save(car);
	}
	
	@Transactional
	@Override
	public Car update(Car car) {
		return carRepository.save(car);
	}
	
	@Transactional
	@Override
	public boolean deleteById(Integer id) {
		if (carRepository.existsById(id)) {
			carRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
