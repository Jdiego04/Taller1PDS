package co.edu.poli.pds.taller1.taller1.persistence.repository;

import co.edu.poli.pds.taller1.taller1.persistence.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
