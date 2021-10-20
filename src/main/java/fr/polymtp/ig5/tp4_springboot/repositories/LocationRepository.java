package fr.polymtp.ig5.tp4_springboot.repositories;

import fr.polymtp.ig5.tp4_springboot.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> { }
