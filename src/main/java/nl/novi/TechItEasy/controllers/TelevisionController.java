package nl.novi.TechItEasy.controllers;

import nl.novi.TechItEasy.models.Television;
import nl.novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {


    private final TelevisionRepository televisionRepository;

    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    @PostMapping("/tvs")
    public ResponseEntity<Television> createTv(@RequestBody Television newTelevision) {
        // Gebruik televisionRepository om de nieuwe televisie op te slaan
        Television savedTelevision = televisionRepository.save(newTelevision);

        // Stuur een HTTP 201 Created-status met de opgeslagen televisie als respons
        return new ResponseEntity<>(savedTelevision, HttpStatus.CREATED);
    }

}




