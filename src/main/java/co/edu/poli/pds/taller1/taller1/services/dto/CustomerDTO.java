package co.edu.poli.pds.taller1.taller1.services.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO {

    private String name;

    private String email;

    private Date birthdate;
}
