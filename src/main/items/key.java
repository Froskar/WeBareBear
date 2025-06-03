package main.items;

public class Key extends Item {
    private final String locationToUnlock;

    public Key(String name, String locationToUnlock) {
        this.name = name;                    // ex. "clé_trône", "clé_cave", etc.
        this.locationToUnlock = locationToUnlock; // nom de la Location à déverrouiller
    }

    public String getLocationToUnlock() {
        return locationToUnlock;
    }

    @Override
    public String getDescription() {
        return "Une clé ouvrant la salle « " + locationToUnlock + " ».";
    }
}
