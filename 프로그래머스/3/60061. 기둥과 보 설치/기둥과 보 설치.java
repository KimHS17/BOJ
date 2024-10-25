import java.util.*;

class Solution {
    static int[][] wall;
    
    public boolean install(int n, int kind, int y, int x) {
        if(kind == 0) { // 기둥 설치
            if(y == 0)
                return true;
            if(y > 0 && wall[y - 1][x] % 2 == 1)
                return true;
            if(wall[y][x] >= 2)
                return true;
            if(x > 0 && wall[y][x - 1] >= 2)
                return true;
        } else { // 보 설치
            if(wall[y - 1][x] % 2 == 1 || wall[y - 1][x + 1] % 2 == 1)
                return true;
            if((x > 0 && wall[y][x - 1] >= 2) && (x < n - 1 && wall[y][x + 1] >= 2))
                return true;
        }
        
        return false;
    }
    
    public boolean remove(int n, int kind, int y, int x) {
        if(kind == 0) { // 기둥 삭제
            if(y < n - 1 && wall[y + 1][x] % 2 == 1 && !install(n, 0, y + 1, x)) // 위쪽 기둥
                return false;
            if(x > 0 && wall[y + 1][x - 1] >= 2 && !install(n, 1, y + 1, x - 1)) // 왼쪽 보
                return false;
            if(x < n && wall[y + 1][x] >= 2 && !install(n, 1, y + 1, x)) // 오른쪽 보
                return false;
        } else { // 보 삭제
            if(y < n && wall[y][x] % 2 == 1 && !install(n, 0, y, x)) // 왼쪽 기둥
                return false;
            if(y < n && wall[y][x + 1] % 2 == 1 && !install(n, 0, y, x + 1)) // 오른쪽 기둥
                return false;
            if(x > 0 && wall[y][x - 1] >= 2 && !install(n, 1, y, x - 1)) // 왼쪽 보
                return false;
            if(x < n - 1 && wall[y][x + 1] >= 2 && !install(n, 1, y, x + 1)) // 오른쪽 보
                return false;
        }
        
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        wall = new int[n + 1][n + 1];
        int[][] answer;
        int cnt = 0, id = 0;
        
        for(int[] bf: build_frame) {
            if(bf[3] == 0) { // 삭제
                wall[bf[1]][bf[0]] -= (bf[2] + 1);
                cnt--;
                if(!remove(n, bf[2], bf[1], bf[0])) {
                    wall[bf[1]][bf[0]] += (bf[2] + 1);
                    cnt++;
                }
            } else { // 설치
                if(install(n, bf[2], bf[1], bf[0])) {
                    wall[bf[1]][bf[0]] += bf[2] + 1;
                    cnt++;
                }
            }
        }

        answer = new int[cnt][3];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(wall[i][j] > 0) {
                    if(wall[i][j] == 3) {
                        answer[id][0] = j;
                        answer[id][1] = i;
                        answer[id++][2] = 0;
                        
                        answer[id][0] = j;
                        answer[id][1] = i;
                        answer[id++][2] = 1;
                    } else {
                        answer[id][0] = j;
                        answer[id][1] = i;
                        answer[id++][2] = wall[i][j] - 1;
                    }
                }
            }
        }
        
        Arrays.sort(answer, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        return answer;
    }
}