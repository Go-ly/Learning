import java.util.Arrays;

public class Practice {
//    给定一个整型数组, 判定数组是否有序（递增）
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean isSort(int[] arr, int[] arr1) {
        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = 0; j < arr1.length - i - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    swap(arr1, j, j + 1);
                }
            }
        }
        if (Arrays.equals(arr, arr1)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int[] arr1 = Arrays.copyOf(arr, arr.length - 1);
        System.out.println(isSort(arr, arr1));
    }
}
