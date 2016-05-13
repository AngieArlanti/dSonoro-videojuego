package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class HealthBonus implements Valuable{

	private int value;

	public HealthBonus(int value){
		this.value=value;
	}
	
	
	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.heal(value);
		return hero;
	}


	@Override
	public int getValue() {
		return value;
	}

}
