public class Animal {
    public String name;
    public int age;
    public Animal(String name) {
        this.name = name;
        System.out.println(this.name);
    }
    public void eat() {
        System.out.println("Animal->eat");
    }
}
