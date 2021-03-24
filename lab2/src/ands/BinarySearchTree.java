package ands;

import java.util.ArrayList;
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

    public BinarySearchTree() { }

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

}
