package ait.cohort34.petPosts.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "caption")
@Entity
@Table(name = "pets")
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
    @ElementCollection
    Set<String> photo;
    String country;
    String city;
    String description;
    String firma;
    String personFirstName;
    String personLastName;
    LocalDate dateCreate  = LocalDate.now();
    //deadline data

    public Pet(String caption, String type, String personLastName, String personFirstName, String firma, String description, String city, String country, Set<String> photo, Boolean disability, int age, String gender, String breed, String category) {
        this.caption = caption;
        this.type = type;
        this.personLastName = personLastName;
        this.personFirstName = personFirstName;
        this.firma = firma;
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
