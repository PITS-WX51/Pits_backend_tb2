package pe.edu.upc.Pits.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResource {
	private Integer id;
	private String lastname_user;
	private String firstname_user;
	private String lastname_mechanic;
	private String firstname_mechanic;
	private String car;
	private String brand;
	private String description;
	private String date;
}
