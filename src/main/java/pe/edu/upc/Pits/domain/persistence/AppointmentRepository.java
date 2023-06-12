package pe.edu.upc.Pits.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.Pits.domain.model.entity.Appointment;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	List<Appointment> findByDate(Date date);
	
	@Query("SELECT mech FROM Appointment mech WHERE mech.lastname_user = :lastname_user or mech.firstname_user = :firstname_user")
	List<Appointment> fetchBylastname_userOrlastname_user(@Param("lastname_user")String lastname_user, @Param("firstname_user")String firstname_user);
	@Query("SELECT mech FROM Appointment mech WHERE mech.lastname_mechanic = :lastname_mechanic or mech.firstname_mechanic = :firstname_mechanic")
	List<Appointment> fetchBylastname_mechanicOrlastname_mechanic(@Param("lastname_mechanic")String lastname_mechanic, @Param("firstname_mechanic")String firstname_mechanic);
}
