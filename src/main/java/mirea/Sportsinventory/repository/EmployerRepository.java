package mirea.Sportsinventory.repository;

import mirea.Sportsinventory.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, String> {
}