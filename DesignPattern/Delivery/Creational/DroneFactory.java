package DesignPattern.Delivery.Creational;

// Factory Method: DroneFactory
public class DroneFactory {
    public static Drone createDrone(String type) {
        if ("light".equalsIgnoreCase(type)) {
            return new LightDrone();
        } else if ("heavy".equalsIgnoreCase(type)) {
            return new HeavyDrone();
        }
        return null;
    }
}
