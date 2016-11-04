package main.java.ua.edu.ucu.collections.immutable;
import java.lang.IndexOutOfBoundsException;
public class ImmutableArrayList implements ImmutableList {
    protected final Object[] list_of_elements;

    public ImmutableArrayList(Object[] list_of_elements) {
        this.list_of_elements = list_of_elements;
    }

    public ImmutableList add(Object e){
        Object[] new_lst = new Object[size() + 1];
        for (int i = 0; i < size(); i ++){
            new_lst[i] = this.list_of_elements[i];
        }
        new_lst[-1] = e;
        ImmutableArrayList newLinkedList = new ImmutableArrayList(new_lst);
        return newLinkedList;

    } //додає елемент у кінець колекції

    public ImmutableList add(int index, Object e)throws IndexOutOfBoundsException{
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Object[] new_lst = new Object[size() + 1];
        int INDEX = index;
        for (int i = 0;i < index;i++){
            new_lst[i] = this.list_of_elements[i];
        }
        new_lst[index] = e;
        for (int i = index; i < size(); i++){
            new_lst[i] = this.list_of_elements[INDEX];
            INDEX++;
        }
        ImmutableArrayList newLinkedList = new ImmutableArrayList(new_lst);
        return newLinkedList;

    } //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public ImmutableList addAll(Object[] c){
        Object[] new_lst = new Object[size() + c.length];
        for( int i = 0; i < size(); i ++){
            new_lst[i] = this.list_of_elements[i];
        }
        int INDEX = 0;
        for (int i = size();i < new_lst.length; i++){
            new_lst[i] = c[INDEX];
            INDEX ++;
        }
        ImmutableArrayList newLinkedList = new ImmutableArrayList(new_lst);
        return newLinkedList;


    } //додає масив елементів у кінець колекції

    public ImmutableArrayList addAll(int index, Object[] c) throws IndexOutOfBoundsException{
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Object[] new_lst = new Object[size() + c.length];
        for (int i = 0; i < index;i++ ){
            new_lst[i] = this.list_of_elements[i];
        }
        int INDEX = 0;
        for (int i = index; INDEX < c.length;i++){
            new_lst[i] = c[INDEX];
            INDEX++;
        }
        INDEX = index;
        for (int i = index + c.length; i < new_lst.length; i++){
            new_lst[i] = this.list_of_elements[INDEX];
            INDEX++;
        }
        ImmutableArrayList newLinkedList = new ImmutableArrayList(new_lst);
        return newLinkedList;


    } // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public Object get(int index) throws IndexOutOfBoundsException {
        if (index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        return this.list_of_elements[index];
    }


    //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public ImmutableArrayList remove(int index) throws IndexOutOfBoundsException{
        if (index > size() - 1){
            throw new IndexOutOfBoundsException();}
        Object [] new_list = new Object[size() - 1];
        this.list_of_elements[index] = null;
        int INDEX = 0;
        for (int i = 0; i < new_list.length;i++){
            if (this.list_of_elements[i] != null){
                new_list[INDEX] = this.list_of_elements[i];
                INDEX ++;
            }
        }
        ImmutableArrayList newArrayList = new ImmutableArrayList(new_list);
        return newArrayList;
    } //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції

    public ImmutableArrayList set(int index, Object e) throws IndexOutOfBoundsException{
        if (index > size() - 1){
            throw new IndexOutOfBoundsException();
        }
        Object[] new_lst = new Object[this.list_of_elements.length];
        for (int i = 0; i < size();i++){
            if (i == index){
                new_lst[i] = e;
            }
            else
            {
                new_lst[i] = this.list_of_elements[i];
            }

        }
        ImmutableArrayList newLinkedList = new ImmutableArrayList(new_lst);
        return newLinkedList;
    }

    public int indexOf(Object e) {
        int index = 0;
        for (int i = 0; i < list_of_elements.length; i++) {
            if (list_of_elements[i] == e) {
                index = i;
            } else {
                index = -1;
            }

        }
        return index;
    }

    public int size(){
        return this.list_of_elements.length;
    }

    public ImmutableArrayList clear(){
        ImmutableArrayList new_list = new ImmutableArrayList(null);
        return new_list;
    }

    public boolean isEmpty(){
        if (this.size() != 0){
            return true;
        }else{
            return false;

        }
    }

    public Object[] toArray(){
        Object [] new_array = new Object[size()];
        for (int i = 0; i < size(); i ++){
            new_array[i] = this.list_of_elements[i];
        }
        return new_array;
    }; //перетворює колекцію до масиву обєктів

    @Override
    public String toString(){
        String str = "";
        for(int i = 0; i < size()-1;i++){
            str += this.list_of_elements[i] + ",";
        }
        str += this.list_of_elements[-1];
        return str;

    }
}



