package nl.novi.TechItEasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelevisionController {

    @GetMapping("/televisions")
    public ResponseEntity<List<String>> getAllTelevisions() {

        List<String> televisionList = new ArrayList<>();
        televisionList.add("SamsungTelevision");
        televisionList.add("NoviTelevision 451T Saga");
        televisionList.add("SonyTelevision 892 pixel");

        return ResponseEntity.ok(televisionList);
    }


}
