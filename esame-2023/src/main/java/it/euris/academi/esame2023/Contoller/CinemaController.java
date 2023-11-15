package it.euris.academi.esame2023.Contoller;

import it.euris.academi.esame2023.data.dto.CinemaDTO;
import it.euris.academi.esame2023.data.entity.Cinema;
import it.euris.academi.esame2023.exception.IdMustBeNullException;
import it.euris.academi.esame2023.exception.IdMustNotBeNullException;
import it.euris.academi.esame2023.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/cinemas")
public class CinemaController {
  private  CinemaService cinemaService;

 @GetMapping("/get")
  public List<CinemaDTO> getAllCinema(){
   return cinemaService.findAll().stream().map(Cinema::toDto).toList();
 }

  @PostMapping("/v1")
  public CinemaDTO saveCinema(@RequestBody CinemaDTO cinemaDTO) {
    try{
      Cinema cinema = cinemaDTO.toModel();
      return cinemaService.insert(cinema).toDto();
    }
    catch(IdMustBeNullException e) {
      throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/update")
  public CinemaDTO updateCinema(@RequestBody CinemaDTO cinemaDTO){
    try{
      Cinema cinema = cinemaDTO.toModel();
      return cinemaService.update(cinema).toDto();
    }
    catch(IdMustNotBeNullException e) {
      throw new ResponseStatusException(
              HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @DeleteMapping("/v1/{id}")
  public Boolean deleteCinema(@PathVariable("id") Integer idCinema) {
    return cinemaService.deleteById(idCinema);
  }

  @GetMapping("/find/{id}")
  public CinemaDTO getCinemaById(@PathVariable("id") Integer idCinema) {
    return cinemaService.findById(idCinema).toDto();
  }
}
