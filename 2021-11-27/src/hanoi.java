public class hanoi {
    public static int calledCount;
    public static void hanoi(int num, String src, String help, String dest) {
        calledCount++;
        if (num < 1) {
            throw new RuntimeException("盘子数量必须大于1\n");
        }
        if (num == 1) {
            System.out.printf("将1个盘子从 %s 柱子上移动到 %s 柱子上\n", src, dest);
        } else {
            hanoi(num - 1, src, dest, help);
            System.out.printf("将1个盘子从 %s 柱子上移动到 %s 柱子上\n", src, dest);
            hanoi(num - 1, help, src, dest);
        }
    }

    public static void main(String[] args) {
        calledCount = 0;
        hanoi(30, "A", "B", "C");
        System.out.println(calledCount);
    }
}
