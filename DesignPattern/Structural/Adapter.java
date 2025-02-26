package DesignPattern.Structural;
import DesignPattern.Utils.AlienSystem;

public class Adapter {
    private AlienSystem alienSystem;

    public Adapter(AlienSystem alienSystem) {
        this.alienSystem = alienSystem;
    }

    // Phương thức request() chuyển đổi thông điệp từ AlienSystem
    public void request() {
        System.out.println("Adapter: Converting alien message to internal format.");
        alienSystem.alienRequest();
    }
}

