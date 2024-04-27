public class MyStack<T> {
    private final MyArrayList<T> list;

    public MyStack() {

        list = new MyArrayList<>();
    }

    public void push(T e) { // Push an element onto the top of the stack
        list.add(e);
    }

    public T pop() { // Remove and return the element at the top of the stack
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    public T peek() { // Return the element at the top of the stack without removing it
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public int size() { //number of elements in the stack

        return list.size();
    }

    public boolean isEmpty() { // Check if the stack is empty

        return list.isEmpty();
    }
}

