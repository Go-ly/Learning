class Dog {
    public String name;
    public int age;
    public boolean are;
    public static int a;
//    public Dog() {
//
//    }
    public Dog(String name) {
        this.name = name;
    }
    public void bark() {
        System.out.println("汪汪");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", are=" + are +
                '}';
    }
}

public class Practice {
    public static void main(String[] args) {
        Dog dog = new Dog("旺财");
        System.out.println(dog.name);
        System.out.println(dog);
    }
}