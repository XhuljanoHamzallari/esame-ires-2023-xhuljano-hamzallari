package it.euris.academi.esame2023.repository;

import it.euris.academi.esame2023.data.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
