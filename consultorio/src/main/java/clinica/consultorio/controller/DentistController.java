package clinica.consultorio.controller;

import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.service.impl.DentistService;
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

    @Autowired
    private DentistService dentistService;

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> findById(@PathVariable("id") Integer id) {
        DentistDTO dentistDTO = dentistService.findById(id);
        return new ResponseEntity<>(dentistDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DentistDTO> create(@RequestBody DentistDTO dentistDTO) {
        DentistDTO newDentistDTO = dentistService.create(dentistDTO);
        return new ResponseEntity<>(newDentistDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        dentistService.deleteById(id);
        return new ResponseEntity<>("Dentist eliminado", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DentistDTO> update(@RequestBody DentistDTO dentistDTO) throws ServerException{
        if (dentistDTO.getId() == null){
            throw new ServerException("El request no trae id");
        }
        if(dentistService.findById(dentistDTO.getId()) == null){
            throw new ServerException("Dentist no encontrado");
        }else{
            DentistDTO updateDentist = dentistService.update(dentistDTO);
            return new ResponseEntity<>(updateDentist, HttpStatus.OK);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Set<DentistDTO>> findAll(){
        Set<DentistDTO> dentistDTOList = dentistService.findAll();
        return new ResponseEntity<>(dentistDTOList,HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<DentistDTO> findByName(@RequestParam String name){
        DentistDTO dentistDTO = dentistService.getOdontologoByName(name);
        return new ResponseEntity<>(dentistDTO,HttpStatus.OK);
    }


}
