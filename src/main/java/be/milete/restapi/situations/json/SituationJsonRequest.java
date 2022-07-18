package be.milete.restapi.situations.json;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class SituationJsonRequest {
    private int boardSize;
    private Set<StonePositionJsonRequest> positions;
}
