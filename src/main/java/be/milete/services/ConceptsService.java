package be.milete.services;

import be.milete.logging.Logger;
import org.springframework.stereotype.Service;

import static be.milete.logging.TopicName.CONCEPT;

@Service
public class ConceptsService {

    public void createConcept(ConceptRequest request){
        Logger.log(CONCEPT, String.format("Service received request to create concept: %s", request.getWord()));
    }
}
