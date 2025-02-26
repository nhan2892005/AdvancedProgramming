package DesignPattern.Creational;
import java.util.ArrayList;
import java.util.List;
import DesignPattern.Behavioral.Observer;
import DesignPattern.Structural.Adapter;

public class Singleton {
    // Instance duy nhất của Mission Control
    private static Singleton instance;
    // Danh sách các observer đăng ký nhận thông báo
    private List<Observer> observers;

    // Constructor private để ngăn tạo instance từ bên ngoài
    private Singleton() {
        observers = new ArrayList<>();
    }

    // Phương thức trả về instance duy nhất (lazy initialization)
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Phương thức đăng ký 1 Observer
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("Mission Control: Observer '" + observer.getClass().getSimpleName() + "' detached");
    }

    // Phương thức thông báo đến tất cả các Observer
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    // Phương thức kinh doanh: phóng nhiệm vụ
    public void launchMission(String missionName) {
        System.out.println("Mission Control: Launching mission '" + missionName + "'");
        notifyObservers("Mission '" + missionName + "' has been launched!");
    }

    // Phương thức nhận thông điệp từ nguồn ngoài thông qua Adapter
    public void receiveAlienMessage(Adapter adapter) {
        System.out.println("Mission Control: Receiving alien message via adapter.");
        adapter.request();
    }
}

