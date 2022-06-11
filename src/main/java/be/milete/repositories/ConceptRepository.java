package be.milete.repositories;

import be.milete.domain.Concept;
import org.springframework.data.repository.CrudRepository;

public interface ConceptRepository extends CrudRepository<Concept, Integer> {

    int deleteByWord(String word);

}
