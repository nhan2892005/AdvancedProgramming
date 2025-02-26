package OOP;

public class ClassB extends ClassA implements InterfaceB {

    // Sử dụng constructor của lớp cha
    public ClassB() {
        super();
    }
    
    public ClassB(int value) {
        super(value);
    }
    
    // Ghi đè (override) phương thức abstract của ClassA
    @Override
    public void abstractMethod() {
        System.out.println("ClassB implementation of abstractMethod, value: " + getValue());
    }
    
    // Triển khai phương thức của InterfaceI
    @Override
    public void methodB() {
        System.out.println("Implementation of methodI in ClassB");
    }
    
    // Phương thức overloading: cùng tên nhưng khác tham số
    public void overloadedMethod() {
        System.out.println("Overloaded method with no parameters in ClassB");
    }
    
    public void overloadedMethod(int x) {
        System.out.println("Overloaded method with int parameter in ClassB: x = " + x);
    }
}
