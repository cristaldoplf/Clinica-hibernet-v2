package clinica.consultorio.controller;

import clinica.consultorio.dto.AppointmentDTO;
import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.dto.PatientDTO;
import clinica.consultorio.service.impl.AppointmentService;
import clinica.consultorio.service.impl.DentistService;
import clinica.consultorio.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    PatientService patientService;
    @Autowired
    DentistService dentistService;

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable("id") Integer id) {
        AppointmentDTO newAppointment = appointmentService.findById(id);
        return new ResponseEntity<>(newAppointment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO newAppointment = appointmentService.create(appointmentDTO);
        return new ResponseEntity<>(newAppointment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        appointmentService.deleteById(id);
        return new ResponseEntity<>("Appointment eliminado",HttpStatus.OK);
    }

//    @PutMapping("/update")
//    public ResponseEntity<AppointmentDTO> update(@RequestBody AppointmentDTO appointmentDTO, @RequestParam String nameDentist, @RequestParam String namePatient) throws ServerException {
//        AppointmentDTO newApoointmentDTO = appointmentDTO;
////        if (newApoointmentDTO.getId() == null){
////            throw new ServerException("El request no trae id");
////        }
////        if(appointmentService.findById(newApoointmentDTO.getId()) == null){
////            throw new ServerException("Patient no encontrado");
////        }else{
//            //busco los ID por los parametros que entran en el endpoint.
//            newApoointmentDTO.setId_dentist(dentistService.getOdontologoByName(nameDentist).getId());
//            newApoointmentDTO.setId_patient(patientService.getPatientByName(namePatient).getId());
//
//            //update
//            AppointmentDTO updatedAppointment = appointmentService.update(newApoointmentDTO);
//            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
//        }
//    }

}
