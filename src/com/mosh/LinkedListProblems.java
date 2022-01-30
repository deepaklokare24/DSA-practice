package com.mosh;

public class LinkedListProblems {
    static Node head;
    public static void main(String[] args) {
        insert_node(1, 23);
        insert_node(2, 24);
        insert_node(3, 25);
        print_ll();
        //insert_node(3, 100);
        delete_node(5);
        print_ll();
    }

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        int sizeofLL = size();
        Node newNode = new Node(value);
        if(head == null || sizeofLL == 0){
            head = newNode;
            return;
        }

        if(position == 1){
            newNode.next = head;
            head = newNode;
        }else if(sizeofLL == position-1){
            Node temp = head;
            int count = 1;
            while(count < position-1 && null != temp){
                count++;
                temp = temp.next;
            }
            temp.next = newNode;
        }else if(position > 1 && position-1 < sizeofLL){
            Node temp = head;
            int count = 0;
            while(count < position-1 && null != temp){
                count++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        int size = size();
        if(position == 1){
            head = head.next;
            return;
        }
        if(position > 0 && position <= size){
            Node temp = head;
            int count = 0;
            while(count < position-1 && null != temp){
                count++;
                temp = temp.next;
            }
            Node kthNode = temp;

            count = 1;
            temp = head;
            while(count < position-1 && null != temp){
                count++;
                temp = temp.next;
            }
            //System.out.println("Previous Node: " + temp.data);
            temp.next = kthNode.next;
            kthNode.next = null;
        }
    }

    public static void print_ll() {
        Node temp = head;
        int count = 0;
        int size = size();
        while(temp != null){
            count++;
            if(count == size){
                System.out.print(temp.data);
            }else{
                System.out.print(temp.data + " ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static int size() {
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
