public class Paladin extends Knight {
	public Paladin(int baseHp, int wp) {
		super(baseHp, wp);
	}

	/*
	 ! Paladin:	
	 *     When a Paladin does battle, his CombatScore would be	triple of his baseHP on	any ground.	
	 * Since Paladin is	from Heaven, his CombatScore can exceed	999. 
	 * Especially, if	baseHP of a	Paladin	is a Fibonacci number Fn with n > 2, his CombatScore will be	
	 * 1000 + n.	
	 ? For example, if a Paladin has baseHP is 34 (=F9), his CombatScore will be 1009.
	 */
	@Override
	public double getCombatScore() {
		int baseHp = this.getBaseHp();
		int orderFibonacci = Utility.getFibonacciIndex(baseHp);
		if (orderFibonacci > 2) {
			return 1000 + Utility.getFibonacciIndex(baseHp);
		}
		return 3 * baseHp;
	}
}
