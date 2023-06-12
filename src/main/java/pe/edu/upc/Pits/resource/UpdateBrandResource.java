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
public class UpdateBrandResource {
	
	@NotNull
	@NotBlank
	@Min(1)
	private Integer id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String name;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 60)
	private String description;
	
}
