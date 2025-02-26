package DesignPattern.Behavioral;

public class Observer {
    private String observerName;

    public Observer(String name) {
        this.observerName = name;
    }

    // Phương thức được gọi khi có sự kiện cập nhật từ Mission Control
    public void update(String message) {
        System.out.println(observerName + " received update: " + message);
    }
}

