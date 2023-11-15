package it.euris.academi.esame2023.data.dto;

import it.euris.academi.esame2023.data.dto.archetype.Dto;
import it.euris.academi.esame2023.data.dto.archetype.Model;
import it.euris.academi.esame2023.data.entity.Film;
import lombok.*;

import static it.euris.academi.esame2023.utility.ConverterUtils.stringToInteger;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FilmDTO implements Dto {
    private String id;
    private String author;
    private String producer;
    private String type;
    private String minimumAge;
    private String duration;


    @Override
    public Film toModel() {
        return Film.builder()
                .id(stringToInteger(id))
                .author(author)
                .producer(producer)
                .type(type)
                .minimumAge(stringToInteger(minimumAge))
                .duration(stringToInteger(duration))
                .build();

    }
}
