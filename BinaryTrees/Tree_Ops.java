package BinaryTrees;

import java.util.Scanner;

public class Tree_Ops {
//    private static BinaryTreeNode<Integer> root;

    public static BinaryTreeNode<Integer> insert(int value, BinaryTreeNode<Integer> root){
        if (root == null)
            return new BinaryTreeNode<>(value);

        if (value < root.data){
            root.left = insert(value, root.left);
        }else {
            root.right = insert(value, root.right);
        }

        return root;
    }

    public static boolean findNode(BinaryTreeNode<Integer> root, int value){
        if (root.data == value)
            return true;

        if (value < root.data){
            return findNode(root.left, value);
        }else {
            return findNode(root.right, value);
        }
    }

    public static void main(String[] args) {
        TakeInputBTree input = new TakeInputBTree();
        BinaryTreeNode<Integer> root = input.getInput();
        input.printTree(root);

        Scanner sc = new Scanner(System.in);
        root = insert(sc.nextInt(), root);

        input.printTree(root);

        System.out.println(findNode(root, 7));
    }
}
