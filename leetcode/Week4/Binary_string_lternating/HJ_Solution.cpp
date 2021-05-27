class Solution {
public:
    int minSwaps(string s) {
        bool one[1001] = {0,};
        static int T = 1;
        int len = s.length();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < len; ++i) {
            if (s.at(i) == '1') {
                one[i] = true;
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        if (cnt1 < cnt2) {
            if (cnt1 + 1 == cnt2) { // one < zero
                cnt1 = 0;
                for (int i = 0; i < len; ++i) {
                    if ((i & 1) == 0 && one[i] == true) {
                        ++cnt1;
                    }
                }
                return cnt1;
            } else {
                return -1;
            }
        } else if (cnt2 < cnt1) {
            if (cnt2 + 1 == cnt1) { // one > zero
                cnt2 = 0;
                for (int i = 0; i < len; ++i) {
                    if ((i & 1) == 0 && one[i] == false) {
                        ++cnt2;
                    }
                }
                return cnt2;
            } else {
                return -1;
            }
        } else { // cnt2 == cnt1
            cnt1 = cnt2 = 0;
            for (int i = 0; i < len; ++i) {
                if (!one[i]) {
                    if ((i & 1) == 0) {
                        ++cnt1;
                    } else {
                        ++cnt2;    
                    }
                }
            }
            if (cnt1 < cnt2) {
                return cnt1;
            } else {
                return cnt2;
            }
        }
        return -1;
    }
};
