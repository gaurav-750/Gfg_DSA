package BinaryTrees;

public class BinaryTreeNode<T> {

    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    T data;

    public BinaryTreeNode(T data){
        this.data = data;
    }
}
