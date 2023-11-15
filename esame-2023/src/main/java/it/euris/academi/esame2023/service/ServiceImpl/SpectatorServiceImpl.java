package it.euris.academi.esame2023.service.ServiceImpl;

import it.euris.academi.esame2023.data.entity.Spectator;
import it.euris.academi.esame2023.exception.IdMustNotBeNullException;
import it.euris.academi.esame2023.repository.SpectatorRepository;
import it.euris.academi.esame2023.service.SpectatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class SpectatorServiceImpl implements SpectatorService {
   private SpectatorRepository spectatorRepository;
    @Override
    public List<Spectator> findAll() {
        return spectatorRepository.findAll();
    }

    @Override
    public Spectator insert(Spectator spectator) {
        if(spectator.getId() != null && spectator.getId() > 0) {
            throw new IdMustNotBeNullException();
        }
        return spectatorRepository.save(spectator);
    }

    @Override
    public Spectator update(Spectator spectator) {
        if(spectator.getId() == null || spectator.getId() == 0) {
            throw new IdMustNotBeNullException();
        }
        return spectatorRepository.save(spectator);
    }

    @Override
    public Boolean deleteById(Integer idSpectator) {
        spectatorRepository.deleteById(idSpectator);
        return spectatorRepository.findById(idSpectator).isEmpty();
    }

    @Override
    public Spectator findById(Integer idSpectator) {
        return spectatorRepository.findById(idSpectator).orElse(Spectator.builder().build());
    }
}
