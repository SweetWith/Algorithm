#include<vector>

using namespace std;

int DP[10001];
bool visited[10001];
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int size = coins.size();
        int coin;
        for (int i = 0; i <= amount; ++i) {
            DP[i] = 100;
            visited[i] = false; 
        }
        visited[0] = true;
        DP[0] = 0;
        for (int i = 0; i < size; ++i) {
            coin = coins[i];
            for (int j = 0; j + coin <= amount; ++j) {
                if (visited[j]) {
                    if (DP[j + coin] > DP[j] + 1) {
                        DP[j + coin] = DP[j] + 1;
                        visited[j + coin] = true;
                    }
                }
            }
        }
        if (visited[amount]) {
            return DP[amount];
        } else {
            return -1;
        }
    }
};
