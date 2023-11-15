package it.euris.academi.esame2023.data.dto;

import it.euris.academi.esame2023.data.dto.archetype.Dto;
import it.euris.academi.esame2023.data.entity.Cinema;
import it.euris.academi.esame2023.data.entity.CinemaRoom;
import it.euris.academi.esame2023.data.entity.Film;
import it.euris.academi.esame2023.data.entity.Spectator;
import lombok.*;

import static it.euris.academi.esame2023.utility.ConverterUtils.stringToInteger;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CinemaRoomDTO implements Dto {
    private String id;
    private Spectator spectator;
    private Film film;
    private Cinema cinema;

    @Override
    public CinemaRoom toModel() {
        return CinemaRoom.builder()
                .id(stringToInteger(id))
                .cinema(cinema)
                .film(film)
                .spectator(spectator)
                .build();
    }
}
