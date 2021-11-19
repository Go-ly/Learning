import java.util.Random;
import java.util.Scanner;

public class Method {
    public static void printAge(int age) {
        //        1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        if (age <= 0) {
            throw new RuntimeException("age必须大于0");
        }
        if (age < 18){
            System.out.println("少年");
        } else if (age < 28) {
            System.out.println("青年");
        } else if (age < 55) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }
    }
    public static boolean isPrimeNumber(int n) {
//        判定一个数字是否是素数
        int i = 2;
        for (; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printPrimeNumber() {
        // 打印1 -- 100之间所有的素数
        for (int i = 2; i <= 100; i++) {
            int j = 2;
            for (; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j == i) {
                System.out.printf("%d ", i);
            }
        }
    }

    public static void printLeapYear() {
//        输出 1000 - 2000 之间所有的闰年
        for(int year = 1000; year <= 2000; year++) {
            if (year % 400 == 0) {
                System.out.printf("%d ", year);
            } else if(year % 4 == 0 && year % 100 != 0) {
                System.out.printf("%d ", year);
            }
            else {
                continue;
            }
        }
    }

    public static void printMulTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d == %d  ", j, i, i * j);
            }
            System.out.println();
        }
    }

    public static int maxNumber(int x, int y) {
        return x > y ? x : y;
    }

    public static int greatsetCommonDivisor(int x, int y) {
//        求两个正整数的最大公约数
        int max = maxNumber(x, y);
        for (int i = max; i >= 1; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
        return -1;
    }

    public static float sumNumber() {
//        计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
        float sum = 0;
        int flag = 1;
        for (int i = 1; i <= 100; i++) {
            sum = sum + (1.0f / i) * flag;
            flag = -flag;
        }
        return sum;
    }

    public static int count9() {
//        编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            int num = i;
            while (num >= 9) {
                if (num % 10 == 9) {
                    count++;
                }
                num = num / 10;
            }
        }
        return count;
    }

//    求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
//    身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)

    public static void printNarcissisticNumber() {
        for (int i = 0; i < 1000; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum = (int) (sum + Math.pow(num % 10, 3));
                num = num / 10;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
//    编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
//    入，最多输入三次。三次均错，则提示退出程序
    public static void login() {
        int password = 123;
        Scanner s = new Scanner(System.in);
        int input = 0;
        int count = 0;
        System.out.println("请输入密码");
        while (true) {
            if (!s.hasNextInt()) {
                System.out.println("不玩了");
                break;
            }
            input = s.nextInt();
            count++;
            if (input == password) {
                System.out.println("密码输入正确");
                break;
            } else {
                if (count >= 3) {
                    System.out.println("密码连续3次输入错误");
                    break;
                }
                System.out.println("密码错误，请重新输入");
            }

        }
    }

//    写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
    public static int countBin(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
//    KiKi学习了循环，BoBo老师给他出了一系列打印图案的练习，该任务是打印用“*”组成的X形图案。
//    输入描述：
//    多组输入，一个整数（2~20），表示输出的行数，也表示组成“X”的反斜线和正斜线的长度。
//    输出描述：
//    针对每行输入，输出用“*”组成的X形图案。
//
//    示例1
//    输入：
//            5
//    复制
//    输出：
//            *   *
//            * *
//            *
//            * *
//            *   *
//    复制
//            示例2
//    输入：
//            6
//    复制
//    输出：
//            *    *
//            *  *
//            **
//            **
//            *  *
//            *    *

    public static void printX() {
        Scanner s = new Scanner(System.in);
        int input = 0;

        // 先打印上半部分
        while(true) {
            if (!s.hasNextInt()) {
                break;
            }
            input = s.nextInt();
            for (int j = 0; j < input / 2; j++) {
                for (int i = 0; i < j; i++) {
                    // 这里先打印空格
                    System.out.print(" ");
                }
                // 这里打印*
                System.out.print("*");
                for (int i = 0; i <= input - 3 - 2 * j; i++) {
                    // 这里打印空格
                    System.out.print(" ");
                }
                if (input % 2 != 0 && j == input / 2) {
                    break;
                }
                System.out.println("*");
            }
            // 判断是奇数还是偶数打印中间部分
            if (input % 2 != 0) {
                for (int i = 0; i < input / 2; i++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            } else {
                for (int i = 0; i < input / 2 - 1; i++) {
                    System.out.print(" ");
                }
                System.out.println("**");
            }
            // 打印下半部分3  2
            for (int j = input / 2 + 1; j < input; j++) {
                // 打印空格
                for (int i = 0; i < input - j - 1; i++) {
                    System.out.print(" ");
                }
                //打印*
                System.out.print("*");
                for (int i = 0; i < 2 * j - input; i++) {
                    // 打印中间空格
                    System.out.print(" ");
                }
                System.out.println("*");
            }
        }

    }

//    完成猜数字游戏 ，用户输入数字，判断该数字是大于，小于，还是等于随机生成的数字，等于的时候退出程序
    public static void guessNumber() {
        Random seed = new Random();
        int toGuess = seed.nextInt(100) + 1;
        int input = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (!scan.hasNextInt()) {
                System.out.println("退出游戏");
                break;
            }
            input = scan.nextInt();
            if (input > toGuess) {
                System.out.println("猜大了");
            } else if (input < toGuess) {
                System.out.println("猜小了");
            } else {
                System.out.println("恭喜你，输入正确！");
                break;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(countBin(15));
    }
// 0000 0000 0000 0000 0000 0000 0000 1111
}
