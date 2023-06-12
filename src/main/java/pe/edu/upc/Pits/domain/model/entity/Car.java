package pe.edu.upc.Pits.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@NotBlank
	@Size(min = 6, max = 6, message = "La placa del auto debe tener 6 digitos")
	@Column(name = "tuition", columnDefinition = "char(6)", nullable = false)
	private String tuition;
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30, message = "Indique la marca de su auto")
	@Column(name = "brand", length = 30, nullable = false)
	private String brand;
	
	@Size(min = 2, max = 60, message = "Describa su auto")
	@Column(name = "Description", nullable = false)
	private String description;
	
	@NotNull
	@NotBlank
	@Size(min = 4, max = 4, message = "Diganos con 4 caracteres el año de su auto")
	@Column(name = "years", columnDefinition = "char(4)", nullable = false)
	private String years;
}
