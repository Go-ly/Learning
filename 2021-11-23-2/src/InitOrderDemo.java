public class InitOrderDemo {
    public InitOrderDemo() {
        System.out.println("6");
    }

    {
        System.out.println("3");
    }

    public int a = initA();

    {
        System.out.println("4");
    }

    public int b = initB();

    {
        System.out.println("5");
    }

    public int initA() {
        System.out.println("1");
        return 1;
    }

    public int initB() {
        System.out.println("2");
        return 2;
    }

}
