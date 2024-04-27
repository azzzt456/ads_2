import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private int size;
    private MyNode<T> head;
    private MyNode<T> tail;

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    private static class MyNode<T> {
        T element;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(T element, MyNode<T> prev, MyNode<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    //Adds the element e to the end of the list
    @Override
    public void add(T e) {
        add(size, e);
    }

    //Adds the element e at the specified index in the list
    @Override
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == size) {
            linkLast(e);
        } else {
            linkBefore(e, getNode(index));
        }
        size++;
    }

    //Creates a new node and appends it to the end of the list.
    private void linkLast(T e) {
        final MyNode<T> l = tail;
        final MyNode<T> newNode = new MyNode<>(e, l, null);
        tail = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }
    }

    //Creates a new node and inserts it before the specified succ node.
    private void linkBefore(T e, MyNode<T> succ) {
        final MyNode<T> pred = succ.prev;
        final MyNode<T> newNode = new MyNode<>(e, pred, succ);
        succ.prev = newNode;
        if (pred == null) {
            head = newNode;
        } else {
            pred.next = newNode;
        }
    }

    //Returns the node at the specified index
    private MyNode<T> getNode(int index) {
        if (index < (size >> 1)) {
            MyNode<T> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            MyNode<T> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }


    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNode(index).element;
    }

    //Removes the node at the specified index
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        MyNode<T> nodeToRemove = getNode(index);
        T element = nodeToRemove.element;
        unlink(nodeToRemove);
        return element;
    }

    //Removes the specified x node from the list
    private void unlink(MyNode<T> x) {
        final MyNode<T> next = x.next;
        final MyNode<T> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;
    }

    //Removes the first occurrence of the element e
    @Override
    public boolean remove(T e) {
        for (MyNode<T> x = head; x != null; x = x.next) {
            if (e.equals(x.element)) {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    //Returns size of the list
    @Override
    public int size() {
        return size;
    }

    //Checks if the list is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //Checks if the list contains the element e
    @Override
    public boolean contains(T e) {
        for (MyNode<T> x = head; x != null; x = x.next) {
            if (e.equals(x.element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        MyNode<T> x = head;
        while (x != null) {
            MyNode<T> next = x.next;
            x.element = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.element;
                current = current.next;
                return data;
            }
        };
    }
}
