public class Dog extends Animal{
    public int aaa;
    public Dog(String name) {
        super(name);
    }
    public void eat() {
        System.out.println(this.name + "->eat");
    }
    public void run() {
        System.out.println("dog->run");
    }
}
