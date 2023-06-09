package pe.edu.upc.Pits.domain.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "brands")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	// Additional
	@OneToMany(mappedBy = "brand")
	private ArrayList<Car> cars;
	
}