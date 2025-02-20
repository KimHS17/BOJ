import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] inorder, postorder, inIdx;
	static StringBuilder sb = new StringBuilder();

    static void tree(int inS, int inE, int postS, int postE) {
        if(inS > inE || postS > postE) {
            return;
        }

        int root = postorder[postE];
        int idx = inIdx[root];
        sb.append(root + " ");

        int len = idx - inS;
        tree(inS, idx - 1, postS, postS + len - 1);
        tree(idx + 1, inE, postS + len, postE - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inorder = new int[n + 1];
        postorder = new int[n + 1];
        inIdx = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inIdx[inorder[i]] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        tree(1, n, 1, n);

        System.out.println(sb);
    }
}
