package model.element;

import sound.ClipName;
import sound.SoundManager;
import model.board.Content;
import model.fighter.Fighter;

public class HealthPotion implements Content {

	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		SoundManager.play(ClipName.SOUND_EFFECT_BUNUS);
		hero.healFull();
		return hero;
	}

}
