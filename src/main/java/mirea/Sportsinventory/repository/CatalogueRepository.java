package mirea.Sportsinventory.repository;

import mirea.Sportsinventory.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogueRepository extends JpaRepository<Catalogue, String> {
    Optional<Catalogue> findById(String id);
}