package it.euris.academi.esame2023.data.entity;

import it.euris.academi.esame2023.data.dto.CinemaRoomDTO;
import it.euris.academi.esame2023.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static it.euris.academi.esame2023.utility.ConverterUtils.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cinema_room")
@ToString
public class CinemaRoom implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_spectator")
    private Spectator spectator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_film")
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cinema")
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaRoom", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public CinemaRoomDTO toDto() {
        return CinemaRoomDTO.builder()
                .id(numberToString(id))
                .cinema(cinema)
                .film(film)
                .spectator(spectator)
                .build();
    }
}
