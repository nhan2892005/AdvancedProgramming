public class Knight extends Fighter {
    public Knight(int baseHp, int wp) {
        super(baseHp, wp);
    }

    /*
     ! Knight:
     *     Normally, when battle’s ground is regular numbber, the CombatScore of a Knight is based on his WP
     * and baseHP. If WP is	1, the CombatScore is the baseHP. Otherwise, the CombatScore is baseHP / 10.		
     *     There is special cases of ground number. 
     ? If ground is	a square number, 
     * the CombatScore of Knights will be double of their baseHP.	
     */
    @Override
    public double getCombatScore() {
        double combatScore = 0.0;

        if (Utility.isSquare(Battle.GROUND)) {
            combatScore = this.getBaseHp() * 2.0;
        } else if (this.getWp() == 1) {
            combatScore = this.getBaseHp();
        } else {
            combatScore = this.getBaseHp() / 10.0;
        }

        combatScore = Math.max(0.0, Math.min(999.0, combatScore));

        return combatScore;
    }
}
