package pe.edu.upc.Pits.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandResource {
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String name;

	@NotBlank
	@Size(min = 2, max = 60)
	private String description;

}
