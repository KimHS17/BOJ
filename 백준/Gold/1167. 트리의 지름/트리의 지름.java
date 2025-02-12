import java.io.*;
import java.util.*;

class Node {
    int idx;
    int dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}

public class Main {
    static int n, v, max = 0;
    static List<Node>[] tree;
    static boolean[] visited;

    static void dfs(int s, int d) {
        for(Node e: tree[s]) {
            if(!visited[e.idx]) {
                visited[e.idx] = true;
                dfs(e.idx, d + e.dist);
                visited[e.idx] = false;
            }
        }

        if(d > max) {
            max = d;
            v = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            while(true) {
                int n2 = Integer.parseInt(st.nextToken());

                if(n2 == -1)
                    break;

                int d = Integer.parseInt(st.nextToken());
                tree[n1].add(new Node(n2, d));
            }
        }
        visited = new boolean[n + 1];
        
        visited[1] = true;
        dfs(1, 0);
        visited[1] = false;
        
        max = 0;
        visited[v] = true;
        dfs(v, 0);

        System.out.println(max);
    }
}