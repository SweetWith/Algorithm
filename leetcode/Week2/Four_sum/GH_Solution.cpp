class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) 
    {
        vector<vector<int>> output;
        sort(nums.begin(), nums.end());
        int size = nums.size();
        for (int i=0; i<size-3; i++)
        {
            while(i > 0 and nums[i] == nums[i-1] and i < size-3) i++;
            for (int l=i+1; l < size - 2; l++)
            {
                while (l > i + 1 and nums[l] == nums[l-1] and l < size-2) l++;
                
                int j = l+1;
                int k = size-1;

                while (j < k)
                {
                    if (nums[i] + nums[j] + nums[k] + nums[l] > target)
                        k--;
                    else if (nums[i] + nums[j] + nums[k] + nums[l] < target)
                        j++;
                    else // nums[i] + ums[j] + nums[k] + nums[l] == target
                    {
                        vector<int> v = {nums[i], nums[l], nums[j++], nums[k--]};
                        if (output.empty() or output.back() != v)
                            output.push_back(v);  
                        while(nums[j-1] == nums[j] and j < k) j++;
                        while(nums[k] == nums[k+1] and j < k) k--;
                    }
                }
            }
        }
        
        return output;
    }
}
