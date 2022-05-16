/*
    Time Complexity: O(N+E)
    Space Complexity: O(N+E),

    where N is the number of nodes and E is the number of edges.
    //https://www.codingninjas.com/codestudio/problems/social-networking-graph_1082557?leftPanelTab=0
*/

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class Solution {

    public static ArrayList < Integer > socialNetwork(int[][] queries, int n, int e, int m, int[][] edges) {
        ArrayList < Integer > answer = new ArrayList < > ();
        for (int j = 0; j < m; j++) {
            int s = queries[j][0];
            int t = queries[j][1];
            // We will store graph in an adjacency list.
            ArrayList < ArrayList < Integer >> graph = new ArrayList < ArrayList < Integer >> (n + 1);
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList < Integer > ());
            }
            // Making adjacency list named graph from edges.
            for (int i = 0; i < e; i++) {
                int x, y;
                x = edges[i][0];
                y = edges[i][1];
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            int[] visited = new int[n + 1];
            // Initially marking all nodes as unvisited
            for (int i = 0; i <= n; i++) {
                visited[i] = 0;
            }

            Queue < Integer > q = new LinkedList < Integer > ();
            q.add(s);
            visited[s] = 1;
            int count = 0;
            while (q.isEmpty() == false) {
                int node = q.poll();
                if (visited[node] == t + 1) {
                    // If the visited[node] is at a distance of t from s we increment count by 1.
                    count++;
                } else if (visited[node] > t + 1) {
                    break;
                }

                // Traversing all the childs of current node
                for (int i = 0; i < graph.get(node).size(); i++) {
                    int child = graph.get(node).get(i);
                    // If the child is unvisited
                    if (visited[child] == 0) {
                        q.add(child);
                        visited[child] = visited[node] + 1;
                    }
                }
            }
            answer.add(count);
        }
        return answer;
    }
}
