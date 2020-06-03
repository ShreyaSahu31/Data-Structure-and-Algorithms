package queue;

public class QueueByArray {

	protected int [] arr;
	protected int top;
	protected int start;
	
	public QueueByArray(int size) {
		arr = new int[size];
		top = start = -1;
		System.out.println("Successfully created an empty queue of size: "+size);
	}
	
	public boolean isQueueFull() {
		if((top + 1) == arr.length) {
			System.out.println("Queue is full");
			return true;
		}	
		else 
			return false;
	}
	
	public boolean isQueueEmpty() {
		if(start == -1) {
		//	System.out.println("Queue is empty..");
			return true;
		}
			
		else 
			return false;
	}
	
	public void enQueue(int value) {
		if(isQueueFull()) {
			return;
		}
		else if(isQueueEmpty()) {
			top = 0;
			start = 0;
			arr[top] = value;
		}
		else {
			arr[top+1] = value;
			top++;
		}
		System.out.println("Successfully inserted " + value + " in queue.");
		printQueue();
	}
	
	public void deQueue() {
		int tmp;
		if(isQueueEmpty()) {
			System.out.println("Queue is empty..");
			return;
		}
		else {
			tmp = arr[start];
			if(start == top) {
				start = top = -1;
			}
			else {
				start++;
			}
		}
		System.out.println("Successfully deleted " + tmp + " from queue.");
		printQueue();
	}
	
	public void printQueue() {
		if(isQueueEmpty()) {
			System.out.println("Queue is empty..");
			return;
		}
		else {
			System.out.println("Queue now ...");
			for(int i=start; i<=top; i++) {
				System.out.print(arr[i]);
				if(i != top) {
					System.out.print(" -> ");
				}
			}
			
			System.out.println();
		}
	}
	
	public void peekOperation() {
		if(isQueueEmpty()) {
			return;
		}
		else {
			System.out.println("Value :" + arr[start]);
		}
	}
	
	public void deleteQueue() {
		if(arr == null)
			System.out.println("Queue not found to delete");
		else
			arr = null;
	}
	
}
