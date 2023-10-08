package co.edu.poli.pds.taller1.taller1.services;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Order;
import co.edu.poli.pds.taller1.taller1.services.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    void save(OrderDTO order);

    void delete(Order order);

    List<Order> findAll();

    Order findById(Long id);

    List<Order> findByCustomer(Long id);

    List<Order> findByDelivery(Long id);
}
