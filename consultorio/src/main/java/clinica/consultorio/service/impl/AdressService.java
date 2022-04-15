package clinica.consultorio.service.impl;

import clinica.consultorio.dto.AdressDTO;
import clinica.consultorio.entidades.Adress;
import clinica.consultorio.repositorio.IAdressRepository;
import clinica.consultorio.service.IAdressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdressService implements IAdressService {

    @Autowired
    private IAdressRepository adressRepository;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    ObjectMapper objectMapper;

    @Override
    public AdressDTO findById(@NotNull Integer id) {
        Adress adress = adressRepository.getById(id);
        AdressDTO newAdress = mapToDTO(adress);
        return newAdress;


    }

    @Override
    public AdressDTO create(AdressDTO adressDTO) {
        Adress adress = mapToEntity(adressDTO);
        //save devuelve lo que creo, por eso lo guardamos y lo mapeamos, es la devolucion
        //del save, no el mismo objeto que entra por parametro.
        Adress newAdress = adressRepository.save(adress);
        return mapToDTO(newAdress);
    }

    @Override
    public void deleteById(Integer id) {
        //1- buscar la entidad
        //2- verificar que se encontro
        //3- eliminarla
        Adress adress = adressRepository.getById(id);
        adressRepository.delete(adress);
    }

    @Override
    public AdressDTO update(AdressDTO adressDTO) {
        Adress adress = mapToEntity(adressDTO);
        Adress newAdress = adressRepository.save(adress);
        return mapToDTO(newAdress);
    }


    @Override
    public Set<AdressDTO> findAll() {
        List<Adress> adress_list = adressRepository.findAll();

        Set<AdressDTO> adressDTO_list = new HashSet<AdressDTO>();

        for (Adress adress: adress_list){
            adressDTO_list.add(mapToDTO(adress));
        }

        return adressDTO_list;

        //Set<Adress> adress_list = adressRepository.findAll();
        //Set<AdressDTO> adressDTO_list = adress_list.stream().map(adress -> mapToDTO(adress)).collect(Collectors.toList());
        //return adressDTO_list;
    }

    //------ MAPPER -----
    private AdressDTO mapToDTO(Adress adress){
        AdressDTO adressDTO = modelMapper.map(adress, AdressDTO.class);

        return adressDTO;
    }

    private Adress mapToEntity(AdressDTO adressDTO){
        Adress adress = modelMapper.map(adressDTO, Adress.class);

        return adress;
    }

//    private AdressDTO mapToDTO(Adress adress){
//        AdressDTO adressDTO = new AdressDTO();
//        if (adress.getId() != null){
//            adress.setId(adress.getId());
//        }
//        adressDTO.setStreet(adress.getStreet());
//        adressDTO.setAdressNumber(adress.getAdressNumber());
//        adressDTO.setTown(adress.getTown());
//        adressDTO.setProvince(adress.getProvince());
//
//        return adressDTO;
//    }
//
//    private Adress mapToEntity(AdressDTO adressDTO){
//        Adress adress = new Adress();
//        if (adressDTO.getId() != null){
//            adress.setId(adressDTO.getId());
//        }
//        adress.setStreet(adressDTO.getStreet());
//        adress.setAdressNumber(adressDTO.getAdressNumber());
//        adress.setTown(adressDTO.getTown());
//        adress.setProvince(adressDTO.getProvince());
//
//        return adress;
//    }


}


