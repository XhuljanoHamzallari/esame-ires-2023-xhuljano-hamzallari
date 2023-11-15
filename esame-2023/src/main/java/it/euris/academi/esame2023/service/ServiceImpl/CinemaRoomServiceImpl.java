package it.euris.academi.esame2023.service.ServiceImpl;

import it.euris.academi.esame2023.data.entity.CinemaRoom;
import it.euris.academi.esame2023.exception.IdMustBeNullException;
import it.euris.academi.esame2023.exception.IdMustNotBeNullException;
import it.euris.academi.esame2023.repository.CinemaRoomRepository;
import it.euris.academi.esame2023.service.CinemaRoomService;

import java.util.List;

public class CinemaRoomServiceImpl implements CinemaRoomService {

private CinemaRoomRepository cinemaRoomRepository;
    @Override
    public List<CinemaRoom> findAll() {
        return cinemaRoomRepository.findAll();
    }

    @Override
    public CinemaRoom insert(CinemaRoom cinemaRoom) {
        if(cinemaRoom.getId() != null && cinemaRoom.getId() > 0) {
            throw new IdMustBeNullException();
        }
        return cinemaRoomRepository.save(cinemaRoom);
    }

    @Override
    public CinemaRoom update(CinemaRoom cinemaRoom) {
        if(cinemaRoom.getId() == null || cinemaRoom.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return cinemaRoomRepository.save(cinemaRoom);
    }

    @Override
    public Boolean deleteById(Integer idCinemaRoom) {
        cinemaRoomRepository.deleteById(idCinemaRoom);

        return cinemaRoomRepository.findById(idCinemaRoom).isEmpty();
    }

    @Override
    public CinemaRoom findById(Integer idCinemaRoom) {
        return cinemaRoomRepository.findById(idCinemaRoom).orElse(CinemaRoom.builder().build());
    }
}
