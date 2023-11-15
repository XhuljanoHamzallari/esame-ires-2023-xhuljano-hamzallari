package it.euris.academi.esame2023.data.dto;

import it.euris.academi.esame2023.data.dto.archetype.Dto;
import it.euris.academi.esame2023.data.dto.archetype.Model;
import it.euris.academi.esame2023.data.entity.CinemaRoom;
import it.euris.academi.esame2023.data.entity.Ticket;
import lombok.*;

import static it.euris.academi.esame2023.utility.ConverterUtils.stringToDouble;
import static it.euris.academi.esame2023.utility.ConverterUtils.stringToInteger;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketDTO implements Dto {

    private String id;
    private String price;
    private String position;
    private CinemaRoom cinemaRoom;

    @Override
    public Ticket toModel() {
        return Ticket.builder()
                .id(stringToInteger(id))
                .price(stringToDouble(price))
                .position(position)
                .cinemaRoom(cinemaRoom)
                .build();
    }
}
