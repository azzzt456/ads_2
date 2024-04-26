public class MyQueue<T> {
    private final MyArrayList<T> list;

    public MyQueue() {
        list = new MyArrayList<>();
    }

    public void enqueue(T e) {
        list.add(e);
    }

    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(0);
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}