package it.euris.academi.esame2023.data.entity;

import it.euris.academi.esame2023.data.dto.FilmDTO;
import it.euris.academi.esame2023.data.dto.archetype.Dto;
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
@Table(name = "film")
@ToString
public class Film implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "minimum_age", nullable = false)
    private Integer minimumAge;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @OneToMany(mappedBy = "film", fetch = FetchType.EAGER)
    @Builder.Default
    private List<CinemaRoom> cinemaRooms = new ArrayList<>();

    @Override
    public FilmDTO toDto() {
        return FilmDTO
                .builder()
                .id(numberToString(id))
                .author(author)
                .producer(producer)
                .type(type)
                .minimumAge(numberToString(minimumAge))
                .duration(numberToString(duration))
                .build();
    }
}
