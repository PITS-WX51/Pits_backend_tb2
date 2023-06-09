package pe.edu.upc.Pits.resource;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResource {
	@NotNull
	@NotBlank
	@Min(1)
	private Integer id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String lastname;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String firstname;
	
	@NotNull
	@NotBlank
	@Size(min = 9, max = 9)
	private String contactnumber;
	
	@NotNull
	@NotBlank
	@Size(min = 8, max = 8)
	private String dni;
}
