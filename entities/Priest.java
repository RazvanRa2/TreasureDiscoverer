package entities;

//extra attribute: knowledge
public class Priest extends Hero {
    public Priest(String name) {
        setName(name);
    }
    public void attack() {

    }

    @Override
    public String toString() {
        return "Priest " + getName() + " at position (" + getPosx() + ", " +
        getPosy() + ") has in inventory: " + getInventory();

    }
}
