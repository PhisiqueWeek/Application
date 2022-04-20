package mirea.Sportsinventory.repository;

import mirea.Sportsinventory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}