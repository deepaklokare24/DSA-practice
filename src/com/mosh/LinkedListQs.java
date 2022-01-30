package com.mosh;

public class LinkedListQs {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node tail;
        Node node1 = new Node(2);
        head.next = node1;
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(4);
        node2.next = node3;
        tail = node3;

        //head = insertAtTheBeginning(head);

        //insertAtTheEndWithoutTail(head);

        //tail = insertAtTheEndWitTail(tail);

        insertAtTheKthPosition(head, 2);

        //head = removeFromTheBeginning(head);

        //removeFromTheEnd(head);

        //removeAtKthPosition(head, 1);
        printAll(head);
        System.out.println("Length of LinkedList : " + findLengthOfLL(head));
    }

    private static void printAll(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data + " " + temp.next);
            temp = temp.next;
        }
    }

    private static int findLengthOfLL(Node head){
        int length = 0;
        Node temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    private static Node insertAtTheBeginning(Node head){
        Node newNode = new Node(0);
        newNode.next = head;
        head = newNode;
        //System.out.println(head.data + " " + head.next);
        return head;
    }

    private static void insertAtTheEndWithoutTail(Node head){
        Node newNode = new Node(5);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    private static Node insertAtTheEndWitTail(Node tail){
        Node newNode = new Node(5);
        tail.next = newNode;
        tail = newNode;
        return tail;
    }

    private static void insertAtTheKthPosition(Node head, int k){
        Node newNode = new Node(100);
        Node temp = head;
        int count = 0;
        while(count < k-1 && null != temp){
            count++;
            temp = temp.next;
        }
        System.out.println("Count : " + count + " K : " + k);

        if(count == k-1 && null != temp){
            newNode.next = temp.next;
            temp.next = newNode;
        }

    }

    private static Node removeFromTheBeginning(Node head) {
        head = head.next;
        return head;
    }

    private static void removeFromTheEnd(Node head) {
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    private static void removeAtKthPosition(Node head, int k) {
        if(k > 0){
            Node temp = head;
            int count = 0;
            while(count < k-1 && null != temp){
                count++;
                temp = temp.next;
            }
            Node kthNode = temp;

            temp = head;
            count = 1;
            while(count < k-1 && null != temp){
                count++;
                temp = temp.next;
            }
            temp.next = kthNode.next;
            kthNode.next = null;
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


