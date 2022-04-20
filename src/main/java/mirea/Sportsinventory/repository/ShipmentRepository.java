package mirea.Sportsinventory.repository;

import mirea.Sportsinventory.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, String> {
}