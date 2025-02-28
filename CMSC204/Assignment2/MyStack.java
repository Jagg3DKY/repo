/*
 * Class: CMSC204 CRN31695
 * Instructor: Sandro Fouche
 * Description: MyStack class, a generic arrayStack
 * Due: 2/27/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Kyran Heijkoop
*/

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{

	private ArrayList<T> stack;
	private int size;
	
	public MyStack(int size){
		this.size = size;
		this.stack = new ArrayList<T>(size);
	}
	
	public MyStack(){
		this.size = 100;
		this.stack = new ArrayList<T>(size);
	}
	
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size() == size;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()){
			throw new StackUnderflowException("Stack is Empty");
		}
		
		T temp = stack.getLast();
		stack.removeLast();
		return temp;
		
	}

	@Override
	public T top() throws StackUnderflowException {
		return stack.getLast();
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException("Stack is full");
		}
		
		stack.add(e);
		return true;
	}

	@Override
	public String toString() {
		
		String s = "";
		if (this.isEmpty()) {
			return s;
		}
		
		for (T e : stack) {
			s += e;
		}
		
		return s;
	}
	
	@Override
	public String toString(String delimiter) {
		
		String s = "";
		if (this.isEmpty()) {
			return s;
		}
		
		s += stack.getFirst();
		
		if (this.size() == 1) {
			return s;
		}
		
		for (int i = 1; i < this.size(); i++) {
			s += delimiter + stack.get(i);
		}
		
		return s;
		
	}

	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException {
		
		ArrayList<T> copy = new ArrayList<>(list);
		for (T items : copy) {
			if(this.isFull()) {
				throw new StackOverflowException("Stack is full");
			}
			push(items);
		}
	}

}
