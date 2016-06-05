package view;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

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
				images.put(Hero.class.getName(), ImageUtils.loadImage("resources/person/guy/guy1.gif"));
				images.put(Cell.class.getName(), ImageUtils.loadImage("resources/hell/floor.png"));
				images.put("FOG", ImageUtils.loadImage("resources/fog.png"));
				images.put(Golem.class.getName(), ImageUtils.loadImage("resources/hell/monster/Arch.gif"));
				images.put(Blood.class.getName(), ImageUtils.loadImage("resources/items/EchoHerbs.gif"));
				images.put(Goblin.class.getName(), ImageUtils.loadImage("resources/hell/monster/Bomb.gif"));
				images.put(Snake.class.getName(), ImageUtils.loadImage("resources/hell/monster/Behemoth.gif"));
				images.put(Sword.class.getName(), ImageUtils.loadImage("resources/items/Excalibur.gif"));
				images.put(Wall.class.getName(), ImageUtils.loadImage("resources/hell/wall.gif"));
				images.put(HealthBonus.class.getName(), ImageUtils.loadImage("resources/healthbonus.png"));
				images.put(HealthPotion.class.getName(), ImageUtils.loadImage("resources/items/Hi-Potion.gif"));
				images.put(StrengthBonus.class.getName(), ImageUtils.loadImage("resources/items/Excalibur.gif"));				
				images.put(HeroArmor.class.getName(), ImageUtils.loadImage("resources/person/guy/power1.gif"));
				images.put(HeroSword.class.getName(), ImageUtils.loadImage("resources/person/guy/power1.gif"));
				images.put(Armor.class.getName(), ImageUtils.loadImage("resources/items/MythrilShield.gif"));
				break;
			case PURGATORY:
				images.put(Hero.class.getName(), ImageUtils.loadImage("resources/person/guy/guy2.gif"));
				images.put(Cell.class.getName(), ImageUtils.loadImage("resources/purgatory/floor.png"));
				images.put("FOG", ImageUtils.loadImage("resources/fog.png"));
				images.put(Golem.class.getName(), ImageUtils.loadImage("resources/golem.png"));
				images.put(Blood.class.getName(), ImageUtils.loadImage("resources/items/EchoHerbs.gif"));
				images.put(Goblin.class.getName(), ImageUtils.loadImage("resources/goblin.png"));
				images.put(Snake.class.getName(), ImageUtils.loadImage("resources/Serpent.png"));
				images.put(Sword.class.getName(), ImageUtils.loadImage("resources/sword.png"));
				images.put(Wall.class.getName(), ImageUtils.loadImage("resources/purgatory/wall.png"));
				images.put(HealthBonus.class.getName(), ImageUtils.loadImage("resources/healthbonus.png"));
				images.put(HealthPotion.class.getName(), ImageUtils.loadImage("resources/items/Hi-Potion.gif"));
				images.put(StrengthBonus.class.getName(), ImageUtils.loadImage("resources/items/Excalibur.gif"));
				images.put(HeroArmor.class.getName(), ImageUtils.loadImage("resources/person/guy/power2.gif"));
				images.put(HeroSword.class.getName(), ImageUtils.loadImage("resources/person/guy/power2.gif"));
				images.put(Armor.class.getName(), ImageUtils.loadImage("resources/armor.png"));				
				break;
			case HEAVEN:
				images.put(Hero.class.getName(), ImageUtils.loadImage("resources/person/guy/guy3.gif"));
				images.put(Cell.class.getName(), ImageUtils.loadImage("resources/heaven/floor.png"));
				images.put("FOG", ImageUtils.loadImage("resources/fog.png"));
				images.put(Golem.class.getName(), ImageUtils.loadImage("resources/golem.png"));
				images.put(Blood.class.getName(), ImageUtils.loadImage("resources/items/EchoHerbs.gif"));
				images.put(Goblin.class.getName(), ImageUtils.loadImage("resources/goblin.png"));
				images.put(Snake.class.getName(), ImageUtils.loadImage("resources/Serpent.png"));
				images.put(Sword.class.getName(), ImageUtils.loadImage("resources/sword.png"));
				images.put(Wall.class.getName(), ImageUtils.loadImage("resources/heaven/wall.png"));
				images.put(HealthBonus.class.getName(), ImageUtils.loadImage("resources/healthbonus.png"));
				images.put(HealthPotion.class.getName(), ImageUtils.loadImage("resources/items/Hi-Potion.gif"));
				images.put(StrengthBonus.class.getName(), ImageUtils.loadImage("resources/items/Excalibur.gif"));
				images.put(HeroArmor.class.getName(), ImageUtils.loadImage("resources/person/guy/power3.gif"));
				images.put(HeroSword.class.getName(), ImageUtils.loadImage("resources/person/guy/power3.gif"));
				images.put(Armor.class.getName(), ImageUtils.loadImage("resources/armor.png"));

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
