package com.mosh;

import java.util.ArrayList;
import java.util.Stack;

public class Trees {
    static int count = 0;

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(20);
        n1.leftNode = n2;
        n1.rightNode = n3;
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(7);
        n2.leftNode = n4;
        n2.rightNode = n5;
        TreeNode n6 = new TreeNode(30);
        n3.rightNode = n6;

        /* // Traverse in Preorder way
        System.out.println("Pre order: ");
        preOrderWithoutRecursion(n1);
        // Traverse in InOrder way
        System.out.println("\nIn order: ");
        inOrderWithoutRecursion(n1);
        // Traverse in PostOrder way
        System.out.println("\nPost order: ");
        postOrderWithoutRecursion(n1);

        System.out.println("\nheight of Tree : " + heightOfTree(n1));*/
        //System.out.println(searchTheGivenKey(n1, 33));

       /* countingNodesGreaterThanItsAncestors(n1, Integer.MIN_VALUE);
        System.out.println("coutn : " + count);*/

       /* TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        a1.leftNode = a2;
        a1.rightNode = a3;
        a2.leftNode = a4;
        a2.rightNode = a5;
        a3.rightNode = a6;

        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);
        TreeNode b5 = new TreeNode(5);
        TreeNode b6 = new TreeNode(6);
        b1.leftNode = b3;
        b1.rightNode = b2;
        b3.leftNode = b6;
        b2.leftNode = b5;
        b2.rightNode = b4;*/

        //System.out.println("Is Identical : " + checkIfTwoTreesAreIdenticalOrNot(a3, b3));
        //System.out.println("Is Symmetrical: " + checkIfSymmetrical(a1, b1));

//        invert(n1);
//        System.out.println("Pre order after : ");
//        preOrderWithoutRecursion(n1);

        //searchKeyInBinarySearchTreeBST();

        //countWithInStandAndEndRange();

