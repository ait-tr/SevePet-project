package ait.cohort34.petPosts.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

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
    Set<String> photo;
    String country;
    String city;
    String description;
    String firma;
    String personFirstName;
    String personLastName;
    LocalDate dateCreate;
}
