package lab1;


public class lab1
{
    public static void main(String[] args)
    {
        SortedLinkedList ll = new SortedLinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(0);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        ll.add(3);

        System.out.println(ll.get());
        System.out.println(ll.get(3));

        ll.displayAll();

        ll.remove(5);
        ll.displayAll();

        ll.addTail(10);
        ll.displayAll();

        ll.remove(10);
        ll.displayAll();

        ll.remove(Integer.valueOf(10));
        ll.displayAll();

        ll.reverse();
        ll.displayAll();

        SortedLinkedList l1 = new SortedLinkedList();
        l1.add(9);
        l1.add(8);
        l1.add(7);
        l1.add(6);
        l1.add(4);
        l1.add(3);
        l1.add(3);
        l1.add(2);
        l1.add(1);
        l1.add(0);
        l1.add(3);

        l1.reverse();
        System.out.println(ll.equal(l1));
        ll.displayAll();
        l1.displayAll();


        ll.displayAll();
        System.out.println(ll.listSize());
        System.out.println(ll.take(3));
        ll.displayAll();

        System.out.println(ll.isEmpty());
        System.out.println(new SortedLinkedList().isEmpty());

        System.out.println(ll.listSize());

        System.out.println(ll.find(Integer.valueOf(10)));
        System.out.println(ll.find(Integer.valueOf(3)));
        System.out.println(ll.find(Integer.valueOf(12389)));

        ll.displayAll();
        ll.remove(Integer.valueOf(3));
        ll.displayAll();




        SortedLinkedList l2 = new SortedLinkedList();

        l2.add(1);
        l2.add(2);
        l2.add(2);
        l2.add(2);
        l2.add(3);
        l2.add(3);l2.add(3);l2.add(3);l2.add(3);l2.add(3);l2.add(3);l2.add(3);l2.add(3);

        l2.displayAll();
        l2.removeDuplicate();
        l2.displayAll();

        SortedLinkedList ls = new SortedLinkedList();
        ls.add("Hello");
        ls.add("world");
        ls.add("!");
        ls.add("world");
        ls.add("Hello");ls.add("Hello");


        ls.displayAll();
        ls.removeDuplicate();
        ls.displayAll();

    }
}
