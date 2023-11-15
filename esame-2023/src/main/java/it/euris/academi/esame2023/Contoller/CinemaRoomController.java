package it.euris.academi.esame2023.Contoller;

import it.euris.academi.esame2023.data.dto.CinemaRoomDTO;
import it.euris.academi.esame2023.data.entity.CinemaRoom;
import it.euris.academi.esame2023.exception.IdMustBeNullException;
import it.euris.academi.esame2023.exception.IdMustNotBeNullException;
import it.euris.academi.esame2023.service.CinemaRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rooms")
public class CinemaRoomController {
    private CinemaRoomService cinemaRoomService;
    @GetMapping("/get")
    public List<CinemaRoomDTO> getAllCinemas(){
        return cinemaRoomService.findAll().stream().map(CinemaRoom::toDto).toList();
    }

    @PostMapping("/insert")
    public CinemaRoomDTO saveCinemaRoom(@RequestBody CinemaRoomDTO cinemaRoomDTO) {
        try{
            CinemaRoom cinemaRoom = cinemaRoomDTO.toModel();
            return cinemaRoomService.insert(cinemaRoom).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/update")
    public CinemaRoomDTO updateCinemaRoom(@RequestBody CinemaRoomDTO cinemaRoomDTO){
        try{
            CinemaRoom cinemaRoom = cinemaRoomDTO.toModel();
            return cinemaRoomService.update(cinemaRoom).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteCinemaRoom(@PathVariable("id") Integer idCinemaRoom) {
        return cinemaRoomService.deleteById(idCinemaRoom);
    }

    @GetMapping("/find/{id}")
    public CinemaRoomDTO getCinemaRoomById(@PathVariable("id") Integer idCinemaRoom) {
        return cinemaRoomService.findById(idCinemaRoom).toDto();
    }
}
