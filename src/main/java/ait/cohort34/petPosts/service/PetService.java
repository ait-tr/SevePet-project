package ait.cohort34.petPosts.service;

import ait.cohort34.petPosts.dto.NewPetDto;
import ait.cohort34.petPosts.dto.PetDto;
import ait.cohort34.petPosts.dto.UpdatePetDto;

public interface PetService {
    PetDto addNewPet(String login,NewPetDto newPetDto);
    Iterable<PetDto> findPetByType(String type);
    Iterable<PetDto> findPetsByAge(String age);
    Iterable<PetDto> findPetsByGender(String gender);
    Iterable<PetDto> findPetsByCountry(String country);
    Iterable<PetDto> findPetsByCategory(String category);
    Iterable<PetDto> findPetsByDisability(Boolean disability);
    Iterable<PetDto> findPetsByAuthor(String author);
    Iterable<PetDto> findAllPets();
    PetDto updatePet(Long  id, UpdatePetDto updatePetDto);
    PetDto removePetById(Long  id);
}
