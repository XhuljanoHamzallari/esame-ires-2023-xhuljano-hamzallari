package it.euris.academi.esame2023.data.dto;

import it.euris.academi.esame2023.data.dto.archetype.Dto;
import it.euris.academi.esame2023.data.entity.Cinema;
import lombok.*;

import static it.euris.academi.esame2023.utility.ConverterUtils.stringToInteger;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CinemaDTO implements Dto {
    private String id;
    private String cinemaRoom;

    @Override
    public Cinema toModel() {
        return Cinema.builder()
                .id(stringToInteger(id))
                .build();
    }
}
