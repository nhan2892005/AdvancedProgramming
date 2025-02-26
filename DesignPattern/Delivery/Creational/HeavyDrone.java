package DesignPattern.Delivery.Creational;

// Concrete product: HeavyDrone
public class HeavyDrone extends Drone {
    @Override
    public void deliverPackage(String destination) {
        System.out.println("HeavyDrone: Delivering package with extra security to " + destination);
    }
}
