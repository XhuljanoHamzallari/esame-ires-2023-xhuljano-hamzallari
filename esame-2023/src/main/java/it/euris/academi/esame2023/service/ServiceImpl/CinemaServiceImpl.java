package it.euris.academi.esame2023.service.ServiceImpl;

import it.euris.academi.esame2023.data.entity.Cinema;
import it.euris.academi.esame2023.exception.IdMustBeNullException;
import it.euris.academi.esame2023.exception.IdMustNotBeNullException;
import it.euris.academi.esame2023.repository.CinemaRepository;
import it.euris.academi.esame2023.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CinemaServiceImpl implements CinemaService {

   private  CinemaRepository cinemaRepository;


    @Override
    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema insert(Cinema cinema) {
        if(cinema.getId() != null && cinema.getId() >0 ){
            throw new IdMustBeNullException();
        }
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema update(Cinema cinema) {
        if(cinema.getId() == null || cinema.getId() == 0){
            throw new IdMustNotBeNullException();
        }

            return cinemaRepository.save(cinema);
    }

    @Override
    public Boolean deleteById(Integer idCinema) {
        cinemaRepository.deleteById(idCinema);
        return cinemaRepository.findById(idCinema).isEmpty();
    }

    @Override
    public Cinema findById(Integer idCinema) {
        return cinemaRepository.findById(idCinema).orElse(Cinema.builder().build());
    }
}
