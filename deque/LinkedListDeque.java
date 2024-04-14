package deque;

public class LinkedListDeque<T> {
    /* helper class */
    private class Node {
        Node before;
        Node after;
        T value;
        public Node(T value, Node before, Node after) {
            this.value = value;
            this.before = before;
            this.after = after;
        }
    }


    /* Attributions */
    private Node sentifirst, sentilast;
    private int size;

    /* Constructor of LinkedListDeque */
    public LinkedListDeque() {
        this.size = 0;
        this.sentifirst = new Node(null, null, null);
        this.sentilast = new Node(null, null, null);
        sentifirst.after = sentilast;
        sentilast.before = sentifirst;
    }


    /* Size of the Deque */
    public int size() {
        return this.size;
    }

    /* addFirst to the Deque */
    public void addFirst(T item) {
        Node a = new Node(item, null, null);
        a.after = sentifirst.after;
        sentifirst.after.before = a;
        sentifirst.after = a;
        a.before = sentifirst;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeFirst() {
        if(this.size > 0) {
            Node p = sentifirst.after;
            p.after.before = sentifirst;
            sentifirst.after = p.after;
            size --;
            return p.value;
        }
        return null;
    }

    /* print the items of Deque */
    public void printDeque() {
        Node p = sentifirst.after;
        while(p != sentilast) {
            System.out.print(p.value + " ");
            p = p.after;
        }
        System.out.println();
    }

    public void addLast(T item) {
        Node b = new Node(item, null, null);
        b.before = sentilast.before;
        sentilast.before.after = b;
        b.after = sentilast;
        sentilast.before = b;
        size += 1;
    }

    public T removeLast() {
        if(size > 0) {
            Node p = sentilast.before;
            sentilast.before = p.before;
            p.before.after = sentilast;
            size --;
            return p.value;

        }
        return null;
    }

    public T get(int index) {
        if(index >= size || index < 0) {
            return null;
        }
        Node p = sentifirst.after;
        while(index != 0) {
            p = p.after;
            index --;
        }
        return p.value;
    }

    public T getRecursive(int index) {
        if(index >= size || index < 0) {
            return null;
        }
        return getRecursive(index, sentifirst.after);
    }
    private T getRecursive(int index, Node p){
        if(index == 0) {
            return p.value;
        }
        return getRecursive(index - 1, p.after);
    }
}



