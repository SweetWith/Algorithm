public class LockKey {
    int lockLength ;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        lockLength  = lock.length;
        int[][] arrKey = new int[lock.length * 3][lock.length * 3];
        int[][] arrLock = new int[lock.length * 3][lock.length * 3];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                arrLock[i + lock.length][j + lock.length] = lock[i][j];
            }
        }

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                arrKey[i + lock.length][j + lock.length] = key[i][j];
            }
        }

        if (solve(arrKey, arrLock))
            return true;

        arrKey = getTurnKey(arrKey);
        if (solve(arrKey, arrLock))
            return true;

        arrKey = getTurnKey(arrKey);
        if (solve(arrKey, arrLock))
            return true;

        arrKey = getTurnKey(arrKey);
        return solve(arrKey, arrLock);
    }

    boolean solve(int[][] key, int[][] lock) {

        for (int i = -lockLength; i < lockLength; i++) {
            for (int j = -lockLength; j < lockLength; j++) {
                //System.out.println("i = " + i+" j = "+j);

                if (isOpen(key,lock, i, j))
                    return true;
            }
        }
        return false;
    }

    boolean isOpen(int[][] key, int[][] lock, int row, int col) {
        if ((0 > row + lockLength) || (row + lockLength > lockLength * 3))
            return false;
        if ((0 > col + lockLength) || (col + lockLength > lockLength * 3))
            return false;

        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                if ((key[i + lockLength +row][j + lockLength +col] ^ lock[i + lockLength][j + lockLength]) == 0)
                    return false;
            }
        }
        return true;
    }



    int[][] getTurnKey(int[][] key) {
        int[][] ret = new int[key.length][key[0].length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                ret[j][i] = key[key.length - i - 1][j];
            }
        }

        return ret;
    }
}
