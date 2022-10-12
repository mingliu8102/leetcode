public class offer13 {
    static boolean[][] visited;
    static int rows;
    static int cols;

    public static int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        rows = m;
        cols = n;
        int count = 0;
        dfs(0, 0, k);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, int k) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) return;
//        if(visited[i][j])return;
        if (canVisit(i, j, k)) {
            visited[i][j] = true;
            dfs(i + 1, j, k);
            dfs(i, j + 1, k);
            dfs(i - 1, j, k);
            dfs(i, j - 1, k);
        } else {
            return;
        }
    }


    private static boolean canVisit(int i, int j, int k) {
        if (visited[i][j]) return false;
        String stri = "" + i;
        String strj = "" + j;
        int sum = 0;
        for (int idx = 0; idx < stri.length(); idx++) {
            sum += stri.charAt(idx) - '0';
        }
        for (int idx = 0; idx < strj.length(); idx++) {
            sum += strj.charAt(idx) - '0';
        }
        return sum <= k;
    }

}
