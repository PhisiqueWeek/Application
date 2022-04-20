package mirea.Sportsinventory.repository;

import mirea.Sportsinventory.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, String> {
}