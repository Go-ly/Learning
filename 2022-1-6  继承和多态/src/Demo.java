public class Demo {
    public static void main(String[] args) {
        Animal dd = new Dog("小小");
        dd.eat();
        Dog dog = (Dog)dd;
        dog.run();
    }
}
