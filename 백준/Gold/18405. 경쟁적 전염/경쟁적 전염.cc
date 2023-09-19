#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, k, s, x, y, num = 0, num2 = 0, sec = 0;
queue<pair<int, int>> q;

void bfs(vector<vector<int>> &b) {
    vector<vector<int>> ck(n, vector<int>(n, 0));
    int d[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    for(int i = 0; i < num; i++) {
        int py = q.front().first;
        int px = q.front().second;

        q.pop();
        for(int j = 0; j < 4; j++) {
            int ny = py + d[j][0];
            int nx = px + d[j][1];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n || (!ck[ny][nx] && b[ny][nx]) || (ck[ny][nx] && b[ny][nx] <= b[py][px]))
                continue;
            
            ck[ny][nx] = 1;
            b[ny][nx] = b[py][px];
            q.push({ny, nx});
            num2++;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> k;
    vector<vector<int>> b(n, vector<int>(n));

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> b[i][j];
            if(b[i][j] != 0) {
                q.push({i, j});
                num++;
            }
        }
    }
    cin >> s >> x >> y;
    
    while(!q.empty()) {
        if(sec == s)
            break;
        sec++;
        bfs(b);
        num = num2;
        num2 = 0;
    }

    cout << b[x - 1][y - 1];
}