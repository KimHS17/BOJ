import java.io.*;
import java.util.*;

public class Main {
    static class TrieNode {
        TreeMap<String, TrieNode> map = new TreeMap<>();
    }

    static TrieNode root = new TrieNode();

    public static void insert(StringTokenizer st) {
        TrieNode curTn = root;
        int k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++) {
            String str = st.nextToken();
            if(!curTn.map.containsKey(str))
                curTn.map.put(str, new TrieNode());
            curTn = curTn.map.get(str);
        }
    }

    public static void print(TrieNode curTn, int depth) {
        for(String str : curTn.map.keySet()){ 
            StringBuilder sb = new StringBuilder("-".repeat(depth)).append(str);
            System.out.println(sb.toString());
            print(curTn.map.get(str), depth + 2);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            insert(st);
        }

        print(root, 0);
    }
}
