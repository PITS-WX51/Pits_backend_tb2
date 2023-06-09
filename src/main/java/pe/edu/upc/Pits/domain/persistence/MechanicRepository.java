package pe.edu.upc.Pits.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Pits.domain.model.entity.Mechanic;

import java.util.List;
import java.util.Optional;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {

    Optional<Mechanic> findBydni(String dni);

    List<Mechanic> findByLastNameStartingWith(String lastName);

    @Query("SELECT mech FROM Mechanic mech WHERE mech.dni = :dni or mech.lastName = :lastName")
    List<Mechanic> fetchByDniOrlastName(@Param("dni")String dni,@Param("lastName")String lastName);
}
