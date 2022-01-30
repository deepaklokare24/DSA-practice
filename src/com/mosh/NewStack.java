package com.mosh;

import java.util.Stack;

public class NewStack {
    Stack aStack;
    Stack minStack;
    int min = Integer.MAX_VALUE;
    public NewStack() {
        aStack = new Stack();
        minStack = new Stack();
    }

    void push(int item){
        aStack.push(item);
        if(item <= min){
            min = item;
            minStack.push(min);
        }
    }

    void pop(){
        if(!aStack.isEmpty()){
            int popValue = (int) aStack.pop();
            if(popValue == (int) minStack.peek()){
                minStack.pop();
            }
        }

    }

    int getMinimum(){
        return (int) minStack.peek();
    }

    public static void main(String[] args) {
        NewStack stack = new NewStack();
        stack.push(10);
        stack.push(12);
        stack.push(7);
        stack.push(6);
        stack.push(9);
        stack.push(11);
        System.out.println("Stack > " + stack.aStack + "Get Min : " + stack.getMinimum());
        stack.push(4);
        stack.push(2);
        System.out.println("Stack > " + stack.aStack + "Get Min : " + stack.getMinimum());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("Stack > " + stack.aStack + "Get Min : " + stack.getMinimum());
    }
}
