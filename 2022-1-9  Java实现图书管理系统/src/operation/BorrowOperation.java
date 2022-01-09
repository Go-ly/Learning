package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名:>");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (name.equals(book.getName())) {
                if (book.isBorrowed()) {
                    System.out.println("该书已借出!!!");
                } else {
                    book.setBorrowed(true);
                    System.out.println("借阅成功!!!");
                }
                return;
            }
        }
        System.out.println("没有此书!!!");
    }
}
