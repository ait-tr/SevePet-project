package ait.cohort34.petPosts.service;

import ait.cohort34.petPosts.dao.PetRepository;
import ait.cohort34.petPosts.dto.NewPetDto;
import ait.cohort34.petPosts.dto.PetDto;
import ait.cohort34.petPosts.dto.exseption.PetNotFoundException;
import ait.cohort34.petPosts.model.Pet;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PetServiceImpl implements PetService {

    final ModelMapper modelMapper;
    final PetRepository petRepository;


    @Override
    public PetDto addNewPet(String author,NewPetDto NewPetDto) {
        Pet pet = modelMapper.map(NewPetDto, Pet.class);
        pet.setAuthor(author);
        petRepository.save(pet);
        return modelMapper.map(pet, PetDto.class);
    }

    @Override
    public PetDto findPetByCaption(String caption) {
        Pet pet=petRepository.findById(caption).orElseThrow(PetNotFoundException::new);
        return modelMapper.map(pet, PetDto.class);
    }
    @Transactional(readOnly = true)
    @Override
    public Iterable<PetDto> findPetsByAge(int age) {
        return petRepository.findByAge(age)
                .map(s->modelMapper.map(s,PetDto.class))
                .toList();
    }
    @Transactional(readOnly = true)
    @Override
    public Iterable<PetDto> findPetsByGender(String gender) {
        return petRepository.findByGenderIgnoreCase(gender)
                .map(s->modelMapper.map(s,PetDto.class))
                .toList();
    }
    @Transactional(readOnly = true)
    @Override
    public Iterable<PetDto> findPetsByCountry(String country) {
        return petRepository.findByCountryIgnoreCase(country)
                .map(s->modelMapper.map(s,PetDto.class))
                .toList();
    }
    @Transactional(readOnly = true)
    @Override
    public Iterable<PetDto> findPetsByCategory(String category) {
        return petRepository.findByCategoryIgnoreCase(category)
                .map(s->modelMapper.map(s,PetDto.class))
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<PetDto> findPetsByDisability(Boolean disability) {
        return petRepository.findByDisability(disability)
                .map(s->modelMapper.map(s,PetDto.class))
                .toList();
    }
    @Transactional(readOnly = true)
    @Override
    public Iterable<PetDto> findPetsByAuthor(String author) {
        return petRepository.findByAuthorIgnoreCase(author)
                .map(s->modelMapper.map(s,PetDto.class))
                .toList();
    }

    @Override
    public Iterable<PetDto> findAllPets() {
        return petRepository.findAll().stream().map(s->modelMapper.map(s,PetDto.class)).toList();
    }

    @Override
    public PetDto removePetByCaption(String caption) {
        Pet pet=petRepository.findById(caption).orElseThrow(PetNotFoundException::new);
        petRepository.delete(pet);
        return modelMapper.map(pet, PetDto.class);
    }
}
