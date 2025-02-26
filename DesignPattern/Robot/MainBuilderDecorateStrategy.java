package DesignPattern.Robot;
import DesignPattern.Robot.Creational.CombatRobot;
import DesignPattern.Robot.Structural.BasicRobot;
import DesignPattern.Robot.Structural.Robot;
import DesignPattern.Robot.Structural.WeaponDecorator;
import DesignPattern.Robot.Structural.ShieldDecorator;
import DesignPattern.Robot.Behavioral.BattleContext;
import DesignPattern.Robot.Behavioral.OffensiveStrategy;
import DesignPattern.Robot.Behavioral.DefensiveStrategy;

public class MainBuilderDecorateStrategy {
    public static void main(String[] args) {
        // Creational – Builder: Tạo CombatRobot với các thuộc tính khác nhau
        CombatRobot robot = new CombatRobot.Builder("Warrior-X")
                                .setModel("RX-78")
                                .setBatteryCapacity(1000)
                                .setWeapon("Laser Blaster")
                                .setArmor("Titanium Alloy")
                                .setSpeed(120)
                                .build();
        System.out.println("=== Combat Robot Created via Builder Pattern ===");
        robot.displaySpecs();
        
        // Structural – Decorator: Nâng cấp một BasicRobot bằng cách thêm vũ khí và lá chắn
        Robot basicRobot = new BasicRobot();
        System.out.println("\n=== Basic Robot Features ===");
        basicRobot.displayFeatures();
        
        Robot decoratedRobot = new ShieldDecorator(new WeaponDecorator(basicRobot));
        System.out.println("\n=== Decorated Robot Features (with Weapon and Shield) ===");
        decoratedRobot.displayFeatures();
        
        // Behavioral – Strategy: Chọn chiến lược tấn công hay phòng thủ trong trận đấu
        BattleContext battleContext = new BattleContext();
        System.out.println("\n=== Battle Strategy Execution ===");
        
        battleContext.setStrategy(new OffensiveStrategy());
        battleContext.executeStrategy();
        
        battleContext.setStrategy(new DefensiveStrategy());
        battleContext.executeStrategy();
    }
}
