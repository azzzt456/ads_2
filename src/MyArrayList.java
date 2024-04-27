import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private static final int cap = 15;
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.elements = (T[]) new Object[cap];
        this.size = 0;
    }

    // Add an element to the end of the list
    @Override
    public void add(T e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    // Add an element at a specific index
    @Override
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (size == elements.length) {
            ensureCapacity();
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = e;
        size++;
    }

    // Get the element at a specific index
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    // Remove the element at a specific index and return it
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removed = elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removed;
    }

    // Remove the first occurrence of a specified element
    @Override
    public boolean remove(T e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = e;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int curIndex = 0;

            @Override
            public boolean hasNext() {
                return curIndex < size && elements[curIndex] != null;
            }

            @Override
            public T next() {
                return elements[curIndex++];
            }
        };
    }
}
