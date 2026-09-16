public class Striver_LowerBound {
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{2,3,7,10,11,11,25}, 11));
    }
    static int lowerBound(int[] arr, int target) {
        // code here
        int start =0;
        int end = arr.length-1;

        while(start <= end ){
            int mid = start + ( end -start)/2;

            if( target > arr[mid] ){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return start;
    }
}
