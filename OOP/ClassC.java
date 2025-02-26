package OOP;

public class ClassC extends ClassB implements InterfaceC {

    public ClassC() {
        super();
    }
    
    public ClassC(int value) {
        super(value);
    }
    
    // Ghi đè lại phương thức abstractMethod (dynamic binding)
    @Override
    public void abstractMethod() {
        System.out.println("ClassC implementation of abstractMethod, value: " + getValue());
    }
    
    // Triển khai phương thức của InterfaceJ
    @Override
    public void methodC() {
        System.out.println("Implementation of methodJ in ClassC");
    }
    
    // Giải quyết diamond inheritance: ghi đè defaultMethod
    @Override
    public void defaultMethod() {
        System.out.println("Overridden defaultMethod in ClassC resolving diamond conflict");
        // Tùy chọn: gọi default methods của từng interface nếu cần
        InterfaceC.super.defaultMethod();
    }
}
