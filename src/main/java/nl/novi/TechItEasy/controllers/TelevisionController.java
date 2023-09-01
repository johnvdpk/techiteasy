package nl.novi.TechItEasy.controllers;

import nl.novi.TechItEasy.exceptions.RecordNotFound;
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

        Televisions samsung = new Televisions("Samsung","4:3"); // Maak een TV instantie
        tvs.add(samsung); // voeg de tv toe aan de lijst

        Televisions sony = new Televisions("Sony","16:9");
        tvs.add(sony);

        Televisions lenovo = new Televisions("Lenovo","5:3");
        tvs.add(lenovo);


    }


        @GetMapping(value = "/tvs")

        public ResponseEntity<List<Televisions>>getAllTvs() {
        return new ResponseEntity<>(tvs, HttpStatus.OK);

        }

    @GetMapping("/tvs/{id}")
    public ResponseEntity<Televisions> getOneTv(@PathVariable int id) {

        if (id >= 0 && id < tvs.size()) {
            Televisions tv = tvs.get(id);
            return new ResponseEntity<>(tv, HttpStatus.OK);
        }
        else {
            throw new RecordNotFound("TV doesn't found" + id);        }
    }

    @PostMapping("/tvs")
    public ResponseEntity<Televisions> createTv(@RequestBody Televisions newTelevisions) {
        tvs.add(newTelevisions);
        return new ResponseEntity<>(newTelevisions, HttpStatus.CREATED);

    }


    @DeleteMapping("/tvs/{id}")

        public ResponseEntity<Televisions> deleteTV(@PathVariable int id) {
            if (id >= 0 && id < tvs.size()) {
                tvs.remove(id);
                return new ResponseEntity<>( HttpStatus.OK);
            }
            else {
                throw new RecordNotFound("Not able to delete TV, record not found");
            }
        }

    }



