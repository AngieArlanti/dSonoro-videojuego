package view.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import model.Game;
import model.board.Cell;
import view.ImageManager;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	
	/**
	 * la otra es hacer aca un JLayaredPane y a ese hacerle
	 * lpane.add(game, new Integer(0), 0);
     * lpane.add(gameOverPanel, new Integer(1), 0);
     * 
     * 
     * O SINO HACER EN ELEMENT PANEL AGREGAR GAME OVER PANEL
     * 
     * CON LO QUE AGREGUE (cambiar color por Color) ya aparece el color, no haria falta tener una clase GameOverPanel
     * 
	 */
	private Game game;
	private ImageManager imgManager;
	private int rows, columns;
	private int cellSize;
	private Color color;
	private Image[][] images;


	public GamePanel(Game game, ImageManager imgManager, final int cellSize, final GamePanelListener listener, Color color) {
		this.game = game;
		this.imgManager = imgManager;
		this.rows = game.getBoardSize();
		this.columns = game.getBoardSize();
		this.images = new Image[rows][columns];
		this.cellSize = cellSize;
		this.color = color;
		setSize(columns * cellSize, rows * cellSize);

		addMouseMotionListener(new MouseMotionAdapter() {

			private Integer currentRow;
			private Integer currentColumn;

			@Override
			public void mouseMoved(MouseEvent e) {
				int row = e.getY() / cellSize;
				int column = e.getX() / cellSize;
				if (row >= GamePanel.this.rows || column >= GamePanel.this.columns || row < 0 || column < 0) {
					return;
				}

				if (!nullSafeEquals(currentRow, row) || !nullSafeEquals(currentColumn, column)) {
					currentRow = row;
					currentColumn = column;
					if (listener != null) {
						listener.onMouseOver(row, column);
					}
				}
			}

			private boolean nullSafeEquals(Object o1, Object o2) {
				return o1 == null ? o2 == null : o1.equals(o2);
			}
		});
	}

	public void put(Image image, int row, int column) {
		images[row][column] = image;
	}

	public void clear(int row, int column) {
		images[row][column] = null;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color);
		g.fillRect(0, 0, columns * cellSize, rows * cellSize);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (images[i][j] != null) {
					g.drawImage(images[i][j], j * cellSize, i * cellSize, null);
				}
			}
		}
		if (game.isOver()) {
			Font plain=new Font("Arial", Font.ITALIC, 30);
			g.setFont(plain);
			Graphics2D string= (Graphics2D) g;
			if (game.playerWon()) {
//				string.setBackground(Color.RED);
				string.setColor(Color.BLUE);
				string.drawString("Game Over - Player WON !!!", 10, 140);
			} else {
//				string.setBackground(Color.RED);
				string.setColor(Color.RED);
				string.drawString("Game Over - Player DIED !!!", 10, 140);
			}
		}
		
		
		
		
		
		
	}
	
	public void refresh() {
		for(int i=0; i<game.getBoardSize(); i++){
			for(int j=0; j<game.getBoardSize(); j++) {
				Cell cell = game.get(i, j);
				if (cell.hasFog()) {
					put(imgManager.get("FOG"), i, j);
				} else {
					put(imgManager.get(cell), i, j);
				}
			}
		}
		repaint();
	}
}