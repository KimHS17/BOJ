import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;
    
        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int[] parent;

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if(aParent < bParent)
            parent[bParent] = aParent;
        else
        parent[aParent] = bParent;
    }

    public static int find(int i) {
        if(parent[i] == i)
            return i;
        
        return find(parent[i]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, cost));
        }

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int totalCost = 0, maxCost = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(find(node.start) != find(node.end)) {
                totalCost += node.cost;
                union(node.start, node.end);
                maxCost = Math.max(maxCost, node.cost);
            }
        }

        System.out.println(totalCost - maxCost);
    }
}
