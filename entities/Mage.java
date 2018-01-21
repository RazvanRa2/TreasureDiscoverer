package entities;

//additional attack: magicAttack

public class Mage extends Hero {
    public Mage(String name) {
        setName(name);
    }

    public void attack() {

    }

    @Override
    public String toString() {
        return "Mage " + getName() + " at position (" + getPosx() + ", " +
        getPosy() + ") has in inventory: " + getInventory();

    }
}
