package arraylist;

import java.util.Collection;
import java.util.List;

interface MyList<E extends Comparable<E>> {
    void add(E e);
    E get(int index);
    E remove(int index);
    void addAll(Collection<? extends E> c);
    int size();
}

public class MyArrayList<E extends Comparable<E>> implements MyList<E> {
    private Object[] array;
    private int size;
    private static final int defaultSize = 10;

    public MyArrayList() {
        array = new Object[defaultSize];
        size = 0;
    }

    public MyArrayList(Collection<? extends E> c) {
        this();
        Object[] a = c.toArray();
        if (a.length == 0) return;
        int newCapacity = a.length;
        if (newCapacity > this.array.length) {
            Object[] elements = new Comparable[newCapacity];
            System.arraycopy(this.array, 0, elements, 0, size);
            System.arraycopy(a, 0, elements, 0, a.length);
            this.array = elements;
        } else {
            System.arraycopy(a, 0, this.array, 0, a.length);
        }
        size = newCapacity;
    }

    private int newCapacity(int capacity) {
        return capacity * 3 / 2 + 1;
    }

    @Override
    public void add(E e) {
        if (size == array.length) {
            int newCapacity = newCapacity(array.length);
            Object[] a = new Comparable[newCapacity];
            System.arraycopy(this.array, 0, a, 0, this.array.length);
            array = a;
        }
        array[size++] = e;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= array.length) {
            throw new IndexOutOfBoundsException("MyArrayList index out of bounds");
        }
        return (E)array[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index >= array.length) {
            throw new IndexOutOfBoundsException("MyArrayList index out of bounds");
        }
        Object removed = array[index];
        size--;
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        return (E) removed;
    }

    @Override
    public void addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        if (a.length == 0) {
            return;
        }
        int newCapacity = a.length + size;
        if (newCapacity > this.array.length) {
            Object[] elements = new Comparable[newCapacity];
            System.arraycopy(this.array, 0, elements, 0, size);
            System.arraycopy(a, 0, elements, size, a.length);
            this.array = elements;
        } else {
            System.arraycopy(a, 0, this.array, size, a.length);
        }
        size = newCapacity;
    }

    public int size() {
        return size;
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    isSorted = false;
                    T tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                E el1 = (E) array[j];
                E el2 = (E) array[j + 1];
                if (el1.compareTo(el2) > 0) {
                    isSorted = false;
                    array[j] = el2;
                    array[j + 1] = el1;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
