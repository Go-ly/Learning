public class UsePerson {
    public static void main(String[] args) {
        Person p = new Person("张三", 66);
        p.myIntroduce();
        System.out.printf("--------\n");
        Person p2 = new Person("李四", 67);
        p2.myIntroduce();
    }
}
