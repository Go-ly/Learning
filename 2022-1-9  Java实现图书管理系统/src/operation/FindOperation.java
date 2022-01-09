package operation;
import book.Book;
import book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (name.equals(book.getName())) {
                System.out.println(book);
                break;
            }
        }
        if (i == bookList.getSize()) {
            System.out.println("没有此书");
        }
    }
}
