import java.io.IOException;
import java.util.Comparator;

public class Demo2 implements Comparable, Comparator {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append("world");
        System.out.println(stringBuilder.toString());
        String string = "a";
        for (int i = 0; i < 10; i ++) {
            string += "b";
        }
        System.out.println(string);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");

    }
    public static int add() {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
