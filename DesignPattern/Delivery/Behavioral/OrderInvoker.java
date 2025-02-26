package DesignPattern.Delivery.Behavioral;

// Invoker: Lưu giữ và kích hoạt lệnh giao hàng
public class OrderInvoker {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void invoke() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("OrderInvoker: No command set.");
        }
    }
}
