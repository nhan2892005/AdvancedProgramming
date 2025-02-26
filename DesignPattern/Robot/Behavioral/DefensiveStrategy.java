package DesignPattern.Robot.Behavioral;

public class DefensiveStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("DefensiveStrategy: Activating shields and defensive maneuvers!");
    }
}