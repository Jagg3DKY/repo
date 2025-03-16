import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedListStudentTest {
    BasicDoubleLinkedList<String> linkedString;
    StringComparator comparator;

    String a = "Jacob";
    String b = "David";
    String c = "Sarah";
    String d = "Cooper";
    String e = "Franklin";
    String f = "Zeke";

    @BeforeEach
    public void setUp() throws Exception {
        linkedString = new BasicDoubleLinkedList<String>();
        linkedString.addToEnd(c);
        linkedString.addToEnd(f);
        comparator = new StringComparator();
    }

    @AfterEach
    public void tearDown() throws Exception {
        linkedString = null;
        comparator = null;
    }

    @Test
    public void testGetSize() {
        assertEquals(2, linkedString.getSize());
    }

    @Test
    public void testAddToEnd() {
        assertEquals(f, linkedString.getLast());
        linkedString.addToEnd(d);
        assertEquals(d, linkedString.getLast());
    }

    @Test
    public void testAddToFront() {
        assertEquals(c, linkedString.getFirst());
        linkedString.addToFront(b);
        assertEquals(b, linkedString.getFirst());
    }

    @Test
    public void testGetFirst() {
        assertEquals(c, linkedString.getFirst());
        linkedString.addToFront(b);
        assertEquals(b, linkedString.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(f, linkedString.getLast());
        linkedString.addToEnd(d);
        assertEquals(d, linkedString.getLast());
    }

    @Test
    public void testToArrayList() {
        ArrayList<String> list;
        linkedString.addToFront(a);
        linkedString.addToEnd(e);
        list = linkedString.toArrayList();
        assertEquals(a, list.get(0));
        assertEquals(c, list.get(1));
        assertEquals(f, list.get(2));
        assertEquals(e, list.get(3));
    }

    @Test
    public void testIteratorSuccessfulNext() {
        linkedString.addToFront(b);
        linkedString.addToEnd(d);
        ListIterator<String> iterator = linkedString.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(f, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(d, iterator.next());
    }

    @Test
    public void testIteratorSuccessfulPrevious() {
        linkedString.addToFront(b);
        linkedString.addToEnd(d);
        ListIterator<String> iterator = linkedString.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(f, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(d, iterator.next());
        
        assertTrue(iterator.hasPrevious());
        assertEquals(d, iterator.previous());
        assertEquals(f, iterator.previous());
        assertEquals(c, iterator.previous());
        assertEquals(b, iterator.previous());
    }

    @Test
    public void testIteratorNoSuchElementExceptionNext() {
        linkedString.addToFront(a);
        linkedString.addToEnd(b);
        ListIterator<String> iterator = linkedString.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(a, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(f, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(b, iterator.next());

        try {
            iterator.next();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException e) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }
    }

    @Test
    public void testIteratorNoSuchElementExceptionPrevious() {
        linkedString.addToFront(a);
        linkedString.addToEnd(b);
        ListIterator<String> iterator = linkedString.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(a, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(f, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(b, iterator.next());

        assertTrue(iterator.hasPrevious());
        assertEquals(b, iterator.previous());
        assertEquals(f, iterator.previous());
        assertEquals(c, iterator.previous());
        assertEquals(a, iterator.previous());

        try {
            iterator.previous();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException e) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }
    }

    @Test
    public void testIteratorUnsupportedOperationException() {
        linkedString.addToFront(a);
        linkedString.addToEnd(b);
        ListIterator<String> iterator = linkedString.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(a, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(f, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(b, iterator.next());

        try {
            iterator.remove();
            assertTrue("Did not throw an UnsupportedOperationException", false);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw an UnsupportedOperationException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }
    }

    @Test
    public void testRemove() {
        linkedString.addToFront(a);
        linkedString.addToEnd(b);
        assertEquals(a, linkedString.getFirst());
        assertEquals(b, linkedString.getLast());

        linkedString.remove(a, comparator);
        assertEquals(c, linkedString.getFirst());
        assertEquals(b, linkedString.getLast());

        linkedString.remove(f, comparator);
        assertEquals(c, linkedString.getFirst());
    }

    @Test
    public void testRetrieveFirstElement() {
        linkedString.addToFront(a);
        linkedString.addToEnd(b);
        assertEquals(a, linkedString.retrieveFirstElement());
        assertEquals(c, linkedString.getFirst());
    }

    @Test
    public void testRetrieveLastElement() {
        linkedString.addToFront(a);
        linkedString.addToEnd(b);
        assertEquals(b, linkedString.retrieveLastElement());
        assertEquals(f, linkedString.getLast());
    }

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String arg0, String arg1) {
            return arg0.compareTo(arg1);
        }
    }
}