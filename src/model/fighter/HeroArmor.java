package model.fighter;

import model.element.Armor;

/**
 * La clase <code>HeroArmor</code>, al extender de Hero, va a tener encapsulado un fighter y ademas agrega un 
 * escudo <code>Armor</code>. Este se comporta de igual manera que el tipo de hero encapsulado, pero agrega la capacidad de
 * ser mas resistente a los golpes, y eso se logra haciendo <code>Override</code> del metodo <code>injured</code>.
 */

public class HeroArmor extends Hero {

	private Armor armor;	
	
	public HeroArmor(Fighter hero, Armor armor) {
		super(hero);
		this.armor=armor;
	}

	@Override
	public void injured(int value) {
		super.injured((int)(value*(1-0.1*armor.getValue())));
	}
	
	
}
