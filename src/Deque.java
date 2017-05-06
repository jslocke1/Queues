

/**
 * Created by jslocke on 5/1/17.
 */


import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item>
{
    private int n;
    private Node first;
    private Node last;


    private class Node
    {
        private Item item;
        private Node next;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public Deque()
    {
        n = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size()
    {
        return n;
    }

    public void addFirst(Item item)
    {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            if (isEmpty())
                last = first;
            n++;
    }

    public void addLast(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        n++;
    }

    public Item removeFirst()
    {
        if (isEmpty())
            throw new NoSuchElementException("There are no elements to remove");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item removeLast()
    {
        if (isEmpty())
            throw new NoSuchElementException("There are no elements to remove");
        Item item = last.item;
        Node curr = first;
        for (int i=0;i<n-1;i++)
            curr = curr.next;
        last = curr;
        n--;
        return item;
    }


    public static void main(String args[])
    {
        Deque<Integer> d1 = new Deque<>();
        d1.addFirst(1);
        d1.addLast(2);
        d1.addFirst(3);
        d1.removeFirst();
        d1.addFirst(4);
        d1.addLast(5);
        d1.removeLast();
        for (Integer i:d1)
            System.out.println(i);
    }
}
