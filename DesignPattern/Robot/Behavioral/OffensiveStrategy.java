package DesignPattern.Robot.Behavioral;

public class OffensiveStrategy implements BattleStrategy {
    @Override
    public void executeStrategy() {
        System.out.println("OffensiveStrategy: Launching a full-scale attack!");
    }
}
