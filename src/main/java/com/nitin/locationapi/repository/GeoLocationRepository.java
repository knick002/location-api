package com.nitin.locationapi.repository;

import com.nitin.locationapi.domain.GeoLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface GeoLocationRepository extends JpaRepository<GeoLocation, BigInteger> {

    GeoLocation findByLatitudeAndLongitude(double latitude, double longitude);
}
