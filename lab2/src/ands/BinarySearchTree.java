package ands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<T>
{
    protected Node root;

    protected static class Node<T>
    {
        T value;
        Node left;
        Node right;
        public Node(T t)
        {
            this.value = t;
        }
    }

    public BinarySearchTree() { this.root = null; }

    public BinarySearchTree(List<T> list)
    {
        for (T t:list) {
            this.add(t);
        }
    }


    public void add(T t)
    {
        Node item = new Node(t);

        if(this.root == null)
        {
            this.root = item;
            return;
        }

        this.add(item, this.root);
    }

    private void add(Node item, Node n)
    {

        if(item.value.hashCode() < n.value.hashCode())
        {
            if(n.left == null)
            {
                n.left = item;
                return;
            }

            this.add(item, n.left);
        }
        else
        {
            if(n.right == null)
            {
                n.right = item;
                return;
            }
            this.add(item, n.right);
        }
    }

    public void delete(T t){
        List l = this.inorder();
        l.remove(t);
        this.root = new BinarySearchTree(l).root;
    }

    public void printInorder()
    {
        if(this.root == null)
        {
            return;
        }

        printInorder(this.root);
    }

    private void printInorder(Node n)
    {
        if(n.left != null)
        {
            printInorder(n.left);
        }
        System.out.println(n.value);
        if(n.right != null)
        {
            printInorder(n.right);
        }
    }

    //inorder

    public List<T> inorder()
    {
        if(this.root == null)
        {
            return null;
        }

        return inorder(new ArrayList<T>(), this.root);
    }

    private List<T> inorder(List<T> list, Node n)
    {
        if(n.left != null)
        {
            inorder(list, n.left);
        }

        list.add((T) n.value);

        if(n.right != null)
        {
            inorder(list, n.right);
        }

        return list;
    }

    //preorder

    public void printPreorder()
    {
        if(this.root == null)
        {
            return;
        }

        printPreorder(this.root);
    }

    private void printPreorder(Node n)
    {
        System.out.println(n.value);
        if(n.left != null)
        {
            printPreorder(n.left);
        }
        if(n.right != null)
        {
            printPreorder(n.right);
        }
    }

    public List<T> preorder()
    {
        if(this.root == null)
        {
            return null;
        }

        return preorder(new ArrayList<T>(), this.root);
    }

    private List<T> preorder(List<T> list, Node n)
    {
        list.add((T) n.value);
        if(n.left != null)
        {
            preorder(list, n.left);
        }

        if(n.right != null)
        {
            preorder(list, n.right);
        }

        return list;
    }

    //postorder

    public void printPostorder()
    {
        if(this.root == null)
        {
            return;
        }

        printPostorder(this.root);
    }

    private void printPostorder(Node n)
    {
        if(n.left != null)
        {
            printPostorder(n.left);
        }
        if(n.right != null)
        {
            printPostorder(n.right);
        }
        System.out.println(n.value);
    }

    public List<T> postorder()
    {
        if(this.root == null)
        {
            return null;
        }

        return postorder(new ArrayList<T>(), this.root);
    }

    private List<T> postorder(List<T> list, Node n)
    {
        if(n.left != null)
        {
            postorder(list, n.left);
        }
        if(n.right != null)
        {
            postorder(list, n.right);
        }
        list.add((T) n.value);

        return list;
    }

    public long getHeight()
    {
        return getHeight(this.root);
    }

    protected long getHeight(Node n)
    {
        if(n == null)
        {
            return 0;
        }
        return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }

    public boolean contains(T t)
    {
        return contains(this.root, new Node(t));
    }

    private boolean contains(Node current, Node n)
    {
        if(current == null)
        {
            return false;
        }
        if(current.value.equals(n.value))
        {
            return true;
        }
        if(n.value.hashCode() < current.value.hashCode())
        {
            return contains(current.left, n);
        }
        else
        {
            return contains(current.right, n);
        }
    }

    public void printSorted(){
        List<T> l = this.inorder();
        for (T t : l) {
            System.out.println(t + " ");
        }
        Collections.reverse(l);
        for (T t : l) {
            System.out.println(t + " ");
        }
    }
    public T findSecondLargest(){
        List<T> l = this.inorder();
        return l.get(l.size() - 2);
    }

    public BinarySearchTree copy(){
        return new BinarySearchTree(this.inorder());
    }
    public BinarySearchTree insert(BinarySearchTree bst) {
        List<T> l = this.inorder();
        l.addAll(bst.inorder());
        return new BinarySearchTree(l);
    }
    public boolean equals(BinarySearchTree bst) {
        return (this.inorder().equals(bst.inorder()) && this.preorder().equals(bst.preorder()) && this.postorder().equals(bst.postorder()));
    }
    public BinarySearchTree symmetricalTree(){
        BinarySearchTree bst = this.copy();
        bst.symmetricalTree(bst.root);
        return bst;
    }

    private void symmetricalTree(Node n) {
        if(n == null){
            return;
        }
        symmetricalTree(n.left);
        symmetricalTree(n.right);
        Node temp = n.left;
        n.left = n.right;
        n.right = temp;
    }
    public T fatherNode(T t){
        if(t.equals(this.root.value)){
            return (T) this.root.value;
        }
        Node n = new Node(t);
        return fatherNode(this.root, n);
    }

    private T fatherNode(Node current, Node n){
        if (current == null){
            return null;
        }
        if((current.right != null && current.right.value.equals(n.value)) || (current.left != null && current.left.value.equals(n.value))){
            return (T) current.value;
        }
        if(n.value.hashCode() < current.value.hashCode()){
            return fatherNode(current.left, n);
        }
        else {
            return fatherNode(current.right, n);
        }
    }
    public T commonAncestor(T t1, T t2){
        if(this.fatherNode(t1).equals(this.fatherNode(t2))){
            return this.fatherNode(t1);
        }
        return commonAncestor(this.fatherNode(t1), this.fatherNode(t2));
    }
}
