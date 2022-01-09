import java.util.Arrays;
public class CloneableDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] arr2 = arr.clone();
        arr2[0] = 666;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
