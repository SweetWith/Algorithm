#include <stack>

class Solution {
public:
    int trap(vector<int>& height) 
    {
        stack<int> stack;
        int output = 0;
        int size = height.size();
        for (int i = 0; i < size; i++)
        {   
            int max;
            while (not stack.empty() and stack.top() <= height[i])
            {
                max = stack.top();
                stack.pop();
            }
            if (not stack.empty())
                max = height[i];
            
            for (int j = i - 1; j >= 0 and height[j] < max; j--)
            {
                output += (max - height[j]);
                height[j] = max;
            }
            
            if (height[i] > 0)
                stack.push(height[i]);
        }
        return output;
    }
};
