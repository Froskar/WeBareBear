package main.items;

public class Letter extends Item {
    private Puzzle puzzle;

    public Letter(Puzzle puzzle) {
        this.puzzle = puzzle;
    }
    public Puzzle getPuzzle() {
        return puzzle;
    }
    public String read() {
        return puzzle.getQuestion();
    }
}
