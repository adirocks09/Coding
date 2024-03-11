package com.dell.linkedList;

public class App1 {

    public static void main(String args[]){

    }

    public Node init(int x){
        Node headNode = new Node(5);
        headNode.setNext(null);
        return headNode;
    }

    public Node push(Node headNode, int a){
        if(headNode == null){
            return init(a);
        }else{
            while(headNode.getNext()!=null){
                headNode=headNode.getNext();
            }
            Node newNode = new Node(a);
            headNode.setNext(newNode);
            return newNode;
        }
    }
}
