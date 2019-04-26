package com.fazenda.streetMusicConcert.place;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceResolver {

    @Autowired
    private PlaceRepository placeRepository;

    public Place resolvePlace(String placeId) {
        return placeRepository.findById(placeId).get();
    }
}