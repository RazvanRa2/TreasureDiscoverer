package observers;

/**
 * Observer that prints the game's world (the map with all the treasures,
 * heroes, obstacles)
 *
 */

import java.util.Observable;
import java.util.Observer;
import game.World;

public class WorldPrinter implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof World) {
			World world = (World) o;

			int[][] map = world.getMap();

			for (int i = 0; i < world.MAP_SIZE; i++) {
				for (int j = 0; j < world.MAP_SIZE; j++) {
					if (map[i][j] == 2) {
						System.out.print("H ");
					}

					if (map[i][j] == 3) {
						System.out.print("T ");
					}

					if (map[i][j] == 0 || map[i][j] == 1) {
						System.out.print(map[i][j] + " ");
					}
				}
				System.out.println();
			}
		}
	}

}
