package implementation;

import myinterface.MySinglyLinkedList;

import java.nio.channels.NotYetBoundException;

public class MyLinkedList implements MySinglyLinkedList {
    //head reference or start  of linked list or reference of first node
    private Node head;
    //tail reference or end  of linked list or reference of last node
    private Node tail;
    //store total number of elements in linked list
    private int size;
    //constructor
    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return head == null;
    }
    @Override
    public void addFirst(int element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            tail = node;
            size++;
        }
        else{
            node.setNext(head);
            head = node;
            size++;
        }
    }
    //traverse
    public void traverse() {
        if (!isEmpty()) {
            Node temp = head;
            System.out.print("head-->");
            while (temp != null){
                System.out.print(temp.getData() +"-->");
                //updating temp value to refer next node of sequence
                temp = temp.getNext();
            }
            System.out.println("null");
        }
        else{
            System.out.println("linked list empty");
        }
    }
}
