package test.java.ua.edu.ucu.collections.immutable;
import main.java.ua.edu.ucu.collections.immutable.ImmutableArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList testArr = new ImmutableArrayList(null);
    private Object[] toAdd = {4, 7, "a", 8, 6.8};
    public ImmutableArrayListTest (){


        testArr = testArr.addAll(toAdd);
    }


    @Test
    public void testAdd() {
        String expected = "4,7,a,8,6.8,5";
        testArr = testArr.add(5);
        assertEquals(expected, testArr.toString());
    }

    @Test
    public void testAddAllEmptyList() {
        String expected = "4,7,a,8,6.8";
        Object[] lst = {};
        testArr = testArr.addAll(lst);
        assertEquals(expected, testArr.toString());
    }

    @Test
    public void testAddAll() {
        String expected = "4,7,a,8,6.8,4,7,a,8,6.8";
        testArr = testArr.addAll(toAdd);
        assertEquals(expected, testArr.toString());
    }


    @Test
    public void testAddIndex() {
        String expected = "4,7,b,a,8,6.8";


        testArr = testArr.add(2, 'b');
        assertEquals(expected, testArr.toString());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllTooLargeIndex() {
        String expected = "4,7,a,8,6.8,4,7,a,8,6.8";
        testArr = testArr.addAll(5, toAdd);
        assertEquals(expected, testArr.toString());
    }
    @Test
    public void testAddAllIndex() {
        String expected = "4,4,7,a,8,6.8,7,a,8,6.8";
        testArr = testArr.addAll(1, toAdd);
        assertEquals(expected, testArr.toString());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveTooLargeIndex() {
        testArr.remove(20);
    }
    @Test
    public void testRemove() {
        String expected = "4,a,8,6.8";

        testArr = testArr.remove(1);
        assertEquals(expected, testArr.toString());
    }
    @Test
    public void testIndexOfIsInList() {
        int expected = 1;

        assertEquals(expected, testArr.indexOf(7));
    }
    @Test
    public void testIndexOfNotInList() {
        int expected = -1;
        assertEquals(expected, testArr.indexOf(90));
    }
    @Test
    public void testEmptyList() {
        assertTrue(new ImmutableArrayList(null).isEmpty());

    }
    @Test
    public void testNotEmptyList() {
        assertFalse(testArr.isEmpty());

    }
    @Test
    public void testToArray() {
        assertArrayEquals(toAdd, testArr.toArray());
    }
}
