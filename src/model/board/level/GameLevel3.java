package model.board.level;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import model.board.Board;
import model.board.Content;
import model.element.*;
import model.fighter.Fighter;
import model.fighter.opponent.*;

public class GameLevel3 extends Board { //TODO rearrange board

	private List<Fighter> enemies;

	@Override
	protected Point getHeroInitPosition() {
		heroPosition = new Point(7, 0); 
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
		Goblin goblin1 = new Goblin(3, this);
		Goblin goblin2 = new Goblin(2, this);
		Goblin goblin3 = new Goblin(1, this);
		Goblin goblin4 = new Goblin(1, this);
		Goblin goblin5 = new Goblin(1, this);
		Goblin goblin6 = new Goblin(2, this);
		Golem golem1 = new Golem(1);
		Golem golem2 = new Golem(2);
		Golem golem3 = new Golem(5);
		HealthBonus health1 = new HealthBonus(5);
		Armor armor1 = new Armor(5);
		Armor armor2 = new Armor(3);
		StrengthBonus strengthBonus1 = new StrengthBonus(3);
		StrengthBonus strengthBonus2 = new StrengthBonus(5);
		HealthPotion potion1 = new HealthPotion();
		Sword sword1 = new Sword(3);

		for (int i = 0; i < 12; i++) {
			setContent(i, 11, wall);
			setContent(11, i, wall);
		}

		setContent(0, 3, wall);
		setContent(1, 3, wall);
		setContent(4, 6, wall);
		setContent(4, 7, wall);
		setContent(4, 8, wall);
		setContent(8, 6, wall);
		setContent(9, 6, wall);
		setContent(10, 6, wall);
		setContent(1, 2, snake1);
		setContent(2, 1, wall);
		setContent(5, 1, health1);
		setContent(5, 2, sword1);
		setContent(2, 2, wall);
		setContent(3, 2, golem1);
		setContent(0, 4, golem3);
		setContent(4, 4, goblin2);
		setContent(10, 2, goblin5);
		setContent(3, 6, goblin6);
		setContent(2, 3, wall);
		setContent(7, 3, wall);
		setContent(8, 3, wall);
		setContent(9, 3, wall);
		setContent(10, 3, wall);
		setContent(9, 4, goblin1);
		setContent(2, 6, armor1);
		setContent(10, 0, armor2);
		setContent(10, 7, goblin3);
		setContent(9, 7, goblin4);
		setContent(5, 9, wall);
		setContent(7, 9, wall);
		setContent(8, 9, wall);
		setContent(9, 9, wall);
		setContent(4, 10, golem2);
		setContent(10, 9, wall);
		setContent(9, 5, strengthBonus1);
		setContent(6, 6, potion1);
		setContent(1, 9, wall);
		setContent(2, 9, wall);
		setContent(3, 9, wall);
		setContent(4, 9, wall);
		setContent(5, 10, wall);
		setContent(9, 10, snake2);
		setContent(10, 10, strengthBonus2);

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
}