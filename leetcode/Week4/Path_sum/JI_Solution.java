package leetcode.Week4.Path_sum;

public class JI_Solution {
    public int minSwaps(String s) {
        int[] even = {0, 0};
        int[] odd = {0, 0};
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                odd[s.charAt(i)-48]++;
            } else {
                even[(int)s.charAt(i)-48]++;
            }
        }
        if (even[0] != odd[1] && even[1] != odd[0])
            return -1;

        if(even[0] == odd[1] && even[1] == odd[0]){
            return Math.min(even[0] , odd[0]);
        }
        else if(even[0] == odd[1]){
            return even[0];
        }
        else if(even[1] == odd[0]){
            return even[1];
        }
        else{
            return 0;
        }
    }
}
