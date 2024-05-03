package ait.cohort34.petPosts.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "caption")
@Document(collection = "pets")
public class Pet {
    @Id
    String caption;
    String author;
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
    LocalDate dateCreate  = LocalDate.now();

    public Pet(String caption, String type, String personLastName, String personFirstName, String clas, String description, String city, String country, String photo, Boolean disability, int age, String gender, String breed, String category) {
        this.caption = caption;
        this.type = type;
        PersonLastName = personLastName;
        PersonFirstName = personFirstName;
        this.clas = clas;
        this.description = description;
        this.city = city;
        this.country = country;
        this.photo = photo;
        this.disability = disability;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.category = category;
    }
}
