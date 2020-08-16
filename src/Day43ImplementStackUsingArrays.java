
public class Day43ImplementStackUsingArrays {
	
	int size;
	int arr[];
	int top;
	
	public Day43ImplementStackUsingArrays(int size) {
		this.size = size;
		this.arr = new int[size];
		this.top = -1;
	}
	
	public boolean isFull() {
		return (size - 1 == top);
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public int peek() {
		return arr[top];
	}
	
	public void push(int num) {
		
		if(!isFull()) {
			arr[++top] = num;
			System.out.println("Element pushed: " + num);
		}
		else {
			System.out.println("Cannot push the element because the stack is full");
		}
	}
	
	public int pop() {
		
		if(!isEmpty()) {
			int val = arr[top];
			top--;
			System.out.println("The popped element is: " + val);
			return val;
		}
		else {
			System.out.println("Cannot pop the element because the stack is empty");
			return -1;
		}
	}

	public static void main(String[] args) {
		
		Day43ImplementStackUsingArrays stack = new Day43ImplementStackUsingArrays(3);
		
		stack.push(4);
		stack.push(3);
		stack.push(13);
		System.out.println("Is stack full? " + stack.isFull());
		stack.push(11);
		
		stack.pop();
		stack.pop();
		System.out.println("Peeked element is: " + stack.peek());
		System.out.println("Is stack empty? " + stack.isEmpty());
		stack.pop();
		System.out.println("Is stack empty? " + stack.isEmpty());

	}

}
