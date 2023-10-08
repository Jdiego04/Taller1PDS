package co.edu.poli.pds.taller1.taller1.controller;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Customer;
import co.edu.poli.pds.taller1.taller1.services.CustomerService;
import co.edu.poli.pds.taller1.taller1.services.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public void save(@RequestBody CustomerDTO customerDTO){
        service.save(customerDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(service.findById(id));
    }

    @GetMapping
    public List<Customer> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

}
