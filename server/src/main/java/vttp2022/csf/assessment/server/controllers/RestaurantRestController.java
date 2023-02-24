package vttp2022.csf.assessment.server.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.services.RestaurantService;

@RestController
public class RestaurantRestController {

    @Autowired
    private RestaurantService rSvc;

    @GetMapping(path="/api/cuisines", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCuisines() {
        Optional<List<String>> cuisines = rSvc.getCuisines();
        return ResponseEntity.ok(cuisines.toString());
        
    }

    @GetMapping(path="/api/{cuisine}/restaurants", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getRestaurantsByCuisine(@RequestParam String cuisine) {
        Optional<List<Restaurant>> restaurants = rSvc.getRestaurantsByCuisine(cuisine);
        //come back later
        return null;
    }

    
}
