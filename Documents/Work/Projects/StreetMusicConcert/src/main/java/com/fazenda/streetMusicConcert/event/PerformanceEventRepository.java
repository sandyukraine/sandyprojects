package com.fazenda.streetMusicConcert.event;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PerformanceEventRepository extends MongoRepository<PerformanceEvent, String> {
    @Query("{'$or' : [{'timeSlot' : {$lt : ?0}}, {'area' : {$lt : ?1}}]}")
    public List<PerformanceEvent> findByPopulationLessThanOrAreaInSquareMilesLessThanQuery(int pop, int area);
}