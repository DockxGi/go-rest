package be.milete.restapi.concepts;

import be.milete.domain.Concept;
import be.milete.restapi.concepts.json.ConceptJsonRequest;
import be.milete.restapi.concepts.json.ConceptJsonResponse;
import be.milete.restapi.exceptions.ResourceNotFound;
import be.milete.services.ConceptsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Controller to access the list of concepts that have a specific meaning in the context of Go games.
 */
@RestController
@RequestMapping("concepts")
public class ConceptsController {

    private final ConceptsService service;

    public ConceptsController(ConceptsService service) {
        this.service = service;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createConcept(@RequestBody @Validated ConceptJsonRequest request){
        service.createConcept(request);
    }

    @DeleteMapping("/{word}")
    public void deleteConcept(@PathVariable("word") String word){
        boolean anythingDeleted = service.deleteConcept(word);
        if (!anythingDeleted){
            throw new ResourceNotFound();
        }
    }

    @GetMapping
    public List<ConceptJsonResponse> getConcepts(){
        List<Concept> allConcepts = service.findAllConcepts();

        Function<Concept, ConceptJsonResponse> conversionFunction = concept -> {
            String word = concept.getWord();
            String description = concept.getDescription();
            return new ConceptJsonResponse(word, description);
        };

        return allConcepts.stream()
                .map(conversionFunction)
                .collect(Collectors.toList());
    }
}
