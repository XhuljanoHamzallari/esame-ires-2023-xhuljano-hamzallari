package it.euris.academi.esame2023.data.entity;

import it.euris.academi.esame2023.data.dto.SpectatorDTO;
import it.euris.academi.esame2023.data.dto.archetype.Dto;
import it.euris.academi.esame2023.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static it.euris.academi.esame2023.utility.ConverterUtils.localDateTimeToString;
import static it.euris.academi.esame2023.utility.ConverterUtils.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "spectator")
@ToString
public class Spectator implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birth_year", nullable = false)
    private LocalDateTime birthYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_ticket", referencedColumnName = "id")
    private Ticket ticket;


    @Override
    public SpectatorDTO toDto() {
        return SpectatorDTO.builder()
                .id(numberToString(id))
                .name(name)
                .surname(surname)
                .birthYear(localDateTimeToString(birthYear))

                .build();
    }
}
