import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> per = new ArrayList<>();

    static void permutation(boolean[] visited, int[] res, int depth, int r) {
        if(depth == r) {
            per.add(res.clone());
            return;
        }

        int d = depth;
        
        if(depth >= 3) {
            d++;
        }

        for(int i = 1; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res[d] = i;
                permutation(visited, res, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    static int baseball(int n, int[][] hit, int[] p) {
        int score = 0, idx = 0;
        
        for(int i = 0; i < n; i++) {
            boolean[] base = new boolean[3];
            int out = 0;

            while(out < 3) {
                int now = hit[i][p[idx]];
                
                switch (now) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        for(int j = 2; j >= 0; j--) {
                            if(base[j]) {
                                if(j == 2) {
                                    score++;
                                }

                                base[j] = false;
                                if(j < 2) {
                                    base[j + 1] = true;
                                }
                            }
                        }
                        base[0] = true;
                        break;
                    case 2:
                        for(int j = 2; j >= 0; j--) {
                            if(base[j]) {
                                if(j >= 1) {
                                    score++;
                                }

                                base[j] = false;
                                if(j < 1) {
                                    base[j + 2] = true;
                                }
                            }
                        }
                        base[1] = true;
                        break;
                    case 3:
                        for(int j = 2; j >= 0; j--) {
                            if(base[j]) {
                                score++;
                                base[j] = false;
                            }
                        }
                        base[2] = true;
                        break;
                    case 4:
                        for(int j = 2; j >= 0; j--) {
                            if(base[j]) {
                                score++;
                                base[j] = false;
                            }
                        }
                        score++;
                        break;
                }
                
                idx = (idx + 1) % 9;
            }
        }

        return score;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] hit = new int[n][9];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                hit[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[] visited = new boolean[9];
        int[] res = new int[9];
        res[3] = 0;
        int max = 0;

        permutation(visited, res, 0, 8);

        for(int[] p: per) {
            max = Math.max(max, baseball(n, hit, p));
        }

        System.out.println(max);
    }
}
