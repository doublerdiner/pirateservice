package com.codeclan.pirateservice.repositories;

import com.codeclan.pirateservice.models.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findShipsByPiratesFirstName(String firstName);
}