        findPathToGivenNode();

    }

    private static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    private static void preOrderWithoutRecursion(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        ArrayList<Integer> result = new ArrayList<>();

        while(current != null || stack.size() > 0){
            if(current.rightNode != null){
                stack.push(current.rightNode);
            }
            if(current != null){
                result.add(current.data);
                current = current.leftNode;
            }
            if(current == null && !stack.isEmpty()){
                current = stack.pop();
                //result.add(current.data);
            }
        }
        System.out.println(result);
    }

    private static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.leftNode);
        System.out.print(root.data + " ");
        inOrder(root.rightNode);
    }

    private static void inOrderWithoutRecursion(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        ArrayList<Integer> result = new ArrayList<>();
        while(current != null || stack.size() > 0){
            while (current != null){
                stack.push(current);
                current = current.leftNode;
            }

            current = stack.pop();
            result.add(current.data);
            current = current.rightNode;
        }
        System.out.println(result);
    }

    private static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        System.out.print(root.data + " ");
    }

    private static void postOrderWithoutRecursion(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode current = root;
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return;
        }

        stack1.push(current);

        while(!stack1.isEmpty()){
            TreeNode temp  = stack1.pop();
            stack2.push(temp);
            if(temp.leftNode != null){
                stack1.push(temp.leftNode);
            }
            if(temp.rightNode != null){
                stack1.push(temp.rightNode);
            }
        }

        while(!stack2.isEmpty()){
            result.add(stack2.pop().data);
        }

        System.out.println(result);
    }

    private static int heightOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        int lstHeight = heightOfTree(root.leftNode);
        int rstHeight = heightOfTree(root.rightNode);
        return Math.max(lstHeight, rstHeight) + 1;
    }

    private static boolean searchTheGivenKey(TreeNode root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        return searchTheGivenKey(root.leftNode, key) || searchTheGivenKey(root.rightNode, key);
    }

    private static int checkIfTwoTreesAreIdenticalOrNot(TreeNode a1, TreeNode b1){
        if(a1 == null && b1 == null){
            return 1;
        }
        if(a1 == null || b1 == null){
            return 0;
        }
        if(a1.data != b1.data){
            return 0;
        }

        return (checkIfTwoTreesAreIdenticalOrNot(a1.leftNode, b1.leftNode) == 1 && checkIfTwoTreesAreIdenticalOrNot(a1.rightNode, b1.rightNode) == 1 ) ? 1 : 0;
    }

    private static boolean checkIfSymmetrical(TreeNode a1, TreeNode b1){
        if(a1 == null && b1 == null){
            return true;
        }
        if(a1 == null || b1 == null){
            return false;
        }
        if(a1.data != b1.data){
            return false;
        }

        return checkIfSymmetrical(a1.leftNode, b1.rightNode) && checkIfSymmetrical(a1.rightNode, b1.leftNode);
    }

    private static void countingNodesGreaterThanItsAncestors(TreeNode root, int maxx){
        if(root == null){
            return;
        }
        if(root.data > maxx){
            count++;
        }

        countingNodesGreaterThanItsAncestors(root.leftNode, Math.max(maxx, root.data));
        countingNodesGreaterThanItsAncestors(root.rightNode, Math.max(maxx, root.data));
    }

    private static TreeNode invert(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode invertedLST = invert(root.leftNode);
        TreeNode invertedRST = invert(root.rightNode);
        root.rightNode = invertedLST;
        root.leftNode = invertedRST;
        return root;
    }

    private static void searchKeyInBinarySearchTreeBST(){
        TreeNode n10 = new TreeNode(10);
        TreeNode n8 = new TreeNode(8);
        TreeNode n20 = new TreeNode(20);
        TreeNode n6 = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);
        TreeNode n18 = new TreeNode(18);
        TreeNode n25 = new TreeNode(25);

        n10.leftNode = n8;
        n10.rightNode = n20;
        n8.leftNode = n6;
        n8.rightNode = n9;
        n20.leftNode = n18;
        n20.rightNode = n25;

        System.out.println("Search in BST wit Key-> 18 : " + search(n10, 18));
    }

    private static boolean search(TreeNode root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }

        if(key > root.data){
            return search(root.rightNode, key);
        }else{
            return search(root.leftNode, key);
        }
    }

    private static void countWithInStandAndEndRange(){
        TreeNode n20 = new TreeNode(20);
        TreeNode n10 = new TreeNode(10);
        TreeNode n30 = new TreeNode(30);
        TreeNode n5 = new TreeNode(5);
        TreeNode n18 = new TreeNode(18);
        TreeNode n50 = new TreeNode(50);
        TreeNode n40 = new TreeNode(40);
        TreeNode n70 = new TreeNode(70);

        n20.leftNode = n10;
        n20.rightNode = n30;
        n10.leftNode = n5;
        n10.rightNode = n18;
        n30.rightNode = n50;
        n50.leftNode = n40;
        n50.rightNode = n70;

        System.out.println("count nodes between 17 and 45 : " + countInRange(n20, 17, 45));
    }

    private static int countInRange(TreeNode root, int s, int e){
        if(root == null){
            return 0;
        }
        if(root.data >= s && root.data <= e){
            return countInRange(root.leftNode, s, e) + countInRange(root.rightNode, s, e) + 1;
        }else if(root.data < s){
            return countInRange(root.rightNode, s, e);
        }else{
            return countInRange(root.leftNode, s, e);
        }
    }

    private static void findPathToGivenNode(){
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        a1.leftNode = a2;
        a1.rightNode = a3;
        a2.leftNode = a4;
        a2.rightNode = a5;
        a3.leftNode = a6;
        a3.rightNode = a7;

        ArrayList<Integer> result = new ArrayList<>();
        if(haspath(a1, result, 50)){
            System.out.println(result);
        }else{
            System.out.println(result);
        }
    }

    private static boolean haspath(TreeNode root, ArrayList<Integer> arr, int key){
        if(root == null){
            return false;
        }
        arr.add(root.data);

        if(root.data == key){
            return true;
        }

        if(haspath(root.leftNode, arr, key) || haspath(root.rightNode, arr, key)){
            return true;
        }

        arr.remove(arr.size()-1);
        return false;
    }

}

class TreeNode {
    int data;
    TreeNode leftNode;
    TreeNode rightNode;

    TreeNode(int x){
        this.data = x;
        this.leftNode = null;
        this.rightNode = null;
    }
}
