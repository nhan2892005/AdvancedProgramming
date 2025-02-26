package DesignPattern.Robot.Structural;

public abstract class RobotDecorator implements Robot {
    protected Robot decoratedRobot;
    
    public RobotDecorator(Robot decoratedRobot) {
        this.decoratedRobot = decoratedRobot;
    }
    
    @Override
    public void displayFeatures() {
        decoratedRobot.displayFeatures();
    }
}
