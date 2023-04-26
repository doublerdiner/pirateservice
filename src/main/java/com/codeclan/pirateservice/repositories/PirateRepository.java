package com.codeclan.pirateservice.repositories;

import com.codeclan.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long> {
    List<Pirate> findPiratesByLastName(String name);

    List<Pirate> findPiratesByAgeGreaterThan(int age);

    List<Pirate> findPiratesByRaidsId(Long Id);

    List<Pirate> findPiratesByFirstName(String name);
}
