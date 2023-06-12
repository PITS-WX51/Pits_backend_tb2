package pe.edu.upc.Pits.domain.service;


import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.Pits.domain.model.entity.Brand;


import java.util.List;
import java.util.Optional;

public interface BrandService /*extends CrudService*/{
	List<Brand> fetchAll();
	Optional<Brand> fetchById(Integer id);
	Brand save(Brand brand);
	Brand update(Brand brand);
	boolean deleteById(Integer id);
}
