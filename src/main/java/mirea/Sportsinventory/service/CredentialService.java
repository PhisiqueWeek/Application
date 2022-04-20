package mirea.Sportsinventory.service;

import mirea.Sportsinventory.entity.Credential;
import mirea.Sportsinventory.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class CredentialService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Credential credential = credentialRepository.findById(login).orElse(null);
        if (credential == null)
            throw new UsernameNotFoundException("Login not found");
        return credential;
    }

    public Credential findUserById(String userId) {
        Optional<Credential> userFromDb = credentialRepository.findById(userId);
        return userFromDb.orElse(null);
    }

    public boolean saveCredential(Credential credential) {
        Credential credentialFromDB = credentialRepository.findById(credential.getUsername()).orElse(null);

        if (credentialFromDB != null) {
            return false;
        }

        credential.setPassword(bCryptPasswordEncoder.encode(credential.getPassword()));
        credentialRepository.save(credential);
        return true;
    }

    public boolean deleteCredential(String userId) {
        if (credentialRepository.findById(userId).isPresent()) {
            credentialRepository.deleteById(userId);
            return true;
        }
        return false;
    }


}
