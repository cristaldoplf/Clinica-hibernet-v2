package clinica.consultorio.controller;

import clinica.consultorio.dto.AppointmentDTO;
import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.dto.PatientDTO;
import clinica.consultorio.service.impl.AppointmentService;
import clinica.consultorio.service.impl.DentistService;
import clinica.consultorio.service.impl.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.Set;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    private static final Logger logger = Logger.getLogger(AppointmentController.class);

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    PatientService patientService;
    @Autowired
    DentistService dentistService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable("id") Integer id) throws Exception {
        if (id < 1 || id == null){
            throw new Exception("El id es incorrecto");
        }
        AppointmentDTO newAppointment = appointmentService.findById(id);
        logger.info("Appointment con el id "+id+" buscado en la base de datos");
        return new ResponseEntity<>(newAppointment, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO newAppointment = appointmentService.create(appointmentDTO);
        logger.info("Appointment con el id "+newAppointment.getId()+" creado en la base de datos");
        return new ResponseEntity<>(newAppointment, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) throws Exception {
        if (id < 1 || id == null){
            throw new Exception("El id es incorrecto");
        }
        appointmentService.deleteById(id);
        logger.warn("Se intenta borrar el Appointment con el id "+id+" en la base de datos");
        return new ResponseEntity<>("Appointment eliminado",HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/update")
    public ResponseEntity<AppointmentDTO> update(@RequestBody AppointmentDTO appointmentDTO) throws Exception {
        if (appointmentDTO.getId() < 1 || appointmentDTO.getId() == null){
            throw new Exception("El id es incorrecto");
        }
            AppointmentDTO updateAppointment = appointmentService.update(appointmentDTO);
        logger.info("Se intenta actualizar el Appointment con el id "+appointmentDTO.getId()+" en la base de datos");
            return new ResponseEntity<>(updateAppointment, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<Set<AppointmentDTO>> findAll(){
        Set<AppointmentDTO> appointmentDTO_list = appointmentService.findAll();
        logger.info("Se intenta buscar la lista completa de Appointments en la base de datos");
        return new ResponseEntity<>(appointmentDTO_list,HttpStatus.OK);
    }
}
