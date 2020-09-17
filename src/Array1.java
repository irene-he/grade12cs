import java.util.Scanner;

public class Array1 {
	static Scanner myScanner = new Scanner(System.in);
	//Scanner object myScanner is used in the code whenever input is required from the user
	/**
	 * Initializes 2 arrays, calls itializeArray and enterFromKeyboard to set their values,
	 * starts the menu driven mainline which will call all the other methods upon the user
	 * choosing that method, loops so that the user can enter more choices from
	 * the menu until they exit.
	 * @param args
	 */
	public static void main(String[] args) {
		//Declared an array to hold 10 integers.
		int[] numbers=new int[10];
		//This array will be used for methods display() and displayReverse/
		int[] originalArray=new int[10];
		//Called initializeArray() and enterFromKeyboard() methods before displaying the menu.
		initializeArray(numbers);
		enterFromKeyboard(numbers, originalArray);
        System.out.println("MENU"); //Menu driven mainline that runs all procedures listed in it.
		System.out.println("===========================================");
		System.out.println("1.Count the number of positive integers.");
		System.out.println("2.Display the array starting from the number that was entered first.");
		System.out.println("3.Display the array from the number entered last to the number entered first.");
		System.out.println("4.Calculate the sum of all the numbers in the array.");
		System.out.println("5.Calculate the average of all the numbers in the array.");
		System.out.println("6.Find the largest number");
		System.out.println("7.Find the smallest number");
		System.out.println("8.Search for and display the index(s) of the array that hold the number you enter.");
		System.out.println("9.Display the array in order of smallest to largest using bubble sort.");
		System.out.println("10.Same as option 9, but faster and more efficient.");
		System.out.println("11.EXIT");
		System.out.println("==============================================");
		System.out.println("Please enter your choice:");
        int input=myScanner.nextInt();
		//While loop that allows the user to repeatedly make other choices from the menu.
		while(input!=11) {
			if(input==1)
				countWhole(numbers);
			//originalArray is passed as the argument to methods display and displayReverse.
			if(input==2)
				display(originalArray);
			if(input==3)
				displayReverse(originalArray);
			if(input==4)
				sum(numbers);
			if(input==5)
				average(numbers);
			if(input==6)
				findMax(numbers);
			if(input==7)
				findMin(numbers);
			if(input==8) {
				//Prompts the user to enter a specified number to look for.
				System.out.println("Please enter a number whose index you would like to find:");
				int specNum = myScanner.nextInt();
				//Passes the array and the specified number to the method.
				search(numbers, specNum);
            } 
            if(input==9) 
				sort(numbers);
			if(input==10)
				improvedBubbleSort(numbers);
			input=myScanner.nextInt();
        }
        System.out.println("Thanks for testing my code.");
	}
	/**
	 * Initializes the array by setting all the index values to -1.
	 * @param array array to be initialized
	 */
    public static void initializeArray(int[] array) {
		for (int i=0; i<array.length;i++)
			array[i]=-1;
	}
	/**
	 * Sets the index values of two arrays (one array is used to store the
	 * original order of the array before any sorting occurs) to the 10 numbers
	 * that the user enters.
	 * @param array array to be initialized
	 * @param list array to be initialized
	 */
    public static void enterFromKeyboard(int[] array, int[] list) {
		System.out.println("Please enter 10 whole numbers to fill an array:");
		for (int i=0; i<array.length;i++)
			array[i]=myScanner.nextInt();
		//Copies the all the values of the array numbers to the array originalArray
        for (int i=0; i<array.length; i++)
            list[i]=array[i];
	}
	/**
	 * Counts and displays the amount of positive whole numbers in the array.
	 * @param array array to be counted through.
	 */
    public static void countWhole(int[] array) {
		int posNumCounter=0;
		for(int elements:array) {
			if (elements>0)
				posNumCounter++;
		}
		System.out.println("There are "+posNumCounter+" positive numbers.");
	}
	/**
	 * Displays the array in the original order it was entered in
	 * starting from the number that the user entered first to the number
	 * that the user entered last.
	 * @param array array to be displayed
	 */
    public static void display(int[] array) {
		for(int elements:array)
			System.out.print(elements+" ");
		System.out.println();
	}
	/**
	 * Displays the array in the reverse order of how it was entered
	 * starting from the last number the user entered to the first number
	 * the user entered.
	 * @param array array to be displayed in reverse order
	 */
    public static void displayReverse(int[] array) {
		for (int i=array.length-1; i>=0; i--)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	/**
	 * Calculates and displays the sum of all the values in the array.
	 * @param array array to find the sum from
	 */
    public static void sum(int[] array) {
		int sum = 0;
		for(int elements:array)
			sum+=elements;
		System.out.println("The sum of the array is "+sum+".");
	}
	/**
	 * Calculates and displays the average of all the values in the array.
	 * @param array array to find the average from
	 */
    public static void average(int[] array) {
		int sum = 0;
		for(int elements:array)
			sum+=elements;
		System.out.println("The average of the array is "+sum/array.length+".");
	}
	/**
	 * Searches through the array's elements for the max (largest) number 
	 * and prints it out.
	 * @param array array to find the max number from
	 */
    public static void findMax(int[] array) {
		int max=array[0];
		for(int elements:array) {
			if(elements>max)
				max=elements;
		}
		System.out.println("The largest number of the array is "+max+".");
	}
	/**
	 * Searches through the array's elements for the min (smallest) number 
	 * and prints it out.
	 * @param array array to find the min number from
	 */
    public static void findMin(int[] array) {
		int min=array[0];
		for(int elements:array) {
			if(elements<min)
				min=elements;
		}
		System.out.println("The smallest number of the array is "+min+".");
	}
	/**
	 * Searches for the index/indices that the number the user entered
	 * is found in and then displays the result.
	 * @param array array to search through
	 * @param specNum number to search through
	 */
    public static void search(int[] array,int specNum) {
		String arrayIndex ="";
		System.out.print(specNum+" is at index/indices: ");
		for(int i=0; i<array.length; i++) {
			if(array[i]==specNum) {
				arrayIndex=i+" ";
				System.out.print(arrayIndex);
			}
		}
		if(arrayIndex.isEmpty())
			System.out.print(specNum+" isn't at any array index");
		System.out.println();
	}
	/**
	 * Uses the bubble sort algorithm to sort the array in ascending order
	 * and diaplays out the sorted array.
	 * @param list array to be sorted through
	 */
    public static void sort(int[] list) {
		int temp; //temporarily stores an index value. 
		for (int iterations=0; iterations<list.length-1; iterations++) {
			for (int swaps=0; swaps<(list.length-1-iterations); swaps++) {
				if(list[swaps]>list[swaps+1]) {
					temp=list[swaps];
					list[swaps]=list[swaps+1];
					list[swaps+1]=temp;
				}
			}
		}
		for(int elements:list) 
			System.out.print(elements+" ");
		System.out.println();
	}
	/**
	 * Uses the improved bubble sort algorithm to sort the array in ascending order
	 * and displays out the sorted array.
	 * @param list array to be sorted through
	 */
    public static void improvedBubbleSort(int[] list) {
        int j=1;
        int temp;
        boolean swap=true;
        while(swap) {
            swap=false;
            for(int i=0; i<list.length-j;i++){
                if (list[i]>list[i+1]){
                    temp=list[i];
                    list[i]=list[i+1];
                    list[i+1]=temp;
                    swap=true;
                }
            }
            j++;
        }
        for(int elements:list) 
			System.out.print(elements+" ");
		System.out.println();
    }
}
