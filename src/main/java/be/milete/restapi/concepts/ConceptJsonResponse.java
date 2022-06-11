package be.milete.restapi.concepts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConceptJsonResponse {
    private String word;
    private String description;

}
