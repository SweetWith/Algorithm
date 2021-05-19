#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> output;
        int size = nums.size();
        sort(nums.begin(), nums.end());
        long long tmp;
        for (int i = 0; i < size - 3; ++i) {
            while (i > 0 && nums[i] == nums[i-1] && i < size - 3) i++;
            for (int j = i + 1; j < size - 2; ++j) {
                while (j > i + 1 && nums[j] == nums[j-1] && j < size - 2) j++;
                int a = j + 1;
                int b = size - 1;
                while (a < b)
                {
                    tmp = (long long)nums[i] + nums[j] + nums[a] + nums[b];
                    if (tmp > target) {
                        b--;
                    }
                    else if (tmp < target) {
                        a++;
                    }
                    else // nums[i] + nums[j] + nums[a] + nums[b] == target
                    {
                        vector<int> v = {nums[i], nums[j], nums[a++], nums[b--]};
                        output.push_back(v);
                        while(nums[a - 1] == nums[a] && a < b) a++;
                        while(nums[b] == nums[b + 1] && a < b) b--;
                    }
                }
            }
        }
        return output;
    }
};
