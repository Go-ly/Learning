public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void myIntroduce() {
        System.out.printf("我的名字叫 %s,今年 %d 岁", this.name, this.age);
    }
}
