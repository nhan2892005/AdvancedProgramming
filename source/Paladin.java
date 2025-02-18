public class Paladin extends Knight {
	public Paladin(int baseHp, int wp) {
		super(baseHp, wp);
	}

	public static int getFibonacciIndex(int n) {
        // Với dãy Fibonacci định nghĩa như trên, chỉ xét n >= 1
        if (n < 1) return -1;
        // Vì 1 xuất hiện ở vị trí F1 và F2, ta chọn trả về vị trí đầu tiên (F1)
        if (n == 1) return 1;
        
        int index = 2; // b là F2
        int a = 1, b = 1;
        
        // Tính các số Fibonacci tiếp theo cho đến khi b >= n
        while (b < n) {
            int c = a + b;
            a = b;
            b = c;
            index++;
            if (b == n) {
                return index;
            }
        }
        
        return -1;
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
		int orderFibonacci = getFibonacciIndex(baseHp);
		if (orderFibonacci > 2) {
			return 1000 + getFibonacciIndex(baseHp);
		}
		return 3 * baseHp;
	}
}
