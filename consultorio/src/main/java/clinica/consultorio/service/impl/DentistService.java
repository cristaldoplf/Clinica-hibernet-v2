package clinica.consultorio.service.impl;

import clinica.consultorio.dto.AppointmentDTO;
import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.entidades.Appointment;
import clinica.consultorio.entidades.Dentist;
import clinica.consultorio.repositorio.IDentistRepository;
import clinica.consultorio.service.IDentistService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DentistService implements IDentistService {

    @Autowired
    private IDentistRepository dentistRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public DentistDTO findById(@NotNull Integer id) {
        Dentist dentist = dentistRepository.getById(id);
        DentistDTO newDentistDTO = mapToDTO(dentist);

        return newDentistDTO;
    }

    @Override
    public DentistDTO create(@NotNull DentistDTO dentistDTO) {
        //DTO recibiendo por parametro
        //1- DTO convertir a entidad
        Dentist dentist = mapToEntity(dentistDTO);
        //2- la entidad guardamos en la base de datos
        Dentist newDentistSave = dentistRepository.save(dentist);
        //3- entidad guardad en la base de datos retornamos como DTO
        return mapToDTO(newDentistSave);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        //1- buscar la entidad
        //2- verificar que se encontro
        //3- eliminarla
        Dentist dentist = dentistRepository.getById(id);
        dentistRepository.delete(dentist);

    }

    @Override
    public DentistDTO update(DentistDTO dentistDTO) {
        //mapeamos el DTO que entra a una entidad, la persistimos
        //y despues lo que devuelve el save lo mapeamos a DTO para devolverlo.
        Dentist dentist = mapToEntity(dentistDTO);
        Dentist newDentistSave = dentistRepository.save(dentist);
        return mapToDTO(newDentistSave);
    }

    @Override
    public Set<DentistDTO> findAll() {
        List<Dentist> dentist_list = dentistRepository.findAll();

        Set<DentistDTO> dentistDTO_list = new HashSet<DentistDTO>();

        for(Dentist dent:dentist_list){
            dentistDTO_list.add(mapToDTO(dent));
        }

        return dentistDTO_list;

        //        Set<Dentist> dentist_list = dentistRepository.findAll();
//        Set<DentistDTO> dentistDTOS_list = dentist_list.stream().map(odo -> mapToDTO(odo)).collect(Collectors.toList());
//        return dentistDTOS_list;
    }

    @Override
    public DentistDTO getOdontologoByName(String name) {
        Dentist dentist = dentistRepository.findDentistByName(name);
        return mapToDTO(dentist);
    }

    //------ MAPPER -----
    private DentistDTO mapToDTO(Dentist dentist){
        DentistDTO dentistDTO = modelMapper.map(dentist, DentistDTO.class);

        return dentistDTO;
    }

    private Dentist mapToEntity(DentistDTO dentistDTO){
        Dentist dentist = modelMapper.map(dentistDTO, Dentist.class);

        return dentist;
    }



}
