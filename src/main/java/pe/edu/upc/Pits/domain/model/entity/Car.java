package pe.edu.upc.Pits.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@Entity
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(max = 6, min = 6)
	@NotBlank
	@Column(name = "tuition", length = 50, nullable = false)
	private String tuition;
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	@OneToMany(mappedBy = "car")
	private ArrayList<User> users;
}
