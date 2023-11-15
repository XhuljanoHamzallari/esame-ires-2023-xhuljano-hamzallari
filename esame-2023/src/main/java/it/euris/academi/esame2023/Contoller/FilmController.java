package it.euris.academi.esame2023.Contoller;

import it.euris.academi.esame2023.data.dto.CinemaRoomDTO;
import it.euris.academi.esame2023.data.dto.FilmDTO;
import it.euris.academi.esame2023.data.entity.CinemaRoom;
import it.euris.academi.esame2023.data.entity.Film;
import it.euris.academi.esame2023.exception.IdMustBeNullException;
import it.euris.academi.esame2023.exception.IdMustNotBeNullException;
import it.euris.academi.esame2023.service.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/films")
public class FilmController {
  private  FilmService filmService;
    @GetMapping("/get")
    public List<FilmDTO> getAllFilms(){
        return filmService.findAll().stream().map(Film::toDto).toList();
    }

    @PostMapping("/insert")
    public FilmDTO saveCinemaRoom(@RequestBody FilmDTO filmDTO) {
        try{
            Film film = filmDTO.toModel();
            return filmService.insert(film).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/update")
    public FilmDTO updateFilm(@RequestBody FilmDTO filmDTO){
        try{
            Film film = filmDTO.toModel();
            return filmService.update(film).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteFilm(@PathVariable("id") Integer idFilm) {
        return filmService.deleteById(idFilm);
    }

    @GetMapping("/find/{id}")
    public FilmDTO getFilmById(@PathVariable("id") Integer idFilm) {
        return filmService.findById(idFilm).toDto();
    }
}
