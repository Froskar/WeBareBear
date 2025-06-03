package main.items;

public class Puzzle extends Item {
    private final String question;
    private final String answer;
    private final String unlocksLocation;
    private boolean solved;

    public Puzzle(String question, String answer, String unlocksLocation, String name, String description) {
        super(name, description);
        this.name = "énigme";
        this.question = question;
        this.answer = answer.toLowerCase();
        this.unlocksLocation = unlocksLocation;
        this.solved = false;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isSolved() {
        return solved;
    }

    public boolean trySolve(String response) {
        if (response.toLowerCase().equals(answer)) {
            solved = true;
            return true;
        }
        return false;
    }

    public String getUnlocksLocation() {
        return unlocksLocation;
    }

    @Override
    public String getDescription() {
        return solved ? "Cette énigme a été résolue." : "Une énigme à résoudre : " + question;
    }
}
