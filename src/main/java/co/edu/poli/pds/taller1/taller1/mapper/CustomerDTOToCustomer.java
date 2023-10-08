package co.edu.poli.pds.taller1.taller1.mapper;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Customer;
import co.edu.poli.pds.taller1.taller1.services.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOToCustomer implements IMapper<CustomerDTO, Customer> {

    @Override
    public Customer mapper(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setBirthdate(customerDTO.getBirthdate());

        return customer;
    }
}
