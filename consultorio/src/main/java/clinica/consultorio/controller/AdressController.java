package clinica.consultorio.controller;

import clinica.consultorio.dto.AdressDTO;
import clinica.consultorio.service.impl.AdressService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/adress")
public class AdressController {

    private static final Logger logger = Logger.getLogger(AdressController.class);

    @Autowired
    private AdressService adressService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<AdressDTO> findById(@PathVariable("id") Integer id) throws Exception {
        if (id < 1 || id == null){
            throw new Exception("El id es incorrecto");
        }
        AdressDTO adressDTO = adressService.findById(id);
        logger.info("Adress con el id "+id+" buscada en la base de datos");
        return new ResponseEntity<>(adressDTO, HttpStatus.OK);
    }
//los otros controller
//    @PostMapping
//    public ResponseEntity<AdressDTO> create(@RequestBody AdressDTO adressDTO) {
//        AdressDTO newAdressDTO = adressService.create(adressDTO);
//        return new ResponseEntity<>(newAdressDTO, HttpStatus.OK);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
//        adressService.deleteById(id);
//        return new ResponseEntity<>("Adress Eliminado", HttpStatus.OK);
//    }

//    @PutMapping("/update")
//    public ResponseEntity<AdressDTO> update(@RequestBody AdressDTO adressDTO) throws ServerException {
//        if (adressDTO.getId() == null) {
//            throw new ServerException("El request no trae id");
//        }
//        if (adressService.findById(adressDTO.getId()) == null) {
//            throw new ServerException("Adress no encontrado");
//        } else {
//            AdressDTO updateAdress = adressService.update(adressDTO);
//            return new ResponseEntity<>(updateAdress, HttpStatus.OK);
//        }
//    }
@CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<Set<AdressDTO>> findAll() {
        Set<AdressDTO> adressDTO_list = adressService.findAll();
        logger.info("Lista completa de Adress buscada en la base de datos.");
        return new ResponseEntity<>(adressDTO_list, HttpStatus.OK);
    }


}
