package it.euris.academi.esame2023.repository;

import it.euris.academi.esame2023.data.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository  extends JpaRepository<Cinema, Integer> {
}
