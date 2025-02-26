package OOP;

public interface InterfaceC {
    // Phương thức trừu tượng
    void methodC();
    
    // Default method cùng tên với của InterfaceI để tạo ra trường hợp diamond
    default void defaultMethod() {
        System.out.println("Default method from InterfaceC");
    }
}
