package it.euris.academi.esame2023.Contoller;

import it.euris.academi.esame2023.data.dto.SpectatorDTO;
import it.euris.academi.esame2023.data.entity.Spectator;
import it.euris.academi.esame2023.exception.IdMustBeNullException;
import it.euris.academi.esame2023.exception.IdMustNotBeNullException;
import it.euris.academi.esame2023.service.SpectatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/spectators" )
public class SpectatorController {
private SpectatorService spectatorService;
    @GetMapping("/get")
    public List<SpectatorDTO> getAllSpectator(){
        return spectatorService.findAll().stream().map(Spectator::toDto).toList();
    }

    @PostMapping("/insert")
    public SpectatorDTO saveSpectator(@RequestBody SpectatorDTO spectatorDTO) {
        try{
            Spectator spectator = spectatorDTO.toModel();
            return spectatorService.insert(spectator).toDto();
        }
        catch(IdMustBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/update")
    public SpectatorDTO updateSpectator(@RequestBody SpectatorDTO spectatorDTO){
        try{
            Spectator spectator = spectatorDTO.toModel();
            return spectatorService.update(spectator).toDto();
        }
        catch(IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteSpectator(@PathVariable("id") Integer idSpectator) {
        return spectatorService.deleteById(idSpectator);
    }

    @GetMapping("/find/{id}")
    public SpectatorDTO getvById(@PathVariable("id") Integer idSpectator) {
        return spectatorService.findById(idSpectator).toDto();
    }
}
