package mirea.Sportsinventory.repository;

import mirea.Sportsinventory.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, String> {
}