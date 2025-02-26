package DesignPattern.Delivery.Behavioral;

// Receiver: Xử lý giao hàng
public class DeliveryReceiver {
    public void processDelivery(String orderId, String droneType, String destination) {
        System.out.println("DeliveryReceiver: Processing delivery for order " + orderId);
        System.out.println("DeliveryReceiver: Drone of type " + droneType + " will deliver to " + destination);
    }
}
