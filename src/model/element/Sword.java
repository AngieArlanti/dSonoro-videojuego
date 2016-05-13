package model.element;

import model.board.Content;
import model.fighter.Fighter;
import model.fighter.HeroSword;

public class Sword implements Valuable {

	private int value;
	
	public Sword(int value) {
		this.value=value;
	}

	@Override
	public boolean canWalkOver() {

		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		return new HeroSword(hero,this);
	}

	public int getValue() {
		return value;
	}
	
	

}
