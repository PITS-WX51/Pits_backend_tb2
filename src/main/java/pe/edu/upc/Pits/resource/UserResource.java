package pe.edu.upc.Pits.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
	private Integer id;
	private String lastname;
	private String firstname;
	private String contactnumber;
	private String dni;
}
