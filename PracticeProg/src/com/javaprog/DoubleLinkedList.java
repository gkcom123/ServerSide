package com.javaprog;

import java.util.NoSuchElementException;

public class DoubleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList l = new DoublyLinkedList();
		l.insertFirst(2);
		l.insertFirst(3);
		l.insertFirst(4);
		l.insertFirst(5);
		l.insertFirst(6);
		System.out.println(l);
		l.reverseList(l);
		System.out.println(l);
		

	}

}

class DoubleLink {
	  public int iData;
	  public DoubleLink next;
	  public DoubleLink previous;

	  public DoubleLink(int id) {
	    iData = id;
	  }

	  public String toString() {
	    return "{" + iData + "} ";
	  }
	}

	class DoublyLinkedList {
	  private DoubleLink first;
	  private DoubleLink last;
	  private transient int size = 0;

	  public DoublyLinkedList() {
	    first = null;
	    last = null;
	  }

	  public boolean isEmpty() {
	    return first == null;
	  }

	  public void insertFirst(int dd) {
		  DoubleLink newLink = new DoubleLink(dd);
	    if (isEmpty()){
	      last = newLink;
	    }else{
	      first.previous = newLink;//last double link object and first double link object are same.
	    }
	    newLink.next = first;
	    first = newLink;
	    size++;
	  }
	    public int size() {
	    	return size;
	        }
	  public void insertLast(int dd) {
	    DoubleLink newLink = new DoubleLink(dd);
	    if (isEmpty()){
	      first = newLink;
	    }else {
	      last.next = newLink;
	      newLink.previous = last;
	    }
	    last = newLink;
	    size++;
	  }

	  public DoubleLink deleteFirst() {
	    DoubleLink temp = first;
	    if (first.next == null){
	      last = null;
	    }else{
	      first.next.previous = null;
	    }
	    first = first.next;
	    return temp;
	  }

	  public DoubleLink deleteLast() {
	    DoubleLink temp = last;
	    if (first.next == null){
	      first = null;
	    }else{
	      last.previous.next = null;
	    }
	    last = last.previous;
	    return temp;
	  }

	  public boolean insertAfter(int key, int dd) {
	    DoubleLink current = first;
	    while (current.iData != key) {
	      current = current.next;
	      if (current == null){
	        return false;
	      }
	    }
	    DoubleLink newLink = new DoubleLink(dd);

	    if (current == last) {
	      newLink.next = null;
	      last = newLink;
	    } else {
	      newLink.next = current.next;
	      current.next.previous = newLink;
	    }
	    newLink.previous = current;
	    current.next = newLink;
	    return true;
	  }

	  public DoubleLink deleteKey(int key) {
	    DoubleLink current = first;
	    while (current.iData != key) {
	      current = current.next;
	      if (current == null)
	        return null;
	    }
	    if (current == first){
	      first = current.next;
	    }else{
	      current.previous.next = current.next;
	    }
	    
	    if (current == last){
	      last = current.previous;
	    }else{
	      current.next.previous = current.previous;
	    }
	    return current;
	  }
	    public DoubleLink getFirst() {
	    	if (size==0)
	    	    throw new NoSuchElementException();

	    	return first;
	        }
	    public void reverseList(DoublyLinkedList l)
	    {
	    	DoubleLink start = l.first;
	    	DoubleLink temp = null;
	    	while(start !=null)
	    	{
	    		temp = start.next;
	    		start.next = start.previous;
	    		start.previous = temp;
	    		if(start.previous ==null)
	    		{
	    			l.first = start;
	    		}
	    		start = start.previous;
	    	}
	    }
	  public String toString() {
	    String str = "List (first-->last): ";
	    DoubleLink current = first;
	    while (current != null) {
	      str += current.toString();
	      current = current.next;
	    }
	    System.out.println("");
/*	    System.out.print("List (last-->first): ");

	    current = last;
	    while (current != null) {
	      str += current.toString();
	      current = current.previous;
	    }
*/	    return str;
	  }
	}
