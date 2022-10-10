public class lc240 {
    static int rows, cols;

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        rows = matrix.length;
        if (rows == 0) return false;
        cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (searchHelper(matrix, target, i, 0, cols - 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean searchHelper(int[][] matrix, int target, int row, int collo, int colhi) {
        int lo = collo, hi = colhi;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] > target) {
                hi = mid - 1;
            } else if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
