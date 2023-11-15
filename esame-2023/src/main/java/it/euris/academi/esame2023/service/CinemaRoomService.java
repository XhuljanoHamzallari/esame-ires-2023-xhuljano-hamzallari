package it.euris.academi.esame2023.service;

import it.euris.academi.esame2023.data.entity.CinemaRoom;

import java.util.List;

public interface CinemaRoomService {
    List<CinemaRoom> findAll();


    CinemaRoom insert(CinemaRoom cinemaRoom);

    CinemaRoom update(CinemaRoom cinemaRoom);

    Boolean deleteById(Integer idCinemaRoom);

    CinemaRoom findById(Integer idCinemaRoom);
}
