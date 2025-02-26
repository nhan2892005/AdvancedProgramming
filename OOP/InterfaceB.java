package OOP;

public interface InterfaceB {
    // Phương thức trừu tượng
    void methodB();
    
    // Default method (có thể được kế thừa hoặc ghi đè)
    default void defaultMethod() {
        System.out.println("Default method from InterfaceB");
    }
}
