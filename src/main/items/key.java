package main.items;

public class Key extends Item {
    private final String locationToUnlock;

    public Key(String name, String locationToUnlock) {
        this.name = name;
        this.locationToUnlock = locationToUnlock;
    }

    public String getLocationToUnlock() {
        return locationToUnlock;
    }

    @Override
    public String getDescription() {
        return "A key to open « " + locationToUnlock + " ».";
    }
}
