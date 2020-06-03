package linkedList;

import node.DoubleNode;

public class DoubleCircularLinkedList {

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
	
	//create Linked List
	public DoubleNode createDoubleLinkedList(int nodeValue) {
		DoubleNode node = new DoubleNode();
		node.setData(nodeValue);
		node.setNext(node);
		node.setPrev(node);
		head = node;
		tail = node;
		setSize(1);
		return head;
	}
	
	//traverse Linked List head to tail
	public void traverseLinkedList() {
		if(existLinkedList()) {
			DoubleNode tmpNode = new DoubleNode();
			tmpNode = head;
			for(int i = 0; i< getSize(); i++) {
				System.out.print(tmpNode.getData());
				if(i != getSize() - 1) {
					System.out.print(" -> ");
				}
				tmpNode = tmpNode.getNext();
			}
			System.out.println("\n");
		}
		else{
			System.out.println("Linked List do not exist !!");
		}
	}
	
	//traverse Linked List tail to head
	public void traverseLinkedListInReverseOrder() {
		if(existLinkedList()) {
			DoubleNode tmpNode = new DoubleNode();
			tmpNode = tail;
			for(int i = 0; i< getSize(); i++) {
				System.out.print(tmpNode.getData());
				if(i != getSize() - 1) {
					System.out.print(" <- ");
				}
				tmpNode = tmpNode.getPrev();
			}
			System.out.println("\n");
		}
		else{
			System.out.println("Linked List do not exist !!");
		}
	}
	
	// Traverse Linked List
		void printHeadUsingTail() {
			if (existLinkedList()) {
				System.out.println("\n\nPrinting Tail...");
				System.out.println(tail.getData());

				System.out.println("\nPrinting Head using Head reference...");
				System.out.println(head.getData());

				System.out.println("\nPrinting Head using Tail reference...");
				System.out.println(tail.getNext().getData());

			} else {
				System.out.println("Linked List does not exists");
			}
		}
	
	//insert in Linked List
	public void insertInLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setData(nodeValue);
		if(! existLinkedList()) {
			System.out.println("Linked List not exist !!");
			return;
		}
		else if(location < 0 || location > getSize()) {
			System.out.println("Invalid Location !!");
			return;
		}
		else if (location == 0) {
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			setHead(node);
		}
		else if(location == getSize()) {
			node.setPrev(tail);
			node.setNext(head);
			tail.setNext(node);
			head.setPrev(node);
			setTail(node);
		}
		else {
			DoubleNode tmpNode = new DoubleNode();
			tmpNode = head;
			for(int i = 0; i< location - 1; i++) {
				tmpNode = tmpNode.getNext();
			}
			node.setPrev(tmpNode);
			node.setNext(tmpNode.getNext());
			tmpNode.setNext(node);
			node.getNext().setPrev(node);
		}
		setSize(getSize() + 1);
		traverseLinkedList();
	}
	
	
	//Searchin a node in linked list
	public boolean searchNode(int nodeValue) {
		if(existLinkedList()) {
			DoubleNode tmpNode = head;
			for (int i = 0; i < getSize(); i++) {
				if(tmpNode.getData() == nodeValue) {
					System.out.println("Value found at location : " + i);
					return true;
				}
				tmpNode = tmpNode.getNext();
			}
		}
		else {
			System.out.println("Linked List not exist !! " );
			return false;
		}
		System.out.println("Value not found !! " );
		return false;
	}
	
	//deleting a node from linked list
	public void deletionOfNode(int location) {
		if(! existLinkedList()) {
			System.out.println("Linked List not exist !!");
			return;
		}
		else if(location < 0 || location > getSize()) {
			System.out.println("Invalid Location !!");
			return;
		}
		else if (location == 0) {
			head = head.getNext();
			head.setPrev(tail);
			tail.setNext(head);
		}
		else if (location == getSize()) {
			tail = tail.getPrev();
			tail.setNext(head);
			head.setPrev(tail);
		}
		else {
			DoubleNode tmpNode = new DoubleNode();
			tmpNode = head;
			for(int i = 0; i< location - 1; i++) {
				tmpNode = tmpNode.getNext();
			}
			tmpNode.setNext(tmpNode.getNext().getNext());
			tmpNode.getNext().setPrev(tmpNode);
		}
		setSize(getSize()-1);
		if(getSize() == 0) {
			head.setNext(null);
			head.setNext(null);
			setHead(null);
			setTail(null);
		}
		
	}
	
	//Deleting the entire linked list
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		if (tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete anymore !");
			return;
		}
		DoubleNode tmpNode = new DoubleNode();
		tmpNode = head;
		for(int i = 0; i< getSize(); i++) {
			tmpNode.setPrev(null);
			tmpNode = tmpNode.getNext();
		}
		tail.setNext(null);
		setHead(null);
		setTail(null);
	}
	
}