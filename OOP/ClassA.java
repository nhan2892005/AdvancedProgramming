package OOP;

public abstract class ClassA {
    // Encapsulation: trường private
    private int value;

    // Constructor mặc định và có tham số (Constructor overloading)
    public ClassA() {
        this.value = 0;
    }
    
    public ClassA(int value) {
        this.value = value;
    }

    // Getter và Setter
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }

    // Abstract method: ép buộc các lớp con phải cài đặt
    public abstract void abstractMethod();

    // Phương thức không trừu tượng
    public void display() {
        System.out.println("ClassA display: value = " + value);
    }
    
    // Static method: ví dụ về static binding
    public static void staticMethod() {
        System.out.println("Static method in ClassA");
    }
}
