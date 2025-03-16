/*
 * Class: CMSC204 CRN31695
 * Instructor: Sandro Fouche
 * Description: BasicDoubleLinkedList class, a generic LinkedList that can travel forwards and backwards. 
 * Includes inner class definitions for Node and DoubleListIterator. DoubleListIterator is a ListIterator used to traverse the LinkedList
 * Due: 3/15/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Kyran Heijkoop
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;




public class BasicDoubleLinkedList<T> implements Iterable<T>{
	
	protected Node<T> head;
	protected Node<T> tail;
	protected int size;
	
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	
	public T getFirst() {
		return this.head.data;
	}
	
	
	public T getLast() {
		return this.tail.data;
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	
	public void addToFront(T data) {
		Node<T> newNode = new Node(data);
		if (head == null) {
			this.head = newNode;
			this.tail = newNode;
			
		}
		
		else {
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}
		size++;
	}
	
	
	public void addToEnd(T data) {
		Node<T> newNode = new Node(data);
		if (tail == null) {
			this.head = newNode;
			this.tail = newNode;
			
		}
		
		else {
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		size++;
	}
	
	
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator(head, size);
	}
	
	
	public T retrieveFirstElement() {
		
		if (head != null) {
			T data = getFirst();
			this.head = head.next;
			this.head.prev = null;
			return data;
		}
		
		return null;
	}
	
	
	public T retrieveLastElement() {
		
		if (tail != null) {
			T data = getLast();
			this.tail = tail.prev;
			this.tail.next = null;
			return data;
		}
		
		return null;
	}

	
	public Node<T> remove(T targetData, Comparator<T> comparator) {

		if (size == 0) {
			return null;
		}
		
		Node<T> current = this.head;
		
		while(current != null) {
			if(comparator.compare(current.data, targetData) == 0) {
				
				if (size == 1) {
					head = null;
					tail = null;
				} 
				
				else if (current == head) {
					head.next.prev = null;
					head = head.next;
				}
				
				else if (current == tail) {
					tail.prev.next = null;
					tail = tail.prev;
				}
				
				else {
					current.next.prev = current.prev;
					current.prev.next = current.next;
				}
				size--;
				return current;
			}
			
			current = current.next;
		}
		
		return null;
	}
	
	
	public ArrayList<T> toArrayList() {
		
		Node<T> current = head;
		ArrayList<T> arrayList = new ArrayList<>();
		
		while(current != null) {
			arrayList.add(current.data);
			current = current.next;
		}
		
		return arrayList;
	}
	
	
	public class Node<T>{
		
		protected T data;
		protected Node<T> prev;
		protected Node<T> next;
		
		public Node(T dataNode) {
			this.prev = null;
			this.next = null;
			this.data = dataNode;
		}
	}
	
	
	public class DoubleLinkedListIterator<T> implements ListIterator<T> {
		
		private Node<T> current;
		private int cursor, size;
		
		public DoubleLinkedListIterator(Node<T> head, int size) {
			this.current = head;
			this.cursor = 0;
			this.size = size;
		}
		
		
		@Override
		public T next() throws NoSuchElementException {
			if (hasNext()) {
				T data = current.data;
				if(current.next != null)
					current = current.next;
				cursor++;
				return data;
			}
			
			throw new NoSuchElementException();
		}
		

		@Override
		public T previous() throws NoSuchElementException {
			if (hasPrevious()) {
				if (cursor != size) {
					current = current.prev;
				}
				cursor--;
				return current.data;
			}
			
			throw new NoSuchElementException();
		}
		
		
		@Override
		public boolean hasNext() {
			return cursor < size;
		}
		
		
		@Override
		public boolean hasPrevious() {
			return cursor > 0;
		}


		@Override
		public void add(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		
		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		
		@Override
		public void set(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
		
		@Override
		public int nextIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		
		@Override
		public int previousIndex() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
	}
	
}
