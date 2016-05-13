package model.fighter.opponent;

import model.board.Content;
import model.element.Sword;
import model.fighter.Fighter;
import model.fighter.FighterBase;
import model.fighter.level.LevelEnemy;


public class Golem extends FighterBase{



	private static final double HEALTH=1.35;
	private static final double STRENGTH=1;
	
	public Golem(int value){
		super(new LevelEnemy(value,HEALTH,STRENGTH));
		
	}
	
	@Override
	public Content interact(Fighter hero) {
		
		  if(super.interact(hero)==null)
		  	return new Sword(getLevel().getValue());
		  else
		  	return this;
	}
	
}
