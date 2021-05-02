package leetcode.Week2.Four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class JI_Solution {
    public List<List<Integer>> FourSum(int[] nums, int target) {
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = 0;
                int right = nums.length - 1;

                while (true) {
                    if ((left >= i) || (right <= j))
                        break;
                    if (nums[left] + nums[right] + nums[i] + nums[j] == target) {
                        hashSet.add(new ArrayList<Integer>(Arrays.asList(nums[left], nums[i], nums[j], nums[right])));
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] + nums[i] + nums[j] > target)
                        right--;
                    else
                        left++;
                }
            }
        }

        return new ArrayList<>(hashSet);
    }
}
