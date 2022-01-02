import java.sql.Time;
import java.util.Scanner;

public class Practice {
//    public static int maxNum(int num1, int num2, int num3) {
//        int max = num1 > num2 ? num1 : num2;
//        max = max > num3 ? max : num3;
//        return max;
//    }
//    public static int max(int x, int y) {
//        return x > y ? x : y;
//    }
//    public static float max(float x, float y) {
//        return x > y ? x : y;
//    }
//    public static void main(String[] args) {
//        int ret = max(1, 2);
//        float ret2 = max(1.5f, 2.3f);
//    }

    // 汉诺塔问题
    public static void hanoi(int num, String src, String help, String dest) {
        if (num == 1) {     // 只有一个盘子的时候直接移动
            System.out.print(src + "->" + dest + "  ");
        } else {
            hanoi(num - 1, src, dest, help);   // 将n - 1个盘子从源柱子借助目标柱子挪到辅助柱子
            System.out.print(src + "->" + dest + "  ");
            hanoi(num - 1, help, src, dest);  // 将辅助柱子上n - 1个盘子借助源柱子挪到目标柱子
        }
    }

    // 求斐波那契数
    public static int fib(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fib(num - 1) + fib(num - 2);
    }

    // 打印一个整数的每一位
    public static void print(int num) {
        if(num > 9) {
            print(num / 10);
        }
        System.out.println(num % 10);
    }

    // 写一个递归方法，输入一个非负整数，返回组成它的数字之和
    public static int addBit(int num) {

        if (num <= 9) {
            return num;
        }
        int sum = 0;
        sum = sum + addBit(num / 10) + num % 10;
        return sum;
    }

    // 递归求1 + 10
    public static int add(int num) {
        if (num == 1) {
            return 1;
        }
        return add(num - 1) + num;
    }

    // 递归求阶乘
    public static int fac(int num) {
        if (num >= 1) {
            return num * fac(num - 1);
        }
        return 1;
    }
    public static void main(String[] args) {
        hanoi(3, "A", "B", "C");
    }
}

