package com.fazenda.streetMusicConcert.performer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PerformerRepository extends MongoRepository<Performer, String> {

}
