package main.java.ua.edu.ucu.collections.immutable;
import com.sun.java.util.jar.pack.ConstantPool;

import java.lang.IndexOutOfBoundsException;
public class ImmutableLinkedList {
    protected final LinkedNode head;

    public ImmutableLinkedList( LinkedNode head) {
        this.head = head;


    }

    public ImmutableLinkedList add(Object e) {
        LinkedNode new_head = new LinkedNode(e);
        new_head.setNext(this.head);
        ImmutableLinkedList result = new ImmutableLinkedList(new_head);
        return result;
    }

    public ImmutableLinkedList add(int index, Object e) throws IndexOutOfBoundsException {
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        if(index == size()){
             return this.add(e);
        }else{
            LinkedNode new_linked_lst = new LinkedNode(this.head.getData());
            LinkedNode new_current = this.head;
            LinkedNode new_head = new_linked_lst;
            LinkedNode pre_link = new_head;
            int INDEX = size() - index;
            while (INDEX != 0){
                new_current = new_current.getNext();
                new_linked_lst = new LinkedNode(new_current.getData());
                pre_link.setNext(new_linked_lst);
                pre_link = pre_link.getNext();
                INDEX--;
            }
            LinkedNode new_element = new LinkedNode(e);
            pre_link.setNext(new_element);
            while(new_current.getNext() != null){
                new_current = new_current.getNext();
                new_linked_lst = new LinkedNode(new_current.getData());
                pre_link.setNext(new_linked_lst);
                pre_link = pre_link.getNext();
            }
            ImmutableLinkedList new_lst = new ImmutableLinkedList(new_head);
            return new_lst;
        }

    }


    public ImmutableLinkedList addAll(Object[] c) {

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