import java.util.Arrays;
public class Array {
    public static void main(String[] args) {
//        int[] arr = { 1,2,3,4,5,6 };
//        for (int e : arr) {
//            System.out.println(e);
//        }
//        arr = new int[]{10, 5, 4, 6, 7, 9, 3};
//        for (int e : arr
//             ) {
//            System.out.println(e);
//        }
//        Arrays.sort(arr, 1, 5);
//        for (int e : arr) {
//            System.out.println(e);
//        }
////        Arrays.fill(arr, 5);
//        for (int e : arr) {
//            System.out.println(e);
//        }
//        int[] arr2 = Arrays.copyOf(arr, 10);
//        for(int e : arr2) {
//            System.out.println(e);
//        }
//        System.out.println(Arrays.toString(arr));
        int[] arr3 = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < arr3.length - 1; i++) {
            int flag = 1;
            for (int j = 0; j < arr3.length - i - 1; j++) {
                if (arr3[j] < arr3[j + 1]) {
                    int temp = arr3[j];
                    arr3[j] = arr3[j + 1];
                    arr3[j + 1] = temp;
                    flag = 0;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        for (int e : arr3) {
            System.out.println(e);
        }
    }
}
