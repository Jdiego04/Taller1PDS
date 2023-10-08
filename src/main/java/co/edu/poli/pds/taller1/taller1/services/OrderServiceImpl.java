package co.edu.poli.pds.taller1.taller1.services;

import co.edu.poli.pds.taller1.taller1.mapper.OrderDTOToOrder;
import co.edu.poli.pds.taller1.taller1.persistence.entity.Order;
import co.edu.poli.pds.taller1.taller1.persistence.repository.OrderRepository;
import co.edu.poli.pds.taller1.taller1.services.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderDTOToOrder orderDTOToOrder;

    private final CustomerService customerService;

    private final DeliveryService deliveryService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(OrderDTO orderDTO) {
        repository.save(orderDTOToOrder.mapper(orderDTO));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Order order) {
        repository.delete(order);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findByCustomer(Long id) {
        return repository.findByCustomer(customerService.findById(id));
    }

    @Override
    public List<Order> findByDelivery(Long id) {
        return repository.findByDelivery(deliveryService.findById(id));
    }
}
