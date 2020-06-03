package queue;

public class CircularQueueByArray {

	protected int arr[];
	protected int top;
	protected int start;
	
	public CircularQueueByArray(int size) {
		arr = new int [size];
		top = start = -1;
		System.out.println("Successfully created circular queue of size" + size);
	}
	
	public boolean isQueueEmpty(){
		if(start == -1) 
			return true;
		else 
			return false;
	}
	
	public boolean isQueueFull() {
		if(top + 1 == start) 
			return true;
		else if(top == arr.length - 1 && start == 0)
			return true;
		else
			return false;
	}
	
	public void enQueue(int value) {
		if(isQueueFull()) {
			System.out.println("Queue is full !!");
			return;
		}
		else if(isQueueEmpty()) {
			top = start = 0;
			arr[top] = value;
			System.out.println("Successfully inserted the value :" + value);
		}
		else {
			if(top == arr.length - 1) {
				top = 0;
			}
			else
				top++;
			arr[top] = value;
			System.out.println("Successfully inserted the value :" + value);
		}
	}
	
	public void deQueue() {
		int tmp;
		if(isQueueEmpty()) {
			System.out.println("Queue is empty !!");
			return;
		}
		else {
			tmp = arr[start];
			arr[start] = 0;
			if(start == top)
				start = top = -1;
			else if(start == arr.length + 1)
				start = 0;
			else
				start++;
			System.out.println("Successfully deleted the value :" + tmp);
		}
	}
	
	public void peekOperation() {
		if(isQueueEmpty()) {
			System.out.println("Queue is empty !!");
			return;
		}
		else
			System.out.println("the value :" + arr[start]);
	}
	
	//Print entire array
		public void printArray() {
			System.out.println("Array now...");
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+"  ");
			}
			System.out.println("\nStart = " + start);
			System.out.println("End = "+ top);
		}
		
		public void deleteQueue() {
			System.out.println("\n\nDeleting the entire Queue...");
			arr = null;
			System.out.println("Queue is successfully deleted !");
		}

}
