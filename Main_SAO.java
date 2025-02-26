import DesignPattern.Structural.Adapter;
import DesignPattern.Creational.Singleton;
import DesignPattern.Behavioral.Observer;
import DesignPattern.Utils.AlienSystem;
import java.util.Scanner;

/**
 * Space Agency Operations (SAO) Main Control System
 * Demonstrates 3 key design patterns:
 * - Singleton: Mission Control (single point of command)
 * - Observer: Real-time mission status updates to multiple displays
 * - Adapter: Communication with alien technology systems
 */
public class Main_SAO {
    public static void main(String[] args) {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│   SPACE AGENCY OPERATIONS (SAO) 2025    │");
        System.out.println("└─────────────────────────────────────────┘");
        
        // SINGLETON PATTERN: Get the only mission control instance
        Singleton missionControl = Singleton.getInstance();
        System.out.println("\n[SYSTEM] Mission Control initialized. Unique instance ID: " + missionControl.hashCode());
        
        // Verify singleton behavior - try to create second instance (should be same)
        Singleton secondReference = Singleton.getInstance();
        System.out.println("[SYSTEM] Second reference ID: " + secondReference.hashCode());
        System.out.println("[SYSTEM] Same instance? " + (missionControl == secondReference));
        
        // OBSERVER PATTERN: Multiple displays monitoring missions
        System.out.println("\n┌─ DISPLAY SYSTEM INITIALIZATION ─┐");
        Observer mainDisplay = new Observer("Main Command Center");
        Observer engineeringDisplay = new Observer("Engineering Bay");
        Observer remoteDisplay = new Observer("Remote Station Alpha");
        
        // Register observers with varying importance levels
        missionControl.attach(mainDisplay);
        missionControl.attach(engineeringDisplay);
        missionControl.attach(remoteDisplay);
        System.out.println("└───────────────────────────────────┘");
        
        // MISSION SEQUENCE DEMONSTRATION
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n┌─ MISSION SEQUENCE STARTED ─┐");
        
        // Launch primary mission with observer notifications
        missionControl.launchMission("Artemis Alpha");
        pause(scanner, "Press ENTER to continue to next phase...");
        
        // Demonstrate observer detachment (one display goes offline)
        System.out.println("\n[SYSTEM] Engineering display going offline for maintenance...");
        missionControl.detach(engineeringDisplay);
        missionControl.launchMission("Artemis Beta");
        
        // ADAPTER PATTERN: Alien communication system
        pause(scanner, "Press ENTER to initiate alien communication sequence...");
        System.out.println("\n┌─ ALIEN COMMUNICATION SEQUENCE ─┐");
        
        // First alien system with adapter
        AlienSystem centauriSystem = new AlienSystem();
        Adapter centauriAdapter = new Adapter(centauriSystem);
        System.out.println("\n[ALERT] Receiving transmission from Alpha Centauri!");
        missionControl.receiveAlienMessage(centauriAdapter);
        
        // Second alien system - demonstrates adapter reusability
        AlienSystem proximaSystem = new AlienSystem();
        Adapter proximaAdapter = new Adapter(proximaSystem);
        System.out.println("\n[ALERT] Receiving transmission from Proxima b!");
        missionControl.receiveAlienMessage(proximaAdapter);
        
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│     MISSION OPERATIONS COMPLETE     │");
        System.out.println("└─────────────────────────────────────┘");
        scanner.close();
    }
    
    // Helper method for interactive pauses
    private static void pause(Scanner scanner, String message) {
        System.out.println("\n" + message);
        scanner.nextLine();
    }
}