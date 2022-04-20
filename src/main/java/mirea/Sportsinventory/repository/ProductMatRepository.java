package mirea.Sportsinventory.repository;

import mirea.Sportsinventory.entity.ProductMat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMatRepository extends JpaRepository<ProductMat, String> {
}