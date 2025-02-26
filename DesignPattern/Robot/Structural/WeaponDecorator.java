package DesignPattern.Robot.Structural;

public class WeaponDecorator extends RobotDecorator {
    
    public WeaponDecorator(Robot decoratedRobot) {
        super(decoratedRobot);
    }
    
    @Override
    public void displayFeatures() {
        super.displayFeatures();
        addWeapon();
    }
    
    private void addWeapon() {
        System.out.println("WeaponDecorator: Adding advanced weaponry.");
    }
}
