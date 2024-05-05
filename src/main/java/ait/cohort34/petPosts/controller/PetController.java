package ait.cohort34.petPosts.controller;

import ait.cohort34.petPosts.dto.NewPetDto;
import ait.cohort34.petPosts.dto.PetDto;
import ait.cohort34.petPosts.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController{
    @Autowired
    final PetService petService;

    @PostMapping("/add/{author}")
    public PetDto addNewPet(@PathVariable String author,@RequestBody NewPetDto newPetDto) {
        return petService.addNewPet(author,newPetDto);
        // в дальнейшем при создании поста будет передаваться принципал логин что упростит отправку запроса
    }
    @GetMapping("/find/caption/{caption}")
    public PetDto findPetByCaption(@PathVariable String caption) {
        return petService.findPetByCaption(caption);
    }
    @GetMapping("/find/age/{age}")
    public Iterable<PetDto> findPetsByAge(@PathVariable int age) {
        return petService.findPetsByAge(age);
    }
    @GetMapping("/find/gender/{gender}")
    public Iterable<PetDto> findPetsByGender(@PathVariable String gender) {
        return petService.findPetsByGender(gender);
    }
    @GetMapping("/find/country/{country}")
    public Iterable<PetDto> findPetsByCountry(@PathVariable String country) {
        return petService.findPetsByCountry(country);
    }
    @GetMapping("/find/category/{category}")
    public Iterable<PetDto> findPetsByCategory(@PathVariable String category) {
        return petService.findPetsByCategory(category);
    }
    @GetMapping("/find/disability/{disability}")
    public Iterable<PetDto> findPetsByDisability(@PathVariable Boolean disability) {
        return petService.findPetsByDisability(disability);
    }
    @GetMapping("/find/author/{author}")
    public Iterable<PetDto> findPetsByAuthor(@PathVariable String author) {
        return petService.findPetsByAuthor(author);
    }
    @GetMapping("/find/all")
    public Iterable<PetDto> findAll() {
        return petService.findAllPets();
    }

    @DeleteMapping("/{caption}")
    public PetDto removePetByCaption(@PathVariable String caption) {
        return petService.removePetByCaption(caption);
    }
}
