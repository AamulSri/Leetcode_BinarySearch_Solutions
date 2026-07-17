public class Leetcode_69_Sqrt {

    public static void main(String[] args) {
        int res = mySqrt(10);
        System.out.println(res);
    }

    public static int mySqrt(int x) {
            int start = 0;
            int end = x/2 +1 ;

            while(start<=end){
                int mid = start + (end - start)/2;
                long square = (long) mid*mid;
                if(square == x){
                    return mid;
                }
                else if(square< x){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }

            }
            return end;
        }
    }
