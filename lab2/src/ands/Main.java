package ands;


import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        //15, 12, 17, 11, 13, 17, 16
        bst.add(11);
        bst.add(10);
        bst.add(9);
        bst.add(3);
        bst.add(1);
        bst.add(5);
        bst.add(7);
        bst.add(17);
        bst.add(15);
        bst.add(19);
        bst.add(18);
        bst.printInorder();

        System.out.println("bst.inorder() = " + bst.inorder());


        BalancedBinarySearchTree<Integer> bbst = new BalancedBinarySearchTree<>();
        //15, 12, 17, 11, 13, 17, 16
        List<Integer> l = new ArrayList<>();
        l.add(11);
        l.add(10);
        l.add(9);
        l.add(3);
        l.add(1);
        l.add(5);
        l.add(7);
        l.add(17);
        l.add(15);
        l.add(19);
        l.add(18);
        bbst.add(11);
        bbst.add(10);
        bbst.add(9);
        bbst.add(3);
        bbst.add(1);
        bbst.add(5);
        bbst.add(7);
        bbst.add(17);
        bbst.add(15);
        bbst.add(19);
        bbst.add(18);

        //BalancedBinarySearchTree<Integer> bbst1 = new BalancedBinarySearchTree(l);


        System.out.println("bbst.inorder() = " + bbst.inorder());
        bbst.printInorder();
        System.out.println("bbst.preorder() = " + bbst.preorder());
        bbst.printPreorder();
        System.out.println("bbst.postorder() = " + bbst.postorder());
        bbst.printPostorder();

        System.out.println("bbst.getHeight() = " + bbst.getHeight());

        System.out.println("bbst.contains(11) = " + bbst.contains(11));
        System.out.println("bbst.contains(20) = " + bbst.contains(20));

        System.out.println("bbst.fatherNode(11) = " + bbst.fatherNode(11));
        System.out.println("bbst.commonAncestor(3, 11) = " + bbst.commonAncestor(3, 11));
        System.out.println("bbst.copy().inorder() = " + bbst.copy().inorder());
        System.out.println("bbst.copy().inorder() = " + bbst.copy().preorder());
        System.out.println("bbst.equals(bbst.copy()) = " + bbst.equals(bbst.copy()));
        System.out.println("bbst.symmetricalTree().inorder() = " + bbst.symmetricalTree().inorder());
        System.out.println("bbst.isBalanced() = " + bbst.isBalanced());
        bbst.delete(17);
        System.out.println("bbst.inorder() = " + bbst.inorder());
        System.out.println("bbst.preorder() = " + bbst.preorder());
        System.out.println("bbst.postorder() = " + bbst.postorder());
    }
}
