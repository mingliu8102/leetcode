import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsSolution {
    static int N;
    static List<List<Integer>> res;

    public static void main(String[] args) {
        Queue q = new LinkedList();
        q.poll()
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null) return null;
        res = new LinkedList<>();
        LinkedList ls = new LinkedList();
        N = graph.length;
        dfs(graph, 0, ls);
        return res;

    }

    private static void dfs(int[][] graph, int start, LinkedList<Integer> ls) {
        if (start == N - 1) {
            res.add(ls);
            return;
        }
        int n = graph[start].length;
        for (int i = 0; i < n; i++) {
            ls.add(graph[start][i]);
            dfs(graph, graph[start][i], ls);
            ls.remove((Integer) graph[start][i]);
        }
    }
}


