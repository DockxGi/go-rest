package be.milete.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

/**
 * Represents a concept in the context of the Go board game with its description. (e.g. atari, ko)
 */
@Getter
@Setter
@Entity
public class Concept {
    @Id
    @GeneratedValue(strategy= AUTO)
    private Integer id;
    private String word;
    private String description;

    public Concept() {
    }

    public Concept(String word, String description) {
        this.word = word;
        this.description = description;
    }


}
