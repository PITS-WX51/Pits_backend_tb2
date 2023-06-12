package pe.edu.upc.Pits.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Pits.domain.model.entity.Car;
import pe.edu.upc.Pits.domain.service.CarService;
import pe.edu.upc.Pits.mapping.CarMapper;
import pe.edu.upc.Pits.resource.CreateCarResource;
import pe.edu.upc.Pits.resource.CarResource;
import pe.edu.upc.Pits.resource.UpdateCarResource;

import java.util.List;

@RestController
@RequestMapping("cars")
@AllArgsConstructor
public class CarController {
	private final CarService carService;
	private final CarMapper mapper;
	
	@PostMapping
	public CarResource save(@RequestBody CreateCarResource resource) {
		return mapper.toResource( carService.save( mapper.toModel(resource) ) );
	}
	
	@GetMapping
	public List<Car> fetchAll() {
		return carService.fetchAll();
	}
	
	@GetMapping("{id}")
	public CarResource fetchId(@PathVariable Integer id) {
		return this.mapper.toResource(carService.fetchById(id).get());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CarResource> update(@PathVariable Integer id,
																						@RequestBody UpdateCarResource resource) {
		if (id.equals(resource.getId())) {
			CarResource carResource = mapper.toResource(
				carService.update( mapper.toModel(resource) ) );
			return new ResponseEntity<>(carResource, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		if (carService.deleteById(id)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
