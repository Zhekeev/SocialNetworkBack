package qz.reactjava.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qz.reactjava.project.model.Location;
import qz.reactjava.project.service.impl.LocationServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/location/")
public class LocationController {
    private final LocationServiceImpl locationService;

    public LocationController(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }

    @PostMapping()
    private ResponseEntity save(@RequestBody Location location) {
        locationService.save(location);
        Map<Object, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    private ResponseEntity<Location> update(@RequestBody Location location) {
        Location updatedLocation = locationService.update(location);
        return new ResponseEntity<>(updatedLocation, HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<List<Location>> getAll() {
        List<Location> locations = locationService.allLocation();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Location> getLocationById(@PathVariable(name = "id")Long id) {
        Location location = locationService.getLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @DeleteMapping
    private ResponseEntity delete(Location location) {
        locationService.delete(location);
        Map<Object, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
