package pe.edu.upc.Pits.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class MechanicResource {

    private Integer id;
    private String lastName;
    private String firstName;
    private String dni;
    private String yearsJob;
}
