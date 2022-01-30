package com.mosh;

import java.util.ArrayList;
import java.util.List;

class ListNode {
       public int val;
       public ListNode next;
       ListNode(int x) { val = x; next = null; }
}

public class LinkedListAssignments {
    static ListNode head;
    public static void main(String[] args) {
        int[][] A = {{2, 18, 0},{2, 5, 1},{2, 8, 0},{1, 7, -1},{1, 5, -1}};
        int N = A.length;
        int M = A[0].length;
        //System.out.println(N + " " + M);

        for(int i=0; i<N; i++){
            if(A[i][0] == 0 && A[i][2] == -1){
                ListNode node = new ListNode(A[i][1]);
                if(head == null){
                    head = node;
                }else{
                    node.next = head;
                    head = node;
                }
            }else if(A[i][0] == 1 && A[i][2] == -1){
                ListNode node = new ListNode(A[i][1]);
                if(head == null){
                    head = node;
                }else{
                    ListNode temp = head;
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    temp.next = node;
                }
            }else if(A[i][0] == 2){
                int index = A[i][2];
                int size = size();
                ListNode node = new ListNode(A[i][1]);
                if(index == 0){
                    node.next = head;
                    head = node;
                }else if(index == size){
                    ListNode temp = head;
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    temp.next = node;
                }else if(index > 0 && index < size){
                    ListNode temp = head;
                    int count = 1;
                    while(count < index && null != temp){
                        count++;
                        temp = temp.next;
                    }
                    node.next = temp.next;
                    temp.next = node;
                }
            }else if(A[i][0] == 3){
                int index = A[i][1];
                int size = size();
                if(index == 0){
                    head = head.next;
                }
                if(index > 0 && index <= size){
                    ListNode temp = head;
                    int count = 0;
                    while(count < index && null != temp){
                        count++;
                        temp = temp.next;
                    }
                    ListNode kthNode = temp;

                    count = 1;
                    temp = head;
                    while(count < index && null != temp){
                        count++;
                        temp = temp.next;
                    }
                    temp.next = kthNode.next;
                    kthNode.next = null;
                }
            }
        }

        print_ll();
        //return head;
    }

    public static void print_ll() {
        ListNode temp = head;
        int count = 0;
        int size = size();
        while(temp != null){
            count++;
            if(count == size){
                System.out.print(temp.val);
            }else{
                System.out.print(temp.val + " ");
            }
            temp = temp.next;
        }
    }

    public static int size() {
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
