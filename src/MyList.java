public interface MyList<T> extends Iterable<T> {
    void add(T e);
    void add(int index, T e);
    T get(int index);
    T remove(int index);
    boolean remove(T e);
    int size();
    boolean isEmpty();
    boolean contains(T e);
    void clear();
}