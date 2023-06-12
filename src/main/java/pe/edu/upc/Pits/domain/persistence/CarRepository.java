package pe.edu.upc.Pits.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Pits.domain.model.entity.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	
	Optional<Car> findBytuition(String tuition);
	
	List<Car> findByBrand(String brand);
	
	@Query("SELECT mech FROM Car mech WHERE mech.years = :years or mech.brand = :brand")
	List<Car> fetchByyearsOrbrand(@Param("years")String years, @Param("brand")String brand);
}
