package pe.edu.upc.Pits.resource;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateMechanicResource {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    private String contactNumber;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 8)
    private String dni;

    @NotNull
    @NotBlank
    private String yearsJob;
}
