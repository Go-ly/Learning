package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名:>");
        String name = scanner.nextLine();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (name.equals(book.getName())) {
                book.setBorrowed(false);
                System.out.println("归还成功!!!");
                return;
            }
        }
        if (i == bookList.getSize()) {
            System.out.println("没有此书!!!");
        }
    }
}
