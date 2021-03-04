package ands;

public class BinarySearchTree<T>
{
    private Node root;

    private static class Node<T>
    {
        T value;
        Node left;
        Node right;
        public Node(T t)
        {
            this.value = t;
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
}
