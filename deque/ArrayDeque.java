package deque;

/* Implement of Deque using Array */

public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst, nextLast;
    /* Constructor of LinkedListDeque */
    public ArrayDeque() {
        this.size = 0;
        items = (T[])new Object[8];
        this.nextFirst = 0;
        this.nextLast = 1;
    }


    /* Size of the Deque */
    public int size() {
        return this.size;
    }

    /* addFirst to the Deque */
    public void addFirst(T item) {
        size ++;
        if(size > items.length) {
            resize(size + size / 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    /* remove the first of the Deque */
    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        size --;
        if(size < items.length / 3 - 1) {
            resize(items.length / 3);
        }

        nextFirst = (nextFirst + 1 + items.length) % items.length;
        return items[nextFirst];
    }

    /* print the items of Deque */
    public void printDeque() {
        int f = (nextFirst + 1 + items.length) % items.length;
        while(f != nextLast) {
            System.out.print(items[f] + " ");
            f = (f + 1 + items.length) % items.length;
        }
        System.out.println();
    }

    public void addLast(T item) {
        size ++;
        if(size > items.length) {
            resize(size + size / 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1 + items.length) % items.length;

    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        size --;
        if(size < items.length / 3 - 1) {
            resize(items.length / 3);
        }

        nextLast = (nextLast - 1 + items.length) % items.length;
        return items[nextLast];
    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            return null;
        } else {
            int f = (nextFirst + 1 + items.length) % items.length;
            while(index != 0) {
                f = (f + 1 + items.length) % items.length;
                index --;
            }
            return items[f];
        }
    }
    private void resize(int size) {
        T[] a = (T[])new Object[size];
        int cnt = 0;
        int f = (nextFirst + 1 + items.length) % items.length;
        int l = (nextLast - 1 + items.length) % items.length;

        while(f != l) {
            a[cnt] = items[f];
            f = (f + 1 + items.length) % items.length;
            cnt += 1;
        }
        a[cnt] = items[l];
        cnt ++;
        this.items = a;
        this.nextFirst = items.length - 1;
        this.nextLast = cnt;
    }
}
