package main.items;

/**
 * Une énigme contenant une question, une réponse, et la salle qu'elle déverrouille si elle est résolue.
 */
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

    /**
     * Tente de résoudre l'énigme avec la réponse tapée.
     * Si correcte, marque solved = true.
     */
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
            return "Énigme \"" + name + "\" déjà résolue.";
        } else {
            return "Énigme \"" + name + "\" : " + question;
        }
    }
}
