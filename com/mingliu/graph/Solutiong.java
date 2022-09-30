class Solutiong {
    public static void main(String[] args) {
        int[][] connected = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(findCircleNum(connected));
    }

    static int[] root;
    static int count;

    public static int findCircleNum(int[][] isConnected) {
        if (isConnected == null) return 0;
        int N = isConnected.length;
        count = N;
        root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    private static void union(int i, int j) {
        int ri = find(i);
        int rj = find(j);
        if (ri == rj) return;
        //注意：这里是root[ri]，不是root[i]
        root[ri] = rj;
        count--;
    }

    private static int find(int i) {
        while (i != root[i]) i = root[i];
        return i;
    }
}
