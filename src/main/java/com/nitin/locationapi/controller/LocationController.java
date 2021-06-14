package com.nitin.locationapi.controller;

import com.nitin.locationapi.domain.GeoLocation;
import com.nitin.locationapi.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);
    private final LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/geolocations")
    public ResponseEntity<List<GeoLocation>> getAllGeoLocations() {
        logger.info("Get AllGeoLocations Controller called");
        return ResponseEntity.ok(locationService.getAllGeoLocations());
    }

    @GetMapping("/geolocationByLocation")
    public ResponseEntity<GeoLocation> getGeoLocation(@RequestParam(value = "lat") String latitude,
            @RequestParam(value = "lon") String longitude) {
        logger.info("Get GeoLocation Controller called for {},{}", latitude, longitude);
        return ResponseEntity.ok(locationService.getGeoLocation(latitude, longitude));
    }

    @PostMapping("/geolocation")
    public ResponseEntity<GeoLocation> createGeoLocation(@RequestBody GeoLocation location) {
        logger.info("Create GeoLocation Controller called for {},{}", location.getLatitude(),location.getLongitude());
        return ResponseEntity.ok(locationService.createGeoLocation(location));
    }
}
