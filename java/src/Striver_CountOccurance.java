public class Striver_CountOccurance {

    public static void main(String[] args) {
        System.out.println(countFreq(new int[] {1, 2, 2, 2, 2, 3, 4, 7, 8, 8}, 2));
    }
    private static int countFreq(int[] arr, int target) {
        // code here
        if(lowerBound(arr , target)==-1){
            return 0;
        }
        return (upperBound(arr , target) -lowerBound(arr , target)+1);

    }

    private static int upperBound(int [] arr , int target){
        int start =0 ;
        int end = arr.length -1;
        int ans = -1;

        while (start <= end){
            int mid = start + ( end -start )/2;
            if(target < arr[mid]){
                end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid +1;
            }
            if(target == arr[mid]){
                ans = mid;
                start = mid +1;
            }
        }
        return ans;
    }

    private static int lowerBound(int [] arr , int target){
        int start =0 ;
        int end = arr.length -1;
        int ans = -1;

        while (start <= end){
            int mid = start + ( end -start )/2;
            if(target < arr[mid]){
                end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid +1;
            }
            if(target == arr[mid]){
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}
