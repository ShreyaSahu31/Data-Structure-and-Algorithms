package array;

public class TwoDimensionalArray {
	
	int arr[][] = null;
	
	 //Constructor
	public TwoDimensionalArray(int row, int col) {
		arr = new int[row][col];
		for(int i = 0; i< row; i++) {
			for(int j= 0; j < col ; j++) {
				arr[i][j] = Integer.MIN_VALUE;
			}
		}
		
	}
	
	 // Print the array
	public void traverseArray() {
		System.out.println("printing the array");
		try {
			for(int i = 0; i< arr.length; i++) {
				for(int j = 0; j< arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
		} catch(Exception e) {
			System.out.println("Array no longer exist !!!");
		}
		
	}
	
	//Insert value in the Array
	public void insert(int row, int col, int value) {
		try { 
			if(arr[row][col] == Integer.MIN_VALUE) {
				arr[row][col] = value;
				System.out.println("Successfully inserted : " + value);
			}
			else {
				System.out.println("The Cell is already occupied !!! " );
			}
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid location !!");
		}
	}
	
	// Access a particular element of an array
	public void accessingCell(int row, int col) {
		try {
			System.out.println("the value is : " + arr[row][col]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid location !!");
		}
	}
	
	//Search for an element in the given Array
	public void searchInAnArray(int value) {
		for(int i = 0; i< arr.length; i++) {
			for(int j = 0; j < arr[i].length ; j++) {
				if(arr[i][j] == value){
					System.out.println("Value found at location : arr[" + i + "][" + j + "]");
					return;
				}
			}		
		}
		System.out.println("Value not found !!!");
	}

	//Delete value from given Array
	public void deleteValueFromArray(int row,int col) {
		try {
			arr[row][col] = Integer.MIN_VALUE;
			System.out.println("Successfully deleted the value");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid cell location");
		}
	}
	
	//Delete the entire Array
	public void deleteThisArray() {
		arr = null;
		System.out.println("Array has been succefully deleted");
	}
	
}

