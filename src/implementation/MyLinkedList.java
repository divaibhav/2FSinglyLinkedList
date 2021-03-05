package implementation;

import myinterface.MySinglyLinkedList;


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
    public void addLast(int element) {
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }
        size++;

    }

    @Override
    public void addLastWithoutUsingTail(int element) {
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            //temp is last node
            temp.setNext(node);
            tail = node;
        }
        size++;

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

    @Override
    public void addAfterGivenNode(int givenElement, int element) {
        Node node = new Node(element);
        if(!isEmpty()){
            //case 1, not needed
            if(head == tail){
                if(head.getData() == givenElement){
                    head.setNext(node);
                    tail = node;
                    size++;
                }
                else {
                    System.out.println("givenElement not found in list");
                }
            }
            else{
                Node temp = head;
                while(temp != null && temp.getData() != givenElement){
                    temp = temp.getNext();
                }
                if(temp != null){
                   //case 2
                    node.setNext(temp.getNext());
                    temp.setNext(node);
                    size++;
                    if(temp == tail){
                        tail = node;
                    }
                }
                else{
                    System.out.println("givenElement not found in list");
                }
            }
        }
        else{
            System.out.println("empty list");
        }
    }

    @Override
    public int removeFirst() {
        int response = 0;//considering 0 as invalid data
        if(!isEmpty()){
            response = head.getData();
            head = head.getNext();
            if(head == null){
                tail = null;
            }
            size--;
        }
        return response;
    }

    @Override
    public int removeLast() {
        int response = 0;
        if(!isEmpty()){
            response = tail.getData();
            Node temp = head;
            Node previous = null;
            while(temp.getNext() != null){
                previous = temp;
                temp = temp.getNext();
            }
            //multiple nodes in linked list
            if(previous != null){
                previous.setNext(null);
                tail = previous;
            }
            //single node
            else {
                head = null;
                tail = null;
            }
            size--;
        }
        return response;
    }

    @Override
    public int removeGivenNode(int givenElement) {

        return 0;
    }

    @Override
    public boolean search(int element) {
        return false;
    }

    @Override
    public int first() {
        if(!isEmpty()){
            return head.getData();
        }
        return 0;
    }

    @Override
    public int last() {
        if(!isEmpty()){
            return tail.getData();
        }
        return 0;
    }

    public Node getHead() {
        return head;
    }

    //printing linked list in reverse
    public void traverseReverse(Node node){
        if(node == null){
            return;
        }
        traverseReverse(node.getNext());
        System.out.print(node.getData() +",");
    }
}
