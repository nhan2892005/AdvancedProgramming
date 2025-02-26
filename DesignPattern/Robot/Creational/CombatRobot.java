package DesignPattern.Robot.Creational;

public class CombatRobot {
    private final String name;
    private final String model;
    private final int batteryCapacity;
    private final String weapon;
    private final String armor;
    private final int speed;
    
    private CombatRobot(Builder builder) {
        this.name = builder.name;
        this.model = builder.model;
        this.batteryCapacity = builder.batteryCapacity;
        this.weapon = builder.weapon;
        this.armor = builder.armor;
        this.speed = builder.speed;
    }
    
    public void displaySpecs() {
        System.out.println("CombatRobot Specs:");
        System.out.println("Name: " + name);
        System.out.println("Model: " + model);
        System.out.println("Battery Capacity: " + batteryCapacity);
        System.out.println("Weapon: " + weapon);
        System.out.println("Armor: " + armor);
        System.out.println("Speed: " + speed);
    }
    
    public static class Builder {
        private String name;
        private String model;
        private int batteryCapacity;
        private String weapon;
        private String armor;
        private int speed;
        
        public Builder(String name) {
            this.name = name;
        }
        
        public Builder setModel(String model) {
            this.model = model;
            return this;
        }
        
        public Builder setBatteryCapacity(int batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
            return this;
        }
        
        public Builder setWeapon(String weapon) {
            this.weapon = weapon;
            return this;
        }
        
        public Builder setArmor(String armor) {
            this.armor = armor;
            return this;
        }
        
        public Builder setSpeed(int speed) {
            this.speed = speed;
            return this;
        }
        
        public CombatRobot build() {
            return new CombatRobot(this);
        }
    }
}
