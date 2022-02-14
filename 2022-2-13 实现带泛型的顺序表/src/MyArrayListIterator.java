import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayListIterator<E> implements Iterator<E> {
    private int currentIndex;
    private  int size;
    private E[] array;
    public MyArrayListIterator(int size, E[] array) {
        currentIndex = 0;
        this.size = size;
        this.array = array;
    }
    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    @Override
    public E next() {
        if (currentIndex >= size) {
            throw new NoSuchElementException();
        }
        E currentElement = array[currentIndex];
        currentIndex++;
        return currentElement;
    }
}
