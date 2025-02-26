package DesignPattern.Delivery;
import DesignPattern.Delivery.Creational.Drone;
import DesignPattern.Delivery.Creational.DroneFactory;
import DesignPattern.Delivery.Structural.DeliveryHubFacade;
import DesignPattern.Delivery.Behavioral.DeliveryReceiver;
import DesignPattern.Delivery.Behavioral.DeliveryOrderCommandImpl;
import DesignPattern.Delivery.Behavioral.OrderInvoker;

public class MainFactoryFacadeCommand {
    public static void main(String[] args) {
        System.out.println("=== Intergalactic Delivery System ===");
        
        // Creational - Factory Method: Tạo các drone giao hàng
        Drone lightDrone = DroneFactory.createDrone("light");
        Drone heavyDrone = DroneFactory.createDrone("heavy");
        
        if (lightDrone != null) {
            lightDrone.deliverPackage("Mars Colony");
        }
        if (heavyDrone != null) {
            heavyDrone.deliverPackage("Jupiter Outpost");
        }
        
        // Structural - Facade: Sử dụng DeliveryHubFacade để xử lý một đơn hàng
        DeliveryHubFacade hubFacade = new DeliveryHubFacade();
        hubFacade.deliverOrder("Order-001", "light", "Saturn Station");
        
        // Behavioral - Command: Đóng gói và thực thi lệnh giao hàng
        DeliveryReceiver receiver = new DeliveryReceiver();
        DeliveryOrderCommandImpl orderCommand = new DeliveryOrderCommandImpl("Order-002", "heavy", "Neptune Base", receiver);
        OrderInvoker invoker = new OrderInvoker();
        invoker.setCommand(orderCommand);
        invoker.invoke();
    }
}
