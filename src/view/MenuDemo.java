package view;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Game;
import model.board.level.GameLevel1;
import model.board.level.GameLevel2;
import model.board.level.GameLevel3;
import model.board.level.Levels;
import sound.ClipName;
import sound.SoundManager;

public class MenuDemo {

	private JFrame mainFrame;
	private JPanel controlPanel;
	private JPanel controlPanel_1;
	private JButton level2Button;
	private JButton level3Button;

	public MenuDemo() {
		prepareGUI();
	}

	public static void main(String[] args) {
		MenuDemo swingControlDemo = new MenuDemo();
		swingControlDemo.showButtonDemo();
		SoundManager.play(ClipName.MENU);
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Menu principal");
		mainFrame.setResizable(false);
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				MenuDemo.class.getResource("/others/icon.jpg")));
		mainFrame.setSize(450, 647);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainFrame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		controlPanel_1 = new JPanel();
		controlPanel = ImagePanel.wrapInBackgroundImage(controlPanel_1, createImageIcon("/others/fondo.png", "background"));
		
		JButton level1Button = new JButton("");
		level1Button.setIcon(new ImageIcon(MenuDemo.class.getResource("/others/prueba1.png")));
		level1Button.addMouseListener(getMouseListener(ClipName.BUTTON_LEVEL1,
				GameLevel1.class, Levels.HELL));
		
		level2Button = new JButton("");
		level2Button.setIcon(new ImageIcon(MenuDemo.class.getResource("/others/prueba2_2.png")));
		level2Button.addMouseListener(getMouseListener(ClipName.BUTTON_LEVEL2,
				GameLevel2.class, Levels.PURGATORY));

		level3Button = new JButton("");
		level3Button.setIcon(new ImageIcon(MenuDemo.class.getResource("/others/prueba3.png")));
		level3Button.addMouseListener(getMouseListener(ClipName.BUTTON_LEVEL3,GameLevel3.class, Levels.HEAVEN));		
		
		GroupLayout gl_controlPanel_1 = new GroupLayout(controlPanel_1);
		gl_controlPanel_1.setHorizontalGroup(
			gl_controlPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlPanel_1.createSequentialGroup()
					.addGap(25)
					.addComponent(level1Button, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(level2Button, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(level3Button, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_controlPanel_1.setVerticalGroup(
			gl_controlPanel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_controlPanel_1.createSequentialGroup()
					.addGap(156)
					.addGroup(gl_controlPanel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(level3Button, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 402, Short.MAX_VALUE)
						.addComponent(level2Button, GroupLayout.PREFERRED_SIZE, 402, Short.MAX_VALUE)
						.addComponent(level1Button, GroupLayout.PREFERRED_SIZE, 402, Short.MAX_VALUE))
					.addGap(60))
		);
		controlPanel_1.setLayout(gl_controlPanel_1);
		
		mainFrame.getContentPane().add(controlPanel);
		mainFrame.setVisible(true);
		SoundManager.loadRoots();
	}

	private static ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = MenuDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private void showButtonDemo() {

		JButton exitButton = new JButton("Salir");
		
		exitButton.addMouseListener(getMouseListener(ClipName.BUTTON_EXIT,
				null, null));
		mainFrame.setVisible(true);
	}

	private MouseListener getMouseListener(final ClipName clip,
			final Class<?> levelClass, final Levels level) {

		MouseListener listener = new MouseListener() {

			@Override
			public void mouseEntered(MouseEvent arg0) {
				SoundManager.play(clip);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				SoundManager.stop(clip);

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (clip != ClipName.BUTTON_EXIT) {
					try {
						Main mainWindow = new Main(new Game(levelClass), level);
						mainWindow.setVisible(true);
						mainFrame.setVisible(false);
						SoundManager.stopSounds();
						switch (level) {
						
						case HELL:
							SoundManager.play(ClipName.MUSIC_LEVEL1);
							break;
						case PURGATORY:
							SoundManager.play(ClipName.MUSIC_LEVEL2);
							break;
						case HEAVEN:
							SoundManager.play(ClipName.MUSIC_LEVEL3);							
							break;
						default:
							break;
						}
						
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					System.exit(0);
					/*
					 * TODO View de creditos: que aparezca el personaje en la
					 * pantalla apagada como el juego y cuando se va moviendo
					 * van descubriendo los creditos.
					 */

				}

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};

		return listener;
	}
}
