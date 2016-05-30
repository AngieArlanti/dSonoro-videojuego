package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Game;
import model.board.Board;
import model.board.level.GameLevel1;
import model.board.level.GameLevel2;
import model.board.level.GameLevel3;
import sound.ClipName;
import sound.SoundManager;

public class MenuDemo {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public MenuDemo() {
		prepareGUI();
	}

	public static void main(String[] args) {
		MenuDemo swingControlDemo = new MenuDemo();
		swingControlDemo.showButtonDemo();
		SoundManager.play(ClipName.MENU);
	}

	private void prepareGUI() {
		mainFrame = new JFrame("Java Swing Examples");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);

		statusLabel.setSize(350, 100);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
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

		headerLabel.setText("Nombre del juego");

		// resources folder should be inside SWING folder.
		ImageIcon icon = createImageIcon("/resources/java_icon.png", "Java");

		JButton level1Button = new JButton("Level 1");
		JButton level2Button = new JButton("Level 2", icon);
		JButton level3Button = new JButton("Level 3", icon);
		JButton exitButton = new JButton("Salir", icon);
		level3Button.setHorizontalTextPosition(SwingConstants.LEFT);

		
		
		level1Button.addMouseListener(getMouseListener(ClipName.LEVEL1,GameLevel1.class));
		level2Button.addMouseListener(getMouseListener(ClipName.LEVEL2,GameLevel2.class));
		level3Button.addMouseListener(getMouseListener(ClipName.LEVEL3,GameLevel3.class));
		
		
//		level2Button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {//TODO blocked until level 1 is completed
//					Main mainWindow = new Main(new Game(GameLevel2.class));
//					mainWindow.setVisible(true);
//					mainFrame.setVisible(false);
//				} catch (InstantiationException e1) {
//					e1.printStackTrace();
//				} catch (IllegalAccessException e1) {
//					e1.printStackTrace();
//				}
//			}
//			
//		});
//
//		level3Button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {//TODO blocked until level 2 is completed
//					Main mainWindow = new Main(new Game(GameLevel3.class));
//					mainWindow.setVisible(true);
//					mainFrame.setVisible(false);
//				} catch (InstantiationException e1) {
//					e1.printStackTrace();
//				} catch (IllegalAccessException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				/*
				 * TODO View de creditos: que aparezca el personaje en la
				 * pantalla apagada como el juego y cuando se va moviendo van
				 * descubriendo los creditos.
				 */
			}
		});

		controlPanel.add(level1Button);
		controlPanel.add(level2Button);
		controlPanel.add(level3Button);
		controlPanel.add(exitButton);

		mainFrame.setVisible(true);
	}
	
	
	private MouseListener getMouseListener(final ClipName hoverClip, final Class<?> level ){
		
		MouseListener listener = new MouseListener() {
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				SoundManager.play(hoverClip);
				
			}			
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				SoundManager.stop(hoverClip);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Main mainWindow = new Main(new Game(level));
					mainWindow.setVisible(true);
					mainFrame.setVisible(false);
					SoundManager.stopSounds();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
