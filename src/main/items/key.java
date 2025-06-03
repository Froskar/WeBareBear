package main.items;

public class Key extends Item {
    private final String locationToUnlock;

    public Key(String locationToUnlock, String name, String description) {
        super(name, description);
        this.locationToUnlock = locationToUnlock;
    }

    public String getLocationToUnlock() {
        return locationToUnlock;
    }

    @Override
    public String getDescription() {
        return description + " (Permet de déverrouiller : " + locationToUnlock + ")";
    }
}