package org.example.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

    @Query(value = "SELECT * FROM flight_entity", nativeQuery = true)
    List<FlightEntity> findAllFlights();
    // native sono Query in SQL come scriverei normalmente in una query su DBeaver
    ;
}
