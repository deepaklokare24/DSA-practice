package com.mosh;

import java.util.Stack;

public class Stacks {
    int[] arr = new int[10];
    int top = -1;

    void push(int item){
        if(top < arr.length-1){
            top++;
            arr[top] = item;
        }
    }

    int pop(){
        int temp = 0;
        if(top >= 0){
            temp = arr[top];
            top--;
        }
        return temp;
    }

    void printStack(){
        for(int i=0; i<=top; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Stacks custom = new Stacks();

        custom.push(5);
        custom.push(7);
        custom.push(10);
        custom.push(15);
        custom.pop();
        custom.push(20);
        custom.push(34);
        custom.pop();
        custom.pop();
        custom.pop();
        custom.printStack();

        Queues queue = new Queues();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.printStack();
    }
}

class Queues{
    int[] arr = new int[10];
    int front = -1;
    int rear = -1;

    void enqueue(int item){
        if(front == -1){
            front++;
            rear++;
            arr[front] = item;
        }else if(front < arr.length-1){
            int index = front;
            front++;
            arr[front] = arr[index];
            while(index > rear){
                arr[index] = arr[index-1];
                index--;
            }
            arr[rear] = item;
        }
    }

    void dequeue(){
        if(front >= 0){
            front--;
        }
    }

    void printStack(){
        for(int i=0; i<= front; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
