package clinica.consultorio.controller;


import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.dto.PatientDTO;
import clinica.consultorio.service.impl.PatientService;
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

    @Autowired
    PatientService patientService;

    @GetMapping("/{id}")
    ResponseEntity<PatientDTO> findById(@PathVariable("id") Integer id) {
        PatientDTO patientDTO = patientService.findById(id);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<PatientDTO> create(@RequestBody PatientDTO patientDTO) {
        PatientDTO newPatientDTO = patientService.create(patientDTO);
        return new ResponseEntity<>(newPatientDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        patientService.deleteById(id);
        return new ResponseEntity<>("Patient eliminado", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<PatientDTO> update(@RequestBody PatientDTO patientDTO) {

        PatientDTO updatePatient = patientService.update(patientDTO);
        return new ResponseEntity<>(updatePatient, HttpStatus.OK);

    }

    @GetMapping("/list")
    public ResponseEntity<Set<PatientDTO>> findAll() {
        Set<PatientDTO> patientDTO_list = patientService.findAll();
        return new ResponseEntity<>(patientDTO_list, HttpStatus.OK);
    }


}
