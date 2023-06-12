package pe.edu.upc.Pits.resource;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarResource {
	
	@NotNull
	@NotBlank
	@Min(1)
	private Integer id;
	
	@NotNull
	@NotBlank
	@Size(min = 6, max = 6)
	private String tuition;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String brand;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 60)
	private String description;
	
	@NotNull
	@NotBlank
	@Size(min = 4, max = 4)
	private String years;
	
}
