package main.items;

public class Puzzle extends Item {
    private String question;
    private String answer;
    private boolean solved;
    private String unlocksLocation;

    public Puzzle(String question, String answer, String unlocksLocation) {
        this.question = question;
        this.answer = answer.toLowerCase();
        this.solved = false;
        this.unlocksLocation = unlocksLocation;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isSolved() {
        return solved;
    }

    public boolean trySolve(String response) {
        if (response.toLowerCase().equals(answer)) {
            this.solved = true;
            return true;
        }
        return false;
    }

    public String getUnlocksLocation() {
        return unlocksLocation;
    }
}
// enigme du jeu