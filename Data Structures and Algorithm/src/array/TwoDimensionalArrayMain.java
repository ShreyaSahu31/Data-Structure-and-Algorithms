package array;

public class TwoDimensionalArrayMain {

	public static void main(String[] args) {

		System.out.println("Creating a blank array of size 5X5...");
		TwoDimensionalArray sda = new TwoDimensionalArray(5,5);
		sda.traverseArray();
		
		
		sda.insert(0,2,1000000001);
		sda.traverseArray();
				
		sda.insert(0,2,1000000001);
		sda.traverseArray();
		
		
		sda.accessingCell(0,2);
		sda.accessingCell(6,2);
		sda.accessingCell(2,2);
		
		
		sda.searchInAnArray(10);
		sda.searchInAnArray(-2147483648);
		sda.searchInAnArray(1000000001);
		
		
		sda.deleteValueFromArray(0,2);
		sda.traverseArray();
		
		
		sda.deleteThisArray();
		sda.traverseArray();
		
	}//end of main method	
}//end of Class
