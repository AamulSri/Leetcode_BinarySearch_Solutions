import java.util.Arrays;

public class LeetCode_34_FindFirstAndLast {

    public static void main(String[] args) {
        int res[] = searchRange(new int[]{5,7,7,7,7,8,8,10}, 7);
        System.out.println(Arrays.toString(res));
    }



    public static int[] searchRange(int[] nums, int target) {
        int res[] = {-1,-1};
        int start = findIndex(nums, target , true);
        int end = findIndex(nums, target , false);
        res[0] = start;
        res[1] = end;
        return res;
    }

    public static int  findIndex (int[] nums, int target, boolean isFirstOccurance) {
    int start = 0;
    int end = nums.length -1;
    int ans =-1;

        while(start<=end){
        int mid = start + ( end - start)/2 ;
        if(target> nums[mid]){
            start = mid+1;
        }
        else if(target<nums[mid]){
            end = mid-1;
        }
        else{
           ans = mid;

           if(isFirstOccurance){
               end = mid-1;
           }
           else{
               start = mid+1;
           }
        }
    }
        return ans;
}
}
