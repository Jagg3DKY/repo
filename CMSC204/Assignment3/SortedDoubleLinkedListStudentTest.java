import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedListStudentTest {
    SortedDoubleLinkedList<String> sortedLinkedString;
    StringComparator comparator;

    String a = "Jacob";
    String b = "David";
    String c = "Sarah";
    String d = "Cooper";
    String e = "Franklin";
    String f = "Zeke";
    //correct order d, b, e, a, c, f 

    @BeforeEach
    public void setUp() throws Exception {
        comparator = new StringComparator();
        sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
        sortedLinkedString.add(f); 
        sortedLinkedString.add(b);
    }

    @AfterEach
    public void tearDown() throws Exception {
        sortedLinkedString = null;
        comparator = null;
    }

    @Test
    public void testGetSize() {
        assertEquals(2, sortedLinkedString.getSize());
    }

    @Test
    public void testAdd() {
        assertEquals(f, sortedLinkedString.getLast());
        sortedLinkedString.add(d);
        assertEquals(d, sortedLinkedString.getFirst());
    }

    @Test
    public void testAddSortedOrder() {
        sortedLinkedString.add(a);  
        sortedLinkedString.add(e);
        sortedLinkedString.add(b);
        
        assertEquals(b, sortedLinkedString.getFirst());
        assertEquals(f, sortedLinkedString.getLast());
    }

    @Test
    public void testAddToFront() {
        try {
            sortedLinkedString.addToFront(c);
            fail("Did not throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddToEnd() {
        try {
            sortedLinkedString.addToEnd(d);
            fail("Did not throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIteratorSuccessfulNext() {
        sortedLinkedString.add(a);
        sortedLinkedString.add(c);
        ListIterator<String> iterator = sortedLinkedString.iterator();
        
        assertTrue(iterator.hasNext());
        assertEquals(b, iterator.next());
        assertEquals(a, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(f, iterator.next());
    }

    @Test
    public void testIteratorSuccessfulPrevious() {
        sortedLinkedString.add(a);
        sortedLinkedString.add(d);
        sortedLinkedString.add(e);
        
        sortedLinkedString.add(c);
        ListIterator<String> iterator = sortedLinkedString.iterator();
        
        assertTrue(iterator.hasNext());
        assertEquals(d, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(e, iterator.next());
        assertEquals(a, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(f, iterator.next());
        assertFalse(iterator.hasNext());
        
        assertTrue(iterator.hasPrevious());
        assertEquals(f, iterator.previous());
        assertEquals(c, iterator.previous());
        assertEquals(a, iterator.previous());
        assertEquals(e, iterator.previous());
        assertEquals(b, iterator.previous());
        assertEquals(d, iterator.previous());
    }

    @Test
    public void testIteratorNoSuchElementExceptionNext() {
        sortedLinkedString.add(a);
        ListIterator<String> iterator = sortedLinkedString.iterator();
        
        assertTrue(iterator.hasNext());
        assertEquals(b, iterator.next());
        assertEquals(a, iterator.next());
        assertEquals(f, iterator.next());
        assertFalse(iterator.hasNext());
        
        try {
            iterator.next();
            fail("Did not throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIteratorNoSuchElementExceptionPrevious() {
        sortedLinkedString.add(a);
        sortedLinkedString.add(c);
        ListIterator<String> iterator = sortedLinkedString.iterator();
        
        assertEquals(b, iterator.next());
        assertEquals(a, iterator.next());
       
        assertEquals(a, iterator.previous());
        assertEquals(b, iterator.previous());
        
        try {
            iterator.previous();
            fail("Did not throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIteratorUnsupportedOperationException() {
        sortedLinkedString.add(a);
        sortedLinkedString.add(e);
        ListIterator<String> iterator = sortedLinkedString.iterator();
        
        try {
            iterator.remove();
            fail("Did not throw UnsupportedOperationException");
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testRemove() {
        sortedLinkedString.add(e);
        sortedLinkedString.add(d);
        
        assertEquals(d, sortedLinkedString.getFirst());
        assertEquals(f, sortedLinkedString.getLast());
        
        sortedLinkedString.remove(d, comparator);
        assertEquals(b, sortedLinkedString.getFirst());
    }

    @Test
    public void testRetrieveFirstElement() {
        sortedLinkedString.add(e);
        sortedLinkedString.add(c);
        
        assertEquals(b, sortedLinkedString.retrieveFirstElement());
        assertEquals(e, sortedLinkedString.getFirst());
    }

    @Test
    public void testRetrieveLastElement() {
        sortedLinkedString.add(a);
        sortedLinkedString.add(d);
        
        assertEquals(f, sortedLinkedString.retrieveLastElement());
        assertEquals(a, sortedLinkedString.getLast());
    }

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String arg0, String arg1) {
            return arg0.compareTo(arg1);
        }
    }
}