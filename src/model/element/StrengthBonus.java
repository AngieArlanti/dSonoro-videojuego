package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class StrengthBonus implements Valuable{

	private int value;
	
	public StrengthBonus(int value) {
		this.value=value;
	}
	
	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.stronger(value);
		return hero;
	}

	@Override
	public int getValue() {
		return value;
	}

}
