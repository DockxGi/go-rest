package be.milete.restapi.situations;

import be.milete.restapi.situations.json.SituationJsonRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Controller to access situations. Situations are a collection of position
 * of stones that are on the Board at a given moment in time.
 * They can be used as examples, exercises and as resource for puzzles.
 */
@RestController
@RequestMapping("situations")
public class SituationsController {

    @ResponseStatus(CREATED)
    @PostMapping
    public void createSituation(@RequestBody  @Validated SituationJsonRequest request){
        System.out.println(request);
    }
}