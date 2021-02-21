package lab1;


public class SortedLinkedList {
    private Value head;
    private Value tail;

    private static class Value {
        public Value next;
        public Object value;

        public Value(Integer integer) {
            this.value = integer;
        }

        public Value(String str) {
            this.value = str;
        }
    }

    public void add(Integer integer) {
        if (integer == null) {
            System.out.println("Null is not an argument");
            return;
        }
        Value elem = new Value(integer);

        if (head == null) {
            head = elem;
            tail = elem;
        } else {
            if ((int) elem.value < (int) head.value) {
                elem.next = head;
                head = elem;
                return;
            }

            Value v = head;
            Value temp = v.next;

            while ((int) elem.value > (int) v.value) {
                v = v.next;
                if (v == null) {
                    break;
                }
                temp = v.next;
            }
            if (v == null) {
                tail.next = elem;
                tail = elem;
                return;
            }
            v.next = elem;
            elem.next = temp;
        }
    }

    public void add(String str) {
        if (str == null) {
            System.out.println("Null is not an argument");
            return;
        }
        Value elem = new Value(str);

        if (head == null) {
            head = elem;
            tail = elem;
        } else {

            if (this.compareTo(elem, head) < 0) {
                elem.next = head;
                head = elem;
                return;
            }

            Value v = head;
            Value temp = v.next;

            while (this.compareTo(elem, v) > 0) {
                v = v.next;
                if (v == null) {
                    break;
                }
                temp = v.next;
            }
            if (v == null) {
                tail.next = elem;
                tail = elem;
                return;
            }
            v.next = elem;
            elem.next = temp;
        }
    }


    public void addTail(Integer integer) {
        if (integer == null) {
            System.out.println("Null is not an argument");
            return;
        }
        Value elem = new Value(integer);

        if (tail == null) {
            head = elem;
            tail = elem;
        } else {
            tail.next = elem;
            tail = elem;
        }
    }

    public void addHead(Integer integer) {
        if (integer == null) {
            System.out.println("Null is not an argument");
            return;
        }
        Value elem = new Value(integer);

        if (head == null) {
            head = elem;
            tail = elem;
        } else {
            elem.next = head;
            head = elem;
        }
    }

    public void remove(int pos) {
        if (pos == 0) {
            this.removeHead();
            return;
        }

        Value v = head, prev = head;

        for (int i = 0; i < pos; i++) {
            if (v == null) {
                System.out.println("Incorrect index");
                return;
            }

            prev = v;
            v = v.next;
        }

        if (v.next == null) {
            this.removeTail(prev);
            return;
        }

        prev.next = v.next;
    }

    public void remove(Integer integer) {
        Value elem = new Value(integer);
        Value v = head;
        boolean deleted = false;

        if (elem.value.equals(head.value)) {
            this.removeHead();
            return;
        }

        int i = 0;
        while (v.next != null) {
            if (elem.value.equals(v.next.value)) {
                this.remove(i + 1);
                deleted = true;
                continue;
            }
            v = v.next;
            i++;
        }

        if (!deleted) {
            System.out.println("Object not found");
        }
    }

    private void removeHead() {
        head = head.next;
    }

    private void removeTail(Value v) {
        v.next = null;
        tail = v;
    }


    public Object get() {
        return head.value;
    }

    public Object get(int pos) {
        Value v = head;

        for (int i = 0; i < pos; i++) {
            if (v == null) {
                System.out.println("Incorrect index");
                return 0;
            }
            v = v.next;
        }
        return v.value;
    }

    public Object take(int pos) {
        Value v = this.head;

        for (int i = 0; i < pos; i++) {
            if (v != null) {
                v = v.next;
            } else {
                System.out.println("Incorrect position");
                return -1;
            }
        }

        this.remove(pos);

        return v.value;
    }

    public int find(Integer integer) {
        Value v = this.head;
        int i = 0;

        while (v != null) {
            if (v.value.equals(integer)) {
                return i;
            }
            v = v.next;
            i++;
        }

        return -1;
    }

    public void displayAll() {
        Value v = head;
        while (v != null) {
            System.out.print(v.value + " ");
            v = v.next;
        }
        System.out.println();
    }


    public boolean isEmpty() {
        return this.head == null;
    }

    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    public int listSize() {
        Value v = this.head;
        int i = 0;

        while (v != null) {
            v = v.next;
            i++;
        }

        return i;
    }

    private int compareTo(Value v1, Value v2) {
        String str1 = String.valueOf(v1.value);
        String str2 = String.valueOf(v2.value);

        return str1.compareTo(str2);
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




/*
    15.	Write a method which removes duplicate items in a sorted linked list.
    For ex., original List: (1 2 2 3 3 3 3 3 3); result List: (1 2 3).
*/

    public void removeDuplicate()
    {
        Value v = this.head;
        int i = 0;

        while (v.next != null)
        {
            if (v.next.value.equals(v.value))
            {
                this.remove(i + 1);
                continue;
            }

            v = v.next;
            i++;
        }
    }
}



