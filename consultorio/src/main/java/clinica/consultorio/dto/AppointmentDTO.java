package clinica.consultorio.dto;

import clinica.consultorio.entidades.Dentist;
import clinica.consultorio.entidades.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentDTO {

    private Integer id;
    private LocalDate fecha;
    private Time hora;
    private Dentist dentist;
    private Patient patient;
}
