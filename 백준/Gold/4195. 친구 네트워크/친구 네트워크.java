import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Integer> map;
    static int idxF;
    static int[] parent;
    static int[] size;

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if(aParent == bParent)
            return;
        
        if(size[aParent] < size[bParent]) {
            parent[aParent] = bParent;
            size[bParent] += size[aParent];
        } else {
            parent[bParent] = aParent;
            size[aParent] += size[bParent];
        }
    }

    public static int find(int idx) {
        if(parent[idx] != idx)
            parent[idx] = find(parent[idx]);
        
        return parent[idx];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++) {
            int f = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            idxF = 0;
            parent = new int[f * 2];
            size = new int[f * 2];
            for(int i = 0; i < f * 2; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            for(int i = 0; i < f; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                int idxF1, idxF2;

                if(!map.containsKey(f1))
                    map.put(f1, idxF++);
                idxF1 = map.get(f1);
                if(!map.containsKey(f2))
                    map.put(f2, idxF++);
                idxF2 = map.get(f2);

                union(idxF1, idxF2);
                System.out.println(size[find(idxF1)]);
            }
        }
    }
}
