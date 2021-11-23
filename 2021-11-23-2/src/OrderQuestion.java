import java.io.OutputStreamWriter;

public class OrderQuestion {
    OrderQuestion() {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    int b = initB();

    int initB() {
        System.out.println("3");
        return 1;
    }

    static {
        System.out.println("4");
    }

    static int a = initA();

    static int initA() {
        System.out.println("5");
        return 2;
    }

    public static void main(String[] args) {
        System.out.println("6");
        new OrderQuestion();
        System.out.println("7");
        new OrderQuestion();
        System.out.println("8");
    }
}
