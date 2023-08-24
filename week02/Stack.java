package week02;

import java.util.LinkedList;

public class Stack<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void push(E element) {
        list.addFirst(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println("Is intStack empty? " + intStack.isEmpty());
        System.out.println("intStack size: " + intStack.size());

        while (!intStack.isEmpty()) {
            System.out.println("Popped: " + intStack.pop());
        }

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");

        System.out.println("Is stringStack empty? " + stringStack.isEmpty());
        System.out.println("stringStack size: " + stringStack.size());

        while (!stringStack.isEmpty()) {
            System.out.println("Popped: " + stringStack.pop());
        }
    }
}
