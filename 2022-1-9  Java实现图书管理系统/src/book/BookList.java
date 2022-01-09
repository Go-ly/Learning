package book;

public class BookList {
    private Book[] bookList = new Book[100];
    private int size;
    public BookList() {
        this.bookList[0] = new Book("Java 核心技术卷", "Cay S. Horstmann", 100, "技术");
        this.bookList[1] = new Book("Java 编程思想", "Bruce Eckel", 100, "技术");
        this.bookList[2] = new Book("C和指针", "KennethA．Reek", 100, "技术");
        this.size = 3;
    }

    public Book getBook(int pos) {
        return bookList[pos];
    }

    public void setBookList(int pos, Book book) {
        this.bookList[pos] = book;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
