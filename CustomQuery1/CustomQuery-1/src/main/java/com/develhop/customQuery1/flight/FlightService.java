package com.develhop.customQuery1.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void provisionFlights() {
        List<FlightEntity> flightEntities = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            FlightEntity flightEntity = new FlightEntity();
            flightEntity.setDescription("Flight " + i);
            flightEntity.setFromAirport(generateRandomString());
            flightEntity.setToAirport(generateRandomString());
            flightEntity.setStatus(Status.ONTIME);
            flightEntities.add(flightEntity);
        }

        flightRepository.saveAllCustom(flightEntities);
        System.out.println("**Voli generati e salvati con successo!**");
    }

    public List<FlightEntity> getAllFlights() {
        return flightRepository.findFlights();
    }

    private String generateRandomString() {
        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
