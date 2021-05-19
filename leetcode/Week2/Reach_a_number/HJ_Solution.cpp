class Solution {
public:
    int reachNumber(int target) {
        int sum = 0;
        if (target < 0) {
            target = -target;
        }
        int i = 0;
        while(sum < target) {
            sum += (++i);
        }
        if (sum == target) {
            return i;
        } else {
            if ((sum & 1) ^ (target & 1)) {
                sum += (++i);
                return i + ((sum & 1) ^ (target & 1));
            } else {
                return i;   
            }
        }
    }
};
