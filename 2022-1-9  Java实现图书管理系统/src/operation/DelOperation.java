package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名:>");
        String name = scanner.nextLine();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (name.equals(book.getName())) {
                // 找到了
                break;
            }
        }
        if (i == bookList.getSize()) {
            System.out.println("没有此书");
            return;
        }
        for (int j = i; j < bookList.getSize() - 1; j++) {
            bookList.setBookList(j, bookList.getBook(j + 1));
        }
        bookList.setBookList(bookList.getSize() - 1, null);
        bookList.setSize(bookList.getSize() - 1);
        System.out.println("删除成功!!!");
    }
}
