package nl.novi.TechItEasy.controllers;

import nl.novi.TechItEasy.exceptions.TvsNotFound;
import nl.novi.TechItEasy.model.Televisions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    private List<Televisions> tvs; // Maakt een ArrayList aan

    public TelevisionController() {
        tvs = new ArrayList<>(); // Geeft de ArrayList een naam

        Televisions samsung = new Televisions(); // Maak een TV instantie
        samsung.setTv("Samsung"); // Geef een TV een naam
        tvs.add(samsung); // voeg de tv toe aan de lijst

        Televisions sony = new Televisions(); // Maak een andere TV instantie
        sony.setTv("sony"); // Stel de naam van de andere TV in
        tvs.add(sony); // Voeg deze TV ook toe aan de lijst

    }


        @GetMapping(value = "/tvs")

        public ResponseEntity<List<Televisions>>getAllTvs() {
        throw new TvsNotFound("probleem");
        //return new ResponseEntity<>(tvs, HttpStatus.OK);

        }

    @GetMapping("/tvs/{id}")
    public ResponseEntity<Televisions> getOneTv(@PathVariable int id) {

        if (id >= 0 && id < tvs.size()) {
            Televisions tv = tvs.get(id);
            return new ResponseEntity<>(tv, HttpStatus.OK);
        }
        else {
            throw new TvsNotFound("TV doesn't found" + id);        }
    }

    @PostMapping("/tvs")
    public ResponseEntity<Televisions> createPerson(@RequestBody Televisions newTelevisions) {
        tvs.add(newTelevisions);
        return new ResponseEntity<>(newTelevisions, HttpStatus.CREATED);

    }


    }


