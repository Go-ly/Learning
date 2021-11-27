public class UseStudent {
    public static void main(String[] args) {
//        Student s = new Student();
//        System.out.println(s.name);
//        System.out.println(s.age);
//        System.out.println(s.height);
//        s.name = "张三";
//        s.age = 66;
//        s.height = 120;
//        System.out.println(s.age);
//        System.out.println(s.name);
//        System.out.println(s.height);
        Student s = new Student("lll", 12, 5);
        System.out.println(s.name);
        System.out.println(s.age);
        System.out.println(s.height);
        Student t = new Student();
        System.out.println(t.height);
    }
}
