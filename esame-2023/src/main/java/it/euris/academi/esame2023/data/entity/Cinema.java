package it.euris.academi.esame2023.data.entity;

import it.euris.academi.esame2023.data.dto.CinemaDTO;
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
@Table(name = "cinema")
@ToString
public class Cinema implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.EAGER)
    private List<CinemaRoom> cinemaRoomList = new ArrayList<>();

    @Override
    public CinemaDTO toDto() {
        return CinemaDTO.builder()
                .id(numberToString(id))
                .cinemaRoom(cinemaRoomList.stream().map(CinemaRoom::getId).toList().toString())
                .build();
    }
}


