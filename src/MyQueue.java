import java.util.NoSuchElementException;

public class MyQueue<T> {
    private final MyArrayList<T> list;

    public MyQueue() {
        list = new MyArrayList<>();
    }

    //Adds an element to the end of the queue
    public void enqueue(T e) {
        list.add(e);
    }

    // Removes and returns the element at the front of the queue
    public T dequeue() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.remove(0);
    }

    //Retrieves, but does not remove
    public T peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.get(0);
    }

    //number of elements
    public int size() {
        return list.size();
    }

    //Checks whether the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }
}