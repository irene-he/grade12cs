public class MergeSort {
    public static void main(String[] args){
        int[] array = {1,4,7,2,8,12,25,0};
        merge(array);
        for(int elements:array)
            System.out.print(elements+" ");
    }
    public static void merge(int[] array){
        merge(array ,new int[array.length], 0, array.length-1);
    }
    public static void merge(int[] array,int[] temp,int leftStart, int rightEnd){
        if(leftStart>=rightEnd)
            return;
        int middle= (leftStart+rightEnd)/2;
        merge(array, temp, leftStart, middle);
        merge(array, temp, middle+1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }
    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd){
        int leftEnd = (leftStart+rightEnd)/2;
        int rightStart = leftEnd+1;
        int size = rightEnd-leftStart+1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left<=leftEnd && right<=rightEnd) {
            if(array[left]<=array[right]) {
                temp[index]=array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        System.arraycopy(array, left, temp, index, leftEnd-left+1);
        System.arraycopy(array, right, temp, index, rightEnd-right+1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }
}