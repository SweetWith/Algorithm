#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> tmp;
        int idx = 0;
        sort(nums.begin(), nums.end());
        int len = nums.size();
        int p1, p2;
        int pre_i = -100001;
        int pre_p1, pre_p2;
        for (int i = 0; i < len - 2; ++i) {
            if (pre_i == nums[i]) {
                continue;
            }
            p1 = i + 1;
            p2 = len - 1;
            pre_p1 = -100001;
            pre_p2 = 100001;
            while (p1 < p2) {
                pre_p1 = nums[p1];
                pre_p2 = nums[p2];
                if (nums[i] + nums[p1] + nums[p2] < 0) {
                    p1++;
                    while (p1 < p2 && pre_p1 == nums[p1]) {
                        p1++;
                    }
                } else if (nums[i] + nums[p1] + nums[p2] > 0) {
                    while (p1 < p2 && pre_p2 == nums[p2]) {
                        p2--;
                    }
                } else {
                    vector<int> tmp;
                    tmp.push_back(nums[i]);
                    tmp.push_back(nums[p1]);
                    tmp.push_back(nums[p2]);
                    ans.push_back(tmp);
                    p1++;
                    while (p1 < p2 && pre_p1 == nums[p1]) {
                        p1++;
                    }
                }
            }
            pre_i = nums[i];
        }
        return ans;
    }
};
