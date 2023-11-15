package it.euris.academi.esame2023.repository;

import it.euris.academi.esame2023.data.entity.Spectator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpectatorRepository extends JpaRepository<Spectator, Integer> {
}
