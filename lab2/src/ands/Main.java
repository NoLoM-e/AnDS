package ands;

import ands.BinarySearchTree;


public class Main
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        //15, 12, 17, 11, 13, 17, 16
        bst.add(15);
        bst.add(12);
        bst.add(17);
        bst.add(11);
        bst.add(13);
        bst.add(17);
        bst.add(16);
        bst.printInorder();
    }
}
