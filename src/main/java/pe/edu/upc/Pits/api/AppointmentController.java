package pe.edu.upc.Pits.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Pits.domain.model.entity.Appointment;
import pe.edu.upc.Pits.domain.service.AppointmentService;
import pe.edu.upc.Pits.mapping.AppointmentMapper;
import pe.edu.upc.Pits.resource.CreateAppointmentResource;
import pe.edu.upc.Pits.resource.AppointmentResource;
import pe.edu.upc.Pits.resource.UpdateAppointmentResource;

import java.util.List;

@RestController
@RequestMapping("appointments")
@AllArgsConstructor
public class AppointmentController {
	private final AppointmentService appointmentService;
	private final AppointmentMapper mapper;
	
	@PostMapping
	public AppointmentResource save(@RequestBody CreateAppointmentResource resource) {
		return mapper.toResource( appointmentService.save( mapper.toModel(resource) ) );
	}
	
	@GetMapping
	public List<Appointment> fetchAll() {
		return appointmentService.fetchAll();
	}
	
	@GetMapping("{id}")
	public AppointmentResource fetchId(@PathVariable Integer id) {
		return this.mapper.toResource(appointmentService.fetchById(id).get());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<AppointmentResource> update(@PathVariable Integer id,
																										@RequestBody UpdateAppointmentResource resource) {
		if (id.equals(resource.getId())) {
			AppointmentResource appointmentResource = mapper.toResource(
				appointmentService.update( mapper.toModel(resource) ) );
			return new ResponseEntity<>(appointmentResource, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		if (appointmentService.deleteById(id)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
