package DesignPattern.Delivery.Structural;



// Facade: DeliveryHubFacade
public class DeliveryHubFacade {
    private OrderProcessing orderProcessing;
    private DroneDispatch droneDispatch;
    private TrackingSystem trackingSystem;
    
    public DeliveryHubFacade() {
        orderProcessing = new OrderProcessing();
        droneDispatch = new DroneDispatch();
        trackingSystem = new TrackingSystem();
    }
    
    public void deliverOrder(String orderId, String droneType, String destination) {
        System.out.println("DeliveryHubFacade: Starting delivery process for order " + orderId);
        orderProcessing.processOrder(orderId);
        droneDispatch.dispatchDrone(droneType, destination);
        trackingSystem.trackOrder(orderId);
        System.out.println("DeliveryHubFacade: Delivery process completed for order " + orderId);
    }
}
