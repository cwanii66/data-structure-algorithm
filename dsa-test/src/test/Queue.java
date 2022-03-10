package test;

import java.util.Iterator;
import java.util.Scanner;

public class Queue<Item> implements Iterable<Item>{
       private Node first; // point at the initial link
       private Node last; // point at the new link
       private int N; // the number of queue's element
       private class Node {
              Item item;
              Node next;
       }
       public boolean isEmpty() { return first == null; } // N == 0 is ok
       public int size() { return N; }
       public void enqueue(Item item) {
              // add element at the end of list
              Node oldlast = last;
              last = new Node();
              last.item = item;
              last.next = null;
              if (isEmpty()) first = last;
              else                 oldlast.next = last;
              N++;
       }
       public Item dequeue() {
              // delete element from head
              Item item = first.item;
              first = first.next;
              if (isEmpty()) last = null;
              N--;
              return item;
       }
       // iterator() algorithm to be resolved

       public static void main(String[] args) {
              Scanner scan = new Scanner(System.in);
              Queue<String> q = new Queue<String>();
              while(!scan.hasNext()) {
                     String item = scan.nextLine();
                     if (!item.equals("-"))
                            q.enqueue(item);
                     else if (!q.isEmpty())
                            System.out.print(q.dequeue() + " ");
              }
              System.out.println("(" + q.size() + " left on queue)");
       }

       @Override
       public Iterator<Item> iterator() {
              return null;
       }
}
