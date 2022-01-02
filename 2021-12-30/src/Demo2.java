import java.util.Arrays;
public class Demo2 {
    public static void main(String[] args) {
        int[][] arr = new int[2][3];
        arr[0] = new int[2];
        arr[0] = new int[3];
        int[][] array = new int[][]{{1,2,3},{4,5,6}};
        for (int[] cur : array) {
            for (int val : cur) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // 调整数组，将偶数放到最前面
    public static void change(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] % 2 != 0) {
                if (arr[right] % 2 == 0) {
                    int tmp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = tmp;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
    }

    // 数组逆置
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }

    // 判断数组是否是升序的
    public static boolean isUp(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public static int[] copyOfRange(int[] arr, int fromIndex, int toIndex) {
        int[] newArray = new int[toIndex - fromIndex];
        int toIndexMin = arr.length < toIndex ? arr.length : toIndex;
        for (int i = fromIndex; i < toIndexMin; i++) {
            newArray[i - fromIndex] = arr[i];
        }
        return newArray;
    }

    public static int[] copyOf(int[] arr, int newLength) {
        int[] array = new int[newLength];
        int minLength = arr.length < newLength ? arr.length : newLength;
        for (int i = 0; i < minLength; i++) {
            array[i] = arr[i];
        }
        return array;
    }

    public static String toString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            str = str + arr[i] + ",";
        }
        if (arr.length != 0) {
            str = str + arr[arr.length - 1];
        }
        str = str + "]";
        return str;
    }
}
