package main.items;

public class Key extends Item {
    private final String locationToUnlock;

    public Key(String locationToUnlock) {
        this.name = "clé";
        this.locationToUnlock = locationToUnlock;
    }

    public String getLocationToUnlock() {
        return locationToUnlock;
    }

    @Override
    public String getDescription() {
        return "Une clé qui semble correspondre à : " + locationToUnlock;
    }
}