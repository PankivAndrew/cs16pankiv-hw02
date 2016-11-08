package main.java.ua.edu.ucu.collections.immutable;
//import com.sun.java.util.jar.pack.ConstantPool;

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
    ImmutableLinkedList add_reverse1(LinkedNode node, int index, Object e){
        if(index == 0){
            return add_reverse1(node,index-1,e).add(e);
        }
        else if (node == null){
            return new ImmutableLinkedList(null);
        }

        else{
            return add_reverse1(node.getNext(),index-1,e).add(node.getData());
        }

    }

    public ImmutableLinkedList add(int index, Object e) throws IndexOutOfBoundsException {
        int INDEX = size() - index ;
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        if(index == size()){
            return this.add(e);
        }else{
            return add_reverse1(this.head,INDEX,e);
            }
        }




    public ImmutableLinkedList addAll(Object[] c) {
        ImmutableLinkedList new_linked_lst = new ImmutableLinkedList(this.head);
        for (int i = 0; i < c.length;i ++ ){
            new_linked_lst = new_linked_lst.add(c[i]);
        }
        return new_linked_lst;
    }


    public ImmutableLinkedList addAll(int index, Object[] c) {
        ImmutableLinkedList new_linked_lst = new ImmutableLinkedList(null);
        Object[] a = toArray();
        for (int i = 0; i < index;i ++ ){
            new_linked_lst = new_linked_lst.add(a[i]);
        }

        int INDEX = 0;
        for(int i = index; i < c.length + 1; i++){
            new_linked_lst = new_linked_lst.add(c[INDEX]);
            INDEX ++;
        }
        for (int i = c.length - 1; i < (c.length + a.length) - 2; i ++){
            new_linked_lst = new_linked_lst.add(a[i]);
        }
        return new_linked_lst;
    }


    public Object get(int index) {
        Object answer = null;
        LinkedNode new_head = this.head;
        if(index == 0){
            answer = this.head.getData();
        }else {
            for (int i = 0; i < index + 1; i++) {
                new_head = new_head.getNext();
                answer = new_head.getData();
            }
        }
        return answer;
    }


    public ImmutableLinkedList remove(int index) throws IndexOutOfBoundsException{
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList new_linked_lst = new ImmutableLinkedList(null);
        Object[] a = toArray();
        int counter = 0;
        while (counter != index){
            new_linked_lst = new_linked_lst.add(a[counter]);
            counter++;
        }
        counter++;
        while (counter != size()){
            new_linked_lst = new_linked_lst.add(a[counter]);
            counter++;
        }
        return new_linked_lst;
    }



    public ImmutableLinkedList set(int index, Object e)throws IndexOutOfBoundsException {
        if (index > size()){
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList new_linked_lst = new ImmutableLinkedList(null);
        Object[] a = toArray();
        int counter = 0;
        while (counter != index){
            new_linked_lst = new_linked_lst.add(a[counter]);
            counter++;
        }
        new_linked_lst = new_linked_lst.add(e);
        counter++;
        while (counter != size()){
            new_linked_lst = new_linked_lst.add(a[counter]);
            counter++;
        }
        return new_linked_lst;


    }

    public int indexOf(Object e) {
        int counter = 0;
        LinkedNode tmp = this.head;
        while (tmp.getData() != e){
            tmp = tmp.getNext();
            counter++;
            if (tmp == null){
                counter = -1;
                break;
            }
        }
        return counter;
    }

    public int size() {
        int counter = 0;
        if(head != null){
            LinkedNode tmp = head;
            counter++;
            while(tmp.getNext() != null ){
                tmp = tmp.getNext();
                counter++;
            }
        }else{
            return 0;
        }
        return counter;
    }


    public ImmutableLinkedList clear() {
        ImmutableLinkedList new_linked_lst = new ImmutableLinkedList(null);
        return new_linked_lst;
    }


    public boolean isEmpty() {
        if(size() ==0){
            return true;
        }else{
            return false;
        }
    }

    public Object[] toArray() {
        Object[] new_array = new Object[this.size()];
        LinkedNode tmp = this.head;
        new_array[size() - 1] = tmp.getData();
        for (int i = size() - 2; i > -1; i--){
            tmp = tmp.getNext();
            new_array[i] = tmp.getData();
        }
        return new_array;

    }
    public String toString() {
        String str = "";
        if(size() == 0){
            str = "";
        }else {
            if (size() < 2) {
                str += head.getData();
                str += "-->";
            } else {
                LinkedNode a = this.head;
                for (int i = 0; i < size() - 1; i++) {
                    str = a.getData() + str;
                    str = "-->" + str;
                    a = a.getNext();
                }
                str = a.getData() + str;

            }
        }
        return str;
    }
    public ImmutableLinkedList addFirst(Object e){
        return this.add(0,e);
    }
    public Object getFirst(){
        return this.get(size()-2);
    }
    public ImmutableLinkedList addLast(Object e){
        return this.add(e);
    }
    public Object getLast(){
        return this.get(0);
    }
    public ImmutableLinkedList removeFirst(){
        return this.remove(0);
    }
    public ImmutableLinkedList removeLast(){
        return this.remove(size()-1);
    }
}
