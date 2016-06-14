package model.element;

import sound.ClipName;
import sound.SoundManager;
import model.board.Content;
import model.fighter.Fighter;

public class Victim implements Content{

	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public Content interact(Fighter hero) {
		SoundManager.play(ClipName.SOUND_EFFECT_PRINCESS);
		return new Person();
	}

}
