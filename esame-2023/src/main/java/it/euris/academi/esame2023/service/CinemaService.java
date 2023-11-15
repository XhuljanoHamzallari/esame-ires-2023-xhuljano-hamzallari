package it.euris.academi.esame2023.service;

import it.euris.academi.esame2023.data.entity.Cinema;

import java.util.List;

public interface CinemaService {
    List<Cinema> findAll();


    Cinema insert(Cinema cinema);

    Cinema update(Cinema cinema);

    Boolean deleteById(Integer idCinema);

    Cinema findById(Integer idCinema);
}
