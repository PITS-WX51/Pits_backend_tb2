package pe.edu.upc.Pits.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentResource {
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String lastname_user;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String firstname_user;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String lastname_mechanic;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String firstname_mechanic;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 10)
	private String car;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 30)
	private String brand;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 60)
	private String description;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
}
