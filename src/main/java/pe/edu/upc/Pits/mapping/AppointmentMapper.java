package pe.edu.upc.Pits.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.Pits.domain.model.entity.Appointment;
import pe.edu.upc.Pits.resource.AppointmentResource;
import pe.edu.upc.Pits.resource.CreateAppointmentResource;
import pe.edu.upc.Pits.resource.UpdateAppointmentResource;
import pe.edu.upc.Pits.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class AppointmentMapper implements Serializable {
	
	@Autowired
	EnhancedModelMapper mapper;
	
	public Appointment toModel(CreateAppointmentResource resource) { return this.mapper.map(resource, Appointment.class);
	}
	public Appointment toModel(UpdateAppointmentResource resource) {
		return this.mapper.map(resource, Appointment.class);
	}
	public AppointmentResource toResource(Appointment appointment) {
		return this.mapper.map(appointment, AppointmentResource.class);
	}
	
}
