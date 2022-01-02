class Dog {
    public String name;
    public int age;
    public boolean are;
    public static int a;
    public void bark() {
        System.out.println("汪汪");
    }
}

public class Practice {
    public static void main(String[] args) {
        Dog dog = new Dog();   // 实例化一个对象
        System.out.println(dog.a);
    }
}