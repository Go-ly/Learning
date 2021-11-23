public class Student {
    public String name;
    public int age;
    public int height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Student() {
        name = "张三";
        age = 60;
        height = 180;
    }
    public Student(int age1) {
        age = age1;
    }
    public Student(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }



}
