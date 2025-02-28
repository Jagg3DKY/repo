/*
 * Class: CMSC204 CRN31695
 * Instructor: Sandro Fouche
 * Description: MyQueue class, a generic arrayqueue
 * Due: 2/27/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Kyran Heijkoop
*/

import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T>{
	
	private ArrayList<T> queue;
	private int size;
	
	
	public MyQueue(int size) {
		this.size = size;
		this.queue = new ArrayList<T>(size);
	}
	
	public MyQueue() {
		this.size = 100;
		this.queue = new ArrayList<T>(size);
	}
	
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size() == size;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (this.isEmpty()){
			throw new QueueUnderflowException("Queue is empty");
		}
		T temp = queue.getFirst();
		queue.removeFirst();
		return temp;
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean enqueue(T enque) throws QueueOverflowException {
		
		if (this.isFull()){
			throw new QueueOverflowException("Queue is full");
		}
		queue.add(enque);
		return true;
	}

	@Override
	public String toString() {
		
		String s = "";
		if (this.isEmpty()) {
			return s;
		}
		
		for (T t : queue) {
			s += t;
		}
		
		return s;
	}
	
	@Override
	public String toString(String delimiter) {
		
		String s = "";
		if (this.isEmpty()) {
			return s;
		}
		
		s += queue.getFirst();
		
		if (this.size() == 1) {
			return s;
		}
		
		for (int i = 1; i < this.size(); i++) {
			s += delimiter + queue.get(i);
		}
		
		return s;
		
	}

	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		
		ArrayList<T> copy = new ArrayList<>(list);
		for (T items : copy) {
			if(this.isFull()) {
				throw new QueueOverflowException("Queue is full");
			}
			enqueue(items);
		}
	}

}
