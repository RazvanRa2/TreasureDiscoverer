package entities;

import java.util.List;
import java.util.ArrayList;
import game.World;

public abstract class Hero {

	protected String name;
	protected List<Treasure> inventory = new ArrayList<Treasure>();
	protected int posx, posy;

	/* Hero actions */
	public void move(Direction direction) {

		World world = World.getInstance();
		int[][] map = world.getMap();
		int tempX = 0;
		int tempY = 0;
		switch(direction) {
		case E:
			tempX = (posx + 1) % World.MAP_SIZE;
			tempY = posy;
			break;
		case W:
			tempX = (posx + World.MAP_SIZE - 1) % World.MAP_SIZE;
			tempY = posy;
			break;
		case S:
			tempY = (posy + 1) % World.MAP_SIZE;
			tempX = posx;
			break;
		case N:
			tempY = (posy + World.MAP_SIZE - 1) % World.MAP_SIZE;
			tempX = posx;
			break;

		}

		if (map[tempY][tempX] != 1) {
			map[posy][posx] = 0;

			posx = tempX;
			posy = tempY;

			map[posy][posx] = world.HERO_SPOT;
		} else {
			System.out.println("Cannot move there - obstacle in the way");
		}
		
		world.update();

	}

	public void collect(Treasure treasure) {
		inventory.add(treasure);
	}

	public List<Treasure> getInventory() {
		return inventory;
	}

	public abstract void attack();


	/* Getters and setters */
	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public enum Direction{
		S, N, E, W
	}

	public enum Type {
		WARRIOR, MAGE, PRIEST
	}

}
