package be.milete.domain;

/**
 * Represents a Go-Board on which black and white stones are placed.
 */
public class Board {
    private Stone[][] stones;

    /**
     * Creates an empty Board with the given size.
     */
    public Board(int size){
        stones = new Stone[size][size];
    }
}
