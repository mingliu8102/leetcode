public class offer12 {
    static boolean[][] visited;
    static int[][] dirs;
    static int rows;
    static int cols;

    public static boolean exist(char[][] board, String word) {
        if (board == null) return false;
        dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
//                if (board[i][j] == word.charAt(0)) {
//                    dfs(board, i, j, word, 0);
//                }
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (i >= rows || i < 0 || j >= cols || j < 0) return false;
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(index)) return false;

        visited[i][j] = true;
        index++;
        if (index == word.length()) return true;

//        return dfs(board, i + 1, j, word, index) || dfs(board, i, j + 1, word, index)
//                || dfs(board, i - 1, j, word, index) || dfs(board, i, j - 1, word, index);
        if (dfs(board, i + 1, j, word, index) || dfs(board, i, j + 1, word, index)
                || dfs(board, i - 1, j, word, index) || dfs(board, i, j - 1, word, index)) return true;
        else {
            //如果没有查找到，撤回上一步
            visited[i][j] = false;
            return false;
        }
    }
}
