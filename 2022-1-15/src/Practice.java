import java.util.Scanner;

public class Practice {
//    实现一个简单的控制台版用户登陆程序, 程序启动提示用户输入用户名密码. 如果用户名密码出错, 使用自定义异常的方式来处理
    public static void main(String[] args) throws passWordException {
        Scanner scanner = new Scanner(System.in);
        int passWord = 666;
        int input = scanner.nextInt();
        if (input != passWord) {
            throw new passWordException("passWord : " + input);
        }
        System.out.println("密码输入正确");
    }
}

class passWordException extends Exception {
    public passWordException(String message) {
        super(message);
    }

    public passWordException() {
        super();
    }

}