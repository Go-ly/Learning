
import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E[] array;
    private int size;
    public MyArrayList() {
        this.array = (E[])new Object[16];
        this.size = 0;
    }
    public MyArrayList(int initinalCapacity) {
        this.array = (E[])new Object[initinalCapacity];
        this.size = 0;
    }
    public MyArrayList(Collection<E> c) {
        this(c.size() * 2);
        addAll(c);
    }
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }



    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.array[i] == o) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (o.equals(this.array[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>(size, array);
    }

    @Override
    public Object[] toArray() {
        return (Object[]) Arrays.copyOf(this.array, this.size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length >= this.size) {
            // a里面能放得下array
            System.arraycopy(this.array, 0, a, 0, this.size);
            return a;
        } else {
            T[] newArray = (T[])new Object[this.size];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            return newArray;
        }
    }

    // 最坏：O(n)
    // 平均：O(1)
    @Override
    public boolean add(E e) {
        ensureCapacity();
        this.array[size++] = e;
        return true;
    }


    // 时间复杂度：O(N)
    private void ensureCapacity() {
        if (this.size < this.array.length) {
            return;
        }
        array = Arrays.copyOf(this.array, this.array.length * 2);
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.array[i] == o) {
                    System.arraycopy(this.array, i + 1, this.array, i, this.size - i - 1);
                    this.array[--size] = null;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (o.equals(this.array[i])) {
                    System.arraycopy(this.array, i + 1, this.array, i, this.size - i - 1);
                    this.array[--size] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            this.add(e);
        };
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E e : c) {
            add(index, e);
        }
        return true;
    }

    // 删除list和c中有交集的部分
    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    // 只保留list和c的交集
    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        // 确保把array中的所有引用都置为null
        // 目的：引用变为null之后，对象才可能被GC回收
        // 对象在应用中已经没用了，但无法被回收，就会发生对象泄露（内存泄露）
        Arrays.fill(array, null);
        this.size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.array[index];
    }

    // O(1)
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldValue = this.array[index];
        this.array[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ensureCapacity();
        System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
        this.array[index] = element;
        this.size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldValue = this.array[index];
        System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
        this.array[--size] = null;
        return oldValue;
    }



    // O(n)
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.array[i] == o) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (o.equals(this.array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = this.size - 1; i >= 0; i--) {
                if (this.array[i] == o) {
                    return i;
                }
            }
        } else {
            for (int i = this.size - 1; i >= 0; i--) {
                if (o.equals(this.array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    // O(n)
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // 标准要求修改了返回的list之后，修改是可以反映到this list
        // 在这里只是返回一个新的list
        if (fromIndex < 0 || toIndex > this.size || fromIndex > toIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        List<E> subList = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(this.get(i));
        }
        return subList;
    }
}
