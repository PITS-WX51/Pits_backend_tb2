package pe.edu.upc.Pits.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Pits.domain.model.entity.Brand;
import pe.edu.upc.Pits.domain.model.entity.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
	List<Brand> findByName(String name);
}
