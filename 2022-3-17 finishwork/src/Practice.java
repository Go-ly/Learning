

public class Practice {

    // 迭代法判断回文
    public static boolean judgePalindrome(String str) {
        char[] array = str.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    // 递归判断回文
    public static boolean recursionJudgePalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        char low = str.charAt(0);
        char high = str.charAt(str.length() - 1);
        if (low == high) {
            return recursionJudgePalindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }

    public static int zeroCount(int n) {    // 1000 < n < 10000
        int count = 0;
        while (n >= 10) {
            if (n % 10 != 0) {
                break;
            } else {
                count++;
                n = n / 10;
            }
        }
        return count;
    }

    public static int recursionZeroCount(int n) {
        if (n % 10 != 0 || n == 0) {
            return 0;
        } else {
            return recursionZeroCount(n / 10) + 1;
        }

    }

    public static void judgeGrade() {
        System.out.println("名次如下：");
        for (int A = 1; A <= 5; A++) {
            for (int B = 1; B <= 5; B++) {
                for (int C = 1; C <= 5; C++) {
                    for (int D = 1; D <= 5; D++) {
                        for (int E = 1; E <= 5; E++) {
                            if (((B == 3 && C != 5) || (B != 3 && C == 5))
                                    && ((D == 2 && E != 4) || (D != 2 && E == 4))
                                    && ((B == 1 && E != 4) || (B != 1 && E == 4))
                                    && ((C == 1 && B != 2) || (C != 1 && B == 2))
                                    && ((D == 2 && A != 3) || (D != 2 && A == 3))
                                    && A + B + C + D + E == 15
                                    && A != B
                                    && A != C
                                    && A != D
                                    && A != E
                            ) {
                                System.out.println("A : " + A + ", B : " + B + ", C : " + C + ", D : " + D + ", E : " + E);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void completeNumber() {
        for (int i = 100; i < 1000; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                int num = i;
                int l1 = num % 10;
                int l2 = (num / 10) % 10;
                if (l1 == l2) {
                    System.out.printf("%d, ", i);
                    continue;
                }
                int l3 = (num / 100) % 10;
                if (l2 == l3 || l1 == l3) {
                    System.out.printf("%d, ", i);
                }
            }
        }
    }

    public static void judgeDiv(int n) {
        int flag = 0;
        if (n % 4 == 0) {
            flag += 1;
        }
        if (n % 7 == 0) {
            flag += 2;
        }
        if (n % 9 == 0) {
            flag += 4;
        }
        switch (flag) {
            case 0:
                System.out.println("不能被4， 7， 9任一个整除");
                break;
            case 1:
                System.out.println("只能被 4 整除");
                break;
            case 2:
                System.out.println("只能被 7 整除");
                break;
            case 3:
                System.out.println("能被 4 和 7 整除");
                break;
            case 4:
                System.out.println("只能被9整除");
                break;
            case 5:
                System.out.println("能被 4 和 9 整除");
                break;
            case 6:
                System.out.println("能被 7 和 9 整除");
                break;
            case 7:
                System.out.println("能同时被 4， 7， 9 整除");
                break;
        }
    }

    public static void printNumber(int num) {
        int count = 0;
        int[] array = new int[1024];
        int i = 0;
        while (num >= 10) {
            array[i] = num % 10;
            num = num / 10;
            i++;
        }
        array[i] = num;
        System.out.printf("共 %d 位数\n", i + 1);
        System.out.printf("正序输出：");
        for (int j = 0; j <= i; j++) {
            System.out.printf("%d ", array[j]);
        }
        System.out.println();
        System.out.printf("逆序输出：");
        for (int j = i; j >= 0; j--) {
            System.out.printf("%d ", array[j]);
        }
    }

    public static void printMatrix(int n) {
        int[][] arr = new int[100][100];
        int k = 1;
        for (int i = 1; i <= n / 2; i++) {
            for (int j = i; j <= n - i; j++) {   // i 行  上侧
                arr[i][j] = k++;
            }
            for (int j = i; j <= n - i; j++) {    // n + 1 - i 列   右侧
                arr[j][n + 1 - i] = k++;
            }
            for (int j = n - i + 1; j >= i + 1; j--) {    // 下侧
                arr[n + 1 - i][j] = k++;
            }
            for (int j = n - i + 1; j >= i + 1; j--) {   // i 列
                arr[j][i] = k++;
            }
        }
        if (n % 2 == 1) {
            int index = (n + 1) / 2;
            arr[index][index] = n * n;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void restoreMul() {
        int[] arr = {2,3,5,7};
        for (int i = 0; i < 4; i++) {
            int A = arr[i];
            for (int j = 0; j < 4; j++) {
                int B = arr[j];
                for (int k = 0; k < 4; k++) {
                    int C = arr[k];
                    for (int l = 0; l < 4; l++) {
                        int D = arr[l];
                        for (int m = 0; m < 4; m++) {
                            int E = arr[m];
                            int muled = A * 100 + B * 10 + C;
                            int low = muled * D;
                            int high = muled * E;
                            int ret = low + high * 10;
                            if (low >= 222 && high >= 222 && isTrue(low) && isTrue(high) && ret >= 22222 && isTrue(ret)) {
                                System.out.println("还原的算式如下：");
                                System.out.printf("%d * %d == %d + %d == %d", muled, E * 10 + D, low, high * 10, ret);
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isTrue(int num) {
        while (num >= 10) {
            int ret = num % 10;
            if (ret != 2 && ret != 3 && ret != 5 && ret != 7) {
                return false;
            }
            num = num / 10;
        }
        if (num != 2 && num != 3 && num != 5 && num != 7) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abccccba";
        System.out.println(zeroCount(0));
        completeNumber();
        judgeDiv(63);
        printNumber(12345);
        System.out.println();
        printMatrix(10);
        restoreMul();
    }
}
