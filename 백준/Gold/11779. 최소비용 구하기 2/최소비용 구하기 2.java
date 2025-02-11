import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int e;
    int c;

    public Node(int e, int c) {
        this.e = e;
        this.c = c;
    }

    @Override
    public int compareTo(Node o) {
        return this.c - o.c;
    }
}

public class Main {
    static int n, m;
    static List<Node>[] edge;
    static int[] cost;
    static List<Integer>[] city;

    public static void dikstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];

        pq.add(new Node(start, 0));
        cost[start] = 0;
        
        while(!pq.isEmpty()) {
            int now = pq.poll().e;

            if(visited[now])
                continue;

            visited[now] = true;

            for(Node n: edge[now]) {
                if(cost[n.e] > cost[now] + n.c) {
                    city[n.e] = new ArrayList<>(city[now]);
                    city[n.e].add(now);
                    cost[n.e] = cost[now] + n.c;
                    pq.add(new Node(n.e, cost[n.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edge = new ArrayList[n + 1];
        city = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            edge[i] = new ArrayList<>();
            city[i] = new ArrayList<>();
        }
        cost = new int[n + 1];
        
        StringTokenizer st;
        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edge[s].add(new Node(e, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(cost, Integer.MAX_VALUE);
        dikstra(start);

        System.out.println(cost[end]);
        System.out.println(city[end].size() + 1);
        for(int c: city[end]) {
            System.out.print(c + " ");
        }
        System.out.print(end);
    }
}
