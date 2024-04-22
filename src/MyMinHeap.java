public class MyMinHeap<T extends Comparable<T>> {
    private final MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public void insert(T element) {
        list.add(element);
        upHeap();
    }

    public T findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return list.get(0);
    }

    public T deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = findMin();
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downHeap();
        }
        return min;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    private void upHeap() {
        int k = size() - 1;
        while (k > 0) {
            int p = (k - 1) / 2;
            T item = list.get(k);
            T parent = list.get(p);
            if (item.compareTo(parent) < 0) {
                // Swap
                list.set(k, parent);
                list.set(p, item);

                // Move up one level
                k = p;
            } else {
                break;
            }
        }
    }

    private void downHeap() {
        int k = 0;
        int l = 2 * k + 1;
        while (l < size()) {
            int min = l;
            int r = l + 1;
            if (r < size()) {
                if (list.get(r).compareTo(list.get(l)) < 0) {
                    min++;
                }
            }
            if (list.get(k).compareTo(list.get(min)) > 0) {
                // Swap
                T temp = list.get(k);
                list.set(k, list.get(min));
                list.set(min, temp);

                // Move down one level
                k = min;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }
}
