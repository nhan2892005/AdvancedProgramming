import OOP.ClassA;
import OOP.ClassB;
import OOP.ClassC;
import OOP.InterfaceC;

public class MainOOP {
    public static void main(String[] args) {
        // Gọi static method (static binding)
        ClassA.staticMethod();
        
        System.out.println("----- Testing ClassB -----");
        // Tạo đối tượng của ClassB và sử dụng các phương thức
        ClassB objB = new ClassB(10);
        objB.display();
        objB.abstractMethod();
        objB.methodB();
        objB.overloadedMethod();
        objB.overloadedMethod(42);
        // Gọi defaultMethod (lấy từ InterfaceB)
        objB.defaultMethod();
        
        System.out.println("----- Testing ClassC -----");
        // Polymorphism: tham chiếu lớp cha trỏ đến đối tượng của ClassC
        ClassA objA = new ClassC(20);
        objA.display();
        objA.abstractMethod(); // Gọi implementation của ClassC
        
        // Sử dụng tham chiếu interface
        InterfaceC objC = (InterfaceC) objA;
        objC.methodC();
        // Gọi phương thức default đã được ghi đè trong ClassC để giải quyết diamond
        ((ClassC) objA).defaultMethod();
    }
}
