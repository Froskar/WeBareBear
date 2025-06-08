package main.items;

public class Puzzle extends Item {
    private final String question;
    private final String answer;
    private final String unlocksLocation;
    private boolean solved;

    public Puzzle(String name, String question, String answer, String unlocksLocation) {
        this.name = name;                 // ex. "énigme_1", "énigme_2", etc.
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
        if (solved) {
            return "Enigma \"" + name + "\" already resolved.";
        } else {
            return "Enigma \"" + name + "\" : " + question;
        }
    }
}
