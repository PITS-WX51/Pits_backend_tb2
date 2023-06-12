package pe.edu.upc.Pits.service.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.Pits.domain.model.entity.Appointment;
import pe.edu.upc.Pits.domain.persistence.AppointmentRepository;
import pe.edu.upc.Pits.domain.service.AppointmentService;
import pe.edu.upc.Pits.shared.Constant;
import pe.edu.upc.Pits.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Pits.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private Validator validator;
	
	@Transactional(readOnly = true)
	@Override
	public List<Appointment> fetchAll(){return appointmentRepository.findAll();}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Appointment> fetchById(Integer id){
		if (appointmentRepository.existsById(id)){
			return appointmentRepository.findById(id);
		} else {
			throw new ResourceNotFoundException("Appointment",id);
		}
	}
	
	@Transactional
	@Override
	public Appointment save(Appointment appointment){
		Set<ConstraintViolation<Appointment>> violations = validator.validate(appointment);
		if (!violations.isEmpty()){
			throw new ResourceValidationException(Constant.APPOINTMENT_ENTITY, violations);
		}
		return appointmentRepository.save(appointment);
	}
	
	@Transactional
	@Override
	public Appointment update(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	@Transactional
	@Override
	public boolean deleteById(Integer id) {
		if (appointmentRepository.existsById(id)) {
			appointmentRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
