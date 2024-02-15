package com.develhop.customQuery1.flight;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@EnableJpaRepositories
@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
    @Query(value = "SELECT * FROM Flight", nativeQuery = true) // native sono Query in SQL come scriverei normalmente in una query su DBeaver
    List<FlightEntity> findFlights();

    @Modifying
    @Query(value = "INSERT INTO Flight (description, from_airport, to_airport, status) " +
            "VALUES (:description, :fromAirport, :toAirport, :status)", nativeQuery = true)
    void saveAllCustom(List<FlightEntity> flightEntities);

}