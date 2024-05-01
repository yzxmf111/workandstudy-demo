package study2024.graph;

import java.util.List;

/**
 * @author xiaotian
 * @description 图成环检测
 * @date 2024-04-20 12:00
 */
public class CycleDetector {
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, List<List<Integer>> adjList) {
        if (recStack[i]) {
            return true; // found a node that is already in the recursion stack
        }
        if (visited[i]) {
            return false; // already visited and no cycle was found from this node
        }

        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adjList.get(i);

        for (Integer c : children) {
            if (isCyclicUtil(c, visited, recStack, adjList)) {
                return true;
            }
        }

        recStack[i] = false;
        return false;
    }

    /**
     * 我们将使用DFS来检测图中是否存在环。需要辅助的visited数组和一个递归栈(recursion stack)来跟踪已经访问的顶点。
     * @param graph
     * @return
     */
    public boolean isCyclic(Graph graph) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        boolean[] recStack = new boolean[graph.getNumVertices()];

        for (int i = 0; i < graph.getNumVertices(); i++) {
            if (isCyclicUtil(i, visited, recStack, graph.getAdjList())) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);  // This creates a cycle.

        CycleDetector detector = new CycleDetector();
        boolean hasCycle = detector.isCyclic(graph);
        System.out.println("The graph has a cycle: " + hasCycle);
    }
}

