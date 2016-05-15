package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.Game;
import model.board.level.GameLevel1;

public class MenuDemo {

	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;

	   public MenuDemo(){
	      prepareGUI();
	   }

	   public static void main(String[] args){
		   MenuDemo  swingControlDemo = new MenuDemo();      
	      swingControlDemo.showButtonDemo();
	   }

	   private void prepareGUI(){
	      mainFrame = new JFrame("Java Swing Examples");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);    

	      statusLabel.setSize(350,100);

	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	    
	   private static ImageIcon createImageIcon(String path, 
	      String description) {
	      java.net.URL imgURL = MenuDemo.class.getResource(path);
	      if (imgURL != null) {
	         return new ImageIcon(imgURL, description);
	      } else {            
	         System.err.println("Couldn't find file: " + path);
	         return null;
	      }
	   }   

	   private void showButtonDemo(){

	      headerLabel.setText("Nombre del juego"); 

	      //resources folder should be inside SWING folder.
	      ImageIcon icon = createImageIcon("/resources/java_icon.png","Java");
	      
	      JButton level1Button = new JButton("Level 1");        
	      JButton level2Button = new JButton("Level 2", icon);
	      JButton level3Button = new JButton("Level 3", icon);
	      JButton exitButton = new JButton("Salir", icon);
	      level3Button.setHorizontalTextPosition(SwingConstants.LEFT);   

	      level1Button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
				try {
					Main mainWindow = new Main(new Game(GameLevel1.class));
					mainWindow.setVisible(true);
					mainFrame.setVisible(false);  
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	    		
	         }          
	      });

	      level2Button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            statusLabel.setText("Level 2 Button clicked.");
	         }
	      });

	      level3Button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            statusLabel.setText("Level 3 Button clicked.");
	         }
	      });
	      
	      exitButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		            statusLabel.setText("Exit Button clicked.");
		         }
		  });

	      controlPanel.add(level1Button);
	      controlPanel.add(level2Button);
	      controlPanel.add(level3Button);   
	      controlPanel.add(exitButton);  

	      mainFrame.setVisible(true);  
	   }
}
