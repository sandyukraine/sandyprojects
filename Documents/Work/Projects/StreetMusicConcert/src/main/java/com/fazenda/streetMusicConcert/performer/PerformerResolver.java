package com.fazenda.streetMusicConcert.performer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformerResolver {

    Logger logger = LoggerFactory.getLogger(PerformerResolver.class);

    @Autowired
    private PerformerRepository performerRepository;

    public Performer resolvePerformer(String performerId) {
        Performer performer = performerRepository.findById(performerId).get();
        logger.info("Performer resolved: " + performer);
        return performer;
    }
}