import java.util.Scanner;

public class Array1 {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int[] numbers=new int[10];
        int[] originalArray=new int[10];
        initializeArray(numbers);
		enterFromKeyboard(numbers, originalArray);
        System.out.println("MENU");
		System.out.println("===========================================");
		System.out.println("1.Count the number of positive integers.");
		System.out.println("2.Display the array starting from the number that was entered first.");
		System.out.println("3.Display the array from the number entered last to the number entered first.");
		System.out.println("4.Calculate the sum of all the numbers in the array.");
		System.out.println("5.Calculate the average of all the numbers in the array.");
		System.out.println("6.Find the largest number");
		System.out.println("7.Find the smallest number");
		System.out.println("8.Search for and display the index(s) of the array that hold the number you enter.");
		System.out.println("9.Display the array in order of smallest to largest");
		System.out.println("10.Same as option 9, but faster.");
		System.out.println("11.EXIT");
		System.out.println("==============================================");
		System.out.println("Please enter your choice:");
        int input=myScanner.nextInt();
        while(input!=11) {
			if(input==1)
				countWhole(numbers);
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
				System.out.println("Please enter a number whose index you would like to find:");
				int specNum = myScanner.nextInt();
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
    public static void initializeArray(int[] array) {
		for (int i=0; i<array.length;i++)
			array[i]=-1;
    }
    public static void enterFromKeyboard(int[] array, int[] list) {
		System.out.println("Please enter 10 whole numbers to fill an array:");
		for (int i=0; i<array.length;i++)
            array[i]=myScanner.nextInt();
        for (int i=0; i<array.length; i++)
            list[i]=array[i];
    }
    public static void countWhole(int[] array) {
		int posNumCounter=0;
		for(int elements:array) {
			if (elements>0)
				posNumCounter++;
		}
		System.out.println("There are "+posNumCounter+" positive numbers.");
	}
    public static void display(int[] array) {
		for(int elements:array)
			System.out.print(elements+" ");
		System.out.println();
	}
    public static void displayReverse(int[] array) {
		for (int i=array.length-1; i>=0; i--)
			System.out.print(array[i]+" ");
		System.out.println();
	}
    public static void sum(int[] array) {
		int sum = 0;
		for(int elements:array)
			sum+=elements;
		System.out.println("The sum of the array is "+sum+".");
	}
    public static void average(int[] array) {
		int sum = 0;
		for(int elements:array)
			sum+=elements;
		System.out.println("The average of the array is "+sum/array.length+".");
	}
    public static void findMax(int[] array) {
		int max=array[0];
		for(int elements:array) {
			if(elements>max)
				max=elements;
		}
		System.out.println("The largest number of the array is "+max+".");
    }
    public static void findMin(int[] array) {
		int min=array[0];
		for(int elements:array) {
			if(elements<min)
				min=elements;
		}
		System.out.println("The smallest number of the array is "+min+".");
	}
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
    public static void sort(int[] list) {
		int temp=0;
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
