package clinica.consultorio.controller;


import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.dto.PatientDTO;
import clinica.consultorio.service.impl.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/patient")
public class PatientController {

    private static final Logger logger = Logger.getLogger(PatientController.class);

    @Autowired
    PatientService patientService;

    @CrossOrigin
    @GetMapping("/{id}")
    ResponseEntity<PatientDTO> findById(@PathVariable("id") Integer id) throws Exception {
        if (id < 1 || id == null){
            throw new Exception("El id es incorrecto");
        }
        PatientDTO patientDTO = patientService.findById(id);
        logger.info("Patient con el id " + id + " buscado en la base de datos");
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    ResponseEntity<PatientDTO> create(@RequestBody PatientDTO patientDTO) {
        PatientDTO newPatientDTO = patientService.create(patientDTO);
        logger.info("Patient con el id " + newPatientDTO.getId() + " creado en la base de datos");
        return new ResponseEntity<>(newPatientDTO, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteById(@PathVariable("id") Integer id) throws Exception {
        if (id < 1 || id == null){
            throw new Exception("El id es incorrecto");
        }
        patientService.deleteById(id);
        logger.warn("Se intenta borrar el Patient con el id " + id + " en la base de datos");
        return new ResponseEntity<>("Patient eliminado", HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<PatientDTO> update(@RequestBody PatientDTO patientDTO) throws Exception {
        if (patientDTO.getId() < 1 || patientDTO.getId() == null){
            throw new Exception("El id es incorrecto");
        }
        PatientDTO updatePatient = patientService.update(patientDTO);
        logger.info("Se intenta actualizar el Patient con el id " + updatePatient.getId() + " en la base de datos");
        return new ResponseEntity<>(updatePatient, HttpStatus.OK);

    }

    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<Set<PatientDTO>> findAll() {
        Set<PatientDTO> patientDTO_list = patientService.findAll();
        logger.info("Se intenta buscar la lista completa de Patients en la base de datos");
        return new ResponseEntity<>(patientDTO_list, HttpStatus.OK);
    }


}
