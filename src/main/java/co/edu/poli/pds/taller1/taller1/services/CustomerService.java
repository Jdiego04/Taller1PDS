package co.edu.poli.pds.taller1.taller1.services;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Customer;
import co.edu.poli.pds.taller1.taller1.services.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void save(CustomerDTO customer);

    void delete(Customer customer);

    List<Customer> findAll();

    Customer findById(Long id);

}
