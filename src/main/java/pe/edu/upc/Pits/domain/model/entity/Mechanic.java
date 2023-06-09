package pe.edu.upc.Pits.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name= "mechanics")
@Getter
@Setter
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 30, message = "El Apellido debe contar entre 2 y 30 caracteres")
    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "first_name", length = 30)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 8)
    @Column(name = "dni", columnDefinition = "char(8)", nullable = false)
    private String dni;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    @Column(name = "contact_number", columnDefinition = "char(9)", nullable = false)
    private String contactNumber;

    @NotNull
    @NotBlank
    @Column(name = "yearsJob", nullable = false)
    private String yearsJob;
}
