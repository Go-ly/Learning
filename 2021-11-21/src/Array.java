public class Array {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3};
        for (int e : arr) {
            System.out.println(e);
        }
        int[] b = { 2, 4, 6, 7};
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
        int[] arr2 = new int[5];
        for (int e : arr2) {
            System.out.println(e);
        }
        int[] arr5 = new int[] {8, 9, 10, 11};
        for (int e : arr5) {
            System.out.println(e);
        }
        int[] arr6;
        arr6 = new int[] {2,3,4};
        for (int e : arr6) {
            System.out.println(e);
        }
        System.out.println("length = " + arr6.length);
        arr6 = new int[] { 4, 5, 6, 7, 8, 9};
        for (int e : arr6) {
            System.out.println(e);
        }

    }
}
