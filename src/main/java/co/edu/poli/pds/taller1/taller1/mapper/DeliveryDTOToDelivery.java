package co.edu.poli.pds.taller1.taller1.mapper;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Company;
import co.edu.poli.pds.taller1.taller1.persistence.entity.Delivery;
import co.edu.poli.pds.taller1.taller1.persistence.entity.Type;
import co.edu.poli.pds.taller1.taller1.services.dto.DeliveryDTO;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DeliveryDTOToDelivery implements IMapper<DeliveryDTO, Delivery> {

    @Override
    public Delivery mapper(DeliveryDTO deliveryDTO) {
        Delivery delivery = new Delivery();

        delivery.setCompany(Company.values()[new Random().nextInt(Company.values().length)]);
        delivery.setDuration(deliveryDTO.getDuration());
        delivery.setType(Type.ORDER);

        return delivery;
    }

}
