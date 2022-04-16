package clinica.consultorio.dto;

import clinica.consultorio.entidades.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DentistDTO {

    private Integer id;
    private String name;
    private String lastName;
    private String licenseNumber;

}
