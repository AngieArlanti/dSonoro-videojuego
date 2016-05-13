package model.element;

import model.board.Content;
import model.fighter.Fighter;
import model.fighter.HeroArmor;

public class Armor implements Valuable{

	int value;
	
	public Armor(int value) {
			this.value=value;
	}
	
	
	@Override
	public boolean canWalkOver() {

		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		return new HeroArmor(hero, this);
	}

	@Override
	public int getValue() {
		return value;
	}

}
