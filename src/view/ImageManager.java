package view;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

import model.board.Cell;
import model.board.Content;
import model.board.level.Levels;
import model.element.*;
import model.fighter.*;
import model.fighter.opponent.*;

public class ImageManager {
	
	private Map<String, Image> images = new HashMap<String, Image>();
	
	public ImageManager(Levels level) {
		initImages(level);
	}

	public void initImages(Levels level) {
		try{
			switch (level) {
			case HELL:
				images.put(Hero.class.getName(), new ImageIcon(ImageManager.class.getResource("/person/guy/guy1.gif")).getImage());
				images.put(Cell.class.getName(), new ImageIcon(ImageManager.class.getResource("/hell/floor.png")).getImage());
				images.put("FOG", new ImageIcon(ImageManager.class.getResource("/fog.png")).getImage());
				images.put(Golem.class.getName(), new ImageIcon(ImageManager.class.getResource("/hell/monster/Arch.gif")).getImage());
				images.put(Blood.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/EchoHerbs.gif")).getImage());
				images.put(Goblin.class.getName(), new ImageIcon(ImageManager.class.getResource("/hell/monster/Bomb.gif")).getImage());
				images.put(Snake.class.getName(), new ImageIcon(ImageManager.class.getResource("/hell/monster/Behemoth.gif")).getImage());
				images.put(Sword.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/Excalibur.gif")).getImage());
				images.put(Wall.class.getName(), new ImageIcon(ImageManager.class.getResource("/hell/wall.gif")).getImage());
				images.put(HealthBonus.class.getName(), new ImageIcon(ImageManager.class.getResource("/healthbonus.png")).getImage());
				images.put(HealthPotion.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/Hi-Potion.gif")).getImage());
				images.put(StrengthBonus.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/Excalibur.gif")).getImage());				
				images.put(HeroArmor.class.getName(), new ImageIcon(ImageManager.class.getResource("/person/guy/power1.gif")).getImage());
				images.put(HeroSword.class.getName(), new ImageIcon(ImageManager.class.getResource("/person/guy/power1.gif")).getImage());
				images.put(Armor.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/MythrilShield.gif")).getImage());
				break;
			case PURGATORY:
				images.put(Hero.class.getName(), new ImageIcon(ImageManager.class.getResource("/person/guy/guy2.gif")).getImage());
				images.put(Cell.class.getName(), new ImageIcon(ImageManager.class.getResource("/purgatory/floor.png")).getImage());
				images.put("FOG", new ImageIcon(ImageManager.class.getResource("/fog.png")).getImage());
				images.put(Golem.class.getName(), new ImageIcon(ImageManager.class.getResource("/purgatory/enemies/ira.gif")).getImage());
				images.put(Blood.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/EchoHerbs.gif")).getImage());
				images.put(Goblin.class.getName(), new ImageIcon(ImageManager.class.getResource("/purgatory/enemies/avaricia.gif")).getImage());
				images.put(Snake.class.getName(), new ImageIcon(ImageManager.class.getResource("/purgatory/enemies/gula.gif")).getImage());
				images.put(Sword.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/Excalibur.gif")).getImage());
				images.put(Wall.class.getName(), new ImageIcon(ImageManager.class.getResource("/purgatory/wall.gif")).getImage());
				images.put(HealthBonus.class.getName(), new ImageIcon(ImageManager.class.getResource("/healthbonus.png")).getImage());
				images.put(HealthPotion.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/Hi-Potion.gif")).getImage());
				images.put(StrengthBonus.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/Excalibur.gif")).getImage());
				images.put(HeroArmor.class.getName(), new ImageIcon(ImageManager.class.getResource("/person/guy/power2.gif")).getImage());
				images.put(HeroSword.class.getName(), new ImageIcon(ImageManager.class.getResource("/person/guy/power2.gif")).getImage());
				images.put(Armor.class.getName(), new ImageIcon(ImageManager.class.getResource("/items/MythrilShield.gif")).getImage());				
				break;
			case HEAVEN:
				images.put(Hero.class.getName(),  new ImageIcon(ImageManager.class.getResource("/person/guy/guy3.gif")).getImage());
				images.put(Cell.class.getName(),  new ImageIcon(ImageManager.class.getResource("/heaven/floor.png")).getImage());
				images.put("FOG",  new ImageIcon(ImageManager.class.getResource("/fog.png")).getImage());
				images.put(Golem.class.getName(),  new ImageIcon(ImageManager.class.getResource("/heaven/enemies/Dragoon.gif")).getImage());
				images.put(Blood.class.getName(),  new ImageIcon(ImageManager.class.getResource("/items/EchoHerbs.gif")).getImage());
				images.put(Goblin.class.getName(),  new ImageIcon(ImageManager.class.getResource("/heaven/enemies/Rapha.gif")).getImage());
				images.put(Snake.class.getName(),  new ImageIcon(ImageManager.class.getResource("/heaven/enemies/DarkKnight.gif")).getImage());
				images.put(Sword.class.getName(),  new ImageIcon(ImageManager.class.getResource("/items/Excalibur.gif")).getImage());
				images.put(Wall.class.getName(),  new ImageIcon(ImageManager.class.getResource("/heaven/wall.gif")).getImage());
				images.put(HealthBonus.class.getName(),  new ImageIcon(ImageManager.class.getResource("/healthbonus.png")).getImage());
				images.put(HealthPotion.class.getName(),  new ImageIcon(ImageManager.class.getResource("/items/Hi-Potion.gif")).getImage());
				images.put(StrengthBonus.class.getName(),  new ImageIcon(ImageManager.class.getResource("/items/Excalibur.gif")).getImage());
				images.put(HeroArmor.class.getName(),  new ImageIcon(ImageManager.class.getResource("/person/guy/power3.gif")).getImage());
				images.put(HeroSword.class.getName(),  new ImageIcon(ImageManager.class.getResource("/person/guy/power3.gif")).getImage());
				images.put(Armor.class.getName(),  new ImageIcon(ImageManager.class.getResource("/armor.png")).getImage());
				images.put(Victim.class.getName(),  new ImageIcon(ImageManager.class.getResource("/heaven/victim/victim1.gif")).getImage());
				images.put(Person.class.getName(),  new ImageIcon(ImageManager.class.getResource("/heaven/victim/victimA.gif")).getImage());
				break;

			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Image get(Cell cell) {
		if (cell.hasContent()) {
			Content content = cell.getContent();
			if (content instanceof Fighter) {
				Fighter fighter = (Fighter) content;
				Image image = ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(fighter.getClass().getName()));
				return ImageUtils.drawString(image, String.valueOf(fighter.getLevel().getValue()), Color.CYAN);
			} else if(content instanceof Valuable) {
				Valuable valuable = (Valuable) content;
				Image image = ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(valuable.getClass().getName()));
				return ImageUtils.drawString(image, String.valueOf(valuable.getValue()), Color.YELLOW);
			} else {
				return ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(cell.getContent().getClass().getName()));
			}
		} else {
			return images.get(cell.getClass().getName());
		}
		
	}
	
	public Image get(String key) {
		return images.get(key);
	}
}
