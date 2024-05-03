package ait.cohort34.petPosts.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode(of = "caption")
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    String caption;
    String type;
    String category;
    String breed;
    String gender;
    int age;
    Boolean disability;
    String photo;
    String country;
    String city;
    String description;
    String clas;
    String PersonFirstName;
    String PersonLastName;
    LocalDate dateCreate;
}
