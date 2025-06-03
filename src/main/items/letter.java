package main.items;

public class Letter extends Item {
    private final Puzzle puzzle;
    private  String contenu;

    public Letter(Puzzle puzzle,String name, String description, String contenu) {
        super(name, description);
        this.name = name;
        this.puzzle = puzzle;
        this.contenu = contenu;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public String read() {
        return this.contenu;
    }

    @Override
    public String getDescription() {
        return "Une lettre froissée";
    }
}