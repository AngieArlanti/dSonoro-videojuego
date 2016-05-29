package model.fighter;

import model.board.Content;
import model.fighter.level.Level;

/**
 *La clase <code>FighterBase</code> implemanta la interface <code>Fighter</code>.En ella se encuentra el comportamiento en comun
 * del Hero y los enemies. De ella extienden los enemies: Goblin, Golem y Snake.
 */
public class FighterBase implements Fighter {

	private Level level;
	private int health;
	private int maxHealth;
	private int strength;
	private int experience;
	private int maxExperience;
	
	public FighterBase (Level level){
		this.level=level;
		initialize();
		
	}
	
	
	private void initialize() {
		maxHealth=level.getMaxHealth();
		health=maxHealth;
		strength=level.getStrength();
		experience=0;
		maxExperience=level.getMaxExperience();
	}


	@Override
	public void addExperience(int value) {
		if(experience+value<maxExperience)
			experience+=value;
		else
			levelUp();		
	}

	private void levelUp() {
		level.levelUp();
		initialize();
	}


	@Override
	public int getExperience() {
		return experience;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public Level getLevel() {
		return level;
	}

	@Override
	public int getMaxExperience() {
		return maxExperience;
	}

	@Override
	public int getMaxHealth() {
		return maxHealth;
	}

	@Override
	public int getStrength() {
		return strength;
	}

	@Override
	public boolean hasMaxLevel() {
		return(level.getValue()==level.getMaxLevel());
	}

	@Override
	public void heal(int value) {
		if(health<maxHealth){
			if(health+value>maxHealth)
				healFull();
			else
				health+=value;
		}
	}

	@Override
	public void healFull() {
		health=maxHealth;
	}

	@Override
	public void injured(int value) {
		if(health-value<0)
			health=0;
		else
			health-=value;
	}

	@Override
	public boolean isAlive() {
		return health>0;
	}

	@Override
	public void stronger(int value) {
		
		strength+=value;		
	}
	
	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.injured(strength);
		if(!hero.isAlive()){
			return this;
		}
		this.injured(hero.getStrength());
		
		if(!isAlive()){
			hero.addExperience(getLevel().getValue());
			return null;
		}
		return this;
	}
}