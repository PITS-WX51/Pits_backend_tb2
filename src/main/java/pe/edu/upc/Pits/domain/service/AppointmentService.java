package pe.edu.upc.Pits.domain.service;

import pe.edu.upc.Pits.domain.model.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService /*extends CrudService*/{
	List<Appointment> fetchAll();
	Optional<Appointment> fetchById(Integer id);
	Appointment save(Appointment appointment);
	Appointment update(Appointment appointment);
	boolean deleteById(Integer id);
}
