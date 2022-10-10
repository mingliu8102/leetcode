import java.util.ArrayList;
import java.util.List;

public class lc54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = spiralOrder(matrix);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[][] directions;

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return null;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowlo = 0, rowhi = rows - 1;
        int collo = 0, colhi = cols - 1;
        directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dir = 0;
        int curX = 0, curY = 0;
        res.add(matrix[0][0]);
        int i = 1;
        while (i < rows * cols) {
            int nextX = curX + directions[dir][0];
            int nextY = curY + directions[dir][1];
            if (nextX > colhi || nextX < collo || nextY > rowhi || nextY < rowlo) {
                dir = (dir + 1) % 4;
                if (dir == 1) {
                    rowlo++;
                }
                if (dir == 2) {
                    colhi--;
                }
                if (dir == 3) {
                    rowhi--;
                }
                if (dir == 0) {
                    collo++;
                }
                continue;
            } else {
                res.add(matrix[nextY][nextX]);
                curX = nextX;
                curY = nextY;
                i++;
            }

        }
        return res;
    }

}
