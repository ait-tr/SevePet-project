package ait.cohort34.petPosts.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "caption")
@NoArgsConstructor
@AllArgsConstructor
public class NewPetDto {
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
}
