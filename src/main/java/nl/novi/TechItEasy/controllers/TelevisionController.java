package nl.novi.TechItEasy.controllers;

import nl.novi.TechItEasy.exceptions.RecordNotFound;
import nl.novi.TechItEasy.model.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    private List<Television> tvs; // Maakt een ArrayList aan

    public TelevisionController() {
        tvs = new ArrayList<>(); // Geeft de ArrayList een naam

        Television samsung = new Television("Samsung","4:3"); // Maak een TV instantie
        tvs.add(samsung); // voeg de tv toe aan de lijst

        Television sony = new Television("Sony","16:9");
        tvs.add(sony);

        Television lenovo = new Television("Lenovo","5:3");
        tvs.add(lenovo);


    }


        @GetMapping(value = "/tvs")

        public ResponseEntity<List<Television>>getAllTvs() {
        return new ResponseEntity<>(tvs, HttpStatus.OK);

        }

    @GetMapping("/tvs/{id}")
    public ResponseEntity<Television> getOneTv(@PathVariable int id) {

        if (id >= 0 && id < tvs.size()) {
            Television tv = tvs.get(id);
            return new ResponseEntity<>(tv, HttpStatus.OK);
        }
        else {
            throw new RecordNotFound("TV doesn't found" + id);        }
    }

    @PostMapping("/tvs")
    public ResponseEntity<Television> createTv(@RequestBody Television newTelevision) {
        tvs.add(newTelevision);
        return new ResponseEntity<>(newTelevision, HttpStatus.CREATED);

    }


    @DeleteMapping("/tvs/{id}")

        public ResponseEntity<Television> deleteTV(@PathVariable int id) {
            if (id >= 0 && id < tvs.size()) {
                tvs.remove(id);
                return new ResponseEntity<>( HttpStatus.OK);
            }
            else {
                throw new RecordNotFound("Not able to delete TV, record not found");
            }
        }

    }



