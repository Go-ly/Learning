import java.util.Arrays;
public class Practice {
    public static void main(String[] args) {
//        int a = 1;
//        int b = 2;
//        int[] arr = {a, b};
//        swap(arr, 0, 1);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(Arrays.toString(arr));
        int[] arr = {1,8,7,6,5,3};
        int[] arr2 = copyOf(arr, 3);
        int[] arr3 = copyOf(arr, 6);
        int[] arr4 = copyOf(arr, 10);
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        int [] arr5 = copyOfRange(arr, 5, 12);
        System.out.println(Arrays.toString(arr5));
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int binarySearch(int[] arr, int key) {
        int fromIndex = 0;
        int toIndex = arr.length - 1;
        while (fromIndex <= toIndex) {
            int mid = (fromIndex + toIndex) / 2;
            if (key < arr[mid]) {
                toIndex = mid - 1;
            } else if (key > arr[mid]) {
                fromIndex = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void sort(int[] arr, int fromIndex, int toIndex) {
        for (int i = 0; i < toIndex - fromIndex - 1; i++) {
            for (int j = fromIndex; j < toIndex - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    public static int[] copyOf(int[] arr, int newLength) {
        int[] newArr = new int[newLength];
        for (int i = 0; i < Math.min(newLength, arr.length); i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static int[] copyOfRange(int[] arr, int fromIndex, int toIndex) {
        // fromIndex >= 0
        // toIndex 可以向后越界
        int[] newArr = new int[toIndex - fromIndex];
        for (int i = fromIndex; i < Math.min(toIndex, arr.length); i++) {
            newArr[i - fromIndex] = arr[i];
        }
        return newArr;
    }
}
