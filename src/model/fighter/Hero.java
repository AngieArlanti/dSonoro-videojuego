package model.fighter;

import model.board.Content;
import model.fighter.level.Level;

/**
 * La clase <code>Hero</code>, en el Board esta inicializada, en nuestro caso, como un <code>FighterBase</code> haciendo que este
 * se comporte como un Hero comun. Quienes extiendas de esta clase, van a encapsular un hero en particular (<code>private Fighter fighter;</code>), y
 * ademas van a agregarle comportamiento, en nuestro caso, puede ser mas resistencia (un HeroArmor) o mas
 * fuerza (un HeroSword).
 */

public class Hero implements Fighter {

	private Fighter fighter;
	
	public Hero(){
		
	}
	public Hero(Fighter fighter) {
		this.fighter = fighter;
	}
	
	protected Fighter getFighter() {
		return fighter;
	}
	
	@Override
	public void addExperience(int value) {
		fighter.addExperience(value);
	}
	
	@Override
	public boolean canWalkOver() {
		return fighter.canWalkOver();
	}
	
	@Override
	public int getExperience() {
		return fighter.getExperience();
	}
	
	@Override
	public int getHealth() {
		return fighter.getHealth();
	}
	
	@Override
	public Level getLevel() {
		return fighter.getLevel();
	}
	
	@Override
	public int getMaxExperience() {
		return fighter.getMaxExperience();
	}
	
	@Override
	public int getMaxHealth() {
		return fighter.getMaxHealth();
	}
	
	@Override
	public int getStrength() {
		return fighter.getStrength();
	}
	
	@Override
	public boolean hasMaxLevel() {
		return fighter.hasMaxLevel();
	}
	
	@Override
	public void heal(int value) {
		fighter.heal(value);
	}
	
	@Override
	public void healFull() {
		fighter.healFull();
	}
	
	@Override
	public void injured(int value) {
		fighter.injured(value);
	}
	
	@Override
	public Content interact(Fighter hero) {
		return fighter.interact(hero);
	}
	
	@Override
	public boolean isAlive() {
		return fighter.isAlive();
	}
	
	@Override
	public void stronger(int value) {
		fighter.stronger(value);
	}
}
