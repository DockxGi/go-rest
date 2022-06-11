package be.milete.services;

import be.milete.domain.Concept;
import be.milete.logging.Logger;
import be.milete.repositories.ConceptRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static be.milete.logging.TopicName.CONCEPT;

@Service
public class ConceptsService {

    private final ConceptRepository repository;

    public ConceptsService(ConceptRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void createConcept(ConceptRequest request){
        Logger.log(CONCEPT, String.format("Service received request to create concept: %s", request.getWord()));
        Concept concept = new Concept(request.getWord(), request.getDescription());
        repository.save(concept);
    }

    @Transactional
    public List<Concept> findAllConcepts(){
        Iterable<Concept> concepts = repository.findAll();
        List<Concept> conceptsList = new ArrayList<>();
        for (Concept concept : concepts) {
            conceptsList.add(concept);
        }
        return conceptsList;
    }

    @Transactional
    public boolean deleteConcept(String word) {
        int deleted = repository.deleteByWord(word);
        return deleted > 0;
    }
}
