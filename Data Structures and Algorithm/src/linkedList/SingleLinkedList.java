package linkedList;

import node.SingleNode;

public class SingleLinkedList {
	
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
	
	//create Linked List
	public void createSingleLinkedList(int nodeValue) {
		SingleNode node = new SingleNode();
		node.setData(nodeValue);
		node.setNext(null);
		head = node;
		tail = node;
		setSize(1);
	}
	
	//insert node in Linked List
	public void insertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setData(nodeValue);
		if(! existLinkedList()) {
			System.out.println(" !! Linked List does not exist. ");
			return;
		}
		else if ( (location > size ) || (location < 0 )) {
			System.out.println(" !! invalid location. ");
			return;
		}
		else if(location == 0) {
			node.setNext(head);
			head = node;
		}
		else if(location == size) {
			node.setNext(null);
			tail.setNext(node);
			tail = node;
		}
		else {
			SingleNode tmpNode = new SingleNode();
			tmpNode = head;
			for(int i = 0; i < location-1; i++) {
				tmpNode = tmpNode.getNext();
			}
			node.setNext(tmpNode.getNext());
			tmpNode.setNext(node);
		}
		setSize( getSize() + 1);
	}
	
	//traverse Linked List
	public void traverseLinkedList() {
		if( existLinkedList()) {
			SingleNode tmpNode = head;
			for (int i = 0; i < size ; i++){
				System.out.print(tmpNode.getData());
				if(i != getSize()-1) {
					System.out.print(" -> ");
				}
				tmpNode = tmpNode.getNext();
			}
		}
		else {
			System.out.println("Linked List not exist !!");
		}
		System.out.println("\n");
	}
	
	// Searching a value in linked list
	public boolean searchNode(int nodeValue) {
		if( existLinkedList()) {
			SingleNode tmpNode = head;
			for (int i = 0; i < size ; i++){
				if(tmpNode.getData() == nodeValue) {
					System.out.print("node found at : " + i +"\n");
					return true;
				}
				tmpNode = tmpNode.getNext();
			}
		}
		else {
			System.out.println("Linked List not exist !!");
			return false;
		}
		
		System.out.println("Value not found ");
		return false;
	}
	
	// Deteting a node in Linked List
	public void deletionOfNode(int location) {
		if(! existLinkedList()) {
			System.out.println("Linked List not exist !!");
			return ;
		}
		else if (location >= getSize() || location < 0) {
			System.out.println("Invalid Location \n");
			return ;
		}
		else if(location == 0) {
			head = head.getNext();
			
		}
		else if (location == getSize() - 1) {
			SingleNode tmpNode = head;
			for(int i = 0 ; i < location - 1 ; i++) {
				tmpNode = tmpNode.getNext();
			}
			tmpNode.setNext(null);
			setTail(tmpNode);
		}
		else {
			SingleNode tmpNode = head;
			for(int i = 0 ; i < location - 1 ; i++) {
				tmpNode = tmpNode.getNext();
			}
			tmpNode.setNext(tmpNode.getNext().getNext());
		}
		setSize(getSize() - 1);
		if(getSize() == 0) {
			head = tail = null;
		}
	}
	
	//Deleting entire Linked List
	public void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully !");
	
	}
	

}
