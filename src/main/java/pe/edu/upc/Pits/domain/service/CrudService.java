package pe.edu.upc.Pits.domain.service;

import java.util.Optional;
import java.util.List;

public interface CrudService<T> {
	T save(T t) throws Exception;
	void delete(Integer id) throws Exception;
	List<T> getAll() throws Exception;
	Optional<T> getById(Integer id) throws Exception;
}
