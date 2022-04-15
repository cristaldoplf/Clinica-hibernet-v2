package clinica.consultorio.dto;

import clinica.consultorio.entidades.Adress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Integer id;
    private String lastname;
    private String name;
    private String email;
    private int dni;
    private LocalDate admissionDate;
    private Adress adress;
}
