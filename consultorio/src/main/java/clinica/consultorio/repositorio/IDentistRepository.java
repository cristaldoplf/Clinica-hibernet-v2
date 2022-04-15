package clinica.consultorio.repositorio;

import clinica.consultorio.entidades.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist,Integer> {

    //@Query("FROM Dentist o WHERE o.name = :name")
    //Dentist getDentistByName(@Param("name") String name);

    public Dentist findDentistByName(String nombre);
    //find+NombreClase+By+NombreAtributo
}
