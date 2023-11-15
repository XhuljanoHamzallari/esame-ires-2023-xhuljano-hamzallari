package it.euris.academi.esame2023.service;

import it.euris.academi.esame2023.data.entity.Spectator;

import java.util.List;

public interface SpectatorService {
    List<Spectator> findAll();

    Spectator insert(Spectator spectator);

    Spectator update(Spectator spectator);

    Boolean deleteById(Integer idSpectator);

    Spectator findById(Integer idSpectator);
}
