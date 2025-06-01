package main.items;

public class Letter {
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

