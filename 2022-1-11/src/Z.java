public class Z {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "ll";
        System.out.println(strStr(str1, str2));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] arr = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        // BF 算法
        int i = 0;
        int j = 0;

        while (j < needle.length() && i < haystack.length()) {
            if (arr[i] == arr2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= needle.length()) {
            return i - j;
        }
        return -1;
    }
}