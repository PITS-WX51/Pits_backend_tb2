package pe.edu.upc.Pits.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Pits.domain.model.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}