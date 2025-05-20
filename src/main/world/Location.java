package main.world;

public class Location implements utils.IPrintable {

    private String name;
    private String description;
    private boolean state;

    public Location(String name, String description, boolean state) {
        this.name = name;
        this.description = description;
        this.state = state;
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public boolean getState() {
        return this.state;
    }

    @Override
    public String getPrintableString() {
        return this.getName();
    }
    @Override
    public boolean isGrayedOut() {
        return false;
    }

    
    
}

