package main.java.ua.edu.ucu.collections;

import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import main.java.ua.edu.ucu.collections.immutable.LinkedNode;

public class Queue extends ImmutableLinkedList {
    private ImmutableLinkedList Queue;


    public Queue(LinkedNode head) {
        super(head);
    }
    public Object peek(){
        return Queue.get(0);
    }
    public Object dequeue(){
        Object new_queue = Queue.get(0);
        Queue = Queue.remove(0);
        return new_queue;
    }
    public void enqueue(Object e){
        Queue = Queue.add(e);
    }

}
