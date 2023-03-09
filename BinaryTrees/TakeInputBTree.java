package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TakeInputBTree {

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = takeInput();
        printBinaryTree(root);
    }

    public BinaryTreeNode<Integer> getInput(){
        return takeInput();
    }

    public void printTree(BinaryTreeNode<Integer> root){
        printBinaryTree(root);
    }

    private static void printBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> curNode = queue.poll();
            System.out.print(curNode.data + ": ");
//            todo left node
            if (curNode.left != null){
                System.out.print("L" + curNode.left.data + ", ");
                queue.add(curNode.left);
            }

//            todo right node
            if (curNode.right != null){
                System.out.print("R" + curNode.right.data + ", ");
                queue.add(curNode.right);
            }
            System.out.println();
        }
    }

    private static BinaryTreeNode<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the root node: ");
        int rootData = sc.nextInt();
        if (rootData == -1)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> curNode = queue.poll();
//            todo left node
            System.out.print("Enter the left child of "+ curNode.data + ": ");
            int leftNodeData = sc.nextInt();
            if (leftNodeData != -1){
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>(leftNodeData);
                curNode.left = leftNode;
                queue.add(leftNode);
            }

//            todo right node
            System.out.print("Enter the right child of "+ curNode.data + ": ");
            int rightNodeData = sc.nextInt();
            if (rightNodeData != -1){
                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>(rightNodeData);
                curNode.right = rightNode;
                queue.add(rightNode);
            }
        }
        return root;
    }
}
