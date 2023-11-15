package it.euris.academi.esame2023.service;

import it.euris.academi.esame2023.data.entity.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll();

    Film insert(Film film);

    Film update(Film film);

    Boolean deleteById(Integer idFilm);

    Film findById(Integer idFilm);
}
