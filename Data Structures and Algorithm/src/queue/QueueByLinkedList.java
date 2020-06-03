package queue;

import linkedList.SingleLinkedList;

public class QueueByLinkedList {
	
	SingleLinkedList list;
	
	public QueueByLinkedList(){
		list = new SingleLinkedList();
	}
	
	public boolean isQueueEmpty() {
		if(list.getHead() == null)
			return true;
		else
			return false;
	}
	
	public void enQueue(int value) {
		if(isQueueEmpty()) {
			list.createSingleLinkedList(value);
		}
		else
			list.insertInLinkedList(value, list.getSize());
		System.out.println("Successfully inserted value :" + value);
		list.traverseLinkedList();
	}
	
	public void deQueue() {
		if(isQueueEmpty()) {
			System.out.println("Queue is empty");
		}
		else {
			System.out.println("Successfully deleted value :" + list.getHead().getData());
			list.deletionOfNode(0);
			list.traverseLinkedList();
		}
	}
	
	public int peekOperation() {
		if(isQueueEmpty()) {
			System.out.println("Queue is empty");
			return 0;
		}
		else {
			return list.getHead().getData();
		}
	}
	
	public void deleteQueue() {
		list.deleteLinkedList();
		System.out.println("Successfully deleted the queue");
	}

}
