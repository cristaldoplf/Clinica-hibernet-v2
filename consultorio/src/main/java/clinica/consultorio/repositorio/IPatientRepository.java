package clinica.consultorio.repositorio;

import clinica.consultorio.entidades.Dentist;
import clinica.consultorio.entidades.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {

    public Patient findPatientByName(String name);
    public Patient findPatientByEmail(String email);
    //find+NombreClase+By+NombreAtributo
    //hay un ejemplo de otra forma de armarlo en IDentistRepository por si este no funciona.
}
