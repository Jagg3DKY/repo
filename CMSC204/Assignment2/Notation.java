/*
 * Class: CMSC204 CRN31695
 * Instructor: Sandro Fouche
 * Description: Notion class that uses an arrayqueue and an arraystack to convert infix and postfix operations to each other, and compute postfix operations.
 * Due: 2/27/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Kyran Heijkoop
*/

public class Notation {
	
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		
		MyQueue<Character> queue = new MyQueue<>();
		MyStack<Character> stack = new MyStack<>();
		int len = infix.length();
		
		try {
			
			for (int i = 0; i < len; i++) {
				
				char c = infix.charAt(i);
				
				if (c == ' ') {
					continue;
				}
				
				if (Character.isDigit(c)){
					queue.enqueue(c);
				}
				
				if (c == '(') {
					stack.push(c);
				}
				
				if (c == '-' || c == '+') {
					while (!stack.isEmpty() && (stack.top() == '*' || stack.top() == '/' || stack.top() == '-' || stack.top() == '+')) {
						queue.enqueue(stack.pop());
					}
					stack.push(c);
				}
				
				if (c == '*' || c == '/') {
					while (!stack.isEmpty() && (stack.top() == '*' || stack.top() == '/')) {
						queue.enqueue(stack.pop());
					}
					stack.push(c);
				}
				
				if (c == ')') {
					while (!stack.isEmpty() && stack.top() != '(') {
						queue.enqueue(stack.pop());
					}
					
					if (stack.isEmpty()) {
						throw new InvalidNotationFormatException("Invalid Infix Entry");
					}
					stack.pop();
				}
			}
			
			while (!stack.isEmpty()) {
				queue.enqueue(stack.pop());
			}
			
		}
		
		
		catch (QueueOverflowException e) {
		}
		
		catch (StackOverflowException e) {
		} 
		
		catch (StackUnderflowException e) {
		}
		
		return queue.toString();
	}
	
	
	public static String convertPostfixToInfix​(String postfix) throws InvalidNotationFormatException {
		
		MyStack<String> stack = new MyStack<>();
		int len = postfix.length();
		
		try {
			
			for (int i = 0; i < len; i++) {
				
				char c = postfix.charAt(i);
				
				if (c == ' ') {
					continue;
				}
				
				if (Character.isDigit(c)){
					stack.push(Character.toString(c));
				}

				
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException("Invalid Postfix Entry");
					}
					
					String second = stack.pop();
					String first = stack.pop();
					String s = "(" + first + c + second + ")";
					stack.push(s);
				}
			}
			
			if (stack.size() > 1) {
				throw new InvalidNotationFormatException("Invalid Postfix Entry");
			}
			
			return stack.pop();
			
		}
		
		catch (StackOverflowException e) {
		} 
		
		catch (StackUnderflowException e) {
		}
		
		return null;
	}
	
	
	public static double evaluatePostfixExpression​(String postfixExpr) throws InvalidNotationFormatException{
		
		MyStack<String> stack = new MyStack<>();
		int len = postfixExpr.length();
		
		try {
			
			for (int i = 0; i < len; i++) {
				
				char c = postfixExpr.charAt(i);
				
				if (c == ' ') {
					continue;
				}
				
				if (Character.isDigit(c) || c == '('){
					stack.push(Character.toString(c));
				}

				
				if (c == '-' || c == '+' || c == '*' || c == '/') {
					
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException("Invalid Postfix Entry");
					}
					
					double second = Double.parseDouble(stack.pop());
					double first = Double.parseDouble(stack.pop());
					double total = 0;
					
					switch (c) {
						case '-': total = first - second;
							break;
							
						case '+': total = first + second;
							break;
							
						case '*': total = first * second;
							break;
							
						case '/': total = first / second;
							break;
					}
					
					stack.push(Double.toString(total));
				}
			}
			
			if (stack.size() > 1) {
				throw new InvalidNotationFormatException("Invalid Postfix Entry");
			}
			
			return Double.parseDouble(stack.pop());
			
		}
		
		catch (StackOverflowException e) {
		} 
		
		catch (StackUnderflowException e) {
		}
		
		
		return 0;
	}
	
}
