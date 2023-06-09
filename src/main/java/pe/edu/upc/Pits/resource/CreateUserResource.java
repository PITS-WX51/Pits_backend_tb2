package pe.edu.upc.Pits.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResource {
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
