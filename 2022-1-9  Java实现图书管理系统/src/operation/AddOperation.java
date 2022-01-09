package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名:>");
        String name = scanner.nextLine();
        System.out.println("请输入作者");
        String author = scanner.nextLine();
        System.out.println("请输入价格");
        int price = scanner.nextInt();
        System.out.println("请输入书类型");
        String type = scanner.next();
        for (int pos = 0; pos < bookList.getSize(); pos++) {
            if (name.equals(bookList.getBook(pos).getName())) {
                System.out.println("此书已存在，不能重复添加");
                return;
            }
        }
        Book book = new Book(name, author, price, type);
        bookList.setBookList(bookList.getSize(), book);
        bookList.setSize(bookList.getSize() + 1);
        System.out.println("新增成功!!!");
    }
}
