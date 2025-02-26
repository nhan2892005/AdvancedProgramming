package DesignPattern.Delivery.Creational;

// Concrete product: LightDrone
public class LightDrone extends Drone {
    @Override
    public void deliverPackage(String destination) {
        System.out.println("LightDrone: Delivering package swiftly to " + destination);
    }
}
