package arraylist;

import java.util.Collection;

interface MyList<E extends Comparable<E>> {
    void add(E e);
    E get(int index);
    E remove(int index);
    boolean addAll(Collection<? extends E> c);
    int size();
}

public class MyArrayList<E extends Comparable<E>> implements MyList<E> {
    private E[] array;
    private int size;
    private static final int defaultSize = 10;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (E[]) new Comparable[defaultSize];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(Collection<? extends E> c) {
        super();
        E[] a = (E[]) c.toArray();
        if (a.length == 0) return;
        int newCapacity = a.length;
        assert this.array != null;
        if (newCapacity > this.array.length) {
            E[] elements = (E[])new Comparable[newCapacity];
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

    @SuppressWarnings("unchecked")
    @Override
    public void add(E e) {
        if (size == array.length) {
            int newCapacity = newCapacity(array.length);
            E[] a = (E[])new Comparable[newCapacity];
            System.arraycopy(this.array, 0, a, 0, this.array.length);
            array = a;
        }
        array[size++] = e;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        return (E)array[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        E removed = array[index];
        size--;
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        return removed;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] a = (E[]) c.toArray();
        if (a.length == 0) {
            return false;
        }
        int newCapacity = a.length + size;
        if (newCapacity > this.array.length) {
            E[] elements = (E[])new Comparable[newCapacity];
            System.arraycopy(this.array, 0, elements, 0, size);
            System.arraycopy(a, 0, elements, size, a.length);
            this.array = elements;
        } else {
            System.arraycopy(a, 0, this.array, size, a.length);
        }
        size = newCapacity;
        return true;
    }

    public int size() {
        return size;
    }

    public void bubbleSort(boolean flag) {
        int check = 1;
        if (!flag) check = -1;
        for (int i = size - 1; i > 0; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if (check * array[j].compareTo(array[j + 1]) > 0) {
                    isSorted = false;
                    E tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
