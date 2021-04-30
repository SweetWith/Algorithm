import java.util.Stack;

public class JW_Solution {
    public static void main(String[] args) {

        JW_Solution jw = new JW_Solution();

        System.out.println(jw.isValid("["));
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {

            char temp = s.charAt(i);

            if('(' == temp || '{' == temp || '[' == temp) {
                stack.push(temp);
            } else {
                if(stack.empty()) return false;
                char temp2 = stack.pop();

                if(')' == temp) {
                    if('(' != temp2) return false;

                } else if('}' == temp) {
                    if('{' != temp2) return false;

                } else {
                    if('[' != temp2) return false;
                }             
            }
        }

        if(!stack.empty()) {
            return false;
        }

        return true;
    }
}
