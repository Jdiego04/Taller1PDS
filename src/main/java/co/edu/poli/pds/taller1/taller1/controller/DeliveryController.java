package co.edu.poli.pds.taller1.taller1.controller;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Delivery;
import co.edu.poli.pds.taller1.taller1.services.DeliveryService;
import co.edu.poli.pds.taller1.taller1.services.dto.DeliveryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService service;

    @PostMapping
    public void save(@RequestBody DeliveryDTO deliveryDTO){
        service.save(deliveryDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(service.findById(id));
    }

    @GetMapping
    public List<Delivery> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Delivery findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

}
