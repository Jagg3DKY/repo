/*
 * Class: CMSC204 CRN31695
 * Instructor: Sandro Fouche
 * Description: SortedDoubleLinkedList class, a generic SortedLinkedList that can travel forwards and backwards. 
 * Extends BasicDoubleLinkedList and uses a Comparator to sort the list when adding elements to itself. 
 * Due: 3/15/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Kyran Heijkoop
*/

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> implements Iterable<T>{
	
	private Comparator<T> comparator;
	
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	

	public void add(T data) {
		
		Node<T> newNode = new Node<>(data);
		Node<T> current = head;
		
		if (head == null) {
			head = newNode;
			tail = newNode;
			size++;
		}
		
		while (current != null) {
			
			int comparison = comparator.compare(newNode.data, current.data);
			if (comparison < 0) {
				
				if (current == head) {
					head.prev = newNode;
					newNode.next = head;
					head = newNode;
				}
				
				else {
					newNode.prev = current.prev;
					newNode.next = current;
					current.prev.next = newNode;
					current.prev = newNode;
				}
				
				size++;
				return;
			}
			
			if (current.next == null) {
				current.next = newNode;
				newNode.prev = current;
				tail = newNode;
				size++;
				return;
			}
			
			current = current.next;
		}
	}
	
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	@Override
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	
	public Node<T> remove​(T data, Comparator<T> comparator){

		if (size == 0) {
			return null;
		}
		
		Node<T> current = this.head;
		
		while(current != null) {
			if(comparator.compare(current.data, data) == 0) {
				
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

				return current;
			}
			
			current = current.next;
		}
		
		return null;
	}
}
