package test.java.ua.edu.ucu.collections.immutable;

import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList testList = new ImmutableLinkedList(null);
    private Object[] toAdd = {4, 7, "a", 8, 6.8};

    public ImmutableLinkedListTest() {
        testList = testList.addAll(toAdd);
    }

    @Test
    public void testAddToEmpty() {
        ImmutableLinkedList testList = new ImmutableLinkedList(null);
        String expected = "5-->";
        testList = testList.add(5);
        assertEquals(expected, testList.toString());
    }
    @Test
    public void testAdd() {
        String expected = "4-->7-->a-->8-->6.8-->100";
        testList = testList.add(100);
        assertEquals(expected, testList.toString());
    }
    @Test
    public void testAddIndex(){
        String expected = "4-->7-->a-->8-->6.8-->5-->8-->6";
        testList = testList.add(5);
        testList = testList.add(8);
        testList = testList.add(7, 6);
        assertEquals(expected, testList.toString());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexWrong() {
        testList.add(10, 'a');
    }
    @Test
    public void testAddAllToEmpty() {
        String expected = "5-->6-->8-->ty";
        ImmutableLinkedList testList = new ImmutableLinkedList(null);

        Object[] arr = {5,6,8,"ty"};
        testList = testList.addAll(arr);
        assertEquals(expected, testList.toString());
    }
    @Test
    public void testAddAll() {
        String expected = "4-->7-->a-->8-->6.8-->100-->eat-->brains";
        testList = testList.addAll(new Object[] {100, "eat", "brains"});
        assertEquals(expected, testList.toString());
    }
    @Test
    public void testAddAllIndex() {
        String expected = "4-->6-->8-->7-->a-->8-->6.8";
        Object[] arr = {6,8};
        testList = testList.addAll(1, arr);
        assertEquals(expected, testList.toString());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexWrong() {
        testList.add(10, new Object[] {1, 9, 0});
    }
    @Test
    public void testGet() {
        String expected = "7";
        Object for_test = null;
        for_test = testList.get(1);
        assertEquals(expected, for_test.toString());
    }
    @Test
    public void testRemove() {
        String expected = "4-->a-->8-->6.8";
        testList = testList.remove(1);
        assertEquals(expected, testList.toString());
    }
    @Test
    public void testRemoveFrom1ElList() {
        ImmutableLinkedList testList = new ImmutableLinkedList(null);
        testList = testList.add(9);
        testList = testList.remove(0);
        assertEquals("", testList.toString());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex () {
        testList.remove(10);
    }
    @Test
    public void testSet(){
        String expected = "4-->5-->a-->8-->6.8";
        testList = testList.set(1,5);
        assertEquals(expected,testList.toString());
    }
    @Test
    public void testSetFirstElement(){
        String expected = "5-->7-->a-->8-->6.8";
        testList = testList.set(0,5);
        assertEquals(expected,testList.toString());
    }
    @Test
    public void testSetLastElement(){
        String expected = "4-->7-->a-->8-->5";
        testList = testList.set(4,5);
        assertEquals(expected,testList.toString());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongIndex(){
        testList = testList.set(6,5);
    }


    @Test
    public void testIndexOfIn() {
        int expected = 2;
        assertEquals(expected, testList.indexOf("a"));
    }
    @Test
    public void testIndexOfNotIn() {
        int expected = -1;
        assertEquals(expected, testList.indexOf("bnnm"));
    }
    @Test
    public void testClear() {
        testList = testList.clear();
        assertEquals("",  testList.toString());
    }
    @Test
    public void testAddFirst() {
        String expected = "1-->4-->7-->a-->8-->5";
        testList = testList.addFirst(1);
        assertEquals(expected,testList.toString());
    }



    @Test
    public void testAddLast() {
        String expected = "4-->7-->a-->8-->5-->1";
        testList = testList.addLast(1);
        assertEquals(expected,testList.toArray());
    }
    @Test
    public void testRemoveFirst() {
        String expected = "7-->a-->8-->5";
        testList = testList.removeFirst();
        assertEquals(expected,testList.toString());
    }
    @Test
    public void testRemoveLast() {
        String expected = "4-->7-->a-->8";
        testList = testList.removeLast();
        assertEquals(expected,testList.toString());
    }
    @Test
    public void testGetFirst() {
        String expected = "4";
        Object a = testList.getFirst();
        assertEquals(expected,a);
    }
    @Test
    public void testGetLast() {
        String expected = "5";
        Object a = testList.getLast();
        assertEquals(expected,a);
    }








}
