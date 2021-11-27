// 构造对象的类
public class Student {
    //   在类里，方法外且不加static就是属性，属性符合默认值语法
    public String name = "默认值";
    public int age = 66;
    public int height = 99;

    // 构造方法 / 构造器
    public Student() {

    }
    public Student(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
