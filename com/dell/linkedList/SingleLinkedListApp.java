package com.dell.linkedList;

public class SingleLinkedListApp {

    public static void insert(Node head, int val){
       while(head.getNext() != null){
           head = head.getNext();
       }
       head.setNext(new Node(val));
    }

    public static Node reverseLinkedList(Node head) {
        Node next = null;
        Node prev = null;
        Node current = head;
        while(current != null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    public static int middleNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getData();
    }


}
