package linkedList;

import node.DoubleNode;

public class DoubleLinkedList {

	protected DoubleNode head;
	protected DoubleNode tail;
	protected int size;
	public DoubleNode getHead() {
		return head;
	}
	public void setHead(DoubleNode head) {
		this.head = head;
	}
	public DoubleNode getTail() {
		return tail;
	}
	public void setTail(DoubleNode tail) {
		this.tail = tail;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean existLinkedList() {
		return head != null;
	}
	
	// create linked list
	public DoubleNode createDoubleLinkedList(int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.setData(nodeValue);
		node.setNext(null);
		node.setPrev(null);
		setHead(node);
		setTail(node);
		setSize(1);
		return head;
	}
	
	//traverse LInkedList head to tail
	public void traverseLinkedList() {
		if(existLinkedList()) {
			DoubleNode tmpNode = new DoubleNode();
			tmpNode = head;
			for(int i = 0 ; i < getSize(); i++) {
				System.out.print(tmpNode.getData());
				if(i!=size-1) {
					System.out.print(" -> ");
				}
				tmpNode = tmpNode.getNext();
			}
			System.out.println("\n");
		}
		else {
			System.out.println("Linked list not exist !!");
		}
		
	}
	
	//traverse linked list tail to head
	public void traverseLinkedListInReverseOrder() {
		if(existLinkedList()) {
			DoubleNode tmpNode = new DoubleNode();
			tmpNode = tail;
			for(int i = 0 ; i < getSize(); i++) {
				System.out.print(tmpNode.getData());
				if(i!=size-1) {
					System.out.print(" <- ");
				}
				tmpNode = tmpNode.getPrev();
			}
			System.out.println("\n");
		}
		else {
			System.out.println("Linked list not exist !!");
		}
		
	}
	
	//insert in linked list
	public void insertInLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setData(nodeValue);
		if(! existLinkedList()) {
			System.out.println("Linked List not exist !!");
			return;
		}
		else if(location < 0 || location > getSize()) {
			System.out.println("Invalid location");
			return;
		}
		
		else if (location == 0) {
			node.setPrev(null);
			node.setNext(getHead());
			head.setPrev(node);
			setHead(node);
		}
		
		else if (location == getSize()) {
			node.setPrev(getTail());
			node.setNext(null);
			tail.setNext(node);
			setTail(node);
		}
		else {
			DoubleNode tmpNode = new DoubleNode();
			tmpNode = head;
			for(int i = 0; i < location - 1; i++) {
				tmpNode = tmpNode.getNext();
			}
			node.setNext(tmpNode.getNext());
			node.setPrev(tmpNode);
			tmpNode.getNext().setPrev(node);
			tmpNode.setNext(node);
		}
		
		setSize(getSize() + 1);
	}
	
	//Searching a node in Linked list
	public boolean searchNode(int nodeValue) {
		if(existLinkedList()) {
			DoubleNode tmpNode = head;
			for (int i = 0 ; i < getSize() ; i++) {
				if(tmpNode.getData() == nodeValue) {
					System.out.println("Value found at locatio : " + i);
					return true;
				}
				tmpNode = tmpNode.getNext();
			}
		}
		else {
			System.out.println("Linked List do not Exist !!");
			return false;
		}
		System.out.println("Value not found !!");
		return false;
	}
	
	// deleting the node in linked list
	public void deletionOfNode(int location) {
		if(! existLinkedList()) {
			System.out.println("Linked List not exist !!");
			return;
		}
		else if(location < 0 || location >= getSize()) {
			System.out.println("Invalid location");
			return;
		}
		else if (location == 0) {
			setHead(head.getNext());
			head.setPrev(null);
		}
		else if(location == getSize() - 1) {
			DoubleNode tmpNode = tail.getPrev();
				
			tmpNode.setNext(null);
			setTail(tmpNode);
		}
		else {
			DoubleNode tmpNode = head;
			for(int i = 0 ; i < location - 1; i++) {
				tmpNode = tmpNode.getNext();
			}
			tmpNode.getNext().getNext().setPrev(tmpNode);
			tmpNode.setNext(tmpNode.getNext().getNext());
		}
		
		setSize(getSize()- 1);
		if(getSize() == 0) {
			setHead(null);
			setTail(null);
		}
		
	}
	
	// delete entire array
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		DoubleNode tmpNode = head;
		for(int i = 0 ; i < getSize() - 1; i++) {
			tmpNode.setPrev(null);
			tmpNode = tmpNode.getNext();
		}
		setHead(null);
		setTail(null);
	}
	
	
	
	
	
	
	
	
	
}
