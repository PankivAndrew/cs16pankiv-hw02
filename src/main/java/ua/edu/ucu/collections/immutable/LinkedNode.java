package main.java.ua.edu.ucu.collections.immutable;

/**
 * Created by Pankiv on 04.11.2016.
 */
public class LinkedNode {
    public Object data;
    public LinkedNode next;

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public LinkedNode getNext() {
        return next;
    }

    public LinkedNode(Object data) {
        this.data = data;
    }
}
