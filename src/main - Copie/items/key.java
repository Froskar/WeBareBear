package main.items;

public class Key {
    private String locationToUnlock;

    public Key(String locationToUnlock) {
        this.locationToUnlock = locationToUnlock;
    }

    public String getLocationToUnlock() {
        return locationToUnlock;
    }
}
