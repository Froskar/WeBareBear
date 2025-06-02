package main.player;

public class player {
    String name;
    int LocationRow = 0;
    int locationColumn = 0;

    public player(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public int getLocationRow() {
        return this.LocationRow;
    }
    public int getLocationColumn() {
        return this.locationColumn;
    }
    public void setLocationRow(int row) {
        this.LocationRow = row;
    }
    public void setLocationColumn(int column) {
        this.locationColumn = column;
    }


}
