import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JW_Solution {

    public static void main(String[] args) {

        JW_Solution jw = new JW_Solution();
        int[] nums = {-2,0,0,2,2};

        System.out.println(jw.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length < 3) return ans;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0) {
                    List<Integer> tempList = new ArrayList<>(); 
                    tempList.add(0, nums[i]);
                    tempList.add(1, nums[left]);
                    tempList.add(2, nums[right]);
                    ans.add(tempList);

                    left++;
                    right--;
                    while (nums[left - 1] == nums[left] && left < right) left++;
                    while (nums[right + 1] == nums[right] && left < right) right--;
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
