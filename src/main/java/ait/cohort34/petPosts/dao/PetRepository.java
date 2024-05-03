package ait.cohort34.petPosts.dao;

import ait.cohort34.petPosts.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PetRepository extends CrudRepository<Pet,String> {
    Stream<Pet> findByAge(int age);
    Stream<Pet> findByCountry(String country);
    Stream<Pet> findByCategory(String category);
    Stream<Pet> findByGender(String gender);
    Stream<Pet> findByDisability(String disability);
}
