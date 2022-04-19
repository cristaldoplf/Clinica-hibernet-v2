package clinica.consultorio.service.impl;

import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {

//    @Autowired
//    IDentistService dentistService;
//
//    @Test
//    public void createDentistTest() {
//        DentistDTO dentist = new DentistDTO();
//        dentist.setName("TestCrearDentista1");
//        dentist.setLicenseNumber("LicenceTestDentista1");
//        dentist.setLastName("ApellidoDentistTest1");
//
//        DentistDTO newDentist = dentistService.create(dentist);
//        assertNotNull(newDentist);
//
//        assertNotNull(dentistService.findById(newDentist.getId()));
//    }
}