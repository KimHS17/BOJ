import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;

    private static void dfs(int node) {
        visited[node] = true;
        for(int i : list[node]) {
            if(!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                dfs(i);
            }
            else if(check[node] == check[i]) {
                IsEven = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for(int t = 0; t < k; t++) {
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            list = new ArrayList[v + 1];
            visited = new boolean[v + 1];
            check = new int[v + 1];
            IsEven = true;

            for(int i = 1; i <= v; i++) {
                list[i] = new ArrayList<Integer>();
            }

            for(int i = 0; i < e; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                list[start].add(end);
                list[end].add(start);
            }

            for(int i = 1; i <= v; i++) {
                if(IsEven)
                    dfs(i);
                else
                    break;
            }
            
            if(IsEven)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}