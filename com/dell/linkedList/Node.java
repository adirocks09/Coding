package com.dell.linkedList;

public class Node {

    private int data;
    private Node next;
    private Node prev;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node insert(int val){
        Node newNode = new Node(val);
        this.setNext(newNode);
        return newNode;
    }

    public void displayNodes(){
        Node head = this;
        while(head != null){
            System.out.print(head.getData() + " --> ");
            head=head.getNext();
        }
        System.out.print("NULL");
        System.out.println();
    }

}
