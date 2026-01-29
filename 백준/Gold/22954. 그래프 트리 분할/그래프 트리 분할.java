import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int to;
        int idx;
    
        public Node(int to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }

    static class Component {
        ArrayList<Integer> nodes = new ArrayList<>();
        ArrayList<Integer> edges = new ArrayList<>();
    }
    
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    
    static void dfs(int now, ArrayList<Integer> nodes, ArrayList<Integer> edges) {
        visited[now] = true;
        nodes.add(now);

        for(Node next: graph[now]) {
            if(!visited[next.to]) {
                edges.add(next.idx);
                dfs(next.to, nodes, edges);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        if(n <= 2) {
            System.out.println("-1");
            return;
        }

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, i + 1));
            graph[v].add(new Node(u, i + 1));
        }

        ArrayList<Component> components = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                Component comp = new Component();
                
                dfs(i, comp.nodes, comp.edges);
                components.add(comp);
            }
        }

        int count = components.size();
        if(count > 2) {
            System.out.println("-1");
        } else if(count == 2) {
            Component compA = components.get(0);
            Component compB = components.get(1);
            int aSize = compA.nodes.size();
            int bSize = compB.nodes.size();

            if(aSize == bSize) {
                System.out.println("-1");
            } else {
                System.out.println(aSize + " " + bSize);
                
                for(int node: compA.nodes) {
                    System.out.print(node + " ");
                }
                System.out.println();
                for(int edge: compA.edges) {
                    System.out.print(edge + " ");
                }
                System.out.println();
                
                for(int node: compB.nodes) {
                    System.out.print(node + " ");
                }
                System.out.println();
                for(int edge: compB.edges) {
                    System.out.print(edge + " ");
                }
                System.out.println();
            }
        } else {
            Component comp = components.get(0);
            int size = comp.nodes.size() - 1;
            int edgeCnt = comp.edges.size() - 1;

            System.out.println(size + " 1");
            
            for(int i = 0; i < size; i++) {
                System.out.print(comp.nodes.get(i) + " ");
            }
            System.out.println();
            for(int i = 0; i < edgeCnt; i++) {
                System.out.print(comp.edges.get(i) + " ");
            }
            System.out.println();

            System.out.println(comp.nodes.get(size));
            System.out.println();
        }
    }
}