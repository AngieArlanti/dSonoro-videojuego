package model.element;

import sound.ClipName;
import sound.SoundManager;
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
		SoundManager.play(ClipName.SOUND_EFFECT_BUNUS);
		hero.stronger(value);
		return hero;
	}

	@Override
	public int getValue() {
		return value;
	}

}
