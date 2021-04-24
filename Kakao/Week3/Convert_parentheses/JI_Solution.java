import java.util.Stack;

public class WayfindingGame {
    Stack<Character> stack = new Stack<>();
    public String solution(String p) {
        return solve(p);
    }

    public String solve(String s){
        String ret = "";
        if(s.length() == 0)
            return "";

        int point = findBalanceBracket(s) +1;
        String u = s.substring(0,point);
        String v = s.substring(point);

        if(isRightBracket(u)){
            ret = u + solve(v);
        }
        else{
            ret = "(" + solve(v) + ")" ;
            if(u.length() != 0)
                ret += swap(u.substring(1,u.length()-1));
        }
        return ret;
    }

    public String swap(String s){
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                ret += ')';
            else
                ret += '(';
        }
        return ret;
    }

    public int findBalanceBracket(String s){
        int i;
        int balance = 0;
        if(s.length() == 0)
            return 0;
        for (i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                balance++;
            else
                balance--;

            if(balance==0)
                break;
        }
        return i;
    }

    public boolean isRightBracket (String s){
        int i;
        if(s.length() == 0)
            return true;

        if(s.charAt(0) == ')')
            return false;

        stack.push(s.charAt(0));

        for (i = 1; i < s.length(); i++) {
            if(stack.peek() == s.charAt(i))
                stack.push(s.charAt(i));
            else
                stack.pop();

            if(stack.isEmpty())
               return true;
        }
        return false;
    }
}
