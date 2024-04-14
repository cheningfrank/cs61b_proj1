package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
        /* initial List must be 0 in size */
        ArrayDeque<String> lld1 = new ArrayDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");


		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
        lld1.addFirst("I");
        lld1.addLast("you");
        lld1.removeFirst();
        String act1 = lld1.removeLast();
        String exp1 = "you";
        assertEquals(exp1,act1);
        assertEquals(3, lld1.size());
		lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> lld1 = new  ArrayDeque<>();
        lld1.addFirst(3);
        int act = lld1.removeFirst();
        int expect = 3;
        lld1.printDeque();
        lld1.removeLast();
        lld1.removeLast();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";
        assertEquals(expect, act);
        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        ArrayDeque<String>  lld1 = new  ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new  ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new  ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
        assertEquals("string", s);
       // assertEquals(3.14159, d);
        assertEquals(true, b);
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 100000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 50000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 99999; i > 50000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }
    @Test
    public void getTest() {
        ArrayDeque<Integer> lld = new ArrayDeque<>();
        lld.addLast(12);
        lld.addLast(1);
        assertEquals(1, (double)lld.get(1), 0.0);
        lld.addFirst(32);
        lld.addLast(323);
        lld.printDeque();
        assertEquals(1, (double)lld.get(2), 0.0);
        assertEquals(null, lld.get(4));
        for (int i = 0; i < 10; i++) {
            lld.addLast(i);
            assertEquals(i, lld.get(3 + i + 1), 0.0);
        }
    }
    @Test
    public void randomizedTest() {
        AList<Integer> L = new AList<>();
        ArrayDeque<Integer> ba = new ArrayDeque<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                ba.addLast(randVal);

            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int s = ba.size();
                assertEquals(size, s);

            } else if(operationNumber == 2) {
                if(L.size() == 0) continue;
                int last = L.getLast();
                int last1 = ba.get(ba.size() - 1);
                assertEquals(last, last1);

            } else {
                continue;

            }
        }
    }
}
