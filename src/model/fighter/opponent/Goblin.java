package model.fighter.opponent;

import model.board.Board;
import model.board.ListenerHeroMove;
import model.board.Content;
import model.element.Blood;
import model.fighter.Fighter;
import model.fighter.FighterBase;
import model.fighter.level.LevelEnemy;

public class Goblin extends FighterBase implements ListenerHeroMove{

	private static final double HEALTH=1;
	private static final double STRENGTH=0.7;
	private int heroSteps;
	
	
	/**
	 * 
	 * @param value
	 * @param board
	 */
	public Goblin(int value, Board board){
		super(new LevelEnemy(value,HEALTH,STRENGTH));
		board.addListenerHeroMove(this);
	}
	
	@Override
	public Content interact(Fighter hero) {
		
		if(super.interact(hero)==null)
			return new Blood();
		else
			return this;
	}

	/**
	 * Cada <code>Goblin</code>, si es lastimado, cuenta cuantos pasos hace el Hero.
	 * Si hizo 2 pasos entonces se cura una unidad. 
	 */
	@Override
	public void actionHeroMove() {
		if(this.getHealth()!= this.getMaxHealth())
			heroSteps++;
		
		if(heroSteps==2)
		{
			this.heal(1);
			heroSteps=0;
		}
	}
	
	

}
