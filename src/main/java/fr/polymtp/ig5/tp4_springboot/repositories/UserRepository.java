package fr.polymtp.ig5.tp4_springboot.repositories;

import fr.polymtp.ig5.tp4_springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
