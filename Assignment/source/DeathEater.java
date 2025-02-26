
public class DeathEater extends Monster implements Combatable {
	public DeathEater(Complex mana) {
		super(mana);
	}

	/*
	 ! DeathEater:A	DeathEater is a	monster, who has no	HP but only MP being a complex number
	 * C = (real, imaginary).
	 * When	combatting,	CombatScore	of a Death Eater would be sqrt(real^2 + imaginary^2).
	 */
	@Override
	public double getCombatScore() {
		Complex mana = this.getMana();
		return mana.getMagnitude();
	}
}
