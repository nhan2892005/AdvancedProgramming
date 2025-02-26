package DesignPattern.Robot.Behavioral;

public class BattleContext {
    private BattleStrategy strategy;
    
    public void setStrategy(BattleStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void executeStrategy() {
        if(strategy != null) {
            strategy.executeStrategy();
        } else {
            System.out.println("No battle strategy set.");
        }
    }
}