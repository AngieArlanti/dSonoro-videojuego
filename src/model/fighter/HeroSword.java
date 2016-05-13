package model.fighter;

import model.element.Sword;

/**
 * La clase <code>HeroSword</code>, al extender de Hero, va a tener encapsulado un fighter y ademas agrega una
 * espada <code>sword</code>. Este se comporta de igual manera que el tipo de hero encapsulado, pero agrega la capacidad atacar
 * con mas fuerza, y eso se logra haciendo <code>Override</code> del metodo <code>strength</code>.
 */

public class HeroSword extends Hero{
	
	private Sword sword;

	public HeroSword(Fighter hero, Sword sword) {
		super(hero);
		this.sword = sword;
	}
	
	public int getStrength(){
		return super.getStrength()+sword.getValue();
		
	}
}
