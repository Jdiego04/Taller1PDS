package co.edu.poli.pds.taller1.taller1.mapper;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Order;
import co.edu.poli.pds.taller1.taller1.services.CustomerService;
import co.edu.poli.pds.taller1.taller1.services.DeliveryService;
import co.edu.poli.pds.taller1.taller1.services.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderDTOToOrder implements IMapper<OrderDTO, Order> {

    private final DeliveryService deliveryService;
    private final CustomerService customerService;

    @Override
    public Order mapper(OrderDTO orderDTO) {
        Order order = new Order();

        order.setOrderDate(orderDTO.getOrderDate());
        order.setDelivery(deliveryService.findById(orderDTO.getDeliverId()));
        order.setCustomer(customerService.findById(orderDTO.getCustomerId()));

        return order;
    }
}
