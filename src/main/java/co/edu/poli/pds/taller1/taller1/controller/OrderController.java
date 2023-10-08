package co.edu.poli.pds.taller1.taller1.controller;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Order;
import co.edu.poli.pds.taller1.taller1.services.OrderService;
import co.edu.poli.pds.taller1.taller1.services.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public void save(@RequestBody OrderDTO orderDTO){
        service.save(orderDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(service.findById(id));
    }

    @GetMapping
    public List<Order> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping("/customer/{id}")
    public List<Order> findByCustomer(@PathVariable("id") Long id){
        return service.findByCustomer(id);
    }

    @GetMapping("/delivery/{id}")
    public List<Order> findByDelivery(@PathVariable("id") Long id){
        return service.findByDelivery(id);
    }
}
