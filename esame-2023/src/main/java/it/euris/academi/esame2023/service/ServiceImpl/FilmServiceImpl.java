package it.euris.academi.esame2023.service.ServiceImpl;

import it.euris.academi.esame2023.data.entity.Film;
import it.euris.academi.esame2023.exception.IdMustBeNullException;
import it.euris.academi.esame2023.exception.IdMustNotBeNullException;
import it.euris.academi.esame2023.repository.FilmRepository;
import it.euris.academi.esame2023.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FilmServiceImpl implements FilmService {
    private FilmRepository filmRepository;
    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film insert(Film film) {
        if(film.getId() != null && film.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return filmRepository.save(film);
    }

    @Override
    public Film update(Film film) {
        if(film.getId() == null || film.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return filmRepository.save(film);
    }

    @Override
    public Boolean deleteById(Integer idFilm) {
        filmRepository.deleteById(idFilm);
        return filmRepository.findById(idFilm).isEmpty();
    }

    @Override
    public Film findById(Integer idFilm) {
        return filmRepository.findById(idFilm).orElse(Film.builder().build());
    }
}
