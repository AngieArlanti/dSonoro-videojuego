package model.board.level;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import sound.ClipName;
import sound.SoundManager;
import model.board.Board;
import model.board.Content;
import model.element.*;
import model.fighter.Fighter;
import model.fighter.opponent.*;

public class GameLevel3 extends Board { //TODO rearrange board

	private List<Fighter> enemies;

	@Override
	protected Point getHeroInitPosition() {
		heroPosition = new Point(0, 0); 
		return heroPosition;
	}

	@Override
	public boolean gameOver() {
		refreshEnemies();
		return (!getHero().isAlive() || playerWon());
	}

	@Override
	public boolean playerWon() {
		return enemies.isEmpty();
	}

	@Override
	protected void setContents() {

		enemies = new LinkedList<Fighter>();
		Wall wall = new Wall();
		Snake snake1 = new Snake(3);
		Snake snake2 = new Snake(4);
		Goblin goblin2 = new Goblin(2, this);
		Goblin goblin3 = new Goblin(1, this);
		Golem golem1 = new Golem(1);
		Golem golem2 = new Golem(2);
		HealthBonus health1 = new HealthBonus(5);
		Armor armor1 = new Armor(5);
		Armor armor2 = new Armor(3);
		StrengthBonus strengthBonus1 = new StrengthBonus(3);
		StrengthBonus strengthBonus2 = new StrengthBonus(5);
		HealthPotion potion1 = new HealthPotion();
		Sword sword1 = new Sword(3);
		Victim victim = new Victim();

//		for (int i = 0; i < 12; i++) {
//			setContent(i, 11, wall);
//			setContent(11, i, wall);
//		}
		//WALL
		setContent(1,0,wall);
		setContent(1,1,wall);
		setContent(1,2,wall);
		setContent(2,2,wall);
		setContent(3,2,wall);
		setContent(4,2,wall);
		setContent(5,2,wall);
		setContent(0,6,wall);
		setContent(1,6,wall);
		setContent(2,6,wall);
		setContent(3,6,wall);
		setContent(4,6,wall);
		setContent(4,7,wall);
		setContent(4,8,wall);
		setContent(4,9,wall);
		setContent(4,10,wall);
		setContent(11,3,wall);
		setContent(10,3,wall);
		setContent(9,3,wall);
		setContent(9,4,wall);
		setContent(9,5,wall);
		setContent(9,6,wall);
		setContent(9,7,wall);

		//Enemies
		setContent(0,4,goblin3);	
		setContent(1,4,goblin2);	
		setContent(1,5,goblin3);	
		setContent(3,0,snake1);	
		setContent(3,1,snake2);	
		setContent(11,4,goblin2);	
		setContent(11,5,goblin3);
		setContent(10,5,goblin3);	
		setContent(2,7,golem2);	
		setContent(2,8,golem1);	
		setContent(3,8,golem2);	
		
		//Victim
		setContent(0,5,victim);
		setContent(10,4,victim);
		setContent(3,7,victim);
		setContent(2,1,victim);
		
		//HealthBonus
		setContent(4,5,health1);	
		setContent(11,7,health1);
		
		//Armor
		setContent(10,0,armor1);	
		setContent(10,10,armor2);
		
		setContent(0,10,strengthBonus1);
		setContent(7,9,potion1);
		setContent(3,3,sword1);
		setContent(10,1,strengthBonus2);

	}

	private void setContent(int x, int y, Content c) {
		g()[y][x].setContent(c);
	}

	private void setContent(int x, int y, Fighter f) {
		setContent(x, y, (Content) f);
		enemies.add(f);
	}

	private void refreshEnemies() {
		Iterator<Fighter> it = enemies.iterator();
		while (it.hasNext()) {
			if (!it.next().isAlive())
				it.remove();
		}
	}

	@Override
	protected void playFootsteps() {
		SoundManager.play(ClipName.FOOTSTEPS_LEVEL3);
		
	}
}