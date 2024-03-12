package com.dell.linkedList;

public class MainApp {
    public static void main(String args[]){
        Node head = new Node(5);
        head.insert(10)
                .insert(15)
                .insert(20)
                .insert(25);

       head.displayNodes();

       int middle = SingleLinkedListApp.middleNode(head);
       System.out.println("Middle Element : " + middle);

        SingleLinkedListApp.reverseLinkedList(head).displayNodes();
        head.displayNodes();

    }
}
