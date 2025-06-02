package main.items;

public class Letter extends Item {
    private final Puzzle puzzle;

    public Letter(Puzzle puzzle) {
        this.name = "lettre";
        this.puzzle = puzzle;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    @Override
    public String getDescription() {
        return "Une lettre froissée. Elle contient une énigme :\n" + puzzle.getQuestion();
    }
}