package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.Game;
import model.board.level.Levels;
import view.panel.GamePanel;
import view.panel.InfoPanel;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private static final int CELL_SIZE = 50;
	private static final int INFO_WIDTH = 200;
	
	/**
	 * agregar un JLayaredPane sharePanel
	 */
	private GamePanel gPanel;
	private InfoPanel infoPanel;
	private ImageManager imgManager;
	
	private int height;
	
	public MainPanel(Game game, Levels level){
		this.imgManager = new ImageManager(level);
		this.height = CELL_SIZE * game.getBoardSize();
		setLayout(null);
		add(infoPanel = new InfoPanel(game, imgManager, INFO_WIDTH, height));
		add(gPanel = new GamePanel(game, imgManager, CELL_SIZE, infoPanel,Color.BLACK));
		setSize(CELL_SIZE * game.getBoardSize() + INFO_WIDTH, height);
		refresh();
	}	
	
	public void refresh() {
		gPanel.refresh();
		infoPanel.refresh();
	}
}
