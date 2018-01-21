package observers;

import java.util.Observable;
import java.util.Observer;
import game.World;
import entities.Hero;
import entities.Treasure;
import java.util.ArrayList;

/**
 * Observer that prints the lore of a treasure when a hero discovers it.
 *
 */

public class TreasureDiscoverer implements Observer {


	public void update(Observable o, Object arg) {
		
		if (o instanceof World)	{
			World world = (World) o;
			ArrayList<Hero> party = world.getParty();
			ArrayList<Treasure> treasures = world.getTreasures();
			ArrayList<Treasure> toRemove = new ArrayList<>();

			for (Hero h : party) {
				for (Treasure t : treasures) {
					int heroX = h.getPosx();
					int heroY = h.getPosy();

					int treasureX = t.getPosx();
					int treasureY = t.getPosy();

					if (heroX == treasureX && heroY == treasureY) {
						toRemove.add(t);
						h.collect(t);

						System.out.println("Hero " + h.getName() + " has found a treasure:\n");
	                    System.out.println(t.getName() + " - " + t.getLore());
					}
				}
			}

			for (Treasure t : toRemove)
				world.removeTreasure(t);

		}

	}
}
