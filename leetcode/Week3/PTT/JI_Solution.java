package leetcode.Week3.PTT;

import java.util.ArrayList;

public class JI_Solution {
    ArrayList<int[]> friend;
    int m;

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int ret = 109000;
        m = languages.length;
        friend = new ArrayList<>();
        for (int i = 0; i < friendships.length; i++) {
            if (!isOK(friendships[i][0], friendships[i][1], languages))
                friend.add(friendships[i]);
        }

        for (int i = 1; i <= n; i++) {
            ret = Math.min(ret, solve(i, languages));
        }
        return ret;
    }

    int solve(int studyNo, int[][] languages) {
        int ret = 0;
        int[] study = new int[m + 1];

        for (int i = 0; i < friend.size(); i++) {
            int a = friend.get(i)[0];
            int b = friend.get(i)[1];
            boolean aflag = false;
            boolean bflag = false;

            for (int j = 0; j < languages[a - 1].length; j++) {
                if (languages[a - 1][j] == studyNo)
                    aflag = true;
            }
            for (int j = 0; j < languages[b - 1].length; j++) {
                if (languages[b - 1][j] == studyNo)
                    bflag = true;
            }
            if (!aflag)
                study[a] = 1;
            if (!bflag)
                study[b] = 1;
        }

        for (int i = 0; i < m + 1; i++) {
            if (study[i] == 1)
                ret++;
        }

        return ret;
    }

    boolean isOK(int a, int b, int[][] languages) {
        for (int i = 0; i < languages[a - 1].length; i++) {
            for (int j = 0; j < languages[b - 1].length; j++) {
                if (languages[a - 1][i] == languages[b - 1][j])
                    return true;
            }
        }
        return false;
    }

}
