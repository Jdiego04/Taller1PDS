package co.edu.poli.pds.taller1.taller1.services;

import co.edu.poli.pds.taller1.taller1.mapper.DeliveryDTOToDelivery;
import co.edu.poli.pds.taller1.taller1.persistence.entity.Delivery;
import co.edu.poli.pds.taller1.taller1.persistence.repository.DeliveryRepository;
import co.edu.poli.pds.taller1.taller1.services.dto.DeliveryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository repository;
    private final DeliveryDTOToDelivery deliveryDTOToDelivery;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(DeliveryDTO deliveryDTO) {
        if (deliveryDTO.getDuration() >= 1 && deliveryDTO.getDuration() <=60){
            repository.save(deliveryDTOToDelivery.mapper(deliveryDTO));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Delivery delivery) {
        repository.delete(delivery);
    }

    @Override
    public List<Delivery> findAll() {
        return repository.findAll();
    }

    @Override
    public Delivery findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
