package be.milete.restapi.situations.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StonePositionJsonRequest {
    private StoneJsonRequest stone;
    private int x;
    private int y;
}
