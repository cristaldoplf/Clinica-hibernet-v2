package clinica.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdressDTO {

    private Integer id;
    private String street;
    private String adressNumber;
    private String town;
    private String province;
}
