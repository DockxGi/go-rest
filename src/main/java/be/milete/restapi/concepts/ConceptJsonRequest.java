package be.milete.restapi.concepts;

import be.milete.services.ConceptRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ConceptJsonRequest implements ConceptRequest {
    @NotBlank
    private String word;
    @NotBlank
    private String description;
}
