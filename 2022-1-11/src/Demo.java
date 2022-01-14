import java.lang.reflect.Field;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        String str1 = "Hello";
        String str2 = "Welcome";
        System.out.println(str1.compareTo(str2));
        String str = str1.replace('l', 'b');
        System.out.println(str);
        String str3 = "hello";
        boolean flag = str3.contains("el");
        System.out.println(flag);

        String str4 = "aaabcaaaabcdeecd";
        System.out.println(str4.indexOf("abcd"));
        System.out.println(str4.lastIndexOf("aaa", 4));

        String str5 = "aaabcaaaabcdeecd";
        System.out.println(str5.startsWith("aaa"));
        System.out.println(str5.startsWith("aaa", 1));
        System.out.println(str5.startsWith("aab", 1));
        System.out.println(str5.endsWith("cd"));
        System.out.println(str5.endsWith("acd"));
        String str6 = "Welcome to java";
        String[] s = str6.split(" ");
        System.out.println(Arrays.toString(s));
        String strr = "    hel   lo  ";
        System.out.println(strr.trim());
        String strr1 = "Welcome To Java";
        System.out.println(strr1.toLowerCase());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append("world");
        System.out.println(stringBuilder);
        String string = "a";
        for (int i = 0; i < 10; i ++) {
            string += "b";
        }
        System.out.println(string);
    }
    public static void main1(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        String str1 = "Welcome";
//        // 获取String类中的value字段
//        Field field = String.class.getDeclaredField("value");
//        field.setAccessible(true);
//        char[] arr = (char[])field.get(str1);
//        arr[0] = 'b';
//        System.out.println(str1);
//        String str2 = "hello" + "world";
//        char[] arr2 = {'a', 'b', 'c'};
//        String str3 = new String(arr2);
//        System.out.println(str3);
//        char[] arr3 = {'h','e','l','l','o'};
//        String str4 = new String(arr3, 1, 3);
//        System.out.println(str4);
//        String str5 = "hello";
//        char ch = str5.charAt(1);
//        System.out.println(ch);
//        String str6 = "hello";
//        char[] arr5 = str6.toCharArray();
//        System.out.println(Arrays.toString(arr5));
//        String str7 = "abcde";
//        byte[] bytes = str7.getBytes();
//        System.out.println(Arrays.toString(bytes));
//        String str11 = "Hello";
//        String str12 = "hEllo";
//        System.out.println(str11.equalsIgnoreCase(str12));
    }
}
