public class Dog extends Animal {
    public int age = 5;
    public Dog(String name) {
        super(name);
    }
    public Dog(int age) {
        super(age);
    }

    public Dog(int x, int y) {

    }

    public Dog() {

    }

    public void method() {
        System.out.println(age);
        System.out.println(super.age);
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.method();
    }
}
