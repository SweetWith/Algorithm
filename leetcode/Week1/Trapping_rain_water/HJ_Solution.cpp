#include<vector>

using namespace std;
#define Min(a,b) (a < b ? a : b)

int DP[30001];
class Solution {
public:
    int trap(vector<int>& height) {
        int len = height.size();
        int max = 0;
        int ans = 0;
        for (int i = len - 1; i >= 0; --i) {
            if(max < height[i]) {
                max = height[i];
            }
            DP[i] = max;
        }
        max = 0;
        int min = 0;
        for (int i = 0; i < len; ++i) {
            if(max < height[i]) {
                max = height[i];
            }
            min = Min(DP[i], max);
            ans += (min - height[i]);
        }
        return ans;
    }
};
