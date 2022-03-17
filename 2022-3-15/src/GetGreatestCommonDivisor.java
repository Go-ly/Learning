public class GetGreatestCommonDivisor {
    public static int getGreatestCommomDivisor(int x, int y) {
        int max = Integer.max(x, y);
        int min = Integer.min(x, y);
        int ret = max % min;
        while (ret != 0) {
            x = min;
            y = ret;
            ret = x % y;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommomDivisor(12, 4));
    }


}
