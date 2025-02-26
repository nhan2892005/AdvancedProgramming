public class UnitTest {
    // ANSI color codes for terminal output
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String RESET = "\u001B[0m";
    
    private static int passedTests = 0;
    private static int totalTests = 0;

    public static void main(String[] args) {
        testKnightCombatScores();
        testWarriorCombatScores();
        testPaladinSpecialCases();
        testDeathEaterMagnitude();
        testGroundEffects();
        testComplexOperations();
        testFibonacciDetection();
        testPolymorphism();
        testTeamMaker();
        testEdgeCases();
        
        // Print summary
        System.out.println("\n===== TEST SUMMARY =====");
        System.out.println("PASSED: " + passedTests + "/" + totalTests + " tests");
        if (passedTests == totalTests) {
            System.out.println(GREEN + "All tests passed!" + RESET);
        } else {
            System.out.println(RED + "Some tests failed!" + RESET);
        }
    }

    // Test utility method for comparing double values
    private static void assertDoubleEquals(String testName, double expected, double actual) {
        totalTests++;
        if (Math.abs(expected - actual) < 0.0001) {
            passedTests++;
            System.out.println(GREEN + "PASS: " + testName + RESET);
        } else {
            System.out.println(RED + "FAIL: " + testName);
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual: " + actual + RESET);
        }
    }
    
    // Test utility method for comparing boolean values
    private static void assertTrue(String testName, boolean condition) {
        totalTests++;
        if (condition) {
            passedTests++;
            System.out.println(GREEN + "PASS: " + testName + RESET);
        } else {
            System.out.println(RED + "FAIL: " + testName + RESET);
        }
    }

    // Test Case 1: Knight combat scores with different WP values and grounds
    private static void testKnightCombatScores() {
        System.out.println("\n===== Test Knight Combat Scores =====");
        Knight knight1 = new Knight(100, 1);  // WP = 1
        Knight knight2 = new Knight(100, 2);  // WP > 1
        
        // Regular ground
        Battle.GROUND = 10;
        System.out.println("Regular Ground (10):");
        assertDoubleEquals("Knight(100,1) on regular ground", 100.0, knight1.getCombatScore());
        assertDoubleEquals("Knight(100,2) on regular ground", 10.0, knight2.getCombatScore());
        
        // Square ground
        Battle.GROUND = 25;
        System.out.println("Square Ground (25):");
        assertDoubleEquals("Knight(100,1) on square ground", 200.0, knight1.getCombatScore());
        assertDoubleEquals("Knight(100,2) on square ground", 200.0, knight2.getCombatScore());
    }
    
    // Test Case 2: Warrior combat scores with different WP values and grounds
    private static void testWarriorCombatScores() {
        System.out.println("\n===== Test Warrior Combat Scores =====");
        Warrior warrior1 = new Warrior(150, 1);  // WP = 1
        Warrior warrior2 = new Warrior(150, 2);  // WP > 1
        
        // Regular ground
        Battle.GROUND = 10;
        System.out.println("Regular Ground (10):");
        assertDoubleEquals("Warrior(150,1) on regular ground", 150.0, warrior1.getCombatScore());
        assertDoubleEquals("Warrior(150,2) on regular ground", 15.0, warrior2.getCombatScore());
        
        // Prime ground
        Battle.GROUND = 17;
        System.out.println("Prime Ground (17):");
        assertDoubleEquals("Warrior(150,1) on prime ground", 300.0, warrior1.getCombatScore());
        assertDoubleEquals("Warrior(150,2) on prime ground", 300.0, warrior2.getCombatScore());
    }
    
    // Test Case 3: Paladin special cases with Fibonacci numbers
    private static void testPaladinSpecialCases() {
        System.out.println("\n===== Test Paladin Special Cases =====");
        Paladin normalPaladin = new Paladin(100, 1);  // Not Fibonacci
        Paladin fibPaladin1 = new Paladin(13, 1);     // F7
        Paladin fibPaladin2 = new Paladin(34, 1);     // F9
        
        assertDoubleEquals("Paladin(100,1) normal case", 300.0, normalPaladin.getCombatScore());
        assertDoubleEquals("Paladin(13,1) Fibonacci F7 case", 1007.0, fibPaladin1.getCombatScore());
        assertDoubleEquals("Paladin(34,1) Fibonacci F9 case", 1009.0, fibPaladin2.getCombatScore());
        
        // Verify Fibonacci detection
        assertTrue("13 is F7", Utility.getFibonacciIndex(13) == 7);
        assertTrue("34 is F9", Utility.getFibonacciIndex(34) == 9);
    }
    
    // Test Case 4: DeathEater magnitude calculations
    private static void testDeathEaterMagnitude() {
        System.out.println("\n===== Test DeathEater Magnitude =====");
        DeathEater de1 = new DeathEater(new Complex(3, 4));     // Magnitude = 5
        DeathEater de2 = new DeathEater(new Complex(300, 400)); // Magnitude = 500
        
        assertDoubleEquals("DeathEater(3,4) magnitude", 5.0, de1.getCombatScore());
        assertDoubleEquals("DeathEater(300,400) magnitude", 500.0, de2.getCombatScore());
    }
    
    // Test Case 5: Ground effects on all character types
    private static void testGroundEffects() {
        System.out.println("\n===== Test Ground Effects =====");
        Knight knight = new Knight(100, 1);
        Warrior warrior = new Warrior(150, 1);
        Paladin paladin = new Paladin(50, 1);
        DeathEater deathEater = new DeathEater(new Complex(30, 40)); // Magnitude = 50
        
        // Regular ground (10)
        Battle.GROUND = 10;
        assertDoubleEquals("Knight on regular ground", 100.0, knight.getCombatScore());
        assertDoubleEquals("Warrior on regular ground", 150.0, warrior.getCombatScore());
        assertDoubleEquals("Paladin on regular ground", 150.0, paladin.getCombatScore());
        assertDoubleEquals("DeathEater on regular ground", 50.0, deathEater.getCombatScore());
        
        // Prime ground (17)
        Battle.GROUND = 17;
        assertDoubleEquals("Knight on prime ground", 100.0, knight.getCombatScore());
        assertDoubleEquals("Warrior on prime ground", 300.0, warrior.getCombatScore());
        assertDoubleEquals("Paladin on prime ground", 150.0, paladin.getCombatScore());
        assertDoubleEquals("DeathEater on prime ground", 50.0, deathEater.getCombatScore());
        
        // Square ground (25)
        Battle.GROUND = 25;
        assertDoubleEquals("Knight on square ground", 200.0, knight.getCombatScore());
        assertDoubleEquals("Warrior on square ground", 150.0, warrior.getCombatScore());
        assertDoubleEquals("Paladin on square ground", 150.0, paladin.getCombatScore());
        assertDoubleEquals("DeathEater on square ground", 50.0, deathEater.getCombatScore());
    }
    
    // Test Case 6: Complex number operations
    private static void testComplexOperations() {
        System.out.println("\n===== Test Complex Number Operations =====");
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(-5, 12);
        
        assertDoubleEquals("Complex(3,4) real part", 3.0, c1.getRe());
        assertDoubleEquals("Complex(3,4) imaginary part", 4.0, c1.getIm());
        assertDoubleEquals("Complex(3,4) magnitude", 5.0, c1.getMagnitude());
        assertDoubleEquals("Complex(-5,12) magnitude", 13.0, c2.getMagnitude());
    }
    
    // Test Case 7: Fibonacci detection
    private static void testFibonacciDetection() {
        System.out.println("\n===== Test Fibonacci Detection =====");
        int[] fibNumbers = {2, 3, 5, 8, 13, 21, 34, 55};
        int[] expectedIndices = {3, 4, 5, 6, 7, 8, 9, 10};
        
        for (int i = 0; i < fibNumbers.length; i++) {
            int actual = Utility.getFibonacciIndex(fibNumbers[i]);
            assertTrue(fibNumbers[i] + " is F" + expectedIndices[i], actual == expectedIndices[i]);
            if (actual != expectedIndices[i]) {
                System.out.println("  Expected: " + expectedIndices[i]);
                System.out.println("  Actual: " + actual);
            }
        }
        
        // Non-Fibonacci numbers should return -1
        int[] nonFibNumbers = {4, 6, 7, 9, 10, 11, 12, 14};
        for (int n : nonFibNumbers) {
            assertTrue(n + " is not a Fibonacci number", Utility.getFibonacciIndex(n) == -1);
        }
    }
    
    // Test Case 8: Polymorphism test
    private static void testPolymorphism() {
        System.out.println("\n===== Test Polymorphism =====");
        Combatable[] fighters = new Combatable[] {
            new Knight(100, 1),
            new Warrior(150, 1),
            new Paladin(21, 1),
            new DeathEater(new Complex(30, 40))
        };
        
        double[] expectedScores = {100.0, 150.0, 1008.0, 50.0}; // Regular ground
        
        Battle.GROUND = 10; // Regular ground
        for (int i = 0; i < fighters.length; i++) {
            assertDoubleEquals(
                "Fighter " + i + " (" + fighters[i].getClass().getSimpleName() + ") score",
                expectedScores[i], 
                fighters[i].getCombatScore()
            );
        }
    }
    
    // Test Case 9: TeamMaker functionality
    private static void testTeamMaker() {
        System.out.println("\n===== Test TeamMaker =====");
        Battle.GROUND = 10; // Regular ground
        
        Combatable[] team1 = TeamMaker.makeTeam1();
        Combatable[] team2 = TeamMaker.makeTeam2();
        
        // Just verify teams are created with correct sizes
        assertTrue("Team1 has 3 members", team1.length == 3);
        assertTrue("Team2 has 3 members", team2.length == 3);
        
        // Verify all members implement Combatable (will compile-time check)
        for (int i = 0; i < team1.length; i++) {
            assertTrue("Team1 member " + i + " is Combatable", 
                      team1[i] != null && team1[i] instanceof Combatable);
        }
        
        for (int i = 0; i < team2.length; i++) {
            assertTrue("Team2 member " + i + " is Combatable", 
                      team2[i] != null && team2[i] instanceof Combatable);
        }
    }
    
    // Test Case 10: Edge cases
    private static void testEdgeCases() {
        System.out.println("\n===== Test Edge Cases =====");
        
        // Edge case 1: Knight with 0 baseHP
        Knight zeroHpKnight = new Knight(0, 1);
        assertDoubleEquals("Knight(0,1) score", 0.0, zeroHpKnight.getCombatScore());
        
        // Edge case 2: DeathEater with zero complex
        DeathEater zeroManaDeathEater = new DeathEater(new Complex(0, 0));
        assertDoubleEquals("DeathEater(0,0) score", 0.0, zeroManaDeathEater.getCombatScore());
        
        // Edge case 3: Extremely high baseHP Paladin
        Paladin giantPaladin = new Paladin(999, 1);
        assertDoubleEquals("Paladin(999,1) score", 2997.0, giantPaladin.getCombatScore());
        
        // Edge case 4: Paladin with Fibonacci number 1
        Paladin edgeFibPaladin = new Paladin(1, 1);
        assertDoubleEquals("Paladin(1,1) score", 3.0, edgeFibPaladin.getCombatScore());
        assertTrue("Fibonacci Index of 34 is 9", Utility.getFibonacciIndex(34) == 9);
        
        // Edge case 5: Ground number effects at boundaries
        int[] specialGrounds = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,17,25,30,50,100};
        double[][] expectedScores = {
            {200.0, 150.0, 200.0, 15.0}, // Ground 0
            {200.0, 150.0, 200.0, 15.0}, // Ground 1
            {100.0, 300.0, 10.0, 300.0}, // Ground 2
            {100.0, 300.0, 10.0, 300.0}, // Ground 3
            {200.0, 150.0, 200.0, 15.0}, // Ground 4
            {100.0, 300.0, 10.0, 300.0}, // Ground 5
            {100.0, 150.0, 10.0, 15.0}, // Ground 6
            {100.0, 300.0, 10.0, 300.0}, // Ground 7
            {100.0, 150.0, 10.0, 15.0}, // Ground 8
            {200.0, 150.0, 200.0, 15.0}, // Ground 9
            {100.0, 150.0, 10.0, 15.0}, // Ground 10
            {100.0, 300.0, 10.0, 300.0}, // Ground 11
            {100.0, 150.0, 10.0, 15.0}, // Ground 12
            {100.0, 300.0, 10.0, 300.0}, // Ground 13
            {100.0, 300.0, 10.0, 300.0}, // Ground 17 (Prime)
            {200.0, 150.0, 200.0, 15.0}, // Ground 25 (Square)
            {100.0, 150.0, 10.0, 15.0}, // Ground 30
            {100.0, 150.0, 10.0, 15.0}, // Ground 50
            {200.0, 150.0, 200.0, 15.0} // Ground 100
        };
        
        Warrior warrior = new Warrior(150, 1);
        Knight knight = new Knight(100, 1);
        Warrior warrior2 = new Warrior(150, 2);
        Knight knight2 = new Knight(100, 2);
        
        for (int i = 0; i < specialGrounds.length; i++) {
            Battle.GROUND = specialGrounds[i];
            assertDoubleEquals(
                "Knight score on ground " + specialGrounds[i], 
                expectedScores[i][0], 
                knight.getCombatScore()
            );
            assertDoubleEquals(
                "Warrior score on ground " + specialGrounds[i], 
                expectedScores[i][1], 
                warrior.getCombatScore()
            );
            assertDoubleEquals(
                "Knight2 score on ground " + specialGrounds[i], 
                expectedScores[i][2], 
                knight2.getCombatScore()
            );
            assertDoubleEquals(
                "Warrior2 score on ground " + specialGrounds[i], 
                expectedScores[i][3], 
                warrior2.getCombatScore()
            );
        }
    }
}