package ait.cohort34.petPosts.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePetDto {
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
}
