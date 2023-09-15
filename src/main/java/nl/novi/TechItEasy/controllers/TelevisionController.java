package nl.novi.TechItEasy.controllers;

import jakarta.validation.Valid;
import nl.novi.TechItEasy.dto.InputDtoToTelevision;
import nl.novi.TechItEasy.dto.TelevisionDto;
import nl.novi.TechItEasy.models.Television;
import nl.novi.TechItEasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {

        this.service = service;
    }

    @GetMapping("/televisions")
    public ResponseEntity<List<TelevisionDto>> getAllTelevisions() {
        List<TelevisionDto> televisions = service.getTelevisions();

        return ResponseEntity.ok().body(televisions);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> getTelevisions(@PathVariable("id") Long id) {
        TelevisionDto television = service.getTelevision(id);
        return ResponseEntity.ok().body(television);

    }

    @PostMapping("/televisions")
    public ResponseEntity<Television> addTelevision(@Valid @RequestBody InputDtoToTelevision inputDtoToTelevision) {

        Television InputDto = service.addTelevision(inputDtoToTelevision);

        return ResponseEntity.created(null).body(InputDto);
    }



}




