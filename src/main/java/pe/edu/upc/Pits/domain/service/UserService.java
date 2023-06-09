package pe.edu.upc.Pits.domain.service;

import pe.edu.upc.Pits.domain.model.entity.User;

import java.util.List;
import java.util.Optional;
public interface UserService {
	List<User> fetchAll();
	Optional<User> fetchById(Integer id);
	User save(User user);
	User update(User user);
	boolean deleteById(Integer id);
}
