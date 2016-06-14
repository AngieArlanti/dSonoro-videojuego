package model.board;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import model.fighter.Fighter;
import model.fighter.FighterBase;
import model.fighter.Hero;
import model.fighter.level.Level;
import model.fighter.level.LevelHero;

/**
 * El campo <code>private Set &ltListenerHeroMove&gt listenersHeroMove</code>, en un conjunto de Listeners para el movimiento del hero.
 * En nuestro caso, estabamos interesados en que Goblin estuviera pendiente de los movimientos del Hero para curarse
 * luego de ser atacado cada dos pasos del mismo.
 * Decidimos no implementar equals y HashCode en Goblin, ya que tenemos distintas instancias
 * de dicho personaje. Lo que determina que dos Goblins sean iguales, es en definitiva, la identidad.
 * 
 * @author usuario
 *
 */
public abstract class Board {
	
	public static final int SIZE = 12;
	
	private Cell[][] g = new Cell[SIZE][SIZE];
	protected Point heroPosition;
	
	private Set <ListenerHeroMove> listenersHeroMove = new HashSet<ListenerHeroMove>();

	public Board() {
		initialize();
	}
	
	/**
	 * El metodo <code>addListenerHeroMove</code> agrega Listeners al set de <code>&ltListerHeroMove&gt</code>
	 * @param content
	 */
	
	public void addListenerHeroMove(ListenerHeroMove content){
		listenersHeroMove.add(content);
	}
	
	
	public void initialize() { //TODO link levels info
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				g[y][x] = new Cell();
			}
		}
		
		setContents();
		/*
		 * Update info
		 * */
		Level level = new LevelHero(1);
		Fighter fighter = new FighterBase(level);
		Hero hero = new Hero(fighter);
		
		heroPosition = getHeroInitPosition();
		g[heroPosition.y][heroPosition.x].setContent(hero);
		cleanFog(heroPosition);
	}	

	public void heroMove(Move move) {
		if (getHero().isAlive() & !playerWon()) {
			Point newPosition = new Point(heroPosition.x + move.getX(), heroPosition.y + move.getY());
	
			if (newPosition.x >= 0 && newPosition.y >= 0 && newPosition.x < SIZE && newPosition.y < SIZE) {
				if (g[newPosition.y][newPosition.x].canWalkOver()) {
					g[newPosition.y][newPosition.x].onWalk(getHero());
					g[heroPosition.y][heroPosition.x].removeContent();
					heroPosition = newPosition;
					cleanFog(heroPosition);
					alertHeroMove();
				} else if (g[newPosition.y][newPosition.x].canInteract()) {
					g[newPosition.y][newPosition.x].interact(getHero());
				}
			}
		}
	}
	
	/**
	 * El metodo <code>alertHeroMove</code> es llamado por el metodo <code>heroMove</code> en el caso de que el Hero
	 * cambie de posicion, para que los Listeners hagan lo que tengan que hacer ante este movimiento, en el caso
	 * nuestro, cada dos pasos cada Goblin incrementa en una unidad de health.
	 */
	private void alertHeroMove() {
		for(ListenerHeroMove element:listenersHeroMove){
			element.actionHeroMove();
			playFootsteps();
		}

	}
	protected abstract void playFootsteps();

	private void cleanFog(Point p){ //TODO tip: we could have fog and heavy fog(two or 3 movements to be removed) 
		for (int i = p.y-1; i <= p.y+1; i++) { //just usefull for one level (ideally level 2)
			for (int j = p.x-1; j <= p.x+1 ; j++) {
				if (i>=0 && i<SIZE && j>=0 && j<SIZE) {
					if (g[i][j].hasFog()) {
						
						g[i][j].removeFog();
						getHero().heal(getHero().getLevel().getValue());
					}
				}
			}
		}
	}
	
	public Point getHeroPosition(){
		return heroPosition;
	}
	
	public Cell get(int x, int y) {
		return g[y][x];
	}
	
	public Hero getHero() {
		return (Hero) g[heroPosition.y][heroPosition.x].getContent();
	}
	
	
	protected Cell[][] g(){
		return g;
	}
	
	protected abstract void setContents();

	protected abstract Point getHeroInitPosition();
	
	public abstract boolean gameOver();
	
	public abstract boolean playerWon();
}
