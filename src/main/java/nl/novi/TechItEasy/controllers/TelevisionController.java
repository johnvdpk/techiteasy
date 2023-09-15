package nl.novi.TechItEasy.controllers;

import nl.novi.TechItEasy.exceptions.RecordNotFound;
import nl.novi.TechItEasy.models.Television;
import nl.novi.TechItEasy.repositories.TelevisionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionController {


    private final TelevisionRepository televisionRepository;

    public TelevisionController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    // We hebben hier de RequestParam "brand" toegevoegd om te laten zien hoe dat werkt.
    // Als de gebruiker een brand invult, dan zoeken we op brand, anders returnen we alle televisions.
    @GetMapping("/televisions")
    public ResponseEntity<List<Television>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {

        List<Television> televisions;

        if (brand == null){

            // Vul de televisions lijst met alle televisions
            televisions = televisionRepository.findAll();


        } else {
            // Vul de televisions lijst met alle television die een bepaald brand hebben
            televisions = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        }

        // Return de televisions lijst en een 200 status
        return ResponseEntity.ok().body(televisions);

    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable("id") Long id) {

        // Haal de television met het gegeven id uit de database.
        // Het Optional datatype betekend "wel of niet". Als er geen television gevonden wordt, dan is de Optional empty,
        // maar als er wel een television gevonden wordt, dan staat de television in de Optional en kun je deze er uit
        // halen met de get-methode. Op deze manier krijg je niet meteen een error als de tv niet in de database voorkomt.
        // Je kunt dat probleem zelf oplossen. In dit geval doen we dat door een RecordNotFoundException op te gooien met een message.
        Optional<Television> television = televisionRepository.findById(id);

        // Check of de optional empty is. Het tegenovergestelde alternatief is "television.isPresent()"
        if (television.isEmpty()){

            // Als er geen television in de optional staat, roepen we hier de RecordNotFoundException constructor aan met message.
            throw new RecordNotFound("No television found with id: " + id );

        } else {
            // Als er wel een television in de optional staat, dan halen we die uit de optional met de get-methode.
            Television television1 = television.get();

            // Return de television en een 200 status
            return ResponseEntity.ok().body(television1);
        }

    }




    // We geven hier een television mee in de parameter. Zorg dat je JSON object exact overeenkomt met het Television object.
    @PostMapping("/televisions")
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {

        // Sla de nieuwe tv in de database op met de save-methode van de repository
        Television returnTelevision = televisionRepository.save(television);

        // Return de gemaakte television en een 201 status
        return ResponseEntity.created(null).body(returnTelevision);

    }

}




