package linkedList;

import node.SingleNode;

public class SingleCircularLinkedList {

	protected SingleNode head;
	protected SingleNode tail;
	protected int size;
	
	public SingleNode getHead() {
		return head;
	}
	public void setHead(SingleNode head) {
		this.head = head;
	}
	public SingleNode getTail() {
		return tail;
	}
	public void setTail(SingleNode tail) {
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
	
	//create Circular Linkked List
	public void createSingleLinkedList(int nodeValue) {
		SingleNode node = new SingleNode();
		node.setData(nodeValue);
		setHead(node);
		setTail(node);
		node.setNext(node);
		setSize(1);
		System.out.println(node);
	}
	
	
	//Insert data in Linked List
	public void insertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setData(nodeValue);
		if(! existLinkedList()) {
			System.out.println("LinkedList does not exist");
			return ;
		}
		else if (location < 0 || location > getSize()) {
			System.out.println("Invalid Locationt");
			return ;
		}
		else if (location == 0) {
			node.setNext(head);
			setHead(node);
			tail.setNext(node);
		}
		else if(location == getSize()) {
			node.setNext(head);
			tail.setNext(node);
			setTail(node);
		}
		else {
			SingleNode tmpNode = new SingleNode();
			tmpNode = head;
			for(int i = 0; i< location - 1; i++) {
				tmpNode = tmpNode.getNext();
			}
			node.setNext(tmpNode.getNext());
			tmpNode.setNext(node);
		}
		setSize(getSize() + 1);
		
	}
	
	//traverse Linked List
	public void traverseLinkedList() {
		if(existLinkedList()) {
			SingleNode tmpNode = new SingleNode();
			tmpNode = head;
			for(int i = 0 ; i < getSize(); i++) {
				System.out.print(tmpNode.getData());
				if(i != getSize()-1) {
					System.out.print(" -> ");
				}
				tmpNode = tmpNode.getNext();
			}
			System.out.println(" \n");
		}
		else {
			System.out.println("LinkedLIst not exist !! \n");
		}
		
	}
	
	
	// Traverse Linked List
		void printHeadUsingTail() {
			if (existLinkedList()) {
				System.out.println("Printing Tail...");
				System.out.println(tail.getData());
				
				System.out.println("Printing Head using Head reference...");
				System.out.println(head.getData());
				
				System.out.println("Printing Head using Tail reference...");
				System.out.println(tail.getNext().getData());
				
			}else{
				System.out.println("Linked List does not exists");
			}
		}

	
	
	//Searching a value in Linked List
	public boolean searchNode(int nodeValue) {
		if(existLinkedList()) {
			SingleNode tmpNode = new SingleNode();
			tmpNode = head;
			for(int i = 0 ; i < getSize(); i++) {
				if(tmpNode.getData() == nodeValue) {
					System.out.print(" Value found at location : " + i);
					return true;
				}
				tmpNode = tmpNode.getNext();
			}
		}
		else {
			System.out.println("LinkedLIst not exist !! \n");
			return false;
		}
		
		System.out.print(" Value not found ");
		return false;
	}
	
	//Delete a node in LinkedList
	public void deletionOfNode(int location) {
		
		if(! existLinkedList()) {
			System.out.println("LinkedList does not exist");
			return ;
		}
		else if (location < 0 || location > getSize()) {
			System.out.println("Invalid Locationt");
			return ;
		}
		else if(location == 0) {
			setHead(head.getNext());
			tail.setNext(head);
		}
		else if (location == getSize()) {
			SingleNode tmpNode  = new SingleNode();
			tmpNode = head;
			for(int i = 0; i < location - 1; i ++) {
				tmpNode = tmpNode.getNext();
			}
			tmpNode.setNext(head);
			setTail(tmpNode);
			
		}
		else {
			SingleNode tmpNode  = new SingleNode();
			tmpNode = head;
			for(int i = 0; i < location - 1; i ++) {
				tmpNode = tmpNode.getNext();
			}
			tmpNode.setNext(tmpNode.getNext().getNext());
		}
		setSize(getSize() - 1);
		if(getSize() == 0) {
			head.setNext(null);
			head = tail = null;
		}
		
	}
	
	
	//Delete entire LinkedList
	public void deleteLinkedList() {
		tail.setNext(null);
		head = tail = null;
		System.out.println("Successfully deleted the linked list");
	}
	
	
}
