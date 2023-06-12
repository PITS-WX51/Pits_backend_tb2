package pe.edu.upc.Pits.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CarResource {
	private Integer id;
	private String tuition;
	private String brand;
	private String description;
	private String years;
}
