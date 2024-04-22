import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
        testMyStack();
        testMyQueue();
        testMyMinHeap();
    }

    private static void testMyArrayList() {
        System.out.println("Testing MyArrayList:");
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(9);
        list.add(1);
        System.out.println("Size: " + list.size());
        System.out.println("Contains 7: " + list.contains(7));
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Removing element at index 1: " + list.remove(1));
        System.out.println("Size: " + list.size());
        System.out.println("Contains 3: " + list.contains(3));
        list.clear();
        System.out.println("Size after clear: " + list.size());
        System.out.println();
    }

    private static void testMyLinkedList() {
        System.out.println("Testing MyLinkedList:");
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(9);
        System.out.println("Size: " + list.size());
        System.out.println("Contains 7: " + list.contains(7));
        System.out.println("Element at index 2: " + list.get(2));
        System.out.println("Removing element at index 1: " + list.remove(1));
        System.out.println("Size: " + list.size());
        System.out.println("Contains 3: " + list.contains(3));
        list.clear();
        System.out.println("Size after clear: " + list.size());
        System.out.println();
    }

    private static void testMyStack() {
        System.out.println("Testing MyStack:");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(4);
        stack.push(3);
        stack.push(9);
        System.out.println("Size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println();
    }

    private static void testMyQueue() {
        System.out.println("Testing MyQueue:");
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(2);
        System.out.println("Size: " + queue.size());
        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Size: " + queue.size());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Size: " + queue.size());
        System.out.println("Is empty? " + queue.isEmpty());
        System.out.println();
    }

    private static void testMyMinHeap() {
        System.out.println("Testing MyMinHeap:");
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(7);
        minHeap.insert(1);
        minHeap.insert(9);
        System.out.println("Size: " + minHeap.size());
        System.out.println("Contains 7: " + minHeap.contains(7));
        System.out.println("Min element: " + minHeap.findMin());
        System.out.println("Removing min element: " + minHeap.deleteMin());
        System.out.println("Size: " + minHeap.size());
        System.out.println("Contains 1: " + minHeap.contains(1));
        System.out.println();
    }
}