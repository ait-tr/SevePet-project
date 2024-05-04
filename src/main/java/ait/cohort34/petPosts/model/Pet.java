package ait.cohort34.petPosts.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

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
    String photo;
    String country;
    String city;
    String description;
    String clas;
    String personFirstName;
    String personLastName;
    LocalDate dateCreate  = LocalDate.now();
    //deadline data

    public Pet(String caption, String type, String personLastName, String personFirstName, String clas, String description, String city, String country, String photo, Boolean disability, int age, String gender, String breed, String category) {
        this.caption = caption;
        this.type = type;
        this.personLastName = personLastName;
        this.personFirstName = personFirstName;
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
