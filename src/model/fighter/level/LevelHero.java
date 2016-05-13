package model.fighter.level;

/**
 * La clase <code>LevelHero<code> va a ser utilizada al instanciar un Hero, seteando la maxima salud, fuerza y
 * experiencia con su formula asignada.
 */

public class LevelHero extends Level{
	
	private static final int maxLevel = 10;
	
	public LevelHero(int value) {
		super(value, maxLevel);
		
	}

	@Override
	public int getMaxExperience() {
		return 5*this.getValue();
	}

	@Override
	public int getMaxHealth() {
		return 10*this.getValue();
	}

	@Override
	public int getStrength() {
		return 5*this.getValue();
	}
	
	
}
