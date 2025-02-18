public class UnitTest {
    public static void main(String[] args) {
        // Tạo các nhân vật
        Knight knight = new Knight(120, 2);
        Warrior warrior = new Warrior(150, 1);
        Paladin paladin = new Paladin(34, 0);  // 34 là số Fibonacci
        DeathEater deathEater = new DeathEater(new Complex(300, 200));

        // Kiểm tra CombatScore trên các loại địa hình
        int[] testGrounds = {10, 17, 25};  // 10: bình thường, 17: số nguyên tố, 25: số chính phương

        System.out.println("===== Test Combat Score on many ground =====");
        for (int ground : testGrounds) {
            System.out.println("Ground Number: " + ground);
            System.out.println("Knight: " + knight.getCombatScore());
            System.out.println("Warrior: " + warrior.getCombatScore());
            System.out.println("Paladin: " + paladin.getCombatScore());
            System.out.println("DeathEater: " + deathEater.getCombatScore());
            System.out.println("---------------------------------");
        }

        // Kiểm tra Complex class
        Complex c1 = new Complex(5, -7);
        Complex c2 = new Complex(-3, 4);
        System.out.println("\n===== Test Complex Numbers =====");
        System.out.println("Complex 1: " + c1);
        System.out.println("Complex 2: " + c2);
    }
}
