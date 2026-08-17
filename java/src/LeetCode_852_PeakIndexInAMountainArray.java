public class LeetCode_852_PeakIndexInAMountainArray {
// same solution for leetcode 162 Find Peak Element
    public static void main(String[] args) {
        int res = peakIndexInMountainArray(new int[]{0,10,5,2});
        System.out.println(res);
    }

    public static int peakIndexInMountainArray(int[] arr) {

        int start = 0 ;
        int end = arr.length -1;

        while(start!=end){
            int mid = start + ( end - start )/2;

            if(arr[mid]>arr[mid+1]){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }

        return start ;
    }

}
