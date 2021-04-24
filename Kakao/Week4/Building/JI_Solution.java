import java.util.ArrayList;

public class Building {
    boolean[][] gidung;
    boolean[][] bo;


    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<int[]> list = new ArrayList<>();

        gidung = new boolean[n + 2][n + 2];
        bo = new boolean[n + 2][n + 2];

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int frame = build_frame[i][2];
            int method = build_frame[i][3];

            if (method == 1) { // install
                if (frame == 0 && isOkGidung(x, y))
                    gidung[x][y] = true;
                else if (frame == 1 && isOkBo(x, y))
                    bo[x][y] = true;
            } else { // remove
                if (frame == 0) { //gidung
                    gidung[x][y] = false;
                    if (y < n && gidung[x][y + 1] && !isOkGidung(x, y + 1))
                        gidung[x][y] = true;
                    if (x > 0 && bo[x - 1][y + 1] && !isOkBo(x - 1, y + 1))
                        gidung[x][y] = true;
                    if (x < n && bo[x][y + 1] && !isOkBo(x, y + 1))
                        gidung[x][y] = true;
                } else if (frame == 1) { // bo
                    bo[x][y] = false;
                    if (gidung[x][y] && !isOkGidung(x, y))
                        bo[x][y] = true;
                    if (gidung[x + 1][y] && !isOkGidung(x + 1, y))
                        bo[x][y] = true;
                    if (x > 0 && bo[x - 1][y] && !isOkBo(x - 1, y))
                        bo[x][y] = true;
                    if (x < n && bo[x + 1][y] && !isOkBo(x + 1, y))
                        bo[x][y] = true;
                }
            }
        }

        int k = 0;
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (gidung[i][j]) {
                    int[] temp = {i, j, 0};
                    list.add(temp);
                    k++;
                }
                if (bo[i][j]) {
                    int[] temp = {i, j, 1};
                    list.add(temp);
                    k++;
                }
            }
        }

        int[][] answer = new int[k][3];
        for (int i = 0; i < k; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    boolean isOkGidung(int x, int y) {
        if (y == 0) return true;
        if (gidung[x][y - 1]) return true;
        if (x != 0 && bo[x - 1][y]) return true;
        if (bo[x][y]) return true;
        return false;
    }

    boolean isOkBo(int x, int y) {
        if (gidung[x][y - 1]) return true;
        if (gidung[x + 1][y - 1]) return true;
        if (x != 0 && bo[x - 1][y] && bo[x + 1][y]) return true;
        return false;
    }

//
//    void print(int[][] answer){
//        for (int i = 0; i < answer.length; i++) {
//            int[] temp = answer[i];
//            System.out.println("x = "+temp[0] + " y = "+ temp[1] +" f = "+temp[2]);
//        }
//    }

}
