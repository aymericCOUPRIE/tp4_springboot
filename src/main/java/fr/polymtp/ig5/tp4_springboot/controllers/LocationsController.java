package fr.polymtp.ig5.tp4_springboot.controllers;

import fr.polymtp.ig5.tp4_springboot.models.Location;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fr.polymtp.ig5.tp4_springboot.repositories.*;
import fr.polymtp.ig5.tp4_springboot.models.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/locations")
public class LocationsController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<Location> list() {
        return locationRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Location get(@PathVariable Long id) {
        return locationRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location create(@RequestBody final Location location) {
        return locationRepository.saveAndFlush(location);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        locationRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Location update(@PathVariable Long id, @RequestBody Location location) {
        Location existingLocation = locationRepository.getById(id);
        BeanUtils.copyProperties(location, existingLocation, "user_id");
        return locationRepository.saveAndFlush(existingLocation);
    }
    /*@GetMapping("/location")
    public Location getLocation(@RequestParam(value = "latitude", defaultValue = "50") Double latitude,
                                @RequestParam(value = "longitude", defaultValue = "50") Double longitude,
                                @RequestParam(value = "location_date", defaultValue = "05-11-2021") Date location_date
    ) {
        Location location = new Location(latitude, longitude, location_date);
        return location;
    }

    @PostMapping("/location")
    public Location postLocation(@RequestBody Location location) {
        return location;
    }*/

}
