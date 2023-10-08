package co.edu.poli.pds.taller1.taller1.persistence.repository;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Customer;
import co.edu.poli.pds.taller1.taller1.persistence.entity.Delivery;
import co.edu.poli.pds.taller1.taller1.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);

    List<Order> findByDelivery(Delivery delivery);
}
