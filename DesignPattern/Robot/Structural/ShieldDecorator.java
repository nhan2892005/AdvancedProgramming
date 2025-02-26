package DesignPattern.Robot.Structural;

public class ShieldDecorator extends RobotDecorator {
    
    public ShieldDecorator(Robot decoratedRobot) {
        super(decoratedRobot);
    }
    
    @Override
    public void displayFeatures() {
        super.displayFeatures();
        addShield();
    }
    
    private void addShield() {
        System.out.println("ShieldDecorator: Equipping energy shield.");
    }
}
