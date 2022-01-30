package com.mosh;

import java.util.Stack;

public class Solution {
    Stack aStack;
    Stack minStack;

    public Solution() {
        aStack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        aStack.push(x);
        if(minStack.isEmpty() || x <= (int) minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        if(!aStack.isEmpty()){
            int popValue = (int) aStack.pop();
            if(popValue == (int) minStack.peek()){
                minStack.pop();
            }
        }
    }

    public int top() {
        if(!aStack.isEmpty()){
            return (int) aStack.peek();
        }
        return -1;
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return (int) minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        String A = "))((";
        Stack stack = new Stack();
        boolean isBalanced = true;

        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == '('){
                stack.push('(');
                continue;
            }

            if(stack.isEmpty()){
                isBalanced = false;
                break;
            }

            char check = (char) stack.pop();
            if(A.charAt(i) == ')' && (char) check != '('){
                isBalanced = false;
                break;
            }
        }

        System.out.println(stack);
        System.out.println("Is balanced ? : " + isBalanced);
    }

    private static int checkForBalancedParanthesis(){
        Stack stack = new Stack();
        String A = "{([])}";

        for(int i=0; i<A.length(); i++){
            char x = A.charAt(i);
            if(x == '(' || x == '{' || x == '['){
                stack.push(x);
                continue;
            }

            if(stack.isEmpty()){
                return 0;
            }

            char check;

            switch(x){
                case ')':
                    check = (char) stack.pop();
                    if(check == '{' || check == '[')
                        return 0;
                    break;
                case '}':
                    check = (char) stack.pop();
                    if(check == '(' || check == '[')
                        return 0;
                    break;
                case ']':
                    check = (char) stack.pop();
                    if(check == '(' || check == '{')
                        return 0;
                    break;
            }
        }

        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }
}

