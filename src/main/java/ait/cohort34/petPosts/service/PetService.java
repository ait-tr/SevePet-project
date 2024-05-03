package ait.cohort34.petPosts.service;

import ait.cohort34.petPosts.dto.NewPetDto;
import ait.cohort34.petPosts.dto.PetDto;

public interface PetService {
    PetDto addNewPet(String author,NewPetDto newPetDto);
    PetDto findPetByCaption(String caption);
    Iterable<PetDto> findPetsByAge(int age);
    Iterable<PetDto> findPetsByGender(String gender);
    Iterable<PetDto> findPetsByCountry(String country);
    Iterable<PetDto> findPetsByCategory(String category);
    Iterable<PetDto> findPetsByDisability(Boolean disability);
    PetDto removePetByCaption(String caption);
}
