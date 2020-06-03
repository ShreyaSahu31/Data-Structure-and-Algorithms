package node;

public class DoubleNode {

	private int data;
	private DoubleNode prev;
	private DoubleNode next;
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setPrev(DoubleNode prev) {
		this.prev = prev;
	}
	
	public DoubleNode getPrev() {
		return prev;
	}
	
	public void setNext(DoubleNode next) {
		this.next = next;
	}
	
	public DoubleNode getNext() {
		return next;
	}
	
	@Override
	public String toString() {
		return data + "";
	}
}
