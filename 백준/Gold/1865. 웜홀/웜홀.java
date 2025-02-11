import java.io.*;
import java.util.*;

class Node {
    public int e;
    public int t;

    public Node(int e, int t) {
        this.e = e;
        this.t = t;
    }
}

public class Main {
    static int n, m, w;
    static List<Node>[] edge;
    static int[] time;
    
    public static boolean bf(int start) {
        boolean update = false;
        Arrays.fill(time, Integer.MAX_VALUE);
        time[start] = 0;

        for(int i = 0; i < n - 1; i++) {
            update = false;

            for(int j = 1; j <= n; j++) {
                for(Node e: edge[j]) {
                    if(time[j] != Integer.MAX_VALUE && time[e.e] > time[j] + e.t) {
                        time[e.e] = time[j] + e.t;
                        update = true;
                    }
                }
            }

            if(!update)
                break;
        }

        if(update) {
            for(int i = 1; i <= n; i++) {
                for(Node e: edge[i]) {
                    if(time[i] != Integer.MAX_VALUE && time[e.e] > time[i] + e.t) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int T = 0; T < tc; T++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            edge = new ArrayList[n + 1];
            time = new int[n + 1];
            boolean ans = false;
            
            for(int i = 0; i <= n; i++) {
                edge[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                edge[s].add(new Node(e, t));
                edge[e].add(new Node(s, t));
            }

            for(int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                edge[s].add(new Node(e, -t));
            }

            for(int i = 1; i <= n; i++) {
                if(bf(i)) {
                    ans = true;
                    break;
                }
            }

            if(ans) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
