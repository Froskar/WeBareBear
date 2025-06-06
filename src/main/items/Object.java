package main.items;


public class Object extends Item {
        String descr;
    public Object (String name, String descr){
        this.name = name.toLowerCase();
        this.descr = descr;
        setTakeable(false);
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.descr;
    }
}
