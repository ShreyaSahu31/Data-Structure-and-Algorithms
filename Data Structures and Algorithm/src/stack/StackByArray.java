package stack;

public class StackByArray {
	
	protected int[] arr;
	protected int topOfStack;
	
	public StackByArray(int size) {
		arr = new int[size];
		topOfStack = -1;
		System.out.println("Successfully created stack of size :" + size);
	}
	
	//if top pointer is -1 , the stack is empty
	public boolean isEmptyStack() {
		if(topOfStack == -1) {
			System.out.println("Stack is underflow");
			return true;
		}
		else
			return false;
	}
	
	//if top pointer is equal to size - 1, stack is full
	public boolean isFullStack() {
		if(topOfStack == arr.length - 1) {
			System.out.println("Stack is overflow");
			return true;
		}
		else
			return false;
	}
	
	//pushing an element in stack
	public void push(int value) {
		if(isFullStack()) {
			return;
		}
		else {
			arr[topOfStack + 1] = value;
			topOfStack++;
		}
	}
	
	//popping an element from stack
	public void pop() {
		if(isEmptyStack()) {
			return;
		}
		else {
			System.out.println("Poppin an element , value: "+ arr[topOfStack]);
			topOfStack--;
		}
	}
	
	//peeking inside the stack
	public void peekOperation() {
		if(isEmptyStack()) {
			return;
		}
		else {
			System.out.println("Element at the top of the stack is :" +arr[topOfStack]);
		}
	}
	
	//deleting stack
	public void deleteStack() {
		
		arr = null;
		System.out.println("Successfully deleted the array....");
		
	}
	

}
