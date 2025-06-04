package main.items;

public class Letter extends Item {
    private final Puzzle puzzle;
    private final Key key;

    public Letter(String name, Puzzle puzzle, Key key) {
        this.name = name;
        this.puzzle = puzzle;
        this.key = key;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public Key getKey() {
        return key;
    }

    public String read() {
        return puzzle.getQuestion();
    }

    @Override
    public String getDescription() {
        return "A crumpled letter. It contains the enigma :\n" + puzzle.getQuestion();
    }
}
