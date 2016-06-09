package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class Victim implements Content{

	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public Content interact(Fighter hero) {
		return new Person();
	}

}
