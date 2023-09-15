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





//    public ResponseEntity<List<TelevisionDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {
  //      List<TelevisionDto> televisions;

    //    if (brand == null){

            // Vul de televisions lijst met alle televisions
      //      televisions = service.getTelevisions();


      //  } else {
            // Vul de televisions lijst met alle television die een bepaald brand hebben
        //    televisions = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        //}

        // Return de televisions lijst en een 200 status
        //return ResponseEntity.ok().body(televisions);

    //}

  //  @GetMapping("/televisions/{id}")
  //  public ResponseEntity<Object> getTelevision(@PathVariable("id") Long id) {

    //        return ResponseEntity.ok().body(TelevisionService.getTelevisionById(id));
    //    }






    // We geven hier een television mee in de parameter. Zorg dat je JSON object exact overeenkomt met het Television object.
   // @PostMapping("/televisions")
   // public ResponseEntity<TelevisionDto> createTelevision(@Valid @RequestBody TelevisionDto televisionDto) {
   // service.createTelevision(televisionDto);

    // URI object moet nog geplaats worden
       

   // return  ResponseEntity.created(uri).body(televisionDto);
   // }

}




