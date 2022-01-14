import java.util.Scanner;
class MyException extends Exception{
    public MyException() {
        super();
    }
    public MyException(String str) {
        super(str);
    }
}
public class ExceptionLearning {
    public static void main(String[] args) throws MyException {
        throw new MyException();
    }
}
