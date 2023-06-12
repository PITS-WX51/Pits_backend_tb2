package pe.edu.upc.Pits.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Pits.domain.model.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findBydni(String dni);
	List<User> findBylastnameStartingWith(String lastname);
	
	@Query("SELECT user FROM User user WHERE user.dni = :dni or user.lastname = :lastname")
	List<User> fetchBydniOrlastname(@Param("dni") String dni, @Param("lastname") String lastname);
}
