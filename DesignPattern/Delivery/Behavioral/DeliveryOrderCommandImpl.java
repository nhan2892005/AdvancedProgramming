package DesignPattern.Delivery.Behavioral;

// Concrete Command: DeliveryOrderCommand
public class DeliveryOrderCommandImpl implements Command {
    private String orderId;
    private String droneType;
    private String destination;
    private DeliveryReceiver receiver;
    
    public DeliveryOrderCommandImpl(String orderId, String droneType, String destination, DeliveryReceiver receiver) {
        this.orderId = orderId;
        this.droneType = droneType;
        this.destination = destination;
        this.receiver = receiver;
    }
    
    @Override
    public void execute() {
        receiver.processDelivery(orderId, droneType, destination);
    }
}
