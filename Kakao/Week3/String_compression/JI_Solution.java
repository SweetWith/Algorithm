public class StringCompression {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length()/2; i++) {
            String temp = solve(i,0,s);
//            System.out.println("i = "+i);
//            System.out.println("temp = " + temp);
            answer = Math.min(answer, temp.length());
        }
        return answer;
    }

    public String solve(int n, int now, String s){
        String ret = "";
        if(now >= s.length())
            return ret;
        if(now+n >= s.length())
            return s.substring(now);

        String temp = s.substring(now,now+n);
        int fdret = findDuplicate(temp, s.substring(now+n) );

        if(fdret != 1){
            ret += Integer.toString(fdret);
        }
        ret = ret + temp + solve(n,now+fdret*n,s);

        return ret;
    }

    public int findDuplicate(String temp, String s){
        int ret = 1;
        int now = 0;
        while(s.length() >= now + temp.length() ){
            if(!s.substring(now,now+temp.length()).equals(temp))
                break;

            now += temp.length();
            ret ++;
        }

        return ret;
    }
}
