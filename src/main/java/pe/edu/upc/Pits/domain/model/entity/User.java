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

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30, message = "El Apellido puede tener de 2 hasta 30 caracteres")
	@Column(name = "Last_name", length = 30, nullable = false)
	private String lastname;
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	@Column(name = "First_name", length = 30)
	private String firstname;
	@NotNull
	@NotBlank
	@Size(min = 9, max = 9)
	@Column(name = "Contact_number", columnDefinition = "char(9)", nullable = false)
	private String contactnumber;
	@NotNull
	@NotBlank
	@Size(min = 8, max = 8)
	@Column(name = "Dni", columnDefinition = "char(8)", nullable = false)
	private String dni;
	@NotNull
	@NotBlank
	@Column(name = "Car_id", nullable = false)
	private String car;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private List<Car> cars;
	
}
