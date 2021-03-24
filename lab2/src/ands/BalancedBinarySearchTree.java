package ands;

import java.util.List;

public class BalancedBinarySearchTree<T> extends BinarySearchTree{

    public BalancedBinarySearchTree()
    {
        super();
    }

    public BalancedBinarySearchTree(List<T> list) {
        for(T t : list) {
            super.add(t);
        }
        this.sort();
    }


    public void add(Object t){
        super.add(t);
        this.sort();
    }

    public void sort(){
        List<T> list = this.inorder();
        this.root = this.sort(list);
    }

    private Node sort(List<T> list)
    {
        if(list.size() == 1)
        {
            return new Node(list.get(0));
        }
        if (list.isEmpty())
        {
            return null;
        }
        int mid = list.size() / 2;

        Node n = new Node(list.get(mid));
        n.left = sort(list.subList(0, mid));
        n.right = sort(list.subList(mid + 1, list.size()));

        return n;
    }
}
