package factories;

import entities.Hero;
import entities.Mage;
import entities.Priest;
import entities.Warrior;

public class HeroFactory {

	private static HeroFactory instance = new HeroFactory();

	public static HeroFactory getInstance() {
		return instance;
	}

	/**
	 *
	 * @param type the Hero type
	 * @param name
	 * @return
	 */
	public Hero createHero(Hero.Type type, String name) {
		if (type == Hero.Type.WARRIOR) {
			return new Warrior(name);
		}

		if (type == Hero.Type.PRIEST) {
			return new Priest(name);
		}

		if (type == Hero.Type.MAGE) {
			return new Mage(name);
		}
		return null;
	}
}
