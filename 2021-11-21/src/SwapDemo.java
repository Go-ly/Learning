
public class SwapDemo {
    public static void main2(String[] args) {
        double[] arr = {1.0, 2.0, 3.0};
        swap(arr, 0, 2);
        System.out.println("Hello");
    }

    private static void swap(double[] array, int i, int j) {
        double t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };
        int[] b = {100, 200, 300 };
        swap(a, b);
        System.out.println("Hello");
    }

    private static void swap(int[] a, int[] b) {
        int[] tmp = a;
        a = b;
        b = tmp;
    }
}
