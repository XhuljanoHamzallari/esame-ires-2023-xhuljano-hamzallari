package it.euris.academi.esame2023.data.dto;

import it.euris.academi.esame2023.data.dto.archetype.Dto;
import it.euris.academi.esame2023.data.entity.Spectator;
import it.euris.academi.esame2023.data.entity.Ticket;
import lombok.*;

import static it.euris.academi.esame2023.utility.ConverterUtils.stringToInteger;
import static it.euris.academi.esame2023.utility.ConverterUtils.stringToLocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SpectatorDTO implements Dto {
    private String id;
    private String name;
    private String surname;
    private String birthYear;
    private Ticket ticket;

    @Override
    public Spectator toModel() {
        return Spectator.builder()
                .id(stringToInteger(id))
                .name(name)
                .surname(surname)
                .birthYear(stringToLocalDateTime(birthYear))
                .ticket(ticket)
                .build();
    }
}
