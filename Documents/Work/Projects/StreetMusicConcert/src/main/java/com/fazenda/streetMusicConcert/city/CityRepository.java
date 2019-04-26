package com.fazenda.streetMusicConcert.city;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CityRepository extends MongoRepository<City, String> {
    public City findByName(String name);
    public List<City> findByPermissionNeeded(boolean permissionNeeded);
}
