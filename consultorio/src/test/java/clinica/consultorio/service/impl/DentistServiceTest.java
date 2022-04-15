package clinica.consultorio.service.impl;

import clinica.consultorio.dto.DentistDTO;
import clinica.consultorio.service.IDentistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {

    @Autowired
    IDentistService dentistService;

    @Test
    public void createDentistTest() {
        DentistDTO dentist = new DentistDTO();
        dentist.setLastName("TestCrearDentista");
        dentist.setLicenceNumber("LicenceTestDentista");
        dentist.setLastName("ApellidoDentistTest");

        DentistDTO newDentist = dentistService.create(dentist);
        assertNotNull(newDentist);

//        assertNotNull(dentistService.findById(newDentist.getId()));
    }
}