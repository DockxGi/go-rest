package be.milete.restapi.concepts;

import be.milete.services.ConceptsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public void createConcept(@RequestBody @Validated ConceptJsonRequest request){
        service.createConcept(request);
    }

}
