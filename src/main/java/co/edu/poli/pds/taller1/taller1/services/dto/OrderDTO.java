package co.edu.poli.pds.taller1.taller1.services.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {

    private Date orderDate;

    private Long deliverId;

    private Long customerId;
}
