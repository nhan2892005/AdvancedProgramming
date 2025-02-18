public class Warrior extends Fighter {
    public Warrior(int baseHp, int wp) {
        super(baseHp, wp);
    }

    /*
     ! Warrior:
     *     Normally, when battle’s ground is regular numbber, the CombatScore of a Warrior is based on his WP
     * and baseHP. If WP is	1, the CombatScore is the baseHP. Otherwise, the CombatScore is baseHP / 10.		
     *     There is special cases of ground number. 
     ? If ground is a prime number,	
     * the	CombatScore	of Warriors	will be	double of their	baseHP.		
     */
    @Override
    public double getCombatScore() {
        if (this.getWp() == 1) {
            return this.getBaseHp();
        } else {
            return this.getBaseHp() / 10.0;
        }
    }
}
