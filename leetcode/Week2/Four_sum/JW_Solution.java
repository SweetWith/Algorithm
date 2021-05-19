package leetcode.Week2.Four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JW_Solution {
    public static void main(String[] args) {
        JW_Solution jw = new JW_Solution();

        int[] nums = {2,2,2,2};

        System.out.println(jw.fourSum(nums, 8));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++) {
            for(int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;

                while(left < right) {
                    if(nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(0, nums[i]);
                        tmp.add(1, nums[j]);
                        tmp.add(2, nums[left]);
                        tmp.add(3, nums[right]);
    
                        ans.add(tmp);
    
                        left++;
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}
