import java.util.Arrays;
import java.util.Scanner;

public class Practice {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static int binarySearch(int[] arr, int k) {
        int fromIndex = 0;
        int toIndex = arr.length - 1;
        while(fromIndex <= toIndex) {
            int mid = (fromIndex + toIndex) / 2;
            if (k < arr[mid]) {
                toIndex = mid - 1;
            } else if (k > arr[mid]) {
                fromIndex = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

//    实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组
    public static int[] copyOf(int[] arr, int newLength) {
        int[] newArr = new int[newLength];
        if (newLength <= arr.length) {
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i];
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
        }
        return newArr;
    }

//    实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素
//    乘以 2 , 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2 * arr[i];
        }
    }

//    实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
    public static int sum(int[] arr) {
        int sum = 0;
        for (int e : arr) {
            sum = sum + e;
        }
        return sum;
    }

//    实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
    public static int avg(int[] arr) {
        int sum = 0;
        for (int e : arr) {
            sum = sum + e;
        }
        return sum / arr.length;
    }

    public static void main(String[] args) {

    }
}
