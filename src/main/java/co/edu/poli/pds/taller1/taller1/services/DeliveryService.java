package co.edu.poli.pds.taller1.taller1.services;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Delivery;
import co.edu.poli.pds.taller1.taller1.services.dto.DeliveryDTO;

import java.util.List;

public interface
DeliveryService {

    void save(DeliveryDTO deliveryDTO);

    void delete(Delivery delivery);

    List<Delivery> findAll();

    Delivery findById(Long id);

}
