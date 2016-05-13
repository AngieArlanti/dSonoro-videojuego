package model.fighter.level;

/**
 * La clase <code>LevelEnemy<code> va a ser utilizada al instanciar un enemy, seteando la maxima salud, fuerza y
 * experiencia con su formula asignada.
 */

public class LevelEnemy extends Level {	

	private static final int maxLevel = 10;
	private double health;
	private double strength;
	
	public LevelEnemy(int value, double health, double strength){
		super(value,maxLevel);
		this.health=health;
		this.strength=strength;
	}
	
	@Override
	public int getMaxHealth() {
		return (int)Math.floor((Math.pow(getValue()+3,2)-10)*health);
	}

	@Override
	public int getStrength() {
		
		return  (int) Math.floor((Math.pow(getValue(),2)+5*getValue())*0.5*strength);
	}

	@Override
	public int getMaxExperience() {
		return 0;
	}	
}
