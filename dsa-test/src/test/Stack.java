package test;

public class Stack<Item> implements Iterable{
       private Node first;
       private int N;
       private class Node {
              // define Node
              Item item;
              Node next;
       }
       public boolean isEmpty() {
              return first == null;
       }
       public int size() { return N; }
       public void push(Item item) {
              Node oldfirst = first;
              first = new Node();
              first.item = item;
              first.next = oldfirst;
              N++;
       }
       public Item pop() {
              Item item = first.item;
              first = first.next;
              N--;
              return item;
       }

       public static void main(String[] args) {
              // create a stack, then push or pop strings according to StdIn
              Stack<String> s = new Stack<String>();

       }
       @Override


}
