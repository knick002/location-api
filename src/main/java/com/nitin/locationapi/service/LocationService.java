package com.nitin.locationapi.service;

import com.nitin.locationapi.domain.GeoLocation;
import com.nitin.locationapi.exception.DuplicateGeoLocationException;
import com.nitin.locationapi.exception.LocationNotFoundException;
import com.nitin.locationapi.repository.GeoLocationRepository;
import com.nitin.locationapi.utils.LocationConstants;
import com.nitin.locationapi.utils.LocationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LocationService {
    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);
    @Autowired
    private GeoLocationRepository geoLocationRepository;

    public List<GeoLocation> getAllGeoLocations() {
        return geoLocationRepository.findAll();
    }

    public GeoLocation getGeoLocation(String latitude, String longitude) {
        //Q: Do we create geolocation if not found?
        double lat = Double.parseDouble(latitude);
        double lon = Double.parseDouble(longitude);
        double dfTokyo = LocationUtils.distance(lat, lon, LocationConstants.TOKYO_JAPAN_LAT, LocationConstants.TOKYO_JAPAN_LON);
        logger.info("dfTokyo from Tokyo_Japan is {} miles", dfTokyo);
        GeoLocation location = geoLocationRepository.findByLatitudeAndLongitude(lat, lon);
        if (location == null) {
            logger.error("Location not found for {}, {}", lat,lon);
            throw new LocationNotFoundException("Location not found");
        }
        return location;
    }

    public GeoLocation createGeoLocation(GeoLocation location) {
        logger.info("Create a geoLocation called for {},{}", location.getLatitude(),location.getLongitude());
        try {
            GeoLocation geoLocation = new GeoLocation();
            geoLocation.setCreated(new Date());
            geoLocation.setLatitude(location.getLatitude());
            geoLocation.setLongitude(location.getLongitude());
            // Find city for Geolocation - use 3rd party API (e.g. googleapis)
            // Probably want to save distance from various cities for each geolocation in separate table
            GeoLocation result = geoLocationRepository.save(geoLocation);
            return result;
        } catch (DataIntegrityViolationException e) {
            logger.error(e.getMessage());
            throw new DuplicateGeoLocationException("Duplicate Gelocation");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e.getCause());
        }
    }
}
