package it.euris.academi.esame2023.data.entity;

import it.euris.academi.esame2023.data.dto.TicketDTO;
import it.euris.academi.esame2023.data.dto.archetype.Dto;
import it.euris.academi.esame2023.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.academi.esame2023.utility.ConverterUtils.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
@ToString
public class Ticket implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "position", nullable = false)
    private String position;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cinema_room", nullable = false)
    private CinemaRoom cinemaRoom;

    @OneToOne(mappedBy = "ticket")
    private Spectator spectator;


    @Override
    public TicketDTO toDto() {
        return TicketDTO.builder()
                .id(numberToString(id))
                .price(numberToString(price))
                .position(position)
                .cinemaRoom(cinemaRoom)
                .build();
    }
}
