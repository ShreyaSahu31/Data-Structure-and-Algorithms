package stack;

import linkedList.SingleLinkedList;

public class StackByLinkedList {

	protected SingleLinkedList list;
	
	public StackByLinkedList() {
		list = new SingleLinkedList();
	}
	
	//check if the stack is empty
	public boolean isEmpty() {
		if(list.getHead() == null)
			return true;
		else 
			return false;
	}
	
	//pushing element in the stack
	public void push(int value) {
		if(isEmpty()) {
			list.createSingleLinkedList(value);
		}
		else {
			list.insertInLinkedList(value, 0);
		}
		System.out.println("SuccessFully inserted the value :" + value);
	}
	
	//popping element from stack
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack underflow !!");
			return -1;
		}
		else {
			int value = list.getHead().getData();
			System.out.println("The value  :" + list.getHead().getData() + "Successfully removed");
			list.deletionOfNode(0);
			return value;
					
		}
	}
	
	//peeking inside the stack
	public int peek() {
		int value = -1;
		if(isEmpty()) {
			System.out.println("Stack underflow !!");
			return value;
		}
		else {
			System.out.println("The value at top of the stack is :" + list.getHead().getData());
			value = list.getHead().getData();
			return value;
		}
	}
	
	//deleting the stack
	public void delete() {
		list.deleteLinkedList();
		System.out.println("Stack successfully deleted");
	}
	
}
