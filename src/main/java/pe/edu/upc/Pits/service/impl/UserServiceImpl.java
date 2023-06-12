package pe.edu.upc.Pits.service.impl;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.Pits.domain.model.entity.User;
import pe.edu.upc.Pits.domain.persistence.UserRepository;
import pe.edu.upc.Pits.domain.service.UserService;
import pe.edu.upc.Pits.shared.Constant;
import pe.edu.upc.Pits.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Pits.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Validator validator;
	
	@Transactional(readOnly = true)
	@Override
	public List<User> fetchAll() {return userRepository.findAll(); }
	
	@Transactional(readOnly = true)
	@Override
	public Optional<User> fetchById(Integer id) {
		if (userRepository.existsById(id)) {
			return userRepository.findById(id);
		} else {
			throw new ResourceNotFoundException("Student", id);
		}
	}
	
	@Transactional
	@Override
	public User save(User user) {
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		if (!violations.isEmpty()) {
			throw new ResourceValidationException(Constant.USER_ENTITY, violations);
		}
		return userRepository.save(user);
	}
	
	@Transactional
	@Override
	public User update(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	@Override
	public boolean deleteById(Integer id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

