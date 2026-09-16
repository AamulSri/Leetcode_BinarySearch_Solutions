public class LeetCode_410_SplitArray {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[] {7,2,5,10,8} , 2));
    }
        public static int splitArray(int[] nums, int k) {

            int start =0 ;
            int end = 0;
            for( int num : nums){
                start = Math.max(start, num);
                end +=num;
            }


            while(start < end ){
                int pieces =1;
                int sum = 0;
                int mid = start + (end - start)/2;
                for( int num : nums){
                    if(sum+num > mid){
                        sum = num;
                        pieces++;
                    }
                    else {
                        sum+=num;
                    }
                }

                if(pieces <= k){
                    end = mid;
                }
                else{
                    start = mid+1;
                }
            }
            return start;
        }
    }


