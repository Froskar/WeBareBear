package main.items;

/**
 * Une lettre contient une énigme. Quand on la lit, on affiche la question.
 */
public class Letter extends Item {
    private final Puzzle puzzle;

    public Letter(String name, Puzzle puzzle) {
        this.name = name; // ex. "lettre_1", "lettre_2", etc.
        this.puzzle = puzzle;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public String read() {
        return puzzle.getQuestion();
    }

    @Override
    public String getDescription() {
        return "Une lettre froissée. Elle contient l'énigme :\n" + puzzle.getQuestion();
    }
}
