package clinica.consultorio.repositorio;

import clinica.consultorio.entidades.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdressRepository extends JpaRepository<Adress, Integer> {
}
