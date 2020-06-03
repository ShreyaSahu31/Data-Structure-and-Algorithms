package binaryTree;

public class BinaryTreeByArray {

	protected int [] arr;
	protected int lastUsedIndex;
	
	//Constructor
	public BinaryTreeByArray(int size) {
		arr = new int[size + 1];
		lastUsedIndex = 0 ;
		System.out.println("SuccessFully created the tree of size" + size);
	}
	
	//check if tree / array is full
	public boolean isTreeFull() {
		if (lastUsedIndex == arr.length - 1)
			return true;
		else
			return false;
	}
	
	//insert value in binary tree
	public void insert (int value) {
		if(isTreeFull()) {
			System.out.println("tree is full !!!");
			return;
		}
		arr[lastUsedIndex + 1] = value;
		lastUsedIndex++ ;
		System.out.println("SuccessFully inserted the value : " + value);
	}
	
	//level order traversal
	public void levelOrder() {
		for(int i = 1; i <= lastUsedIndex; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}
	
	// In order traversal
	public void inOrder (int index) {
		if(index > lastUsedIndex || index < 1) {
			return;
		}
		inOrder(index * 2);
		System.out.print(arr[index] + " ");
		inOrder(index *2 + 1);
	}
	
	//pre Order traversal 
	public void preOrder (int index) {
		if(index > lastUsedIndex || index < 1) {
			return;
		}
		System.out.print(arr[index] + " ");
		preOrder(index * 2);
		preOrder(index *2 + 1);
	}

	//post Order traversal 
	public void postOrder (int index) {
		if(index > lastUsedIndex || index < 1) {
			return;
		}
		postOrder(index * 2);
		postOrder(index *2 + 1);
		System.out.print(arr[index] + " ");
	}
	
	//searching a node
	public int search(int value) {
		for(int i = 1; i <= lastUsedIndex; i++) {
			if(arr[i] == value){
				System.out.println("Value found : " + value);
				return i;
			}
		}
		System.out.println("Value  not found : " + value);
		return -1;
	}
	
	// Deleting a node
	public void delete(int value) {
		int location = search(value);
		if(location != -1){
			arr[location] = arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("Successfully Value deleted : " + value);
			return;
		}
		
		System.out.println("Value  not found : " + value);
	}
	
	//deleting the entire tree
	public void deleteTree() {
		try {
			arr = null;
			System.out.println("Tree has been deleted successfully !");
		}catch(Exception e){
			System.out.println("There was an error deleting the tree.\nOr the tree has been already deleted .");
		}
	}
	
}
