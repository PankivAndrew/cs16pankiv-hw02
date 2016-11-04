package main.java.ua.edu.ucu.collections.immutable;
import java.lang.IndexOutOfBoundsException;
public class ImmutableLinkedList implements ImmutableList  {
    protected final LinkedNode head;

    public ImmutableLinkedList( LinkedNode head) {
        this.head = head;


    }

    public ImmutableLinkedList add(Object e) {
        LinkedNode new_head = new LinkedNode(e,head);
        ImmutableLinkedList result = new ImmutableLinkedList(new_head);
        return result;
    }

    public ImmutableLinkedList add(int index, Object e) {
        return null;
    }


    public ImmutableLinkedList addAll(Object[] c) {
        return null;
    }


    public ImmutableLinkedList addAll(int index, Object[] c) {
        return null;
    }


    public Object get(int index) {
        return null;
    }


    public ImmutableLinkedList remove(int index) {
        return null;
    }


    public ImmutableLinkedList set(int index, Object e) {
        return null;
    }

    public int indexOf(Object e) {
        return 0;
    }

    public int size() {
        int counter = 0;
        LinkedNode tmp = head;
        while(tmp.getNext() != null ){
            tmp = tmp.getNext();
            counter++;
        }
        return counter;
    }


    public ImmutableLinkedList clear() {
        return null;
    }


    public boolean isEmpty() {
        return false;
    }

    public Object[] toArray() {
        return new Object[0];
    }
}