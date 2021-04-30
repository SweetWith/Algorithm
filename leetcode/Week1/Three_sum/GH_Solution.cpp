#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) 
    {
        vector<vector<int>> output;
        sort(nums.begin(), nums.end());
        int size = nums.size();
        for (int i=0; i<size-2; i++)
        {
            while (i > 0 and nums[i] == nums[i-1] and i < size-2) i++;
            int j = i+1;
            int k = size - 1;

            while (j < k)
            {
                if (nums[i] + nums[j] + nums[k] > 0)
                    k--;
                else if (nums[i] + nums[j] + nums[k] < 0)
                    j++;
                else // nums[i] + ums[j] + nums[k] == 0
                {
                    vector<int> v = {nums[i], nums[j++], nums[k--]};
                    if (output.empty() or output.back() != v)
                        output.push_back(v);  
                    while(nums[j-1] == nums[j] and j < k) j++;
                    while(nums[k] == nums[k+1] and j < k) k--;
                }
            }
        }
        
        return output;
    }
};
