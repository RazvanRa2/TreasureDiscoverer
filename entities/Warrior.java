package entities;

//extra attribute: damage (aka strength)
public class Warrior extends Hero {
    public Warrior(String name) {
        setName(name);
    }
    public void attack() {

    }

    @Override
    public String toString() {
        return "Warrior " + getName() + " at position (" + getPosx() + ", " +
        getPosy() + ") has in inventory: " + getInventory();

    }
}
