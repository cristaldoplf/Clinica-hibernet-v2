package clinica.consultorio.controller;

import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.service.impl.DentistService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/dentist")
public class DentistController {

    private static final Logger logger = Logger.getLogger(DentistController.class);

    @Autowired
    private DentistService dentistService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> findById(@PathVariable("id") Integer id) throws Exception {
        if (id < 1 || id == null){
            throw new Exception("El id es incorrecto");
        }
        DentistDTO dentistDTO = dentistService.findById(id);
        logger.info("Dentist con el id " + id + " buscado en la base de datos");
        return new ResponseEntity<>(dentistDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<DentistDTO> create(@RequestBody DentistDTO dentistDTO) {
        DentistDTO newDentistDTO = dentistService.create(dentistDTO);
        logger.info("Dentist con el id " + newDentistDTO.getId() + " creado en la base de datos");
        return new ResponseEntity<>(newDentistDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) throws Exception {
        if (id < 1 || id == null){
            throw new Exception("El id es incorrecto");
        }
        dentistService.deleteById(id);
        logger.warn("Se intenta borrar el Dentist con el id " + id + " en la base de datos");
        return new ResponseEntity<>("Dentist eliminado", HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<DentistDTO> update(@RequestBody DentistDTO dentistDTO) throws Exception {
        if (dentistDTO.getId() < 1 || dentistDTO.getId() == null){
            throw new Exception("El id es incorrecto");
        }
        DentistDTO updateDentist = dentistService.update(dentistDTO);
        logger.info("Se intenta actualizar el Dentist con el id " + updateDentist.getId() + " en la base de datos");
        return new ResponseEntity<>(updateDentist, HttpStatus.OK);

    }

    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<Set<DentistDTO>> findAll() {
        Set<DentistDTO> dentistDTOList = dentistService.findAll();
        logger.info("Se intenta buscar la lista completa de Dentists en la base de datos");
        return new ResponseEntity<>(dentistDTOList, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/name")
    public ResponseEntity<DentistDTO> findByName(@RequestParam String name) throws Exception {
        if (name.length() < 1 || name == null){
            throw new Exception("El id es incorrecto");
        }
        DentistDTO dentistDTO = dentistService.getOdontologoByName(name);
        logger.info("Se busca un doctor ocn le nombre " + name + " en la base de datos");
        return new ResponseEntity<>(dentistDTO, HttpStatus.OK);
    }


}
