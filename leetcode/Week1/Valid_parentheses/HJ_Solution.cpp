#include <stack>
#include <string>
using namespace std;

class Solution {
public:
    bool isValid(string s) {
        stack<char> Stack;
        int len = s.length();
        char c;
        for (int i = 0; i < len; ++i) {
            c = s.at(i);
            if (c == '[' || c == '{' || c == '(') {
                Stack.push(c);
            } else if (c == ']') {
                if (!Stack.empty() && Stack.top() == '[') {
                    Stack.pop();
                } else {
                    return false;
                }
            } else if (c == ')') {
                if (!Stack.empty() && Stack.top() == '(') {
                    Stack.pop();
                } else {
                    return false;
                }
            } else { // c == }
                if (!Stack.empty() && Stack.top() == '{') {
                    Stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (Stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
};
