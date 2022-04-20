package mirea.Sportsinventory.repository;

import mirea.Sportsinventory.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, String> {
    Optional<Credential> findById(String username);
}
