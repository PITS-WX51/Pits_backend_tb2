package pe.edu.upc.Pits.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.Date;
@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30, message = "El Apellido puede tener de 2 hasta 30 caracteres")
	@Column(name = "Last_name_user", length = 30, nullable = false)
	private String lastname_user;
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	@Column(name = "First_name_user", length = 30, nullable = false)
	private String firstname_user;
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30, message = "El Apellido puede tener de 2 hasta 30 caracteres")
	@Column(name = "Last_name_mechanic", length = 30, nullable = false)
	private String lastname_mechanic;
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	@Column(name = "First_name_mechanic", length = 30, nullable = false)
	private String firstname_mechanic;
	@NotNull
	@NotBlank
	@Column(name = "Car_id", nullable = false)
	private String car;
	@Size(min = 2, max = 30, message = "Marca")
	@Column(name = "brand", nullable = false)
	private String brand;
	@Size(min = 2, max = 60, message = "Descripcion de la cita")
	@Column(name = "Description", nullable = false)
	private String description;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private List<Car> cars;
	
}
